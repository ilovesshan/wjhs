package com.ilovesshan.wjhs.beans.converter;

import com.ilovesshan.wjhs.beans.dto.AccountRecordCreateDto;
import com.ilovesshan.wjhs.beans.pojo.AccountRecord;
import com.ilovesshan.wjhs.beans.vo.AccountRecordVo;
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
public interface AccountRecordConverter {
    AccountRecordVo po2vo(AccountRecord accountRecord);

    AccountRecord dto2po(AccountRecordCreateDto accountRecordCreateDto);
}
