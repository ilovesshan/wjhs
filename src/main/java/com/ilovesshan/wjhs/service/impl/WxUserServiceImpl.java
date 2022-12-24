package com.ilovesshan.wjhs.service.impl;

import com.ilovesshan.wjhs.beans.pojo.Account;
import com.ilovesshan.wjhs.beans.pojo.WxUser;
import com.ilovesshan.wjhs.core.exception.CustomException;
import com.ilovesshan.wjhs.core.exception.TransactionalException;
import com.ilovesshan.wjhs.mapper.WxUserMapper;
import com.ilovesshan.wjhs.service.AccountService;
import com.ilovesshan.wjhs.service.WxUserService;
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
public class WxUserServiceImpl implements WxUserService {

    @Autowired
    private AccountService accountService;

    @Autowired
    private WxUserMapper userMapper;

    @Override
    public WxUser findUserByOpenId(String openid) {
        return userMapper.findUserByOpenId(openid);
    }

    @Override
    @Transactional(rollbackFor = TransactionalException.class)
    public boolean insert(WxUser wxUser) {
        // 给当前用户初始化一个账户
        Account account = new Account(UuidUtil.generator(), "1", wxUser.getId(), 0, "15", null, null);
        accountService.insert(account);

        return userMapper.insert(wxUser) > 0;
    }

    @Override
    public boolean update(WxUser wxUser) {
        findUserById(wxUser.getId());
        return userMapper.update(wxUser) > 0;
    }

    @Override
    public WxUser findUserById(String id) {
        WxUser findUser = userMapper.findUserById(id);
        if (Objects.isNull(findUser)) {
            throw new CustomException(R.ERROR_USER_NOT_FOUND);
        }
        return findUser;
    }

    @Override
    public List<WxUser> selectList() {
        return userMapper.selectList();
    }

    @Override
    public boolean deleteById(String id) {
        findUserById(id);
        return userMapper.deleteById(id) > 0;
    }
}
