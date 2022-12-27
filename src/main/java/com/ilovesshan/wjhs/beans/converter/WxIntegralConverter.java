package com.ilovesshan.wjhs.beans.converter;

import com.ilovesshan.wjhs.beans.pojo.UserIntegral;
import com.ilovesshan.wjhs.beans.pojo.WxIntegral;
import com.ilovesshan.wjhs.beans.vo.UserIntegralVo;
import com.ilovesshan.wjhs.beans.vo.WxIntegralVo;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/11/30
 * @description:
 */

@Component
@Mapper(componentModel = "spring")
public interface WxIntegralConverter {
    WxIntegralVo po2vo(WxIntegral wxIntegral);

    UserIntegralVo po2vo(UserIntegral userIntegral);
}
