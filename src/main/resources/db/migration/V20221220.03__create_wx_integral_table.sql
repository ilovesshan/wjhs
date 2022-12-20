-- 新增 用户积分表
DROP TABLE IF EXISTS `wx_integral`;
CREATE TABLE `wx_integral`(
    `id` VARCHAR(32) NOT NULL  COMMENT '主键id',
    `order_id` VARCHAR(32) NOT NULL COMMENT '订单id',
    `pay_status` CHAR(3) NOT NULL COMMENT '出入账状态(35:收入, 36:支出)',
    `is_delete` CHAR(3) DEFAULT 15 NOT NULL COMMENT '是否删除(14:已删除、15:未删除)',
    `trading_money` double(7,2) NOT NULL COMMENT '交易金额',
    `create_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT= '用户积分表';
