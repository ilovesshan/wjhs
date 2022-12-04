package com.ilovesshan.wjhs.beans.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class OperationLog {

  private String id;
  private String businessModule;
  private String businessType;
  private String businessDescribe;
  private String apiMethod;
  private String requestMethod;
  private String userId;
  private String userName;
  private String userType;
  private String url;
  private String ip;
  private String status;
  private String isDelete;
  private String errorMessage;
  private Date operationTime;
}
