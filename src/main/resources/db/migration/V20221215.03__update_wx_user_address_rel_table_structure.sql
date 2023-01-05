-- 新增 is_delete
alter table `wx_user_address_rel` add `is_delete` char(3) default 15 not null comment '是否删除(14:已删除、15:未删除)';

-- 新增 create_time
alter table `wx_user_address_rel` add `create_time` datetime(0) default current_timestamp comment '创建时间';

-- 新增 update_time
alter table `wx_user_address_rel` add`update_time` datetime(0) default current_timestamp on update current_timestamp comment '修改时间';



