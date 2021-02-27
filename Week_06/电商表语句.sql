CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `proid` int(11) DEFAULT NULL COMMENT '商品id',
  `count` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '数量',
  `singleprice` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '单价',
  `price` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '总价',
  `userid` int(11) DEFAULT NULL COMMENT '购买者',
  `sffk` int(2) DEFAULT '0' COMMENT '是否支付',
  `tel` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '联系电话',
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '送货地址',
  `date` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '下单日期',
  `senddept` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '快递公司',
  `visible` int(2) DEFAULT '1' COMMENT '是否可见',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COMMENT='订单表';


CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `img` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `content` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `price` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `sfcx` int(2) DEFAULT '0' COMMENT '是否促销',
  `newprice` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '促销价',
  `sfms` int(2) DEFAULT '0' COMMENT '是否秒杀',
  `msprice` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '秒杀价格',
  `msdate` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '秒杀时间',
  `mscount` int(5) DEFAULT NULL COMMENT '秒杀数量',
  `sfjp` int(2) DEFAULT '0' COMMENT '是否竞拍',
  `qpprice` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '起拍价',
  `jpprice` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '竞拍价',
  `jpperson` int(11) DEFAULT NULL COMMENT '竞拍人',
  `jpdate` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '竞拍结束时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB   DEFAULT CHARSET=utf8mb4 COMMENT='产品表';


CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱',
  `sex` int(2) DEFAULT '0' COMMENT '性别',
  `admin` int(2) DEFAULT '0' COMMENT '是否管理员',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB   DEFAULT CHARSET=utf8mb4 COMMENT='用户表';