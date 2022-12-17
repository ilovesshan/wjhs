-- note_attachmentids 备注图片id列表
alter table `recycle_order` change `note_attachmentids` `note_attachmentIds` varchar(255) default null comment '备注图片id列表' after `note`;
