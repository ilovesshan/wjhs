package com.ilovesshan.wjhs.core.config;

import com.ilovesshan.wjhs.contants.Constants;
import com.ilovesshan.wjhs.core.inceptor.SecurityHandlerInterceptor;
import com.ilovesshan.wjhs.utils.SystemUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    // 注入拦截器
    @Bean
    public SecurityHandlerInterceptor securityHandlerInterceptor() {
        return new SecurityHandlerInterceptor();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 区分当前运行的系统环境
        registry.addResourceHandler("/preview/**").addResourceLocations("file:" + (SystemUtil.isWindows() ? Constants.ATTACHMENT_UPLOAD_WINDOWS_DEST : Constants.ATTACHMENT_UPLOAD_LINUX_DEST));
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(securityHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/auth", "/wx/auth", "/preview/**")
                .excludePathPatterns("/doc.html", "/webjars/**", "/img.icons/**", "/swagger-resources/**", "/v2/api-docs");
    }
}
