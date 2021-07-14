/*
Navicat MySQL Data Transfer

Source Server         : lhy
Source Server Version : 50627
Source Host           : localhost:3306
Source Database       : secondhandmarket

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `p_Id` int(100) NOT NULL AUTO_INCREMENT,
  `p_Account` varchar(100) DEFAULT NULL,
  `p_Name` varchar(100) DEFAULT NULL,
  `c_Id` varchar(100) DEFAULT NULL,
  `p_Title` varchar(100) DEFAULT NULL,
  `p_Des` varchar(100) DEFAULT NULL,
  `p_originalPrice` double DEFAULT NULL,
  `p_Price` double DEFAULT NULL,
  `p_Date` date DEFAULT NULL,
  `p_href` varchar(255) DEFAULT NULL,
  `p_num` int(100) DEFAULT NULL,
  PRIMARY KEY (`p_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (1, 'user1', '笔记本-显示器', 'c02', '2020新款14英寸IPS便携显示器', '成色: 全新售后服务: 店铺三包产地: 港澳台地区屏幕尺寸: 14英寸屏幕比例: 16:9接口类型: HDMI 音频', 3500, 2410, '2020-09-18', '/images/product/01.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (2, 'user1', '电子产品-笔记本-联想-Lenovo', 'c02', 'Lenovo/联想 拯救者 R7000 2020款', '15.6英寸游戏笔记本电脑锐龙六核R5轻薄独显4G手提游戏本便携电脑Y7000', 7000, 5000, '2021-03-02', '/images/product/02.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (3, 'user1', '衣帽鞋伞-雨伞-天堂', 'c04', '全新天堂雨伞', '没用过，伞稍微有点小', 23, 10, '2020-04-03', '/images/product/03.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (4, 'user1', '电子产品-手机-华为-P40', 'c02', '华为P40', '256g储存内存，七成新', 5700, 4500, '2020-06-23', '/images/product/04.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (5, 'user1', '书籍教材-教材-计算机网络', 'c01', '计算机网络', '五成新，有笔记', 60, 20, '2021-07-01', '/images/product/05.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (6, 'user1', '音乐器材-专辑-JAY-周杰伦-CD', 'c10', 'JAY周杰伦专辑正版全套', '全新，CD唱片珍藏杰伦十代 叶惠美/七里香/范特西', 600, 300, '2021-06-09', '/images/product/06.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (7, 'user1', '音乐器材-专辑-陶喆-黑胶', 'c10', '陶喆 同名专辑', '全新，典藏彩胶 透明蓝 12寸+7寸黑胶 LP', 300, 200, '2021-06-03', '/images/product/07.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (8, 'user1', '电子产品-键盘-罗技-无线蓝牙', 'c02', '罗技K380无线蓝牙网红键盘', '超薄安静便携LINE FRIENDS联名iPad安卓办公打字专用游戏', 600, 300, '2021-05-18', '/images/product/08.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (9, 'user1', '电子产品-相机-GoProMAXVlog-运动相机', 'c02', 'GoProMAXVlog运动相机5.6K', '360度全景防水防抖，有小刮痕', 5000, 3700, '2021-05-17', '/images/product/09.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (10, 'user1', '电子产品-耳机-Sony-索尼-降噪', 'c02', 'Sony/索尼 WI-1000XM2', '颈挂无线蓝牙主动降噪耳机入耳式双耳挂脖式耳麦重低音男女生通用', 2000, 1000, '2021-04-22', '/images/product/10.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (11, 'user2', '电子产品-笔记本-电竞-显示器-AOC', 'c02', 'AOC 27英寸240Hz电竞显示器', '0.5ms响应曲面HDR Mode曲屏屏幕1MS电脑游戏144Hz旋转升降PS4K壁挂24', 3000, 1500, '2021-04-29', '/images/product/11.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (12, 'user2', '电子产品-笔记本-HP-惠普-暗影精灵', 'c02', '【新品】HP/惠普 暗影精灵7', '抽奖中的，全新的', 14000, 11000, '2021-03-17', '/images/product/12.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (13, 'user2', '衣帽鞋伞-雨伞-十二骨抗风-防晒-晴雨', 'c04', '全自动雨伞', '十二骨抗风 黑胶防晒，晴雨两用 可定制LOGO', 30, 10, '2021-06-23', '/images/product/13.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (14, 'user2', '电子产品-手机-iphone-iphone12-256g', 'c02', '9成新iphone12', '256g储存内存，换华为了不用这个了', 5000, 4000, '2021-06-23', '/images/product/14.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (15, 'user2', '书籍教材-文学-亚里士多德', 'c01', '亚里士多德全集', '多买了一本，便宜出了', 40, 20, '2021-05-18', '/images/product/15.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (16, 'user2', '音乐器材-专辑-邓紫棋-摩天动物园', 'c10', '正版 邓紫棋专辑 摩天动物园', 'CD+歌词写真本+贴纸 实体专辑唱片。封面为内地发行独占版本，付内地独占贴纸', 200, 99, '2021-05-18', '/images/product/16.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (17, 'user2', '音乐器材-专辑-涅盘乐队 -Nirvana', 'c10', '涅盘乐队 Nirvana专辑', 'Unplugged纽约不插电 黑胶唱片lp 摇滚音乐，两张黑胶唱片，12寸大唱盘，摇滚音乐', 300, 198, '2021-07-05', '/images/product/17.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (18, 'user3', '衣帽鞋伞-衣服-短袖-日系-T恤-国潮-假两件', 'c04', '夏季新款日系t恤短袖', '国潮ins假两件潮流潮牌纯棉宽松半袖上衣服', 120, 70, '2021-06-21', '/images/product/18.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (19, 'user3', '衣帽鞋伞-衣服-短袖-蓝色-T恤-半袖-兔子', 'c04', '半袖2021夏季新款蓝色t恤', '几乎全新,兔子设计感小众女装中长款短袖宽松上衣', 160, 80, '2021-03-08', '/images/product/19.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (20, 'user3', '衣帽鞋伞-帽子-顶帽-防紫外线-百搭', 'c04', '拉菲草空顶帽', '正品，防紫外线遮阳草帽马尾帽韩版百搭防晒帽子', 60, 35, '2021-05-17', '/images/product/20.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (21, 'user3', '书籍教材-教材-数据分析-Python', 'c01', '利用Python进行数据分析', '当当买的，未拆封', 120, 85, '2021-05-25', '/images/product/21.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (22, 'user3', '书籍教材-文学-历史-儿童书', 'c01', '写给儿童的中国历史书', '小孩长大了，不要了，有点旧了', 170, 119, '2021-05-25', '/images/product/22.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (23, 'user3', '书籍教材-小说-德博拉·哈克尼斯', 'c01', '生命之书', '魔法觉醒三部曲德博拉·哈克尼斯，赠品也在', 60, 40, '2021-07-12', '/images/product/23.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (24, 'user2', '书籍教材-教材-刑法学', 'c01', '刑法学案例研习', '9成新《刑法分则案例研习》——方鹏', 40, 10, '2021-05-24', '/images/product/24.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (25, 'user2', '书籍教材-教材-高等数学', 'c01', '高等数学上册', '高等数学上册', 40, 16, '2021-05-24', '/images/product/25.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (26, 'user2', '书籍教材-教材-数据库概论', 'c01', '数据库概论', '95新，16级，数据库概论', 54, 20, '2020-09-23', '/images/product/26.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (27, 'user2', '书籍教材-教材-四六级-单词', 'c01', '四六级单词书', '俞敏洪老师的四级词汇书，词根+联想记忆法。', 45, 14, '2021-05-24', '/images/product/27.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (28, 'user2', '书籍教材-教材-财务管理专业英语-财务管理', 'c01', '财务管理专业英语', '财务管理专业的英语教材', 33, 8, '2021-06-28', '/images/product/28.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (29, 'user2', '书籍教材-文学-索尼设计', 'c01', '索尼设计，塑造现代 索尼设计塑造现代(精)', '二手，95新，介意勿拍', 56, 21, '2021-05-17', '/images/product/29.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (30, 'user3', '书籍教材-文学-钢铁侠-冒险', 'c01', '硅谷钢铁侠(埃隆・马斯克的冒险人生)(精)', '【95新】 作者:(美)阿什利・万斯 译者:周恒星 出版社:中信出版社 出版地址:北京 出版日期:2016-04-01 本版版次:1 字数:350 语种:汉 装帧:精装 页数:345 开本:16', 67, 33, '2021-05-17', '/images/product/30.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (31, 'user2', '书籍教材-文学-三毛', 'c01', '正版 三毛作品全集11册全套珍藏版 撒哈拉的故事现当代文学书小说', '全新！！一套11本！！不砍价！！加好友，备注来源！！', 262, 88, '2021-05-24', '/images/product/31.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (32, 'user2', '书籍教材-文学-乔布斯-自传', 'c01', '史蒂夫·乔布斯传', '开本:16开 译者:管延圻 出版社:中信出版社 编者:柳川艳 85新', 44, 23, '2021-06-29', '/images/product/32.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (33, 'user3', '书籍教材-文学-特斯拉-传记', 'c01', '《特斯拉之父》-埃隆.马斯克传-【日本】竹内一正著', '《特斯拉之父》-埃隆.马斯克传-【日本】竹内一正著', 56, 32, '2021-05-24', '/images/product/33.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (34, 'user2', '书籍教材-小说-追风筝的人', 'c01', '追风筝的人', '88新，追风筝的人', 32, 22, '2021-05-24', '/images/product/34.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (35, 'user2', '书籍教材-小说', 'c01', '全新未开封 苏菲的世界', '之前买的一直没动过 在宿舍交易', 33, 12, '2021-05-13', '/images/product/35.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (36, 'user1', '书籍教材-小说', 'c01', '一路泥泞，一路花开', '我看到跌跌撞撞的你泪流满面，却拍拍尘土继续朝前走。一路摔倒，一路坚强。没有人告诉你，勇敢的你看起来那么美。', 34, 22, '2021-05-24', '/images/product/36.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (37, 'user1', '书籍教材-小说', 'c01', '高智商犯罪', '推理控看过来 便宜卖了', 45, 22, '2021-05-15', '/images/product/37.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (38, 'user3', '书籍教材-小说', 'c01', '凉生，我们可不可以不忧伤', '88新', 43, 22, '2021-04-11', '/images/product/38.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (39, 'user3', '书籍教材-小说', 'c01', '中英双语珍藏版，相约星期二', '拆封新书', 65, 27, '2021-06-03', '/images/product/39.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (40, 'user2', '书籍教材-文学-哲学', 'c01', '中国哲学简史 作者 冯友兰', '未拆封全新的噢~~原价38我们只卖20噢~~~', 38, 20, '2021-04-03', '/images/product/40.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (41, 'user3', '书籍教材-小说', 'c01', '智族GQ年度人物刊副刊杨洋', '里面是各种杨洋！！！', 23, 2, '2021-05-21', '/images/product/41.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (42, 'user2', '书籍教材-动漫', 'c01', '如果历史是一群喵1-6套装', '国产知识萌漫 微博动漫大V作者肥志历史漫画系列夏商西周春秋战国楚两汉魏晋南北', 229, 120, '2021-04-25', '/images/product/42.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (43, 'user2', '书籍教材-动漫', 'c01', '漫画基础教程', '美少女+卡通人物+综合篇素描超级动漫新手初学零基础入门手绘临摹画册本技法书籍q版鬼刀日本古风男生教材', 88, 35, '2021-05-21', '/images/product/43.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (44, 'user3', '书籍教材-动漫', 'c01', '漫画拟人 美少女设定资料集', '中青雄狮 童话甜点花天空拟人设计人物角色设定漫画技法动漫画册插画集彩铅入门教程绘画书', 78, 44, '2021-05-04', '/images/product/44.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (45, 'user1', '书籍教材-动漫', 'c01', '龙猫', '宫崎骏绘本故事书 漫画动漫珍藏画册画集周边 新华书店', 65, 34, '2021-05-02', '/images/product/45.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (46, 'user1', '电子产品-平板-苹果-32G', 'c02', 'ipad 2017 32g 苹果平板电脑', 'ipad5 32g 购于苏宁， 无磕伤， 箱说全， 因为需要画画买了pro所以这个就闲置了。', 2990, 1690, '2021-03-23', '/images/product/46.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (47, 'user2', '电子产品-平板-联想小新-11英寸', 'c02', '联想(Lenovo)平板小新Pad 11英寸', '11英寸 学习娱乐平板电脑 学习模式 2k全面屏 6GB+128GB WIFI灰', 1299, 890, '2021-05-21', '/images/product/47.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (48, 'user1', '电子产品-平板-华为', 'c02', '华为平板MatePad 10.4英寸麒麟820', '影音娱乐办公学习 专属教育中心 全面屏平板电脑6G+128G WIFI(贝母白)', 2299, 1679, '2021-04-24', '/images/product/48.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (49, 'user3', '电子产品-平板', 'c02', 'Apple iPad 10.2英寸 平板电脑', '（ 2020年新款 128G WLAN版/Retina显示屏/A12仿生芯片MYLF2CH/A）金色', 2999, 1567, '2021-03-21', '/images/product/49.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (50, 'user3', '电子产品-平板', 'c02', '华为HUAWEI MatePad Pro 10.8英寸', '2021款 鸿蒙HarmonyOS 影音娱乐办公学习平板电脑 8+128GB WIFI夜阑灰', 3799, 2789, '2021-04-23', '/images/product/50.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (51, 'user3', '电子产品-平板', 'c02', '荣耀平板电脑 荣耀平板X7 ', '8英寸轻薄高清大屏影音娱乐学习Pad学生平板电脑 【X7】3G+32G WiFi版 深海蓝', 999, 566, '2021-04-11', '/images/product/51.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (52, 'user2', '电子产品-手表', 'c02', '卡奈亚（Crnaira）品牌手表', '男士黑科技多功能日期星期防水夜光时尚男表简约时尚全黑学生个性腕表潮流 红针（送皮表带和佛珠）', 68, 34, '2020-10-15', '/images/product/52.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (53, 'user2', '电子产品-手表', 'c02', 'LATIT【京东自有品牌】运动手表', '男女户外青少年多功能夜光防水闹钟学生电子表', 55, 33, '2021-05-21', '/images/product/53.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (54, 'user3', '电子产品-手表', 'c02', '2021新品考试专用手表', '男女学生初高中公务员准时潮防水表机械表 逢考必过 白色黑皮带大号男', 44, 23, '2020-12-10', '/images/product/54.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (55, 'user3', '电子产品-手表', 'c02', '迪士尼（Disney）女士手表', '时尚潮流双日历少女腕表初中高中学生手表女MK-11319RG', 166, 123, '2021-05-28', '/images/product/55.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (56, 'user2', '电子产品-手机', 'c02', '联想拯救者电竞手机2', 'Pro 12GB+256GB 骁龙888 双涡扇增压液冷 八指操控 144Hz定制三星E4屏 5G游戏手机 玄', 4199, 3489, '2021-05-29', '/images/product/56.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (57, 'user1', '电子产品-手机', 'c02', ' 荣耀Play5T', '22.5W超级快充 5000mAh大电池 6.5英寸护眼屏 全网通8GB+128GB极光蓝', 1199, 789, '2021-04-25', '/images/product/57.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (58, 'user3', '电子产品-手机', 'c02', 'Redmi Note 9 ', '4G 6000mAh大电池 骁龙662处理器 18W快充 羽墨黑 6GB+128GB 游戏智能手机 小米 红米', 999, 679, '2021-05-14', '/images/product/58.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (59, 'user3', '电子产品-手机', 'c02', 'realme 真我Q3 ', '骁龙750G 120Hz可变帧电竞屏 30W智慧闪充 5000mAh大电池 迷幻银 6GB+128GB realmeq3双5G手机', 1199, 899, '2021-05-09', '/images/product/59.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (60, 'user2', '电子产品-手机', 'c02', '苹果手机', '苹果xs 258g', 6400, 2229, '2021-05-26', '/images/product/60.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (61, 'user1', '电子产品-手机', 'c02', '锤子坚果R1 全网通4G手机6G128G', '讲清楚不议价的。来咨询的不接受还价 ，成色：98新，正品行货，支持验货。同校自提。', 2199, 1456, '2021-06-16', '/images/product/61.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (62, 'user1', '电子产品-手机', 'c02', '95新iphone8plus256G不要了送人', '前女友送的iPhone8plus，现在分手了，低价出。详情联系：18910918916', 4690, 200, '2021-05-20', '/images/product/62.jpg', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (63, 'user1', '电子产品-台式机', 'c02', '设计师专用电脑主机图形工作站', 'i7 9700KF/K2200黑蘋果绘图建模3D渲染视频剪辑平面PS组装机台式全套高配整机', 5199, 3211, '2021-07-01', '/images/product/63.png', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (64, 'user2', '电子产品-路由器', 'c02', '小米路由器', 'AX6000 WiFi6增强版家用千兆端口5G双频6000M无线速率Mesh路由大户型穿墙王全屋智能', 599, 299, '2021-07-02', '/images/product/64.png', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (65, 'user3', '代步工具-滑板', 'c03', 'FILA滑板', '初学者女生青少年滑板儿童成人男专业板四轮公路双翘滑板', 268, 122, '2021-07-05', '/images/product/65.png', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (66, 'user1', '代步工具-自行车', 'c03', '迪卡侬城市自行车', '26寸男女士休闲通勤上班轻便变速复古车OVBCC', 1199, 799, '2021-07-03', '/images/product/66.png', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (67, 'user3', '代步工具-电动车', 'c03', '斯洛克爱玛台铃同款电动车', '锂电池电瓶车小型女士新国标电动自行车', 2877, 1677, '2021-07-04', '/images/product/67.png', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (68, 'user2', '代步工具-摩托车', 'c03', '飞鹰摩托车', '跑车趴赛FY250GR25街车R15赛车春风NK250水冷雅马哈', 5000, 3000, '2021-07-01', '/images/product/68.png', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (69, 'user1', '衣帽鞋伞-鞋子', 'c04', '回力情侣网鞋女', '夏季新款透气软底百搭休闲跑步轻便男士网面运动鞋', 199, 99, '2021-07-06', '/images/product/69.png', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (70, 'user2', '衣帽鞋伞-鞋子', 'c04', '环球帆布鞋女鞋', '百搭小白鞋球鞋春秋板鞋2021年新款夏季薄款布鞋女', 60, 45, '2021-07-02', '/images/product/70.png', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (71, 'user3', '体育健身-球类', 'c05', '鸿克成人比赛专用篮球', '牛皮真皮球手感室外5号翻毛7号耐磨蓝球正品', 375, 145, '2021-07-12', '/images/product/71.png', 1);
INSERT INTO `product` (`p_Id`, `p_Account`, `p_Name`, `c_Id`, `p_Title`, `p_Des`, `p_originalPrice`, `p_Price`, `p_Date`, `p_href`, `p_num`) VALUES (72, 'user4', '体育健身-球类', 'c05', '迪士尼篮球儿童', '3号幼儿园小学生比赛专用耐磨橡胶高弹训练5号篮球', 36, 16, '2021-07-13', '/images/product/72.png', NULL);
