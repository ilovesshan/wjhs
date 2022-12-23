-- 更新账户流水表结构  account_record
alter table `account_record` add `pay_status` CHAR(3) NOT NULL COMMENT '出入账状态(35:收入, 36:支出)' after user_id_to;
