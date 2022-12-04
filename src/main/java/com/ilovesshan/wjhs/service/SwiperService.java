package com.ilovesshan.wjhs.service;

import com.ilovesshan.wjhs.beans.dto.SwiperCreateDto;
import com.ilovesshan.wjhs.beans.dto.SwiperUpdateDto;
import com.ilovesshan.wjhs.beans.pojo.Swiper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/4
 * @description:
 */
public interface SwiperService {
    boolean create(SwiperCreateDto swiperCreateDto);

    List<Swiper> selectByType(String type);

    boolean update(SwiperUpdateDto swiperUpdateDto);

    boolean delete(String id);
}
