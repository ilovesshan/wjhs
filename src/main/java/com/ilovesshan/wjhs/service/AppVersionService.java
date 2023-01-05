package com.ilovesshan.wjhs.service;

import com.ilovesshan.wjhs.beans.pojo.AppVersionUpgrade;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2023/1/3
 * @description:
 */
public interface AppVersionService {

    boolean upload(AppVersionUpgrade appVersionUpgrade, MultipartFile file);

    boolean save(AppVersionUpgrade appVersionUpgrade);

    AppVersionUpgrade selectById(String id);

    AppVersionUpgrade selectMaxVersionApk();

    List<AppVersionUpgrade> selectApkList();

    boolean deleteApkById(String id);

    boolean checkApkNeedUpdate(String currentVersionName, String maxVersionName);
}
