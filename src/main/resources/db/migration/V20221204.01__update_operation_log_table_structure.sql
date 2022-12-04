-- 更新日志表中url数据长度
alter table operation_log modify `url` VARCHAR(255) NOT NULL COMMENT '请求url';