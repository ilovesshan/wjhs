-- 清空账户表和账户流水表中的信息
delete from `wjhs`.`account`;
delete from `wjhs`.`account_record`;

-- 账户表和账户流水表新增is_delete字段
alter table `wjhs`.`account` add `is_delete` char(3) not null comment '是否删除(14:已删除、15:未删除)' after `balance`;
alter table `wjhs`.`account_record` add `is_delete` char(3) not null comment '是否删除(14:已删除、15:未删除)' after `trading_note`;


-- 删除用户信息(除了admin之外)
delete from `wjhs`.`user` where id != '369bcfe480454d22a07a8644f6df0349';


-- 更改金额范围
alter table `wjhs`.`account` change `balance` `balance` double(10,2) not null comment '账户余额';


-- 默认给admin账户充值1000000(壹佰万)元
insert into
  `wjhs`.`account` (`id`, `user_type`, `user_id`, `balance`, `is_delete`)
values
  ('7695208063144363b2a6be095908e177', 0, '369bcfe480454d22a07a8644f6df0349', 1000000, "15");