-- 修改表名称
alter table `adress` rename `address`;

-- base_addrerss字段拆分： 省 province    市 city varchar(15)     县/区 area
alter table `address` drop column base_addrerss;

alter table `address` add `area` varchar(10) default null comment '县/区' after `detail_address`;
alter table `address` add `city` varchar(15) default null comment '市' after `area`;
alter table `address` add `province` varchar(10) default null comment '省' after `city`;

-- is_DEFAULT 重命名 改成小写
alter table `address` change `is_DEFAULT`  `is_default` CHAR(3) DEFAULT 19 NOT NULL COMMENT '是否是默认地址(18:默认地址、19:非默认地址)';