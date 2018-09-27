/*
Navicat MySQL Data Transfer

Source Server         : zhouhy
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : root

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-09-27 17:16:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bill_tag
-- ----------------------------
DROP TABLE IF EXISTS `bill_tag`;
CREATE TABLE `bill_tag` (
  `id` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '标签ID',
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '标签名字',
  `explain` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '标签说明',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `sys_user_id` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of bill_tag
-- ----------------------------
INSERT INTO `bill_tag` VALUES ('1', '地铁出行', '出行', '2018-09-21 00:00:00', '2018-09-21 00:00:00', '1');
INSERT INTO `bill_tag` VALUES ('2', '烟', '消费', '2018-09-21 00:00:00', '2018-09-21 00:00:00', '1');
INSERT INTO `bill_tag` VALUES ('2f2b0029cf56496186f51fa92b77141a', '饮用水', null, '2018-09-27 00:00:00', '2018-09-27 00:00:00', '1');
INSERT INTO `bill_tag` VALUES ('3', '午餐', '饮食', '2018-09-21 00:00:00', '2018-09-21 00:00:00', '1');
INSERT INTO `bill_tag` VALUES ('4', '晚餐', '饮食', '2018-09-25 00:00:00', '2018-09-25 00:00:00', '1');
INSERT INTO `bill_tag` VALUES ('5', '早餐', '饮食', '2018-09-25 00:00:00', '2018-09-25 00:00:00', '1');
INSERT INTO `bill_tag` VALUES ('6', '饿了么会员', '充值', '2018-09-25 00:00:00', '2018-09-25 00:00:00', '1');
INSERT INTO `bill_tag` VALUES ('7', '剑灵充值', '充值', '2018-09-25 00:00:00', '2018-09-25 00:00:00', '1');
INSERT INTO `bill_tag` VALUES ('7efa4261dfdb4382946d3e876b8f6726', '打的', null, '2018-09-27 00:00:00', '2018-09-27 00:00:00', '1');
INSERT INTO `bill_tag` VALUES ('8', '零食', '消费', '2018-09-25 00:00:00', '2018-09-25 00:00:00', '1');
INSERT INTO `bill_tag` VALUES ('9', '分线器', '购物', '2018-09-25 00:00:00', '2018-09-25 00:00:00', '1');
INSERT INTO `bill_tag` VALUES ('93dab082e8e24b52b746b1530f34dfeb', '服务器购买', null, '2018-09-27 00:00:00', '2018-09-27 00:00:00', '1');
INSERT INTO `bill_tag` VALUES ('abc269f020e842f59b07f82b4226154e', '测试数据', null, '2018-09-27 00:00:00', '2018-09-27 00:00:00', '1');
