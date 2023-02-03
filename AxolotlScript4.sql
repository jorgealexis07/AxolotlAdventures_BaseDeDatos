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
-- -----------------------------------------------------
-- Schema db_axolotl
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema db_axolotl
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_axolotl` DEFAULT CHARACTER SET utf8mb3 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Actividades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Actividades` (
  `id_Actividades` INT NOT NULL AUTO_INCREMENT,
  `nom_actv` VARCHAR(45) NOT NULL,
  `precio_actv` INT NOT NULL,
  `descrip_actv` VARCHAR(300) NOT NULL,
  `resumen_actv` VARCHAR(200) NOT NULL,
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
  `id_Compras` INT NOT NULL AUTO_INCREMENT,
  `date_Compras` DATE NOT NULL,
  `numpx_actv` INT NOT NULL,
  `precio_total` INT NULL,
  `Clientes_id_Clientes` INT NOT NULL,
  PRIMARY KEY (`id_Compras`, `Clientes_id_Clientes`),
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

USE `db_axolotl` ;

-- -----------------------------------------------------
-- Table `db_axolotl`.`actividades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_axolotl`.`actividades` (
  `id_Actividades` INT NOT NULL AUTO_INCREMENT,
  `nom_actv` VARCHAR(45) NOT NULL,
  `precio_actv` INT NOT NULL,
  `tiempo_actv` INT NOT NULL,
  `descrip_actv` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id_Actividades`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `db_axolotl`.`actividades_has_ventas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_axolotl`.`actividades_has_ventas` (
  `Actividades_id_Actividades` INT NOT NULL,
  `Ventas_id_VentasClientes` INT NOT NULL,
  `Ventas_Clientes_id_Clientes` INT NOT NULL,
  PRIMARY KEY (`Actividades_id_Actividades`, `Ventas_id_VentasClientes`, `Ventas_Clientes_id_Clientes`),
  INDEX `fk_Actividades_has_Ventas_Ventas1_idx` (`Ventas_id_VentasClientes` ASC, `Ventas_Clientes_id_Clientes` ASC) VISIBLE,
  INDEX `fk_Actividades_has_Ventas_Actividades1_idx` (`Actividades_id_Actividades` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `db_axolotl`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_axolotl`.`clientes` (
  `id_Clientes` INT NOT NULL AUTO_INCREMENT,
  `nom_cliente` VARCHAR(45) NOT NULL,
  `app_cliente` VARCHAR(45) NOT NULL,
  `email_cliente` VARCHAR(45) NOT NULL,
  `cel_cliente` VARCHAR(13) NOT NULL,
  `contr_cliente` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_Clientes`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `db_axolotl`.`ventas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_axolotl`.`ventas` (
  `id_VentasClientes` INT NOT NULL AUTO_INCREMENT,
  `date_Venta` DATE NOT NULL,
  `numpx_actv` INT NOT NULL,
  `precio_total` INT NULL DEFAULT NULL,
  `Clientes_id_Clientes` INT NOT NULL,
  PRIMARY KEY (`id_VentasClientes`, `Clientes_id_Clientes`),
  INDEX `fk_Ventas_Clientes1_idx` (`Clientes_id_Clientes` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 26
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
