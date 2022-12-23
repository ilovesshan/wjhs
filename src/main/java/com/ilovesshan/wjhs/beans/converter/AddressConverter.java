package com.ilovesshan.wjhs.beans.converter;

import com.ilovesshan.wjhs.beans.dto.AddressCreateDto;
import com.ilovesshan.wjhs.beans.dto.AddressUpdateDto;
import com.ilovesshan.wjhs.beans.pojo.Address;
import com.ilovesshan.wjhs.beans.vo.AddressVo;
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
public interface AddressConverter {

    AddressVo po2vo(Address address);

    Address dto2po(AddressCreateDto addressCreateDto);

    Address dto2po(AddressUpdateDto addressUpdateDto);
}
