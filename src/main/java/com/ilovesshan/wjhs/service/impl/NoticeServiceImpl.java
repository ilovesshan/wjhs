package com.ilovesshan.wjhs.service.impl;

import com.ilovesshan.wjhs.beans.converter.NoticeConverter;
import com.ilovesshan.wjhs.beans.dto.NoticeCreateDto;
import com.ilovesshan.wjhs.beans.dto.NoticeUpdateDto;
import com.ilovesshan.wjhs.beans.pojo.Notice;
import com.ilovesshan.wjhs.core.exception.CustomException;
import com.ilovesshan.wjhs.mapper.NoticeMapper;
import com.ilovesshan.wjhs.service.NoticeService;
import com.ilovesshan.wjhs.utils.R;
import com.ilovesshan.wjhs.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/4
 * @description:
 */

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Autowired
    private NoticeConverter noticeConverter;


    @Override
    public List<Notice> selectByType(String type) {
        return noticeMapper.selectByType(type);
    }

    @Override
    public boolean create(NoticeCreateDto noticeCreateDto) {
        Notice notice = noticeConverter.dto2po(noticeCreateDto);
        notice.setId(UuidUtil.generator());
        return noticeMapper.insert(notice) > 0;
    }


    @Override
    public boolean update(NoticeUpdateDto noticeUpdateDto) {
        Notice finedNotice = noticeMapper.selectById(noticeUpdateDto.getId());
        if (Objects.isNull(finedNotice)) {
            throw new CustomException(R.ERROR_RESOURCES_NOTFOUND);
        }
        return noticeMapper.update(noticeConverter.dto2po(noticeUpdateDto)) > 0;
    }


    @Override
    public boolean deleteById(String id) {
        Notice finedNotice = noticeMapper.selectById(id);
        if (Objects.isNull(finedNotice)) {
            throw new CustomException(R.ERROR_RESOURCES_NOTFOUND);
        }
        return noticeMapper.deleteById(id) > 0;
    }
}
