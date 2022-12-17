package com.ilovesshan.wjhs.beans.converter;

import com.ilovesshan.wjhs.beans.dto.RecycleOrderCreateDto;
import com.ilovesshan.wjhs.beans.dto.RecycleOrderUpdateDto;
import com.ilovesshan.wjhs.beans.pojo.RecycleOrder;
import com.ilovesshan.wjhs.beans.vo.RecycleOrderVo;
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
public interface RecycleOrderConverter {

    RecycleOrderVo po2vo(RecycleOrder recycleOrder);

    RecycleOrder dto2po(RecycleOrderUpdateDto recycleOrderUpdateDto);

    RecycleOrder dto2po(RecycleOrderCreateDto recycleOrderCreateDto);
}
