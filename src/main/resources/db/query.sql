
CREATE TABLE `web_access` (
  `ID` varchar(22) COLLATE utf8mb4_unicode_ci NOT NULL,
  `USERNAME` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `DESCRIPTION` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `SOURCE` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ACCESS_DATE` datetime NOT NULL,
  `DATA` text COLLATE utf8mb4_unicode_ci,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `web_menu` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MODULE` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `PARENT_ID` bigint NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `WEB_MENU_UN` (`MODULE`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `web_menu` VALUES (1,'root','root',0),(2,'User and Role','userrole',0),(3,'Role','userrole/role',2),(4,'User','userrole/user',2),(5,'Add Role','userrole/role/add',3),(6,'Delete Role','userrole/role/delete',3),(7,'Edit Role','userrole/role/edit',3),(8,'Add User','userrole/user/add',4),(9,'Block User','userrole/user/block',4),(10,'Delete User','userrole/user/delete',4),(11,'Edit User','userrole/user/edit',4),(12,'Release User','userrole/user/release',4),(13,'Unblock User','userrole/user/unblock',4),(14,'Dashboard','dashboard',0),(15,'Master Data','masterdata',0),(16,'Branch Data','masterdata/branch',15);

DROP TABLE IF EXISTS `web_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `web_role` (
  `ID` int NOT NULL,
  `NAME` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `CREATED_DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `CREATED_BY` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `LAST_MODIFIED_DATE` datetime DEFAULT NULL,
  `LAST_MODIFIED_BY` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `VERSION` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `web_role_menu` (
  `MENU_ID` int NOT NULL,
  `ROLE_ID` int NOT NULL,
  PRIMARY KEY (`ROLE_ID`,`MENU_ID`),
  KEY `WEB_ROLE_MENU_WEB_MENU_FK` (`MENU_ID`),
  CONSTRAINT `WEB_ROLE_MENU_WEB_MENU_FK` FOREIGN KEY (`MENU_ID`) REFERENCES `web_menu` (`ID`),
  CONSTRAINT `WEB_ROLE_MENU_WEB_ROLE_FK` FOREIGN KEY (`ROLE_ID`) REFERENCES `web_role` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `web_role_menu` VALUES (2,2),(3,2),(4,2),(5,2),(6,2),(7,2),(8,2),(9,2),(10,2),(11,2),(12,2),(13,2);

CREATE TABLE `web_user` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `PASSWORD` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `IS_LOGIN_WEB` tinyint(1) NOT NULL DEFAULT '0',
  `LAST_LOGIN_WEB` datetime DEFAULT NULL,
  `LAST_LOGIN_SRC` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `LAST_LOGOUT_WEB` datetime DEFAULT NULL,
  `LAST_IP_WEB` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `EMAIL` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ENABLED` tinyint(1) NOT NULL DEFAULT '1',
  `FULL_NAME` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `NIP` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `LAST_RESET_DATE` datetime DEFAULT NULL,
  `AVATAR` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `DEPARTMENT` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `DIVISION` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `BRANCH` varchar(5) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `PHONE_NUMBER` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `INVALID_LOGIN_COUNTER` int NOT NULL DEFAULT '0',
  `CREATED_DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `CREATED_BY` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `LAST_MODIFIED_DATE` datetime DEFAULT NULL,
  `LAST_MODIFIED_BY` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `VERSION` int NOT NULL DEFAULT '1',
  `LAST_ACCESS` int DEFAULT '1',
  `SESSION_ID` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `USERNAME` (`USERNAME`),
  UNIQUE KEY `NIP` (`NIP`),
  UNIQUE KEY `EMAIL` (`EMAIL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `web_user_role` (
  `USER_ID` int NOT NULL,
  `ROLE_ID` int NOT NULL,
  PRIMARY KEY (`USER_ID`),
  KEY `FK_USER_ROLE_ROLE` (`ROLE_ID`),
  CONSTRAINT `FK_USER_ROLE_ROLE` FOREIGN KEY (`ROLE_ID`) REFERENCES `web_role` (`ID`),
  CONSTRAINT `FK_USER_ROLE_USER` FOREIGN KEY (`USER_ID`) REFERENCES `web_user` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;