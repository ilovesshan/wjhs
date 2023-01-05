package com.ilovesshan.wjhs.controller;

import com.ilovesshan.wjhs.beans.converter.AppVersionUpgradeConverter;
import com.ilovesshan.wjhs.beans.dto.AppVersionUpgradeDto;
import com.ilovesshan.wjhs.beans.pojo.AppVersionUpgrade;
import com.ilovesshan.wjhs.beans.vo.AppVersionUpdateVo;
import com.ilovesshan.wjhs.beans.vo.AppVersionUpgradeVo;
import com.ilovesshan.wjhs.contants.Constants;
import com.ilovesshan.wjhs.core.annotation.Log;
import com.ilovesshan.wjhs.service.AppVersionService;
import com.ilovesshan.wjhs.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/15
 * @description:
 */

@Api(tags = "App版本管理模块")
@RestController
@RequestMapping("/appVersions")
public class AppVersionController {

    @Autowired
    private AppVersionService appVersionService;

    @Autowired
    private AppVersionUpgradeConverter appVersionUpgradeConverter;

    @ApiOperation("apk上传")
    @PostMapping
    @Log(businessModule = "App版本管理模块", businessType = "POST", businessDescribe = "apk上传")
    public R uploadApp(AppVersionUpgradeDto appVersionUpgradeDto, @RequestParam("file") MultipartFile file) {
        boolean isSuccess = appVersionService.upload(appVersionUpgradeConverter.dto2po(appVersionUpgradeDto), file);
        return isSuccess ? R.success(R.SUCCESS_APK_UPLOAD) : R.success(R.ERROR_APK_UPLOAD);
    }


    @ApiOperation("查询最新apk")
    @GetMapping("/new")
    public R selectNewAppVersion(@RequestParam String versionName) {
        AppVersionUpgrade maxVersionApk = appVersionService.selectMaxVersionApk();

        AppVersionUpdateVo appVersionUpdateVo = new AppVersionUpdateVo();
        appVersionUpdateVo.setVersionCode(Integer.parseInt(maxVersionApk.getVersionCode()));
        appVersionUpdateVo.setVersionName(maxVersionApk.getVersionName());
        appVersionUpdateVo.setHasUpdate(appVersionService.checkApkNeedUpdate(versionName, maxVersionApk.getVersionName()));
        appVersionUpdateVo.setForce(Objects.equals(maxVersionApk.getUpdateStatus(), "41"));
        appVersionUpdateVo.setIgnorable(false);
        appVersionUpdateVo.setDownloadUrl(maxVersionApk.getDownloadUrl());
        appVersionUpdateVo.setUpdateContent(maxVersionApk.getModifyContent());
        appVersionUpdateVo.setApkSize((int) (maxVersionApk.getApkSize() / 1024));
        appVersionUpdateVo.setApkMd5(Constants.APK_MD5_KEY);

        return R.success(R.SUCCESS_MESSAGE_SELECT, appVersionUpdateVo);
    }


    @ApiOperation("查询apk列表")
    @GetMapping
    public R selectApkList() {
        List<AppVersionUpgrade> apks = appVersionService.selectApkList();
        List<AppVersionUpgradeVo> apkVos = apks.stream().map(appVersionUpgradeConverter::po2vo).collect(Collectors.toList());
        return R.success(R.SUCCESS_MESSAGE_SELECT, apkVos);
    }

    @Log(businessModule = "App版本管理模块", businessType = "DELETE", businessDescribe = "删除apk")
    @ApiOperation("删除apk")
    @DeleteMapping("/{id}")
    public R deleteApkById(@PathVariable String id) {
        boolean isSuccess = appVersionService.deleteApkById(id);
        return isSuccess ? R.success(R.SUCCESS_MESSAGE_DELETE) : R.success(R.ERROR_MESSAGE_DELETE);
    }
}
