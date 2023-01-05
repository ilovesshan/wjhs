-- 初始化 用户表数据
INSERT INTO
  `wjhs`.`user` (`id`, `username`, `password`, `user_type`, `gender`, `attachment_id`, `nick_name`, `phone`, `is_delete`, `last_visit_time`)
VALUES
  ('369BCFE480454D22A07A8644F6DF0349', 'admin', '_hSF8lwCW9Ha2zdsii0AjaOSsVwKQ28Ti3SUe144KXU=', 0, 20, NULL, '管理员', 15882712233, 15, NULL),
  ('ADBD5F0E46474696B65140568E43385E', 'sunlei', '_hSF8lwCW9Ha2zdsii0AjaOSsVwKQ28Ti3SUe144KXU=', 2, 20, NULL, '孙雷', 15882712233, 15, NULL),
  ('796d300069384ee3abf3a318e879c5bd', 'linnana', '_hSF8lwCW9Ha2zdsii0AjaOSsVwKQ28Ti3SUe144KXU=', 2, 20, NULL, '琳娜娜', 15882712233, 15, NULL),
  ('F2532E33786F4B8D9FA2DB00F03352FB', 'ilovesshan', '_hSF8lwCW9Ha2zdsii0AjaOSsVwKQ28Ti3SUe144KXU=', 3, 20, NULL, NULL, 15882712233,15, NULL);


-- 初始化 角色表数据
INSERT INTO
  `wjhs`.`role` (`id`, `role_name`, `role_code`,`description`, `is_delete`)
VALUES
  ('612F7B30836B4698959AE2954F58922A', '平台用户', 'PTYH', '', 15),
  ('D4B32DEE01E845DEA40EC55120F44973','微信用户', 'WXYH', '', 15),
  ('509E0E6D5A464248BBB60F1869B701FA', '骑手用户','QSYH', '', 15),
  ('D3E36342C3C943AA99587F23D60EB272', '回收中心用户', 'HSZXYH', '', 15);


-- 初始化 字典表数据
INSERT INTO
  `wjhs`.`system_dict` (`id`, `dict_code`, `dict_name`, `dict_describe`, `sort`, `create_by`, `create_by_user_id`)
VALUES
  ('F3A6A71BD8FD4A25B3E3D61520EBEBEF', 0, '用户类型(yhlx)', '平台用户', 1 , 'admin', '369BCFE480454D22A07A8644F6DF0349'),
  ('497F4D3CAC91476EBBEB1C679D4CBBF5', 1, '用户类型(yhlx)', '微信用户', 1 , 'admin', '369BCFE480454D22A07A8644F6DF0349'),
  ('F5ADC7D21F3E48C4B296D44D019ABF38', 2, '用户类型(yhlx)', '骑手用户', 1 , 'admin', '369BCFE480454D22A07A8644F6DF0349'),
  ('A619507790284EF882492DDB4CE3B0FD', 3, '用户类型(yhlx)', '回收中心用户', 1 , 'admin', '369BCFE480454D22A07A8644F6DF0349'),

  ('6D1E77DC642445FA994A84115A75A1B7', 4, '回收订单状态(hsddzt)', '待接单', 1 , 'admin', '369BCFE480454D22A07A8644F6DF0349'),
  ('E7D531B8D6FE4A288C8AEBF403924118', 5, '回收订单状态(hsddzt)', '待上门', 1 , 'admin', '369BCFE480454D22A07A8644F6DF0349'),
  ('089E5E6A67714279B987A31AF97131C0', 6, '回收订单状态(hsddzt)', '待结算', 1 , 'admin', '369BCFE480454D22A07A8644F6DF0349'),
  ('AAF67629CAF84590AF9E0ECACD2DAF6A', 7, '回收订单状态(hsddzt)', '已完结', 1 , 'admin', '369BCFE480454D22A07A8644F6DF0349'),
  ('217D885919544570B41D3C222C967BE8', 8, '回收订单状态(hsddzt)', '已超时', 1 , 'admin', '369BCFE480454D22A07A8644F6DF0349'),
  ('EFF59628C8CE4AD4BFDDAC155CA82058', 9, '回收订单状态(hsddzt)', '取消订单', 1 , 'admin', '369BCFE480454D22A07A8644F6DF0349'),

  ('8CF00400B3CE420BAAE6F40687BDE431', 10, '回收订单流程(hsddlc)', '用户到骑手', 1 , 'admin', '369BCFE480454D22A07A8644F6DF0349'),
  ('1E20CEADCB444D0DA3AB0A46000E552F', 11, '回收订单流程(hsddlc)', '骑手到回收中心', 1 , 'admin', '369BCFE480454D22A07A8644F6DF0349'),

  ('B40D87D666144596973B909E5D4E3BB4', 12, '用户状态(yhzt)', '正常', 1 , 'admin', '369BCFE480454D22A07A8644F6DF0349'),
  ('D0F3A88D099642A498AB77C497C5165D', 13, '用户状态(yhzt)', '停用', 1 , 'admin', '369BCFE480454D22A07A8644F6DF0349'),

  ('C536B35929B24A7B8FC5A01B04181259', 14, '数据状态(sjzt)', '逻辑删除(已经删除)', 1 , 'admin', '369BCFE480454D22A07A8644F6DF0349'),
  ('CE15758CA04B4CB887A851B9E459FE68', 15, '数据状态(sjzt)', '逻辑删除(未删除)', 1 , 'admin', '369BCFE480454D22A07A8644F6DF0349'),

  ('41C8973B5AFE4F8A84820AA83B8FE6B7', 16, '积分商品状态(jfspzt)', '正常', 1 , 'admin', '369BCFE480454D22A07A8644F6DF0349'),
  ('91B47BF061D34301BE521FA283839CEF', 17, '积分商品状态(jfspzt)', '已下架', 1 , 'admin', '369BCFE480454D22A07A8644F6DF0349'),

  ('968294A4D44D46DD8775990144DFBF40', 18, '地址信息状态(dzxxzt)', '默认地址', 1 , 'admin', '369BCFE480454D22A07A8644F6DF0349'),
  ('A1915E353BB54DF4A32DF0B9AAE6FABF', 19, '地址信息状态(dzxxzt)', '非默认地址', 1 , 'admin', '369BCFE480454D22A07A8644F6DF0349'),

  ('538FB84080D24AC9B1904F5270D33C85', 20, '性别状态(xbzt)', '男', 1 , 'admin',  '369BCFE480454D22A07A8644F6DF0349'),
  ('9D73A5790DCD4CF2815CF8119976D116', 21, '性别状态(xbzt)', '女', 1 , 'admin',  '369BCFE480454D22A07A8644F6DF0349'),

  ('6E90BCA2A59D4F6EA4874820B7251536', 22, '操作状态(czzt)', '成功', 1 , 'admin', '369BCFE480454D22A07A8644F6DF0349'),
  ('99FABB30FF9E47D4BF3DB044C01AC85C', 23, '操作状态(czzt)', '失败', 1 , 'admin', '369BCFE480454D22A07A8644F6DF0349'),

  ('CE374C948A334E21A25257EF858971A3', 24, '交易方式(jyfs)', '微信', 1 , 'admin', '369BCFE480454D22A07A8644F6DF0349'),
  ('37E05F1636BD4D8080992B515B7FD344', 25, '交易方式(jyfs)', '支付宝', 1 , 'admin', '369BCFE480454D22A07A8644F6DF0349'),
  ('0B7EBDE2702B410AA2B14A408B99B75F', 26, '交易方式(jyfs)', '现金', 1 , 'admin', '369BCFE480454D22A07A8644F6DF0349'),
  ('1BA5D4E14ACC4EDC9E8BBACC478D1603', 27, '交易方式(jyfs)', '刷卡', 1 , 'admin', '369BCFE480454D22A07A8644F6DF0349'),

  ('763A480C51BC4D68AC49F6652D1BF0D2', 28, '菜单类型(cdlx)', '目录', 1 , 'admin', '369BCFE480454D22A07A8644F6DF0349'),
  ('E72D13A4320B41D08452C127174E5392', 29, '菜单类型(cdlx)', '菜单', 1 , 'admin', '369BCFE480454D22A07A8644F6DF0349'),
  ('6F07165F9BF54089B781D91F125283C7', 30, '菜单类型(cdlx)', '按钮', 1 , 'admin', '369BCFE480454D22A07A8644F6DF0349'),

    ('7B780A0BF5EB46248FB77D800AD7024D', 31, '终端类型(zdlx)', '小程序', 1 , 'admin', '369BCFE480454D22A07A8644F6DF0349'),
  ('B81A602284B44052AE1BE0D5EBBA9A2E', 32, '终端类型(zdlx)', 'App', 1 , 'admin', '369BCFE480454D22A07A8644F6DF0349'),

    ('6EB0678757884A29870847A2A625526D', 33, '商品状态(spzt)', '上架', 1 , 'admin', '369BCFE480454D22A07A8644F6DF0349'),
  ('FED74C098E4543BE9B1C82DA06F49985', 34, '商品状态(spzt)', '下架', 1 , 'admin', '369BCFE480454D22A07A8644F6DF0349'),

  ('1ddc152f8ee44b6f90d86db9fc482fe0', 35, '出入账状态(crzzt)', '支出', 1 , 'admin', '369BCFE480454D22A07A8644F6DF0349'),
  ('8623d4a600154cb888562038ec308821', 36, '出入账状态(crzzt)', '收入', 1 , 'admin', '369BCFE480454D22A07A8644F6DF0349'),

    ('500ecc8e61924a80a7d2960016f6ada9', 37, '反馈处理状态(fkclzt)', '未处理', 1 , 'admin', '369BCFE480454D22A07A8644F6DF0349'),
  ('03b799466fe546799cc1b127e46e983c', 38, '反馈处理状态(fkclzt)', '已处理', 1 , 'admin', '369BCFE480454D22A07A8644F6DF0349'),

    ('eda45a148e0b430ba65cfa7479f2ed79', 39, 'app更新状态(appgxzt)', '无版本更新', 1 , 'admin', '369BCFE480454D22A07A8644F6DF0349'),
  ('22d68c0e484b411e9b284f0941ff12cf', 40, 'app更新状态(appgxzt)', '有版本更新，不需要强制升级', 1 , 'admin', '369BCFE480454D22A07A8644F6DF0349'),
  ('b93cc53a6675430da69c6f848dd3a500', 41, 'app更新状态(appgxzt)', '有版本更新，需要强制升级', 1 , 'admin', '369BCFE480454D22A07A8644F6DF0349');


-- 初始化 账户表数据
INSERT INTO
  `wjhs`.`account` (`id`, `user_type`, `user_id`, `balance`, `is_delete`)
VALUES
  ('bdb449e9d322473d86fcbc7434ebb1ef', 0, '369BCFE480454D22A07A8644F6DF0349', 994000, '15'),
  ('11D26E088CDA47D581DD6290AEC61BB7', 0, 'ADBD5F0E46474696B65140568E43385E', 1000, '15'),
  ('caded86ddbb044fbbc6c5206e8dd5b80', 0, '796d300069384ee3abf3a318e879c5bd', 1000, '15'),
  ('EC9A069267EC4DC5A25AA3A2C5F0A741', 0, 'F2532E33786F4B8D9FA2DB00F03352FB', 5000, '15');



-- 初始化 账户流水表数据
INSERT INTO
  `wjhs`.`account_record` (`id`, `user_type_from`, `user_type_to`, `user_id_from`, `user_id_to`, `pay_status`, `trading_id`, `trading_money`, `trading_type`, `trading_note`,`is_delete`)
VALUES
  ('E527EADFA76A46A48164ECEDC65721FD', 2, 0, 'ADBD5F0E46474696B65140568E43385E', '369BCFE480454D22A07A8644F6DF0349', '35', NULL, 1000, 28, '用户注册，系统首次充值', '15'),
  ('5c29884bf9fc4a1abb29af95646594d8', 2, 0, '796d300069384ee3abf3a318e879c5bd', '369BCFE480454D22A07A8644F6DF0349', '35', NULL, 1000, 28, '用户注册，系统首次充值', '15'),
  ('1331266BF62E47DBBFC277D098B25233', 3, 0, 'F2532E33786F4B8D9FA2DB00F03352FB', '369BCFE480454D22A07A8644F6DF0349', '35', NULL, 5000, 28, '用户注册，系统首次充值', '15');


INSERT INTO
  `recycle_goods_type` (`id`, `name`, `describe`, `is_delete`, `status`)
VALUES
  ('1793fa07104e4cfab1b6e511fdba3d46', '库存积压', '回收各类积压物资回收，如库存布料、地毯、布头，服装卷筒布，服装下脚料。', '15', '33'),
  ('2a69cb12676e4eb2a8709deaeba7f693', '电子电器', '打印机、复印件、传真机、废旧电脑及配件、中央空调、手提电脑、冰箱、线路板、电子元件、洗衣机、发电机、电动机、点焊机、旧变压器等。', '14', '33'),
  ('3a5cd0e1300c47ccb1d57ea7a34429e6', '拆迁工程', '回收工程拆除、拆活动房、拆配电房、拆建筑废料、拆电线电缆。', '15', '34'),
  ('41b1ec1b9c7446c298884b3161d96f93', '宾馆酒店', '回收电视、电脑、冰柜、大型冷库，各类电器积压库存物资等。', '15', '34'),
  ('583f49bf209242ef8f6d228f5475e664', '工业废料', '回收模具贴、模具钢、铣刀等各工厂下脚料，建筑废料、拆迁废料、废电线电缆、水暖器材、管扣件及门窗材料。', '15', '33'),
  ('585453a37a1845f48b2cdc697b763734', '废纸', '回收报纸、书本、纸板等。', '15', '33'),
  ('5ff0a5ef474841c88d40cbab8d22b0d2', '电子电器', '回收打印机、复印件、传真机、废旧电脑及配件、中央空调、手提电脑、冰箱、线路板、电子元件、洗衣机、发电机、电动机、点焊机、旧变压器等。', '15', '33'),
  ('8c45f79831854dfa90a65001ac08844d', '有色金属', '回收废电线电缆、紫铜、黄铜、磷铜、青铜、红铜、漆包线铜、铜屑、铝合金等。', '15', '34'),
  ('9939ed8a838f4885b98593083af98cad', '稀有金属', '回收镁、镀金、镀银、钨丝、钨钢、锌、钛、镍、铬、铑、钼、锑、铟、钴粉、锡铋合金等。', '15', '34'),
  ('a2be382ef78b4b4ca2fa1bbd73dab01a', '塑料资源', '回收亚克力、聚氯乙烯、聚苯乙烯、聚乙烯、聚丙烯、ABS料等塑料。', '15', '34'),
  ('b46745ddc3974d5cb2cfe1bac64616e6', '工业设备', '回收水暖冷冻设备、废旧化工设备、空调系统、机床、锅炉、贮罐、换热器、塔器、钛设备等一切废旧设备。', '15', '33');