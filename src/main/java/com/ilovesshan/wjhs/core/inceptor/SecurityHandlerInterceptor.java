package com.ilovesshan.wjhs.core.inceptor;

import com.ilovesshan.wjhs.beans.pojo.User;
import com.ilovesshan.wjhs.beans.pojo.WxUser;
import com.ilovesshan.wjhs.contants.Constants;
import com.ilovesshan.wjhs.core.base.UserCache;
import com.ilovesshan.wjhs.core.config.RedisCache;
import com.ilovesshan.wjhs.core.exception.AuthorizationException;
import com.ilovesshan.wjhs.utils.JwtUtil;
import com.ilovesshan.wjhs.utils.R;
import com.ilovesshan.wjhs.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/3
 * @description:
 */
public class SecurityHandlerInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisCache redisCache;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = request.getHeader(Constants.HEADER_KEY);
        // 不存在登录凭证(token或者openId)
        if (!StringUtils.hasText(authorization)) {
            ResponseUtil.write(response, R.builder().code(R.ERROR_CODE_AUTHORIZATION).message(R.ERROR_INSUFFICIENT_AUTHENTICATION).build());
            return false;
        }

        // 处理小程序端的业务逻辑
        if (authorization.contains(Constants.HEADER_WX_VALUE_PREFIX)) {
            String openId = authorization.replace(Constants.HEADER_WX_VALUE_PREFIX, "");
            WxUser finedUser = redisCache.get(Constants.REDIS_WX__USER_PREFIX + openId, WxUser.class);
            if (Objects.isNull(finedUser)) {
                throw new AuthorizationException(R.ERROR_INSUFFICIENT_AUTHENTICATION);
            }
            // 将当前用户ID和用户名称存在UserCache中 方便在任意地方获取
            UserCache.set("userId", finedUser.getId());
            UserCache.set("username", finedUser.getNickName());
            UserCache.set("userType", "1");
            return true;
        } else {
            String userId = JwtUtil.getUserId(authorization.replace(Constants.HEADER_VALUE_PREFIX, ""));
            // 去redis中查询用户信息
            User finedUser = redisCache.get(Constants.REDIS_USER_PREFIX + userId, User.class);
            if (Objects.isNull(finedUser)) {
                throw new AuthorizationException(R.ERROR_INSUFFICIENT_AUTHENTICATION);
            }
            // 将当前用户ID和用户名称存在UserCache中 方便在任意地方获取
            UserCache.set("userId", userId);
            UserCache.set("username", finedUser.getUsername());
            UserCache.set("userType", finedUser.getUserType());
            return true;
        }
    }
}
