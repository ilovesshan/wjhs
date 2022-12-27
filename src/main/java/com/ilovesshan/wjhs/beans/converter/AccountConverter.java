package com.ilovesshan.wjhs.beans.converter;

import com.ilovesshan.wjhs.beans.pojo.Account;
import com.ilovesshan.wjhs.beans.pojo.UserAccount;
import com.ilovesshan.wjhs.beans.vo.AccountVo;
import com.ilovesshan.wjhs.beans.vo.UserAccountVo;
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

    UserAccountVo po2vo(UserAccount userAccount);
}
