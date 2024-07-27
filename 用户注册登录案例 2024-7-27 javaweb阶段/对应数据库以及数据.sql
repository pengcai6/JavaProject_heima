/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80400
 Source Host           : localhost:3306
 Source Schema         : day17

 Target Server Type    : MySQL
 Target Server Version : 80400
 File Encoding         : 65001

 Date: 27/07/2024 18:18:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'zhangsan', '1234');
INSERT INTO `user` VALUES (2, 'lisi', '1234');
INSERT INTO `user` VALUES (3, 'wangwu', '1234');
INSERT INTO `user` VALUES (4, 'zhaoliu', '1234');
INSERT INTO `user` VALUES (5, 'cai', '1010 ');
INSERT INTO `user` VALUES (6, 'cai6', '123 ');
INSERT INTO `user` VALUES (7, '李博', '123 ');

SET FOREIGN_KEY_CHECKS = 1;
