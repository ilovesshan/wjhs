package com.ilovesshan.wjhs.beans.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class RecycleGoodsAndTypeVo {
    private String id;
    private String name;
    private String describe;
    private String status;
    private List<RecycleGoodsVo> recycleGoods;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
