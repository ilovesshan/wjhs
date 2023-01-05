-- ----------------------------
-- table structure for account
-- ----------------------------
drop table if exists `account`;
create table `account` (
  `id` varchar(32) not null comment '主键id',
  `user_type` char(3) not null comment '用户类型(0:平台用户、1:微信用户、 2:骑手用户、 3:回收中心用户)',
  `user_id` varchar(32) not null comment '用户id',
  `balance` double(10,2) not null comment '账户余额',
  `is_delete` char(3) not null comment '是否删除(14:已删除、15:未删除)',
  `create_time` datetime default current_timestamp comment '创建时间',
  `update_time` datetime default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`id`)
) engine=innodb default charset=utf8mb3 comment='账户表';

-- ----------------------------
-- table structure for account_record
-- ----------------------------
drop table if exists `account_record`;
create table `account_record` (
  `id` varchar(32) not null comment '主键id',
  `user_type_from` char(3) not null comment '支出用户类型(0:平台用户、1:微信用户、 2:骑手用户、 3:回收中心用户)',
  `user_type_to` char(3) not null comment '收入用户类型(0:平台用户、1:微信用户、 2:骑手用户、 3:回收中心用户)',
  `user_id_from` varchar(32) not null comment '支出用户id',
  `user_id_to` varchar(32) not null comment '收入用户id',
  `pay_status` char(3) not null comment '出入账状态(35:收入, 36:支出)',
  `trading_id` varchar(32) default null comment '交易id(订单id)',
  `trading_money` double(7,2) not null comment '交易金额',
  `trading_type` char(3) not null comment '交易方式(24:微信、25:支付宝、 26:现金、 27:平台交易)',
  `trading_note` varchar(255) default null comment '交易备注',
  `is_delete` char(3) not null comment '是否删除(14:已删除、15:未删除)',
  `create_time` datetime default current_timestamp comment '创建时间',
  `update_time` datetime default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`id`)
) engine=innodb default charset=utf8mb3 comment='账户流水';

-- ----------------------------
-- table structure for address
-- ----------------------------
drop table if exists `address`;
create table `address` (
  `id` varchar(32) not null comment '主键id',
  `detail_address` varchar(150) not null comment '详细地址',
  `area` varchar(10) default null comment '县/区',
  `city` varchar(15) default null comment '市',
  `province` varchar(10) default null comment '省',
  `phone` varchar(11) not null comment '收件人手机号',
  `user_name` varchar(10) not null comment '收件人姓名',
  `longitude` varchar(20) not null comment '经度',
  `latitude` varchar(20) not null comment '纬度',
  `is_default` char(3) not null default '19' comment '是否是默认地址(18:默认地址、19:非默认地址)',
  `is_delete` char(3) default '15' comment '是否删除(14:已删除、15:未删除)',
  `create_time` datetime default current_timestamp comment '创建时间',
  `update_time` datetime default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`id`)
) engine=innodb default charset=utf8mb3 comment='小程序用户地址信息表';

-- ----------------------------
-- table structure for app_version_upgrade
-- ----------------------------
drop table if exists `app_version_upgrade`;
create table `app_version_upgrade` (
  `id` varchar(32) not null comment '主键id',
  `update_status` char(3) not null comment 'app更新状态(39:无版本更新、40:有版本更新，不需要强制升级、41:有版本更新，需要强制升级)',
  `version_code` varchar(5) not null comment '编译版本号(唯一)',
  `version_name` varchar(10) not null comment '版本名(用于展示)',
  `major` tinyint not null comment '主版本号',
  `minor` tinyint not null comment '次版本号',
  `patch` tinyint not null comment '修订号',
  `modify_content` varchar(255) default '' comment '升级提示',
  `download_url` varchar(255) not null comment '下载地址',
  `apk_size` int not null comment '文件的大小(单位:kb)',
  `apk_md5` varchar(255) default null comment 'md5值',
  `is_delete` char(3) not null default '15' comment '是否删除(14:已删除、15:未删除)',
  `create_time` datetime default current_timestamp comment '创建时间',
  `update_time` datetime default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`id`)
) engine=innodb default charset=utf8mb4 collate=utf8mb4_0900_ai_ci comment='app版本升级表';

-- ----------------------------
-- table structure for attachment
-- ----------------------------
drop table if exists `attachment`;
create table `attachment` (
  `id` varchar(32) not null comment '主键id',
  `url` varchar(100) not null comment '访问地址',
  `create_by_user_id` varchar(32) not null comment '创建人id',
  `create_by_user_name` varchar(32) default null comment '创建人姓名',
  `create_by_user_type` char(3) not null comment '用户类型(0:平台用户、1:微信用户、 2:骑手用户、 3:回收中心用户)',
  `is_delete` char(3) not null default '15' comment '是否删除(14:已删除、15:未删除)',
  `create_time` datetime default current_timestamp comment '创建时间',
  `update_time` datetime default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`id`)
) engine=innodb default charset=utf8mb3 comment='系统附件表';

-- ----------------------------
-- table structure for flyway_schema_history
-- ----------------------------
drop table if exists `flyway_schema_history`;
create table `flyway_schema_history` (
  `installed_rank` int not null,
  `version` varchar(50) default null,
  `description` varchar(200) not null,
  `type` varchar(20) not null,
  `script` varchar(1000) not null,
  `checksum` int default null,
  `installed_by` varchar(100) not null,
  `installed_on` timestamp not null default current_timestamp,
  `execution_time` int not null,
  `success` tinyint(1) not null,
  primary key (`installed_rank`),
  key `flyway_schema_history_s_idx` (`success`)
) engine=innodb default charset=utf8mb3;

-- ----------------------------
-- table structure for integral_goods
-- ----------------------------
drop table if exists `integral_goods`;
create table `integral_goods` (
  `id` varchar(32) not null comment '主键id',
  `type_id` int not null comment '类别id',
  `name` varchar(30) not null comment '商品名称',
  `describe` varchar(100) default null comment '商品描述',
  `integral` double(7,2) not null comment '兑换商品需要的积分',
  `attachment_id` varchar(32) not null comment '附件id',
  `is_delete` char(3) not null default '15' comment '是否删除(14:已删除、15:未删除)',
  `status` char(3) default '16' comment '商品状态(16:正常、17:已下架)',
  `create_time` datetime default current_timestamp comment '创建时间',
  `update_time` datetime default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`id`)
) engine=innodb default charset=utf8mb3 comment='积分商品表';

-- ----------------------------
-- table structure for integral_goods_type
-- ----------------------------
drop table if exists `integral_goods_type`;
create table `integral_goods_type` (
  `id` varchar(32) not null comment '主键id',
  `describe` varchar(100) default null comment '类别描述',
  `is_delete` char(3) not null default '15' comment '是否删除(14:已删除、15:未删除)',
  `create_time` datetime default current_timestamp comment '创建时间',
  `update_time` datetime default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`id`)
) engine=innodb default charset=utf8mb3 comment='积分商品分类表';

-- ----------------------------
-- table structure for integral_order
-- ----------------------------
drop table if exists `integral_order`;
create table `integral_order` (
  `id` varchar(32) not null comment '主键id',
  `user_id` varchar(32) not null comment '下单用户id',
  `status` char(3) not null comment '订单类别(20:待发货, 21:待收货, 22:已完成)',
  `trading_money` double(7,2) not null comment '交易金额',
  `note` varchar(255) default null comment '下单备注',
  `is_delete` char(3) not null default '15' comment '是否删除(14:已删除、15:未删除)',
  `create_time` datetime default current_timestamp comment '创建时间',
  `update_time` datetime default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`id`)
) engine=innodb default charset=utf8mb3 comment='积分商品表订单表';

-- ----------------------------
-- table structure for login_log
-- ----------------------------
drop table if exists `login_log`;
create table `login_log` (
  `id` varchar(32) not null comment '主键id',
  `user_type` char(3) not null comment '用户类型(0:平台用户、1:微信用户、 2:骑手用户、 3:回收中心用户)',
  `user_id` varchar(32) not null comment '用户id',
  `token` varchar(100) not null comment '登录凭证',
  `user_name` varchar(10) not null comment '用户名称',
  `login_ip` varchar(128) default null comment '登录ip',
  `login_time` datetime default null comment '登录时间',
  `login_location` varchar(50) default null comment '用户登录地址',
  `is_delete` char(3) not null default '15' comment '是否删除(14:已删除、15:未删除)',
  `browser` varchar(50) default '' comment '浏览器类型',
  `system_os` varchar(50) default '' comment '操作系统',
  primary key (`id`)
) engine=innodb default charset=utf8mb4 collate=utf8mb4_0900_ai_ci comment='用户登录表';

-- ----------------------------
-- table structure for menu
-- ----------------------------
drop table if exists `menu`;
create table `menu` (
  `id` varchar(32) not null comment '编号',
  `parent_id` varchar(32) not null default '0' comment '所属上级',
  `name` varchar(20) not null default '' comment '名称',
  `type` tinyint not null default '0' comment '类型(28:目录, 29:菜单,30:按钮)',
  `path` varchar(100) default null comment '路由地址',
  `component` varchar(100) default null comment '组件路径',
  `perms` varchar(100) default null comment '权限标识',
  `icon` varchar(100) default null comment '图标',
  `sort_value` int default null comment '排序',
  `is_delete` char(3) not null default '15' comment '是否删除(14:已删除、15:未删除)',
  `create_time` timestamp not null default current_timestamp comment '创建时间',
  `update_time` timestamp not null default current_timestamp on update current_timestamp comment '更新时间',
  primary key (`id`)
) engine=innodb default charset=utf8mb4 collate=utf8mb4_0900_ai_ci comment='权限表';

-- ----------------------------
-- table structure for notice
-- ----------------------------
drop table if exists `notice`;
create table `notice` (
  `id` varchar(32) not null comment '主键id',
  `type` char(3) not null comment '类型(31:小程序端、32:app端)',
  `title` varchar(30) not null comment '标题',
  `sub_title` varchar(100) default null comment '子标题',
  `detail` varchar(100) default null comment '详细信息',
  `link` varchar(100) default null comment '跳转链接',
  `is_delete` char(3) not null default '15' comment '是否删除(14:已删除、15:未删除)',
  `create_time` datetime default current_timestamp comment '创建时间',
  `update_time` datetime default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`id`)
) engine=innodb default charset=utf8mb3 comment='公告栏表';

-- ----------------------------
-- table structure for operation_log
-- ----------------------------
drop table if exists `operation_log`;
create table `operation_log` (
  `id` varchar(32) not null comment '主键id',
  `business_module` varchar(20) not null comment '业务模块',
  `business_type` varchar(20) not null comment '业务类型',
  `business_describe` varchar(30) default null comment '描述信息',
  `api_method` varchar(255) not null comment 'api方法',
  `request_method` varchar(10) not null comment '请求方式',
  `user_id` varchar(32) not null comment '操作人员id',
  `user_name` varchar(100) not null comment '操作人员姓名',
  `user_type` char(3) not null comment '用户类型(0:平台用户、1:微信用户、 2:骑手用户、 3:回收中心用户)',
  `url` varchar(255) not null comment '请求url',
  `ip` varchar(32) default null comment '源ip地址',
  `status` char(3) not null comment '操作状态(22:成功、23:失败)',
  `is_delete` char(3) not null default '15' comment '是否删除(14:已删除、15:未删除)',
  `error_message` text not null comment '错误消息',
  `operation_time` datetime default null comment '操作时间',
  primary key (`id`)
) engine=innodb default charset=utf8mb4 collate=utf8mb4_0900_ai_ci comment='操作日志';

-- ----------------------------
-- table structure for recycle_goods
-- ----------------------------
drop table if exists `recycle_goods`;
create table `recycle_goods` (
  `id` varchar(32) not null comment '主键id',
  `type_id` varchar(32) not null comment '类别id',
  `name` varchar(30) not null comment '商品名称',
  `describe` varchar(100) default null comment '商品描述',
  `integral` double(7,2) not null comment '商品可兑换积分',
  `attachment_id` varchar(32) not null comment '附件id',
  `user_price` double(7,2) not null comment '用户价格',
  `driver_price` double(7,2) not null comment '骑手价格',
  `recycle_center_price` double(7,2) not null comment '回收中心用户价格',
  `is_delete` char(3) not null default '15' comment '是否删除(14:已删除、15:未删除)',
  `status` char(3) default '33' comment '商品状态(33:上架、34:下架)',
  `create_time` datetime default current_timestamp comment '创建时间',
  `update_time` datetime default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`id`)
) engine=innodb default charset=utf8mb3 comment='回收商品表';

-- ----------------------------
-- table structure for recycle_goods_type
-- ----------------------------
drop table if exists `recycle_goods_type`;
create table `recycle_goods_type` (
  `id` varchar(32) not null comment '主键id',
  `name` varchar(30) not null comment '类别名称',
  `describe` varchar(100) default null comment '类别描述',
  `is_delete` char(3) not null default '15' comment '是否删除(14:已删除、15:未删除)',
  `status` char(3) default '33' comment '商品状态(33:上架、34:下架)',
  `create_time` datetime default current_timestamp comment '创建时间',
  `update_time` datetime default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`id`)
) engine=innodb default charset=utf8mb3 comment='回收商品分类表';

-- ----------------------------
-- table structure for recycle_order
-- ----------------------------
drop table if exists `recycle_order`;
create table `recycle_order` (
  `id` varchar(32) not null comment '主键id',
  `submit_user_id` varchar(32) not null comment '下单用户id',
  `receive_user_id` varchar(32) default null comment '接单用户id',
  `order_type` char(3) not null comment '订单类别(10:用户到骑手, 11:骑手到回收中心用户)',
  `status` char(3) not null comment '订单类别(4:待接单, 5:待上门, 6:待结算, 7:已完结, 8:已超时, 9:取消订单)',
  `send_to_recycle_center` varchar(1) default null comment '是否已经送往回收中心',
  `trading_money` double(7,2) not null comment '交易金额',
  `total_weight` double(7,2) not null comment '订单总重量',
  `total_integral` double(7,2) not null comment '订单积分',
  `address_id` varchar(32) not null comment '上门地址id',
  `appointment_begin_time` datetime not null comment ' 预约开始时间',
  `appointment_end_time` datetime not null comment '预约结束时间',
  `note` varchar(255) default null comment '下单备注',
  `note_attachmentids` varchar(255) default null comment '备注图片id列表',
  `is_delete` char(3) not null default '15' comment '是否删除(14:已删除、15:未删除)',
  `create_time` datetime default current_timestamp comment '创建时间',
  `update_time` datetime default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`id`)
) engine=innodb default charset=utf8mb3 comment='回收商品订单表';

-- ----------------------------
-- table structure for recycle_order_detail
-- ----------------------------
drop table if exists `recycle_order_detail`;
create table `recycle_order_detail` (
  `id` varchar(32) not null comment '主键id',
  `order_id` varchar(32) not null comment '订单id',
  `goods_id` varchar(32) not null comment '商品id',
  `weight` double(7,2) not null comment '商品重量(kg)',
  `is_delete` char(3) not null default '15' comment '是否删除(14:已删除、15:未删除)',
  `create_time` datetime default current_timestamp comment '创建时间',
  `update_time` datetime default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`id`)
) engine=innodb default charset=utf8mb3 comment='回收商品订单详情表';

-- ----------------------------
-- table structure for recycle_statistical
-- ----------------------------
drop table if exists `recycle_statistical`;
create table `recycle_statistical` (
  `id` varchar(32) not null comment '主键id',
  `order_id` varchar(32) not null comment '订单id',
  `submit_user_id` varchar(32) not null comment '下单用户id',
  `receive_user_id` varchar(32) not null comment '接单用户id',
  `weight` double(7,2) not null comment '商品重量(kg)',
  `order_type` char(3) not null comment '订单类别(10:用户到骑手, 11:骑手到回收中心用户)',
  `is_delete` char(3) not null default '15' comment '是否删除(14:已删除、15:未删除)',
  `create_time` datetime default current_timestamp comment '创建时间',
  `update_time` datetime default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`id`)
) engine=innodb default charset=utf8mb4 collate=utf8mb4_0900_ai_ci comment='回收统计表';

-- ----------------------------
-- table structure for role
-- ----------------------------
drop table if exists `role`;
create table `role` (
  `id` varchar(32) not null comment '角色id',
  `role_name` varchar(20) not null default '' comment '角色名称',
  `role_code` varchar(40) default null comment '角色编码',
  `description` varchar(255) default null comment '描述',
  `is_delete` char(3) not null default '15' comment '是否删除(14:已删除、15:未删除)',
  `create_time` timestamp not null default current_timestamp comment '创建时间',
  `update_time` timestamp not null default current_timestamp on update current_timestamp comment '更新时间',
  primary key (`id`)
) engine=innodb default charset=utf8mb3 comment='角色表';

-- ----------------------------
-- table structure for role_menu
-- ----------------------------
drop table if exists `role_menu`;
create table `role_menu` (
  `id` varchar(32) not null,
  `role_id` varchar(32) not null default '0',
  `menu_id` varchar(32) not null default '0',
  `is_delete` char(3) not null default '15' comment '是否删除(14:已删除、15:未删除)',
  `create_time` timestamp not null default current_timestamp comment '创建时间',
  `update_time` timestamp not null default current_timestamp on update current_timestamp comment '更新时间',
  primary key (`id`)
) engine=innodb default charset=utf8mb3 comment='角色权限关联表';

-- ----------------------------
-- table structure for swiper
-- ----------------------------
drop table if exists `swiper`;
create table `swiper` (
  `id` varchar(32) not null comment '主键id',
  `type` char(3) not null comment '类型(31:小程序端、32:app端)',
  `attachment_id` varchar(32) not null comment '附件id',
  `title` varchar(30) default null comment '标题',
  `sub_title` varchar(100) default null comment '子标题',
  `detail` varchar(100) default null comment '详细信息',
  `link` varchar(100) default null comment '跳转链接',
  `is_delete` char(3) not null default '15' comment '是否删除(14:已删除、15:未删除)',
  `create_time` datetime default current_timestamp comment '创建时间',
  `update_time` datetime default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`id`)
) engine=innodb default charset=utf8mb3 comment='轮播图表';

-- ----------------------------
-- table structure for system_dict
-- ----------------------------
drop table if exists `system_dict`;
create table `system_dict` (
  `id` varchar(32) not null comment '主键id',
  `dict_code` int not null comment '数据类型编码',
  `dict_name` varchar(30) not null comment '数据类型名称',
  `dict_describe` varchar(100) default null comment '描述',
  `sort` int default '1' comment '排序',
  `create_by` varchar(50) not null comment '创建人',
  `create_by_user_id` varchar(32) not null comment '创建人id',
  `update_by` varchar(50) default null comment '修改人',
  `update_by_user_id` varchar(32) default null comment '修改人id',
  `is_delete` char(3) not null default '15' comment '是否删除(14:已删除、15:未删除)',
  `create_time` datetime default current_timestamp comment '创建时间',
  `update_time` datetime default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`id`),
  unique key `idx_dict_code` (`dict_code`)
) engine=innodb default charset=utf8mb3 comment='系统字典类型表';

-- ----------------------------
-- table structure for user
-- ----------------------------
drop table if exists `user`;
create table `user` (
  `id` varchar(32) not null comment '主键id',
  `username` varchar(32) not null comment '用户名称',
  `password` varchar(255) not null comment '用户密码',
  `user_type` char(3) not null comment '用户类型(0:平台用户、1:微信用户、 2:骑手用户、 3:回收中心用户)',
  `gender` char(3) default null comment '性别(20:男、21:女)',
  `attachment_id` varchar(32) default null comment '附件id(头像)',
  `nick_name` varchar(255) default null comment '昵称',
  `phone` varchar(11) not null comment '手机号',
  `is_delete` char(3) not null default '15' comment '是否删除(14:已删除、15:未删除)',
  `last_visit_time` datetime default null comment '最后登录时间',
  `create_time` datetime default current_timestamp comment '创建时间',
  `update_time` datetime default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`id`)
) engine=innodb default charset=utf8mb3 comment='骑手/回收中心用户/平台用户表';

-- ----------------------------
-- table structure for user_feedback
-- ----------------------------
drop table if exists `user_feedback`;
create table `user_feedback` (
  `id` varchar(32) not null comment '主键id',
  `user_id` varchar(32) not null comment '用户id',
  `user_type` char(3) not null comment '用户类型(0:平台用户、1:微信用户、 2:骑手用户、 3:回收中心用户)',
  `feedback_title` varchar(32) not null comment '反馈标题',
  `feedback_detail` varchar(255) not null comment '反馈详细',
  `attachment_id` varchar(32) default null comment '附件id',
  `is_solve` char(3) not null default '37' comment '是否解决(37:未处理、38:已处理)',
  `is_delete` char(3) not null default '15' comment '是否删除(14:已删除、15:未删除)',
  `create_time` datetime default current_timestamp comment '创建时间',
  `update_time` datetime default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`id`)
) engine=innodb default charset=utf8mb4 collate=utf8mb4_0900_ai_ci comment='用户反馈表';

-- ----------------------------
-- table structure for user_role
-- ----------------------------
drop table if exists `user_role`;
create table `user_role` (
  `id` varchar(32) not null comment '主键id',
  `user_id` varchar(32) default null comment '用户id',
  `role_id` varchar(32) default null comment '角色id',
  `is_delete` char(3) not null default '15' comment '是否删除(14:已删除、15:未删除)',
  `create_time` timestamp not null default current_timestamp comment '创建时间',
  `update_time` timestamp not null default current_timestamp on update current_timestamp comment '更新时间',
  primary key (`id`)
) engine=innodb default charset=utf8mb3 comment='用户角色关联表';

-- ----------------------------
-- table structure for wx_integral
-- ----------------------------
drop table if exists `wx_integral`;
create table `wx_integral` (
  `id` varchar(32) not null comment '主键id',
  `user_id` varchar(32) not null comment '用户id',
  `integral` double(7,2) not null comment '用户积分',
  `is_delete` char(3) not null default '15' comment '是否删除(14:已删除、15:未删除)',
  `create_time` datetime default current_timestamp comment '创建时间',
  `update_time` datetime default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`id`)
) engine=innodb default charset=utf8mb4 collate=utf8mb4_0900_ai_ci comment='用户积分表';

-- ----------------------------
-- table structure for wx_integral_record
-- ----------------------------
drop table if exists `wx_integral_record`;
create table `wx_integral_record` (
  `id` varchar(32) not null comment '主键id',
  `user_id` varchar(32) not null comment '用户id',
  `order_id` varchar(32) not null comment '订单id',
  `pay_status` char(3) not null comment '出入账状态(35:收入, 36:支出)',
  `trading_integral` double(7,2) not null comment '交易积分',
  `is_delete` char(3) not null default '15' comment '是否删除(14:已删除、15:未删除)',
  `create_time` datetime default current_timestamp comment '创建时间',
  `update_time` datetime default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`id`)
) engine=innodb default charset=utf8mb4 collate=utf8mb4_0900_ai_ci comment='用户积分流水表';

-- ----------------------------
-- table structure for wx_user
-- ----------------------------
drop table if exists `wx_user`;
create table `wx_user` (
  `id` varchar(32) not null comment '主键id',
  `open_id` varchar(100) not null comment 'open_id',
  `skey` varchar(100) not null comment 'skey',
  `session_key` varchar(100) not null comment 'session_key',
  `gender` char(3) default null comment '性别(20:男、21:女)',
  `avatar_url` varchar(255) default null comment '头像',
  `city` varchar(255) default null comment '市',
  `province` varchar(255) default null comment '省',
  `country` varchar(255) default null comment '国',
  `nick_name` varchar(255) default null comment '昵称',
  `is_delete` char(3) not null default '15' comment '是否删除(14:已删除、15:未删除)',
  `last_visit_time` datetime default null comment '最后登录时间',
  `create_time` datetime default current_timestamp comment '创建时间',
  `update_time` datetime default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`id`)
) engine=innodb default charset=utf8mb3 comment='小程序用户信息表';

-- ----------------------------
-- table structure for wx_user_address_rel
-- ----------------------------
drop table if exists `wx_user_address_rel`;
create table `wx_user_address_rel` (
  `id` varchar(32) character set utf8 collate utf8_danish_ci not null comment '主键id',
  `user_id` varchar(32) not null comment '用户id',
  `address_id` varchar(32) not null comment '地址id',
  `is_delete` char(3) not null default '15' comment '是否删除(14:已删除、15:未删除)',
  `create_time` datetime default current_timestamp comment '创建时间',
  `update_time` datetime default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`id`),
  unique key `user_id` (`user_id`,`address_id`),
  key `address_id` (`address_id`),
  constraint `wx_user_address_rel_ibfk_1` foreign key (`user_id`) references `wx_user` (`id`),
  constraint `wx_user_address_rel_ibfk_2` foreign key (`address_id`) references `address` (`id`)
) engine=innodb default charset=utf8mb3 comment='小程序用户信息和地址信息关联表';