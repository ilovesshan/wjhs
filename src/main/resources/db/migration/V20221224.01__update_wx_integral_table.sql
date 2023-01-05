-- 更新 用户积分表结构
alter table `wjhs`.`wx_integral` add `user_id` varchar(32) not null comment '用户id' after `id`;
alter table `wjhs`.`wx_integral` add `integral` double(7,2) not null comment '用户积分' after `user_id`;
alter table `wjhs`.`wx_integral` drop column `order_id`;
alter table `wjhs`.`wx_integral` drop column `pay_status`;
alter table `wjhs`.`wx_integral` drop column `trading_money`;
