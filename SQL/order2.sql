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
-- Table structure for order2
-- ----------------------------
DROP TABLE IF EXISTS `order2`;
CREATE TABLE `order2` (
  `o_Id` varchar(100) NOT NULL,
  `o_ItemId` int(255) DEFAULT NULL,
  `o_Seller` varchar(100) DEFAULT NULL,
  `o_Buyer` varchar(100) DEFAULT NULL,
  `o_Baddress` varchar(100) DEFAULT NULL,
  `o_Saddress` varchar(100) DEFAULT NULL,
  `o_Date` date DEFAULT NULL,
  `o_Status` enum('已完成','待交易') DEFAULT NULL,
  PRIMARY KEY (`o_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order2
-- ----------------------------
INSERT INTO `order2` VALUES ('o01', '01', 'user1', 'user2', '福建省厦门市厦门大学翔安校区', '福建省厦门市厦门大学翔安校区', '2021-7-5', '待交易');
INSERT INTO `order2` VALUES ('o02', '02', 'user1', 'user2', '福建省厦门市厦门大学翔安校区', '福建省厦门市厦门大学翔安校区', '2021-7-5', '已完成');
INSERT INTO `order2` VALUES ('o03', '03', 'user1', 'user2', '福建省厦门市厦门大学翔安校区', '福建省厦门市厦门大学翔安校区', '2021-7-5', '待交易');
INSERT INTO `order2` VALUES ('o04', '04', 'user1', 'user2', '福建省厦门市厦门大学翔安校区', '福建省厦门市厦门大学翔安校区', '2021-7-5', '已完成');
INSERT INTO `order2` VALUES ('o05', '05', 'user1', 'user2', '福建省厦门市厦门大学翔安校区', '福建省厦门市厦门大学翔安校区', '2021-7-5', '待交易');
INSERT INTO `order2` VALUES ('o06', '05', 'user1', 'user2', '福建省厦门市厦门大学翔安校区', '福建省厦门市厦门大学翔安校区', '2021-7-5', '已完成');
INSERT INTO `order2` VALUES ('o07', '07', 'user1', 'user2', '福建省厦门市厦门大学翔安校区', '福建省厦门市厦门大学翔安校区', '2021-7-5', '待交易');
INSERT INTO `order2` VALUES ('o08', '08', 'user1', 'user2', '福建省厦门市厦门大学翔安校区', '福建省厦门市厦门大学翔安校区', '2021-7-5', '已完成');
INSERT INTO `order2` VALUES ('o09', '09', 'user1', 'user2', '福建省厦门市厦门大学翔安校区', '福建省厦门市厦门大学翔安校区', '2021-7-5', '待交易');
INSERT INTO `order2` VALUES ('o10', '10', 'user1', 'user2', '福建省厦门市厦门大学翔安校区', '福建省厦门市厦门大学翔安校区', '2021-7-5', '已完成');
