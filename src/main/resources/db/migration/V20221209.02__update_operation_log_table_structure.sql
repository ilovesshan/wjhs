-- 更新日志表中url数据长度
alter table operation_log modify `user_name` varchar(100) not null comment '操作人员姓名';
alter table operation_log modify `api_method` varchar(255) not null comment 'api方法';
alter table operation_log modify `error_message` text  not null comment '错误消息';
