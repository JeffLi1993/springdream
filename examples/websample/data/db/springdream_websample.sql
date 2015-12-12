/*
Navicat MySQL Data Transfer

Source Server         : MS
Source Server Version : 50703
Source Host           : localhost:3306
Source Database       : springdream_websample

Target Server Type    : MYSQL
Target Server Version : 50703
File Encoding         : 65001

Date: 2015-12-13 00:42:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(64) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'jeff', '8b877c1524e8972863faaf9347cf5b7f', 'bysocket@aliyun.com', '13958686678');
INSERT INTO `user` VALUES ('2', '123', '123', '123@qq.com', '123');
