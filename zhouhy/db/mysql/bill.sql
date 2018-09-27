/*
Navicat MySQL Data Transfer

Source Server         : zhouhy
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : root

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-09-27 17:16:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bill
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill` (
  `id` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT 'ID',
  `date` int(8) DEFAULT NULL COMMENT '时间，20180920',
  `paid` double(7,0) DEFAULT '0' COMMENT '支出',
  `max_paid` double(7,0) DEFAULT NULL COMMENT '最大支出',
  `max_paid_explain` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `income` double(7,0) DEFAULT '0' COMMENT '收入',
  `max_income` double(7,0) DEFAULT NULL COMMENT '最大收入',
  `max_income_explain` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '最大收入说明',
  `status` int(1) DEFAULT '1' COMMENT '状态 1：正常  2：异常  3：警告',
  `sys_user_id` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of bill
-- ----------------------------
INSERT INTO `bill` VALUES ('1', '20180921', '138', '50', '烟', null, '0', '无', '1', '1');
INSERT INTO `bill` VALUES ('2', '20180922', '57', '20', '早餐', null, '0', null, '1', '1');
INSERT INTO `bill` VALUES ('3', '20180923', '45', '18', '早餐', null, '0', null, '1', '1');
INSERT INTO `bill` VALUES ('4', '20180924', '125', '42', '烟', null, '0', null, '1', '1');
INSERT INTO `bill` VALUES ('5', '20180925', '56', '20', '午餐', null, '0', null, '1', '1');
INSERT INTO `bill` VALUES ('5c75413355ad465584319da193ecb0ca', '20180927', '48', '21', '午餐', null, null, null, '1', '1');
INSERT INTO `bill` VALUES ('ba8a8eb477bd4d0e9b5c0f45a167eb1c', '20180926', '153', '69', '服务器购买', null, null, null, '1', '1');
