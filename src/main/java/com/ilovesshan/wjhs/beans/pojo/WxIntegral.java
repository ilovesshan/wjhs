package com.ilovesshan.wjhs.beans.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxIntegral {
    private String id;
    private String userId;
    private double integral;
    private String isDelete;
    private Date createTime;
    private Date updateTime;
}
