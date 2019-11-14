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

/*Table structure for table `act_evt_log` */

DROP TABLE IF EXISTS `act_evt_log`;

CREATE TABLE `act_evt_log` (
  `LOG_NR_` bigint(20) NOT NULL AUTO_INCREMENT,
  `TYPE_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TIME_STAMP_` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DATA_` longblob,
  `LOCK_OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `LOCK_TIME_` timestamp NULL DEFAULT NULL,
  `IS_PROCESSED_` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`LOG_NR_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_evt_log` */

/*Table structure for table `act_ge_bytearray` */

DROP TABLE IF EXISTS `act_ge_bytearray`;

CREATE TABLE `act_ge_bytearray` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DEPLOYMENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `BYTES_` longblob,
  `GENERATED_` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_BYTEARR_DEPL` (`DEPLOYMENT_ID_`),
  CONSTRAINT `ACT_FK_BYTEARR_DEPL` FOREIGN KEY (`DEPLOYMENT_ID_`) REFERENCES `act_re_deployment` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ge_bytearray` */

/*Table structure for table `act_ge_property` */

DROP TABLE IF EXISTS `act_ge_property`;

CREATE TABLE `act_ge_property` (
  `NAME_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `VALUE_` varchar(300) COLLATE utf8_bin DEFAULT NULL,
  `REV_` int(11) DEFAULT NULL,
  PRIMARY KEY (`NAME_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ge_property` */

insert  into `act_ge_property`(`NAME_`,`VALUE_`,`REV_`) values 
('cfg.execution-related-entities-count','false',1),
('next.dbid','1',1),
('schema.history','create(6.0.0.4)',1),
('schema.version','6.0.0.4',1);

/*Table structure for table `act_hi_actinst` */

DROP TABLE IF EXISTS `act_hi_actinst`;

CREATE TABLE `act_hi_actinst` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `ACT_ID_` varchar(255) COLLATE utf8_bin NOT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `CALL_PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACT_NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ACT_TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `ASSIGNEE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `START_TIME_` datetime NOT NULL,
  `END_TIME_` datetime DEFAULT NULL,
  `DURATION_` bigint(20) DEFAULT NULL,
  `DELETE_REASON_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_ACT_INST_START` (`START_TIME_`),
  KEY `ACT_IDX_HI_ACT_INST_END` (`END_TIME_`),
  KEY `ACT_IDX_HI_ACT_INST_PROCINST` (`PROC_INST_ID_`,`ACT_ID_`),
  KEY `ACT_IDX_HI_ACT_INST_EXEC` (`EXECUTION_ID_`,`ACT_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_hi_actinst` */

/*Table structure for table `act_hi_attachment` */

DROP TABLE IF EXISTS `act_hi_attachment`;

CREATE TABLE `act_hi_attachment` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `URL_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `CONTENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TIME_` datetime DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_hi_attachment` */

/*Table structure for table `act_hi_comment` */

DROP TABLE IF EXISTS `act_hi_comment`;

CREATE TABLE `act_hi_comment` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TIME_` datetime NOT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACTION_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `MESSAGE_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `FULL_MSG_` longblob,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_hi_comment` */

/*Table structure for table `act_hi_detail` */

DROP TABLE IF EXISTS `act_hi_detail`;

CREATE TABLE `act_hi_detail` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACT_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin NOT NULL,
  `VAR_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TIME_` datetime NOT NULL,
  `BYTEARRAY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DOUBLE_` double DEFAULT NULL,
  `LONG_` bigint(20) DEFAULT NULL,
  `TEXT_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TEXT2_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_DETAIL_PROC_INST` (`PROC_INST_ID_`),
  KEY `ACT_IDX_HI_DETAIL_ACT_INST` (`ACT_INST_ID_`),
  KEY `ACT_IDX_HI_DETAIL_TIME` (`TIME_`),
  KEY `ACT_IDX_HI_DETAIL_NAME` (`NAME_`),
  KEY `ACT_IDX_HI_DETAIL_TASK_ID` (`TASK_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_hi_detail` */

/*Table structure for table `act_hi_identitylink` */

DROP TABLE IF EXISTS `act_hi_identitylink`;

CREATE TABLE `act_hi_identitylink` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `GROUP_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_IDENT_LNK_USER` (`USER_ID_`),
  KEY `ACT_IDX_HI_IDENT_LNK_TASK` (`TASK_ID_`),
  KEY `ACT_IDX_HI_IDENT_LNK_PROCINST` (`PROC_INST_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_hi_identitylink` */

/*Table structure for table `act_hi_procinst` */

DROP TABLE IF EXISTS `act_hi_procinst`;

CREATE TABLE `act_hi_procinst` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `BUSINESS_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `START_TIME_` datetime NOT NULL,
  `END_TIME_` datetime DEFAULT NULL,
  `DURATION_` bigint(20) DEFAULT NULL,
  `START_USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `START_ACT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `END_ACT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `SUPER_PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DELETE_REASON_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `PROC_INST_ID_` (`PROC_INST_ID_`),
  KEY `ACT_IDX_HI_PRO_INST_END` (`END_TIME_`),
  KEY `ACT_IDX_HI_PRO_I_BUSKEY` (`BUSINESS_KEY_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_hi_procinst` */

/*Table structure for table `act_hi_taskinst` */

DROP TABLE IF EXISTS `act_hi_taskinst`;

CREATE TABLE `act_hi_taskinst` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_DEF_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PARENT_TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ASSIGNEE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `START_TIME_` datetime NOT NULL,
  `CLAIM_TIME_` datetime DEFAULT NULL,
  `END_TIME_` datetime DEFAULT NULL,
  `DURATION_` bigint(20) DEFAULT NULL,
  `DELETE_REASON_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `PRIORITY_` int(11) DEFAULT NULL,
  `DUE_DATE_` datetime DEFAULT NULL,
  `FORM_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_TASK_INST_PROCINST` (`PROC_INST_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_hi_taskinst` */

/*Table structure for table `act_hi_varinst` */

DROP TABLE IF EXISTS `act_hi_varinst`;

CREATE TABLE `act_hi_varinst` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin NOT NULL,
  `VAR_TYPE_` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `REV_` int(11) DEFAULT NULL,
  `BYTEARRAY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DOUBLE_` double DEFAULT NULL,
  `LONG_` bigint(20) DEFAULT NULL,
  `TEXT_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TEXT2_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `CREATE_TIME_` datetime DEFAULT NULL,
  `LAST_UPDATED_TIME_` datetime DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_PROCVAR_PROC_INST` (`PROC_INST_ID_`),
  KEY `ACT_IDX_HI_PROCVAR_NAME_TYPE` (`NAME_`,`VAR_TYPE_`),
  KEY `ACT_IDX_HI_PROCVAR_TASK_ID` (`TASK_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_hi_varinst` */

/*Table structure for table `act_id_group` */

DROP TABLE IF EXISTS `act_id_group`;

CREATE TABLE `act_id_group` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_id_group` */

/*Table structure for table `act_id_info` */

DROP TABLE IF EXISTS `act_id_info`;

CREATE TABLE `act_id_info` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `USER_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `VALUE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PASSWORD_` longblob,
  `PARENT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_id_info` */

/*Table structure for table `act_id_membership` */

DROP TABLE IF EXISTS `act_id_membership`;

CREATE TABLE `act_id_membership` (
  `USER_ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `GROUP_ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`USER_ID_`,`GROUP_ID_`),
  KEY `ACT_FK_MEMB_GROUP` (`GROUP_ID_`),
  CONSTRAINT `ACT_FK_MEMB_GROUP` FOREIGN KEY (`GROUP_ID_`) REFERENCES `act_id_group` (`ID_`),
  CONSTRAINT `ACT_FK_MEMB_USER` FOREIGN KEY (`USER_ID_`) REFERENCES `act_id_user` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_id_membership` */

/*Table structure for table `act_id_user` */

DROP TABLE IF EXISTS `act_id_user`;

CREATE TABLE `act_id_user` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `FIRST_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `LAST_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EMAIL_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PWD_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PICTURE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_id_user` */

/*Table structure for table `act_procdef_info` */

DROP TABLE IF EXISTS `act_procdef_info`;

CREATE TABLE `act_procdef_info` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `INFO_JSON_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `ACT_UNIQ_INFO_PROCDEF` (`PROC_DEF_ID_`),
  KEY `ACT_IDX_INFO_PROCDEF` (`PROC_DEF_ID_`),
  KEY `ACT_FK_INFO_JSON_BA` (`INFO_JSON_ID_`),
  CONSTRAINT `ACT_FK_INFO_JSON_BA` FOREIGN KEY (`INFO_JSON_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
  CONSTRAINT `ACT_FK_INFO_PROCDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_procdef_info` */

/*Table structure for table `act_re_deployment` */

DROP TABLE IF EXISTS `act_re_deployment`;

CREATE TABLE `act_re_deployment` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  `DEPLOY_TIME_` timestamp NULL DEFAULT NULL,
  `ENGINE_VERSION_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_re_deployment` */

/*Table structure for table `act_re_model` */

DROP TABLE IF EXISTS `act_re_model`;

CREATE TABLE `act_re_model` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CREATE_TIME_` timestamp NULL DEFAULT NULL,
  `LAST_UPDATE_TIME_` timestamp NULL DEFAULT NULL,
  `VERSION_` int(11) DEFAULT NULL,
  `META_INFO_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DEPLOYMENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EDITOR_SOURCE_VALUE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EDITOR_SOURCE_EXTRA_VALUE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_MODEL_SOURCE` (`EDITOR_SOURCE_VALUE_ID_`),
  KEY `ACT_FK_MODEL_SOURCE_EXTRA` (`EDITOR_SOURCE_EXTRA_VALUE_ID_`),
  KEY `ACT_FK_MODEL_DEPLOYMENT` (`DEPLOYMENT_ID_`),
  CONSTRAINT `ACT_FK_MODEL_DEPLOYMENT` FOREIGN KEY (`DEPLOYMENT_ID_`) REFERENCES `act_re_deployment` (`ID_`),
  CONSTRAINT `ACT_FK_MODEL_SOURCE` FOREIGN KEY (`EDITOR_SOURCE_VALUE_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
  CONSTRAINT `ACT_FK_MODEL_SOURCE_EXTRA` FOREIGN KEY (`EDITOR_SOURCE_EXTRA_VALUE_ID_`) REFERENCES `act_ge_bytearray` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_re_model` */

/*Table structure for table `act_re_procdef` */

DROP TABLE IF EXISTS `act_re_procdef`;

CREATE TABLE `act_re_procdef` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8_bin NOT NULL,
  `VERSION_` int(11) NOT NULL,
  `DEPLOYMENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `RESOURCE_NAME_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DGRM_RESOURCE_NAME_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `HAS_START_FORM_KEY_` tinyint(4) DEFAULT NULL,
  `HAS_GRAPHICAL_NOTATION_` tinyint(4) DEFAULT NULL,
  `SUSPENSION_STATE_` int(11) DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  `ENGINE_VERSION_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `ACT_UNIQ_PROCDEF` (`KEY_`,`VERSION_`,`TENANT_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_re_procdef` */

/*Table structure for table `act_ru_deadletter_job` */

DROP TABLE IF EXISTS `act_ru_deadletter_job`;

CREATE TABLE `act_ru_deadletter_job` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `EXCLUSIVE_` tinyint(1) DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXCEPTION_STACK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXCEPTION_MSG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DUEDATE_` timestamp NULL DEFAULT NULL,
  `REPEAT_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_CFG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_DEADLETTER_JOB_EXECUTION` (`EXECUTION_ID_`),
  KEY `ACT_FK_DEADLETTER_JOB_PROCESS_INSTANCE` (`PROCESS_INSTANCE_ID_`),
  KEY `ACT_FK_DEADLETTER_JOB_PROC_DEF` (`PROC_DEF_ID_`),
  KEY `ACT_FK_DEADLETTER_JOB_EXCEPTION` (`EXCEPTION_STACK_ID_`),
  CONSTRAINT `ACT_FK_DEADLETTER_JOB_EXCEPTION` FOREIGN KEY (`EXCEPTION_STACK_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
  CONSTRAINT `ACT_FK_DEADLETTER_JOB_EXECUTION` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_DEADLETTER_JOB_PROCESS_INSTANCE` FOREIGN KEY (`PROCESS_INSTANCE_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_DEADLETTER_JOB_PROC_DEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ru_deadletter_job` */

/*Table structure for table `act_ru_event_subscr` */

DROP TABLE IF EXISTS `act_ru_event_subscr`;

CREATE TABLE `act_ru_event_subscr` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `EVENT_TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `EVENT_NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACTIVITY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `CONFIGURATION_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CREATED_` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_EVENT_SUBSCR_CONFIG_` (`CONFIGURATION_`),
  KEY `ACT_FK_EVENT_EXEC` (`EXECUTION_ID_`),
  CONSTRAINT `ACT_FK_EVENT_EXEC` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ru_event_subscr` */

/*Table structure for table `act_ru_execution` */

DROP TABLE IF EXISTS `act_ru_execution`;

CREATE TABLE `act_ru_execution` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `BUSINESS_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PARENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `SUPER_EXEC_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ROOT_PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `IS_ACTIVE_` tinyint(4) DEFAULT NULL,
  `IS_CONCURRENT_` tinyint(4) DEFAULT NULL,
  `IS_SCOPE_` tinyint(4) DEFAULT NULL,
  `IS_EVENT_SCOPE_` tinyint(4) DEFAULT NULL,
  `IS_MI_ROOT_` tinyint(4) DEFAULT NULL,
  `SUSPENSION_STATE_` int(11) DEFAULT NULL,
  `CACHED_ENT_STATE_` int(11) DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `START_TIME_` datetime DEFAULT NULL,
  `START_USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `LOCK_TIME_` timestamp NULL DEFAULT NULL,
  `IS_COUNT_ENABLED_` tinyint(4) DEFAULT NULL,
  `EVT_SUBSCR_COUNT_` int(11) DEFAULT NULL,
  `TASK_COUNT_` int(11) DEFAULT NULL,
  `JOB_COUNT_` int(11) DEFAULT NULL,
  `TIMER_JOB_COUNT_` int(11) DEFAULT NULL,
  `SUSP_JOB_COUNT_` int(11) DEFAULT NULL,
  `DEADLETTER_JOB_COUNT_` int(11) DEFAULT NULL,
  `VAR_COUNT_` int(11) DEFAULT NULL,
  `ID_LINK_COUNT_` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_EXEC_BUSKEY` (`BUSINESS_KEY_`),
  KEY `ACT_IDC_EXEC_ROOT` (`ROOT_PROC_INST_ID_`),
  KEY `ACT_FK_EXE_PROCINST` (`PROC_INST_ID_`),
  KEY `ACT_FK_EXE_PARENT` (`PARENT_ID_`),
  KEY `ACT_FK_EXE_SUPER` (`SUPER_EXEC_`),
  KEY `ACT_FK_EXE_PROCDEF` (`PROC_DEF_ID_`),
  CONSTRAINT `ACT_FK_EXE_PARENT` FOREIGN KEY (`PARENT_ID_`) REFERENCES `act_ru_execution` (`ID_`) ON DELETE CASCADE,
  CONSTRAINT `ACT_FK_EXE_PROCDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`),
  CONSTRAINT `ACT_FK_EXE_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ACT_FK_EXE_SUPER` FOREIGN KEY (`SUPER_EXEC_`) REFERENCES `act_ru_execution` (`ID_`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ru_execution` */

/*Table structure for table `act_ru_identitylink` */

DROP TABLE IF EXISTS `act_ru_identitylink`;

CREATE TABLE `act_ru_identitylink` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `GROUP_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_IDENT_LNK_USER` (`USER_ID_`),
  KEY `ACT_IDX_IDENT_LNK_GROUP` (`GROUP_ID_`),
  KEY `ACT_IDX_ATHRZ_PROCEDEF` (`PROC_DEF_ID_`),
  KEY `ACT_FK_TSKASS_TASK` (`TASK_ID_`),
  KEY `ACT_FK_IDL_PROCINST` (`PROC_INST_ID_`),
  CONSTRAINT `ACT_FK_ATHRZ_PROCEDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`),
  CONSTRAINT `ACT_FK_IDL_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_TSKASS_TASK` FOREIGN KEY (`TASK_ID_`) REFERENCES `act_ru_task` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ru_identitylink` */

/*Table structure for table `act_ru_job` */

DROP TABLE IF EXISTS `act_ru_job`;

CREATE TABLE `act_ru_job` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `LOCK_EXP_TIME_` timestamp NULL DEFAULT NULL,
  `LOCK_OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EXCLUSIVE_` tinyint(1) DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `RETRIES_` int(11) DEFAULT NULL,
  `EXCEPTION_STACK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXCEPTION_MSG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DUEDATE_` timestamp NULL DEFAULT NULL,
  `REPEAT_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_CFG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_JOB_EXECUTION` (`EXECUTION_ID_`),
  KEY `ACT_FK_JOB_PROCESS_INSTANCE` (`PROCESS_INSTANCE_ID_`),
  KEY `ACT_FK_JOB_PROC_DEF` (`PROC_DEF_ID_`),
  KEY `ACT_FK_JOB_EXCEPTION` (`EXCEPTION_STACK_ID_`),
  CONSTRAINT `ACT_FK_JOB_EXCEPTION` FOREIGN KEY (`EXCEPTION_STACK_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
  CONSTRAINT `ACT_FK_JOB_EXECUTION` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_JOB_PROCESS_INSTANCE` FOREIGN KEY (`PROCESS_INSTANCE_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_JOB_PROC_DEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ru_job` */

/*Table structure for table `act_ru_suspended_job` */

DROP TABLE IF EXISTS `act_ru_suspended_job`;

CREATE TABLE `act_ru_suspended_job` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `EXCLUSIVE_` tinyint(1) DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `RETRIES_` int(11) DEFAULT NULL,
  `EXCEPTION_STACK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXCEPTION_MSG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DUEDATE_` timestamp NULL DEFAULT NULL,
  `REPEAT_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_CFG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_SUSPENDED_JOB_EXECUTION` (`EXECUTION_ID_`),
  KEY `ACT_FK_SUSPENDED_JOB_PROCESS_INSTANCE` (`PROCESS_INSTANCE_ID_`),
  KEY `ACT_FK_SUSPENDED_JOB_PROC_DEF` (`PROC_DEF_ID_`),
  KEY `ACT_FK_SUSPENDED_JOB_EXCEPTION` (`EXCEPTION_STACK_ID_`),
  CONSTRAINT `ACT_FK_SUSPENDED_JOB_EXCEPTION` FOREIGN KEY (`EXCEPTION_STACK_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
  CONSTRAINT `ACT_FK_SUSPENDED_JOB_EXECUTION` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_SUSPENDED_JOB_PROCESS_INSTANCE` FOREIGN KEY (`PROCESS_INSTANCE_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_SUSPENDED_JOB_PROC_DEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ru_suspended_job` */

/*Table structure for table `act_ru_task` */

DROP TABLE IF EXISTS `act_ru_task`;

CREATE TABLE `act_ru_task` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PARENT_TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TASK_DEF_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ASSIGNEE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DELEGATION_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PRIORITY_` int(11) DEFAULT NULL,
  `CREATE_TIME_` timestamp NULL DEFAULT NULL,
  `DUE_DATE_` datetime DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `SUSPENSION_STATE_` int(11) DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  `FORM_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CLAIM_TIME_` datetime DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_TASK_CREATE` (`CREATE_TIME_`),
  KEY `ACT_FK_TASK_EXE` (`EXECUTION_ID_`),
  KEY `ACT_FK_TASK_PROCINST` (`PROC_INST_ID_`),
  KEY `ACT_FK_TASK_PROCDEF` (`PROC_DEF_ID_`),
  CONSTRAINT `ACT_FK_TASK_EXE` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_TASK_PROCDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`),
  CONSTRAINT `ACT_FK_TASK_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ru_task` */

/*Table structure for table `act_ru_timer_job` */

DROP TABLE IF EXISTS `act_ru_timer_job`;

CREATE TABLE `act_ru_timer_job` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `LOCK_EXP_TIME_` timestamp NULL DEFAULT NULL,
  `LOCK_OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EXCLUSIVE_` tinyint(1) DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `RETRIES_` int(11) DEFAULT NULL,
  `EXCEPTION_STACK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXCEPTION_MSG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DUEDATE_` timestamp NULL DEFAULT NULL,
  `REPEAT_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_CFG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_TIMER_JOB_EXECUTION` (`EXECUTION_ID_`),
  KEY `ACT_FK_TIMER_JOB_PROCESS_INSTANCE` (`PROCESS_INSTANCE_ID_`),
  KEY `ACT_FK_TIMER_JOB_PROC_DEF` (`PROC_DEF_ID_`),
  KEY `ACT_FK_TIMER_JOB_EXCEPTION` (`EXCEPTION_STACK_ID_`),
  CONSTRAINT `ACT_FK_TIMER_JOB_EXCEPTION` FOREIGN KEY (`EXCEPTION_STACK_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
  CONSTRAINT `ACT_FK_TIMER_JOB_EXECUTION` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_TIMER_JOB_PROCESS_INSTANCE` FOREIGN KEY (`PROCESS_INSTANCE_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_TIMER_JOB_PROC_DEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ru_timer_job` */

/*Table structure for table `act_ru_variable` */

DROP TABLE IF EXISTS `act_ru_variable`;

CREATE TABLE `act_ru_variable` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin NOT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `BYTEARRAY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DOUBLE_` double DEFAULT NULL,
  `LONG_` bigint(20) DEFAULT NULL,
  `TEXT_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TEXT2_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_VARIABLE_TASK_ID` (`TASK_ID_`),
  KEY `ACT_FK_VAR_EXE` (`EXECUTION_ID_`),
  KEY `ACT_FK_VAR_PROCINST` (`PROC_INST_ID_`),
  KEY `ACT_FK_VAR_BYTEARRAY` (`BYTEARRAY_ID_`),
  CONSTRAINT `ACT_FK_VAR_BYTEARRAY` FOREIGN KEY (`BYTEARRAY_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
  CONSTRAINT `ACT_FK_VAR_EXE` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_VAR_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ru_variable` */

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

/*Table structure for table `application` */

DROP TABLE IF EXISTS `application`;

CREATE TABLE `application` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `application_name` varchar(255) DEFAULT NULL,
  `created_by` int(10) DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT NULL,
  `modified_by` int(10) DEFAULT NULL,
  `modified_date` timestamp NULL DEFAULT NULL,
  `version` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_application_name` (`application_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `application` */

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `entity_master` */

insert  into `entity_master`(`id`,`entity_type_id`,`parent_id`,`code`,`name`,`address_id`,`gst_number`,`active_status`,`created_by`,`created_date`,`modified_by`,`modified_date`,`region_id`,`version`,`contact_number`,`email_id`) values 
(3,NULL,NULL,'Mark','MarkSolution',NULL,'GST_0120',1,809,'2019-03-06 16:06:33',NULL,NULL,NULL,1,'996956859',NULL),
(5,NULL,NULL,'uj','sdf',NULL,NULL,1,NULL,'2019-11-14 22:25:54',NULL,NULL,NULL,0,NULL,NULL),
(6,NULL,NULL,'lkj','hjbnhj',NULL,NULL,1,NULL,'2019-11-14 22:52:15',NULL,NULL,NULL,0,NULL,NULL);

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
  `ITEM_SELLING_PRICE` double DEFAULT NULL,
  `ITEM_SELLING_SERVICE_PRICE` double DEFAULT NULL,
  `ITEM_SELLING_PACKGING_PRICE` double DEFAULT NULL,
  `ITEM_OFFER_TYPE` varchar(1) DEFAULT NULL COMMENT '''D'' DISCOUNT , ''N'' NON DISCOUNT',
  `ITEM_PHOTO_PATH` varchar(300) DEFAULT NULL,
  `ITEM_STATUS` varchar(1) DEFAULT NULL COMMENT '''A'' ACTIVE, ''I'' INACTIVE',
  `CREATED_BY` int(10) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `MODIFY_BY` int(10) DEFAULT NULL,
  `MODIFY_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`ITEM_PK`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Data for the table `itrm_master` */

insert  into `itrm_master`(`ITEM_PK`,`ITEM_CODE`,`ITEM_NAME`,`ITEM_TYPE`,`ITEM_UOM_FK`,`ITEM_PURCHASE_PRICE`,`ITEM_SELLING_PRICE`,`ITEM_SELLING_SERVICE_PRICE`,`ITEM_SELLING_PACKGING_PRICE`,`ITEM_OFFER_TYPE`,`ITEM_PHOTO_PATH`,`ITEM_STATUS`,`CREATED_BY`,`CREATED_DATE`,`MODIFY_BY`,`MODIFY_DATE`) values 
(1,'RW101','RICE',1,1,NULL,NULL,NULL,NULL,NULL,NULL,'A',1,'2019-11-13 22:10:00',1,'2019-11-13 22:10:08'),
(2,'RW102','DALL',1,1,NULL,NULL,NULL,NULL,NULL,NULL,'A',1,'2019-11-13 22:10:00',1,'2019-11-13 22:10:08'),
(3,'RW103','WHEAT FLOUE',1,1,NULL,NULL,NULL,NULL,NULL,NULL,'A',1,'2019-11-13 22:10:00',1,'2019-11-13 22:10:08'),
(4,'RW104','SALT',1,4,NULL,NULL,NULL,NULL,NULL,NULL,'A',1,'2019-11-13 22:10:00',1,'2019-11-13 22:10:08'),
(5,'RW105','OIL',1,6,NULL,NULL,NULL,NULL,NULL,NULL,'A',1,'2019-11-13 22:10:00',1,'2019-11-13 22:10:08'),
(6,'SL101','RICE PLATE',2,5,NULL,100,5,5,NULL,NULL,'A',1,'2019-11-13 22:10:00',1,'2019-11-13 22:10:08'),
(7,'SL102','ROTI PLATE',2,5,NULL,100,5,5,NULL,NULL,'A',1,'2019-11-13 22:10:00',1,'2019-11-13 22:10:08'),
(8,'SL103','RASHGULA ',2,3,NULL,10,2,2,NULL,NULL,'A',1,'2019-11-13 22:10:00',1,'2019-11-13 22:10:08'),
(9,'SL104','CHICKEN PLATE',2,5,NULL,100,5,5,NULL,NULL,'A',1,'2019-11-13 22:10:00',1,'2019-11-13 22:10:08'),
(10,'SL105','PANEER PLATE',2,5,NULL,100,5,5,NULL,NULL,'A',1,'2019-11-13 22:10:00',1,'2019-11-13 22:10:08');

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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Data for the table `itrm_tax_master` */

insert  into `itrm_tax_master`(`ITEM_TAX_PK`,`ITEM_TAX_FK`,`ITEM_FK`,`ITEM_TAX_PERSENT`,`ITEM_TAX_VALUE`,`CREATED_BY`,`CREATED_DATE`,`MODIFY_BY`,`MODIFY_DATE`) values 
(1,1,6,7,7,1,'2019-11-13 22:34:23',1,'2019-11-13 22:34:33'),
(2,2,6,7,7,1,'2019-11-13 22:34:23',1,'2019-11-13 22:34:33'),
(3,1,7,7,7,1,'2019-11-13 22:34:23',1,'2019-11-13 22:34:33'),
(4,2,7,7,7,1,'2019-11-13 22:34:23',1,'2019-11-13 22:34:33'),
(5,1,8,7,0.07,1,'2019-11-13 22:34:23',1,'2019-11-13 22:34:33'),
(6,2,8,7,0.07,1,'2019-11-13 22:34:23',1,'2019-11-13 22:34:33'),
(7,1,9,7,7,1,'2019-11-13 22:34:23',1,'2019-11-13 22:34:33'),
(8,2,9,7,7,1,'2019-11-13 22:34:23',1,'2019-11-13 22:34:33'),
(9,1,10,7,7,1,'2019-11-13 22:34:23',1,'2019-11-13 22:34:33'),
(10,2,10,7,7,1,'2019-11-13 22:34:23',1,'2019-11-13 22:34:33');

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
  `application_id` int(10) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_role_master_rolename` (`role_name`),
  KEY `fk_role_master_createdby` (`created_by`),
  KEY `fk_role_master_modifiedby` (`modified_by`),
  CONSTRAINT `fk_role_master_createdby` FOREIGN KEY (`created_by`) REFERENCES `user_master` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_role_master_modifiedby` FOREIGN KEY (`modified_by`) REFERENCES `user_master` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `role_master` */

insert  into `role_master`(`id`,`role_name`,`created_by`,`created_date`,`modified_by`,`modified_date`,`version`,`application_id`,`status`) values 
(1,'Admin',1,'2019-11-14 22:53:49',NULL,NULL,NULL,1,'true');

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

/*Table structure for table `uom_master` */

DROP TABLE IF EXISTS `uom_master`;

CREATE TABLE `uom_master` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `local_name` varchar(100) DEFAULT NULL,
  `created_by` int(10) DEFAULT NULL,
  `created_date` date NOT NULL,
  `modified_by` int(10) DEFAULT NULL,
  `modified_date` date DEFAULT NULL,
  `version` int(10) DEFAULT NULL,
  `code` varchar(10) DEFAULT NULL,
  `active_status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_uom_master_name` (`name`),
  UNIQUE KEY `uom_master_code_key` (`code`),
  UNIQUE KEY `uq_uom_master_lname` (`local_name`),
  KEY `fk_uom_master_createdby` (`created_by`),
  KEY `fk_uom_master_modifiedby` (`modified_by`),
  CONSTRAINT `fk_uom_master_createdby` FOREIGN KEY (`created_by`) REFERENCES `user_master` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_uom_master_modifiedby` FOREIGN KEY (`modified_by`) REFERENCES `user_master` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `uom_master` */

insert  into `uom_master`(`id`,`name`,`local_name`,`created_by`,`created_date`,`modified_by`,`modified_date`,`version`,`code`,`active_status`) values 
(1,'KG','KG',1,'2019-04-22',NULL,'2019-04-22',1,'KG',1),
(2,'Gram','Gram',1,'2019-04-22',NULL,'2019-04-22',1,'GRAM',1),
(3,'Piece','Piece',1,'2019-04-22',NULL,'2019-04-22',1,'PIECE',1),
(4,'liter','liter',1,'2019-04-22',NULL,'2019-04-22',1,'LITER',1),
(5,'Plate','Plate',1,'2019-11-13',NULL,'2019-11-13',1,'PLT',1),
(6,'Packet','Packet',1,'2019-11-13',NULL,'2019-11-13',1,'PKT',1);

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `user_master` */

insert  into `user_master`(`id`,`username`,`PASSWORD`,`created_by`,`created_date`,`modified_by`,`modified_date`,`VERSION`,`STATUS`,`user_type`,`email_id`,`second_password`,`mobile_number`,`entity_id`) values 
(1,'admin','/RJFtj5I3i+EBkpN955nyXGxnP2Mo6eO4bSD7RDROudDrhaQVOqz3Y14',NULL,'2018-09-21 21:19:20',NULL,NULL,1,1,'ADMIN_USER',NULL,NULL,NULL,3),
(2,'admin1','gGzk1XwPh242pyc4LNRR2YZJW2skITrRR4ydgelS/GQB4iJzdhsv8oJX',NULL,'2019-11-14 22:26:20',NULL,NULL,0,1,'Admin',NULL,NULL,NULL,5),
(3,'adminn','eHNEsAuH/c/fYl34dLvg8QGH0Y04PgYUEJfB5kYEFdtt5gZ1tdSsfsMo',NULL,'2019-11-14 22:52:15',NULL,NULL,0,1,'Admin',NULL,NULL,NULL,6);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
