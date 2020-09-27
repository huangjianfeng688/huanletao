/*
Navicat MySQL Data Transfer

Source Server         : 悟空
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : huanletaodb

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2020-09-26 13:07:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `key` varchar(15) NOT NULL,
  `value` varchar(25) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL,
  `html` varchar(25) NOT NULL,
  `type` varchar(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '用户管理', 'User.html', '1');
INSERT INTO `sys_menu` VALUES ('2', '商品管理', 'goods.html', '1');
INSERT INTO `sys_menu` VALUES ('3', '订单管理', 'Orders.html', '1');
INSERT INTO `sys_menu` VALUES ('4', '定时任务', 'job.html', '1');

-- ----------------------------
-- Table structure for sys_permissions
-- ----------------------------
DROP TABLE IF EXISTS `sys_permissions`;
CREATE TABLE `sys_permissions` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `name` varchar(255) NOT NULL COMMENT '权限名称',
  `resources` varchar(255) NOT NULL COMMENT '具体的权限资源',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permissions
-- ----------------------------
INSERT INTO `sys_permissions` VALUES ('1', '收藏商品', 'good:collect');
INSERT INTO `sys_permissions` VALUES ('2', '想要商品', 'good:want');
INSERT INTO `sys_permissions` VALUES ('3', '发表评论', 'comment:report');
INSERT INTO `sys_permissions` VALUES ('4', '个人中心', 'user:personal');
INSERT INTO `sys_permissions` VALUES ('5', '商品管理', 'good:manage');
INSERT INTO `sys_permissions` VALUES ('6', '用户管理', 'user:manage');
INSERT INTO `sys_permissions` VALUES ('7', '权限管理', 'permission:manage');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户角色id',
  `role_name` varchar(255) NOT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '系统管理员');
INSERT INTO `sys_role` VALUES ('2', '超级管理员');
INSERT INTO `sys_role` VALUES ('3', '权限管理员');
INSERT INTO `sys_role` VALUES ('4', '商品管理员');
INSERT INTO `sys_role` VALUES ('12', '高工');
INSERT INTO `sys_role` VALUES ('13', '初级工程师');
INSERT INTO `sys_role` VALUES ('14', 'dba');
INSERT INTO `sys_role` VALUES ('15', '数据分析师');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `menu_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('1', '1', '1');
INSERT INTO `sys_role_menu` VALUES ('2', '1', '2');
INSERT INTO `sys_role_menu` VALUES ('3', '2', '3');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `roleid` int(11) NOT NULL COMMENT '角色id',
  `permissionid` int(11) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('1', '1', '1');
INSERT INTO `sys_role_permission` VALUES ('2', '1', '2');
INSERT INTO `sys_role_permission` VALUES ('3', '1', '3');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(25) NOT NULL,
  `password` varchar(50) NOT NULL,
  `mail` varchar(25) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '470c1a25c189b4d27506ab673567075d94', '1710350112@qq.com', '1');
INSERT INTO `sys_user` VALUES ('2', 'root', '470c1a25c189b4d27506ab673567075d94', '171', '2');
INSERT INTO `sys_user` VALUES ('3', 'zhangsan', '470c1a25c189b4d27506ab673567075d94', '444', '3');

-- ----------------------------
-- Table structure for task_schedule_job
-- ----------------------------
DROP TABLE IF EXISTS `task_schedule_job`;
CREATE TABLE `task_schedule_job` (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `job_name` varchar(255) DEFAULT NULL,
  `job_group` varchar(255) DEFAULT NULL,
  `job_status` varchar(255) DEFAULT NULL,
  `cron_expression` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `bean_class` varchar(255) DEFAULT NULL,
  `is_concurrent` varchar(255) DEFAULT NULL COMMENT '1',
  `spring_id` varchar(255) DEFAULT NULL,
  `method_name` varchar(255) NOT NULL,
  PRIMARY KEY (`job_id`),
  UNIQUE KEY `name_group` (`job_name`,`job_group`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of task_schedule_job
-- ----------------------------
INSERT INTO `task_schedule_job` VALUES ('1', null, '2014-08-08 14:17:34', 'test', 'test', '0', '0/1 * * * * ?', 'test', 'com.snailxr.base.task.TaskTest', '0', null, 'run1');
INSERT INTO `task_schedule_job` VALUES ('2', null, '2014-04-25 14:17:19', 'test1', 'test', '0', '0/5 * * * * ?', 'test2', null, '1', 'taskTest', 'run');
INSERT INTO `task_schedule_job` VALUES ('10', '2014-04-25 16:52:17', '2014-08-08 14:17:27', '中间', '1111', '0', '0/1 * * * * ?', 'xxx', 'com.snailxr.base.task.TaskTest', '1', '', 'run');

-- ----------------------------
-- Table structure for web_advert
-- ----------------------------
DROP TABLE IF EXISTS `web_advert`;
CREATE TABLE `web_advert` (
  `advertid` int(11) NOT NULL AUTO_INCREMENT COMMENT '广告id',
  `advertname` varchar(255) NOT NULL COMMENT '广告标题',
  `tarurl` varchar(255) NOT NULL COMMENT '广告的目标地址',
  `picaddress` varchar(255) NOT NULL COMMENT '图片地址',
  `status` char(2) NOT NULL DEFAULT '0' COMMENT '状态是否启用，0未启用，1启用',
  PRIMARY KEY (`advertid`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_advert
-- ----------------------------
INSERT INTO `web_advert` VALUES ('1', '广告', 'www.baidu.com', '/static/image/wheel/20150622231627_Fhr2x.jpeg', '0');
INSERT INTO `web_advert` VALUES ('2', '谷歌', 'www.google.com', '/static/image/wheel/男鞋361.jpg', '1');
INSERT INTO `web_advert` VALUES ('3', '淘宝网', 'www.taobao.com', '/static/image/wheel/20170211061910157.jpg', '1');
INSERT INTO `web_advert` VALUES ('6', '搜索', '搜索', '/static/image/wheel/solr复制域的设计.png', '1');
INSERT INTO `web_advert` VALUES ('5', '你是猪吗', 'www.huawei.com', '/static/image/wheel/20170211061910157.jpg', '0');

-- ----------------------------
-- Table structure for web_category
-- ----------------------------
DROP TABLE IF EXISTS `web_category`;
CREATE TABLE `web_category` (
  `categoryid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `catename` varchar(255) NOT NULL COMMENT '分类名称',
  PRIMARY KEY (`categoryid`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_category
-- ----------------------------
INSERT INTO `web_category` VALUES ('1', '数码产品');
INSERT INTO `web_category` VALUES ('2', '书籍教材 ');
INSERT INTO `web_category` VALUES ('3', '衣鞋帽伞');
INSERT INTO `web_category` VALUES ('4', '代步工具');
INSERT INTO `web_category` VALUES ('5', '体育健身');
INSERT INTO `web_category` VALUES ('6', '家用电器');
INSERT INTO `web_category` VALUES ('7', '日常用品');
INSERT INTO `web_category` VALUES ('8', '虚拟产品');
INSERT INTO `web_category` VALUES ('9', '手工设计5');

-- ----------------------------
-- Table structure for web_collect
-- ----------------------------
DROP TABLE IF EXISTS `web_collect`;
CREATE TABLE `web_collect` (
  `collectid` int(11) NOT NULL AUTO_INCREMENT COMMENT '收藏id',
  `userid` int(11) NOT NULL COMMENT '收藏的用户id',
  `goodid` varchar(255) NOT NULL COMMENT '收藏的商品id列表',
  PRIMARY KEY (`collectid`)
) ENGINE=MyISAM AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_collect
-- ----------------------------
INSERT INTO `web_collect` VALUES ('19', '7', '20,3,13');
INSERT INTO `web_collect` VALUES ('11', '6', '11');
INSERT INTO `web_collect` VALUES ('28', '20', '10');
INSERT INTO `web_collect` VALUES ('22', '20', '22');
INSERT INTO `web_collect` VALUES ('15', '15', '15');
INSERT INTO `web_collect` VALUES ('20', '13', '1');
INSERT INTO `web_collect` VALUES ('23', '22', '3,10');
INSERT INTO `web_collect` VALUES ('27', '22', '24');
INSERT INTO `web_collect` VALUES ('25', '26', '3');
INSERT INTO `web_collect` VALUES ('26', '25', '29');

-- ----------------------------
-- Table structure for web_comment
-- ----------------------------
DROP TABLE IF EXISTS `web_comment`;
CREATE TABLE `web_comment` (
  `commentid` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `userid` int(11) NOT NULL COMMENT '发表评论的用户id',
  `goodid` int(11) NOT NULL COMMENT '评论的商品id',
  `context` tinytext COMMENT '评论的内容',
  PRIMARY KEY (`commentid`)
) ENGINE=MyISAM AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_comment
-- ----------------------------
INSERT INTO `web_comment` VALUES ('1', '8', '10', '还不错。卖家合作愉快。人很不错。');
INSERT INTO `web_comment` VALUES ('2', '6', '10', '东西不错。人好看，哈哈哈，聊');
INSERT INTO `web_comment` VALUES ('3', '7', '10', '还可以哦');
INSERT INTO `web_comment` VALUES ('4', '6', '10', '好还是 好红烧豆腐 是');
INSERT INTO `web_comment` VALUES ('5', '6', '10', '水电费了好客山东');
INSERT INTO `web_comment` VALUES ('6', '6', '11', '滑石粉是否会');
INSERT INTO `web_comment` VALUES ('7', '6', '11', '哦哦啊是否');
INSERT INTO `web_comment` VALUES ('8', '6', '12', '好看好呗');
INSERT INTO `web_comment` VALUES ('9', '6', '1', '西瓜可口');
INSERT INTO `web_comment` VALUES ('10', '15', '15', '还不错哦');
INSERT INTO `web_comment` VALUES ('11', '16', '10', 'nihao');
INSERT INTO `web_comment` VALUES ('12', '17', '3', '好不错');
INSERT INTO `web_comment` VALUES ('13', '7', '3', '苹果手机，非常不错的一部手机。');
INSERT INTO `web_comment` VALUES ('14', '13', '1', '年是否会');
INSERT INTO `web_comment` VALUES ('15', '20', '12', '好吃');
INSERT INTO `web_comment` VALUES ('16', '20', '22', '你好张桂，鞋子不错。');
INSERT INTO `web_comment` VALUES ('17', '22', '3', '好不错');
INSERT INTO `web_comment` VALUES ('18', '22', '25', '哈哈哈');
INSERT INTO `web_comment` VALUES ('19', '26', '10', '行数');
INSERT INTO `web_comment` VALUES ('20', '26', '3', '哈哈哈哈，很好用');
INSERT INTO `web_comment` VALUES ('21', '25', '29', '好。非常不错');
INSERT INTO `web_comment` VALUES ('22', '26', '3', '发的方法');
INSERT INTO `web_comment` VALUES ('23', '26', '10', '你好');
INSERT INTO `web_comment` VALUES ('24', '25', '10', '水电费');
INSERT INTO `web_comment` VALUES ('25', '22', '3', '哦你好奴婢');
INSERT INTO `web_comment` VALUES ('26', '20', '10', '小菜鸟');
INSERT INTO `web_comment` VALUES ('27', '20', '10', '发送');
INSERT INTO `web_comment` VALUES ('28', '20', '10', '陈剑央发布的');

-- ----------------------------
-- Table structure for web_good
-- ----------------------------
DROP TABLE IF EXISTS `web_good`;
CREATE TABLE `web_good` (
  `goodid` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `userid` int(11) NOT NULL COMMENT '用户id，对应所属用户的id',
  `goodname` varchar(255) NOT NULL COMMENT '商品名称',
  `price` decimal(8,2) NOT NULL COMMENT '商品价格',
  `categoryid` int(11) NOT NULL COMMENT '所属的分类id',
  `status` char(2) NOT NULL DEFAULT '0' COMMENT '商品状态，0表示为未审核,1表示审核通过，2表示审核未通过',
  PRIMARY KEY (`goodid`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_good
-- ----------------------------
INSERT INTO `web_good` VALUES ('1', '4', '西瓜', '124.00', '1', '1');
INSERT INTO `web_good` VALUES ('3', '8', '华为meta30', '1542.50', '4', '1');
INSERT INTO `web_good` VALUES ('10', '32', '超级牛逼的361鞋子', '999.00', '3', '1');
INSERT INTO `web_good` VALUES ('11', '7', '相机', '1245.00', '4', '1');
INSERT INTO `web_good` VALUES ('12', '7', '三星电脑', '7777.00', '4', '1');
INSERT INTO `web_good` VALUES ('13', '6', '三鲜酱油', '25.00', '7', '1');
INSERT INTO `web_good` VALUES ('14', '13', '树华府', '4564.00', '3', '1');
INSERT INTO `web_good` VALUES ('15', '6', '苹果手机', '8888.00', '1', '1');
INSERT INTO `web_good` VALUES ('18', '6', '测试商品', '9999.00', '1', '1');
INSERT INTO `web_good` VALUES ('19', '16', '测试商品', '9999.00', '3', '0');
INSERT INTO `web_good` VALUES ('20', '17', '测试商品', '99999.00', '2', '1');
INSERT INTO `web_good` VALUES ('21', '19', '二手衣服', '123.00', '0', '0');
INSERT INTO `web_good` VALUES ('22', '21', '测试商品888', '8888.00', '7', '1');
INSERT INTO `web_good` VALUES ('23', '22', '水果到', '2888.00', '3', '1');
INSERT INTO `web_good` VALUES ('24', '22', 'ddd', '111.00', '2', '1');
INSERT INTO `web_good` VALUES ('25', '22', 'fsdfd', '1111.00', '2', '1');
INSERT INTO `web_good` VALUES ('26', '22', 'admin', '1111.00', '4', '1');
INSERT INTO `web_good` VALUES ('29', '26', '11手机', '1522.00', '1', '1');
INSERT INTO `web_good` VALUES ('30', '26', 'aa', '222.00', '3', '1');
INSERT INTO `web_good` VALUES ('31', '28', '首付款后', '7777.00', '4', '1');
INSERT INTO `web_good` VALUES ('32', '31', '张三分首尔', '90000.00', '5', '2');

-- ----------------------------
-- Table structure for web_good_desc
-- ----------------------------
DROP TABLE IF EXISTS `web_good_desc`;
CREATE TABLE `web_good_desc` (
  `goodid` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `goodname` varchar(255) NOT NULL COMMENT '商品名称',
  `price` decimal(8,2) DEFAULT NULL COMMENT '商品价格',
  `pictures` varchar(255) DEFAULT NULL COMMENT '所有的图片列表，以逗号',
  `address` varchar(255) DEFAULT NULL COMMENT '商品现在所在地址',
  `gooddesc` text COMMENT '商品描述',
  `status` char(2) DEFAULT '0' COMMENT '商品现在的状态，是否是卖出，0表示为未卖出，1表示已出售，2表示正在交易中',
  `goodnumber` int(11) DEFAULT NULL COMMENT '物品的数量',
  `old` char(4) DEFAULT NULL COMMENT '商品的老化程度',
  PRIMARY KEY (`goodid`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_good_desc
-- ----------------------------
INSERT INTO `web_good_desc` VALUES ('1', '西瓜', '124.00', '/static/image/good/xigua.jpg', '广西科技师范学院来宾校区17栋508', '这是最美味的西瓜，是绝壁西瓜。', '1', '50', null);
INSERT INTO `web_good_desc` VALUES ('3', '华为meta30', '1542.00', '/static/image/good/huawei.jpg', '广西科技大学', '华为meta30，最新版，最好用，\r\n', '0', '5', null);
INSERT INTO `web_good_desc` VALUES ('10', '超级牛逼的361鞋子', '999.00', '/static/image/good/男鞋361.jpg', '广西科技师范学院', '鞋子是好鞋，卖家也是大帅哥。', '1', '2', null);
INSERT INTO `web_good_desc` VALUES ('11', '相机', '1245.00', '/static/image/good/xiangji.jpg', '广西科技师范学院', '超高清像素，好用有还看，还能撩汉子哦', '0', '2', null);
INSERT INTO `web_good_desc` VALUES ('12', '三星电脑', '7777.00', '/static/image/good/sanxing.jpg', '广西科技师范学院', '三星电脑，白色外壳，有移动硬盘。还没有用到4年，很好用。', '2', '4', null);
INSERT INTO `web_good_desc` VALUES ('13', '三鲜酱油', '25.00', '/static/image/good/45.jpg', '广西来宾市', '三鲜酱油，好吃，很香', '1', '1', null);
INSERT INTO `web_good_desc` VALUES ('14', '树华府', '4564.00', '/static/image/good/default.jpg', '广西科技发返回', '水电费是否是水电费是', '0', '2', null);
INSERT INTO `web_good_desc` VALUES ('15', '苹果手机', '8888.00', '/static/image/good/u=1026016199,1338164578&fm=26&gp=0.jpg', '广西科技师范学院', '好用的手机', '0', '1', null);
INSERT INTO `web_good_desc` VALUES ('16', '小鸡鸡', '999999.00', '/static/image/good/动态.png', 'xxxx', 'xxx', '0', '3', null);
INSERT INTO `web_good_desc` VALUES ('17', '小鸡鸡', '999999.00', '/static/image/good/动态.png', 'xxxx', 'xxx', '0', '3', null);
INSERT INTO `web_good_desc` VALUES ('18', '测试商品', '9999.00', '/static/image/good/20180604122455exge0ykykjx.jpg', '广西来宾中央广场', '是否会上岛咖啡黑客技术地方受到发师范', '0', '1', null);
INSERT INTO `web_good_desc` VALUES ('19', '测试商品', '9999.00', '/static/image/good/20180604122455exge0ykykjx.jpg', '广西来宾中央广场', '发顺丰师范是发师范', '0', '1', null);
INSERT INTO `web_good_desc` VALUES ('20', '测试商品', '99999.00', '/static/image/good/QQ截图20200228090025.png', '广西来宾', '是否', '0', '1', null);
INSERT INTO `web_good_desc` VALUES ('21', '二手衣服', '123.00', '/static/image/good/6.jpg', '南宁市', '11111', '0', '1', null);
INSERT INTO `web_good_desc` VALUES ('22', '测试商品888', '8888.00', '/static/image/good/男鞋361.jpg', '广西南宁市', '啦啦啦啦老师傅 是否 水电费说的发的发', '1', '3', null);
INSERT INTO `web_good_desc` VALUES ('23', '水果到', '2888.00', '/static/image/good/5.jpg', '广西来宾', '舒服舒服', '0', '1', null);
INSERT INTO `web_good_desc` VALUES ('24', 'ddd', '111.00', '/static/image/good/6.jpg', '广西来宾', '水电费', '2', '1', null);
INSERT INTO `web_good_desc` VALUES ('25', 'fsdfd', '1111.00', '/static/image/good/20150622231627_Fhr2x.jpeg', '111', '1111', '0', '11', null);
INSERT INTO `web_good_desc` VALUES ('26', 'admin', '1111.00', '/static/image/good/f.png', '广西来宾', '发顺丰', '0', '11', null);
INSERT INTO `web_good_desc` VALUES ('29', '11手机', '1522.00', '/static/image/good/45.jpg', '广西来宾', '哈哈哈哈哈', '1', '1', null);
INSERT INTO `web_good_desc` VALUES ('30', 'aa', '222.00', '/static/image/good/2e03f75e77f9e15f9208f6a83deaa38.jpg', '上思', '是是是', '0', '3', null);
INSERT INTO `web_good_desc` VALUES ('31', '首付款后', '7777.00', '/static/image/good/8.jpg', '南宁市西乡塘', '水电费后首付款', '0', '1', null);
INSERT INTO `web_good_desc` VALUES ('32', '张三分首尔', '90000.00', '/static/image/good/微信图片_20200803123427.jpg', '南宁西乡塘', 'sss', '0', '8', null);

-- ----------------------------
-- Table structure for web_order
-- ----------------------------
DROP TABLE IF EXISTS `web_order`;
CREATE TABLE `web_order` (
  `orderid` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `goodid` int(11) NOT NULL COMMENT '交易的商品id',
  `sellerid` int(11) NOT NULL COMMENT '卖家id',
  `buyerid` int(11) NOT NULL COMMENT '买家id',
  `createdate` datetime NOT NULL COMMENT '订单创建时间',
  `status` char(2) DEFAULT NULL COMMENT '订单状态，0表示正在交易，1表示交易成功，2表示交易失败',
  PRIMARY KEY (`orderid`)
) ENGINE=MyISAM AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_order
-- ----------------------------
INSERT INTO `web_order` VALUES ('36', '29', '26', '20', '2020-05-11 11:46:15', '1');
INSERT INTO `web_order` VALUES ('35', '29', '26', '20', '2020-05-10 00:19:36', '1');

-- ----------------------------
-- Table structure for web_user
-- ----------------------------
DROP TABLE IF EXISTS `web_user`;
CREATE TABLE `web_user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id，主键自增',
  `username` varchar(255) DEFAULT '欢乐小淘' COMMENT '用户名',
  `loginname` varchar(255) NOT NULL COMMENT '用户账号，电话用于登录和接收短信',
  `password` varchar(255) NOT NULL COMMENT '登录密码',
  `sex` char(1) DEFAULT NULL COMMENT '0表示男，1表示女',
  `college` varchar(255) DEFAULT NULL COMMENT '所在学校',
  `graduatedate` date DEFAULT NULL COMMENT '毕业年份',
  `Headimage` varchar(255) DEFAULT '/static/image/avatar/default.jpg' COMMENT '头像图片地址',
  `usertype` int(11) NOT NULL DEFAULT '1' COMMENT '用户类型',
  `phone` varchar(255) DEFAULT NULL COMMENT '用户联系电话',
  PRIMARY KEY (`userid`)
) ENGINE=MyISAM AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_user
-- ----------------------------
INSERT INTO `web_user` VALUES ('7', '欢乐小淘', 'admin', '470c1a25c189b4d27506ab673567075d94', '0', '广西大学', '2019-12-06', '/static/image/avatar/jhg.jpg', '2', '18876701231');
INSERT INTO `web_user` VALUES ('27', 'taotao', 'tao', '1d411a8d1835619b0181a218348648d72b', '1', '广西大学', '2020-05-08', '/static/image/avatar/jhg.jpg', '1', '');
INSERT INTO `web_user` VALUES ('20', '谢华康', 'xie123', '470c1a25c189b4d27506ab673567075d94', '1', '广西大学', '2020-07-01', '/static/image/avatar/5.jpg', '1', '');
INSERT INTO `web_user` VALUES ('26', '淘淘小米', 'zhang123', '71723d2c2ac4b723a224d8c43b9536c96', '0', '广西大学', '2020-05-08', '/static/image/avatar/2018纪念日.png', '1', '');
INSERT INTO `web_user` VALUES ('21', '欢乐小淘', 'huanletao', '40d95d75b35ccd5548272509d1007739ab', '0', '广西大学', '2020-04-02', '/static/image/avatar/default.png', '1', '');
INSERT INTO `web_user` VALUES ('22', '踏雪无痕', 'huangjf', '470c1a25c189b4d27506ab673567075d94', '0', '广西大学', '2020-05-10', '/static/image/avatar/88.png', '1', '18207700421');
INSERT INTO `web_user` VALUES ('25', '小郎君222', 'langj', '470c1a25c189b4d27506ab673567075d94', '1', '中国传媒大学', '2020-05-22', '/static/image/avatar/u=1026016199,1338164578&fm=26&gp=0.jpg', '1', '12807700457');
INSERT INTO `web_user` VALUES ('28', '韦嘉莹', 'weijy', '470c1a25c189b4d27506ab673567075d94', '1', '广西科技师范学院', '2021-07-01', '/static/image/avatar/5.jpg', '1', '15978075846');
INSERT INTO `web_user` VALUES ('29', '人民银行', 'lianj', '470c1a25c189b4d27506ab673567075d94', '1', '广西民族大学', '2020-07-01', '/static/image/avatar/default.jpg', '1', null);
INSERT INTO `web_user` VALUES ('31', '张三丰', 'zhangsf', '470c1a25c189b4d27506ab673567075d94', '0', '广西大学', '2020-08-21', '/static/image/avatar/1233 (1).jpg', '1', '18207700421');
INSERT INTO `web_user` VALUES ('32', '张三丰', '1710350112@qq.com', '470c1a25c189b4d27506ab673567075d94', '0', '广西大学', '2020-08-21', '/static/image/avatar/1233 (1).jpg', '1', '18207700421');

-- ----------------------------
-- Table structure for web_want
-- ----------------------------
DROP TABLE IF EXISTS `web_want`;
CREATE TABLE `web_want` (
  `wantid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `goodid` int(11) NOT NULL COMMENT '商品id',
  `userid` int(11) NOT NULL COMMENT '用户id',
  `reply` char(2) DEFAULT NULL COMMENT '卖家回复的信息',
  PRIMARY KEY (`wantid`)
) ENGINE=MyISAM AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_want
-- ----------------------------
INSERT INTO `web_want` VALUES ('26', '30', '26', null);
INSERT INTO `web_want` VALUES ('25', '29', '25', null);
INSERT INTO `web_want` VALUES ('24', '3', '26', null);
INSERT INTO `web_want` VALUES ('27', '24', '22', null);
INSERT INTO `web_want` VALUES ('28', '24', '22', null);
INSERT INTO `web_want` VALUES ('29', '24', '22', null);
INSERT INTO `web_want` VALUES ('30', '10', '20', null);
INSERT INTO `web_want` VALUES ('31', '10', '20', null);
INSERT INTO `web_want` VALUES ('32', '10', '20', null);

-- ----------------------------
-- View structure for user12
-- ----------------------------
DROP VIEW IF EXISTS `user12`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `user12` AS select `web_user`.`userid` AS `userid`,`web_user`.`username` AS `username`,`web_user`.`loginname` AS `loginname`,`web_user`.`password` AS `password`,`web_user`.`sex` AS `sex`,`web_user`.`college` AS `college`,`web_user`.`graduatedate` AS `graduatedate`,`web_user`.`Headimage` AS `Headimage`,`web_user`.`usertype` AS `usertype`,`web_user`.`phone` AS `phone` from `web_user` ;

-- ----------------------------
-- View structure for userproducts
-- ----------------------------
DROP VIEW IF EXISTS `userproducts`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `userproducts` AS select `web_user`.`username` AS `用户名`,count(`web_good`.`goodname`) AS `商品数` from (`web_user` left join `web_good` on((`web_user`.`userid` = `web_good`.`userid`))) group by `web_user`.`userid` order by `商品数` desc ;

-- ----------------------------
-- Procedure structure for login
-- ----------------------------
DROP PROCEDURE IF EXISTS `login`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `login`(in username varchar(25),
											 in PASSWORD VARCHAR(20))
BEGIN

   -- 声明变量。
   DECLARE responseEnum varchar(20) DEFAULT '';

   -- 赋值
   select  COUNT(*) into responseEnum from web_user
   where web_user.loginname = username 
   and web_user.`password` = `password`;
   
   select IF(responseEnum > 0,'成功','失败');

end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for myp1
-- ----------------------------
DROP PROCEDURE IF EXISTS `myp1`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `myp1`()
BEGIN

		insert into web_role(id,roleName) values(12,'高工'),(13,'初级工程师'),
    (14,'dba'),(15,'数据分析师');
    DELETE from web_role where id is NULL;

END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for myp2
-- ----------------------------
DROP PROCEDURE IF EXISTS `myp2`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `myp2`(in idn VARCHAR(20),out msg VARCHAR(25))
BEGIN

  SELECT roleName into msg from web_role where id = idn;

end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for test_loop
-- ----------------------------
DROP PROCEDURE IF EXISTS `test_loop`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `test_loop`()
BEGIN

  DECLARE i int;
   set i = 20;
   loop_example:LOOP
     INSERT into web_role(id,roleName) VALUE (i,CONCAT('地摊老板',i));
     set i = i + 1;
     if i > 30 then 
        leave loop_example;
      end if;
    end loop;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for test_while
-- ----------------------------
DROP PROCEDURE IF EXISTS `test_while`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `test_while`()
BEGIN

  DECLARE i int DEFAULT 0 ;
  DECLARE d BIGINT DEFAULT 12;
  DECLARE n int;
  select COUNT(*) INTO n from web_user ;
  WHILE i < n DO
-- 		 insert into test(id) VALUES(i);
     update test set test.no = d where id = i ;
		 set i = i + 1;
     set d = d + 120;
   end while;

end
;;
DELIMITER ;

-- ----------------------------
-- Function structure for fn1
-- ----------------------------
DROP FUNCTION IF EXISTS `fn1`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `fn1`() RETURNS varchar(20) CHARSET utf8
BEGIN

  DECLARE a VARCHAR(20);
  select '你好' into a;
  return a;

END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for fn2
-- ----------------------------
DROP FUNCTION IF EXISTS `fn2`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `fn2`(username VARCHAR(20)) RETURNS int(11)
begin 

  DECLARE cnt int DEFAULT 0;
  select userid from web_user where web_user.username = username into cnt;
  return cnt;
   
end
;;
DELIMITER ;

-- ----------------------------
-- Function structure for generateIdCard
-- ----------------------------
DROP FUNCTION IF EXISTS `generateIdCard`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `generateIdCard`() RETURNS varchar(18) CHARSET utf8
BEGIN
		-- 定义变量
    DECLARE province char(2);
    DECLARE ctiy int(2) zerofill;
    DECLARE countys int(2) zerofill;
    DECLARE _sum INT;
    DECLARE mod_result TINYINT;
    DECLARE check_bit CHAR(1);
		-- 随机获取省份代码。【11-82】
    select  cast(floor(11+(rand()*71)) as char)  into province;
    SELECT floor(1+(RAND()*27)) into ctiy;
    

		RETURN ctiy;

end
;;
DELIMITER ;
