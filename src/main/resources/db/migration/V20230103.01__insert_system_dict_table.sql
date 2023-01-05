-- 添加数据字典 app更新状态(appgxzt)
INSERT INTO
  `wjhs`.`system_dict` (`id`, `dict_code`, `dict_name`, `dict_describe`, `sort`, `create_by`, `create_by_user_id`, `update_by`, `update_by_user_id`)
VALUES
  ('eda45a148e0b430ba65cfa7479f2ed79', 39, 'app更新状态(appgxzt)', '无版本更新', 1 , 'admin', '369BCFE480454D22A07A8644F6DF0349', NULL, NULL),
  ('22d68c0e484b411e9b284f0941ff12cf', 40, 'app更新状态(appgxzt)', '有版本更新，不需要强制升级', 1 , 'admin', '369BCFE480454D22A07A8644F6DF0349', NULL, NULL),
  ('b93cc53a6675430da69c6f848dd3a500', 41, 'app更新状态(appgxzt)', '有版本更新，需要强制升级', 1 , 'admin', '369BCFE480454D22A07A8644F6DF0349', NULL, NULL);
