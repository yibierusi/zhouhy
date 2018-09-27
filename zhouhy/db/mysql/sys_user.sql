/*
Navicat MySQL Data Transfer

Source Server         : zhouhy
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : root

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-09-27 17:17:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(64) NOT NULL COMMENT '用户ID',
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `nickname` varchar(32) DEFAULT NULL COMMENT '网名',
  `sex` varchar(2) DEFAULT NULL COMMENT '性别',
  `birth_date` datetime DEFAULT NULL COMMENT '生日',
  `ico` varchar(255) DEFAULT NULL COMMENT '头像',
  `signature` varchar(255) DEFAULT NULL COMMENT '签名',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(100) DEFAULT NULL COMMENT '手机',
  `mobile` varchar(100) DEFAULT NULL COMMENT '电话',
  `user_type` varchar(1) DEFAULT NULL COMMENT '用户类型',
  `user_state` varchar(1) DEFAULT NULL COMMENT '用户状态',
  `login_time` timestamp NULL DEFAULT NULL,
  `login_ip` varchar(15) DEFAULT NULL COMMENT '登录ip',
  `registered_time` datetime DEFAULT NULL COMMENT '注册时间',
  `registered_ip` varchar(15) DEFAULT NULL COMMENT '注册ip',
  `update_by` varchar(64) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `state` int(1) DEFAULT '0' COMMENT '0：未删除 1：删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'zhouhy', '111111', 'zhouhy', null, null, null, null, null, null, null, null, null, null, null, '2018-07-05 17:32:14', null, null, null, null, null);
