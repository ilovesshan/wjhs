package com.ilovesshan.wjhs.beans.converter;

import com.ilovesshan.wjhs.beans.dto.RecycleGoodsTypeCreateDto;
import com.ilovesshan.wjhs.beans.dto.RecycleGoodsTypeUpdateDto;
import com.ilovesshan.wjhs.beans.pojo.RecycleGoodsType;
import com.ilovesshan.wjhs.beans.vo.RecycleGoodsTypeVo;
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
public interface RecycleGoodsTypeConverter {

    RecycleGoodsTypeVo po2vo(RecycleGoodsType recycleGoodsType);

    RecycleGoodsType dto2po(RecycleGoodsTypeCreateDto recycleGoodsTypeCreateDto);

    RecycleGoodsType dto2po(RecycleGoodsTypeUpdateDto recycleGoodsTypeUpdateDto);
}
