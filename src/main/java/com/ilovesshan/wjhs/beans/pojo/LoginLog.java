package com.ilovesshan.wjhs.beans.pojo;


import lombok.Data;

import java.util.Date;

@Data
public class LoginLog {
  private String id;
  private String userType;
  private String userId;
  private String token;
  private String userName;
  private String loginIp;
  private Date loginTime;
  private String loginLocation;
  private String isDelete;
  private String browser;
  private String systemOs;

}
