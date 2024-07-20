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
-- Table structure for table `books`
--

USE test ;

CREATE TABLE IF NOT EXISTS `books` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `callno` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `author` varchar(100) NOT NULL,
  `publisher` varchar(100) NOT NULL,
  `quantity` int(10) NOT NULL,
  `issued` int(10) NOT NULL,
  `added_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `callno` (`callno`),
  UNIQUE KEY `callno_2` (`callno`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`id`, `callno`, `name`, `author`, `publisher`, `quantity`, `issued`, `added_date`) VALUES
(1, 'A@4', 'C In Depth', 'Shrivastav', 'BPB', 2, 2, '2016-07-19 19:37:56'),
(2, 'B@1', 'DBMS', 'Korth', 'Pearson', 3, 0, '2016-07-18 18:39:52'),
(3, 'G@12', 'Let''s see', 'Yashwant Kanetkar', 'BPB', 10, 0, '2016-07-18 23:02:14');


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;




CREATE TABLE IF NOT EXISTS `charge` (
`id` int(10) NOT NULL AUTO_INCREMENT,
  
  `fine` int(10) NOT NULL,
  PRIMARY KEY (`id`)
  
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

INSERT INTO `charge` (`id`,`fine`) VALUES
(1,1),
(2,2),
(3,3);


CREATE TABLE IF NOT EXISTS `perma` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookcallno` varchar(50) NOT NULL,
  `studentid` int(11) NOT NULL,
  `studentname` varchar(50) NOT NULL,
  `studentcontact` varchar(20) NOT NULL,
  /*`issueddate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,*/
  `issueddate` DATE NOT NULL ,
  `returndate` DATE NOT NULL,
  `duedays` int(11) NOT NULL,
  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

 INSERT INTO `perma` (`id`, `bookcallno`, `studentid`, `studentname`, `studentcontact`, `issueddate`,`returndate`,`duedays`) VALUES
 (4, 'A@4', 23, 'kk', '932992932', '2016-07-19 ','2016-07-23 ','0'),
 (6, 'A@4', 335, 'Sumedh', '95676565756', '2016-07-11','2016-07-27 ','1'),
(7, 'A@4', 87, 'abhishek', '9329882382', '2016-07-19 ','2016-07-25 ','0');



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


