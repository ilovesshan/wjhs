-- status 更改备注
alter table `recycle_order` change `status`  `status` char(3) not null comment '订单类别(4:待接单, 5:待上门, 6:待结算, 7:已完结, 8:已超时, 9:取消订单)';

-- receive_user_id 默认为空
alter table `recycle_order` change `receive_user_id`   `receive_user_id` varchar(32) default null comment '接单用户id';

-- total_weight 订单总重量
alter table `recycle_order` add `total_weight` double(7,2) not null comment '订单总重量' after `trading_money`;

-- address_id 上门地址id
alter table `recycle_order` add `address_id` varchar(32) not null comment '上门地址id' after `total_weight`;

-- appointment_begin_time datetime(0) 预约开始时间
alter table `recycle_order` add `appointment_begin_time` datetime(0) not null comment ' 预约开始时间' after `address_id`;

-- appointment_end_time  datetime(0) 预约结束时间
alter table `recycle_order` add `appointment_end_time` datetime(0) not null comment '预约结束时间' after `appointment_begin_time`;

-- note_attachmentids 备注图片id列表
alter table `recycle_order` add `note_attachmentids` varchar(255) default null comment '备注图片id列表' after `note`;
