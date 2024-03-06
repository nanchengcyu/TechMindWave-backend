/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3308
 Source Server Type    : MySQL
 Source Server Version : 50737
 Source Host           : localhost:3308
 Source Schema         : nanchengbi

 Target Server Type    : MySQL
 Target Server Version : 50737
 File Encoding         : 65001

 Date: 25/08/2023 15:41:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ai_assistant
-- ----------------------------
DROP TABLE IF EXISTS `ai_assistant`;
CREATE TABLE `ai_assistant`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `questionName` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '问题名称',
  `questionGoal` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '问题概述',
  `questionResult` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '问答结果',
  `questionType` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '问题类型',
  `questionStatus` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'wait' COMMENT 'wait-等待,running-生成中,succeed-成功生成,failed-生成失败',
  `execMessage` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '执行信息',
  `userId` bigint(20) NULL DEFAULT NULL COMMENT '创建用户 id',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `isDelete` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1692864684501274626 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'AI 问答助手信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ai_assistant
-- ----------------------------
INSERT INTO `ai_assistant` VALUES (1690580971562217474, '你好', '你好', '', '', 'wait', NULL, 1690580805534887938, '2023-08-13 12:28:07', '2023-08-13 12:28:07', 0);
INSERT INTO `ai_assistant` VALUES (1690652344754216962, '如何学习做人', '如何学习做人', NULL, '如何学习做人', 'failed', NULL, 1690592362125934594, '2023-08-13 17:11:44', '2023-08-13 17:12:53', 1);
INSERT INTO `ai_assistant` VALUES (1690750131567161345, '你好', '你好', '你好！有什么我可以帮助你的问题吗？', '你好', 'succeed', NULL, 1690592362125934594, '2023-08-13 23:40:18', '2023-08-13 23:40:20', 0);
INSERT INTO `ai_assistant` VALUES (1690751050283315201, '我想要一份简历，你能生成吗', '我想要一份简历，你能生成吗', '当然可以帮你生成简历！以下是一份简单的简历模板，你可以按照自己的需求进行修改和填写。\n\n========================\n姓名：\n联系方式：\n地址：\n邮箱：\n\n教育背景：\n- 学历：（填写你的学历）\n- 毕业院校：（填写你的毕业院校）\n- 专业：（填写你的专业）\n- 在校经历或荣誉：（在校期间的活动、实习、奖项等）\n\n工作经历：\n- 公司名称：\n- 职位：\n- 工作时间：\n- 工作职责和成就：（简要描述你在该职位上承担的工作任务和取得的成绩）\n\n技能和特长：\n- 语言技能：（列举你精通的语言，如中文、英文等）\n- 技术技能：（列举你掌握的技能，如计算机操作、编程语言、软件应用等）\n- 其他特长：（列举你的其他特长或才能）\n\n个人项目：\n- 在校或工作期间参与的个人项目，包括项目名称、角色和贡献等。\n\n个人简介：\n- 简要介绍自己的个人特点、兴趣爱好和职业目标等。\n\n参考资料：\n- 提供1-2个人参考资料（如导师、主管等），包括姓名、职位、联系方式等。\n\n========================\n\n请根据自己的实际情况，将模板中的内容填写完整。祝你成功地制作出一份优秀的简历！如果还有其他问题，我很乐意帮助你。', '我想要一份简历，你能生成吗', 'succeed', NULL, 1690592362125934594, '2023-08-13 23:43:57', '2023-08-13 23:44:10', 0);
INSERT INTO `ai_assistant` VALUES (1690751134173589506, '我想要一份简历，你能生成吗', '我想要一份简历，你能生成吗', '当然可以！我可以帮你生成一份简历。请告诉我你的个人信息，包括姓名、联系方式、教育背景、工作经历和技能。我将根据这些信息为你生成一份专业的简历。', '我想要一份简历，你能生成吗', 'succeed', NULL, 1690592362125934594, '2023-08-13 23:44:17', '2023-08-13 23:44:20', 0);
INSERT INTO `ai_assistant` VALUES (1690751139252891650, '我想要一份简历，你能生成吗', '我想要一份简历，你能生成吗', NULL, '我想要一份简历，你能生成吗', 'failed', NULL, 1690592362125934594, '2023-08-13 23:44:18', '2023-08-13 23:45:24', 1);
INSERT INTO `ai_assistant` VALUES (1690751163953147906, '我想要一份简历，你能生成吗', '我想要一份简历，你能生成吗', '当然可以！请提供以下信息，我将帮您生成一份简历： \n1. 姓名\n2. 联系信息（电话号码和电子邮件地址）\n3. 教育背景（学历、学校名称、就读时间）\n4. 工作经验（公司名称、职位、工作时间，可附上主要职责和成就）\n5. 技能（具备的技能、证书或培训）\n6. 个人简介（个人特点、职业目标）\n请提供上述信息后，我将尽快帮您生成一份简历。', '我想要一份简历，你能生成吗', 'succeed', NULL, 1690592362125934594, '2023-08-13 23:44:24', '2023-08-13 23:45:33', 1);
INSERT INTO `ai_assistant` VALUES (1691395065563369473, '你好啊', '你好啊', '你好！有什么问题我可以帮你解答呢？', '你好啊', 'succeed', NULL, 1690946228361175042, '2023-08-15 18:23:02', '2023-08-15 18:23:06', 0);
INSERT INTO `ai_assistant` VALUES (1692864281038589953, 'hello', 'hello', 'Hello! How can I assist you today?', 'hello', 'succeed', NULL, 1690946228361175042, '2023-08-19 19:41:11', '2023-08-19 19:41:11', 0);
INSERT INTO `ai_assistant` VALUES (1692864684501274625, 'hello', 'hello', 'Hello! How can I help you today?', 'hello\n', 'succeed', NULL, 1690946228361175042, '2023-08-19 19:42:47', '2023-08-19 19:42:47', 0);

-- ----------------------------
-- Table structure for ai_frequency
-- ----------------------------
DROP TABLE IF EXISTS `ai_frequency`;
CREATE TABLE `ai_frequency`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `userId` bigint(20) NOT NULL COMMENT '用户 id',
  `totalFrequency` bigint(20) NOT NULL DEFAULT 0 COMMENT '总调用次数',
  `remainFrequency` int(11) NOT NULL DEFAULT 5 COMMENT '剩余调用次数',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `isDelete` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1690946228424089602 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'ai调用次数表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ai_frequency
-- ----------------------------
INSERT INTO `ai_frequency` VALUES (1690580805534887939, 1690580805534887938, 0, 5, '2023-08-13 12:27:28', '2023-08-13 12:27:28', 0);
INSERT INTO `ai_frequency` VALUES (1690592362155294721, 1690592362125934594, 4, 1, '2023-08-13 13:13:23', '2023-08-13 13:13:23', 0);
INSERT INTO `ai_frequency` VALUES (1690741578617942019, 1690741578617942018, 0, 5, '2023-08-13 23:06:19', '2023-08-13 23:06:19', 0);
INSERT INTO `ai_frequency` VALUES (1690946228424089601, 1690946228361175042, 4, 1, '2023-08-14 12:39:31', '2023-08-14 12:39:31', 0);

-- ----------------------------
-- Table structure for ai_frequency_order
-- ----------------------------
DROP TABLE IF EXISTS `ai_frequency_order`;
CREATE TABLE `ai_frequency_order`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `userId` bigint(20) NOT NULL COMMENT '用户 id',
  `purchaseQuantity` bigint(20) NOT NULL COMMENT '购买数量',
  `price` float(255, 2) NOT NULL COMMENT '单价',
  `totalAmount` float(10, 2) NOT NULL COMMENT '交易金额',
  `orderStatus` int(11) NOT NULL DEFAULT 0 COMMENT '交易状态【0->待付款；1->已完成；2->无效订单,3->删除订单】',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `isDelete` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1692066442121330690 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '次数订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ai_frequency_order
-- ----------------------------
INSERT INTO `ai_frequency_order` VALUES (1690750380054507521, 1690592362125934594, 5, 0.10, 0.50, 2, '2023-08-13 23:41:17', '2023-08-14 09:15:08', 0);
INSERT INTO `ai_frequency_order` VALUES (1691346191431847938, 1690946228361175042, 1, 0.10, 0.10, 2, '2023-08-15 15:08:50', '2023-08-15 15:18:50', 0);
INSERT INTO `ai_frequency_order` VALUES (1692066442121330689, 1690946228361175042, 1, 0.10, 0.10, 2, '2023-08-17 14:50:51', '2023-08-17 15:00:51', 0);

-- ----------------------------
-- Table structure for alipay_info
-- ----------------------------
DROP TABLE IF EXISTS `alipay_info`;
CREATE TABLE `alipay_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `userId` bigint(20) NOT NULL COMMENT '用户 id',
  `alipayAccountNo` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '支付宝流水账号',
  `alipayId` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '支付宝唯一id',
  `orderId` bigint(20) NULL DEFAULT NULL COMMENT '订单id',
  `totalAmount` float(10, 2) NOT NULL COMMENT '交易金额',
  `payStatus` int(11) NOT NULL DEFAULT 0 COMMENT '交易状态【0->未支付；1->已完成；2->支付失败】',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '支付时间',
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `isDelete` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1692067475182600194 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '次数订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of alipay_info
-- ----------------------------
INSERT INTO `alipay_info` VALUES (1690750426309292033, 1690592362125934594, '1690750426310000640', NULL, 1690750380054507521, 10000.00, 0, '2023-08-13 23:41:28', '2023-08-13 23:45:53', 0);
INSERT INTO `alipay_info` VALUES (1692066470323830786, 1690946228361175042, '1692066470320254976', NULL, 1692066442121330689, 0.10, 0, '2023-08-17 14:50:58', '2023-08-17 14:50:58', 0);
INSERT INTO `alipay_info` VALUES (1692067475182600193, 1690946228361175042, '1692067475237744640', NULL, 1692066442121330689, 0.10, 0, '2023-08-17 14:54:57', '2023-08-17 14:54:57', 0);

-- ----------------------------
-- Table structure for chart
-- ----------------------------
DROP TABLE IF EXISTS `chart`;
CREATE TABLE `chart`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `goal` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '分析目标',
  `chartName` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '图表名称',
  `chartData` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '图表数据',
  `chartType` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '图表类型',
  `genChart` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '生成的图表信息',
  `genResult` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '生成的分析结论',
  `chartStatus` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'wait' COMMENT 'wait-等待,running-生成中,succeed-成功生成,failed-生成失败',
  `execMessage` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '执行信息',
  `userId` bigint(20) NULL DEFAULT NULL COMMENT '创建图标用户 id',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `isDelete` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1692864147542282242 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '图表信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of chart
-- ----------------------------
INSERT INTO `chart` VALUES (1690652196070334465, 'nanchengyu网站数据分析', 'nanchengyu', '日期,用户数量\n1,20\n2,40\n3,600\n', '玫瑰图', '{\n  \"tooltip\": {},\n  \"series\": [\n    {\n      \"name\": \"用户数量\",\n      \"type\": \"pie\",\n      \"data\": [\n        {\"value\": 20, \"name\": \"1\"},\n        {\"value\": 40, \"name\": \"2\"},\n        {\"value\": 600, \"name\": \"3\"}\n      ],\n      \"roseType\": \"radius\",\n      \"label\": {\n        \"show\": true,\n        \"position\": \"inside\"\n      },\n      \"emphasis\": {\n        \"itemStyle\": {\n          \"shadowBlur\": 10,\n          \"shadowOffsetX\": 0,\n          \"shadowColor\": \"rgba(0, 0, 0, 0.5)\"\n        }\n      }\n    }\n  ]\n}', '根据数据分析结果，可以看出nanchengyu网站的用户数量在第3天出现了显著增长，从40增加到了600。这表明在第3天有大量用户访问了该网站。前两天的用户数量相对较少，说明该网站的用户活跃度在第3天有了明显提升。', 'succeed', NULL, 1690592362125934594, '2023-08-13 17:11:09', '2023-08-13 19:17:42', 1);
INSERT INTO `chart` VALUES (1690750045223219202, '南城网站用户增长趋势图', '南城网站用户增长趋势图', '日期,用户数量\n1,20\n2,40\n3,600\n', '玫瑰图', '{\n  \"tooltip\": {},\n  \"grid\": {},\n  \"polar\": {},\n  \"angleAxis\": {\n    \"type\": \"category\",\n    \"data\": [\"1\", \"2\", \"3\"]\n  },\n  \"radiusAxis\": {},\n  \"series\": [\n    {\n      \"type\": \"bar\",\n      \"data\": [20, 40, 600],\n      \"coordinateSystem\": \"polar\",\n      \"barCategoryGap\": \"1\",\n      \"label\": {\n        \"show\": true,\n        \"position\": \"top\",\n        \"formatter\": \"{b}\\n{c}\"\n      }\n    }\n  ]\n}', '根据数据分析，南城网站用户数量呈现出明显的增长趋势。在第1天，用户数量为20；第2天，用户数量增加至40；第3天，用户数量激增至600。从数据中可以观察到，用户数量的增长速度非常快。根据这个趋势，可以得出结论：南城网站的用户增长非常迅速。', 'succeed', NULL, 1690592362125934594, '2023-08-13 23:39:58', '2023-08-14 18:23:53', 1);
INSERT INTO `chart` VALUES (1691017451925446658, '龙哥网站数据人数分析', '龙哥网站数据分析图', '日期,用户数量\n1,20\n2,40\n3,600\n', '雷达图', '{\n  \"title\": {\n    \"text\": \"龙哥网站数据人数分析\",\n    \"subtext\": \"用户数量\"\n  },\n  \"tooltip\": {\n    \"trigger\": \"axis\"\n  },\n  \"radar\": {\n    \"indicator\": [\n      {\n        \"name\": \"1\",\n        \"max\": 600\n      },\n      {\n        \"name\": \"2\",\n        \"max\": 600\n      },\n      {\n        \"name\": \"3\",\n        \"max\": 600\n      }\n    ]\n  },\n  \"series\": [\n    {\n      \"name\": \"用户数量\",\n      \"type\": \"radar\",\n      \"data\": [\n        {\n          \"value\": [20, 40, 600],\n          \"name\": \"用户数量\"\n        }\n      ]\n    }\n  ]\n}', '根据数据分析，龙哥网站在不同日期的用户数量呈现较大的差异。具体来说，第一天的用户数量为20人，第二天的用户数量为40人，而第三天的用户数量达到了600人。通过雷达图的可视化形式，可以直观地展示出每天的用户数量情况。从图中可以明显看出，第三天的用户数量远超过前两天，说明在第三天有一次较大规模的用户增长。这可能是由于某种推广活动或者宣传效果好所导致的。需进一步分析原因，以便针对性地进行后续的运营策略和推广活动。总体而言，龙哥网站的用户数量呈现出良好的增长态势，但仍需要不断努力提升。', 'succeed', NULL, 1690946228361175042, '2023-08-14 17:22:32', '2023-08-14 17:22:32', 0);
INSERT INTO `chart` VALUES (1691359037385428994, '我想要获取下我的网站用户增长趋势', 'TechMindWave网站用户增长趋势图', '日期,用户数量\n1,20\n2,40\n3,600\n', '雷达图', '{\n  \"title\": {\n    \"text\": \"网站用户增长趋势\",\n    \"subtext\": \"数据来源：原始数据\"\n  },\n  \"tooltip\": {},\n  \"radar\": {\n    \"name\": {\n      \"textStyle\": {\n        \"color\": \"#fff\",\n        \"backgroundColor\": \"#999\",\n        \"borderColor\": \"#000\",\n        \"borderWidth\": 1,\n        \"borderRadius\": 3,\n        \"padding\": [3, 5]\n      }\n    },\n    \"indicator\": [\n      { \"name\": \"1\", \"max\": 600 },\n      { \"name\": \"2\", \"max\": 600 },\n      { \"name\": \"3\", \"max\": 600 }\n    ]\n  },\n  \"series\": [{\n    \"type\": \"radar\",\n    \"data\": [\n      {\n        \"name\": \"用户数量\",\n        \"value\": [20, 40, 600]\n      }\n    ]\n  }]\n}', '根据提供的原始数据，通过雷达图可以看出，在1号有20个用户，2号有40个用户，3号急剧增长到600个用户。', 'succeed', NULL, 1690946228361175042, '2023-08-15 15:59:53', '2023-08-15 15:59:53', 0);
INSERT INTO `chart` VALUES (1692864147542282241, '你好网用户', '你好网用户', '日期,用户数量\n1,20\n2,40\n3,600\n', '玫瑰图', '{\n  \"title\": {\n    \"text\": \"用户数量玫瑰图\"\n  },\n  \"legend\": {},\n  \"series\": [\n    {\n      \"name\": \"用户数量\",\n      \"type\": \"pie\",\n      \"data\": [\n        { \"value\": 20, \"name\": \"1\" },\n        { \"value\": 40, \"name\": \"2\" },\n        { \"value\": 600, \"name\": \"3\" }\n      ],\n      \"roseType\": \"radius\"\n    }\n  ]\n}', '根据分析结果，可以看出用户数量的变化情况。在1号有20个用户，2号有40个用户，3号有600个用户。据此可以得出结论：用户数量在3号有明显的增长，相比1号和2号，增长速度更快。', 'succeed', NULL, 1690946228361175042, '2023-08-19 19:40:39', '2023-08-19 19:40:39', 0);

-- ----------------------------
-- Table structure for credit
-- ----------------------------
DROP TABLE IF EXISTS `credit`;
CREATE TABLE `credit`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `userId` bigint(20) NULL DEFAULT NULL COMMENT '创建用户Id',
  `creditTotal` bigint(20) NULL DEFAULT 0 COMMENT '总积分',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `isDelete` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '积分表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of credit
-- ----------------------------
INSERT INTO `credit` VALUES (1, 1690592362125934594, 9997, '2023-08-13 23:21:28', '2023-08-14 09:51:15', 0);
INSERT INTO `credit` VALUES (2, 1690741578617942018, 99998, '2023-08-13 23:21:55', '2023-08-13 23:32:18', 0);
INSERT INTO `credit` VALUES (3, 1690946228361175042, 10196, '2023-08-14 12:42:38', '2023-08-19 19:43:38', 0);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `alipayTradeNo` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '支付宝交易凭证id',
  `userId` bigint(20) NOT NULL COMMENT '用户id',
  `subject` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '交易名称',
  `totalAmount` double NOT NULL COMMENT '交易金额',
  `tradeStatus` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'unpaid ' COMMENT 'unpaid,paying,succeed,failed',
  `buyerId` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '支付宝买家id',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `isDelete` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '充值订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------

-- ----------------------------
-- Table structure for text_record
-- ----------------------------
DROP TABLE IF EXISTS `text_record`;
CREATE TABLE `text_record`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `textTaskId` bigint(20) NULL DEFAULT NULL COMMENT '文本任务id',
  `textContent` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '文本内容',
  `genTextContent` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '生成的文本内容',
  `status` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'wait' COMMENT 'wait,running,succeed,failed',
  `execMessage` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '执行信息',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `isDelete` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1692864897932627971 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '文本记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of text_record
-- ----------------------------
INSERT INTO `text_record` VALUES (1690745787899801602, 1690745787899801601, '你好啊', NULL, 'wait', NULL, '2023-08-13 23:23:03', '2023-08-13 23:23:03', 0);
INSERT INTO `text_record` VALUES (1690748119328845827, 1690748119328845826, '你好啊', NULL, 'wait', NULL, '2023-08-13 23:32:18', '2023-08-13 23:32:18', 0);
INSERT INTO `text_record` VALUES (1690897109756264449, 1690897109739487234, '你好啊', NULL, 'wait', NULL, '2023-08-14 09:24:20', '2023-08-14 09:24:20', 0);
INSERT INTO `text_record` VALUES (1690903271671144450, 1690903271629201409, '你好啊', NULL, 'wait', NULL, '2023-08-14 09:48:50', '2023-08-14 09:48:50', 0);
INSERT INTO `text_record` VALUES (1690903879979442177, 1690903879912333313, '你好啊', NULL, 'wait', NULL, '2023-08-14 09:51:15', '2023-08-14 09:51:15', 0);
INSERT INTO `text_record` VALUES (1690947079402233857, 1690947079322542081, '你好啊', NULL, 'wait', NULL, '2023-08-14 12:42:54', '2023-08-14 12:42:54', 0);
INSERT INTO `text_record` VALUES (1691394436111585281, 1691394436061253634, '你好啊', '你好啊！很高兴能为您提供帮助。不过，Markdown格式是一种用于文本排版的轻量级标记语言，只支持对文本的格式进行简单的美化和排版。如果你想要对文章进行排版和格式化，可以使用Markdown的语法进行编辑。以下是一些常见的Markdown语法示例：\n\n1. 标题：\n   使用\'#\'符号表示不同级别的标题，例如：  \n   # 一级标题  \n   ## 二级标题  \n   ### 三级标题  \n   以此类推。\n\n2. 强调：\n   使用\'*\'或\'_\'包围文本来使其斜体，例如：  \n   *斜体* 或 _斜体_\n\n   使用双\'*\'或双\'_\'包围文本来使其加粗，例如：  \n   **加粗** 或 __加粗__\n\n3. 列表：\n   使用\'*\'或\'-\'创建无序列表，例如：  \n   - 项目1\n   - 项目2\n   - 项目3\n\n   使用数字加\'.\'创建有序列表，例如：  \n   1. 项目1\n   2. 项目2\n   3. 项目3\n\n4. 链接和图片：\n   使用\'[链接文本](链接地址)\'创建链接，例如：  \n   [谷歌](https://www.google.com)\n\n   使用\'![图片描述](图片链接地址)\'插入图片，例如：  \n   ![图片示例](https://example.com/image.jpg)\n\n5. 引用：\n   使用\'>\'符号表示引用内容，例如：  \n   > 这是引用的内容\n\n这只是Markdown语法的一小部分示例，你可以根据需要进行排版和格式化。希望对你有所帮助！如果你还有其他问题，请随时提问。', 'succeed', NULL, '2023-08-15 18:20:32', '2023-08-15 18:20:32', 0);
INSERT INTO `text_record` VALUES (1692008620474023939, 1692008620474023938, '你好啊', '你好啊！很高兴能够与你交流。有什么我能帮助你的吗？', 'succeed', NULL, '2023-08-17 11:01:05', '2023-08-17 11:01:05', 0);
INSERT INTO `text_record` VALUES (1692864897932627970, 1692864897932627969, '你好啊', '你好啊。', 'succeed', NULL, '2023-08-19 19:43:38', '2023-08-19 19:43:38', 0);

-- ----------------------------
-- Table structure for text_task
-- ----------------------------
DROP TABLE IF EXISTS `text_task`;
CREATE TABLE `text_task`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务id',
  `name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '笔记名称',
  `textType` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '文本类型',
  `genTextContent` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '生成的文本内容',
  `userId` bigint(20) NULL DEFAULT NULL COMMENT '创建用户Id',
  `status` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'wait' COMMENT 'wait,running,succeed,failed',
  `execMessage` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '执行信息',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `isDelete` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1692864897932627970 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '文本任务表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of text_task
-- ----------------------------
INSERT INTO `text_task` VALUES (1690716261555761153, 'nihao', 'nihao', NULL, 1690592362125934594, 'wait', NULL, '2023-08-13 21:25:43', '2023-08-13 21:25:43', 0);
INSERT INTO `text_task` VALUES (1690903271629201409, '你好啊', 'markdown', NULL, 1690592362125934594, 'wait', NULL, '2023-08-14 09:48:50', '2023-08-14 09:48:50', 0);
INSERT INTO `text_task` VALUES (1690903879912333313, '你好啊测试', 'markdown', NULL, 1690592362125934594, 'wait', NULL, '2023-08-14 09:51:15', '2023-08-14 09:51:15', 0);
INSERT INTO `text_task` VALUES (1690947079322542081, '你好啊', 'markdown', NULL, 1690946228361175042, 'wait', NULL, '2023-08-14 12:42:54', '2023-08-14 12:42:54', 0);
INSERT INTO `text_task` VALUES (1691394436061253634, '你好啊', 'markdown', '你好啊！很高兴能为您提供帮助。不过，Markdown格式是一种用于文本排版的轻量级标记语言，只支持对文本的格式进行简单的美化和排版。如果你想要对文章进行排版和格式化，可以使用Markdown的语法进行编辑。以下是一些常见的Markdown语法示例：\n\n1. 标题：\n   使用\'#\'符号表示不同级别的标题，例如：  \n   # 一级标题  \n   ## 二级标题  \n   ### 三级标题  \n   以此类推。\n\n2. 强调：\n   使用\'*\'或\'_\'包围文本来使其斜体，例如：  \n   *斜体* 或 _斜体_\n\n   使用双\'*\'或双\'_\'包围文本来使其加粗，例如：  \n   **加粗** 或 __加粗__\n\n3. 列表：\n   使用\'*\'或\'-\'创建无序列表，例如：  \n   - 项目1\n   - 项目2\n   - 项目3\n\n   使用数字加\'.\'创建有序列表，例如：  \n   1. 项目1\n   2. 项目2\n   3. 项目3\n\n4. 链接和图片：\n   使用\'[链接文本](链接地址)\'创建链接，例如：  \n   [谷歌](https://www.google.com)\n\n   使用\'![图片描述](图片链接地址)\'插入图片，例如：  \n   ![图片示例](https://example.com/image.jpg)\n\n5. 引用：\n   使用\'>\'符号表示引用内容，例如：  \n   > 这是引用的内容\n\n这只是Markdown语法的一小部分示例，你可以根据需要进行排版和格式化。希望对你有所帮助！如果你还有其他问题，请随时提问。\n', 1690946228361175042, 'succeed', NULL, '2023-08-15 18:20:32', '2023-08-15 18:21:17', 0);
INSERT INTO `text_task` VALUES (1692008620474023938, '你好啊', 'markdown', '你好啊！很高兴能够与你交流。有什么我能帮助你的吗？\n', 1690946228361175042, 'succeed', NULL, '2023-08-17 11:01:05', '2023-08-17 11:01:09', 0);
INSERT INTO `text_task` VALUES (1692864897932627969, '1111', 'markdown', '你好啊。\n', 1690946228361175042, 'succeed', NULL, '2023-08-19 19:43:38', '2023-08-19 19:43:38', 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `userAccount` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '账号',
  `userPassword` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `userName` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `userAvatar` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户头像',
  `userRole` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'user' COMMENT 'user-普通用户 admin-管理员',
  `gender` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '男' COMMENT '性别 男 女',
  `phone` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '电话',
  `email` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '邮箱',
  `userStatus` int(11) NOT NULL DEFAULT 0 COMMENT '状态 0 - 正常 1-注销 2-封号',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `isDelete` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_userAccount`(`userAccount`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1690946228361175043 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1690592362125934594, 'nancheng', '12345678', 'nancheng', 'https://avatars.githubusercontent.com/u/104661473?v=4', 'admin', '男', '16638747874', 'nanchnegyu02@qq.com', 0, '2023-08-13 13:13:23', '2023-08-14 17:38:43', 1);
INSERT INTO `user` VALUES (1690741578617942018, 'nanchengyu', '12345678', 'nanchengyu', 'https://avatars.githubusercontent.com/u/104661473?v=4', 'user', '男', NULL, NULL, 0, '2023-08-13 23:06:19', '2023-08-14 17:38:38', 1);
INSERT INTO `user` VALUES (1690946228361175042, 'nanchengyu02', '8b1b4a2bb93396357991785733c79efd', '南城余', 'https://avatars.githubusercontent.com/u/104661473?v=4', 'admin', '男', NULL, NULL, 0, '2023-08-14 12:39:31', '2023-08-16 09:36:34', 0);

-- ----------------------------
-- Table structure for user_code
-- ----------------------------
DROP TABLE IF EXISTS `user_code`;
CREATE TABLE `user_code`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `userId` bigint(20) NOT NULL COMMENT '用户id',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `isDelete` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_userAccount`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_code
-- ----------------------------
INSERT INTO `user_code` VALUES (1, 1690580805534887938, '2023-08-13 12:27:28', '2023-08-13 12:27:28', 0);
INSERT INTO `user_code` VALUES (2, 1690592362125934594, '2023-08-13 13:13:23', '2023-08-13 13:13:23', 0);
INSERT INTO `user_code` VALUES (3, 1690741578617942018, '2023-08-13 23:06:19', '2023-08-13 23:06:19', 0);
INSERT INTO `user_code` VALUES (4, 1690946228361175042, '2023-08-14 12:39:31', '2023-08-14 12:39:31', 0);

SET FOREIGN_KEY_CHECKS = 1;
