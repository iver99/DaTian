/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50541
Source Host           : localhost:3506
Source Database       : datian

Target Server Type    : MYSQL
Target Server Version : 50541
File Encoding         : 65001

Date: 2015-06-17 00:08:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `relDate` datetime DEFAULT NULL,
  `frequency` int(11) DEFAULT NULL,
  `clientId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('Add32998832', '李四', '河北省唐山市', '010-33223444', '2015-05-30 00:00:00', '0', 'CL23767471');
INSERT INTO `address` VALUES ('Add42880504', '王五', '北京市朝阳区', '010-22334542', '2015-05-30 00:00:00', '0', 'CL81096930');
INSERT INTO `address` VALUES ('Add9525010', '郝晨栋', '陕西省西安市', '17728335463', '2015-05-31 00:00:00', '0', 'CL81096930');
INSERT INTO `address` VALUES ('Add95250105', '苏磊', '内蒙古包头市', '18623537354', '2015-05-31 00:00:00', '0', 'CL78387917');
INSERT INTO `address` VALUES ('Add95250106', '胡霞', '北京市海淀区', '17756745643', '2015-05-31 00:00:00', '0', 'CL78387917');
INSERT INTO `address` VALUES ('Add9525015', '张三', '北京市海淀区北京交通大学', '13413244244', '2015-04-13 00:00:00', '0', 'CL23767471');

-- ----------------------------
-- Table structure for attention
-- ----------------------------
DROP TABLE IF EXISTS `attention`;
CREATE TABLE `attention` (
  `id` varchar(255) NOT NULL,
  `type` int(11) DEFAULT NULL,
  `relDate` date DEFAULT NULL,
  `clientId` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `typeId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attention
-- ----------------------------
INSERT INTO `attention` VALUES ('\r\nCL7798491', '1', '2014-12-01', '\r\nCL77984982', '有效', null);
INSERT INTO `attention` VALUES ('\r\nCL7798494', '2', '2014-12-28', '\r\nCL77984982', '有更新', null);

-- ----------------------------
-- Table structure for businessclient
-- ----------------------------
DROP TABLE IF EXISTS `businessclient`;
CREATE TABLE `businessclient` (
  `id` varchar(255) NOT NULL,
  `account` varchar(255) DEFAULT NULL,
  `clientName` varchar(255) DEFAULT NULL,
  `clientBusiness` varchar(255) DEFAULT NULL,
  `relDate` date DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `relatedMaterial` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `carrierId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of businessclient
-- ----------------------------
INSERT INTO `businessclient` VALUES ('BU00000001', 'H201406001', '北京北大方正电子有限公司', '电子', '2015-05-10', '郑国', '13832348888', '/usr/local/iver99/testfile.txt', '无', 'CL29101095');
INSERT INTO `businessclient` VALUES ('BU00000002', 'H201406002', '深圳市德力发科技有限公司', '汽车', '2015-05-10', '陈郁', '13902382563', '/usr/local/iver99/testfile.txt', '无', 'CL29101095');
INSERT INTO `businessclient` VALUES ('BU00000003', 'H201406003', '天津怡坤车业', '汽车', '2015-05-10', '李国强', '13902385859', '/usr/local/iver99/testfile.txt', '无', 'CL29101095');
INSERT INTO `businessclient` VALUES ('BU00000004', 'H201406004', '杭州八安电子科技有限公司', '电子', '2015-05-10', '丁晓莉', '13902382416', '/usr/local/iver99/testfile.txt', '无', 'CL29101095');
INSERT INTO `businessclient` VALUES ('BU00000005', 'H201406005', '上海上久泵业制造有限公司', '汽车', '2015-05-10', '孙明明', '13902382134', '/usr/local/iver99/testfile.txt', '无', 'CL29101095');
INSERT INTO `businessclient` VALUES ('BU00000006', 'H201406006', '东莞市喜来华纶针织有限公司', '医药', '2015-05-10', '李露', '13902389639', '/usr/local/iver99/testfile.txt', '无', 'CL73207711');
INSERT INTO `businessclient` VALUES ('BU00000007', 'H201406007', '无锡强达毛毡制品有限公司', '医药', '2015-05-10', '徐立', '13902389429', '/usr/local/iver99/testfile.txt', '无', 'CL73207711');
INSERT INTO `businessclient` VALUES ('BU00000008', 'H201406008', '上海龙煌服饰有限公司', '医药', '2015-05-10', '魏义方', '13902381684', '/usr/local/iver99/testfile.txt', '无', 'CL73207711');
INSERT INTO `businessclient` VALUES ('BU00000009', 'H201406009', '科勒电器(中国)有限公司', '电子', '2015-05-10', '马国明', '13902387276', '/usr/local/iver99/testfile.txt', '无', 'CL73207711');
INSERT INTO `businessclient` VALUES ('BU00000010', 'H201406010', '中山市嘉威特电器有限公司', '电子', '2015-05-10', '王海峰', '13902387436', '/usr/local/iver99/testfile.txt', '无', 'CL73207711');
INSERT INTO `businessclient` VALUES ('BU00000011', 'H201406011', '深圳市彩世界电器有限公司', '电子', '2015-05-10', '张格', '13902388218', '/usr/local/iver99/testfile.txt', '无', 'CL41403136');
INSERT INTO `businessclient` VALUES ('BU00000012', 'H201406012', '日照市爱普电器有限公司', '电子', '2015-05-10', '胡英', '13902389194', '/usr/local/iver99/testfile.txt', '无', 'CL41403136');
INSERT INTO `businessclient` VALUES ('BU00000013', 'H201406013', '广州奇俊电子科技有限公司', '汽车', '2015-05-10', '陈卫', '13902386945', '/usr/local/iver99/testfile.txt', '无', 'CL41403136');
INSERT INTO `businessclient` VALUES ('BU00000014', 'H201406014', '佛山威视宝电子科技公司', '电子', '2015-05-10', '高文胜', '13902389691', '/usr/local/iver99/testfile.txt', '无', 'CL41403136');
INSERT INTO `businessclient` VALUES ('BU00000015', 'H201406015', '沈阳超越电气设备有限公司', '电子', '2015-05-10', '郝小洋', '13902384954', '/usr/local/iver99/testfile.txt', '无', 'CL41403136');

-- ----------------------------
-- Table structure for carinfo
-- ----------------------------
DROP TABLE IF EXISTS `carinfo`;
CREATE TABLE `carinfo` (
  `id` varchar(255) NOT NULL,
  `carNum` varchar(255) DEFAULT NULL,
  `carTeam` varchar(255) DEFAULT NULL,
  `carUse` varchar(255) DEFAULT NULL,
  `carBase` varchar(255) DEFAULT NULL,
  `carLength` double(12,1) DEFAULT NULL,
  `carWidth` double(12,1) DEFAULT NULL,
  `carHeight` double(12,1) DEFAULT NULL,
  `carWeight` double(12,1) DEFAULT NULL,
  `carState` varchar(255) DEFAULT NULL,
  `carLocation` varchar(255) DEFAULT NULL,
  `relDate` date DEFAULT NULL,
  `carType` varchar(255) DEFAULT NULL,
  `locLongitude` double(12,8) DEFAULT NULL,
  `locLatitude` double(12,8) DEFAULT NULL,
  `locationType` varchar(255) DEFAULT NULL,
  `terminalId` varchar(255) DEFAULT NULL,
  `purchaseTime` date DEFAULT NULL,
  `driverId` varchar(255) DEFAULT NULL,
  `carBrand` varchar(255) DEFAULT NULL,
  `storage` varchar(255) DEFAULT NULL,
  `linetransportId` varchar(255) DEFAULT NULL,
  `carrierId` varchar(255) DEFAULT NULL,
  `stopPlace` varchar(255) DEFAULT NULL COMMENT '经停城市',
  `startPlace` varchar(255) DEFAULT NULL,
  `endPlace` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of carinfo
-- ----------------------------
INSERT INTO `carinfo` VALUES ('CAR00000001', '冀EKK301', '北京车队', '普通运输', '箱式', '4.0', '2.0', '1.0', '3.0', '停歇', '北京-北京市-东城区东长安街', '2015-05-06', '单桥', '116.40793400', '39.91416000', '手机', '无', '2015-05-20', 'DR00000001', '解放', '否', '', 'CL29101095', '上海', '成都', '唐山');
INSERT INTO `carinfo` VALUES ('CAR00000015', '豫EL1915', '北京车队', '普通运输', '箱式', '4.5', '2.0', '1.0', '8.0', '停歇', '北京-北京市-朝阳区今天路甲19号', '2015-05-06', '其他', '116.48432600', '39.92301400', '手机', '无', '2015-05-20', 'DR00000015', '解放', '否', '', 'CL29101095', '上海', '成都', '唐山');
INSERT INTO `carinfo` VALUES ('CAR00000016', '浙A61623', '北京车队', '普通运输', '平板', '4.5', '2.0', '1.0', '8.0', '停歇', '北京-北京市-东城区东长安街', '2015-05-06', '单桥', '116.40793400', '39.91416000', '手机', '无', '2015-05-20', 'DR00000016', '解放', '否', '', 'CL29101095', '成都', '唐山', '西安');
INSERT INTO `carinfo` VALUES ('CAR00000017', '鲁RED183', '北京车队', '普通运输', '高栏', '5.0', '2.0', '1.5', '20.0', '停歇', '北京-北京市-东城区东长安街', '2015-05-06', '其他', '116.39492600', '39.90674400', '手机', '无', '2015-05-20', 'DR00000017', '解放', '否', '', 'CL29101095', '唐山', '西安', '武汉');
INSERT INTO `carinfo` VALUES ('CAR00000018', '沪B79235', '北京车队', '普通运输', '普通', '10.0', '2.0', '1.5', '12.0', '停歇', '北京-北京市-西城区前门西大街甲47-2号', '2015-05-06', '单桥', '116.48432600', '39.92301400', '手机', '无', '2015-05-20', 'DR00000018', '解放', '否', '', 'CL29101095', '西安', '武汉', '上海');
INSERT INTO `carinfo` VALUES ('CAR00000035', '沪AT3483', '天津车队', '普通运输', '箱式', '6.2', '2.0', '1.5', '10.0', '停歇', '北京-北京市-朝阳区今天路甲19号', '2015-05-06', '其他', '116.39492600', '39.90674400', '手机', '无', '2015-05-20', 'DR00000035', '福田', '否', '', 'CL73207711', '成都', '唐山', '西安');
INSERT INTO `carinfo` VALUES ('CAR00000036', '沪B06048', '天津车队', '普通运输', '箱式', '10.0', '2.0', '1.5', '16.0', '停歇', '北京-北京市-东城区东长安街', '2015-05-06', '单桥', '116.48432600', '39.92301400', '手机', '无', '2015-05-20', 'DR00000036', '福田', '否', '', 'CL73207711', '唐山', '西安', '武汉');
INSERT INTO `carinfo` VALUES ('CAR00000037', '苏B55329', '天津车队', '普通运输', '平板', '6.2', '2.0', '1.5', '16.0', '停歇', '北京-北京市-西城区前门西大街甲47-2号', '2015-05-06', '其他', '116.40793400', '39.91416000', '手机', '无', '2015-05-20', 'DR00000037', '福田', '否', '', 'CL73207711', '西安', '武汉', '上海');
INSERT INTO `carinfo` VALUES ('CAR00000038', '苏B55392', '天津车队', '普通运输', '平板', '12.0', '2.0', '1.5', '16.0', '停歇', '北京-北京市-朝阳区今天路甲19号', '2015-05-06', '单桥', '116.39492600', '39.90674400', '手机', '无', '2015-05-20', 'DR00000038', '福田', '否', '', 'CL73207711', '武汉', '上海', '成都');
INSERT INTO `carinfo` VALUES ('CAR00000039', '皖KC2202', '天津车队', '普通运输', '高栏', '6.2', '2.0', '1.5', '10.0', '停歇', '北京-北京市-东城区东长安街', '2015-05-06', '其他', '116.48432600', '39.92301400', '手机', '无', '2015-05-20', 'DR00000039', '福田', '否', '', 'CL73207711', '上海', '成都', '唐山');
INSERT INTO `carinfo` VALUES ('CAR00000040', '皖S37893', '上海车队', '普通运输', '高栏', '12.0', '2.0', '1.5', '10.0', '停歇', '北京-北京市-东城区东长安街', '2015-05-06', '其他', '116.40793400', '39.91416000', '手机', '无', '2015-05-20', 'DR00000040', '福田', '否', '', 'CL73207711', '成都', '唐山', '西安');
INSERT INTO `carinfo` VALUES ('CAR00000041', '翼B94984', '上海车队', '普通运输', '平板', '10.0', '2.0', '1.5', '10.0', '停歇', '北京-北京市-东城区东长安街', '2015-05-06', '其他', '116.39492600', '39.90674400', '手机', '无', '2015-05-20', 'DR00000041', '福田', '否', '', 'CL73207711', '唐山', '西安', '成都');
INSERT INTO `carinfo` VALUES ('CAR00000042', '浙H02987', '上海车队', '普通运输', '普通', '10.0', '2.0', '1.5', '8.0', '停歇', '北京-北京市-西城区前门西大街甲47-2号', '2015-05-06', '单桥', '116.48432600', '39.92301400', '手机', '无', '2015-05-20', 'DR00000042', '福田', '否', '', 'CL73207711', '西安', '成都', '唐山');
INSERT INTO `carinfo` VALUES ('CAR00000043', '沪B89948', '上海车队', '普通运输', '箱式', '12.0', '3.0', '2.0', '8.0', '停歇', '北京-北京市-朝阳区今天路甲19号', '2015-05-06', '单桥', '116.40793400', '39.91416000', '手机', '无', '2015-05-20', 'DR00000043', '福田', '否', '', 'CL73207711', '成都', '唐山', '唐山');
INSERT INTO `carinfo` VALUES ('CAR00000044', '沪BL7183', '上海车队', '普通运输', '高栏', '6.8', '3.0', '2.0', '10.0', '停歇', '北京-北京市-东城区东长安街', '2015-05-06', '单桥', '116.39492600', '39.90674400', '手机', '无', '2015-05-20', 'DR00000044', '福田', '否', '', 'CL73207711', '唐山', '唐山', '西安');
INSERT INTO `carinfo` VALUES ('CAR00000045', '沪D15262', '上海车队', '普通运输', '平板', '14.0', '3.0', '2.0', '10.0', '停歇', '北京-北京市-西城区前门西大街甲47-2号', '2015-05-06', '单桥', '116.48432600', '39.92301400', '手机', '无', '2015-05-20', 'DR00000045', '福田', '否', '', 'CL73207711', '唐山', '西安', '武汉');
INSERT INTO `carinfo` VALUES ('CAR00000046', '吉AB2211', '北京车队', '普通运输', '高栏', '6.8', '3.0', '2.0', '15.0', '停歇', '北京-北京市-朝阳区今天路甲19号', '2015-05-06', '单桥', '116.40793400', '39.91416000', '手机', '无', '2015-05-20', 'DR00000046', '福田', '否', '', 'CL73207711', '西安', '武汉', '上海');
INSERT INTO `carinfo` VALUES ('CAR00000047', '京AH7112', '北京车队', '普通运输', '高栏', '14.0', '3.0', '2.0', '12.0', '停歇', '北京-北京市-东城区东长安街', '2015-05-06', '单桥', '116.39492600', '39.90674400', '手机', '无', '2015-05-20', 'DR00000047', '福田', '否', '', 'CL73207711', '武汉', '上海', '成都');
INSERT INTO `carinfo` VALUES ('CAR00000075', '川B71460', '上海车队', '普通运输', '高栏', '14.0', '3.0', '2.0', '30.0', '停歇', '北京-北京市-朝阳区今天路甲19号', '2015-05-06', '单桥', '116.48432600', '39.92301400', '手机', '无', '2015-05-20', 'DR00000075', '东风', '否', '', 'CL41403136', '武汉', '上海', '成都');
INSERT INTO `carinfo` VALUES ('CAR00000076', '鲁B46330', '上海车队', '普通运输', '箱式', '9.0', '3.0', '2.0', '10.0', '停歇', '北京-北京市-东城区东长安街', '2015-05-06', '单桥', '116.40793400', '39.91416000', '手机', '无', '2015-05-20', 'DR00000076', '福田', '否', '', 'CL41403136', '上海', '成都', '唐山');
INSERT INTO `carinfo` VALUES ('CAR00000077', '鲁BD8998', '上海车队', '普通运输', '高栏', '9.0', '3.0', '2.0', '10.0', '停歇', '北京-北京市-西城区前门西大街甲47-2号', '2015-05-06', '单桥', '116.39492600', '39.90674400', '手机', '无', '2015-05-20', 'DR00000077', '福田', '否', '', 'CL41403136', '成都', '唐山', '西安');
INSERT INTO `carinfo` VALUES ('CAR00000078', '鲁R07772', '上海车队', '普通运输', '高栏', '9.0', '3.0', '2.0', '10.0', '停歇', '北京-北京市-朝阳区今天路甲19号', '2015-05-06', '其他', '116.48432600', '39.92301400', '手机', '无', '2015-05-20', 'DR00000078', '东风', '否', '', 'CL41403136', '唐山', '西安', '成都');
INSERT INTO `carinfo` VALUES ('CAR00000079', '鲁U93290', '天津车队', '普通运输', '箱式', '9.0', '3.0', '2.0', '10.0', '停歇', '北京-北京市-东城区东长安街', '2015-05-06', '单桥', '116.40793400', '39.91416000', '手机', '无', '2015-05-20', 'DR00000079', '福田', '否', '', 'CL41403136', '西安', '成都', '唐山');
INSERT INTO `carinfo` VALUES ('CAR00000080', '鲁U95829', '天津车队', '普通运输', '箱式', '9.0', '3.0', '2.0', '10.0', '停歇', '北京-北京市-东城区东长安街', '2015-05-06', '单桥', '116.39492600', '39.90674400', '手机', '无', '2015-05-20', 'DR00000080', '福田', '否', '', 'CL41403136', '成都', '唐山', '成都');
INSERT INTO `carinfo` VALUES ('CAR00000081', '蒙D17802', '天津车队', '普通运输', '高栏', '9.0', '3.0', '2.0', '18.0', '停歇', '北京-北京市-西城区前门西大街甲47-2号', '2015-05-06', '其他', '116.48432600', '39.92301400', '手机', '无', '2015-05-20', 'DR00000081', '东风', '否', '', 'CL41403136', '唐山', '成都', '唐山');
INSERT INTO `carinfo` VALUES ('CAR00000082', '苏JN1997', '天津车队', '普通运输', '高栏', '9.0', '3.0', '2.0', '10.0', '停歇', '北京-北京市-朝阳区今天路甲19号', '2015-05-06', '单桥', '116.40793400', '39.91416000', '手机', '无', '2015-05-20', 'DR00000082', '福田', '否', '', 'CL41403136', '成都', '唐山', '西安');
INSERT INTO `carinfo` VALUES ('CAR00000083', '赣G32403', '天津车队', '普通运输', '箱式', '9.6', '3.0', '2.0', '12.0', '停歇', '北京-北京市-东城区东长安街', '2015-05-06', '单桥', '116.39492600', '39.90674400', '手机', '无', '2015-05-20', 'DR00000083', '东风', '否', '', 'CL41403136', '唐山', '西安', '上海');
INSERT INTO `carinfo` VALUES ('CAR00000084', '鲁LA2578', '天津车队', '普通运输', '平板', '9.6', '3.0', '2.0', '15.0', '停歇', '北京-北京市-西城区前门西大街甲47-2号', '2015-05-06', '其他', '116.48432600', '39.92301400', '手机', '无', '2015-05-20', 'DR00000084', '东风', '否', '', 'CL41403136', '西安', '上海', '武汉');
INSERT INTO `carinfo` VALUES ('CAR00000098', '鲁M95795', '天津车队', '普通运输', '高栏', '13.0', '2.5', '4.0', '30.0', '停歇', '北京-北京市-朝阳区今天路甲19号', '2015-05-06', '其他', '116.39492600', '39.90674400', '手机', '无', '2015-05-20', 'DR00000098', '东风', '否', '', 'CL41403136', '唐山', '上海', '成都');
INSERT INTO `carinfo` VALUES ('CAR00000099', '赣F86360', '天津车队', '普通运输', '箱式', '14.0', '4.0', '5.0', '20.0', '停歇', '北京-北京市-东城区东长安街', '2015-05-06', '其他', '116.48432600', '39.92301400', '手机', '无', '2015-05-20', 'DR00000099', '东风', '否', '', 'CL41403136', '上海', '成都', '唐山');
INSERT INTO `carinfo` VALUES ('CAR00000100', '军V12009', '北京车队', '普通运输', '高栏', '16.5', '4.0', '5.0', '40.0', '停歇', '北京-北京市-西城区前门西大街甲47-2号', '2015-05-06', '单桥', '116.40793400', '39.91416000', '手机', '无', '2015-05-20', 'DR00000100', '东风', '否', '', 'CL41403136', '成都', '唐山', '西安');

-- ----------------------------
-- Table structure for carrierinfo
-- ----------------------------
DROP TABLE IF EXISTS `carrierinfo`;
CREATE TABLE `carrierinfo` (
  `id` varchar(255) NOT NULL,
  `companyName` varchar(255) DEFAULT NULL,
  `companyAccount` varchar(255) DEFAULT NULL,
  `companyContact` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `resourceRate` varchar(255) DEFAULT NULL,
  `creditRate` int(11) DEFAULT NULL,
  `depositCondition` int(11) DEFAULT NULL,
  `invoiceKind` varchar(255) DEFAULT NULL,
  `companyAddr` varchar(255) DEFAULT NULL,
  `companyScale` varchar(255) DEFAULT NULL,
  `serviceIndustry` varchar(255) DEFAULT NULL,
  `companyType` varchar(255) DEFAULT NULL,
  `relDate` datetime DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `line` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `warehouse` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of carrierinfo
-- ----------------------------
INSERT INTO `carrierinfo` VALUES ('CL29101095', '北京索契物流有限公司', 'account3', '李四', '16525456565', '自有', '2', '1', '增值税', '北京市海淀区', '100-500人', '电子', '外资企业', '2015-01-31 00:00:00', '', '0', '1', '0', '已验证');
INSERT INTO `carrierinfo` VALUES ('CL41403136', '济南德顺物流有限公司', 'account5', '王楠', '13321525658', '自有', '2', '1', '增值税', '山东省济南市', '50-100人', '汽车', '私营企业', '2014-10-31 00:00:00', '', '1', '0', '0', '未验证');
INSERT INTO `carrierinfo` VALUES ('CL73207711', '天津友达通有限公司', 'account4', '张敏', '15452545454', '外围', '1', '1', '增值税', '天津市河西区', '50-100人', '汽车', '私营企业', '2015-03-03 00:00:00', '', '1', '1', '0', '已验证');

-- ----------------------------
-- Table structure for carteam
-- ----------------------------
DROP TABLE IF EXISTS `carteam`;
CREATE TABLE `carteam` (
  `id` varchar(255) NOT NULL,
  `teamName` varchar(255) DEFAULT NULL,
  `carCount` varchar(255) DEFAULT NULL,
  `chief` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `relDate` date DEFAULT NULL,
  `explaination` varchar(255) DEFAULT NULL,
  `carrierId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of carteam
-- ----------------------------
INSERT INTO `carteam` VALUES ('CT00000001', '北京车队', '5', '孙兆峰', '13064818806', '2015-04-22', '无', 'CL29101095  ');
INSERT INTO `carteam` VALUES ('CT00000002', '上海车队', '5', '金荣汉', '13999261880', '2015-04-22', '无', 'CL73207711 ');
INSERT INTO `carteam` VALUES ('CT00000003', '天津车队', '5', '张明远', '15201112342', '2015-04-21', '无', 'CL41403136');

-- ----------------------------
-- Table structure for cityline
-- ----------------------------
DROP TABLE IF EXISTS `cityline`;
CREATE TABLE `cityline` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `cityName` varchar(255) DEFAULT NULL,
  `refPrice` float(10,2) DEFAULT NULL,
  `relDate` date DEFAULT NULL,
  `carrierId` varchar(255) DEFAULT NULL,
  `VIPService` varchar(255) DEFAULT NULL,
  `detailPrice` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `VIPDetail` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cityline
-- ----------------------------
INSERT INTO `cityline` VALUES ('CI00000001', '北京城市配送', '北京城市配送', '2.10', '2015-05-04', 'CL29101095', '有', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '包装、装卸、上楼');
INSERT INTO `cityline` VALUES ('CI00000009', '青岛城市配送', '青岛城市配送', '2.10', '2015-03-24', 'CL29101095', '有', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '包装、装卸、上楼');
INSERT INTO `cityline` VALUES ('CI00000010', '大连城市配送', '大连城市配送', '2.20', '2015-05-04', 'CL29101095', '有', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '包装、装卸、上楼');
INSERT INTO `cityline` VALUES ('CI00000011', '武汉城市配送', '武汉城市配送', '1.80', '2015-05-04', 'CL29101095', '有', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '包装、装卸、上楼');
INSERT INTO `cityline` VALUES ('CI00000012', '石家庄城市配送', '石家庄城市配送', '1.80', '2015-05-05', 'CL29101095', '有', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '包装、装卸、上楼');
INSERT INTO `cityline` VALUES ('CI00000013', '成都城市配送', '成都城市配送', '1.80', '2015-05-06', 'CL29101095', '有', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '包装、装卸、上楼');
INSERT INTO `cityline` VALUES ('CI00000014', '太原城市配送', '太原城市配送', '1.80', '2015-05-07', 'CL29101095', '有', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '包装、装卸、上楼');
INSERT INTO `cityline` VALUES ('CI00000015', '兰州城市配送', '兰州城市配送', '1.80', '2015-05-08', 'CL29101095', '有', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '包装、装卸、上楼');
INSERT INTO `cityline` VALUES ('CI00000016', '厦门城市配送', '厦门城市配送', '1.80', '2015-03-24', 'CL29101095', '无', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '');
INSERT INTO `cityline` VALUES ('CI00000017', '杭州城市配送', '杭州城市配送', '1.90', '2015-03-25', 'CL73207711', '无', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '');
INSERT INTO `cityline` VALUES ('CI00000029', '索契青岛城市配送', '索契青岛城市配送', '1.60', '2015-03-24', 'CL73207711', '有', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '包装、装卸、上楼');
INSERT INTO `cityline` VALUES ('CI00000030', '索契大连城市配送', '索契大连城市配送', '1.60', '2015-05-04', 'CL73207711', '有', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '包装、装卸、上楼');
INSERT INTO `cityline` VALUES ('CI00000031', '友达北京城市配送', '友达北京城市配送', '1.50', '2015-05-04', 'CL73207711', '有', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '包装、装卸、上楼');
INSERT INTO `cityline` VALUES ('CI00000032', '友达通重庆城市配送', '友达通重庆城市配送', '1.50', '2015-05-04', 'CL73207711', '无', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '');
INSERT INTO `cityline` VALUES ('CI00000033', '友达通深圳城市配送', '友达通深圳城市配送', '1.50', '2015-03-24', 'CL73207711', '无', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '');
INSERT INTO `cityline` VALUES ('CI00000034', '友达通上海城市配送', '友达通上海城市配送', '1.50', '2015-03-24', 'CL73207711', '无', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '');
INSERT INTO `cityline` VALUES ('CI00000035', '友达通苏州城市配送', '友达通苏州城市配送', '1.50', '2015-05-04', 'CL41403136', '有', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '包装、装卸、上楼');
INSERT INTO `cityline` VALUES ('CI00000036', '友达通广州城市配送', '友达通广州城市配送', '1.60', '2015-03-24', 'CL41403136', '有', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '包装、装卸、上楼');
INSERT INTO `cityline` VALUES ('CI00000037', '友达通南京城市配送', '友达通南京城市配送', '1.60', '2015-03-24', 'CL41403136', '无', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '');
INSERT INTO `cityline` VALUES ('CI00000038', '友达通天津城市配送', '友达通天津城市配送', '1.60', '2015-05-04', 'CL41403136', '有', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '包装、装卸、上楼');
INSERT INTO `cityline` VALUES ('CI00000039', '友达通青岛城市配送', '友达通青岛城市配送', '1.60', '2015-03-24', 'CL41403136', '有', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '包装、装卸、上楼');
INSERT INTO `cityline` VALUES ('CI00000040', '友达通大连城市配送', '友达通大连城市配送', '1.60', '2015-05-04', 'CL41403136', '有', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '包装、装卸、上楼');
INSERT INTO `cityline` VALUES ('CI00000041', '天凯顺武汉城市配送', '天凯顺武汉城市配送', '2.00', '2015-05-04', 'CL41403136', '有', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '包装、装卸、上楼');
INSERT INTO `cityline` VALUES ('CI00000042', '天凯顺石家庄城市配送', '天凯顺石家庄城市配送', '2.00', '2015-05-04', 'CL41403136', '有', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '包装、装卸、上楼');

-- ----------------------------
-- Table structure for clientinfo
-- ----------------------------
DROP TABLE IF EXISTS `clientinfo`;
CREATE TABLE `clientinfo` (
  `id` varchar(255) NOT NULL,
  `realName` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `IDCard` varchar(255) DEFAULT NULL,
  `IDPicture` varchar(255) DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `carrierId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clientinfo
-- ----------------------------
INSERT INTO `clientinfo` VALUES ('C-0002', '郝晨栋', '男', '123123', null, '', '/usr/local/iver99/testfile.txt', '2015-05-31', null, null);
INSERT INTO `clientinfo` VALUES ('CL23767471', '郝晨栋', '男', '18888237738', 'haochendong@163.com', '130203199001011234', '/usr/local/iver99/testfile.txt', '2015-05-31', null, null);
INSERT INTO `clientinfo` VALUES ('CL78387917', '苏磊', '男', '13293049303', 'sulei@163.com', '130203199001011236', '/usr/local/iver99/testfile.txt', '2015-06-06', null, null);
INSERT INTO `clientinfo` VALUES ('CL81096930', '雷文雅', '女', '1832938483', 'leiwenya@163.com', '130203199001011235', '/usr/local/iver99/testfile.txt', '2015-06-06', null, null);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` varchar(255) NOT NULL,
  `orderId` varchar(255) DEFAULT NULL,
  `serviceAttitude` varchar(11) DEFAULT NULL,
  `transportEfficiency` varchar(11) DEFAULT NULL,
  `cargoSafety` varchar(11) DEFAULT NULL,
  `totalMoney` varchar(11) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `relDate` date DEFAULT NULL,
  `carId` varchar(11) DEFAULT NULL,
  `linetransportId` varchar(11) DEFAULT NULL,
  `citylineId` varchar(11) DEFAULT NULL,
  `warehouseId` varchar(11) DEFAULT NULL,
  `clientId` varchar(255) DEFAULT NULL,
  `carrierId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for companycertificate
-- ----------------------------
DROP TABLE IF EXISTS `companycertificate`;
CREATE TABLE `companycertificate` (
  `id` varchar(255) NOT NULL,
  `companyName` varchar(255) DEFAULT NULL,
  `divisionCode` varchar(255) DEFAULT NULL,
  `legalName` varchar(255) DEFAULT NULL,
  `legalIDCard` varchar(255) DEFAULT NULL,
  `companyAddr` varchar(255) DEFAULT NULL,
  `companyType` varchar(255) DEFAULT NULL,
  `companyScale` varchar(255) DEFAULT NULL,
  `invoiceKind` varchar(255) DEFAULT NULL,
  `serviceIndustry` varchar(255) DEFAULT NULL,
  `businessKind` varchar(255) DEFAULT NULL,
  `companyContact` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `basicSituation` varchar(255) DEFAULT NULL,
  `relatedMaterial` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of companycertificate
-- ----------------------------
INSERT INTO `companycertificate` VALUES ('CL29101095  ', '北京东方之星货运公司', 'DM32293222', '翟博渊', '12343234323232', '北京市海淀区交大东路', '国有企业', '1-50人', '增值税发票', '医药', '干线运输线路,城市配送网络', '翟博渊', '13298766695', '准备上市', 'D://uploadFile//companyCertificate//CL29101095_datian上线6-3.sql');
INSERT INTO `companycertificate` VALUES ('CL41403136', '上海德邦物流公司', 'DM32293222', '翟博渊', '12343234323232', '北京市海淀区交大东路', '合资企业', '50-200人', '非增值税发票', '电子', '干线运输线路,城市配送网络,仓储', '翟博渊', '13298766695', '准备扩大公司规模', 'D://uploadFile//companyCertificate//CL41403136_datian上线6-2.sql');
INSERT INTO `companycertificate` VALUES ('CL73207711', '上海德邦物流公司', 'DM23232311', '翟博眼', '123213234234', '上海市', '国有企业', '50-200人', '非增值税发票', '电子', '干线运输线路,城市配送网络', '翟博渊', '19237234234', '准备上市', 'D://uploadFile//companyCertificate//CL73207711_datian测试版.sql');

-- ----------------------------
-- Table structure for complaintform
-- ----------------------------
DROP TABLE IF EXISTS `complaintform`;
CREATE TABLE `complaintform` (
  `id` varchar(255) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `theme` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `relDate` date DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `orderId` varchar(255) DEFAULT NULL,
  `relatedMaterial` varchar(255) DEFAULT NULL,
  `feedback` varchar(255) DEFAULT NULL,
  `clientId` varchar(255) DEFAULT NULL,
  `carrierId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of complaintform
-- ----------------------------

-- ----------------------------
-- Table structure for contract
-- ----------------------------
DROP TABLE IF EXISTS `contract`;
CREATE TABLE `contract` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `carrierAccount` varchar(255) DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  `time` int(11) DEFAULT NULL,
  `caculateType` varchar(255) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `relatedMaterial` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `clientId` varchar(255) DEFAULT NULL,
  `carrierId` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  `monthlyStatementDays` varchar(255) DEFAULT NULL COMMENT '月结情况下的时间长度',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of contract
-- ----------------------------
INSERT INTO `contract` VALUES ('CO00000001', '运输合同', '北京市畅通达有限公司', '2015-01-25', '2015-02-25', null, '月结', '张明远', '15201112342', '/usr/local/iver99/testfile.txt', '无', 'CL23767471', 'CL29101095', '已终止', ' 特殊原因', '30天');
INSERT INTO `contract` VALUES ('CO00000002', '运输合同', '北京圆通有限公司', '2015-02-01', '2016-01-31', null, '月结', '李义达', '15929983120', '/usr/local/iver99/testfile.txt', '无', 'CL23767471', 'CL29101095', '已过期', '', '30天');
INSERT INTO `contract` VALUES ('CO00000003', '运输合同', '北京索契物流有限公司', '2015-02-01', '2016-01-31', null, '月结', '陈明', '13187340989', '/usr/local/iver99/testfile.txt', '无', 'CL23767471', 'CL73207711', '有效', '', '30天');
INSERT INTO `contract` VALUES ('CO00000004', '运输合同', '天津友达通有限公司', '2015-02-01', '2016-01-31', null, '月结', '王国权', '15151288481', '/usr/local/iver99/testfile.txt', '无', 'CL23767471', 'CL29101095', '有效', '', '30天');
INSERT INTO `contract` VALUES ('CO00000005', '运输合同', '济南德顺物流有限公司', '2015-02-01', '2016-01-31', null, '月结', '王亮', '18936991920', '/usr/local/iver99/testfile.txt', '无', 'CL23767471', 'CL41403136', '有效', '', '30天');
INSERT INTO `contract` VALUES ('CO00000006', '运输合同', '扬州万泰物流有限公司', '2015-02-01', '2016-01-31', null, '月结', '金荣汉', '13999261880', '/usr/local/iver99/testfile.txt', '无', 'CL23767471', 'CL29101095', '有效', '', '60天');
INSERT INTO `contract` VALUES ('CO00000007', '运输合同', '广州市远泰物流有限公司', '2015-02-01', '2016-01-31', null, '月结', '章翠秀', '13951590393', '/usr/local/iver99/testfile.txt', '无', 'CL81096930', 'CL29101095', '有效', '', '60天');
INSERT INTO `contract` VALUES ('CO00000008', '运输合同', '通捷恒远物流', '2015-02-01', '2016-01-31', null, '月结', '孙兆峰', '13064818806', '/usr/local/iver99/testfile.txt', '无', 'CL81096930', 'CL73207711', '有效', '', '30天');
INSERT INTO `contract` VALUES ('CO00000009', '运输合同', '天津天凯顺物流公司', '2015-02-01', '2016-01-31', null, '月结', '张瑜', '15630837858', '/usr/local/iver99/testfile.txt', '无', 'CL81096930', 'CL73207711', '有效', '', '30天');
INSERT INTO `contract` VALUES ('CO00000010', '运输合同', '天津昌茂物流有限公司', '2015-02-01', '2016-01-31', null, '月结', '朱彦冬', '13505220530', '/usr/local/iver99/testfile.txt', '无', 'CL81096930', 'CL73207711', '有效', '', '60天');
INSERT INTO `contract` VALUES ('CO00000011', '运输合同', '北京市畅通达有限公司', '2015-02-01', '2016-01-31', null, '月结', '梁文汉', '13902382915', '/usr/local/iver99/testfile.txt', '无', 'CL81096930', 'CL73207711', '有效', '', '60天');
INSERT INTO `contract` VALUES ('CO00000012', '运输合同', '北京圆通有限公司', '2015-02-01', '2016-01-31', null, '月结', '徐刚', '13902385181', '/usr/local/iver99/testfile.txt', '无', 'CL81096930', 'CL73207711', '有效', '', '30天');
INSERT INTO `contract` VALUES ('CO00000013', '运输合同', '北京索契物流有限公司', '2015-02-01', '2016-01-31', null, '月结', '李子佼', '13902389834', '/usr/local/iver99/testfile.txt', '无', 'CL81096930', 'CL73207711', '有效', '', '30天');
INSERT INTO `contract` VALUES ('CO00000014', '运输合同', '天津友达通有限公司', '2015-02-01', '2016-01-31', null, '月结', '王强', '13902384771', '/usr/local/iver99/testfile.txt', '无', 'CL81096930', 'CL41403136', '有效', '', '30天');
INSERT INTO `contract` VALUES ('CO00000015', '运输合同', '济南德顺物流有限公司', '2015-02-01', '2016-01-31', null, '月结', '丁一鸣', '13902384702', '/usr/local/iver99/testfile.txt', '无', 'CL78387917', 'CL41403136', '有效', '', '30天');
INSERT INTO `contract` VALUES ('CO00000016', '运输合同', '扬州万泰物流有限公司', '2015-02-01', '2016-01-31', null, '月结', '张元平', '13902385294', '/usr/local/iver99/testfile.txt', '无', 'CL78387917', 'CL41403136', '有效', '', '60天');
INSERT INTO `contract` VALUES ('CO00000017', '运输合同', '广州市远泰物流有限公司', '2015-02-01', '2016-01-31', null, '月结', '王一帆', '13902385631', '/usr/local/iver99/testfile.txt', '无', 'CL78387917', 'CL29101095', '有效', '', '60天');
INSERT INTO `contract` VALUES ('CO00000018', '运输合同', '通捷恒远物流', '2015-02-01', '2016-01-31', null, '月结', '傅彬', '13902383675', '/usr/local/iver99/testfile.txt', '无', 'CL78387917', 'CL41403136', '有效', '', '60天');
INSERT INTO `contract` VALUES ('CO00000019', '运输合同', '天津天凯顺物流公司', '2015-02-01', '2016-01-31', null, '月结', '李艳', '13902380989', '/usr/local/iver99/testfile.txt', '无', 'CL78387917', 'CL41403136', '有效', '', '60天');
INSERT INTO `contract` VALUES ('CO00000020', '运输合同', '天津昌茂物流有限公司', '2015-02-01', '2016-01-31', null, '月结', '刘欣瑜', '13902382601', '/usr/local/iver99/testfile.txt', '无', 'CL78387917', 'CL41403136', '有效', '', '30天');

-- ----------------------------
-- Table structure for driverinfo
-- ----------------------------
DROP TABLE IF EXISTS `driverinfo`;
CREATE TABLE `driverinfo` (
  `id` varchar(255) NOT NULL,
  `driverName` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `licenceRate` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `relDate` date DEFAULT NULL,
  `IDCard` varchar(255) DEFAULT NULL,
  `licenceNum` varchar(255) DEFAULT NULL,
  `licenceTime` date DEFAULT NULL,
  `carrierId` varchar(255) DEFAULT NULL,
  `carId` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `idscans` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of driverinfo
-- ----------------------------
INSERT INTO `driverinfo` VALUES ('DR00000014', '张云强', '男', '27', 'A', '13010310007', '2015-05-16', '120101197702098198', '220100796814', '2004-09-15', 'CL29101095', 'CAR00000014', '', '/usr/local/iver99/testfile.txt');
INSERT INTO `driverinfo` VALUES ('DR00000023', '汪家根', '男', '41', 'A', '13010310005', '2015-05-16', '120101197702093290', '510400514547', '2007-08-03', 'CL29101095', 'CAR00000023', '', '/usr/local/iver99/testfile.txt');
INSERT INTO `driverinfo` VALUES ('DR00000024', '胡锦峰', '男', '27', 'A', '13829970912', '2015-05-16', '420101198204018197', '510400514547', '2011-05-06', 'CL29101095', 'CAR00000024', '', '/usr/local/iver99/testfile.txt');
INSERT INTO `driverinfo` VALUES ('DR00000025', '冯西德', '男', '38', 'A', '13010310010', '2015-05-16', '120101197702098411', '230101082684', '2007-02-28', 'CL29101095', 'CAR00000025', '', '/usr/local/iver99/testfile.txt');
INSERT INTO `driverinfo` VALUES ('DR00000026', '王成龙', '男', '26', 'A', '13829659039', '2015-05-16', '42010119820401513X', '220100796814', '2006-03-12', 'CL29101095', 'CAR00000026', '', '/usr/local/iver99/testfile.txt');
INSERT INTO `driverinfo` VALUES ('DR00000027', '邓中元', '男', '39', 'A', '13829813809', '2015-05-16', '420101198204018218', '110008685523', '2011-09-23', 'CL29101095', 'CAR00000027', '', '/usr/local/iver99/testfile.txt');
INSERT INTO `driverinfo` VALUES ('DR00000028', '恽赛虹', '男', '33', 'A', '13980400024', '2015-05-16', '410106198312035752', '231100633466', '2008-05-06', 'CL29101095', 'CAR00000028', '', '/usr/local/iver99/testfile.txt');
INSERT INTO `driverinfo` VALUES ('DR00000029', '李英铭', '男', '38', 'A', '13016429091', '2015-05-16', '110101197405012130', '110008685523', '2008-04-01', 'CL29101095', 'CAR00000029', '', '/usr/local/iver99/testfile.txt');
INSERT INTO `driverinfo` VALUES ('DR00000030', '陈新峰', '男', '47', 'A', '13829973945', '2015-05-16', '340101197708045477', '220100796814', '2006-03-12', 'CL29101095', 'CAR00000030', '', '/usr/local/iver99/testfile.txt');
INSERT INTO `driverinfo` VALUES ('DR00000031', '曾俊波', '男', '39', 'A', '13016284720', '2015-05-16', '120101197702092538', '230101082684', '2007-02-28', 'CL29101095', 'CAR00000031', '', '/usr/local/iver99/testfile.txt');
INSERT INTO `driverinfo` VALUES ('DR00000032', '郭锦宁', '男', '29', 'A', '13829094612', '2015-05-16', '420101198204012131', '231100633466', '2010-12-18', 'CL29101095', 'CAR00000032', '', '/usr/local/iver99/testfile.txt');
INSERT INTO `driverinfo` VALUES ('DR00000033', '王海', '男', '28', 'A', '13010310000', '2015-05-16', '120101197702095691', '110008685523', '2011-09-23', 'CL29101095', 'CAR00000033', '', '/usr/local/iver99/testfile.txt');
INSERT INTO `driverinfo` VALUES ('DR00000034', '夏歌', '男', '31', 'A', '13862380001', '2015-05-16', '210101198010155573', '220100796814', '2006-03-12', 'CL73207711', 'CAR00000034', '', '/usr/local/iver99/testfile.txt');
INSERT INTO `driverinfo` VALUES ('DR00000035', '张敏坚', '男', '26', 'A', '13829058690', '2015-05-16', '420101198204016693', '230101082684', '2010-10-09', 'CL73207711', 'CAR00000035', '', '/usr/local/iver99/testfile.txt');
INSERT INTO `driverinfo` VALUES ('DR00000036', '吴烜', '男', '30', 'A', '13512299008', '2015-05-16', '110101197405018890', '230101082684', '2007-02-28', 'CL73207711', 'CAR00000036', '', '/usr/local/iver99/testfile.txt');
INSERT INTO `driverinfo` VALUES ('DR00000037', '王振基', '男', '45', 'A', '13010310001', '2015-05-16', '120101197702092992', '231100633466', '2008-05-06', 'CL73207711', 'CAR00000037', '', '/usr/local/iver99/testfile.txt');
INSERT INTO `driverinfo` VALUES ('DR00000038', '崔敬柱', '男', '28', 'A', '13016369950', '2015-05-16', '11010119740501315X', '230101082684', '2010-10-09', 'CL73207711', 'CAR00000038', '', '/usr/local/iver99/testfile.txt');
INSERT INTO `driverinfo` VALUES ('DR00000039', '王现涛', '男', '36', 'A', '13016015981', '2015-05-16', '110101197405012974', '231100633466', '2010-12-18', 'CL73207711', 'CAR00000039', '', '/usr/local/iver99/testfile.txt');
INSERT INTO `driverinfo` VALUES ('DR00000040', '累林', '男', '32', 'A', '13829452089', '2015-05-16', '210101198010157472', '231100633466', '2008-05-06', 'CL73207711', 'CAR00000040', '', '/usr/local/iver99/testfile.txt');
INSERT INTO `driverinfo` VALUES ('DR00000041', '石向东', '男', '31', 'A', '13829840784', '2015-05-16', '210101198010153594', '510400514547', '2007-08-03', 'CL73207711', 'CAR00000041', '', '/usr/local/iver99/testfile.txt');
INSERT INTO `driverinfo` VALUES ('DR00000053', '王靖', '女', '32', 'A', '13980400042', '2015-05-16', '410106198312035517', '220100796814', '2004-09-15', 'CL73207711', 'CAR00000053', '', '/usr/local/iver99/testfile.txt');
INSERT INTO `driverinfo` VALUES ('DR00000054', '刘俸岐', '男', '30', 'A', '13829578076', '2015-05-16', '340101197708042110', '110008685523', '2011-09-23', 'CL73207711', 'CAR00000054', '', '/usr/local/iver99/testfile.txt');
INSERT INTO `driverinfo` VALUES ('DR00000055', '程树林', '男', '38', 'A', '13829676258', '2015-05-16', '340101197708047333', '230101082684', '2007-02-28', 'CL73207711', 'CAR00000055', '', '/usr/local/iver99/testfile.txt');
INSERT INTO `driverinfo` VALUES ('DR00000064', '王军', '男', '38', 'A', '13016113492', '2015-05-16', '11010119740501171X', '231100633466', '2008-05-06', 'CL73207711', 'CAR00000064', '', '/usr/local/iver99/testfile.txt');
INSERT INTO `driverinfo` VALUES ('DR00000065', '周智鹏', '男', '31', 'A', '13829854993', '2015-05-16', '420101198204014815', '510400514547', '2007-08-03', 'CL73207711', 'CAR00000065', '', '/usr/local/iver99/testfile.txt');
INSERT INTO `driverinfo` VALUES ('DR00000066', '孙璐', '男', '39', 'A', '13829902823', '2015-05-16', '420101198204015973', '220100796814', '2006-03-12', 'CL73207711', 'CAR00000066', '', '/usr/local/iver99/testfile.txt');
INSERT INTO `driverinfo` VALUES ('DR00000067', '詹志兵', '男', '32', 'A', '13829824963', '2015-05-16', '41010619831203133X', '230101082684', '2010-10-09', 'CL73207711', 'CAR00000067', '', '/usr/local/iver99/testfile.txt');
INSERT INTO `driverinfo` VALUES ('DR00000068', '杨园禾', '男', '26', 'A', '13829634842', '2015-05-16', '340101197708041898', '220100796814', '2006-03-12', 'CL41403136', 'CAR00000068', '', '/usr/local/iver99/testfile.txt');
INSERT INTO `driverinfo` VALUES ('DR00000069', '廖水金', '男', '47', 'A', '13817550007', '2015-05-16', '120101197702095819', '231100633466', '2008-05-06', 'CL41403136', 'CAR00000069', '', '/usr/local/iver99/testfile.txt');
INSERT INTO `driverinfo` VALUES ('DR00000070', '陈凯', '男', '39', 'A', '13829475321', '2015-05-16', '340101197708041230', '230101082684', '2010-10-09', 'CL41403136', 'CAR00000070', '', '/usr/local/iver99/testfile.txt');
INSERT INTO `driverinfo` VALUES ('DR00000071', '刘飞', '男', '36', 'A', '13817550017', '2015-05-16', '21010119801015743X', '110008685523', '2008-04-01', 'CL41403136', 'CAR00000071', '', '/usr/local/iver99/testfile.txt');
INSERT INTO `driverinfo` VALUES ('DR00000072', '冯少斌', '男', '32', 'A', '13016851918', '2015-05-16', '110101197405018559', '110008685523', '2008-04-01', 'CL41403136', 'CAR00000072', '', '/usr/local/iver99/testfile.txt');
INSERT INTO `driverinfo` VALUES ('DR00000073', '庄连杰', '男', '32', 'A', '13010310017', '2015-05-16', '120101197702099377', '510400514547', '2011-05-06', 'CL41403136', 'CAR00000073', '', '/usr/local/iver99/testfile.txt');
INSERT INTO `driverinfo` VALUES ('DR00000074', '孙灿', '男', '27', 'A', '13662500001', '2015-05-16', '210101198010152073', '231100633466', '2010-12-18', 'CL41403136', 'CAR00000074', '', '/usr/local/iver99/testfile.txt');
INSERT INTO `driverinfo` VALUES ('DR00000075', '王长海', '男', '47', 'A', '13829571887', '2015-05-16', '42010119820401919X', '230101082684', '2010-10-09', 'CL41403136', 'CAR00000075', '', '/usr/local/iver99/testfile.txt');
INSERT INTO `driverinfo` VALUES ('DR00000076', '李志江', '男', '29', 'A', '13829135183', '2015-05-16', '340101197708045290', '110008685523', '2008-04-01', 'CL41403136', 'CAR00000076', '', '/usr/local/iver99/testfile.txt');
INSERT INTO `driverinfo` VALUES ('DR00000077', '杨茂东', '男', '32', 'A', '13817550010', '2015-05-16', '120101197702092079', '510400514547', '2007-08-03', 'CL41403136', 'CAR00000077', '', '/usr/local/iver99/testfile.txt');
INSERT INTO `driverinfo` VALUES ('DR00000078', '李春晟', '男', '32', 'A', '13509180007', '2015-05-16', '210101198010159814', '230101082684', '2007-02-28', 'CL41403136', 'CAR00000078', '', '/usr/local/iver99/testfile.txt');
INSERT INTO `driverinfo` VALUES ('DR00000079', '胡长志', '男', '31', 'A', '13509180005', '2015-05-16', '210101198010159291', '220100796814', '2004-09-15', 'CL41403136', 'CAR00000079', '', '/usr/local/iver99/testfile.txt');
INSERT INTO `driverinfo` VALUES ('DR00000100', '楚晓', '男', '29', 'A', '13662500005', '2015-05-16', '210101198010151150', '510400514547', '2011-05-06', 'CL41403136', 'CAR00000100', '', '/usr/local/iver99/testfile.txt');

-- ----------------------------
-- Table structure for focus
-- ----------------------------
DROP TABLE IF EXISTS `focus`;
CREATE TABLE `focus` (
  `id` varchar(255) DEFAULT NULL,
  `clientId` varchar(255) DEFAULT NULL,
  `focusType` varchar(255) DEFAULT NULL,
  `focusId` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of focus
-- ----------------------------

-- ----------------------------
-- Table structure for goodsform
-- ----------------------------
DROP TABLE IF EXISTS `goodsform`;
CREATE TABLE `goodsform` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `transportType` varchar(255) DEFAULT NULL,
  `weight` float(10,0) DEFAULT NULL,
  `startPlace` varchar(255) DEFAULT NULL,
  `endPlace` varchar(255) DEFAULT NULL,
  `relDate` date DEFAULT NULL,
  `limitDate` date DEFAULT NULL,
  `transportReq` varchar(255) DEFAULT NULL,
  `damageReq` varchar(255) DEFAULT NULL,
  `VIPService` varchar(255) DEFAULT NULL,
  `VIPServiceDetail` varchar(255) DEFAULT NULL,
  `oriented` varchar(255) DEFAULT NULL,
  `feedbackQuantity` int(11) DEFAULT '0',
  `invoice` varchar(255) DEFAULT NULL,
  `relatedMaterial` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `clientId` varchar(255) DEFAULT NULL,
  `carrierId` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goodsform
-- ----------------------------
INSERT INTO `goodsform` VALUES ('GO00000017', '日照到徐州货源', '医药', '整车', '12', '莒县', '沛县', '2015-04-15', '2015-04-24', '无', '若出现丢失或破损，须照原价赔偿', '不需要', '送货上门', '用户', '0', '不需要', '/usr/local/iver99/testfile.txt', '待确认', 'CL23767471', '', '本批货物为贵重物品，请轻拿轻放');
INSERT INTO `goodsform` VALUES ('GO00000018', '赤峰到乌兰浩特货源', '医药', '整车', '40', '天山', '扎兰屯', '2015-04-15', '2015-04-24', '无', '若出现丢失或破损，须照原价赔偿', '不需要', '送货上门', '用户', '0', '需要', '/usr/local/iver99/testfile.txt', '待确认', 'CL23767471', '', '本批货物为贵重物品，如果运输途中损坏需要照价赔偿');
INSERT INTO `goodsform` VALUES ('GO00000033', '松原到青岛货源', '医药', '零担', '1', '扶余', '青岛', '2015-04-15', '2015-04-24', '可拼车', '若出现丢失或破损，须照原价赔偿', '不需要', '送货上门', '用户', '0', '需要', '/usr/local/iver99/testfile.txt', '待确认', 'CL81096930', '', '本批货物为贵重物品，如果运输途中损坏需要照价赔偿');
INSERT INTO `goodsform` VALUES ('GO00000034', '宝应到兰州货源', '电子仪器', '整车', '38', '宝应', '兰州', '2015-04-15', '2015-04-24', '车长13米，高栏车', '若出现丢失或破损，须照原价赔偿', '不需要', '送货上门', '用户', '0', '需要', '/usr/local/iver99/testfile.txt', '待确认', 'CL81096930', '', '本批货物为贵重物品，请轻拿轻放');
INSERT INTO `goodsform` VALUES ('GO00000035', '张家港到赤峰货源', '电子仪器', '整车', '29', '张家港', '赤峰', '2015-01-26', '2015-01-29', '无', '若出现丢失或破损，须照原价赔偿', '不需要', '送货上门', '用户', '0', '需要', '/usr/local/iver99/testfile.txt', '已确认', 'CL81096930', 'CL29101095', '本批货物为贵重物品，请轻拿轻放');
INSERT INTO `goodsform` VALUES ('GO00000037', '邯郸到唐山货源', '服装', '整车', '80', '邯郸', '唐山', '2015-01-26', '2015-01-29', '无', '若出现丢失或破损，须照原价赔偿', '不需要', '送货上门', '用户', '0', '需要', '/usr/local/iver99/testfile.txt', '待确认', 'CL81096930', '', '本批货物为贵重物品，如果运输途中损坏需要照价赔偿');
INSERT INTO `goodsform` VALUES ('GO00000038', '胶州到莱芜货源', '服装', '整车', '40', '胶州', '莱芜', '2015-01-26', '2015-01-29', '平板车', '若出现丢失或破损，须照原价赔偿', '不需要', '送货上门', '用户', '0', '需要', '/usr/local/iver99/testfile.txt', '待确认', 'CL78387917', '', '本批货物为贵重物品，请轻拿轻放');
INSERT INTO `goodsform` VALUES ('GO00000039', '静宁到敦煌货源', '服装', '整车', '11', '静宁', '敦煌', '2015-01-26', '2015-01-29', '6.6米高栏车', '若出现丢失或破损，须照原价赔偿', '不需要', '送货上门', '用户', '0', '需要', '/usr/local/iver99/testfile.txt', '已确认', 'CL78387917', 'CL29101095', '本批货物为贵重物品，请轻拿轻放');
INSERT INTO `goodsform` VALUES ('GO00000040', '成都到宜宾货源', '服装', '整车', '10', '成都', '宜宾', '2015-01-26', '2015-01-29', '6.8米高栏车', '若出现丢失或破损，须照原价赔偿', '不需要', '送货上门', '用户', '0', '需要', '/usr/local/iver99/testfile.txt', '已确认', 'CL78387917', 'CL73207711', '本批货物为贵重物品，如果运输途中损坏需要照价赔偿');

-- ----------------------------
-- Table structure for linetransport
-- ----------------------------
DROP TABLE IF EXISTS `linetransport`;
CREATE TABLE `linetransport` (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `lineName` varchar(255) DEFAULT NULL,
  `startPlace` varchar(255) DEFAULT NULL,
  `endPlace` varchar(255) DEFAULT NULL,
  `onWayTime` int(11) DEFAULT NULL,
  `refPrice` float(10,0) DEFAULT NULL,
  `relDate` date DEFAULT NULL,
  `carrierId` varchar(255) DEFAULT NULL,
  `detailPrice` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of linetransport
-- ----------------------------
INSERT INTO `linetransport` VALUES ('LI00000003', '上海到广州', '上海', '广州', '24', '1', '2015-04-28', 'CL29101095', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '零担');
INSERT INTO `linetransport` VALUES ('LI00000004', '苏州到北京', '苏州', '北京', '36', '3', '2015-05-30', 'CL29101095', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '整车');
INSERT INTO `linetransport` VALUES ('LI00000005', '天津到大连', '天津', '大连', '12', '2', '2015-04-28', 'CL29101095', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '零担');
INSERT INTO `linetransport` VALUES ('LI00000007', '广州到重庆', '广州', '重庆', '36', '3', '2015-04-28', 'CL29101095', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '整车');
INSERT INTO `linetransport` VALUES ('LI00000008', '青岛到北京', '青岛', '北京', '12', '2', '2015-04-28', 'CL29101095', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '零担');
INSERT INTO `linetransport` VALUES ('LI00000009', '青岛到苏州', '青岛', '苏州', '24', '1', '2015-04-28', 'CL29101095', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '零担');
INSERT INTO `linetransport` VALUES ('LI00000010', '青岛到深圳', '青岛', '深圳', '36', '3', '2015-04-28', 'CL29101095', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '整车');
INSERT INTO `linetransport` VALUES ('LI00000011', '北京到深圳', '北京', '深圳', '24', '2', '2015-04-28', 'CL73207711', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '整车');
INSERT INTO `linetransport` VALUES ('LI00000012', '重庆到南京', '重庆', '南京', '24', '2', '2015-04-28', 'CL73207711', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '零担');
INSERT INTO `linetransport` VALUES ('LI00000022', '成都到太原', '成都', '太原', '24', '2', '2015-04-28', 'CL73207711', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '零担');
INSERT INTO `linetransport` VALUES ('LI00000023', '兰州到厦门', '兰州', '厦门', '24', '2', '2015-04-28', 'CL73207711', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '零担');
INSERT INTO `linetransport` VALUES ('LI00000024', '杭州到哈尔滨', '杭州', '哈尔滨', '24', '2', '2015-04-28', 'CL73207711', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '零担');
INSERT INTO `linetransport` VALUES ('LI00000025', '长春到常州', '长春', '常州', '24', '2', '2015-04-28', 'CL73207711', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '零担');
INSERT INTO `linetransport` VALUES ('LI00000026', '武汉到厦门', '武汉', '厦门', '24', '2', '2015-04-28', 'CL73207711', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '零担');
INSERT INTO `linetransport` VALUES ('LI00000034', '杭州到哈尔滨', '杭州', '哈尔滨', '12', '3', '2015-04-28', 'CL73207711', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '零担');
INSERT INTO `linetransport` VALUES ('LI00000035', '长春到常州', '长春', '常州', '12', '3', '2015-04-28', 'CL73207711', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '零担');
INSERT INTO `linetransport` VALUES ('LI00000036', '武汉到厦门', '武汉', '厦门', '12', '3', '2015-04-28', 'CL41403136', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '零担');
INSERT INTO `linetransport` VALUES ('LI00000037', '杭州到常州', '杭州', '常州', '12', '3', '2015-04-28', 'CL41403136', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '零担');
INSERT INTO `linetransport` VALUES ('LI00000038', '成都到哈尔滨', '成都', '哈尔滨', '12', '3', '2015-04-28', 'CL41403136', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '零担');
INSERT INTO `linetransport` VALUES ('LI00000039', '长春到太原', '长春', '太原', '12', '3', '2015-04-28', 'CL41403136', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '零担');
INSERT INTO `linetransport` VALUES ('LI00000040', '成都到常州', '成都', '常州', '12', '3', '2015-04-28', 'CL41403136', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '零担');
INSERT INTO `linetransport` VALUES ('LI00000041', '北京到深圳', '北京', '深圳', '12', '3', '2015-04-28', 'CL41403136', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '整车');
INSERT INTO `linetransport` VALUES ('LI00000042', '重庆到南京', '重庆', '南京', '12', '3', '2015-04-28', 'CL41403136', '/usr/local/iver99/testfile.txt', '1）重量与体积之比小于1：4时即为泡货，按轻货报价计费。2）时限从货物到达始发站的次日零时起开始计算。3）所有报价均不含保险，保险费率为货物声明价值的0.3%。4）以上报价为门到门价格，不含装卸、分拣、上楼等操作费用。如需装卸，装卸费另计。', '零担');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` varchar(255) DEFAULT NULL,
  `clientId` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `relDate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------

-- ----------------------------
-- Table structure for orderform
-- ----------------------------
DROP TABLE IF EXISTS `orderform`;
CREATE TABLE `orderform` (
  `id` varchar(255) NOT NULL,
  `orderNum` varchar(255) DEFAULT NULL,
  `clientName` varchar(255) DEFAULT NULL,
  `isLinkToClientWayBill` varchar(255) DEFAULT NULL,
  `clientWayBillNum` varchar(255) DEFAULT NULL,
  `hasCarrierContract` varchar(255) DEFAULT NULL,
  `contractId` varchar(255) DEFAULT NULL,
  `companyName` varchar(255) DEFAULT NULL,
  `resourceName` varchar(255) DEFAULT NULL,
  `resourceType` varchar(255) DEFAULT NULL,
  `submitTime` datetime DEFAULT NULL,
  `deliveryAddr` varchar(255) DEFAULT NULL,
  `deliveryName` varchar(255) DEFAULT NULL,
  `deliveryPhone` varchar(255) DEFAULT NULL,
  `recieverAddr` varchar(255) DEFAULT NULL,
  `recieverName` varchar(255) DEFAULT NULL,
  `recieverPhone` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `goodsName` varchar(255) DEFAULT NULL,
  `goodsWeight` float(10,0) DEFAULT NULL,
  `goodsVolume` float(10,0) DEFAULT NULL,
  `declaredPrice` float(10,0) DEFAULT NULL,
  `expectedPrice` float(10,0) DEFAULT '0',
  `actualPrice` float(10,0) DEFAULT '0',
  `insurance` float(10,0) DEFAULT '0',
  `acceptPicture` varchar(255) DEFAULT NULL,
  `explainReason` varchar(255) DEFAULT NULL,
  `carNum` varchar(255) DEFAULT NULL,
  `driver` varchar(255) DEFAULT NULL,
  `clientId` varchar(255) DEFAULT NULL,
  `carrierId` varchar(255) DEFAULT NULL,
  `citylineId` varchar(255) DEFAULT NULL,
  `linetransportId` varchar(255) DEFAULT NULL,
  `warehouseId` varchar(255) DEFAULT NULL,
  `cancelReason` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL COMMENT '订单状态',
  `settlementState` varchar(255) DEFAULT NULL,
  `commentId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderform
-- ----------------------------

-- ----------------------------
-- Table structure for response
-- ----------------------------
DROP TABLE IF EXISTS `response`;
CREATE TABLE `response` (
  `id` varchar(255) NOT NULL,
  `committer` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `goodsId` varchar(255) DEFAULT NULL,
  `clientId` varchar(255) DEFAULT NULL,
  `carrierId` varchar(255) DEFAULT NULL,
  `relatedMaterial` varchar(255) DEFAULT NULL,
  `relDate` datetime DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of response
-- ----------------------------

-- ----------------------------
-- Table structure for subaccount
-- ----------------------------
DROP TABLE IF EXISTS `subaccount`;
CREATE TABLE `subaccount` (
  `id` varchar(255) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `resourceManagement` varchar(255) DEFAULT NULL,
  `transactionManagement` varchar(255) DEFAULT NULL,
  `schemaManagement` varchar(255) DEFAULT NULL,
  `statisticsManagement` varchar(255) DEFAULT NULL,
  `hostAccountName` varchar(255) DEFAULT NULL,
  `hostAccountId` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `relDate` date DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subaccount
-- ----------------------------

-- ----------------------------
-- Table structure for track
-- ----------------------------
DROP TABLE IF EXISTS `track`;
CREATE TABLE `track` (
  `id` varchar(255) NOT NULL,
  `orderNum` varchar(255) DEFAULT NULL,
  `carNum` varchar(255) DEFAULT NULL,
  `locLongitude` double(12,8) DEFAULT NULL,
  `locLatitude` double(12,8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of track
-- ----------------------------
INSERT INTO `track` VALUES ('T-0001', 'y53031440', '京AB0001', '116.30193400', '39.97755200');
INSERT INTO `track` VALUES ('T-0002', 'y53031440', '京AB0001', '116.33147000', '39.98689500');
INSERT INTO `track` VALUES ('T-0003', 'y53031440', '京AB0001', '116.40656800', '39.98816700');
INSERT INTO `track` VALUES ('T-0004', 'y53031440', '京AB0001', '116.47958300', '39.95432600');
INSERT INTO `track` VALUES ('T-0005', 'y53031441', '京AB0003', '116.40656800', '39.98816700');
INSERT INTO `track` VALUES ('T-0006', 'y53031440', '京AB0001', '116.50832800', '39.91914100');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `id` varchar(255) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `privilege` varchar(255) DEFAULT NULL,
  `userKind` int(11) DEFAULT NULL COMMENT '1代表管理员，2代表普通用户，3代表企业用户，',
  `validateTime` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `emailStatus` varchar(255) DEFAULT NULL,
  `phoneStatus` varchar(255) DEFAULT NULL,
  `securityQuestionStatus` varchar(255) DEFAULT NULL,
  `securityQuestionOne` varchar(255) DEFAULT NULL,
  `securityAnswerOne` varchar(255) DEFAULT NULL,
  `securityQuestionTwo` varchar(255) DEFAULT NULL,
  `securityAnswerTwo` varchar(255) DEFAULT NULL,
  `securityQuestionThree` varchar(255) DEFAULT NULL,
  `securityAnswerThree` varchar(255) DEFAULT NULL,
  `headIcon` varchar(255) DEFAULT NULL,
  `feedback` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('C-0002', 'admin', '21232F297A57A5A743894A0E4A801FC3', '', '1233@163.com', null, '1', null, '已审核', '已绑定', '已绑定', '已设置', '您的生日？', '1', '您最尊敬的人？', '2', '您的第一任班主任？', '3', '未设置', null);
INSERT INTO `userinfo` VALUES ('CL23767471', 'user1', '24C9E15E52AFC47C225B757E7BEE1F9D', '18301930384', null, null, '2', null, '已审核', '未绑定', '已绑定', '未设置', null, null, null, null, null, null, '未设置', null);
INSERT INTO `userinfo` VALUES ('CL29101095', 'company1', 'DF655F976F7C9D3263815BD981225CD9', '18393882934', null, null, '3', null, '未验证', '未绑定', '已绑定', '未设置', null, null, null, null, null, null, '未设置', null);
INSERT INTO `userinfo` VALUES ('CL41403136', 'company3', 'E828AE3339B8D80B3902C1564578804E', '17833948392', null, null, '3', null, '未验证', '未绑定', '已绑定', '未设置', null, null, null, null, null, null, '未设置', null);
INSERT INTO `userinfo` VALUES ('CL73207711', 'company2', 'D196A28097115067FEFD73D25B0C0BE8', '18893849584', null, null, '3', null, '未验证', '未绑定', '已绑定', '未设置', null, null, null, null, null, null, '未设置', null);
INSERT INTO `userinfo` VALUES ('CL78387917', 'user3', '92877AF70A45FD6A2ED7FE81E1236B78', '13293049303', null, null, '2', null, '未验证', '未绑定', '已绑定', '未设置', null, null, null, null, null, null, '未设置', null);
INSERT INTO `userinfo` VALUES ('CL81096930', 'user2', '7E58D63B60197CEB55A1C487989A3720', '1832938483', null, null, '2', null, '未验证', '未绑定', '已绑定', '未设置', null, null, null, null, null, null, '未设置', null);

-- ----------------------------
-- Table structure for warehouse
-- ----------------------------
DROP TABLE IF EXISTS `warehouse`;
CREATE TABLE `warehouse` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `kind` varchar(255) DEFAULT NULL,
  `houseArea` float(10,0) DEFAULT NULL,
  `yardArea` float(10,0) DEFAULT NULL,
  `height` float(10,0) DEFAULT NULL,
  `fireRate` varchar(255) DEFAULT NULL,
  `storageForm` varchar(255) DEFAULT NULL,
  `fireSecurity` varchar(255) DEFAULT NULL,
  `environment` varchar(255) DEFAULT NULL,
  `serviceContent` varchar(255) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `detailPrice` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `carrierId` varchar(255) DEFAULT NULL,
  `relDate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of warehouse
-- ----------------------------
INSERT INTO `warehouse` VALUES ('RE00000001', '1号库', '北京', '北京市海淀区', '保税', '自有', '20000', '6000', '6', '乙', '露天', '烟感', 'Internet宽带接入', '机械出入库搬运', '张三', '13900003366', '/usr/local/iver99/testfile.txt', '无', 'CL29101095', '2015-05-20');
INSERT INTO `warehouse` VALUES ('RE00000002', '22号库', '上海', '上海市浦东区', '保税', '自有', '10000', '6000', '5', '甲', '冷藏', '烟感', 'Internet宽带接入', '机械出入库搬运', '孙武', '13900003367', '/usr/local/iver99/testfile.txt', '无', 'CL29101095', '2015-05-31');
INSERT INTO `warehouse` VALUES ('RE00000003', '3号库', '北京', '北京市朝阳区', '保税', '自有', '10000', '6000', '4', '甲', '冷藏', '24小时摄像监控', '仓库信息管理系统', '分拣', '孙亮', '13900003368', '/usr/local/iver99/testfile.txt', '', 'CL29101095', '2015-05-20');
INSERT INTO `warehouse` VALUES ('RE00000004', '4号库', '天津', '天津市西青区', '保税', '自有', '30000', '8000', '8', '乙', '露天', '烟感, 24小时摄像监控', '仓库信息管理系统', '机械出入库搬运', '王楠', '13925456563', '/usr/local/iver99/testfile.txt', '', 'CL29101095', '2015-05-20');
INSERT INTO `warehouse` VALUES ('RE00000005', '55号库', '广州', '广州市天河区', '保税', '自有', '20000', '6000', '6', '丙', '冷藏', '24小时摄像监控', '仓库信息管理系统', '分拣', '李四', '13845478789', '/usr/local/iver99/testfile.txt', '', 'CL29101095', '2015-05-30');
INSERT INTO `warehouse` VALUES ('RE00000006', '林安库', '广州', '广州市林安区', '保税', '自有', '50000', '5000', '5', '甲', '冷藏', '烟感, 24小时摄像监控', 'Internet宽带接入', '分拣, 包装', '陈泽', '15621545698', '/usr/local/iver99/testfile.txt', '', 'CL29101095', '2015-05-20');
INSERT INTO `warehouse` VALUES ('RE00000007', '浦西库', '上海', '上海市浦西区', '非保税', '自有', '40000', '6000', '6', '甲', '恒温', '烟感, 24小时摄像监控', '信息系统', '机械出入库搬运', '王铎', '16565323656', '/usr/local/iver99/testfile.txt', '', 'CL29101095', '2015-05-20');
INSERT INTO `warehouse` VALUES ('RE00000008', '西青库', '天津', '天津市西青区', '保税', '自有', '60000', '8000', '8', '丙', '普通', '烟感, 24小时摄像监控', '仓库信息管理系统', '分拣, 包装', '李萍', '15545236569', '/usr/local/iver99/testfile.txt', '', 'CL41403136', '2015-05-20');
INSERT INTO `warehouse` VALUES ('RE00000009', '海淀库', '北京', '北京市海淀区', '非保税', '自有', '20000', '4000', '4', '乙', '冷藏', '烟感, 24小时摄像监控', '信息系统', '分拣, 包装', '陈楠', '19656523256', '/usr/local/iver99/testfile.txt', '', 'CL41403136', '2015-05-20');
INSERT INTO `warehouse` VALUES ('RE00000010', '河西库', '天津', '天津市河西区', '非保税', '自有', '10000', '5000', '4', '甲', '冷藏', '烟感, 24小时摄像监控', '信息系统', '机械出入库搬运', '王伟', '12656532323', '/usr/local/iver99/testfile.txt', '', 'CL41403136', '2015-05-20');
INSERT INTO `warehouse` VALUES ('RE00000011', '501库', '天津', '天津市西青区', '保税', '自有', '30000', '6000', '5', '甲', '冷藏', '烟感, 24小时摄像监控', '仓库信息管理系统', '分拣, 包装', '李毅', '15645423569', '/usr/local/iver99/testfile.txt', '', 'CL41403136', '2015-05-20');
INSERT INTO `warehouse` VALUES ('RE00000012', '502库', '上海', '上海市浦东区', '保税', '自有', '30000', '8000', '6', '甲', '露天', '烟感, 24小时摄像监控', 'Internet宽带接入', '机械出入库搬运', '陈伟', '17565498653', '/usr/local/iver99/testfile.txt', '', 'CL73207711', '2015-05-20');
INSERT INTO `warehouse` VALUES ('RE00000013', '503库', '青岛', '青岛市', '非保税', '租赁', '10000', '4000', '3', '丙', '冷藏', '24小时摄像监控', 'Internet宽带接入', '分拣', '孙楠', '16632569874', '/usr/local/iver99/testfile.txt', '', 'CL73207711', '2015-05-20');
INSERT INTO `warehouse` VALUES ('RE00000014', '504库', '广州', '广州市林安区', '非保税', '租赁', '20000', '5000', '4', '乙', '冷藏', '烟感, 24小时摄像监控', '信息系统', '分拣, 包装', '孙成', '14523265654', '/usr/local/iver99/testfile.txt', '', 'CL73207711', '2015-05-20');
INSERT INTO `warehouse` VALUES ('RE00000015', '505库', '南京', '南京市', '保税', '自有', '50000', '6000', '8', '甲', '露天', '烟感, 24小时摄像监控', '仓库信息管理系统', '机械出入库搬运', '李平', '12545456365', '/usr/local/iver99/testfile.txt', '', 'CL73207711', '2015-05-20');
INSERT INTO `warehouse` VALUES ('RE00000016', '西青A库', '天津', '天津市西青区', '保税', '自有', '20000', '5000', '6', '甲', '冷藏', '烟感, 24小时摄像监控', '仓库信息管理系统', '分拣, 包装', '陈增', '12354565569', '/usr/local/iver99/testfile.txt', '', 'CL73207711', '2015-05-20');
INSERT INTO `warehouse` VALUES ('RE00000017', '河西A库', '天津', '天津市河西区', '非保税', '租赁', '10000', '3000', '3', '丙', '冷藏', '24小时摄像监控', 'Internet宽带接入', '分拣', '陈平', '15845423265', '/usr/local/iver99/testfile.txt', '', 'CL73207711', '2015-05-20');
INSERT INTO `warehouse` VALUES ('RE00000018', '朝阳A库', '北京', '北京市朝阳区', '非保税', '自有', '30000', '5000', '4', '乙', '恒温', '烟感, 24小时摄像监控', '信息系统', '分拣, 包装', '王五', '15698654541', '/usr/local/iver99/testfile.txt', '', 'CL73207711', '2015-05-20');
INSERT INTO `warehouse` VALUES ('RE00000019', '机场A库', '北京', '北京市朝阳区', '保税', '自有', '50000', '6000', '8', '甲', '普通', '烟感, 24小时摄像监控', '仓库信息管理系统', '机械出入库搬运', '李德', '16898956565', '/usr/local/iver99/testfile.txt', '', 'CL41403136', '2015-05-20');
INSERT INTO `warehouse` VALUES ('RE00000020', '西青B库', '天津', '天津市西青区', '非保税', '自有', '30000', '6000', '6', '甲', '冷藏', '烟感, 24小时摄像监控', '仓库信息管理系统', '分拣, 包装', '陈怡', '14545254566', '/usr/local/iver99/testfile.txt', '', 'CL41403136', '2015-05-20');

-- ----------------------------
-- View structure for car_carrier_view
-- ----------------------------
DROP VIEW IF EXISTS `car_carrier_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `car_carrier_view` AS SELECT
carinfo.carLength,
carinfo.carNum,
carinfo.carTeam,
carinfo.carUse,
carinfo.carLocation,
carinfo.relDate,
carinfo.carType,
carinfo.linetransportId,
carinfo.locLongitude,
carinfo.locLatitude,
carinfo.locationType,
carinfo.carBrand,
carinfo.`storage`,
carinfo.carrierId,
carinfo.carWeight,
carinfo.carState,
carinfo.driverId,
carinfo.purchaseTime,
carinfo.id,
carrierinfo.companyName,
carinfo.carBase,
carinfo.carWidth,
carinfo.carHeight,
carinfo.terminalId,
carinfo.stopPlace,
carinfo.startPlace,
carinfo.endPlace
FROM
carinfo ,
carrierinfo
WHERE
carinfo.carrierId = carrierinfo.id ; ;

-- ----------------------------
-- View structure for city_carrier_view
-- ----------------------------
DROP VIEW IF EXISTS `city_carrier_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `city_carrier_view` AS SELECT
carrierinfo.companyName,
cityline.id,
cityline.cityName,
cityline.refPrice,
cityline.relDate,
cityline.carrierId,
cityline.VIPService,
cityline.detailPrice,
cityline.remarks,
carrierinfo.creditRate,
cityline.`name`
FROM
carrierinfo ,
cityline
WHERE
carrierinfo.id = cityline.carrierId ; ;

-- ----------------------------
-- View structure for complaint_client_view
-- ----------------------------
DROP VIEW IF EXISTS `complaint_client_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost`  VIEW `complaint_client_view` AS SELECT
complaintform.id,
complaintform.type,
complaintform.theme,
complaintform.content,
complaintform.relDate,
complaintform.state,
complaintform.orderId,
complaintform.relatedMaterial,
complaintform.feedback,
complaintform.clientId,
complaintform.carrierId,
clientinfo.realName
FROM
complaintform ,
clientinfo
WHERE
complaintform.clientId = clientinfo.id ; ;

-- ----------------------------
-- View structure for focus_car_view
-- ----------------------------
DROP VIEW IF EXISTS `focus_car_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `focus_car_view` AS SELECT
focus.id,
focus.clientId,
focus.focusType,
focus.focusId,
focus.`status`,
carinfo.carNum,
carinfo.carrierId,
carrierinfo.companyName,
carinfo.relDate,
carinfo.linetransportId
FROM
focus ,
carinfo ,
carrierinfo
WHERE
focus.focusId = carinfo.id AND
carinfo.carrierId = carrierinfo.id ; ;

-- ----------------------------
-- View structure for focus_cityline_view
-- ----------------------------
DROP VIEW IF EXISTS `focus_cityline_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `focus_cityline_view` AS SELECT
focus.id,
focus.clientId,
focus.focusType,
focus.focusId,
focus.`status`,
cityline.`name`,
carrierinfo.companyName,
cityline.carrierId,
cityline.relDate
FROM
focus ,
cityline ,
carrierinfo
WHERE
focus.focusId = cityline.id AND
cityline.carrierId = carrierinfo.id ; ;

-- ----------------------------
-- View structure for focus_company_view
-- ----------------------------
DROP VIEW IF EXISTS `focus_company_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `focus_company_view` AS SELECT
focus.id,
focus.clientId,
focus.focusType,
focus.focusId,
focus.`status`,
carrierinfo.companyName,
carrierinfo.relDate,
carrierinfo.id AS carrierId
FROM
focus ,
carrierinfo
WHERE
focus.focusId = carrierinfo.id ;

-- ----------------------------
-- View structure for focus_goods_view
-- ----------------------------
DROP VIEW IF EXISTS `focus_goods_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost`  VIEW `focus_goods_view` AS SELECT
focus.id,
focus.clientId,
focus.focusType,
focus.focusId,
focus.`status`,
goodsform.`name`,
goodsform.relDate
FROM
focus ,
goodsform
WHERE
focus.focusId = goodsform.id ; ;

-- ----------------------------
-- View structure for focus_linetransport_view
-- ----------------------------
DROP VIEW IF EXISTS `focus_linetransport_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `focus_linetransport_view` AS SELECT
focus.id,
focus.clientId,
focus.focusType,
focus.focusId,
focus.`status`,
linetransport.startPlace,
linetransport.endPlace,
carrierinfo.companyName,
linetransport.carrierId,
linetransport.relDate
FROM
focus ,
linetransport ,
carrierinfo
WHERE
focus.focusId = linetransport.id AND
linetransport.carrierId = carrierinfo.id ; ;

-- ----------------------------
-- View structure for focus_warehouse_view
-- ----------------------------
DROP VIEW IF EXISTS `focus_warehouse_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `focus_warehouse_view` AS SELECT
warehouse.`name`,
carrierinfo.companyName,
warehouse.carrierId,
focus.id,
focus.clientId,
focus.focusType,
focus.focusId,
focus.`status`,
warehouse.relDate
FROM
focus ,
warehouse ,
carrierinfo
WHERE
focus.focusId = warehouse.id AND
warehouse.carrierId = carrierinfo.id ; ;

-- ----------------------------
-- View structure for goods_client_view
-- ----------------------------
DROP VIEW IF EXISTS `goods_client_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `goods_client_view` AS SELECT
goodsform.id,
goodsform.`name`,
goodsform.transportType,
goodsform.weight,
goodsform.startPlace,
goodsform.endPlace,
goodsform.relDate,
goodsform.limitDate,
goodsform.transportReq,
goodsform.damageReq,
goodsform.VIPService,
goodsform.oriented,
goodsform.invoice,
goodsform.relatedMaterial,
goodsform.state,
goodsform.clientId,
goodsform.remarks,
clientinfo.realName,
goodsform.type,
clientinfo.phone,
clientinfo.carrierId,
goodsform.VIPServiceDetail
FROM
clientinfo ,
goodsform
WHERE
clientinfo.id = goodsform.clientId ; ;

-- ----------------------------
-- View structure for goods_response_view
-- ----------------------------
DROP VIEW IF EXISTS `goods_response_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `goods_response_view` AS SELECT
response.committer,
response.phone,
response.goodsId,
response.clientId,
response.carrierId,
response.remarks,
goodsform.id,
response.id AS responseId,
goodsform.state,
goodsform.`name`,
response.relatedMaterial,
response.relDate
FROM
goodsform ,
response
WHERE
goodsform.id = response.goodsId ; ;

-- ----------------------------
-- View structure for line_carrier_view
-- ----------------------------
DROP VIEW IF EXISTS `line_carrier_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `line_carrier_view` AS SELECT
carrierinfo.companyName,
linetransport.startPlace,
linetransport.endPlace,
linetransport.carrierId,
linetransport.id,
linetransport.onWayTime,
linetransport.refPrice,
linetransport.relDate,
linetransport.detailPrice,
linetransport.remarks,
linetransport.type,
linetransport.lineName
FROM
carrierinfo ,
linetransport
WHERE
carrierinfo.id = linetransport.carrierId ; ;

-- ----------------------------
-- View structure for order_carrier_view
-- ----------------------------
DROP VIEW IF EXISTS `order_carrier_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `order_carrier_view` AS SELECT
carrierinfo.companyName AS carrierName,
carrierinfo.companyAccount AS carrierAccount,
orderform.id,
orderform.goodsName,
orderform.carrierId,
orderform.expectedPrice,
orderform.actualPrice,
orderform.submitTime,
orderform.state,
orderform.deliveryAddr,
orderform.deliveryName,
orderform.deliveryPhone,
orderform.recieverAddr,
orderform.recieverName,
orderform.recieverPhone,
orderform.warehouseId,
orderform.citylineId,
orderform.linetransportId,
orderform.remarks,
orderform.insurance,
orderform.clientId,
orderform.goodsWeight,
orderform.goodsVolume,
orderform.contractId,
orderform.acceptPicture,
orderform.resourceType,
orderform.carNum,
orderform.driver,
orderform.commentId,
orderform.explainReason,
orderform.orderNum,
orderform.clientName,
orderform.hasCarrierContract,
orderform.declaredPrice,
orderform.cancelReason,
orderform.isLinkToClientWayBill,
orderform.clientWayBillNum,
orderform.resourceName
FROM
orderform ,
carrierinfo
WHERE
orderform.carrierId = carrierinfo.id ; ;

-- ----------------------------
-- View structure for settlement_carrier_view
-- ----------------------------
DROP VIEW IF EXISTS `settlement_carrier_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `settlement_carrier_view` AS SELECT
orderform.orderNum,
orderform.clientName,
orderform.contractId,
orderform.submitTime,
orderform.settlementState,
orderform.actualPrice,
orderform.expectedPrice,
orderform.carrierId,
carrierinfo.id AS carrierId2,
carrierinfo.companyName,
orderform.id
FROM
orderform ,
carrierinfo
WHERE
orderform.carrierId = carrierinfo.id ; ;

-- ----------------------------
-- View structure for warehouse_carrier_view
-- ----------------------------
DROP VIEW IF EXISTS `warehouse_carrier_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost`  VIEW `warehouse_carrier_view` AS SELECT
warehouse.id,
warehouse.`name`,
warehouse.city,
warehouse.address,
warehouse.type,
warehouse.kind,
warehouse.houseArea,
warehouse.yardArea,
warehouse.height,
warehouse.fireRate,
warehouse.storageForm,
warehouse.fireSecurity,
warehouse.environment,
warehouse.serviceContent,
warehouse.contact,
warehouse.phone,
warehouse.detailPrice,
warehouse.remarks,
warehouse.carrierId,
warehouse.relDate,
carrierinfo.companyName
FROM
warehouse ,
carrierinfo
WHERE
warehouse.carrierId = carrierinfo.id ;
