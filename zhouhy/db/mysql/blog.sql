/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : zhou

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2018-01-18 10:30:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` varchar(100) NOT NULL,
  `title` varchar(500) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `author_id` varchar(100) DEFAULT NULL,
  `read_count` int(10) DEFAULT '1',
  `comment_count` int(10) DEFAULT '1',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `del_flag` char(255) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
