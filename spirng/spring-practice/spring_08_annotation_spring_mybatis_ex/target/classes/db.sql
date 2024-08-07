DROP TABLE IF EXISTS `tbl_account`;
CREATE TABLE `tbl_account`  (
                                `id` int(11) NOT NULL AUTO_INCREMENT,
                                `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                                `money` double(12, 0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


INSERT INTO `tbl_account` VALUES (1, 'Tom', 1000);
INSERT INTO `tbl_account` VALUES (2, 'Jerry', 1000);