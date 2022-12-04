package com.ilovesshan.wjhs.beans.converter;

import com.ilovesshan.wjhs.beans.dto.NoticeCreateDto;
import com.ilovesshan.wjhs.beans.dto.NoticeUpdateDto;
import com.ilovesshan.wjhs.beans.pojo.Notice;
import com.ilovesshan.wjhs.beans.vo.NoticeVo;
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
public interface NoticeConverter {

    NoticeVo po2vo(Notice swiper);

    Notice dto2po(NoticeCreateDto noticeCreateDto);

    Notice dto2po(NoticeUpdateDto noticeUpdateDto);
}
