-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 18, 2015 at 01:44 AM
-- Server version: 5.1.44
-- PHP Version: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `mumscrums5`
--

-- --------------------------------------------------------

--
-- Table structure for table `burndown`
--

CREATE TABLE IF NOT EXISTS `burndown` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `total_planned_effort` int(11) DEFAULT NULL,
  `total_remaining_effort` int(11) DEFAULT NULL,
  `sprint_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKBA31F6F1E24FA351` (`sprint_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `burndown`
--


-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `joinDate` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `salary` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `zip` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `city`, `email`, `firstName`, `joinDate`, `lastName`, `salary`, `state`, `street`, `telephone`, `zip`) VALUES
(1, 'Fairfield', 'bgsudeep@gmail.com', 'Sudeep', '16-09-2015', 'Bagale', '100000', 'Iowa', '1000 North 4th Street', '6462807357', '52557'),
(2, 'Fairfield', 'bgsudeep@gmail.com', 'Sudeep', '16-09-2015', 'Bagale', '123', 'Iowa', '1000 North 4th Street', '6462807357', '52557');

-- --------------------------------------------------------

--
-- Table structure for table `employee_user`
--

CREATE TABLE IF NOT EXISTS `employee_user` (
  `user_id` int(11) NOT NULL DEFAULT '0',
  `employee_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FK8719BABC92AF8371` (`user_id`),
  KEY `FK8719BABC882FD111` (`employee_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee_user`
--

INSERT INTO `employee_user` (`user_id`, `employee_id`) VALUES
(1, 1),
(2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `product_backlog`
--

CREATE TABLE IF NOT EXISTS `product_backlog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `product_backlog`
--

INSERT INTO `product_backlog` (`id`, `description`, `title`) VALUES
(1, 'This is a description to create a watch', 'Create Watch');

-- --------------------------------------------------------

--
-- Table structure for table `release_backlog`
--

CREATE TABLE IF NOT EXISTS `release_backlog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) NOT NULL,
  `endDate` datetime DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `startDate` datetime DEFAULT NULL,
  `product_backlog_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKE715F8C5E3FCEAD2` (`product_backlog_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `release_backlog`
--


-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `role`) VALUES
(1, 'Product Owner'),
(2, 'Scrum Master'),
(3, 'Developer'),
(4, 'Tester');

-- --------------------------------------------------------

--
-- Table structure for table `sprint`
--

CREATE TABLE IF NOT EXISTS `sprint` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `release_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKCA9D021A734DFB63` (`release_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `sprint`
--


-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `enabled` bit(1) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `enabled`, `password`, `username`) VALUES
(1, '', 'hello', 'bgsudeep'),
(2, '', 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE IF NOT EXISTS `user_role` (
  `role_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  KEY `FK143BF46A92AF8371` (`user_id`),
  KEY `FK143BF46AED84BF91` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`role_id`, `user_id`) VALUES
(2, 1),
(1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `user_story`
--

CREATE TABLE IF NOT EXISTS `user_story` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `assignedDate` datetime DEFAULT NULL,
  `completedDate` datetime DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `estimatedDevHours` double DEFAULT NULL,
  `estimatedTestHours` double DEFAULT NULL,
  `remainingDevHours` double DEFAULT NULL,
  `remainingTestHours` double DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `product_backlog_id` int(11) NOT NULL,
  `release_backlog_id` int(11) DEFAULT NULL,
  `sprint_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK73530381839D89E5` (`release_backlog_id`),
  KEY `FK73530381E3FCEAD2` (`product_backlog_id`),
  KEY `FK73530381E24FA351` (`sprint_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `user_story`
--

