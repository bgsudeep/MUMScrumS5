-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 23, 2015 at 03:27 AM
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
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `city`, `email`, `firstName`, `joinDate`, `lastName`, `salary`, `state`, `street`, `telephone`, `zip`) VALUES
(1, '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'),
(3, 'Fairfield', 'bgsudeep@gmail.com', 'Sudeep', '09-09-2015', 'Bagale', '1000000', 'IA', '1000 North 4th Street', '646-280-7357', '52557'),
(4, 'Fairfield', 'saugatligal@gmail.com', 'Saugat', '09-09-2015', 'Ligal', '1000000', 'IA', '1000 North 4th Street', '262-271-4867', '52557');

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
(3, 3),
(4, 4);

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
(1, 'PB 1 Desc', 'PB 1');

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
  `assigned_to` int(11) DEFAULT NULL,
  `product_backlog_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKE715F8C5E3FCEAD2` (`product_backlog_id`),
  KEY `FKE715F8C5B987D751` (`assigned_to`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `release_backlog`
--

INSERT INTO `release_backlog` (`id`, `description`, `endDate`, `name`, `startDate`, `assigned_to`, `product_backlog_id`) VALUES
(1, 'RB 1 Desc', '2015-12-12 00:00:00', 'RB 1', '2015-09-11 00:00:00', NULL, 1);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `role`) VALUES
(5, 'Scrum Master'),
(2, 'Developer'),
(3, 'Tester'),
(4, 'Product Owner'),
(1, 'HR ADMIN');

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
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `sprint`
--

INSERT INTO `sprint` (`id`, `description`, `title`, `release_id`) VALUES
(1, 'Sprint 1 Desc', 'Sprint 1', 1);

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
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `enabled`, `password`, `username`) VALUES
(1, '', 'admin', 'admin'),
(3, '', 'hello', 'bgsudeep'),
(4, '', 'hello', 'saugatligal');

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
(1, 1),
(4, 3),
(3, 4);

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
  `assigned_developer` int(11) DEFAULT NULL,
  `assigned_tester` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK73530381839D89E5` (`release_backlog_id`),
  KEY `FK73530381E3FCEAD2` (`product_backlog_id`),
  KEY `FK73530381E24FA351` (`sprint_id`),
  KEY `FK735303816A35735E` (`assigned_developer`),
  KEY `FK7353038180E0CD15` (`assigned_tester`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `user_story`
--

INSERT INTO `user_story` (`id`, `assignedDate`, `completedDate`, `createdDate`, `description`, `estimatedDevHours`, `estimatedTestHours`, `remainingDevHours`, `remainingTestHours`, `title`, `product_backlog_id`, `release_backlog_id`, `sprint_id`, `assigned_developer`, `assigned_tester`) VALUES
(1, NULL, NULL, NULL, 'US 1 Desc', 12, 12, 12, 12, 'US 1', 1, 1, 1, NULL, NULL),
(2, NULL, NULL, NULL, 'US 2 Desc', 23, 23, 23, 23, 'US2', 1, 1, 1, NULL, 4);
