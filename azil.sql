-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 14, 2022 at 10:35 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `azil`
--

-- --------------------------------------------------------

--
-- Table structure for table `dogs`
--

CREATE TABLE `dogs` (
  `dog_id` int(11) NOT NULL,
  `dog_name` text NOT NULL,
  `dog_age` int(11) NOT NULL,
  `dog_gender` text NOT NULL,
  `dog_breed` text NOT NULL,
  `vacinated` tinyint(1) NOT NULL,
  `adopted` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `dogs`
--

INSERT INTO `dogs` (`dog_id`, `dog_name`, `dog_age`, `dog_gender`, `dog_breed`, `vacinated`, `adopted`) VALUES
(1, 'Zoki', 2, 'MALE', 'Bulldogs', 0, 0),
(3, 'Aska', 2, 'FEMALE', 'Siberian Huskies', 1, 1),
(4, 'Sky', 4, 'FEMALE', 'German Shepherd Dogs', 0, 0),
(5, 'Zuca', 6, 'MALE', 'Retrievers (Golden)', 0, 0),
(6, 'Rambo', 10, 'MALE', 'Rottweilers', 0, 1),
(7, 'Rex', 4, 'MALE', 'Retrievers (Labrador)', 0, 1),
(8, 'Lusi', 6, 'FEMALE', 'Retrievers (Labrador)', 1, 1),
(9, 'Mili', 1, 'MALE', 'Dachshunds', 1, 1),
(10, 'Max', 6, 'MALE', 'Great Danes', 0, 0),
(11, 'Rea', 3, 'FEMALE', 'Doberman Pinschers', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `message`
--

CREATE TABLE `message` (
  `message_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `message_type` text NOT NULL,
  `message_title` text NOT NULL,
  `message_text` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `message`
--

INSERT INTO `message` (`message_id`, `user_id`, `message_type`, `message_title`, `message_text`) VALUES
(2, 6, 'REVIEW', 'Praise', 'Communication is at its peak and the dogs are great'),
(3, 7, 'QUESTION', 'Question', 'How many dogs are in the shelter'),
(4, 8, 'COMPLAINT', 'Unprofessional', 'I waited for the dog for almost two weeks'),
(5, 8, 'REVIEW', 'Not satisfied', 'Communication and waiting times are desperate'),
(6, 9, 'QUESTION', 'Vaccination ', 'How much does a dog\'s vaccination cost?'),
(7, 7, 'REVIEW', 'Very good', 'Your aplication is very good!');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `user_name` text NOT NULL,
  `password` text NOT NULL,
  `adopted_number` int(11) NOT NULL,
  `age` int(11) NOT NULL,
  `email` text NOT NULL,
  `admin` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `user_name`, `password`, `adopted_number`, `age`, `email`, `admin`) VALUES
(1, 'milan', '11111', 0, 19, 'milan@gmail.com', 1),
(2, 'Lazar', 'laza142', 0, 20, 'lazar@gmail.com', 1),
(3, 'Jasmina', 'Jasmina', 0, 18, 'Jasmina@gmail.com', 0),
(4, 'Nikolas', 'Nikolas', 0, 34, 'Nikolas@gmail.com', 0),
(5, 'Djordje', 'Djordje', 0, 40, 'Djordje@gmail.com', 0),
(6, 'Ivana', 'Djordje', 2, 33, 'Ivana@gmail.com', 0),
(7, 'Sasa', '123456', 1, 22, 'sasa@gmail.com', 0),
(8, 'Svetomir', 'sveto111', 2, 20, 'Svetomir@gmail.com', 0),
(9, 'Andra', 'andrea142', 0, 23, 'andra@gmail.com', 0);

-- --------------------------------------------------------

--
-- Table structure for table `user_dogs`
--

CREATE TABLE `user_dogs` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `dog_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_dogs`
--

INSERT INTO `user_dogs` (`id`, `user_id`, `dog_id`) VALUES
(1, 6, 7),
(2, 6, 8),
(3, 8, 9),
(4, 8, 6),
(5, 7, 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dogs`
--
ALTER TABLE `dogs`
  ADD PRIMARY KEY (`dog_id`);

--
-- Indexes for table `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`message_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `user_dogs`
--
ALTER TABLE `user_dogs`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `dog_id` (`dog_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `dogs`
--
ALTER TABLE `dogs`
  MODIFY `dog_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `message`
--
ALTER TABLE `message`
  MODIFY `message_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `user_dogs`
--
ALTER TABLE `user_dogs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `message`
--
ALTER TABLE `message`
  ADD CONSTRAINT `message_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `user_dogs`
--
ALTER TABLE `user_dogs`
  ADD CONSTRAINT `user_dogs_ibfk_1` FOREIGN KEY (`dog_id`) REFERENCES `dogs` (`dog_id`),
  ADD CONSTRAINT `user_dogs_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
