-- 更新账户流水表结构  account_record
alter table `user_feedback` add  `user_type` CHAR(3) NOT NULL COMMENT '用户类型(0:平台用户、1:微信用户、 2:骑手用户、 3:回收中心用户)' after user_id;
