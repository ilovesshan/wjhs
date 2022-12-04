-- 更新轮播图表中 type字段备注说明
alter table swiper modify `type` char(3)  NOT NULL COMMENT '类型(31:小程序端、32:App端)';

-- 更新公告栏表中 type字段备注说明
alter table notice modify `type` char(3)  NOT NULL COMMENT '类型(31:小程序端、32:App端)';