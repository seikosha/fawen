/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost
 Source Database       : fawen

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : utf-8

 Date: 08/04/2020 22:47:26 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `content`
-- ----------------------------
DROP TABLE IF EXISTS `content`;
CREATE TABLE `content` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `uid` int(6) NOT NULL,
  `title` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `category` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `location` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `create_time` datetime(6) DEFAULT NULL,
  `update_time` datetime(6) DEFAULT NULL,
  `selection` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `content`
-- ----------------------------
BEGIN;
INSERT INTO `content` VALUES ('14', '10', '不靠谱的二房东收了我订金，我可以要求退还吗？', '事情是这样的：\n\n1.2020年6月30日，我跟一家中介公司交了订金，要租位于xxx地区的房子；\n\n2.2020年7月1日，我在网上看到，我的那个房子已经交给了一家很不靠谱的公司出租，等于我的房东不是原房东，而是一个专业的二房东，这家二房东在网上的评价很差很差；\n\n在这种情况下，我担心我租了以后也会发生像网上评价的那些不好的恶评情况，所以我现在想退回我的订金不租了。我想请问一下，是否可以？', '民事', '上海', '2020-07-10 11:11:36.000000', '2020-07-24 22:15:27.000000', b'1'), ('16', '10', '测试一下应该没问题', '是不是这样会比较好呢？还是这样还不西行', '民事', '山西', '2020-07-10 16:50:44.000000', null, null), ('17', '10', '这个问题可能很大条', '所以要在这里好好的测试一下，要不会很麻烦', '不清楚', '吉林', '2020-07-14 11:13:24.000000', null, null), ('21', '10', '行政问题应该不会很多', '但你说没有也是不现实的', '行政', '山西', '2020-07-17 18:47:11.000000', null, null), ('22', '10', '不如再来一条吧', '少于三条总是不像样嘛', '行政', '甘肃', '2020-07-17 18:47:37.000000', null, null), ('23', '10', '民事案件当然多多益善啦', '毕竟好赚钱嘛', '民事', '安徽', '2020-07-17 18:48:14.000000', null, null), ('24', '12', '总要给我阿三一个出场的机会吧', '既然出场了就要好好面对', '刑事', '甘肃', '2020-07-21 11:16:59.000000', '2020-08-03 21:08:05.000000', null), ('25', '23', 'コンサルタント費用', '突然のメールですみません。費用について教えていただかますか', '不清楚', '广西', '2020-08-03 20:37:27.000000', '2020-08-03 21:05:18.000000', null), ('26', '23', '我有一个新的问题', '这个问题不解决，我就浑身难受！夜不能寐！', '不清楚', '广西', '2020-08-03 19:45:39.000000', '2020-08-03 21:06:14.000000', null), ('27', '23', '我好困惑因为我没钱了', '老板不发工资如何讨薪才能追到我的钱？救命。', '民事', '山西', '2020-08-03 20:53:46.000000', '2020-08-03 19:56:14.000000', null), ('29', '23', '这个问题我一定要认真对待', '要还是搞不定，真的要气死了！！看我不收拾你！！', '不清楚', '广西', '2020-08-03 20:54:40.000000', '2020-08-03 20:58:19.000000', null), ('30', '10', '我的问题很简单，也非常纯粹', '这个问题件就是，如果功能还调不好，我就该去死了', '刑事', '江西', '2020-08-03 21:19:46.000000', null, null), ('31', '23', '我之所以成为我，不是没有原因的', '可是具体原因是什么，我又很难说的上来，这可怎生是好呢？', '不清楚', '广西', '2020-08-03 21:20:58.000000', null, null), ('32', '25', '问卵能有几多愁~~', '恰似一江逼水向东流！！！！！！！！！', '不清楚', '台湾', '2020-08-03 22:33:55.000000', '2020-08-03 22:37:17.000000', null);
COMMIT;

-- ----------------------------
--  Table structure for `liked`
-- ----------------------------
DROP TABLE IF EXISTS `liked`;
CREATE TABLE `liked` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `liker_id` int(6) NOT NULL,
  `rid` int(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `liked`
-- ----------------------------
BEGIN;
INSERT INTO `liked` VALUES ('1', '10', '14'), ('7', '10', '4'), ('8', '10', '16'), ('9', '23', '25'), ('10', '10', '24'), ('11', '23', '23'), ('12', '10', '37');
COMMIT;

-- ----------------------------
--  Table structure for `mail`
-- ----------------------------
DROP TABLE IF EXISTS `mail`;
CREATE TABLE `mail` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `sender_id` int(6) DEFAULT NULL,
  `receiver_id` int(6) DEFAULT NULL,
  `title` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `content` varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `send_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `mail`
-- ----------------------------
BEGIN;
INSERT INTO `mail` VALUES ('5', '13', '10', '你知道我是一直很喜欢你的', '喜欢你却又不敢说出口，这样的心情真糟糕', '2020-07-22 09:10:07');
COMMIT;

-- ----------------------------
--  Table structure for `reply`
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `cid` int(6) NOT NULL,
  `uid` int(6) NOT NULL,
  `content` varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime NOT NULL,
  `stars` int(6) DEFAULT '0',
  `best` bit(1) DEFAULT NULL,
  `solve` bit(1) DEFAULT NULL,
  `challenges` int(6) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `reply`
-- ----------------------------
BEGIN;
INSERT INTO `reply` VALUES ('3', '14', '10', '依我愚见，应该是不可以的。', '2020-07-10 17:37:11', '7', b'0', b'0', '0'), ('4', '14', '10', '但其实也不一定', '2020-07-10 20:50:02', '6', b'0', b'0', '0'), ('5', '14', '10', '这种情况是要分情形来处理的', '2020-07-10 20:50:33', '1', b'0', b'0', '1'), ('9', '16', '10', '这样还是能行的', '2020-07-11 09:34:30', '3', b'0', b'0', '1'), ('10', '16', '10', '我觉得在这个问题上我还是比较专业的', '2020-07-12 10:43:54', '3', b'0', b'0', '1'), ('11', '16', '10', '你这种说法我觉得是有问题的', '2020-07-12 10:50:29', '0', b'0', b'0', '1'), ('12', '16', '10', '这样讲究竟是否合适？', '2020-07-12 10:51:30', '2', b'0', b'0', '1'), ('13', '16', '10', '这样判断我觉得还是OK的', '2020-07-12 10:53:50', '1', b'0', b'0', '5'), ('16', '14', '10', '不管怎么说吧', '2020-07-16 11:17:57', '1', b'0', b'0', '1'), ('17', '14', '10', '到底要怎样你才会满意', '2020-07-16 11:29:27', null, b'0', b'0', null), ('18', '14', '10', '我想试试这样会不会成功', '2020-07-24 21:37:26', '0', b'0', b'0', '0'), ('19', '14', '10', '总得让我得着一次吧？', '2020-07-24 21:38:34', '0', b'0', b'1', '0'), ('20', '14', '10', '总得让我得着一次吧？', '2020-07-24 21:56:45', '0', b'0', b'0', '0'), ('21', '14', '10', '实在不行的话我也管不了了', '2020-07-24 22:15:27', '0', b'0', b'0', '0'), ('23', '25', '10', '我试了一下，我这里没有问题呀！', '2020-08-03 19:39:26', '0', null, null, '0'), ('24', '26', '23', '我试试看我能不能解决！', '2020-08-03 19:52:56', '1', null, null, '1'), ('25', '27', '23', '怎么会出现这样的问题呢？这个老板真的太坏了！', '2020-08-03 19:56:14', '1', null, b'1', '0'), ('26', '27', '23', '这个很好解决。', '2020-08-03 20:56:56', '0', null, null, '0'), ('27', '26', '10', '我对mushyoom提出的如下意见存有不同看法：我试试看我能不能解决！\n\n其实我不太同意你的说法，但似乎也无可奈何', '2020-08-03 20:00:39', '0', null, null, '0'), ('28', '25', '23', '没有人回答我一下吗？嗯？\n', '2020-08-03 21:04:54', '0', null, null, '0'), ('29', '25', '23', '用Chrome就没问题了！耶！', '2020-08-03 21:05:18', '0', null, null, '0'), ('31', '26', '23', '我对seikosha提出的如下意见存有不同看法：我对mushyoom提出的如下意见存有不同看法：我试试看我能不能解决！\n\n现在好像可以解决了！\n\n其实我不太同意你的说法，但似乎也无可奈何', '2020-08-03 21:06:14', '0', null, null, '0'), ('32', '24', '23', '好的，加油啊阿三', '2020-08-03 21:08:05', '0', null, null, '0'), ('33', '28', '23', '自己赚啊这位大佬！！！！', '2020-08-03 21:14:10', '0', null, null, '0'), ('34', '29', '10', '真的吗？真的又那么严重吗？', '2020-08-03 20:58:19', '0', null, null, '1'), ('35', '30', '10', '这样的事情是可怕的，更是骇人听闻的！', '2020-08-03 21:20:01', '0', null, null, '0'), ('36', '31', '23', '比如说，这样与那样，比如说，东边或西边，又比如说，今生和来世！', '2020-08-03 21:21:27', '0', null, null, '0'), ('37', '32', '25', '嗷嗷儿流~', '2020-08-03 22:34:18', '1', null, null, '1'), ('38', '32', '23', '我对qieniangbie提出的如下意见存有不同看法：嗷嗷儿流~\n\n我熬木里翻了兜', '2020-08-03 22:37:17', '0', null, null, '0');
COMMIT;

-- ----------------------------
--  Table structure for `reply_mail`
-- ----------------------------
DROP TABLE IF EXISTS `reply_mail`;
CREATE TABLE `reply_mail` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `mid` int(6) NOT NULL,
  `content` varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `reply_time` datetime NOT NULL,
  `replyer_id` int(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `reply_mail`
-- ----------------------------
BEGIN;
INSERT INTO `reply_mail` VALUES ('1', '5', '但还能怎么样呢，你还能上天吗？', '2020-07-22 16:07:10', '13'), ('2', '5', '我认为我说的话是非常没有问题的', '2020-07-22 17:16:03', '10'), ('3', '5', '这下总行了吧，可累死俺了', '2020-07-22 17:43:52', '10');
COMMIT;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(24) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `email` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `location` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `status` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `description` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(24) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime(6) DEFAULT NULL,
  `last_login_time` datetime(6) DEFAULT NULL,
  `image_url` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('seikosha8', '1', 'fdhsjakfdh@qq.com', '湖北', '法律专业学生', '我还好啦', 'belldandy5', '2020-07-26 14:56:32.000000', null, null), ('seikosha9', '2', 'fdsjalfdsha@qq.com', '广东', '以上都不是', '太噶好！', 'belldandy5', '2020-07-26 14:57:17.000000', null, null), ('seikosha', '10', '43214321@qq.com', '内蒙古', '司法机关从业人员', 'fdasfda', 'belldandy5', null, '2020-08-04 11:15:13.000000', null), ('seikosha1', '13', 'zi_xiong1987@yahoo.co', '辽宁', '社会法律工作者', '就是一二傻子', 'belldandy5', null, null, null), ('seikosha4', '15', 'jdiasofjdaoi@qq.com', '新疆', '法律专业学生', '什么也不是的家伙', 'belldandy5', null, null, null), ('seikosha2', '18', 'zi_xiong1987@yahoo.co', '内蒙古', '社会法律工作者', '我是一个大善人呐', 'belldandy5', null, null, null), ('seikosha3', '19', '56125237@qq.com', '内蒙古', '司法机关从业人员', '合着您们都是我爹', 'belldandy5', null, null, null), ('seikosha5', '20', 'dsajfiao@qq.com', '吉林', '司法机关从业人员', '我是个怪人耶', 'belldandy5', null, null, null), ('seikosha6', '21', '56125237@qq.com', '辽宁', '司法机关从业人员', '我是个什么样的人我估摸着您猜不着', 'belldandy5', null, null, null), ('seikosha7', '22', '47321892437@qq.com', '内蒙古', '以上都不是', '我是一个蠢货', 'belldandy5', '2020-07-25 15:19:54.000000', null, null), ('mushyoom', '23', '59838907@qq.com', '广西', '以上都不是', '我是马大元。', '19880613', '2020-08-03 20:35:53.000000', '2020-08-04 11:10:04.000000', null), ('madashuai', '24', 'fdjsiaojdi@yahoo.co.jp', '天津', '司法机关从业人员', '我是马大帅！~', 'keshuaile', '2020-08-03 21:26:14.000000', null, null), ('qieniangbie', '25', 'ava182@sina.com.com', '江西', '以上都不是', '西卵东西', '701982', '2020-08-03 22:31:48.000000', null, null);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
