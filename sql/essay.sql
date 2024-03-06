use techmindwave;
DROP TABLE IF EXISTS `essay`;
CREATE TABLE `essay`  (
                          `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
                          `essayName` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '文章名称',
                          `essayType` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '文章类型',
                          `genEssay` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '生成的文章内容',
                          `userId` bigint(20) NULL DEFAULT NULL COMMENT '创建文章用户 id',
                          `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                          `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                          `isDelete` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否删除',
                          PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1731623236617977858 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '文章信息表' ROW_FORMAT = DYNAMIC;