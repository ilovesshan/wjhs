package com.ilovesshan.wjhs.beans.converter;

import com.ilovesshan.wjhs.beans.pojo.WxIntegralRecord;
import com.ilovesshan.wjhs.beans.vo.WxIntegralRecordVo;
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
public interface WxIntegralRecordConverter {
    WxIntegralRecordVo po2vo(WxIntegralRecord wxIntegralRecord);
}
