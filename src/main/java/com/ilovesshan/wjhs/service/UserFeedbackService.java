package com.ilovesshan.wjhs.service;

import com.ilovesshan.wjhs.beans.dto.UserFeedbackDto;
import com.ilovesshan.wjhs.beans.pojo.UserFeedback;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/29
 * @description:
 */
public interface UserFeedbackService {
    UserFeedback selectById(String id);

    List<UserFeedback> selectListByUserId(String userId);

    List<UserFeedback> selectListByType(String type);

    boolean create(UserFeedbackDto userFeedbackDto);

    boolean updateIsSolveDone(String id);

    boolean deleteById(String id);
}
