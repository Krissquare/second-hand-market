/*
Navicat MySQL Data Transfer

Source Server         : wyq
Source Server Version : 50627
Source Host           : localhost:3306
Source Database       : secondhand

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

Date: 2020-12-14 22:59:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for attribute
-- ----------------------------
DROP TABLE IF EXISTS `attribute`;
CREATE TABLE `attribute` (
  `a_Account` varchar(100) NOT NULL,
  `p_Id` varchar(100) DEFAULT NULL,
  `a_Brand` varchar(100) DEFAULT NULL,
  `a_BuyTime` date DEFAULT NULL,
  `a_view` varchar(100) DEFAULT NULL,
  `a_Value` double DEFAULT NULL,
  PRIMARY KEY (`a_Account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attribute
-- ----------------------------
