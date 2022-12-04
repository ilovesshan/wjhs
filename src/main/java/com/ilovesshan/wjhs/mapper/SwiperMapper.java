package com.ilovesshan.wjhs.mapper;

import com.ilovesshan.wjhs.beans.pojo.Swiper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/11/30
 * @description:
 */

@Mapper
public interface SwiperMapper {

    Swiper selectById(String id);

    int insert(Swiper dto2po);

    List<Swiper> selectByType(String type);

    int update(Swiper dto2po);

    int delete(String id);
}
