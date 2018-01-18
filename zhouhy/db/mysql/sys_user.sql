/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : zhou

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2018-01-18 10:39:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `nickname` varchar(100) DEFAULT NULL,
  `sex` varchar(100) DEFAULT NULL,
  `birth_date` timestamp NULL DEFAULT NULL,
  `ico` varchar(400) DEFAULT NULL,
  `signature` varchar(400) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone` varchar(100) DEFAULT NULL,
  `mobile` varchar(100) DEFAULT NULL,
  `user_type` varchar(100) DEFAULT NULL,
  `user_state` varchar(100) DEFAULT NULL,
  `login_time` timestamp NULL DEFAULT NULL,
  `login_ip` varchar(100) DEFAULT NULL,
  `registered_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `registered_ip` varchar(100) DEFAULT NULL,
  `update_by` varchar(100) DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `del_flag` char(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
