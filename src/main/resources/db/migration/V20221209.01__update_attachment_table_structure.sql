-- 更新日志表中url数据长度
alter table attachment modify `create_by_user_name` varchar(32) not null comment '创建人姓名';

