-- total_weight 订单积分
alter table `recycle_order` add `send_to_recycle_center` varchar(1) default null comment '是否已经送往回收中心' after `status`;
