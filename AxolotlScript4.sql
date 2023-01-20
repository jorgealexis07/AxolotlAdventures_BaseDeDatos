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
  `tiempo_actv` INT NOT NULL,
  `descrip_actv` VARCHAR(200) NOT NULL,
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
-- Table `db_axolotl`.`Ventas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_axolotl`.`Ventas` (
  `id_VentasClientes` INT NOT NULL AUTO_INCREMENT,
  `date_Venta` DATE NOT NULL,
  `numpx_actv` INT NOT NULL,
  `precio_total` INT NULL,
  `Clientes_id_Clientes` INT NOT NULL,
  PRIMARY KEY (`id_VentasClientes`, `Clientes_id_Clientes`),
  INDEX `fk_Ventas_Clientes1_idx` (`Clientes_id_Clientes` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_axolotl`.`Actividades_has_Ventas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_axolotl`.`Actividades_has_Ventas` (
  `Actividades_id_Actividades` INT NOT NULL,
  `Ventas_id_VentasClientes` INT NOT NULL,
  `Ventas_Clientes_id_Clientes` INT NOT NULL,
  PRIMARY KEY (`Actividades_id_Actividades`, `Ventas_id_VentasClientes`, `Ventas_Clientes_id_Clientes`),
  INDEX `fk_Actividades_has_Ventas_Ventas1_idx` (`Ventas_id_VentasClientes` ASC, `Ventas_Clientes_id_Clientes` ASC) VISIBLE,
  INDEX `fk_Actividades_has_Ventas_Actividades1_idx` (`Actividades_id_Actividades` ASC) VISIBLE)
ENGINE = InnoDB;

INSERT INTO db_axolotl . Actividades (nom_actv, precio_actv, tiempo_actv, descrip_actv)
VALUES ("Los Cabos", 4620, 4, "recorrido por los principales lugares de Cabo."),
	   ("Bernal", 1479, 3, "Suba a la cima del tercer monolito más alto del mundo."),
       ("Riviera Maya", 5700, 5, "Prepárate para disfrutar y enamorarte de la belleza y actividades de este hermoso Parque Nacional."),
       ("San Miguel de Ayende",1300, 4, "El recorrido cuenta con un guía que lo acercará a la arquitectura barroca de esta ciudad colonial."),
       ("Puerto Vallarta", 4500, 3, "Pocas experiencias se comparan a nadar con los delfines en su hábitat natural y Puerto Vallarta es el hogar de un gran número de ellos."),
       ("Guadalajara", 3200, 4, "Recorrido turístico en Guadalajara para conocer la ciudad. Se inicia conociendo la zona de La Minerva, Los Arcos de Guadalajara, entre otros."),
	   ("Michoacan", 2890, 3, "Escape de la ciudad con una visita memorable al santuario de la mariposa monarca.")
    ;
    
INSERT INTO db_axolotl . Clientes (nom_cliente, app_cliente, email_cliente, cel_cliente, contr_cliente)
VALUES ("Valeria", "Duque", "valeria.duques99@gmail.com", "3334982345", "duquesilla"),
	   ("Danilú", "Hernandez", "danilu_24@live.com", "332171226", "daniuuuuu"),
       ("Alexis","Perez","alexisillopillo89@gmail.com", "3345670984", "lerolero"),
       ("Leonardo", "Alvarez", "leonrawr@outlook.com", "3234567890", "lerolero"),
	   ("Cesar", "Mora", "moraleja777@outlook.com", "876542321", "morita")
	;
    
INSERT INTO db_axolotl . Ventas (date_Venta, numpx_actv, precio_total, Clientes_id_Clientes)
VALUES ("11-07-22", 4, 5916,1),
       ("26-11-22", 2, 11400,2),
       ("16-09-22", 10, 13000,3),
       ("14-02-22", 2, 9000, 4),
       ("19-01-22", 3, 13860, 5)
       ;
 INSERT INTO db_axolotl . Actividades_has_Ventas ( Actividades_id_Actividades, Ventas_id_VentasClientes, Ventas_Clientes_id_Clientes)
VALUES      (1,1,1),
            (2,2,2),
			(3,3,3),
			(4,4,4),
            (5,5,5)
			;




SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;