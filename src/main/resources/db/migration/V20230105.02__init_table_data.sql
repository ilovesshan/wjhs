-- 初始化 用户表数据
insert into 
  `wjhs`.`user` (`id`, `username`, `password`, `user_type`, `gender`, `attachment_id`, `nick_name`, `phone`, `is_delete`, `last_visit_time`) 
values 
  ('369bcfe480454d22a07a8644f6df0349', 'admin', '_hSF8lwCW9Ha2zdsii0AjaOSsVwKQ28Ti3SUe144KXU=', 0, 20, null, '管理员', 15882712233, 15, null),
  ('adbd5f0e46474696b65140568e43385e', 'sunlei', '_hSF8lwCW9Ha2zdsii0AjaOSsVwKQ28Ti3SUe144KXU=', 2, 20, null, '孙雷', 15882712233, 15, null),
  ('796d300069384ee3abf3a318e879c5bd', 'linnana', '_hSF8lwCW9Ha2zdsii0AjaOSsVwKQ28Ti3SUe144KXU=', 2, 20, null, '琳娜娜', 15882712233, 15, null),
  ('f2532e33786f4b8d9fa2db00f03352fb', 'ilovesshan', '_hSF8lwCW9Ha2zdsii0AjaOSsVwKQ28Ti3SUe144KXU=', 3, 20, null, null, 15882712233,15, null);


-- 初始化 角色表数据
insert into 
  `wjhs`.`role` (`id`, `role_name`, `role_code`,`description`, `is_delete`) 
values 
  ('612f7b30836b4698959ae2954f58922a', '平台用户', 'ptyh', '', 15),
  ('d4b32dee01e845dea40ec55120f44973','微信用户', 'wxyh', '', 15),
  ('509e0e6d5a464248bbb60f1869b701fa', '骑手用户','qsyh', '', 15),
  ('d3e36342c3c943aa99587f23d60eb272', '回收中心用户', 'hszxyh', '', 15);


-- 初始化 字典表数据
insert into 
  `wjhs`.`system_dict` (`id`, `dict_code`, `dict_name`, `dict_describe`, `sort`, `create_by`, `create_by_user_id`) 
values 
  ('f3a6a71bd8fd4a25b3e3d61520ebebef', 0, '用户类型(yhlx)', '平台用户', 1 , 'admin', '369bcfe480454d22a07a8644f6df0349'),
  ('497f4d3cac91476ebbeb1c679d4cbbf5', 1, '用户类型(yhlx)', '微信用户', 1 , 'admin', '369bcfe480454d22a07a8644f6df0349'),
  ('f5adc7d21f3e48c4b296d44d019abf38', 2, '用户类型(yhlx)', '骑手用户', 1 , 'admin', '369bcfe480454d22a07a8644f6df0349'),
  ('a619507790284ef882492ddb4ce3b0fd', 3, '用户类型(yhlx)', '回收中心用户', 1 , 'admin', '369bcfe480454d22a07a8644f6df0349'),

  ('6d1e77dc642445fa994a84115a75a1b7', 4, '回收订单状态(hsddzt)', '待接单', 1 , 'admin', '369bcfe480454d22a07a8644f6df0349'),
  ('e7d531b8d6fe4a288c8aebf403924118', 5, '回收订单状态(hsddzt)', '待上门', 1 , 'admin', '369bcfe480454d22a07a8644f6df0349'),
  ('089e5e6a67714279b987a31af97131c0', 6, '回收订单状态(hsddzt)', '待结算', 1 , 'admin', '369bcfe480454d22a07a8644f6df0349'),
  ('aaf67629caf84590af9e0ecacd2daf6a', 7, '回收订单状态(hsddzt)', '已完结', 1 , 'admin', '369bcfe480454d22a07a8644f6df0349'),
  ('217d885919544570b41d3c222c967be8', 8, '回收订单状态(hsddzt)', '已超时', 1 , 'admin', '369bcfe480454d22a07a8644f6df0349'),
  ('eff59628c8ce4ad4bfddac155ca82058', 9, '回收订单状态(hsddzt)', '取消订单', 1 , 'admin', '369bcfe480454d22a07a8644f6df0349'),

  ('8cf00400b3ce420baae6f40687bde431', 10, '回收订单流程(hsddlc)', '用户到骑手', 1 , 'admin', '369bcfe480454d22a07a8644f6df0349'),
  ('1e20ceadcb444d0da3ab0a46000e552f', 11, '回收订单流程(hsddlc)', '骑手到回收中心', 1 , 'admin', '369bcfe480454d22a07a8644f6df0349'),

  ('b40d87d666144596973b909e5d4e3bb4', 12, '用户状态(yhzt)', '正常', 1 , 'admin', '369bcfe480454d22a07a8644f6df0349'),
  ('d0f3a88d099642a498ab77c497c5165d', 13, '用户状态(yhzt)', '停用', 1 , 'admin', '369bcfe480454d22a07a8644f6df0349'),

  ('c536b35929b24a7b8fc5a01b04181259', 14, '数据状态(sjzt)', '逻辑删除(已经删除)', 1 , 'admin', '369bcfe480454d22a07a8644f6df0349'),
  ('ce15758ca04b4cb887a851b9e459fe68', 15, '数据状态(sjzt)', '逻辑删除(未删除)', 1 , 'admin', '369bcfe480454d22a07a8644f6df0349'),

  ('41c8973b5afe4f8a84820aa83b8fe6b7', 16, '积分商品状态(jfspzt)', '正常', 1 , 'admin', '369bcfe480454d22a07a8644f6df0349'),
  ('91b47bf061d34301be521fa283839cef', 17, '积分商品状态(jfspzt)', '已下架', 1 , 'admin', '369bcfe480454d22a07a8644f6df0349'),

  ('968294a4d44d46dd8775990144dfbf40', 18, '地址信息状态(dzxxzt)', '默认地址', 1 , 'admin', '369bcfe480454d22a07a8644f6df0349'),
  ('a1915e353bb54df4a32df0b9aae6fabf', 19, '地址信息状态(dzxxzt)', '非默认地址', 1 , 'admin', '369bcfe480454d22a07a8644f6df0349'),

  ('538fb84080d24ac9b1904f5270d33c85', 20, '性别状态(xbzt)', '男', 1 , 'admin',  '369bcfe480454d22a07a8644f6df0349'),
  ('9d73a5790dcd4cf2815cf8119976d116', 21, '性别状态(xbzt)', '女', 1 , 'admin',  '369bcfe480454d22a07a8644f6df0349'),

  ('6e90bca2a59d4f6ea4874820b7251536', 22, '操作状态(czzt)', '成功', 1 , 'admin', '369bcfe480454d22a07a8644f6df0349'),
  ('99fabb30ff9e47d4bf3db044c01ac85c', 23, '操作状态(czzt)', '失败', 1 , 'admin', '369bcfe480454d22a07a8644f6df0349'),

  ('ce374c948a334e21a25257ef858971a3', 24, '交易方式(jyfs)', '微信', 1 , 'admin', '369bcfe480454d22a07a8644f6df0349'),
  ('37e05f1636bd4d8080992b515b7fd344', 25, '交易方式(jyfs)', '支付宝', 1 , 'admin', '369bcfe480454d22a07a8644f6df0349'),
  ('0b7ebde2702b410aa2b14a408b99b75f', 26, '交易方式(jyfs)', '现金', 1 , 'admin', '369bcfe480454d22a07a8644f6df0349'),
  ('1ba5d4e14acc4edc9e8bbacc478d1603', 27, '交易方式(jyfs)', '刷卡', 1 , 'admin', '369bcfe480454d22a07a8644f6df0349'),

  ('763a480c51bc4d68ac49f6652d1bf0d2', 28, '菜单类型(cdlx)', '目录', 1 , 'admin', '369bcfe480454d22a07a8644f6df0349'),
  ('e72d13a4320b41d08452c127174e5392', 29, '菜单类型(cdlx)', '菜单', 1 , 'admin', '369bcfe480454d22a07a8644f6df0349'),
  ('6f07165f9bf54089b781d91f125283c7', 30, '菜单类型(cdlx)', '按钮', 1 , 'admin', '369bcfe480454d22a07a8644f6df0349'),

    ('7b780a0bf5eb46248fb77d800ad7024d', 31, '终端类型(zdlx)', '小程序', 1 , 'admin', '369bcfe480454d22a07a8644f6df0349'),
  ('b81a602284b44052ae1be0d5ebba9a2e', 32, '终端类型(zdlx)', 'app', 1 , 'admin', '369bcfe480454d22a07a8644f6df0349'),

    ('6eb0678757884a29870847a2a625526d', 33, '商品状态(spzt)', '上架', 1 , 'admin', '369bcfe480454d22a07a8644f6df0349'),
  ('fed74c098e4543be9b1c82da06f49985', 34, '商品状态(spzt)', '下架', 1 , 'admin', '369bcfe480454d22a07a8644f6df0349'),

  ('1ddc152f8ee44b6f90d86db9fc482fe0', 35, '出入账状态(crzzt)', '支出', 1 , 'admin', '369bcfe480454d22a07a8644f6df0349'),
  ('8623d4a600154cb888562038ec308821', 36, '出入账状态(crzzt)', '收入', 1 , 'admin', '369bcfe480454d22a07a8644f6df0349'),

    ('500ecc8e61924a80a7d2960016f6ada9', 37, '反馈处理状态(fkclzt)', '未处理', 1 , 'admin', '369bcfe480454d22a07a8644f6df0349'),
  ('03b799466fe546799cc1b127e46e983c', 38, '反馈处理状态(fkclzt)', '已处理', 1 , 'admin', '369bcfe480454d22a07a8644f6df0349'),

    ('eda45a148e0b430ba65cfa7479f2ed79', 39, 'app更新状态(appgxzt)', '无版本更新', 1 , 'admin', '369bcfe480454d22a07a8644f6df0349'),
  ('22d68c0e484b411e9b284f0941ff12cf', 40, 'app更新状态(appgxzt)', '有版本更新，不需要强制升级', 1 , 'admin', '369bcfe480454d22a07a8644f6df0349'),
  ('b93cc53a6675430da69c6f848dd3a500', 41, 'app更新状态(appgxzt)', '有版本更新，需要强制升级', 1 , 'admin', '369bcfe480454d22a07a8644f6df0349');


-- 初始化 账户表数据
insert into 
  `wjhs`.`account` (`id`, `user_type`, `user_id`, `balance`, `is_delete`) 
values 
  ('bdb449e9d322473d86fcbc7434ebb1ef', 0, '369bcfe480454d22a07a8644f6df0349', 994000, '15'),
  ('11d26e088cda47d581dd6290aec61bb7', 0, 'adbd5f0e46474696b65140568e43385e', 1000, '15'),
  ('caded86ddbb044fbbc6c5206e8dd5b80', 0, '796d300069384ee3abf3a318e879c5bd', 1000, '15'),
  ('ec9a069267ec4dc5a25aa3a2c5f0a741', 0, 'f2532e33786f4b8d9fa2db00f03352fb', 5000, '15');



-- 初始化 账户流水表数据
insert into 
  `wjhs`.`account_record` (`id`, `user_type_from`, `user_type_to`, `user_id_from`, `user_id_to`, `pay_status`, `trading_id`, `trading_money`, `trading_type`, `trading_note`,`is_delete`)  
values 
  ('e527eadfa76a46a48164ecedc65721fd', 2, 0, 'adbd5f0e46474696b65140568e43385e', '369bcfe480454d22a07a8644f6df0349', '35', null, 1000, 28, '用户注册，系统首次充值', '15'),
  ('5c29884bf9fc4a1abb29af95646594d8', 2, 0, '796d300069384ee3abf3a318e879c5bd', '369bcfe480454d22a07a8644f6df0349', '35', null, 1000, 28, '用户注册，系统首次充值', '15'),
  ('1331266bf62e47dbbfc277d098b25233', 3, 0, 'f2532e33786f4b8d9fa2db00f03352fb', '369bcfe480454d22a07a8644f6df0349', '35', null, 5000, 28, '用户注册，系统首次充值', '15');


insert into 
  `recycle_goods_type` (`id`, `name`, `describe`, `is_delete`, `status`)
values 
  ('1793fa07104e4cfab1b6e511fdba3d46', '库存积压', '回收各类积压物资回收，如库存布料、地毯、布头，服装卷筒布，服装下脚料。', '15', '33'),
  ('2a69cb12676e4eb2a8709deaeba7f693', '电子电器', '打印机、复印件、传真机、废旧电脑及配件、中央空调、手提电脑、冰箱、线路板、电子元件、洗衣机、发电机、电动机、点焊机、旧变压器等。', '14', '33'),
  ('3a5cd0e1300c47ccb1d57ea7a34429e6', '拆迁工程', '回收工程拆除、拆活动房、拆配电房、拆建筑废料、拆电线电缆。', '15', '34'),
  ('41b1ec1b9c7446c298884b3161d96f93', '宾馆酒店', '回收电视、电脑、冰柜、大型冷库，各类电器积压库存物资等。', '15', '34'),
  ('583f49bf209242ef8f6d228f5475e664', '工业废料', '回收模具贴、模具钢、铣刀等各工厂下脚料，建筑废料、拆迁废料、废电线电缆、水暖器材、管扣件及门窗材料。', '15', '33'),
  ('585453a37a1845f48b2cdc697b763734', '废纸', '回收报纸、书本、纸板等。', '15', '33'),
  ('5ff0a5ef474841c88d40cbab8d22b0d2', '电子电器', '回收打印机、复印件、传真机、废旧电脑及配件、中央空调、手提电脑、冰箱、线路板、电子元件、洗衣机、发电机、电动机、点焊机、旧变压器等。', '15', '33'),
  ('8c45f79831854dfa90a65001ac08844d', '有色金属', '回收废电线电缆、紫铜、黄铜、磷铜、青铜、红铜、漆包线铜、铜屑、铝合金等。', '15', '34'),
  ('9939ed8a838f4885b98593083af98cad', '稀有金属', '回收镁、镀金、镀银、钨丝、钨钢、锌、钛、镍、铬、铑、钼、锑、铟、钴粉、锡铋合金等。', '15', '34'),
  ('a2be382ef78b4b4ca2fa1bbd73dab01a', '塑料资源', '回收亚克力、聚氯乙烯、聚苯乙烯、聚乙烯、聚丙烯、abs料等塑料。', '15', '34'),
  ('b46745ddc3974d5cb2cfe1bac64616e6', '工业设备', '回收水暖冷冻设备、废旧化工设备、空调系统、机床、锅炉、贮罐、换热器、塔器、钛设备等一切废旧设备。', '15', '33');