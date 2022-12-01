package com.ilovesshan.wjhs.beans.converter;

import com.ilovesshan.wjhs.beans.dto.WxUserUpdateDto;
import com.ilovesshan.wjhs.beans.pojo.WxUser;
import com.ilovesshan.wjhs.beans.vo.WxUserAuthVo;
import com.ilovesshan.wjhs.beans.vo.WxUserVo;
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
public interface WxUserConverter {

    WxUser dto2po(WxUserUpdateDto wxUserUpdateDto);

    WxUserVo po2vo(WxUser WxUser);

    WxUserAuthVo po2AuthVo(WxUser WxUser);
}
