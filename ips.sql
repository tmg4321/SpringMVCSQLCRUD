-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema incomeproperties
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `incomeproperties` ;

-- -----------------------------------------------------
-- Schema incomeproperties
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `incomeproperties` DEFAULT CHARACTER SET utf8 ;
USE `incomeproperties` ;

-- -----------------------------------------------------
-- Table `address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `address` ;

CREATE TABLE IF NOT EXISTS `address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `property_id` INT NOT NULL DEFAULT 0,
  `street_address` VARCHAR(100) NOT NULL,
  `city` VARCHAR(50) NOT NULL,
  `state_abbreviation` CHAR(2) NOT NULL,
  `zip_code` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `note`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `note` ;

CREATE TABLE IF NOT EXISTS `note` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `property_id` INT NOT NULL,
  `note` VARCHAR(1000) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pic_set`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pic_set` ;

CREATE TABLE IF NOT EXISTS `pic_set` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `pic_set` VARCHAR(10000) NULL,
  `property_id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `caprate`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `caprate` ;

CREATE TABLE IF NOT EXISTS `caprate` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `monthly_opcosts` INT NULL,
  `rent` INT NULL,
  `rate` DECIMAL(5,2) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `property`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `property` ;

CREATE TABLE IF NOT EXISTS `property` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `address_id` INT NOT NULL,
  `note_id` INT NULL,
  `rent` INT NULL,
  `purchase_price` INT NULL,
  `caprate_id` INT NULL,
  `picset_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_property_address_idx` (`address_id` ASC),
  INDEX `fk_property_note_idx` (`note_id` ASC),
  INDEX `fk_property_picset_idx` (`picset_id` ASC),
  INDEX `fk_property_caprate_idx` (`caprate_id` ASC),
  CONSTRAINT `fk_property_address`
    FOREIGN KEY (`address_id`)
    REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_property_note`
    FOREIGN KEY (`note_id`)
    REFERENCES `note` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_property_picset`
    FOREIGN KEY (`picset_id`)
    REFERENCES `pic_set` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_property_caprate`
    FOREIGN KEY (`caprate_id`)
    REFERENCES `caprate` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
GRANT USAGE ON *.* TO ipuser@localhost;
 DROP USER ipuser@localhost;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'ipuser'@'localhost' IDENTIFIED BY 'ipuser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'ipuser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `address`
-- -----------------------------------------------------
START TRANSACTION;
USE `incomeproperties`;
INSERT INTO `address` (`id`, `property_id`, `street_address`, `city`, `state_abbreviation`, `zip_code`) VALUES (1, 1, '123 Any Street', 'Naples', 'FL', NULL);
INSERT INTO `address` (`id`, `property_id`, `street_address`, `city`, `state_abbreviation`, `zip_code`) VALUES (2, 2, '456 Any Street', 'Naples', 'FL', NULL);
INSERT INTO `address` (`id`, `property_id`, `street_address`, `city`, `state_abbreviation`, `zip_code`) VALUES (3, 3, '789 Any Street', 'Naples', 'FL', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `note`
-- -----------------------------------------------------
START TRANSACTION;
USE `incomeproperties`;
INSERT INTO `note` (`id`, `property_id`, `note`) VALUES (1, 1, 'notes for prop 1');
INSERT INTO `note` (`id`, `property_id`, `note`) VALUES (2, 2, 'notes for prop 2');
INSERT INTO `note` (`id`, `property_id`, `note`) VALUES (3, 3, 'notes for prop 3');

COMMIT;


-- -----------------------------------------------------
-- Data for table `property`
-- -----------------------------------------------------
START TRANSACTION;
USE `incomeproperties`;
INSERT INTO `property` (`id`, `address_id`, `note_id`, `rent`, `purchase_price`, `caprate_id`, `picset_id`) VALUES (1, 1, 1, 4000, 300000, NULL, NULL);
INSERT INTO `property` (`id`, `address_id`, `note_id`, `rent`, `purchase_price`, `caprate_id`, `picset_id`) VALUES (2, 2, 2, 5000, 400000, NULL, NULL);
INSERT INTO `property` (`id`, `address_id`, `note_id`, `rent`, `purchase_price`, `caprate_id`, `picset_id`) VALUES (3, 3, 3, 7000, 450000, NULL, NULL);

COMMIT;

