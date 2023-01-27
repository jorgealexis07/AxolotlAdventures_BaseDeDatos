-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema AxolotlDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema AxolotlDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `AxolotlDB` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema AxolotlDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema AxolotlDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `AxolotlDB` DEFAULT CHARACTER SET utf8mb3 ;
USE `AxolotlDB` ;

-- -----------------------------------------------------
-- Table `mydb`.`Actividades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AxolotlDB`.`Actividades` (
  `id_Actividades` INT NOT NULL AUTO_INCREMENT,
  `nom_actv` VARCHAR(45) NOT NULL,
  `precio_actv` INT NOT NULL,
  `descrip_actv` VARCHAR(300) NOT NULL,
  `img_actv` VARCHAR(300) NOT NULL,
  `Actividadescol` VARCHAR(45) NULL,
  PRIMARY KEY (`id_Actividades`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AxolotlDB`.`Clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AxolotlDB`.`Clientes` (
  `id_Clientes` INT NOT NULL AUTO_INCREMENT,
  `nom_cliente` VARCHAR(45) NOT NULL,
  `app_cliente` VARCHAR(45) NOT NULL,
  `email_cliente` VARCHAR(45) NOT NULL,
  `cel_cliente` VARCHAR(13) NOT NULL,
  `contr_cliente` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_Clientes`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AxolotlDB`.`Compras`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AxolotlDB`.`Compras` (
  `id_ComprasClientes` INT NOT NULL AUTO_INCREMENT,
  `date_Compras` DATE NOT NULL,
  `numpx_actv` INT NOT NULL,
  `precio_total` INT NULL,
  `Clientes_id_Clientes` INT NOT NULL,
  PRIMARY KEY (`id_ComprasClientes`, `Clientes_id_Clientes`),
  INDEX `fk_Compras_Clientes1_idx` (`Clientes_id_Clientes` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AxolotlDB`.`Actividades_has_Compras`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AxolotlDB`.`Actividades_has_Compras` (
  `Actividades_id_Actividades` INT NOT NULL,
  `Compras_id_ComprasClientes` INT NOT NULL,
  `Compras_Clientes_id_Clientes` INT NOT NULL,
  PRIMARY KEY (`Actividades_id_Actividades`, `Compras_id_ComprasClientes`, `Compras_Clientes_id_Clientes`),
  INDEX `fk_Actividades_has_Compras_Compras1_idx` (`Compras_id_ComprasClientes` ASC, `Compras_Clientes_id_Clientes` ASC) VISIBLE,
  INDEX `fk_Actividades_has_Compras_Actividades1_idx` (`Actividades_id_Actividades` ASC) VISIBLE)
ENGINE = InnoDB;

USE `AxolotlDB` ;
INSERT INTO AxolotlDB . Actividades (nom_actv, precio_actv, descrip_actv, img_actv)
VALUES ("Los Cabos", 4620, "recorrido por los principales lugares de Cabo.", "img1"),
	   ("Bernal", 1479, "Suba a la cima del tercer monolito más alto del mundo.", "img1"),
       ("Riviera Maya", 5700, "Prepárate para disfrutar y enamorarte de la belleza y actividades de este hermoso Parque Nacional.", "img1"),
       ("San Miguel de Ayende",1300, "El recorrido cuenta con un guía que lo acercará a la arquitectura barroca de esta ciudad colonial.", "img1"),
       ("Puerto Vallarta", 4500, "Pocas experiencias se comparan a nadar con los delfines en su hábitat natural y Puerto Vallarta es el hogar de un gran número de ellos.", "img1"),
       ("Guadalajara", 3200, "Recorrido turístico en Guadalajara para conocer la ciudad. Se inicia conociendo la zona de La Minerva, Los Arcos de Guadalajara, entre otros.", "img1"),
	   ("Michoacan", 2890, "Escape de la ciudad con una visita memorable al santuario de la mariposa monarca.", "img1")
    ;
    
INSERT INTO AxolotlDB . Clientes (nom_cliente, app_cliente, email_cliente, cel_cliente, contr_cliente)
VALUES ("Valeria", "Duque", "valeria.duques99@gmail.com", "3334982345", "duquesilla"),
	   ("Danilú", "Hernandez", "danilu_24@live.com", "332171226", "daniuuuuu"),
       ("Alexis","Perez","alexisillopillo89@gmail.com", "3345670984", "lerolero"),
       ("Leonardo", "Alvarez", "leonrawr@outlook.com", "3234567890", "lerolero"),
	   ("Cesar", "Mora", "moraleja777@outlook.com", "876542321", "morita")
	;
    
INSERT INTO AxolotlDB. Compras (date_Compras, numpx_actv, precio_total, Clientes_id_Clientes)
VALUES ("11-07-22", 4, 5916,1),
       ("26-11-22", 2, 11400,2),
       ("16-09-22", 10, 13000,3),
       ("14-02-22", 2, 9000, 4),
       ("19-01-22", 3, 13860, 5)
       ;
 INSERT INTO AxolotlDB . Actividades_has_Compras ( Actividades_id_Actividades, Compras_id_ComprasClientes, Compras_Clientes_id_Clientes)
VALUES      
(1,1,1),
(2,2,2),
(3,3,3),
(4,4,4),
(5,5,5)
		