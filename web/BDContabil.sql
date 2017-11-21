/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Coronel Mustang
 * Created: 21/11/2017
 */
-- MySQL Workbench Synchronization
-- Generated: 2017-11-21 20:00
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: Coronel Mustang

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `BDContabil` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE IF NOT EXISTS `BDContabil`.`tb_empresa` (
  `id_empresa` INT(11) NOT NULL AUTO_INCREMENT,
  `empresa` VARCHAR(45) NOT NULL,
  `cnpj` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id_empresa`),
  UNIQUE INDEX `empresa_UNIQUE` (`empresa` ASC),
  UNIQUE INDEX `cnpj_UNIQUE` (`cnpj` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `BDContabil`.`tb_balanco` (
  `id_balanco` INT(11) NOT NULL AUTO_INCREMENT,
  `fk_empresa` INT(11) NOT NULL,
  `ano` INT(11) NOT NULL,
  `mes` INT(11) NOT NULL,
  PRIMARY KEY (`id_balanco`),
  INDEX `fk_empresa_in_tb_balanco_idx` (`fk_empresa` ASC),
  CONSTRAINT `fk_empresa_in_tb_balanco`
    FOREIGN KEY (`fk_empresa`)
    REFERENCES `BDContabil`.`tb_empresa` (`id_empresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `BDContabil`.`tb_grupo` (
  `id_grupo` INT(11) NOT NULL AUTO_INCREMENT,
  `grupo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_grupo`),
UNIQUE INDEX `grupo_UNIQUE` (`grupo` ASC),
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `BDContabil`.`tb_subgrupo` (
  `id_subgrupo` INT(11) NOT NULL AUTO_INCREMENT,
  `subgrupo` VARCHAR(45) NOT NULL,
  `fk_grupo` INT(11) NOT NULL,
  `fk_empresa` INT(11) NOT NULL,
  PRIMARY KEY (`id_subgrupo`),
  INDEX `fk_grupo_in_tb_subgrupo_idx` (`fk_grupo` ASC),
  INDEX `fk_empresa_in_tb_subgrupo_idx` (`fk_empresa` ASC),
  CONSTRAINT `fk_grupo_in_tb_subgrupo`
    FOREIGN KEY (`fk_grupo`)
    REFERENCES `BDContabil`.`tb_grupo` (`id_grupo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_empresa_in_tb_subgrupo`
    FOREIGN KEY (`fk_empresa`)
    REFERENCES `BDContabil`.`tb_empresa` (`id_empresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `BDContabil`.`tb_conta` (
  `id_conta` INT(11) NOT NULL AUTO_INCREMENT,
  `conta` VARCHAR(45) NOT NULL,
  `fk_balanco` INT(11) NOT NULL,
  `fk_subconta` INT(11) NOT NULL,
  `fk_empresa` INT(11) NOT NULL,
  `valor` DOUBLE NOT NULL,
  PRIMARY KEY (`id_conta`),
  INDEX `fk_balanco_in_tb_conta_idx` (`fk_balanco` ASC),
  INDEX `fk_subgrupo_in_tb_conta_idx` (`fk_subconta` ASC),
  INDEX `fk_empresa_in_tb_conta_idx` (`fk_empresa` ASC),
  CONSTRAINT `fk_balanco_in_tb_conta`
    FOREIGN KEY (`fk_balanco`)
    REFERENCES `BDContabil`.`tb_balanco` (`id_balanco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_subgrupo_in_tb_conta`
    FOREIGN KEY (`fk_subconta`)
    REFERENCES `BDContabil`.`tb_subgrupo` (`id_subgrupo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_empresa_in_tb_conta`
    FOREIGN KEY (`fk_empresa`)
    REFERENCES `BDContabil`.`tb_empresa` (`id_empresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
