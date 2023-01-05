package com.ilovesshan.wjhs.mapper;

import com.ilovesshan.wjhs.beans.pojo.AppVersionUpgrade;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2023/1/3
 * @description:
 */

@Mapper
public interface AppVersionMapper {

    int insert(AppVersionUpgrade appVersionUpgrade);

    AppVersionUpgrade selectMaxVersionApk();

    AppVersionUpgrade selectById(String id);

    List<AppVersionUpgrade> selectApkList();

    int deleteApkById(String id);

}
