package com.ilovesshan.wjhs.beans.converter;

import com.ilovesshan.wjhs.beans.dto.SwiperCreateDto;
import com.ilovesshan.wjhs.beans.dto.SwiperUpdateDto;
import com.ilovesshan.wjhs.beans.pojo.Swiper;
import com.ilovesshan.wjhs.beans.vo.SwiperVo;
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
public interface SwiperConverter {

    SwiperVo po2vo(Swiper swiper);

    Swiper dto2po(SwiperCreateDto swiperCreateDto);

    Swiper dto2po(SwiperUpdateDto swiperUpdateDto);
}
