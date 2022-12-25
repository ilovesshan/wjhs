package com.ilovesshan.wjhs.beans.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class AccountVo {
    private String id;
    private String userType;
    private String userId;
    private double balance;
    private String isDelete;
    private List<AccountRecordVo> accountRecords;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
