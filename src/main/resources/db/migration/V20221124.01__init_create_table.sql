-- DROP DATABASE IF EXISTS wjhs;
-- CREATE DATABASE wjhs;
--
-- USE  wjhs;

-- 备注：
-- 			1、省市区街道sql语句, 从文件中自行导入
-- 			2、CODE状态码参考：系统字典表(system_dict)



-- ----------------------------
-- 创建 用户操作日志表
-- ----------------------------
DROP TABLE IF EXISTS `operation_log`;
CREATE TABLE `operation_log` (
  `id` VARCHAR(32) NOT NULL COMMENT '主键id',
  `business_module` VARCHAR(20) NOT NULL COMMENT '业务模块',
  `business_type` VARCHAR(20) NOT NULL COMMENT '业务类型',
  `business_describe` VARCHAR(30) DEFAULT NULL COMMENT '描述信息',
  `api_method` VARCHAR(10)  NOT NULL COMMENT 'api方法',
  `request_method` VARCHAR(10)  NOT NULL  COMMENT '请求方式',
  `user_id` VARCHAR(32)  NOT NULL  COMMENT '操作人员id',
  `user_name` VARCHAR(10)  NOT NULL  COMMENT '操作人员姓名',
  `user_type` CHAR(3) NOT NULL COMMENT '用户类型(0:平台用户、1:微信用户、 2:骑手用户、 3:回收中心用户)',
  `url` VARCHAR(30) NOT NULL COMMENT '请求url',
  `ip` VARCHAR(32) DEFAULT NULL COMMENT '源IP地址',
  `status` CHAR(3) NOT NULL COMMENT '操作状态(22:成功、23:失败)',
  `is_delete`  CHAR(3) DEFAULT 15 NOT NULL COMMENT '是否删除(14:已删除、15:未删除)',
  `error_message` VARCHAR(255) DEFAULT NULL COMMENT '错误消息',
  `operation_time` DATETIME(0) DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='操作日志';



-- ----------------------------
-- 创建 用户登录日志表
-- ----------------------------
DROP TABLE IF EXISTS `login_log`;
CREATE TABLE `login_log`(
  `id` VARCHAR(32) NOT NULL  COMMENT '主键id',
	`user_type` CHAR(3) NOT NULL COMMENT '用户类型(0:平台用户、1:微信用户、 2:骑手用户、 3:回收中心用户)',
  `user_id` VARCHAR(32) NOT NULL COMMENT '用户id',
  `token` VARCHAR(100) NOT NULL COMMENT '登录凭证',
  `user_name` VARCHAR(10) NOT NULL COMMENT '用户名称',
  `login_ip` VARCHAR(128) DEFAULT NULL COMMENT '登录IP',
  `login_time` DATETIME(0) DEFAULT NULL COMMENT '登录时间',
  `login_localtion` VARCHAR(50) DEFAULT NULL COMMENT '用户登录地址',
  `is_delete` CHAR(3) DEFAULT 15 NOT NULL COMMENT '是否删除(14:已删除、15:未删除)',
  `browser` VARCHAR(50)  NULL DEFAULT '' COMMENT '浏览器类型',
	`system_os` VARCHAR(50)  NULL DEFAULT '' COMMENT '操作系统',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT= '用户登录表';




-- ----------------------------
-- 创建 附件表
-- ----------------------------

DROP TABLE IF EXISTS `attachment`;
CREATE TABLE `attachment` (
  `id` VARCHAR(32) NOT NULL  COMMENT '主键id',
  `url` VARCHAR(100) NOT NULL COMMENT '访问地址',
  `create_by_user_id` VARCHAR(32) NOT NULL COMMENT '创建人id',
  `create_by_user_name` VARCHAR(10) NOT NULL COMMENT '创建人name',
  `create_by_user_type` CHAR(3) NOT NULL COMMENT '用户类型(0:平台用户、1:微信用户、 2:骑手用户、 3:回收中心用户)',
  `is_delete`  CHAR(3) DEFAULT 15 NOT NULL COMMENT '是否删除(14:已删除、15:未删除)',
  `create_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='系统附件表';



-- ----------------------------
-- 创建 系统字典表
-- ----------------------------
DROP TABLE IF EXISTS `system_dict`;
CREATE TABLE `system_dict` (
  `id` VARCHAR(32) NOT NULL  COMMENT '主键id',
  `dict_code` int(3) NOT NULL COMMENT '数据类型编码',
  `dict_name` VARCHAR(30) NOT NULL COMMENT '数据类型名称',
  `dict_describe` VARCHAR(100) DEFAULT NULL COMMENT '描述',
  `sort` int(5) DEFAULT '1' COMMENT '排序',
  `create_by` VARCHAR(50) NOT NULL COMMENT '创建人',
  `create_by_user_id` VARCHAR(32) NOT NULL COMMENT '创建人id',
  `update_by` VARCHAR(50) DEFAULT NULL COMMENT '修改人',
  `update_by_user_id` VARCHAR(32) DEFAULT NULL COMMENT '修改人id',
  `is_delete`  CHAR(3) DEFAULT 15  NOT NULL COMMENT '是否删除(14:已删除、15:未删除)',
  `create_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_dict_code` (`dict_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统字典类型表';



-- ----------------------------
-- 创建 骑手/回收中心用户/平台用户表
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` VARCHAR(32) NOT NULL  COMMENT '主键id',
	`username` VARCHAR(32) NOT NULL COMMENT '用户名称',
	`password` VARCHAR(255) NOT NULL COMMENT '用户密码',
  `user_type` CHAR(3) NOT NULL COMMENT '用户类型(0:平台用户、1:微信用户、 2:骑手用户、 3:回收中心用户)',
	`gender` CHAR(3) DEFAULT NULL COMMENT '性别(20:男、21:女)',
	`attachment_id` VARCHAR(32) DEFAULT NULL COMMENT '附件id(头像)',
  `nick_name` VARCHAR(255) DEFAULT NULL COMMENT '昵称',
  `phone` VARCHAR(11) NOT NULL COMMENT '手机号',
  `is_delete`  CHAR(3) DEFAULT 15 NOT NULL COMMENT '是否删除(14:已删除、15:未删除)',
  `last_visit_time` DATETIME(0) DEFAULT NULL COMMENT '最后登录时间',
  `create_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='骑手/回收中心用户/平台用户表';



-- ----------------------------
-- 创建 小程序用户信息表
-- ----------------------------
DROP TABLE IF EXISTS `wx_user`;
CREATE TABLE `wx_user`  (
  `id` VARCHAR(32) NOT NULL  COMMENT '主键id',
  `open_id` VARCHAR(100) NOT NULL COMMENT 'open_id',
  `skey` VARCHAR(100) NOT NULL COMMENT 'skey',
  `session_key` VARCHAR(100) NOT NULL COMMENT 'session_key',
	`gender` CHAR(3) DEFAULT NULL COMMENT '性别(20:男、21:女)',
	`avatar_url` VARCHAR(255) DEFAULT NULL COMMENT '头像',
  `city` VARCHAR(255) DEFAULT NULL COMMENT '市',
  `province` VARCHAR(255) DEFAULT NULL COMMENT '省',
  `country` VARCHAR(255) DEFAULT NULL COMMENT '国',
  `nick_name` VARCHAR(255) DEFAULT NULL COMMENT '昵称',
  `is_delete`  CHAR(3) DEFAULT 15 NOT NULL COMMENT '是否删除(14:已删除、15:未删除)',
  `last_visit_time` DATETIME(0) DEFAULT NULL COMMENT '最后登录时间',
  `create_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='小程序用户信息表';



-- ----------------------------
-- 创建 角色表
-- ----------------------------
DROP TABLE IF EXISTS `role`;
create table `role`(
  `id` CHAR(3) COMMENT '主键id',
  `code` VARCHAR(10) NOT NULL COMMENT '角色编码',
  `name` VARCHAR(20) NOT NULL COMMENT '角色名称',
  `create_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';



-- ----------------------------
-- 创建 用户角色关联表
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
create table `user_role`(
  `id` VARCHAR(32) COMMENT '主键id',
  `user_id` VARCHAR(32) COMMENT '用户id',
  `role_id` VARCHAR(32) COMMENT '角色id',
  `create_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色关联表';



-- ----------------------------
-- 创建 小程序用户地址信息表
-- ----------------------------
DROP TABLE IF EXISTS `adress`;
CREATE TABLE `adress`  (
	`id` VARCHAR(32) NOT NULL  COMMENT '主键id',
  `base_addrerss` VARCHAR(50) NOT NULL COMMENT '基本地址(省市区地址)',
  `detail_address` VARCHAR(150) NOT NULL COMMENT '详细地址',
  `phone` VARCHAR(11) NOT NULL COMMENT '收件人手机号',
  `user_name` VARCHAR(10) NOT NULL COMMENT '收件人姓名',
  `longitude` VARCHAR(20) NOT NULL COMMENT '经度',
  `latitude` VARCHAR(20) NOT NULL COMMENT '纬度',
  `is_DEFAULT` CHAR(3) DEFAULT 19 NOT NULL COMMENT '是否是默认地址(18:默认地址、19:非默认地址)',
  `is_delete`  CHAR(3) DEFAULT 15 COMMENT '是否删除(14:已删除、15:未删除)',
  `create_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='小程序用户地址信息表';



-- ----------------------------
-- 创建 小程序用户信息和地址信息关联表
-- ----------------------------
DROP TABLE IF EXISTS `wx_user_address_rel`;
CREATE TABLE `wx_user_address_rel`  (
	`id` VARCHAR(32) NOT NULL  COMMENT '主键id',
	`user_id` VARCHAR(32) NOT NULL COMMENT '用户id',
	`address_id` VARCHAR(32) NOT NULL COMMENT '地址id',
	FOREIGN KEY(`user_id`) REFERENCES wx_user(`id`),
	FOREIGN KEY (`address_id`) REFERENCES adress(`id`),
  UNIQUE (`user_id` ,`address_id`),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='小程序用户信息和地址信息关联表';





-- ----------------------------
-- 创建 轮播图表
-- ----------------------------
DROP TABLE IF EXISTS `swiper`;
CREATE TABLE `swiper`  (
	`id` VARCHAR(32) NOT NULL  COMMENT '主键id',
	`type` VARCHAR(100) DEFAULT NULL COMMENT '类型',
	`attachment_id` VARCHAR(32) NOT NULL COMMENT '附件id',
	`title` VARCHAR(30) DEFAULT NULL COMMENT '标题',
	`sub_title` VARCHAR(100) DEFAULT NULL COMMENT '子标题',
	`detail` VARCHAR(100) DEFAULT NULL COMMENT '详细信息',
	`link` VARCHAR(100) DEFAULT NULL COMMENT '跳转链接',
  `is_delete`  CHAR(3) DEFAULT 15 NOT NULL COMMENT '是否删除(14:已删除、15:未删除)',
  `create_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='轮播图表';




-- ----------------------------
-- 创建 公告栏表
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
	`id` VARCHAR(32) NOT NULL COMMENT '主键id',
	`type` VARCHAR(100) DEFAULT NULL COMMENT '类型',
	`title` VARCHAR(30) NOT NULL COMMENT '标题',
	`sub_title` VARCHAR(100) DEFAULT NULL COMMENT '子标题',
	`detail` VARCHAR(100) DEFAULT NULL COMMENT '详细信息',
	`link` VARCHAR(100) DEFAULT NULL COMMENT '跳转链接',
  `is_delete`  CHAR(3) DEFAULT 15 NOT NULL COMMENT '是否删除(14:已删除、15:未删除)',
  `create_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公告栏表';





-- ----------------------------
-- 创建 回收商品分类表
-- ----------------------------
DROP TABLE IF EXISTS `recycle_goods_type`;
CREATE TABLE `recycle_goods_type`  (
	`id` VARCHAR(32) NOT NULL  COMMENT '主键id',
	`name` VARCHAR(30) NOT NULL COMMENT '类别名称',
	`describe` VARCHAR(100) DEFAULT NULL COMMENT '类别描述',
  `is_delete`  CHAR(3) DEFAULT 15 NOT NULL COMMENT '是否删除(14:已删除、15:未删除)',
  `create_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='回收商品分类表';


-- ----------------------------
-- 创建 回收商品表
-- ----------------------------
DROP TABLE IF EXISTS `recycle_goods`;
CREATE TABLE `recycle_goods`  (
	`id` VARCHAR(32) NOT NULL  COMMENT '主键id',
	`type_id` VARCHAR(32) NOT NULL COMMENT '类别id',
	`name` VARCHAR(30) NOT NULL COMMENT '商品名称',
	`describe` VARCHAR(100) DEFAULT NULL COMMENT '商品描述',
	`integral` double(7,2) NOT NULL COMMENT '商品可兑换积分',
	`attachment_id` VARCHAR(32) NOT NULL COMMENT '附件id',
	`user_price` double(7,2) NOT NULL COMMENT '用户价格',
	`driver_price` double(7,2) NOT NULL COMMENT '骑手价格',
	`recycle_center__price` double(7,2) NOT NULL COMMENT '回收中心用户价格',
  `is_delete`  CHAR(3) DEFAULT 15 NOT NULL COMMENT '是否删除(14:已删除、15:未删除)',
  `create_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='回收商品表';




-- ----------------------------
-- 创建 回收商品订单表
-- ----------------------------
DROP TABLE IF EXISTS `recycle_order`;
CREATE TABLE `recycle_order`  (
	`id` VARCHAR(32) NOT NULL  COMMENT '主键id',
  `submit_user_id` VARCHAR(32) NOT NULL COMMENT '下单用户id',
  `receive_user_id` VARCHAR(32) NOT NULL COMMENT '接单用户id',
  `order_type` CHAR(3) NOT NULL COMMENT '订单类别(10:用户到骑手, 11:骑手到回收中心用户)',
  `status` CHAR(3) NOT NULL COMMENT '订单类别(4:待接单, 5:待上门, 6:待结算, 7:已完结, 8:待已超时, 9:取消订单)',
  `trading_money` double(7,2) NOT NULL COMMENT '交易金额',
  `note` VARCHAR(255) DEFAULT NULL COMMENT '下单备注',
  `is_delete`  CHAR(3) DEFAULT 15  NOT NULL COMMENT '是否删除(14:已删除、15:未删除)',
  `create_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='回收商品订单表';



-- ----------------------------
-- 创建 回收商品订单详情表
-- ----------------------------
DROP TABLE IF EXISTS `recycle_order_detail`;
CREATE TABLE `recycle_order_detail`(
	`id` VARCHAR(32) NOT NULL  COMMENT '主键id',
	`order_id` VARCHAR(32) NOT NULL COMMENT '订单id',
  `goods_id` VARCHAR(32) NOT NULL COMMENT '商品id',
  `weight` double(7,2)  NOT NULL COMMENT '商品重量(KG)',
  `is_delete`  CHAR(3) DEFAULT 15 NOT NULL COMMENT '是否删除(14:已删除、15:未删除)',
  `create_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='回收商品订单详情表';





-- ----------------------------
-- 创建 积分商品分类表
-- ----------------------------
DROP TABLE IF EXISTS `integral_goods_type`;
CREATE TABLE `integral_goods_type`  (
	`id` VARCHAR(32) NOT NULL  COMMENT '主键id',
	`name` VARCHAR(30) NOT NULL COMMENT '类别名称',
	`describe` VARCHAR(100) DEFAULT NULL COMMENT '类别描述',
  `is_delete`  CHAR(3) DEFAULT 15  NOT NULL COMMENT '是否删除(14:已删除、15:未删除)',
  `create_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='积分商品分类表';


-- ----------------------------
-- 创建 积分商品表
-- ----------------------------
DROP TABLE IF EXISTS `integral_goods`;
CREATE TABLE `integral_goods`  (
	`id` VARCHAR(32) NOT NULL  COMMENT '主键id',
	`type_id`  int(11) NOT NULL COMMENT '类别id',
	`name` VARCHAR(30) NOT NULL COMMENT '商品名称',
	`describe` VARCHAR(100) DEFAULT NULL COMMENT '商品描述',
	`integral` double(7,2) NOT NULL COMMENT '兑换商品需要的积分',
	`attachment_id` VARCHAR(32) NOT NULL COMMENT '附件id',
  `is_delete`  CHAR(3) DEFAULT 15 NOT NULL COMMENT '是否删除(14:已删除、15:未删除)',
  `status`  CHAR(3) DEFAULT 16 COMMENT '商品状态(16:正常、17:已下架)',
  `create_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='积分商品表';


-- ----------------------------
-- 创建 积分商品表订单表
-- ----------------------------
DROP TABLE IF EXISTS `integral_order`;
CREATE TABLE `integral_order`  (
	`id` VARCHAR(32) NOT NULL  COMMENT '主键id',
  `user_id` VARCHAR(32) NOT NULL COMMENT '下单用户id',
  `status` CHAR(3) NOT NULL COMMENT '订单类别(20:待发货, 21:待收货, 22:已完成)',
  `trading_money` double(7,2) NOT NULL COMMENT '交易金额',
  `note` VARCHAR(255) DEFAULT NULL COMMENT '下单备注',
  `is_delete`  CHAR(3) DEFAULT 15 NOT NULL COMMENT '是否删除(14:已删除、15:未删除)',
  `create_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='积分商品表订单表';






-- ----------------------------
-- 创建 账户表
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
	`id` VARCHAR(32) NOT NULL  COMMENT '主键id',
	`user_type` CHAR(3) NOT NULL COMMENT '用户类型(0:平台用户、1:微信用户、 2:骑手用户、 3:回收中心用户)',
  `user_id` VARCHAR(32) NOT NULL COMMENT '用户id',
  `balance` double(7,2) NOT NULL COMMENT '用户余额',
  `create_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账户表';



-- ----------------------------
-- 创建 账户流水表
-- ----------------------------
DROP TABLE IF EXISTS `account_record`;
CREATE TABLE `account_record`  (
	`id` VARCHAR(32) NOT NULL  COMMENT '主键id',
	`user_type_from` CHAR(3) NOT NULL COMMENT '支出用户类型(0:平台用户、1:微信用户、 2:骑手用户、 3:回收中心用户)',
	`user_type_to` CHAR(3) NOT NULL COMMENT '收入用户类型(0:平台用户、1:微信用户、 2:骑手用户、 3:回收中心用户)',
	`user_id_from` VARCHAR(32) NOT NULL COMMENT '支出用户id',
	`user_id_to` VARCHAR(32) NOT NULL COMMENT '收入用户id',
	`trading_id` VARCHAR(32) NULL COMMENT '交易id(订单id)',
  `trading_money` double(7,2) NOT NULL COMMENT '交易金额',
  `trading_type` CHAR(3) NOT NULL COMMENT '交易方式',
  `trading_note` VARCHAR(255) DEFAULT NULL COMMENT '交易备注',
  `create_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账户流水';



