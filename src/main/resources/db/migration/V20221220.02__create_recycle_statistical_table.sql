-- 新增 回收统计表
DROP TABLE IF EXISTS `recycle_statistical`;
CREATE TABLE `recycle_statistical`(
    `id` VARCHAR(32) NOT NULL  COMMENT '主键id',
    `order_id` VARCHAR(32) NOT NULL COMMENT '订单id',
    `submit_user_id` VARCHAR(32) NOT NULL COMMENT '下单用户id',
    `receive_user_id` VARCHAR(32) NOT NULL COMMENT '接单用户id',
    `weight` double(7,2)  NOT NULL COMMENT '商品重量(KG)',
    `order_type` CHAR(3) NOT NULL COMMENT '订单类别(10:用户到骑手, 11:骑手到回收中心用户)',
    `is_delete` CHAR(3) DEFAULT 15 NOT NULL COMMENT '是否删除(14:已删除、15:未删除)',
    `create_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT= '回收统计表';
