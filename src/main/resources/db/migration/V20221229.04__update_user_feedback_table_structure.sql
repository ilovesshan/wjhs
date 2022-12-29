-- 更新账户流水表结构  account_record
alter table `user_feedback` change  `feedback_title` `feedback_title` varchar(32) not null comment '反馈标题';
