-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema db_axolotl
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema db_axolotl
-- -----------------------------------------------------

CREATE SCHEMA IF NOT EXISTS `db_axolotl` DEFAULT CHARACTER SET utf8 ;
USE `db_axolotl` ;

-- -----------------------------------------------------
-- Table `db_axolotl`.`Actividades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_axolotl`.`Actividades` (
  `id_Actividades` INT NOT NULL AUTO_INCREMENT,
  `nom_actv` VARCHAR(45) NOT NULL,
  `precio_actv` INT NOT NULL,
  `descrip_actv` VARCHAR(200) NOT NULL,
`img_actv` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_Actividades`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_axolotl`.`Clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_axolotl`.`Clientes` (
  `id_Clientes` INT NOT NULL AUTO_INCREMENT,
  `nom_cliente` VARCHAR(45) NOT NULL,
  `app_cliente` VARCHAR(45) NOT NULL,
  `email_cliente` VARCHAR(45) NOT NULL,
  `cel_cliente` VARCHAR(13) NOT NULL,
  `contr_cliente` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_Clientes`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_axolotl`.`Compras`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_axolotl`.`Compras` (
  `id_ComprasClientes` INT NOT NULL AUTO_INCREMENT,
  `date_Venta` DATE NOT NULL,
  `numpx_actv` INT NOT NULL,
  `precio_total` INT NULL,
  `Clientes_id_Clientes` INT NOT NULL,
  PRIMARY KEY (`id_ComprasClientes`, `Clientes_id_Clientes`),
  INDEX `fk_Compras_Clientes1_idx` (`Clientes_id_Clientes` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_axolotl`.`Actividades_has_Compras`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_axolotl`.`Actividades_has_Compras` (
  `Actividades_id_Actividades` INT NOT NULL,
  `Compras_id_ComprasClientes` INT NOT NULL,
  `Compras_Clientes_id_Clientes` INT NOT NULL,
  PRIMARY KEY (`Actividades_id_Actividades`, `Ventas_id_VentasClientes`, `Ventas_Clientes_id_Clientes`),
  INDEX `fk_Actividades_has_Ventas_Ventas1_idx` (`Ventas_id_VentasClientes` ASC, `Ventas_Clientes_id_Clientes` ASC) VISIBLE,
  INDEX `fk_Actividades_has_Ventas_Actividades1_idx` (`Actividades_id_Actividades` ASC) VISIBLE)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
