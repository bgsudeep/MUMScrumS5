-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 16, 2015 at 03:31 AM
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
-- Table structure for table `EMPLOYEE`
--

CREATE TABLE IF NOT EXISTS `EMPLOYEE` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `telephone` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `zip` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `salary` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `joinDate` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `EMPLOYEE`
--

INSERT INTO `EMPLOYEE` (`id`, `telephone`, `firstName`, `lastName`, `street`, `city`, `state`, `zip`, `email`, `password`, `salary`, `username`, `joinDate`) VALUES
(2, '646-280-7357', 'Sudeep', 'Bagale', '1000 North 4th Street', 'Fairfield', 'IA', '52557', 'bgsudeep@gmail.com', 'hello', '100000', 'bgsudeep', '16-09-2015'),
(3, '262-271-4867', 'Saugat', 'Ligal', '1000 North 4th Street', 'Fairfield', 'IA', '52557', 'saugatligal@gmail.com', 'asdf', '10000000', 'saugatligal', '16-09-2015'),
(4, '262-271-4867', 'Saugat', 'Ligal', '1000 North 4th Street', 'Fairfield', 'IA', '52557', 'saugatligal@gmail.com', 'asdf', '10000000', 'saugatligal', '16-09-2015'),
(5, '262-271-4867', '', 'Ligal', '1000 North 4th Street', 'Fairfield', 'IA', '52557', 'saugatligal@gmail.com', 'asdf', '10000000', 'saugatligal', '16-09-2015'),
(6, '262-271-4867', '', 'Ligal', '1000 North 4th Street', 'Fairfield', 'IA', '52557', 'saugatligal@gmail.com', 'asdf', '10000000', 'saugatligal', '16-09-2015'),
(7, '646-280-7357', 'Sudeep', 'Bagale', '1000 North 4th Street', 'Fairfield', 'IA', '52557', 'bgsudeep@gmail.com', 'hello', '100000', 'bgsudeep', '16-09-2015'),
(8, '646-280-7357', 'Sudeep', 'Bagale', '1000 North 4th Street', 'Fairfield', 'IA', '52557', 'bgsudeep@gmail.com', 'hello', '100000', 'bgsudeep', '16-09-2015'),
(9, '646-280-7357', 'Sudeep', 'Bagale', '1000 North 4th Street', 'Fairfield', 'IA', '52557', 'bgsudeep@gmail.com', 'asd', '100000', 'bgsudeep', '16-09-2015'),
(10, '646-280-7357', 'Sudeep', 'Bagale', '1000 North 4th Street', 'Fairfield', 'IA', '52557', 'bgsudeep@gmail.com', 'wer', '100000', 'bgsudeep', '16-09-2015'),
(11, '646-280-7357', 'Sudeep', 'Bagale', '1000 North 4th Street', 'Fairfield', 'IA', '52557', 'bgsudeep@gmail.com', 'hello', '100000', 'bgsudeep', 'asdf'),
(12, '262-271-4867', 'Saugat', 'Ligal', '1000 North 4th Street', 'Fairfield', 'IA', '52557', 'saugatligal@gmail.com', 'asd', '234234', 'saugatligal', 'asdf');

-- --------------------------------------------------------

--
-- Table structure for table `User`
--

CREATE TABLE IF NOT EXISTS `User` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `roleID` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `User`
--

