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
-- Table `mydb`.`Actividades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Actividades` (
  `id_Actividades` INT NOT NULL AUTO_INCREMENT,
  `nom_actv` VARCHAR(45) NOT NULL,
  `precio_actv` INT NOT NULL,
  `descrip_actv` VARCHAR(300) NOT NULL,
  `img_actv` VARCHAR(300) NOT NULL,
  `Actividadescol` VARCHAR(45) NULL,
  PRIMARY KEY (`id_Actividades`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Clientes` (
  `id_Clientes` INT NOT NULL AUTO_INCREMENT,
  `nom_cliente` VARCHAR(45) NOT NULL,
  `app_cliente` VARCHAR(45) NOT NULL,
  `email_cliente` VARCHAR(45) NOT NULL,
  `cel_cliente` VARCHAR(13) NOT NULL,
  `contr_cliente` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_Clientes`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Compras`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Compras` (
  `id_ComprasClientes` INT NOT NULL AUTO_INCREMENT,
  `date_Compras` DATE NOT NULL,
  `numpx_actv` INT NOT NULL,
  `precio_total` INT NULL,
  `Clientes_id_Clientes` INT NOT NULL,
  PRIMARY KEY (`id_ComprasClientes`, `Clientes_id_Clientes`),
  INDEX `fk_Compras_Clientes1_idx` (`Clientes_id_Clientes` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Actividades_has_Compras`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Actividades_has_Compras` (
  `Actividades_id_Actividades` INT NOT NULL,
  `Compras_id_ComprasClientes` INT NOT NULL,
  `Compras_Clientes_id_Clientes` INT NOT NULL,
  PRIMARY KEY (`Actividades_id_Actividades`, `Compras_id_ComprasClientes`, `Compras_Clientes_id_Clientes`),
  INDEX `fk_Actividades_has_Compras_Compras1_idx` (`Compras_id_ComprasClientes` ASC, `Compras_Clientes_id_Clientes` ASC) VISIBLE,
  INDEX `fk_Actividades_has_Compras_Actividades1_idx` (`Actividades_id_Actividades` ASC) VISIBLE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
