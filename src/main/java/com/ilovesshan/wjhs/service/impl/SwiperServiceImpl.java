package com.ilovesshan.wjhs.service.impl;

import com.ilovesshan.wjhs.beans.converter.SwiperConverter;
import com.ilovesshan.wjhs.beans.dto.SwiperCreateDto;
import com.ilovesshan.wjhs.beans.dto.SwiperSelectDto;
import com.ilovesshan.wjhs.beans.dto.SwiperUpdateDto;
import com.ilovesshan.wjhs.beans.pojo.Swiper;
import com.ilovesshan.wjhs.core.exception.CustomException;
import com.ilovesshan.wjhs.mapper.SwiperMapper;
import com.ilovesshan.wjhs.service.SwiperService;
import com.ilovesshan.wjhs.utils.R;
import com.ilovesshan.wjhs.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/4
 * @description:
 */

@Service
public class SwiperServiceImpl implements SwiperService {

    @Autowired
    private SwiperMapper swiperMapper;

    @Autowired
    private SwiperConverter swiperConverter;

    @Override
    public boolean create(SwiperCreateDto swiperCreateDto) {
        Swiper swiper = swiperConverter.dto2po(swiperCreateDto);
        swiper.setId(UuidUtil.generator());
        return swiperMapper.insert(swiper) > 0;
    }

    @Override
    public List<Swiper> selectByConditions(SwiperSelectDto swiperSelectDto) {
        return swiperMapper.selectByConditions(swiperSelectDto);
    }

    @Override
    public boolean update(SwiperUpdateDto swiperUpdateDto) {
        Swiper finedSwiper = swiperMapper.selectById(swiperUpdateDto.getId());
        if (Objects.isNull(finedSwiper)) {
            throw new CustomException(R.ERROR_RESOURCES_NOTFOUND);
        }
        return swiperMapper.update(swiperConverter.dto2po(swiperUpdateDto)) > 0;
    }

    @Override
    public boolean deleteById(String id) {
        Swiper finedSwiper = swiperMapper.selectById(id);
        if (Objects.isNull(finedSwiper)) {
            throw new CustomException(R.ERROR_RESOURCES_NOTFOUND);
        }
        return swiperMapper.delete(id) > 0;
    }

    @Override
    public Swiper selectById(String id) {
        return swiperMapper.selectById(id);
    }
}
