-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema testdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Table `users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `users` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `userid` VARCHAR(45) NOT NULL,
  `password` VARCHAR(500) NOT NULL,
  `name` NVARCHAR(45) NOT NULL,
  `date` TIMESTAMP NOT NULL DEFAULT current_timestamp,
  `phone` VARCHAR(45) NOT NULL,
  `gender` VARCHAR(1) NOT NULL,
  `email` VARCHAR(45) NULL,
  `birthday` DATE NULL,
  `grade` NVARCHAR(1) NULL DEFAULT 'N',
  `address_id` INT NULL DEFAULT -1,
  `snsLogin_id` VARCHAR(45) NULL DEFAULT '00',
  `userSecurity_id` VARCHAR(45) NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `userid_UNIQUE` (`userid` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `seller`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `seller` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `users_id` INT UNSIGNED NOT NULL,
  `CompanyRegistrationNumber` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`, `users_id`, `CompanyRegistrationNumber`),
  INDEX `fk_seller_users1_idx` (`users_id` ASC) VISIBLE,
  CONSTRAINT `fk_seller_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `users` (`id`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `sellermall`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sellermall` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `seller_id` INT UNSIGNED NOT NULL,
  `name` NVARCHAR(45) NOT NULL,
  `create_date` TIMESTAMP NOT NULL DEFAULT current_timestamp,
  `grade` NVARCHAR(1) NULL DEFAULT 'N',
  PRIMARY KEY (`id`, `seller_id`),
  INDEX `fk_sellerrMall_seller1_idx` (`seller_id` ASC) VISIBLE,
  CONSTRAINT `fk_sellerrMall_seller1`
    FOREIGN KEY (`seller_id`)
    REFERENCES `seller` (`id`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `product` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `sellerMall_id` INT UNSIGNED NOT NULL,
  `price` INT NOT NULL,
  `name` VARCHAR(45) CHARACTER SET 'utf8mb3' NOT NULL,
  `kind` VARCHAR(45) NOT NULL,
  `date` TIMESTAMP NOT NULL DEFAULT current_timestamp,
  `img` VARCHAR(200) NOT NULL,
  `buycount` INT NULL DEFAULT 0,
  `stock` INT NULL DEFAULT -1,
  PRIMARY KEY (`id`, `sellerMall_id`),
  INDEX `fk_product_sellerrMall1_idx` (`sellerMall_id` ASC) VISIBLE,
  CONSTRAINT `fk_product_sellerrMall1`
    FOREIGN KEY (`sellerMall_id`)
    REFERENCES `sellermall` (`id`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `order_list`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `order_list` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `users_id` INT UNSIGNED NOT NULL,
  `product_id` INT UNSIGNED NOT NULL,
  `order_count` INT NOT NULL DEFAULT 1,
  `delivery_id` INT NOT NULL DEFAULT -1,
  `date` TIMESTAMP NULL DEFAULT current_timestamp,
  `result` VARCHAR(45) NULL DEFAULT 'N',
  PRIMARY KEY (`id`, `users_id`, `product_id`),
  INDEX `fk_order_users1_idx` (`users_id` ASC) VISIBLE,
  INDEX `fk_order_product1_idx` (`product_id` ASC) VISIBLE,
  CONSTRAINT `fk_order_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `product` (`id`),
  CONSTRAINT `fk_order_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `users` (`id`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `inquiry`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inquiry` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `users_id` INT UNSIGNED NOT NULL,
  `sellerrMall_id` INT UNSIGNED NOT NULL,
  `product_id` INT UNSIGNED NOT NULL,
  `order_list_id` INT UNSIGNED NOT NULL,
  `contents` NVARCHAR(300) NULL,
  `name` NVARCHAR(45) NOT NULL,
  `date` TIMESTAMP NULL DEFAULT current_timestamp,
  `result` NVARCHAR(1) NULL DEFAULT 'N',
  `answer` NVARCHAR(300) NULL,
  PRIMARY KEY (`id`, `users_id`, `sellerrMall_id`, `product_id`, `order_list_id`),
  INDEX `fk_inquiry_users1_idx` (`users_id` ASC) VISIBLE,
  INDEX `fk_inquiry_sellerrMall1_idx` (`sellerrMall_id` ASC) VISIBLE,
  INDEX `fk_inquiry_product1_idx` (`product_id` ASC) VISIBLE,
  INDEX `fk_inquiry_order_list1_idx` (`order_list_id` ASC) VISIBLE,
  CONSTRAINT `fk_inquiry_sellerrMall1`
    FOREIGN KEY (`sellerrMall_id`)
    REFERENCES `sellermall` (`id`)
    ON DELETE CASCADE,
  CONSTRAINT `fk_inquiry_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `users` (`id`)
    ON DELETE NO ACTION,
  CONSTRAINT `fk_inquiry_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_inquiry_order_list1`
    FOREIGN KEY (`order_list_id`)
    REFERENCES `order_list` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `product_ description`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `product_ description` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `product_id` INT UNSIGNED NOT NULL,
  `description_name` NVARCHAR(45) NOT NULL,
  `parameter` NVARCHAR(200) NULL,
  PRIMARY KEY (`id`, `product_id`),
  INDEX `fk_product_ description_product1_idx` (`product_id` ASC) VISIBLE,
  CONSTRAINT `fk_product_ description_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `product` (`id`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `address` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `users_id` INT UNSIGNED NOT NULL,
  `postcode` VARCHAR(45) NOT NULL,
  `address1` VARCHAR(300) NOT NULL,
  `address2` VARCHAR(300) NULL,
  PRIMARY KEY (`id`, `users_id`),
  INDEX `fk_address_users1_idx` (`users_id` ASC) VISIBLE,
  CONSTRAINT `fk_address_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `users` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_security`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user_security` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `users_id` INT UNSIGNED NOT NULL,
  `ipaddress` VARCHAR(200) NULL,
  `model` VARCHAR(200) NULL,
  `security_check` INT NULL DEFAULT 0,
  PRIMARY KEY (`id`, `users_id`),
  INDEX `fk_user_security_users1_idx` (`users_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_security_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `users` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `review` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `order_list_id` INT UNSIGNED NOT NULL,
  `star_score` INT NOT NULL,
  `contents` NVARCHAR(300) NULL,
  PRIMARY KEY (`id`, `order_list_id`),
  INDEX `fk_review_order_list1_idx` (`order_list_id` ASC) VISIBLE,
  CONSTRAINT `fk_review_order_list1`
    FOREIGN KEY (`order_list_id`)
    REFERENCES `order_list` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `delivery`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `delivery` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `address_id` INT UNSIGNED NOT NULL,
  `delivery_company` VARCHAR(10) NULL,
  `delivery_num` VARCHAR(60) NULL,
  PRIMARY KEY (`id`, `address_id`),
  INDEX `fk_delivery_address1_idx` (`address_id` ASC) VISIBLE,
  CONSTRAINT `fk_delivery_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `address` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sellerMallPage`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sellerMallPage` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `sellermall_id` INT UNSIGNED NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `name` NVARCHAR(45) NOT NULL,
  `categori` VARCHAR(45) NULL DEFAULT 'N',
  PRIMARY KEY (`id`, `sellermall_id`),
  INDEX `fk_sellerMallPage_sellermall1_idx` (`sellermall_id` ASC) VISIBLE,
  CONSTRAINT `fk_sellerMallPage_sellermall1`
    FOREIGN KEY (`sellermall_id`)
    REFERENCES `sellermall` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TextContents`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TextContents` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `sellerMallPage_id` INT NOT NULL,
  `Name` VARCHAR(45) NULL,
  `Content` NVARCHAR(5000) NULL,
  `date` TIMESTAMP NULL DEFAULT current_timestamp,
  PRIMARY KEY (`id`, `sellerMallPage_id`),
  INDEX `fk_Contents_sellerMallPage1_idx` (`sellerMallPage_id` ASC) VISIBLE,
  CONSTRAINT `fk_Contents_sellerMallPage1`
    FOREIGN KEY (`sellerMallPage_id`)
    REFERENCES `sellerMallPage` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ProductContents`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ProductContents` (
  `id` INT NOT NULL,
  `sellerMallPage_id` INT NOT NULL,
  `kind` NVARCHAR(45) NULL,
  `description_name` NVARCHAR(45) NULL,
  PRIMARY KEY (`id`, `sellerMallPage_id`),
  INDEX `fk_table1_sellerMallPage1_idx` (`sellerMallPage_id` ASC) VISIBLE,
  CONSTRAINT `fk_table1_sellerMallPage1`
    FOREIGN KEY (`sellerMallPage_id`)
    REFERENCES `sellerMallPage` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `snsLogin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `snsLogin` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `users_id` INT UNSIGNED NOT NULL,
  `snsId` VARCHAR(45) NOT NULL,
  `snsEmail` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`, `users_id`),
  INDEX `fk_snsLogin_users1_idx` (`users_id` ASC) VISIBLE,
  CONSTRAINT `fk_snsLogin_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pay_table`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pay_table` (
  `orderId` VARCHAR(64) NOT NULL,
  `mId` NVARCHAR(14) NOT NULL,
  `paymentKey` VARCHAR(200) NOT NULL,
  `order_num` INT UNSIGNED NOT NULL,
  `id` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `orderName` VARCHAR(100) NULL,
  `pay_method` VARCHAR(10) NOT NULL,
  `easyPay` VARCHAR(100) NULL,
  `pay_bank` VARCHAR(10) NULL,
  `pay_status` VARCHAR(45) NOT NULL,
  `pay_date` DATETIME NOT NULL,
  `totalAmount` INT NOT NULL,
  `cancelReason` NVARCHAR(100) NOT NULL,
  `cancel_date` DATETIME NULL,
  `cancelAmount` INT NULL,
  PRIMARY KEY (`orderId`, `order_num`),
  INDEX `fk_pay_table_order_list1_idx` (`order_num` ASC) VISIBLE,
  CONSTRAINT `fk_pay_table_order_list1`
    FOREIGN KEY (`order_num`)
    REFERENCES `order_list` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
