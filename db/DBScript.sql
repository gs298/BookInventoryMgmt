
DROP DATABASE IF EXISTS `BookInventory`;

CREATE DATABASE `BookInventory`;

USE `BookInventory`;

CREATE TABLE `Book` (
  `id` bigint(13) NOT NULL,
  `name` varchar(45) NOT NULL,
  `author` varchar(45) NOT NULL,
  `page` int(11) NOT NULL,
  `rd` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ;
