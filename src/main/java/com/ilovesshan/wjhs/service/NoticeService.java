package com.ilovesshan.wjhs.service;

import com.ilovesshan.wjhs.beans.dto.NoticeCreateDto;
import com.ilovesshan.wjhs.beans.dto.NoticeUpdateDto;
import com.ilovesshan.wjhs.beans.pojo.Notice;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/4
 * @description:
 */
public interface NoticeService {
    List<Notice> selectByType(String type);

    boolean create(NoticeCreateDto noticeCreateDto);

    boolean update(NoticeUpdateDto noticeUpdateDto);

    boolean deleteById(String id);
}
