package com.ilovesshan.wjhs.mapper;

import com.ilovesshan.wjhs.beans.pojo.WxUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/11/30
 * @description:
 */

@Mapper
public interface WxUserMapper {
    WxUser findUserByOpenId(String openid);

    int insert(WxUser wxUser);

    int update(WxUser wxUser);

    WxUser findUserById(String id);

    List<WxUser> selectList();

    int deleteById(String id);
}
