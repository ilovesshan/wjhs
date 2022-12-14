-- 回收商品表  recycle_goods 添加上下架状态字段(status)
alter table `recycle_goods` change `recycle_center__price` `recycle_center_price` double(7,2) NOT NULL COMMENT '回收中心用户价格';