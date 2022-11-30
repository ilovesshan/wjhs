package com.ilovesshan.wjhs.core.filter;

import com.ilovesshan.wjhs.beans.pojo.AuthUser;
import com.ilovesshan.wjhs.contants.Constants;
import com.ilovesshan.wjhs.core.base.UserCache;
import com.ilovesshan.wjhs.core.config.RedisCache;
import com.ilovesshan.wjhs.core.exception.AuthorizationException;
import com.ilovesshan.wjhs.utils.JwtUtil;
import com.ilovesshan.wjhs.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/11/30
 * @description:
 */

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private RedisCache redisCache;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader(Constants.HEADER_KEY);
        // TODO: 是否对小程序端用户进行鉴权处理??
        // 不存在token或者是非法token
        if (!StringUtils.hasText(authorization) || !StringUtils.hasText(Constants.HEADER_VALUE_PREFIX)) {
            filterChain.doFilter(request, response);
            return;
        }

        String userId = JwtUtil.getUserId(authorization.replace(Constants.HEADER_VALUE_PREFIX, ""));

        // 去redis中查询用户信息
        AuthUser authUser = redisCache.get(Constants.REDIS_USER_PREFIX + userId, AuthUser.class);

        if (Objects.isNull(authUser)) {
            throw new AuthorizationException(R.ERROR_INSUFFICIENT_AUTHENTICATION);
        }

        // 将用户信息保存在SecurityContext中
        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(authUser, null, Collections.emptyList());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        // 将当前用户ID和用户名称存在UserCache中 方便在任意地方获取
        UserCache.set("userId", userId);
        UserCache.set("username", authUser.getUsername());

        // 放行 执行下一个过滤器
        filterChain.doFilter(request, response);
    }
}
