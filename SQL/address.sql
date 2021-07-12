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
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `a_Account` varchar(100) NOT NULL,
  `a_Address1` varchar(100) NOT NULL,
  `a_Address2` varchar(100) DEFAULT NULL,
  `a_Address3` varchar(100) DEFAULT NULL,
  `a_Address4` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('user1', '福建省厦门市厦门大学思明校区', '福建省厦门市厦门大学翔安校区', '福建省厦门市厦门大学漳州校区', '福建省厦门市厦门大学马来校区');
INSERT INTO `address` VALUES ('user2', '福建省厦门市厦门大学思明校区', '福建省厦门市厦门大学翔安校区', '福建省厦门市厦门大学漳州校区', '福建省厦门市厦门大学马来校区');
INSERT INTO `address` VALUES ('user3', '福建省厦门市厦门大学思明校区', '福建省厦门市厦门大学漳州校区', '福建省厦门市厦门大学马来校区', '福建省厦门市厦门大学翔安校区');
INSERT INTO `address` VALUES ('admin', '无', '无', '无', '无');
