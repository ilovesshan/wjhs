
package com.ilovesshan.wjhs.service.impl;

import com.ilovesshan.wjhs.beans.dto.UserUpdatePasswordDto;
import com.ilovesshan.wjhs.beans.pojo.Account;
import com.ilovesshan.wjhs.beans.pojo.AccountRecord;
import com.ilovesshan.wjhs.beans.pojo.User;
import com.ilovesshan.wjhs.core.exception.CustomException;
import com.ilovesshan.wjhs.core.exception.TransactionalException;
import com.ilovesshan.wjhs.mapper.UserMapper;
import com.ilovesshan.wjhs.service.AccountRecordService;
import com.ilovesshan.wjhs.service.AccountService;
import com.ilovesshan.wjhs.service.UserService;
import com.ilovesshan.wjhs.utils.AesUtils;
import com.ilovesshan.wjhs.utils.R;
import com.ilovesshan.wjhs.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private AccountService accountService;

    @Autowired
    private AccountRecordService accountRecordService;

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
    @Transactional(rollbackFor = TransactionalException.class)
    public String create(User user) {
        // 自动生成一个key(用户ID)
        String userId = UuidUtil.generator();

        // 骑手、回收中心注册账号之后，系统默认充值(骑手1000，回收中心5000元)用于支出费用
        double balance = Objects.equals("2", user.getUserType()) ? 1000.00 : 5000.00;
        Account account = new Account(UuidUtil.generator(), user.getUserType(), userId, balance, "15", null, null);
        accountService.insert(account);

        // admin账户需要扣除费用
        accountService.updateMoneyWithDecrement("369BCFE480454D22A07A8644F6DF0349", balance);


        // 新增账户流水记录
        AccountRecord accountRecord = new AccountRecord(
                UuidUtil.generator(), "0", user.getUserType(), "369BCFE480454D22A07A8644F6DF0349", userId,
                "36", null, balance, "28", "用户注册，系统首次充值", "15", null, null
        );
        accountRecordService.insert(accountRecord);

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
