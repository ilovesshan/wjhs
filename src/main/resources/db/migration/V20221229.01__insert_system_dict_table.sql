-- 添加数据字典 出入账状态(crzzt)
INSERT INTO
  `wjhs`.`system_dict` (`id`, `dict_code`, `dict_name`, `dict_describe`, `sort`, `create_by`, `create_by_user_id`, `update_by`, `update_by_user_id`)
VALUES
  ('500ecc8e61924a80a7d2960016f6ada9', 37, '反馈处理状态(fkclzt)', '未处理', 1 , 'admin', '369BCFE480454D22A07A8644F6DF0349', NULL, NULL),
  ('03b799466fe546799cc1b127e46e983c', 38, '反馈处理状态(fkclzt)', '已处理', 1 , 'admin', '369BCFE480454D22A07A8644F6DF0349', NULL, NULL);
