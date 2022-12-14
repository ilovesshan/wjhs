package com.ilovesshan.wjhs.beans.converter;

import com.ilovesshan.wjhs.beans.dto.UserCreateDto;
import com.ilovesshan.wjhs.beans.dto.UserUpdateDto;
import com.ilovesshan.wjhs.beans.pojo.User;
import com.ilovesshan.wjhs.beans.vo.UserVo;
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
public interface UserConverter {

    UserVo po2vo(User user);

    User dto2po(UserUpdateDto userUpdateDto);

    User dto2po(UserCreateDto userCreateDto);
}
