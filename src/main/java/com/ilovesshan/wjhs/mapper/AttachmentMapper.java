package com.ilovesshan.wjhs.mapper;

import com.ilovesshan.wjhs.beans.pojo.Attachment;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/11/30
 * @description:
 */

@Mapper
public interface AttachmentMapper {

    int insert(Attachment attachment);

    Attachment selectById(String id);

    int deleteById(String id);
}
