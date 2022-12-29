package com.ilovesshan.wjhs.beans.converter;

import com.ilovesshan.wjhs.beans.dto.UserFeedbackDto;
import com.ilovesshan.wjhs.beans.pojo.UserFeedback;
import com.ilovesshan.wjhs.beans.vo.UserFeedbackVo;
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
public interface UserFeedbackConverter {
    UserFeedbackVo po2vo(UserFeedback userFeedback);

    UserFeedback dto2po(UserFeedbackDto userFeedbackDto);
}
