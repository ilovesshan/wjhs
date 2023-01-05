-- 新增用户积分流水表
drop table if exists `wx_integral_record`;
create table `wx_integral_record`(
    `id` varchar(32) not null  comment '主键id',
    `user_id` varchar(32) not null comment '用户id',
    `order_id` varchar(32) not null comment '订单id',
    `pay_status` char(3) not null comment '出入账状态(35:收入, 36:支出)',
    `trading_integral` double(7,2) not null comment '交易积分',
    `is_delete` char(3) default 15 not null comment '是否删除(14:已删除、15:未删除)',
    `create_time` datetime(0) default current_timestamp comment '创建时间',
    `update_time` datetime(0) default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`id`)
) engine=innodb default charset=utf8mb4 collate=utf8mb4_0900_ai_ci comment= '用户积分流水表';


