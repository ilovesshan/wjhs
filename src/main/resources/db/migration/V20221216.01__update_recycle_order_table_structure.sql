-- total_weight 订单积分
alter table `recycle_order` add `total_integral` double(7,2) not null comment '订单积分' after `total_weight`;
