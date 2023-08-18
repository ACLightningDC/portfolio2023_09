-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`users` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `userid` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `name` NVARCHAR(45) NOT NULL,
  `joinDate` DATE NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NULL,
  `birthday` DATE NULL,
  `degree` CHAR(1) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `userid_UNIQUE` (`userid` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`seller`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`seller` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `users_id` INT UNSIGNED NOT NULL,
  `CompanyRegistrationNumber` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`, `users_id`, `CompanyRegistrationNumber`),
  INDEX `fk_seller_users1_idx` (`users_id` ASC) VISIBLE,
  CONSTRAINT `fk_seller_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `mydb`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`sellerrMall`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`sellerrMall` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `seller_id` INT UNSIGNED NOT NULL,
  `name` NVARCHAR(45) NOT NULL,
  `create_date` DATE NOT NULL,
  PRIMARY KEY (`id`, `seller_id`),
  INDEX `fk_sellerrMall_seller1_idx` (`seller_id` ASC) VISIBLE,
  CONSTRAINT `fk_sellerrMall_seller1`
    FOREIGN KEY (`seller_id`)
    REFERENCES `mydb`.`seller` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`product` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `sellerrMall_id` INT UNSIGNED NOT NULL,
  `price` INT NOT NULL,
  `name` NVARCHAR(45) NOT NULL,
  `kind` NVARCHAR(45) NOT NULL,
  `date` DATE NOT NULL,
  `img` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`, `sellerrMall_id`),
  INDEX `fk_product_sellerrMall1_idx` (`sellerrMall_id` ASC) VISIBLE,
  CONSTRAINT `fk_product_sellerrMall1`
    FOREIGN KEY (`sellerrMall_id`)
    REFERENCES `mydb`.`sellerrMall` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`product_ description`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`product_ description` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `product_id` INT UNSIGNED NOT NULL,
  `description_name` NVARCHAR(45) NOT NULL,
  `parameter` NVARCHAR(45) NULL,
  PRIMARY KEY (`id`, `product_id`),
  INDEX `fk_product_ description_product1_idx` (`product_id` ASC) VISIBLE,
  CONSTRAINT `fk_product_ description_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `mydb`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`order` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `users_id` INT UNSIGNED NOT NULL,
  `product_id` INT UNSIGNED NOT NULL,
  `order_count` INT NOT NULL,
  `delivery` CHAR(1) NULL,
  `indate` DATE NOT NULL,
  `result` VARCHAR(45) NULL,
  PRIMARY KEY (`id`, `users_id`, `product_id`),
  INDEX `fk_order_users1_idx` (`users_id` ASC) VISIBLE,
  INDEX `fk_order_product1_idx` (`product_id` ASC) VISIBLE,
  CONSTRAINT `fk_order_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `mydb`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `mydb`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`inquiry`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`inquiry` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `users_id` INT UNSIGNED NOT NULL,
  `sellerrMall_id` INT UNSIGNED NOT NULL,
  `contents` NVARCHAR(300) NULL,
  `name` NVARCHAR(45) NULL,
  `date` VARCHAR(45) NULL,
  `inquirycol` DATE NULL,
  `result` CHAR(1) NULL,
  PRIMARY KEY (`id`, `users_id`, `sellerrMall_id`),
  INDEX `fk_inquiry_users1_idx` (`users_id` ASC) VISIBLE,
  INDEX `fk_inquiry_sellerrMall1_idx` (`sellerrMall_id` ASC) VISIBLE,
  CONSTRAINT `fk_inquiry_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `mydb`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_inquiry_sellerrMall1`
    FOREIGN KEY (`sellerrMall_id`)
    REFERENCES `mydb`.`sellerrMall` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

select* from users;