package com.ilovesshan.wjhs.beans.converter;

import com.ilovesshan.wjhs.beans.dto.RecycleOrderDetailCreateDto;
import com.ilovesshan.wjhs.beans.pojo.RecycleOrderDetail;
import com.ilovesshan.wjhs.beans.vo.RecycleOrderDetailVo;
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
public interface RecycleOrderDetailConverter {

    RecycleOrderDetailVo po2vo(RecycleOrderDetail recycleOrderDetail);

    RecycleOrderDetail dto2po(RecycleOrderDetailCreateDto recycleOrderDetailCreateDto);
}
