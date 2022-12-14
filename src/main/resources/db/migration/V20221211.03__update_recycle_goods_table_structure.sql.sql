-- 回收商品表  recycle_goods 添加上下架状态字段(status)
alter table `recycle_goods` add `status` char(3) default 33  COMMENT '商品状态(33:上架、34:下架)' after `is_delete`;