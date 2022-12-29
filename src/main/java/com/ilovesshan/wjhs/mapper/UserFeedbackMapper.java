package com.ilovesshan.wjhs.mapper;

import com.ilovesshan.wjhs.beans.pojo.UserFeedback;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/20
 * @description:
 */

@Mapper
public interface UserFeedbackMapper {
    List<UserFeedback> selectListByUserId(String userId);

    List<UserFeedback> selectListByType(@Param("userType") String userType, @Param("isSolve") String isSolve);

    int create(UserFeedback userFeedback);

    int updateIsSolveDone(String id);

    int deleteById(String id);

    UserFeedback selectById(String id);
}
