package com.ilovesshan.wjhs.mapper;

import com.ilovesshan.wjhs.beans.pojo.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/11/30
 * @description:
 */

@Mapper
public interface NoticeMapper {
    List<Notice> selectByType(String type);

    int insert(Notice notice);

    Notice selectById(String id);

    int update(Notice notice);

    int deleteById(String id);
}
