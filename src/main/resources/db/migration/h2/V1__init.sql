
CREATE TABLE `employee` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255),
  `last_name` varchar(255),
  `gender` varchar(255),
  `department` varchar(255),
  `date_of_birth` date,
   primary key (`id`)
  );