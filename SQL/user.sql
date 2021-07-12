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
  `u_Email` varchar(100) DEFAULT NULL,
  `u_Phone` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`u_Account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('user1', '王五', '123456', '男', '123456@qq.com', '12345678910');
INSERT INTO `user` VALUES ('user2', '张三', '123456', '女', '123456@qq.com', '12345678910');
INSERT INTO `user` VALUES ('user3', '李四', '123456', '男', '123456@qq.com', '12345678910');
INSERT INTO `user` VALUES ('admin', '雷鸿宇', '123456', null, null, null);
