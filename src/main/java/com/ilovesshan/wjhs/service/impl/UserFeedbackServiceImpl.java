package com.ilovesshan.wjhs.service.impl;

import com.ilovesshan.wjhs.beans.converter.UserFeedbackConverter;
import com.ilovesshan.wjhs.beans.dto.UserFeedbackDto;
import com.ilovesshan.wjhs.beans.pojo.UserFeedback;
import com.ilovesshan.wjhs.core.base.UserCache;
import com.ilovesshan.wjhs.core.exception.CustomException;
import com.ilovesshan.wjhs.mapper.UserFeedbackMapper;
import com.ilovesshan.wjhs.service.UserFeedbackService;
import com.ilovesshan.wjhs.utils.R;
import com.ilovesshan.wjhs.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/29
 * @description:
 */

@Service
public class UserFeedbackServiceImpl implements UserFeedbackService {

    @Autowired
    private UserFeedbackConverter userFeedbackConverter;

    @Autowired
    private UserFeedbackMapper userFeedbackMapper;

    @Override
    public UserFeedback selectById(String id) {
        UserFeedback userFeedback = userFeedbackMapper.selectById(id);
        if (Objects.isNull(userFeedback)) {
            throw new CustomException(R.ERROR_RESOURCES_NOTFOUND);
        }
        return userFeedback;
    }

    @Override
    public List<UserFeedback> selectListByUserId(String userId) {
        return userFeedbackMapper.selectListByUserId(userId);
    }

    @Override
    public List<UserFeedback> selectListByType(String type) {
        return userFeedbackMapper.selectListByType(type);
    }

    @Override
    public boolean create(UserFeedbackDto userFeedbackDto) {
        UserFeedback userFeedback = userFeedbackConverter.dto2po(userFeedbackDto);
        userFeedback.setId(UuidUtil.generator());
        userFeedback.setUserId(UserCache.get("userId"));
        userFeedback.setUserType(UserCache.get("userType"));
        return userFeedbackMapper.create(userFeedback) > 0;
    }

    @Override
    public boolean updateIsSolveDone(String id) {
        selectById(id);
        return userFeedbackMapper.updateIsSolveDone(id) > 0;
    }

    @Override
    public boolean deleteById(String id) {
        selectById(id);
        return userFeedbackMapper.deleteById(id) > 0;
    }
}
