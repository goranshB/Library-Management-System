-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 19, 2016 at 07:40 PM
-- Server version: 5.5.16
-- PHP Version: 5.4.0beta2-dev

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Table structure for table `issuebooks`
--
USE test ;
CREATE TABLE IF NOT EXISTS `studenttable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentname` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `studentid` int(11) NOT NULL,
  
  `studentcontact` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

 INSERT INTO `studenttable` (`id`,  `studentname`,`password`,`studentid`, `studentcontact`) VALUES
 (1, 'gaurav','g',100,'932992932'),
 (2, 'sabhijeet','a', 102,'95676565756'),
 (3, 'suraj', 's',103, '9329882382'),
(4,'kk','k',23, '932992932'),
 (5,'Sumedh','sd',335, '95676565756'),
 (6, 'abhishek','ab',87, '9329882382');