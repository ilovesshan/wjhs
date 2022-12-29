package com.ilovesshan.wjhs.utils;

import com.ilovesshan.wjhs.beans.converter.AttachmentConverter;
import com.ilovesshan.wjhs.beans.converter.UserFeedbackConverter;
import com.ilovesshan.wjhs.beans.pojo.UserFeedback;
import com.ilovesshan.wjhs.beans.vo.UserFeedbackVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/16
 * @description:
 */


@Component
public class UserFeedbackVoParseUtil {
    @Autowired
    private UserFeedbackConverter userFeedbackConverter;

    @Autowired
    private  AttachmentConverter attachmentConverter;

    public List<UserFeedbackVo> parseList(List<UserFeedback> userFeedbacks) {
        List<UserFeedbackVo> userFeedbackVos = userFeedbacks.stream().map(userFeedback -> {
            UserFeedbackVo userFeedbackVo = userFeedbackConverter.po2vo(userFeedback);
            userFeedbackVo.setAttachment(attachmentConverter.po2vo(userFeedback.getAttachment()));
            return userFeedbackVo;
        }).collect(Collectors.toList());
        return userFeedbackVos;
    }

}
