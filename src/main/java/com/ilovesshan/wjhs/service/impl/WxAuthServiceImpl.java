package com.ilovesshan.wjhs.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ilovesshan.wjhs.beans.pojo.WxUser;
import com.ilovesshan.wjhs.contants.Constants;
import com.ilovesshan.wjhs.core.config.RedisCache;
import com.ilovesshan.wjhs.core.exception.AuthorizationException;
import com.ilovesshan.wjhs.service.WxAuthService;
import com.ilovesshan.wjhs.service.WxUserService;
import com.ilovesshan.wjhs.utils.R;
import com.ilovesshan.wjhs.utils.UuidUtil;
import com.ilovesshan.wjhs.utils.WxChatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/11/30
 * @description:
 */


@Service
public class WxAuthServiceImpl implements WxAuthService {

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private WxUserService wxUserService;

    @Override
    public WxUser auth(String code) {
        // 获取sessionKey和openId
        JSONObject SessionKeyOpenId = WxChatUtil.getSessionKeyAndOpenId(code);
        String openid = SessionKeyOpenId.getString("openid");
        String sessionKey = SessionKeyOpenId.getString("session_key");

        // 如果sessionKey或者openId无效
        if (!StringUtils.hasText(openid) || !StringUtils.hasText(sessionKey)) {
            throw new AuthorizationException(R.ERROR_WX_VALID_CODE);
        }

        // 根据openid去数据库查询、不存在就是新用户 存在就更新登录时间
        WxUser selectedUser = wxUserService.findUserByOpenId(openid);
        if (Objects.isNull(selectedUser)) {
            WxUser wxUser = new WxUser();
            wxUser.setId(UuidUtil.generator());
            wxUser.setOpenId(openid);
            wxUser.setSessionKey(sessionKey);
            wxUser.setSkey(UuidUtil.generator());
            wxUser.setLastVisitTime(new Date());
            wxUserService.insert(wxUser);
            // 将用户登录信息存在redis中
            redisCache.set(Constants.REDIS_WX__USER_PREFIX + wxUser.getOpenId(), wxUser, Constants.JWT_EXPIRATION);
            return wxUser;
        } else {
            // 更新最后登录时间
            selectedUser.setLastVisitTime(new Date());
            wxUserService.update(selectedUser);
            // 将用户登录信息存在redis中
            redisCache.set(Constants.REDIS_WX__USER_PREFIX + selectedUser.getOpenId(), selectedUser, Constants.JWT_EXPIRATION);
            return selectedUser;
        }
    }
}
