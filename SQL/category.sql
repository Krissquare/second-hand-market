/*
Navicat MySQL Data Transfer

Source Server         : wyq
Source Server Version : 50627
Source Host           : localhost:3306
Source Database       : secondhand

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

Date: 2020-12-14 22:59:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `c_Id` varchar(100) NOT NULL,
  `c_Name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`c_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('c01', '书籍教材');
INSERT INTO `category` VALUES ('c02', '电子产品');
INSERT INTO `category` VALUES ('c03', '代步工具');
INSERT INTO `category` VALUES ('c04', '衣帽鞋伞');
INSERT INTO `category` VALUES ('c05', '体育健身');
INSERT INTO `category` VALUES ('c06', '家用电器');
INSERT INTO `category` VALUES ('c07', '虚拟产品');
INSERT INTO `category` VALUES ('c08', '手工设计');
INSERT INTO `category` VALUES ('c09', '日常用品');
INSERT INTO `category` VALUES ('c10', '音乐器材');
