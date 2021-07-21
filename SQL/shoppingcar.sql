-- ----------------------------
--  Table structure for `shoppingcar`
-- ----------------------------
DROP TABLE IF EXISTS `shoppingcar`;
CREATE TABLE `shoppingcar` (
  `s_Id` int(100) NOT NULL AUTO_INCREMENT,
  `u_Account` varchar(255) DEFAULT NULL,
  `p_Id` int(100) DEFAULT NULL,
  `p_Num` int(100) DEFAULT null ,
  PRIMARY KEY (`s_Id`),
  foreign key(p_Id) references product(p_Id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
