/*
Navicat MySQL Data Transfer

Source Server         : zhouhy
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : root

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-09-27 17:16:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for photo_album
-- ----------------------------
DROP TABLE IF EXISTS `photo_album`;
CREATE TABLE `photo_album` (
  `id` varchar(64) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '相册ID',
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '相册名字',
  `content` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sys_user_id` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户ID',
  `photo_id` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '相册ID',
  `photo_path` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `reads` int(7) NOT NULL DEFAULT '0' COMMENT '阅读数',
  `comments` int(7) NOT NULL DEFAULT '0' COMMENT '评论数',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `state` int(1) DEFAULT '0' COMMENT '0：未删除 1：删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of photo_album
-- ----------------------------
INSERT INTO `photo_album` VALUES ('408a68a9dc854292aa981771e4eb087e', '文章图片', '文章图片', '1', null, null, '0', '0', null, null, '0');
INSERT INTO `photo_album` VALUES ('f84556c30c05482bb45293a837475928', '相册名册-测试数据', '相册简介-测试数据', '1', null, null, '0', '0', null, null, '0');
