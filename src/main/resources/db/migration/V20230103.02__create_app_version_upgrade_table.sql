-- 新增app版本升级表
drop table if exists `app_version_upgrade`;
create table `app_version_upgrade`(
    `id` varchar(32) not null  comment '主键id',
    `update_status` char(3) not null comment 'app更新状态(39:无版本更新、40:有版本更新，不需要强制升级、41:有版本更新，需要强制升级)',
    `version_code` varchar(5) not null comment '编译版本号(唯一)',
    `version_name` varchar(10) not null comment '版本名(用于展示)',
    `major` tinyint not null comment '主版本号',
    `minor` tinyint not null comment '次版本号',
    `patch` tinyint not null comment '修订号',
    `modify_content` varchar(255) default "" comment '升级提示',
    `download_url` varchar(255) not null comment '下载地址',
    `apk_size` int(10) not null comment '文件的大小(单位:kb)',
    `apk_md5` varchar(255) default null comment 'md5值',
    `is_delete` char(3) default 15 not null comment '是否删除(14:已删除、15:未删除)',
    `create_time` datetime(0) default current_timestamp comment '创建时间',
    `update_time` datetime(0) default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`id`)
) engine=innodb default charset=utf8mb4 collate=utf8mb4_0900_ai_ci comment= 'app版本升级表';


