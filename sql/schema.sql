-- MySQL Script generated by MySQL Workbench
-- 05/14/15 16:16:44
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema warehouse
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `warehouse` ;

-- -----------------------------------------------------
-- Schema warehouse
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `warehouse` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `warehouse` ;

-- -----------------------------------------------------
-- Table `warehouse`.`warehouse`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `warehouse`.`warehouse` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `address_country` VARCHAR(45) NOT NULL,
  `address_city` VARCHAR(45) NOT NULL,
  `address_postcode` VARCHAR(45) NOT NULL,
  `address_street` VARCHAR(45) NOT NULL,
  `address_number` VARCHAR(45) NOT NULL,
  `rec_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `rec_user` VARCHAR(45) NOT NULL,
  `mod_date` DATETIME NULL,
  `mod_user` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `warehouse`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `warehouse`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `login_name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NULL,
  `birthday` DATE NULL,
  `role` VARCHAR(45) NOT NULL,
  `rec_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `red_user` VARCHAR(45) NOT NULL,
  `mod_date` DATETIME NULL,
  `mod_user` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `warehouse`.`device_basedata`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `warehouse`.`device_basedata` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `manufacturer` VARCHAR(45) NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `visible` TINYINT(1) NOT NULL DEFAULT 1,
  `rec_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `rec_user` VARCHAR(45) NOT NULL,
  `mod_date` DATETIME NULL,
  `mod_user` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `warehouse`.`device_warehouse_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `warehouse`.`device_warehouse_info` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `device_basedata_fk` INT NOT NULL,
  `warehouse_fk` INT NOT NULL,
  `count` DECIMAL(10) NOT NULL,
  `rec_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `rec_user` VARCHAR(45) NOT NULL,
  `mod_date` DATETIME NULL,
  `mod_user` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `db_dwi_fk_idx` (`device_basedata_fk` ASC),
  INDEX `w_dwi_fk_idx` (`warehouse_fk` ASC),
  CONSTRAINT `db_dwi_fk`
    FOREIGN KEY (`device_basedata_fk`)
    REFERENCES `warehouse`.`device_basedata` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `w_dwi_fk`
    FOREIGN KEY (`warehouse_fk`)
    REFERENCES `warehouse`.`warehouse` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `warehouse`.`device_warehouse_info_h`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `warehouse`.`device_warehouse_info_h` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `device_warehouse_info_fk` INT NOT NULL,
  `user_fk` INT NOT NULL,
  `create_date` DATETIME NOT NULL,
  `count` DECIMAL(10) NOT NULL,
  `rec_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `rec_user` VARCHAR(45) NOT NULL,
  `mod_date` DATETIME NULL,
  `mod_user` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `dwi_dwih_fk_idx` (`device_warehouse_info_fk` ASC),
  INDEX `u_dwih_fk_idx` (`user_fk` ASC),
  CONSTRAINT `dwi_dwih_fk`
    FOREIGN KEY (`device_warehouse_info_fk`)
    REFERENCES `warehouse`.`device_warehouse_info` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `u_dwih_fk`
    FOREIGN KEY (`user_fk`)
    REFERENCES `warehouse`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `warehouse`.`property`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `warehouse`.`property` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `rec_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `rec_user` VARCHAR(45) NOT NULL,
  `mod_date` DATETIME NULL,
  `mod_user` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `warehouse`.`device_property`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `warehouse`.`device_property` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `device_base_fk` INT NOT NULL,
  `property_fk` INT NOT NULL,
  `value` VARCHAR(45) NOT NULL,
  `rec_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `rec_user` VARCHAR(45) NOT NULL,
  `mod_date` DATETIME NULL,
  `mod_user` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `db_dp_fk_idx` (`device_base_fk` ASC),
  INDEX `fk_device_property_property1_idx` (`property_fk` ASC),
  CONSTRAINT `db_dp_fk`
    FOREIGN KEY (`device_base_fk`)
    REFERENCES `warehouse`.`device_basedata` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_device_property_property1`
    FOREIGN KEY (`property_fk`)
    REFERENCES `warehouse`.`property` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `warehouse`.`work_in_sw`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `warehouse`.`work_in_sw` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_fk` INT NOT NULL,
  `warehouse_fk` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `w_wis_fk_idx` (`warehouse_fk` ASC),
  INDEX `u_wis_fk_idx` (`user_fk` ASC),
  CONSTRAINT `w_wis_fk`
    FOREIGN KEY (`warehouse_fk`)
    REFERENCES `warehouse`.`warehouse` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `u_wis_fk`
    FOREIGN KEY (`user_fk`)
    REFERENCES `warehouse`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `warehouse`.`manager_in_sw`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `warehouse`.`manager_in_sw` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_fk` INT NOT NULL,
  `warehouse_fk` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `w_mis_fk_idx` (`warehouse_fk` ASC),
  INDEX `u_mis_fk_idx` (`user_fk` ASC),
  CONSTRAINT `w_mis_fk`
    FOREIGN KEY (`warehouse_fk`)
    REFERENCES `warehouse`.`warehouse` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `u_mis_fk`
    FOREIGN KEY (`user_fk`)
    REFERENCES `warehouse`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `warehouse`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `warehouse`.`order` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `customer_name` VARCHAR(45) NOT NULL,
  `completed` TINYINT(1) NOT NULL DEFAULT 0,
  `order_identifier` VARCHAR(45) NOT NULL,
  `warehouse_fk` INT NOT NULL,
  `rec_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `rec_user` VARCHAR(45) NOT NULL,
  `mod_date` DATETIME NULL,
  `mod_user` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_order_warehouse1_idx` (`warehouse_fk` ASC),
  CONSTRAINT `fk_order_warehouse1`
    FOREIGN KEY (`warehouse_fk`)
    REFERENCES `warehouse`.`warehouse` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `warehouse`.`order_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `warehouse`.`order_item` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `count` INT NOT NULL,
  `order_fk` INT NOT NULL,
  `device_basedata_fk` INT NOT NULL,
  `rec_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `rec_user` VARCHAR(45) NOT NULL,
  `mod_date` DATETIME NULL,
  `mod_user` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_order_copy1_order1_idx` (`order_fk` ASC),
  INDEX `fk_order_copy1_device_basedata1_idx` (`device_basedata_fk` ASC),
  CONSTRAINT `fk_order_copy1_order1`
    FOREIGN KEY (`order_fk`)
    REFERENCES `warehouse`.`order` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_copy1_device_basedata1`
    FOREIGN KEY (`device_basedata_fk`)
    REFERENCES `warehouse`.`device_basedata` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `warehouse`.`warehouse`
-- -----------------------------------------------------
START TRANSACTION;
USE `warehouse`;
INSERT INTO `warehouse`.`warehouse` (`id`, `name`, `address_country`, `address_city`, `address_postcode`, `address_street`, `address_number`, `rec_date`, `rec_user`, `mod_date`, `mod_user`) VALUES (DEFAULT, 'Központi raktár', 'Magyar', 'Debrecen', '4032', 'Böszörményi', '68', DEFAULT, 'zsolti', NULL, NULL);
INSERT INTO `warehouse`.`warehouse` (`id`, `name`, `address_country`, `address_city`, `address_postcode`, `address_street`, `address_number`, `rec_date`, `rec_user`, `mod_date`, `mod_user`) VALUES (DEFAULT, 'Alraktár', 'Magyar', 'Nyíregyháza', '4400', 'Debreceni', '20', DEFAULT, 'zsolti', NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `warehouse`.`user`
-- -----------------------------------------------------
START TRANSACTION;
USE `warehouse`;
INSERT INTO `warehouse`.`user` (`id`, `name`, `login_name`, `password`, `address`, `birthday`, `role`, `rec_date`, `red_user`, `mod_date`, `mod_user`) VALUES (DEFAULT, 'Fehérvári Zsolt', 'zsolti', 'alma', '4244 Újfehértó', '1991.11.20', 'admin', DEFAULT, 'zsolti', NULL, NULL);
INSERT INTO `warehouse`.`user` (`id`, `name`, `login_name`, `password`, `address`, `birthday`, `role`, `rec_date`, `red_user`, `mod_date`, `mod_user`) VALUES (DEFAULT, 'Horváth Ádám', 'adam', 'alma', '4400 Nyíregyháza', '1992.01.23', 'admin', DEFAULT, 'zsolti', NULL, NULL);
INSERT INTO `warehouse`.`user` (`id`, `name`, `login_name`, `password`, `address`, `birthday`, `role`, `rec_date`, `red_user`, `mod_date`, `mod_user`) VALUES (DEFAULT, 'Lámfalusi Csaba', 'csaba', 'alma', '4032 Debrecen', '1993.01.01', 'admin', DEFAULT, 'zsolti', NULL, NULL);
INSERT INTO `warehouse`.`user` (`id`, `name`, `login_name`, `password`, `address`, `birthday`, `role`, `rec_date`, `red_user`, `mod_date`, `mod_user`) VALUES (DEFAULT, 'Gyákon Jácint', 'jacint', 'alma', '4032 Debrecen', '1993.01.01', 'admin', DEFAULT, 'zsolti', NULL, NULL);
INSERT INTO `warehouse`.`user` (`id`, `name`, `login_name`, `password`, `address`, `birthday`, `role`, `rec_date`, `red_user`, `mod_date`, `mod_user`) VALUES (DEFAULT, 'Fá Zoltán', 'zoltan', 'alma', '2232 Istenhátamögött', '1945.10.10', 'employee', DEFAULT, 'zsolti', NULL, NULL);
INSERT INTO `warehouse`.`user` (`id`, `name`, `login_name`, `password`, `address`, `birthday`, `role`, `rec_date`, `red_user`, `mod_date`, `mod_user`) VALUES (DEFAULT, 'Lakatos Elemér', 'elemer', 'alma', '3456 Lakatlan', '1987.02.02', 'employee', DEFAULT, 'zsolti', NULL, NULL);
INSERT INTO `warehouse`.`user` (`id`, `name`, `login_name`, `password`, `address`, `birthday`, `role`, `rec_date`, `red_user`, `mod_date`, `mod_user`) VALUES (DEFAULT, 'Locsolók Anna', 'anna', 'alma', '3245 Mucsaröcsöge', '1984.01.01', 'employee', DEFAULT, 'zsolti', NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `warehouse`.`device_basedata`
-- -----------------------------------------------------
START TRANSACTION;
USE `warehouse`;
INSERT INTO `warehouse`.`device_basedata` (`id`, `manufacturer`, `type`, `description`, `visible`, `rec_date`, `rec_user`, `mod_date`, `mod_user`) VALUES (DEFAULT, 'Samsung', 'Televízió', '101 cm FULL HD', DEFAULT, DEFAULT, 'zsolti', NULL, NULL);
INSERT INTO `warehouse`.`device_basedata` (`id`, `manufacturer`, `type`, `description`, `visible`, `rec_date`, `rec_user`, `mod_date`, `mod_user`) VALUES (DEFAULT, 'LG', 'Monitor', '24\" HD, IPS LED', DEFAULT, DEFAULT, 'zsolti', NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `warehouse`.`device_warehouse_info`
-- -----------------------------------------------------
START TRANSACTION;
USE `warehouse`;
INSERT INTO `warehouse`.`device_warehouse_info` (`id`, `device_basedata_fk`, `warehouse_fk`, `count`, `rec_date`, `rec_user`, `mod_date`, `mod_user`) VALUES (DEFAULT, 1, 1, 20, DEFAULT, 'zsolti', NULL, NULL);
INSERT INTO `warehouse`.`device_warehouse_info` (`id`, `device_basedata_fk`, `warehouse_fk`, `count`, `rec_date`, `rec_user`, `mod_date`, `mod_user`) VALUES (DEFAULT, 2, 2, 10, DEFAULT, 'zsolti', NULL, NULL);
INSERT INTO `warehouse`.`device_warehouse_info` (`id`, `device_basedata_fk`, `warehouse_fk`, `count`, `rec_date`, `rec_user`, `mod_date`, `mod_user`) VALUES (DEFAULT, 1, 2, 2, DEFAULT, 'zsolti', NULL, NULL);
INSERT INTO `warehouse`.`device_warehouse_info` (`id`, `device_basedata_fk`, `warehouse_fk`, `count`, `rec_date`, `rec_user`, `mod_date`, `mod_user`) VALUES (DEFAULT, 2, 1, 5, DEFAULT, 'zsolti', NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `warehouse`.`device_warehouse_info_h`
-- -----------------------------------------------------
START TRANSACTION;
USE `warehouse`;
INSERT INTO `warehouse`.`device_warehouse_info_h` (`id`, `device_warehouse_info_fk`, `user_fk`, `create_date`, `count`, `rec_date`, `rec_user`, `mod_date`, `mod_user`) VALUES (DEFAULT, 1, 1, DEFAULT, 20, DEFAULT, 'zsolti', NULL, NULL);
INSERT INTO `warehouse`.`device_warehouse_info_h` (`id`, `device_warehouse_info_fk`, `user_fk`, `create_date`, `count`, `rec_date`, `rec_user`, `mod_date`, `mod_user`) VALUES (DEFAULT, 2, 1, DEFAULT, 20, DEFAULT, 'zsolti', NULL, NULL);
INSERT INTO `warehouse`.`device_warehouse_info_h` (`id`, `device_warehouse_info_fk`, `user_fk`, `create_date`, `count`, `rec_date`, `rec_user`, `mod_date`, `mod_user`) VALUES (DEFAULT, 3, 1, DEFAULT, 20, DEFAULT, 'zsolti', NULL, NULL);
INSERT INTO `warehouse`.`device_warehouse_info_h` (`id`, `device_warehouse_info_fk`, `user_fk`, `create_date`, `count`, `rec_date`, `rec_user`, `mod_date`, `mod_user`) VALUES (DEFAULT, 4, 1, DEFAULT, 20, DEFAULT, 'zsolti', NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `warehouse`.`property`
-- -----------------------------------------------------
START TRANSACTION;
USE `warehouse`;
INSERT INTO `warehouse`.`property` (`id`, `name`, `rec_date`, `rec_user`, `mod_date`, `mod_user`) VALUES (DEFAULT, 'Átmérő', DEFAULT, 'zsolti', NULL, NULL);
INSERT INTO `warehouse`.`property` (`id`, `name`, `rec_date`, `rec_user`, `mod_date`, `mod_user`) VALUES (DEFAULT, 'Energia osztály', DEFAULT, 'zsolti', NULL, NULL);
INSERT INTO `warehouse`.`property` (`id`, `name`, `rec_date`, `rec_user`, `mod_date`, `mod_user`) VALUES (DEFAULT, 'Csatlakozó típus', DEFAULT, 'zsolti', NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `warehouse`.`device_property`
-- -----------------------------------------------------
START TRANSACTION;
USE `warehouse`;
INSERT INTO `warehouse`.`device_property` (`id`, `device_base_fk`, `property_fk`, `value`, `rec_date`, `rec_user`, `mod_date`, `mod_user`) VALUES (DEFAULT, 1, 1, '32\"', DEFAULT, 'zsolti', NULL, NULL);
INSERT INTO `warehouse`.`device_property` (`id`, `device_base_fk`, `property_fk`, `value`, `rec_date`, `rec_user`, `mod_date`, `mod_user`) VALUES (DEFAULT, 1, 2, 'A+', DEFAULT, 'zsolti', NULL, NULL);
INSERT INTO `warehouse`.`device_property` (`id`, `device_base_fk`, `property_fk`, `value`, `rec_date`, `rec_user`, `mod_date`, `mod_user`) VALUES (DEFAULT, 2, 1, '24\"', DEFAULT, 'zsolti', NULL, NULL);
INSERT INTO `warehouse`.`device_property` (`id`, `device_base_fk`, `property_fk`, `value`, `rec_date`, `rec_user`, `mod_date`, `mod_user`) VALUES (DEFAULT, 2, 2, 'C', DEFAULT, 'zsolti', NULL, NULL);
INSERT INTO `warehouse`.`device_property` (`id`, `device_base_fk`, `property_fk`, `value`, `rec_date`, `rec_user`, `mod_date`, `mod_user`) VALUES (DEFAULT, 2, 3, 'HDMI,VGA', DEFAULT, 'zsolti', NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `warehouse`.`work_in_sw`
-- -----------------------------------------------------
START TRANSACTION;
USE `warehouse`;
INSERT INTO `warehouse`.`work_in_sw` (`id`, `user_fk`, `warehouse_fk`) VALUES (DEFAULT, 7, 1);
INSERT INTO `warehouse`.`work_in_sw` (`id`, `user_fk`, `warehouse_fk`) VALUES (DEFAULT, 7, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `warehouse`.`manager_in_sw`
-- -----------------------------------------------------
START TRANSACTION;
USE `warehouse`;
INSERT INTO `warehouse`.`manager_in_sw` (`id`, `user_fk`, `warehouse_fk`) VALUES (DEFAULT, 5, 1);
INSERT INTO `warehouse`.`manager_in_sw` (`id`, `user_fk`, `warehouse_fk`) VALUES (DEFAULT, 6, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `warehouse`.`order`
-- -----------------------------------------------------
START TRANSACTION;
USE `warehouse`;
INSERT INTO `warehouse`.`order` (`id`, `customer_name`, `completed`, `order_identifier`, `warehouse_fk`, `rec_date`, `rec_user`, `mod_date`, `mod_user`) VALUES (DEFAULT, 'Kiss Elemér', DEFAULT, '123456789', 1, DEFAULT, 'zsolti', NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `warehouse`.`order_item`
-- -----------------------------------------------------
START TRANSACTION;
USE `warehouse`;
INSERT INTO `warehouse`.`order_item` (`id`, `count`, `order_fk`, `device_basedata_fk`, `rec_date`, `rec_user`, `mod_date`, `mod_user`) VALUES (DEFAULT, 3, 1, 1, DEFAULT, 'zsolti', NULL, NULL);
INSERT INTO `warehouse`.`order_item` (`id`, `count`, `order_fk`, `device_basedata_fk`, `rec_date`, `rec_user`, `mod_date`, `mod_user`) VALUES (DEFAULT, 4, 1, 2, DEFAULT, 'zsolti', NULL, NULL);

COMMIT;

