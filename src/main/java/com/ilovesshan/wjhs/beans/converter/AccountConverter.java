package com.ilovesshan.wjhs.beans.converter;

import com.ilovesshan.wjhs.beans.pojo.Account;
import com.ilovesshan.wjhs.beans.vo.AccountVo;
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
public interface AccountConverter {

    AccountVo po2vo(Account account);
}
