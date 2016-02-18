CREATE TABLE `poker`.`casino` (
  `id` INT NOT NULL COMMENT '',
  `name` VARCHAR(255) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '');

CREATE TABLE `poker`.`users` (
  `id` INT NOT NULL COMMENT '',
  `username` VARCHAR(255) NOT NULL COMMENT '',
  `password` VARCHAR(255) NOT NULL COMMENT '',
  `email` VARCHAR(255) NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '');
