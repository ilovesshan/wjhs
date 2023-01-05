package com.ilovesshan.wjhs.service.impl;

import com.ilovesshan.wjhs.beans.pojo.AppVersionUpgrade;
import com.ilovesshan.wjhs.contants.Constants;
import com.ilovesshan.wjhs.core.exception.CustomException;
import com.ilovesshan.wjhs.mapper.AppVersionMapper;
import com.ilovesshan.wjhs.service.AppVersionService;
import com.ilovesshan.wjhs.utils.R;
import com.ilovesshan.wjhs.utils.SystemUtil;
import com.ilovesshan.wjhs.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2023/1/3
 * @description:
 */

@Service
public class AppVersionServiceImpl implements AppVersionService {

    @Autowired
    private AppVersionMapper appVersionMapper;

    @Override
    public boolean upload(AppVersionUpgrade appVersionUpgrade, MultipartFile file) {
        // 校验apk版本信息
        AppVersionUpgrade maxVersionUpgrade = selectMaxVersionApk();
        checkApkVersion(appVersionUpgrade, maxVersionUpgrade);

        // 区分当前运行的系统环境
        File fileDir = new File(SystemUtil.isWindows() ? Constants.APP_UPLOAD_WINDOWS_DEST : Constants.APP_UPLOAD_LINUX_DEST);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }

        // 获取文件扩展名
        String ext = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        if (!Objects.equals(".apk", ext)) {
            throw new CustomException(R.ERROR_FILE_TYPE);
        }

        // 文件名称
        String fileName = UuidUtil.generator() + ext;

        try {
            file.transferTo(new File(fileDir + File.separator + fileName));
        } catch (IOException e) {
            e.printStackTrace();
            throw new CustomException(R.ERROR_ATTACHMENT_UPLOAD);
        }

        // 将AppVersionUpgrade对象 新增到数据库
        appVersionUpgrade.setId(UuidUtil.generator());
        appVersionUpgrade.setDownloadUrl(Constants.APP_DOWNLOAD_PREFIX + fileName);
        appVersionUpgrade.setApkSize(file.getSize());
        return save(appVersionUpgrade);
    }

    private void checkApkVersion(AppVersionUpgrade currentAppVersion, AppVersionUpgrade maxVersionUpgrade) {
        if (!Objects.isNull(maxVersionUpgrade)) {
            if (currentAppVersion.getMajor() < maxVersionUpgrade.getMajor()) {
                throw new CustomException("上传失败，当前apk最新版本是：" + maxVersionUpgrade.getVersionName() + "，请检查主版本号");
            }

            if (currentAppVersion.getMajor() == maxVersionUpgrade.getMajor()) {
                if (currentAppVersion.getMinor() < maxVersionUpgrade.getMinor()) {
                    throw new CustomException("上传失败，当前apk最新版本是：" + maxVersionUpgrade.getVersionName() + "，请检查次版本号");
                }
                if (currentAppVersion.getMinor() == maxVersionUpgrade.getMinor()) {
                    if (currentAppVersion.getPatch() <= maxVersionUpgrade.getPatch()) {
                        throw new CustomException("上传失败，当前apk最新版本是：" + maxVersionUpgrade.getVersionName() + "，请检查修订号");
                    }
                }
            }
        }
    }

    @Override
    public boolean save(AppVersionUpgrade appVersionUpgrade) {
        return appVersionMapper.insert(appVersionUpgrade) > 0;
    }

    @Override
    public AppVersionUpgrade selectById(String id) {
        AppVersionUpgrade appVersionUpgrade = appVersionMapper.selectById(id);
        if (Objects.isNull(appVersionUpgrade)) {
            throw new CustomException(R.ERROR_RESOURCES_NOTFOUND);
        }
        return appVersionUpgrade;
    }

    @Override
    public AppVersionUpgrade selectMaxVersionApk() {
        return appVersionMapper.selectMaxVersionApk();
    }

    @Override
    public List<AppVersionUpgrade> selectApkList() {
        return appVersionMapper.selectApkList();
    }

    @Override
    public boolean deleteApkById(String id) {
        AppVersionUpgrade currentVersionUpgrade = selectById(id);
        AppVersionUpgrade maxVersionUpgrade = selectMaxVersionApk();

        if (
                currentVersionUpgrade.getMajor() == maxVersionUpgrade.getMajor()
                        && currentVersionUpgrade.getMinor() == maxVersionUpgrade.getMinor()
                        && currentVersionUpgrade.getPatch() == maxVersionUpgrade.getPatch()
        ) {
            throw new CustomException("最新版本的Apk不允许删除");
        }
        return appVersionMapper.deleteApkById(id) > 0;
    }

    @Override
    public boolean checkApkNeedUpdate(String currentVersionName, String maxVersionName) {
        List<Integer> currentVersions = new ArrayList<>();
        List<Integer> maxVersions = new ArrayList<>();

        for (String version : currentVersionName.split("\\.")) {
            currentVersions.add(Integer.parseInt(version));
        }
        for (String version : maxVersionName.split("\\.")) {
            maxVersions.add(Integer.parseInt(version));
        }

        if (currentVersions.get(0) < maxVersions.get(0)) {
            return true;
        }

        if (Objects.equals(currentVersions.get(0), maxVersions.get(0))) {
            if (currentVersions.get(1) < maxVersions.get(1)) {
                return true;
            }
            if (Objects.equals(currentVersions.get(1), maxVersions.get(1))) {
                if (currentVersions.get(2) < maxVersions.get(2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
