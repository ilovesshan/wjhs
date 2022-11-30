package com.ilovesshan.wjhs.beans.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class SystemDictVo {
    private String id;
    private long dictCode;
    private String dictName;
    private String dictDescribe;
    private String createBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
