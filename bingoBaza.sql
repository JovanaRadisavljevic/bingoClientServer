/*
SQLyog Community v13.1.8 (64 bit)
MySQL - 10.4.32-MariaDB : Database - bingo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bingo` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `bingo`;

/*Table structure for table `igra` */

DROP TABLE IF EXISTS `igra`;

CREATE TABLE `igra` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `kombinacija` varchar(20) DEFAULT NULL,
  `naMestu` bigint(20) DEFAULT NULL,
  `vanMesta` bigint(20) DEFAULT NULL,
  `rezultat` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `rezultat` (`rezultat`),
  CONSTRAINT `igra_ibfk_1` FOREIGN KEY (`rezultat`) REFERENCES `rezultat` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `igra` */

insert  into `igra`(`id`,`kombinacija`,`naMestu`,`vanMesta`,`rezultat`) values 
(7,'4-5-4-1',1,1,5),
(8,'4-5-4-2',0,2,5),
(9,'4-1-2-2',0,2,5),
(10,'4-1-2-3',0,3,5),
(11,'3-1-2-3',0,3,5),
(12,'3-1-4-3',0,2,5),
(13,'1-2-4-3',1,0,6),
(14,'1-2-4-5',2,0,6),
(15,'4-4-4-5',4,0,6);

/*Table structure for table `rezultat` */

DROP TABLE IF EXISTS `rezultat`;

CREATE TABLE `rezultat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `kombinacija` varchar(20) DEFAULT NULL,
  `rezultatIgre` varchar(20) DEFAULT NULL,
  `brPokusaja` bigint(20) DEFAULT NULL,
  `datum` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `rezultat` */

insert  into `rezultat`(`id`,`kombinacija`,`rezultatIgre`,`brPokusaja`,`datum`) values 
(5,'5-2-3-1','IZGUBIO',6,'2025-06-02 16:00:13'),
(6,'4-4-4-5','POBEDIO',3,'2025-06-02 17:56:02');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
