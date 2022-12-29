-- 新增用户反馈表
drop table if exists `user_feedback`;
create table `user_feedback`(
    `id` varchar(32) not null  comment '主键id',
    `user_id` varchar(32) not null comment '用户id',
    `feedback_title` varchar(128) not null comment '反馈标题',
    `feedback_detail` varchar(255) not null comment '反馈详细',
    `attachment_id` VARCHAR(32) DEFAULT NULL COMMENT '附件id',
    `is_solve` char(3) default '37' not null comment '是否解决(37:未处理、38:已处理)',
    `is_delete` char(3) default '15' not null comment '是否删除(14:已删除、15:未删除)',
    `create_time` datetime(0) default current_timestamp comment '创建时间',
    `update_time` datetime(0) default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`id`)
) engine=innodb default charset=utf8mb4 collate=utf8mb4_0900_ai_ci comment= '用户反馈表';