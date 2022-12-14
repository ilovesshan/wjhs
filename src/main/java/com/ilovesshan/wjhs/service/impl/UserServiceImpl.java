
package com.ilovesshan.wjhs.service.impl;

import com.ilovesshan.wjhs.beans.dto.UserUpdatePasswordDto;
import com.ilovesshan.wjhs.beans.pojo.User;
import com.ilovesshan.wjhs.core.exception.CustomException;
import com.ilovesshan.wjhs.mapper.UserMapper;
import com.ilovesshan.wjhs.service.UserService;
import com.ilovesshan.wjhs.utils.AesUtils;
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
 * @date: 2022/11/30
 * @description:
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }

    @Override
    public User findUserById(String id) {
        User findUser = userMapper.findUserById(id);
        if (Objects.isNull(findUser)) {
            throw new CustomException(R.ERROR_USER_NOT_FOUND);
        }
        return findUser;
    }

    @Override
    public boolean update(User user) {
        findUserById(user.getId());
        return userMapper.update(user) > 0;
    }


    @Override
    public String create(User user) {
        // TODO 骑手、回收中心注册账号之后，系统默认充值(骑手200，回收中心5000元)用于支出费用，同时平台每个月也会扣取部分费用(骑手)。
        String userId = UuidUtil.generator();
        // 自动生成一个key
        user.setId(userId);
        // 对密码加密 存数据库
        user.setPassword(AesUtils.encrypt(user.getPassword()));
        userMapper.insert(user);
        return userId;
    }

    @Override
    public boolean deleteById(String id) {
        findUserById(id);
        return userMapper.deleteById(id) > 0;
    }

    @Override
    public List<User> selectListByType(String type) {
        return userMapper.selectListByType(type);
    }

    @Override
    public int updatePassword(UserUpdatePasswordDto userUpdatePasswordDto) {
        return userMapper.updatePassword(userUpdatePasswordDto.getId(), userUpdatePasswordDto.getNewPassword());
    }
}
