/*
Navicat MySQL Data Transfer

Source Server         : zhouhy
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : root

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-09-27 17:16:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for photo
-- ----------------------------
DROP TABLE IF EXISTS `photo`;
CREATE TABLE `photo` (
  `id` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '照片ID',
  `photo_album_id` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '相册ID',
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '照片名字',
  `path` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '路径',
  `suffix` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '后缀',
  `bytes` int(11) DEFAULT NULL COMMENT '大小',
  `content` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '博客具体内容',
  `reads` int(7) NOT NULL DEFAULT '0' COMMENT '阅读数',
  `comments` int(7) NOT NULL DEFAULT '0' COMMENT '评论数',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `state` int(1) NOT NULL DEFAULT '0' COMMENT '0：未删除  1：删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of photo
-- ----------------------------
INSERT INTO `photo` VALUES ('01d7599e242c45fdbcb6506265acc60f', '408a68a9dc854292aa981771e4eb087e', 'hexo', '/upload/photo/zhouhy/408a68a9dc854292aa981771e4eb087e/1536302323838.jpg', 'jpg', null, null, '0', '0', null, null, '0');
INSERT INTO `photo` VALUES ('3c5e7352fb29458aae03ad35a6db1e50', '408a68a9dc854292aa981771e4eb087e', 'markdownpad2_1', '/upload/photo/zhouhy/408a68a9dc854292aa981771e4eb087e/1536302482827.jpg', 'jpg', null, null, '0', '0', null, null, '0');
INSERT INTO `photo` VALUES ('5506335350db4a038ee914f12a62bfb9', '408a68a9dc854292aa981771e4eb087e', 'markdownpad2_3', '/upload/photo/zhouhy/408a68a9dc854292aa981771e4eb087e/1536302482827.jpg', 'jpg', null, null, '0', '0', null, null, '0');
INSERT INTO `photo` VALUES ('a7a4877df59741ca8a592278899f0a86', '408a68a9dc854292aa981771e4eb087e', 'markdownpad2_2', '/upload/photo/zhouhy/408a68a9dc854292aa981771e4eb087e/1536302482831.jpg', 'jpg', null, null, '0', '0', null, null, '0');
INSERT INTO `photo` VALUES ('b06ba15fd8664f27b102219513415471', '408a68a9dc854292aa981771e4eb087e', 'markdownpad2_4', '/upload/photo/zhouhy/408a68a9dc854292aa981771e4eb087e/1536302482831.jpg', 'jpg', null, null, '0', '0', null, null, '0');
INSERT INTO `photo` VALUES ('faf07c8a744549e8b1b440016d2072c2', 'f84556c30c05482bb45293a837475928', '2', '/upload/photo/zhouhy/f84556c30c05482bb45293a837475928/1536291908961.jpg', 'jpg', null, null, '0', '0', null, null, '0');
