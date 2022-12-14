package com.ilovesshan.wjhs.beans.converter;

import com.ilovesshan.wjhs.beans.dto.RecycleGoodsCreateDto;
import com.ilovesshan.wjhs.beans.dto.RecycleGoodsUpdateDto;
import com.ilovesshan.wjhs.beans.pojo.RecycleGoods;
import com.ilovesshan.wjhs.beans.pojo.RecycleGoodsAndType;
import com.ilovesshan.wjhs.beans.vo.RecycleGoodsAndTypeVo;
import com.ilovesshan.wjhs.beans.vo.RecycleGoodsVo;
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
public interface RecycleGoodsConverter {
    RecycleGoodsVo po2vo(RecycleGoods recycleGoods);

    RecycleGoodsAndTypeVo po2vo(RecycleGoodsAndType RecycleGoodsAndType);

    RecycleGoods dto2po(RecycleGoodsCreateDto recycleGoodsCreateDto);

    RecycleGoods dto2po(RecycleGoodsUpdateDto recycleGoodsUpdateDto);
}
