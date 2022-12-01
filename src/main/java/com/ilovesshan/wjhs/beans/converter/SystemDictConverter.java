package com.ilovesshan.wjhs.beans.converter;

import com.ilovesshan.wjhs.beans.pojo.SystemDict;
import com.ilovesshan.wjhs.beans.vo.SystemDictVo;
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
public interface SystemDictConverter {

    SystemDictVo po2vo(SystemDict systemDict);

}
