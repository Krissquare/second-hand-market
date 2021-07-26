/*
Navicat MySQL Data Transfer

Source Server         : lhy
Source Server Version : 50627
Source Host           : localhost:3306
Source Database       : secondhandmarket

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `u_Account` varchar(100) NOT NULL,
  `u_Name` varchar(100) DEFAULT NULL,
  `u_Password` varchar(100) DEFAULT NULL,
  `u_Sex` varchar(10) DEFAULT NULL,
  `u_Email` varchar(100) not null unique ,
  `u_Phone` varchar(100) DEFAULT NULL,
  `wallet` double not null default 0,
  PRIMARY KEY (`u_Account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('user1', '王五', '123456', '男', '1234@qq.com', '12345678910', 50000);
INSERT INTO `user` VALUES ('user2', '张三', '123456', '女', '12345@qq.com', '12345678910', 50000);
INSERT INTO `user`(`u_Account`,`u_Name`,`u_Password`,`u_Sex`,`u_Email`,`u_Phone`) VALUES ('user3', '李四', '123456', '男', '123456@qq.com', '12345678910');
INSERT INTO `user` VALUES ('admin', '雷鸿宇', '123456', null, '123@qq.com', null,1000000);
