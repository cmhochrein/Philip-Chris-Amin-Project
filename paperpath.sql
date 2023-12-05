-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 05, 2023 at 04:56 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `paperpath`
--

-- --------------------------------------------------------

--
-- Table structure for table `articles`
--

CREATE TABLE `articles` (
  `id` bigint(20) NOT NULL,
  `content` longtext DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `article_request`
--

CREATE TABLE `article_request` (
  `id` bigint(20) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `request` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `photo`
--

CREATE TABLE `photo` (
  `photo_id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `picture` longblob DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `photo_requests`
--

CREATE TABLE `photo_requests` (
  `id` bigint(20) NOT NULL,
  `request-body` longtext DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `reqphoto_id` bigint(20) DEFAULT NULL,
  `acceptor` varchar(255) DEFAULT NULL,
  `creator` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `photo_requests`
--

INSERT INTO `photo_requests` (`id`, `request-body`, `title`, `reqphoto_id`, `acceptor`, `creator`) VALUES
(1, 'Request body where you would write what you want a photo of', 'Request Title 1', NULL, '', NULL),
(2, 'Request body 2 where you would write what photo you need', 'Request Title 2', NULL, NULL, NULL),
(3, 'Request body 3', 'Request Title 3', NULL, '', NULL),
(4, 'Request body 4', 'Request Title 4', NULL, NULL, NULL),
(5, 'Request body 5', 'Request Title 5', NULL, NULL, NULL),
(6, 'Request body 6', 'Request Title 6', NULL, '', NULL),
(7, 'Request body 7', 'Request Title 7', NULL, NULL, NULL),
(8, 'Request body 8', 'Request Title 8', NULL, '', NULL),
(9, 'Request body 9', 'Request Title 9', NULL, NULL, NULL),
(10, 'Request body 10', 'Request Title 10', NULL, NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `articles`
--
ALTER TABLE `articles`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `article_request`
--
ALTER TABLE `article_request`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `photo`
--
ALTER TABLE `photo`
  ADD PRIMARY KEY (`photo_id`);

--
-- Indexes for table `photo_requests`
--
ALTER TABLE `photo_requests`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_1rt5fuf5vkrgh3a87ipcuiypp` (`reqphoto_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `articles`
--
ALTER TABLE `articles`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `article_request`
--
ALTER TABLE `article_request`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `photo`
--
ALTER TABLE `photo`
  MODIFY `photo_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT for table `photo_requests`
--
ALTER TABLE `photo_requests`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `photo_requests`
--
ALTER TABLE `photo_requests`
  ADD CONSTRAINT `FKr16au8spjcsir1hbow4c6l6b8` FOREIGN KEY (`reqphoto_id`) REFERENCES `photo` (`photo_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
