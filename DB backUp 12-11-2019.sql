/*
SQLyog Community v12.4.0 (64 bit)
MySQL - 5.5.13 : Database - orffo_hotel_billing
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`orffo_hotel_billing` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `orffo_hotel_billing`;

/*Table structure for table `address_master` */

DROP TABLE IF EXISTS `address_master`;

CREATE TABLE `address_master` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(200) DEFAULT NULL,
  `line_one` varchar(250) NOT NULL,
  `l_line_one` varchar(250) DEFAULT NULL,
  `line_two` varchar(250) DEFAULT NULL,
  `l_line_two` varchar(250) DEFAULT NULL,
  `line_three` varchar(250) DEFAULT NULL,
  `l_line_three` varchar(250) DEFAULT NULL,
  `area_id` int(10) DEFAULT NULL,
  `city_id` int(10) DEFAULT NULL,
  `taluk_id` int(10) DEFAULT NULL,
  `district_id` int(10) DEFAULT NULL,
  `state_id` int(10) DEFAULT NULL,
  `country_id` int(10) DEFAULT NULL,
  `land_mark` varchar(250) DEFAULT NULL,
  `postal_code` varchar(10) DEFAULT NULL,
  `geo_coordinates` varchar(100) DEFAULT NULL,
  `created_by` int(10) NOT NULL,
  `created_date` datetime NOT NULL,
  `modified_by` int(10) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `version` int(10) NOT NULL,
  `CODE` varchar(20) DEFAULT NULL,
  `sync_code` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_address_master_synccode` (`sync_code`),
  UNIQUE KEY `uq_addressmaster_code` (`CODE`),
  UNIQUE KEY `uq_addressmaster_name` (`NAME`),
  KEY `fk_addressmaster_areaid` (`area_id`),
  CONSTRAINT `fk_addressmaster_areaid` FOREIGN KEY (`area_id`) REFERENCES `area_master` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `address_master` */

/*Table structure for table `app_config` */

DROP TABLE IF EXISTS `app_config`;

CREATE TABLE `app_config` (
  `app_key` varchar(100) NOT NULL,
  `app_value` varchar(100) NOT NULL,
  `created_by` int(10) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modified_by` int(10) DEFAULT NULL,
  `modified_date` timestamp NULL DEFAULT NULL,
  `version` int(10) NOT NULL,
  PRIMARY KEY (`app_key`),
  KEY `fk_app_config_createdby` (`created_by`),
  KEY `fk_app_config_modifiedby` (`modified_by`),
  CONSTRAINT `fk_app_config_createdby` FOREIGN KEY (`created_by`) REFERENCES `user_master` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_app_config_modifiedby` FOREIGN KEY (`modified_by`) REFERENCES `user_master` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `app_config` */

/*Table structure for table `app_feature` */

DROP TABLE IF EXISTS `app_feature`;

CREATE TABLE `app_feature` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `version` int(10) DEFAULT NULL,
  `created_by` int(10) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `description` varchar(255) DEFAULT NULL,
  `feature_name` varchar(255) NOT NULL,
  `style_class` varchar(255) DEFAULT NULL,
  `application_id` int(10) DEFAULT NULL,
  `parent_id` int(10) DEFAULT NULL,
  `modified_by` int(10) DEFAULT NULL,
  `modified_date` timestamp NULL DEFAULT NULL,
  `action_key` varchar(255) NOT NULL,
  `code` varchar(255) NOT NULL,
  `has_file_movement` tinyint(1) DEFAULT NULL,
  `active_status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_appfeature_feature_name` (`feature_name`),
  UNIQUE KEY `uq_appfeature_code` (`code`),
  KEY `fk_appfeature_parentid` (`parent_id`),
  CONSTRAINT `fk_appfeature_parentid` FOREIGN KEY (`parent_id`) REFERENCES `app_feature` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `app_feature` */

insert  into `app_feature`(`id`,`version`,`created_by`,`created_date`,`description`,`feature_name`,`style_class`,`application_id`,`parent_id`,`modified_by`,`modified_date`,`action_key`,`code`,`has_file_movement`,`active_status`) values 
(1,0,1,'2017-10-20 00:58:09','Group','Group','menuLevelTwo',1,1,NULL,NULL,'stmenu','USER_MANAGEMENT_GROUP',NULL,NULL);

/*Table structure for table `area_master` */

DROP TABLE IF EXISTS `area_master`;

CREATE TABLE `area_master` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city_id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `l_name` varchar(100) DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `created_date` date NOT NULL,
  `modified_by` int(11) DEFAULT NULL,
  `modified_date` date DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `active_status` tinyint(1) DEFAULT NULL,
  `code` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_area_master_cityidname` (`city_id`,`name`),
  UNIQUE KEY `uq_area_master_namecity` (`name`,`city_id`),
  UNIQUE KEY `uq_area_master_code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `area_master` */

/*Table structure for table `bind_opff` */

DROP TABLE IF EXISTS `bind_opff`;

CREATE TABLE `bind_opff` (
  `BIND_OFF_PK` int(10) NOT NULL AUTO_INCREMENT,
  `BIND_OFF_ID` varchar(20) DEFAULT NULL,
  `ITEM_FK` int(10) DEFAULT NULL,
  `BIND_OFF_DATE` date DEFAULT NULL,
  `BIND_OFF_TAX_FK` int(10) DEFAULT NULL,
  `TOTAL_SELL_ITEM_QUANTITY` int(10) DEFAULT NULL,
  `TOTAL_SELL_ITEM_PRICE` double DEFAULT NULL,
  `TOTAL_SELL_SERVICE_CHARGES` double DEFAULT NULL,
  `TOTAL_SELL_PACKAGING_CHARGES` double DEFAULT NULL,
  `TOTAL_RETURN_ITEM_QUANTITY` int(10) DEFAULT NULL,
  `TOTAL_RETURN_ITEM_PRICE` double DEFAULT NULL,
  `TOTAL_RETURN_SERVICE_CHARGES` double DEFAULT NULL,
  `TOTAL_RETURN_PACKAGING_CHARGES` double DEFAULT NULL,
  `CREATED_BY` int(10) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `MODIFY_BY` int(10) DEFAULT NULL,
  `MODIFY_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`BIND_OFF_PK`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `bind_opff` */

/*Table structure for table `bind_opff_tax` */

DROP TABLE IF EXISTS `bind_opff_tax`;

CREATE TABLE `bind_opff_tax` (
  `BIND_OFF_TAX_PK` int(10) NOT NULL AUTO_INCREMENT,
  `TAX_FK` int(10) DEFAULT NULL,
  `TAX_PERSENT` double DEFAULT NULL,
  `TAX_VALUE` double DEFAULT NULL,
  `CREATED_BY` int(10) DEFAULT NULL,
  `CREATED_DATE` double DEFAULT NULL,
  `MODIFY_BY` int(10) DEFAULT NULL,
  `MODIFY_DATE` double DEFAULT NULL,
  PRIMARY KEY (`BIND_OFF_TAX_PK`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `bind_opff_tax` */

/*Table structure for table `entity_master` */

DROP TABLE IF EXISTS `entity_master`;

CREATE TABLE `entity_master` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `entity_type_id` int(10) DEFAULT NULL,
  `parent_id` int(10) DEFAULT NULL,
  `code` varchar(150) NOT NULL,
  `name` varchar(150) NOT NULL,
  `address_id` int(10) DEFAULT NULL,
  `gst_number` varchar(20) DEFAULT NULL,
  `active_status` tinyint(1) NOT NULL,
  `created_by` int(10) DEFAULT NULL,
  `created_date` datetime NOT NULL,
  `modified_by` int(10) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `region_id` int(10) DEFAULT NULL,
  `version` int(10) DEFAULT NULL,
  `contact_number` varchar(50) DEFAULT NULL,
  `email_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_entitymaster_code` (`code`),
  UNIQUE KEY `uq_entitymaster_name` (`name`),
  KEY `fk_entitymaster_addressid` (`address_id`),
  KEY `fk_entitymaster_entitytypeid` (`entity_type_id`),
  KEY `fk_entitymaster_parentid` (`parent_id`),
  KEY `fk_entitymaster_regionid` (`region_id`),
  CONSTRAINT `fk_entitymaster_addressid` FOREIGN KEY (`address_id`) REFERENCES `address_master` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_entitymaster_entitytypeid` FOREIGN KEY (`entity_type_id`) REFERENCES `entity_type_master` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_entitymaster_parentid` FOREIGN KEY (`parent_id`) REFERENCES `entity_master` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_entitymaster_regionid` FOREIGN KEY (`region_id`) REFERENCES `entity_master` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `entity_master` */

insert  into `entity_master`(`id`,`entity_type_id`,`parent_id`,`code`,`name`,`address_id`,`gst_number`,`active_status`,`created_by`,`created_date`,`modified_by`,`modified_date`,`region_id`,`version`,`contact_number`,`email_id`) values 
(3,NULL,NULL,'Mark','MarkSolution',NULL,'GST_0120',1,809,'2019-03-06 16:06:33',NULL,NULL,NULL,1,'996956859',NULL);

/*Table structure for table `entity_type_master` */

DROP TABLE IF EXISTS `entity_type_master`;

CREATE TABLE `entity_type_master` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) DEFAULT NULL,
  `l_name` varchar(150) DEFAULT NULL,
  `created_by` int(10) DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modified_by` int(10) DEFAULT NULL,
  `modified_date` timestamp NULL DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `group_name` varchar(100) DEFAULT NULL,
  `version` int(10) DEFAULT NULL,
  `active_status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_entitytypemaster_code` (`code`),
  UNIQUE KEY `uq_entitytypemaster_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `entity_type_master` */

/*Table structure for table `item_billing` */

DROP TABLE IF EXISTS `item_billing`;

CREATE TABLE `item_billing` (
  `ITEM_BILLING_PK` int(10) NOT NULL AUTO_INCREMENT,
  `ITEM_BILLING_NO` varchar(20) DEFAULT NULL,
  `ITEM_BILLING_DATE` timestamp NULL DEFAULT NULL,
  `ITEM_BILLING_ITEM_FK` int(10) DEFAULT NULL,
  `ITEM_BILLING_ITEM_QUANTITY` int(10) DEFAULT NULL,
  `ITEM_BILLING_ITEM_PRICE` double DEFAULT NULL,
  `ITEM_BILLING_SERVICE_CHARGES` double DEFAULT NULL,
  `ITEM_BILLING_PACKING_CHARGES` double DEFAULT NULL,
  `ITEM_BILLING_TAX_FK` int(10) DEFAULT NULL,
  `ITEM_BILLING_ITEM_RETURN_FK` int(10) DEFAULT NULL,
  `CREATED_BY` int(10) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `MODIFY_BY` int(10) DEFAULT NULL,
  `MODIFY_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`ITEM_BILLING_PK`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `item_billing` */

/*Table structure for table `item_billing_tax` */

DROP TABLE IF EXISTS `item_billing_tax`;

CREATE TABLE `item_billing_tax` (
  `ITEM_BILLING_TAX_PK` int(10) NOT NULL AUTO_INCREMENT,
  `ITEM_BILLING_FK` int(10) DEFAULT NULL,
  `TAX_FK` int(10) DEFAULT NULL,
  `TAX_PERSENT` double DEFAULT NULL,
  `TAX_AMOUNT` double DEFAULT NULL,
  `CREATED_BY` int(10) DEFAULT NULL,
  `CREATED_DATE` double DEFAULT NULL,
  `MODIFY_BY` int(10) DEFAULT NULL,
  `MODIFY_DATE` double DEFAULT NULL,
  PRIMARY KEY (`ITEM_BILLING_TAX_PK`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `item_billing_tax` */

/*Table structure for table `item_return_billing` */

DROP TABLE IF EXISTS `item_return_billing`;

CREATE TABLE `item_return_billing` (
  `ITEM_RETURN_BILLING_PK` int(10) NOT NULL AUTO_INCREMENT,
  `ITEM_RETURN_BILLING_NO` varchar(20) DEFAULT NULL,
  `ITEM_RETURN_BILLING_DATE` timestamp NULL DEFAULT NULL,
  `ITEM_RETURN_ITEM_FK` int(10) DEFAULT NULL,
  `ITEM_RETURN_ITEM_QUANTITY` int(10) DEFAULT NULL,
  `ITEM_RETURN_ITEM_PRICE` double DEFAULT NULL,
  `ITEM_RETURN_SERVICE_CHARGES` double DEFAULT NULL,
  `ITEM_RETURN_PACKING_CHARGES` double DEFAULT NULL,
  `ITEM_RETURN_TAX_FK` int(10) DEFAULT NULL,
  `ITEM_BILLING_ITEM_RETURN_FK` int(10) DEFAULT NULL,
  `CREATED_BY` int(10) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `MODIFY_BY` int(10) DEFAULT NULL,
  `MODIFY_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`ITEM_RETURN_BILLING_PK`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `item_return_billing` */

/*Table structure for table `item_return_billing_tax` */

DROP TABLE IF EXISTS `item_return_billing_tax`;

CREATE TABLE `item_return_billing_tax` (
  `ITEM_RETURN_BILLING_TAX_PK` int(10) NOT NULL AUTO_INCREMENT,
  `ITEM_RETURN_BILLING_FK` int(10) DEFAULT NULL,
  `TAX_FK` int(10) DEFAULT NULL,
  `TAX_PERSENT` double DEFAULT NULL,
  `TAX_AMOUNT` double DEFAULT NULL,
  `CREATED_BY` int(10) DEFAULT NULL,
  `CREATED_DATE` double DEFAULT NULL,
  `MODIFY_BY` int(10) DEFAULT NULL,
  `MODIFY_DATE` double DEFAULT NULL,
  PRIMARY KEY (`ITEM_RETURN_BILLING_TAX_PK`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `item_return_billing_tax` */

/*Table structure for table `item_stock` */

DROP TABLE IF EXISTS `item_stock`;

CREATE TABLE `item_stock` (
  `ITEM_STOCK_PK` int(10) NOT NULL AUTO_INCREMENT,
  `ITEM_STOCK_ID` varchar(10) DEFAULT NULL,
  `ITEM_FK` int(10) DEFAULT NULL,
  `ITEM_STOCK_DATE` datetime DEFAULT NULL,
  `ITEM_UOM_FK` int(10) DEFAULT NULL,
  `ITEM_PURCHASE_TOTAL_QUANTITY` double DEFAULT NULL,
  `ITEM_PURCHASE_TOTAL_PRICE` double DEFAULT NULL,
  `ITEM_COST` double DEFAULT NULL,
  `ITEM_DAMAGE_TOTAL_QUANTITY` double DEFAULT NULL,
  `ITEM_DAMAGE_TOTAL_PRICE` double DEFAULT NULL,
  `ITEM_STOCK_STATUS` varchar(1) DEFAULT NULL COMMENT '''A'' ACTIVE, ''I'' INACTIVE',
  `CREATED_BY` int(10) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `MODIFY_BY` int(10) DEFAULT NULL,
  `MODIFY_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`ITEM_STOCK_PK`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `item_stock` */

/*Table structure for table `itrm_master` */

DROP TABLE IF EXISTS `itrm_master`;

CREATE TABLE `itrm_master` (
  `ITEM_PK` int(10) NOT NULL AUTO_INCREMENT,
  `ITEM_CODE` varchar(20) DEFAULT NULL,
  `ITEM_NAME` varchar(100) DEFAULT NULL,
  `ITEM_TYPE` int(1) DEFAULT NULL COMMENT '''1'' RAW ITEM,''2'' SELLING ITREM',
  `ITEM_UOM_FK` int(10) DEFAULT NULL,
  `ITEM_PURCHASE_PRICE` double DEFAULT NULL,
  `ITEM_SEKLLING_PRICE` double DEFAULT NULL,
  `ITEM_OFFER_TYPE` varchar(1) DEFAULT NULL COMMENT '''D'' DISCOUNT , ''N'' NON DISCOUNT',
  `ITEM_PHOTO_PATH` varchar(300) DEFAULT NULL,
  `ITEM_STATUS` varchar(1) DEFAULT NULL COMMENT '''A'' ACTIVE, ''I'' INACTIVE',
  `CREATED_BY` int(10) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `MODIFY_BY` int(10) DEFAULT NULL,
  `MODIFY_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`ITEM_PK`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `itrm_master` */

/*Table structure for table `itrm_tax_master` */

DROP TABLE IF EXISTS `itrm_tax_master`;

CREATE TABLE `itrm_tax_master` (
  `ITEM_TAX_PK` int(10) NOT NULL AUTO_INCREMENT,
  `ITEM_TAX_FK` int(10) DEFAULT NULL,
  `ITEM_FK` int(10) DEFAULT NULL,
  `ITEM_TAX_PERSENT` double DEFAULT NULL,
  `ITEM_TAX_VALUE` double DEFAULT NULL,
  `CREATED_BY` int(10) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `MODIFY_BY` int(10) DEFAULT NULL,
  `MODIFY_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`ITEM_TAX_PK`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `itrm_tax_master` */

/*Table structure for table `role_feature` */

DROP TABLE IF EXISTS `role_feature`;

CREATE TABLE `role_feature` (
  `role_id` int(10) NOT NULL,
  `feature_id` int(10) NOT NULL,
  PRIMARY KEY (`role_id`,`feature_id`),
  KEY `fk_rolefeature_featureid` (`feature_id`),
  CONSTRAINT `fk_rolefeature_featureid` FOREIGN KEY (`feature_id`) REFERENCES `app_feature` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_rolefeature_roleid` FOREIGN KEY (`role_id`) REFERENCES `role_master` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `role_feature` */

insert  into `role_feature`(`role_id`,`feature_id`) values 
(1,1);

/*Table structure for table `role_master` */

DROP TABLE IF EXISTS `role_master`;

CREATE TABLE `role_master` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(250) NOT NULL,
  `created_by` int(10) DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modified_by` int(10) DEFAULT NULL,
  `modified_date` timestamp NULL DEFAULT NULL,
  `version` int(10) DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT '0',
  `application_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_role_master_rolename` (`role_name`),
  KEY `fk_role_master_createdby` (`created_by`),
  KEY `fk_role_master_modifiedby` (`modified_by`),
  CONSTRAINT `fk_role_master_createdby` FOREIGN KEY (`created_by`) REFERENCES `user_master` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_role_master_modifiedby` FOREIGN KEY (`modified_by`) REFERENCES `user_master` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `role_master` */

insert  into `role_master`(`id`,`role_name`,`created_by`,`created_date`,`modified_by`,`modified_date`,`version`,`STATUS`,`application_id`) values 
(1,'Admin',1,'2019-03-06 21:39:18',NULL,NULL,NULL,1,2);

/*Table structure for table `role_user` */

DROP TABLE IF EXISTS `role_user`;

CREATE TABLE `role_user` (
  `user_id` int(10) NOT NULL,
  `role_id` int(10) NOT NULL,
  `id_unique` int(10) DEFAULT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `fk_role_user_roleid` (`role_id`),
  CONSTRAINT `fk_role_user_roleid` FOREIGN KEY (`role_id`) REFERENCES `role_master` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_role_user_userid` FOREIGN KEY (`user_id`) REFERENCES `user_master` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `role_user` */

insert  into `role_user`(`user_id`,`role_id`,`id_unique`) values 
(1,1,1);

/*Table structure for table `tax_master` */

DROP TABLE IF EXISTS `tax_master`;

CREATE TABLE `tax_master` (
  `TAX_PK` int(10) NOT NULL AUTO_INCREMENT,
  `TAX_CODE` varchar(10) DEFAULT NULL,
  `TAX_NAME` varchar(100) DEFAULT NULL,
  `CREATED_BY` int(10) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `MODIFY_BY` int(10) DEFAULT NULL,
  `MODIFY_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`TAX_PK`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tax_master` */

/*Table structure for table `used_stock` */

DROP TABLE IF EXISTS `used_stock`;

CREATE TABLE `used_stock` (
  `USED_STOCK_PK` int(10) NOT NULL AUTO_INCREMENT,
  `USED_STOCK_ID` varchar(20) DEFAULT NULL,
  `STOCK_FK` int(10) DEFAULT NULL,
  `USED_ITEM_FK` int(10) DEFAULT NULL,
  `USED_ITEM_UOM_FK` int(10) DEFAULT NULL,
  `USED_DATE` datetime DEFAULT NULL,
  `USED_TOTAL_QUANTITY` double DEFAULT NULL,
  `USED_TOTAL_PRICE` double DEFAULT NULL,
  `CREATED_BY` int(10) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `MODIFY_BY` int(10) DEFAULT NULL,
  `MODIFY_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`USED_STOCK_PK`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `used_stock` */

/*Table structure for table `user_feature` */

DROP TABLE IF EXISTS `user_feature`;

CREATE TABLE `user_feature` (
  `user_id` int(10) NOT NULL,
  `feature_id` int(10) NOT NULL,
  PRIMARY KEY (`user_id`,`feature_id`),
  KEY `fk_user_feature_featureid` (`feature_id`),
  CONSTRAINT `fk_user_feature_featureid` FOREIGN KEY (`feature_id`) REFERENCES `app_feature` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_user_feature_userid` FOREIGN KEY (`user_id`) REFERENCES `user_master` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user_feature` */

/*Table structure for table `user_master` */

DROP TABLE IF EXISTS `user_master`;

CREATE TABLE `user_master` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `PASSWORD` varchar(250) DEFAULT NULL,
  `created_by` int(10) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` int(10) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `VERSION` int(10) DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT '1',
  `user_type` varchar(100) DEFAULT NULL,
  `email_id` varchar(150) DEFAULT NULL,
  `second_password` varchar(200) DEFAULT NULL,
  `mobile_number` varchar(10) DEFAULT NULL,
  `entity_id` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_usermaster_username` (`username`),
  KEY `fk_usermaster_createdby` (`created_by`),
  KEY `fk_usermaster_entity_id_pk` (`entity_id`),
  KEY `fk_usermaster_modifiedby` (`modified_by`),
  CONSTRAINT `fk_usermaster_createdby` FOREIGN KEY (`created_by`) REFERENCES `user_master` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_usermaster_entity_id_pk` FOREIGN KEY (`entity_id`) REFERENCES `entity_master` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_usermaster_modifiedby` FOREIGN KEY (`modified_by`) REFERENCES `user_master` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `user_master` */

insert  into `user_master`(`id`,`username`,`PASSWORD`,`created_by`,`created_date`,`modified_by`,`modified_date`,`VERSION`,`STATUS`,`user_type`,`email_id`,`second_password`,`mobile_number`,`entity_id`) values 
(1,'admin','/RJFtj5I3i+EBkpN955nyXGxnP2Mo6eO4bSD7RDROudDrhaQVOqz3Y14',NULL,'2018-09-21 21:19:20',NULL,NULL,1,1,'ADMIN_USER',NULL,NULL,NULL,3);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
