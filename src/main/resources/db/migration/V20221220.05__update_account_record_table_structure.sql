-- 将之前数据默认余额设置成 收入
update `wjhs`.`account_record` set `pay_status` = '36' limit 2;

-- 添加字段 注释
alter table `wjhs`.`account_record` change `trading_type`  `trading_type` CHAR(3) NOT NULL COMMENT '交易方式(24:微信、25:支付宝、 26:现金、 27:平台交易)';