
package com.ilovesshan.wjhs.beans.vo;

import lombok.Data;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/27
 * @description:
 */

@Data
public class UserIntegralVo {
    private String userId;
    private String username;
    private String avatarUrl;
    private double integral;
    private List<WxIntegralRecordVo> integralRecords;
}
