/*
Navicat MySQL Data Transfer

Source Server         : zhouhy
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : root

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-09-27 17:16:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bill_detail
-- ----------------------------
DROP TABLE IF EXISTS `bill_detail`;
CREATE TABLE `bill_detail` (
  `id` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '账单明细ID',
  `type` tinyint(1) DEFAULT NULL COMMENT '类型：1支出  2  收入',
  `money` int(11) DEFAULT NULL COMMENT '金额',
  `bill_id` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '账单ID',
  `bill_tag_ids` text COLLATE utf8_unicode_ci COMMENT '标签ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of bill_detail
-- ----------------------------
INSERT INTO `bill_detail` VALUES ('018beb2ff76649ea876c03fede1a72b4', '1', '4', '5c75413355ad465584319da193ecb0ca', '1');
INSERT INTO `bill_detail` VALUES ('05b9d7000c5f44e2b8ab2abf4d160bbc', '1', '1111', null, 'abc269f020e842f59b07f82b4226154e');
INSERT INTO `bill_detail` VALUES ('1', '1', '19', '1', '2');
INSERT INTO `bill_detail` VALUES ('10', '1', '18', '3', '5');
INSERT INTO `bill_detail` VALUES ('11', '1', '14', '3', '4');
INSERT INTO `bill_detail` VALUES ('14', '1', '42', '4', '2');
INSERT INTO `bill_detail` VALUES ('15', '1', '18', '4', '5');
INSERT INTO `bill_detail` VALUES ('16', '1', '13', '3', '8');
INSERT INTO `bill_detail` VALUES ('16b6db9d748d4e019ff9767775439bb0', null, '0', null, null);
INSERT INTO `bill_detail` VALUES ('17', '1', '30', '4', '4');
INSERT INTO `bill_detail` VALUES ('18', '1', '35', '4', '9');
INSERT INTO `bill_detail` VALUES ('19', '1', '4', '5', '1');
INSERT INTO `bill_detail` VALUES ('1e9ebdbcb8f1457ba6fa30f7c3942cbe', '1', '1111', null, 'abc269f020e842f59b07f82b4226154e');
INSERT INTO `bill_detail` VALUES ('1fae38d6c5eb4d6bbeab1b189d00a3db', '1', '4', '1', '1');
INSERT INTO `bill_detail` VALUES ('2', '1', '3', '1', '1');
INSERT INTO `bill_detail` VALUES ('20', '1', '4', '5', '1');
INSERT INTO `bill_detail` VALUES ('21', '1', '20', '5', '3');
INSERT INTO `bill_detail` VALUES ('26d4ee11d646498abd6bc668ef31a786', '1', '28', 'ba8a8eb477bd4d0e9b5c0f45a167eb1c', '3');
INSERT INTO `bill_detail` VALUES ('2a4e021654d54ad1993e0c89ad3a3b39', '1', '4', '5c75413355ad465584319da193ecb0ca', '1');
INSERT INTO `bill_detail` VALUES ('2ecb7beac25347e994e5f229a7ff8910', '1', '69', 'ba8a8eb477bd4d0e9b5c0f45a167eb1c', '93dab082e8e24b52b746b1530f34dfeb');
INSERT INTO `bill_detail` VALUES ('3', '1', '27', '1', '3');
INSERT INTO `bill_detail` VALUES ('4', '1', '35', '1', '4');
INSERT INTO `bill_detail` VALUES ('5', '1', '50', '1', '2');
INSERT INTO `bill_detail` VALUES ('6', '1', '10', '2', '6');
INSERT INTO `bill_detail` VALUES ('685f50a2b1314a0d9b4d3be301c99ccc', '1', '10', 'ba8a8eb477bd4d0e9b5c0f45a167eb1c', '7efa4261dfdb4382946d3e876b8f6726');
INSERT INTO `bill_detail` VALUES ('7', '1', '20', '2', '5');
INSERT INTO `bill_detail` VALUES ('71fe9576093044a0a44b2921bccd8757', null, '0', null, null);
INSERT INTO `bill_detail` VALUES ('76ba3ce9296b4235b081e7d666cdba8e', null, '0', null, null);
INSERT INTO `bill_detail` VALUES ('7855debfa5454669bf3844b28930cffd', '1', '19', '5c75413355ad465584319da193ecb0ca', '2');
INSERT INTO `bill_detail` VALUES ('8', '1', '15', '2', '7');
INSERT INTO `bill_detail` VALUES ('89a6320e6a184196a4fe05a8541febc4', '1', '18', 'ba8a8eb477bd4d0e9b5c0f45a167eb1c', '2');
INSERT INTO `bill_detail` VALUES ('8bbfed48bde4412786ab14f963364457', '1', '21', '5c75413355ad465584319da193ecb0ca', '3');
INSERT INTO `bill_detail` VALUES ('9', '1', '12', '2', '4');
INSERT INTO `bill_detail` VALUES ('96616fb3189948afa57846247f7333ff', null, '0', null, null);
INSERT INTO `bill_detail` VALUES ('988c46644ffd4426a90bef6cbe709f57', '1', '4', 'ba8a8eb477bd4d0e9b5c0f45a167eb1c', '1');
INSERT INTO `bill_detail` VALUES ('aa009a125a83424e8a3e8198bab2867a', null, '0', null, null);
INSERT INTO `bill_detail` VALUES ('c564638ddfe344819d95c09f41873f39', '1', '13', '5', '4');
INSERT INTO `bill_detail` VALUES ('d39d2dfb4d0844efa0bcb67460505bd1', '1', '15', '5', '2f2b0029cf56496186f51fa92b77141a');
INSERT INTO `bill_detail` VALUES ('d9449e061cbd405b96b41a4476e99aa1', '1', '4', 'ba8a8eb477bd4d0e9b5c0f45a167eb1c', '1');
INSERT INTO `bill_detail` VALUES ('e6f2f93d05374d32a966c61a925a4e9f', '1', '1111', null, '2f2b0029cf56496186f51fa92b77141a,abc269f020e842f59b07f82b4226154e');
INSERT INTO `bill_detail` VALUES ('f0a327942bb24406810c81017f400c7d', '1', '1111', null, 'abc269f020e842f59b07f82b4226154e');
INSERT INTO `bill_detail` VALUES ('fce0c40720f94790b0c58bd46b9bf659', '1', '20', 'ba8a8eb477bd4d0e9b5c0f45a167eb1c', '4');
