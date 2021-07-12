-- ----------------------------
--  Table structure for `shoppingcar`
-- ----------------------------
DROP TABLE IF EXISTS `shoppingcar`;
CREATE TABLE `shoppingcar` (
  `s_Id` int(100) NOT NULL AUTO_INCREMENT,
  `u_Account` varchar(255) DEFAULT NULL,
  `p_Id` int(100) DEFAULT NULL,
  PRIMARY KEY (`s_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
