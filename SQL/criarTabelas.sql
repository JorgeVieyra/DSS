SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema MediaCenter
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema MediaCenter
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `MediaCenter` ;
USE `MediaCenter` ;

-- -----------------------------------------------------
-- Table `MediaCenter`.`Conta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MediaCenter`.`Conta` (
  `username` VARCHAR(16) NOT NULL,
  `senha` VARCHAR(32) NOT NULL,
  `isAdmin` TINYINT NOT NULL,
  `email` VARCHAR(254) NOT NULL,
  PRIMARY KEY (`username`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MediaCenter`.`Colecao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MediaCenter`.`Colecao` (
  `idColecao` INT NOT NULL,
  `criador` VARCHAR(16) NULL,
  `titulo` VARCHAR(32) NOT NULL,
  `categoria` VARCHAR(32) NOT NULL,
  `isPublic` TINYINT NOT NULL,
  PRIMARY KEY (`idColecao`),
  INDEX `fk_Criador_idx` (`criador` ASC) VISIBLE,
  CONSTRAINT `fk_Criador`
    FOREIGN KEY (`criador`)
    REFERENCES `MediaCenter`.`Conta` (`username`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MediaCenter`.`MediaID`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MediaCenter`.`MediaID` (
  `idMedia` INT NOT NULL,
  PRIMARY KEY (`idMedia`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MediaCenter`.`Musica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MediaCenter`.`Musica` (
  `idMusica` INT NOT NULL,
  `titulo` VARCHAR(100) NOT NULL,
  `artista` VARCHAR(64) NOT NULL,
  `dataInclusao` DATE NOT NULL,
  `colecao` INT NULL,
  `uploader` VARCHAR(16) NULL,
  `isPublic` TINYINT NOT NULL,
  `caminho` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idMusica`),
  INDEX `fk_Colecao_idx` (`colecao` ASC) VISIBLE,
  INDEX `fk_UploaderM_idx` (`uploader` ASC) VISIBLE,
  CONSTRAINT `fk_ColecaoM`
    FOREIGN KEY (`colecao`)
    REFERENCES `MediaCenter`.`Colecao` (`idColecao`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_UploaderM`
    FOREIGN KEY (`uploader`)
    REFERENCES `MediaCenter`.`Conta` (`username`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_MusicaID`
    FOREIGN KEY (`idMusica`)
    REFERENCES `MediaCenter`.`MediaID` (`idMedia`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MediaCenter`.`Video`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MediaCenter`.`Video` (
  `idVideo` INT NOT NULL,
  `titulo` VARCHAR(100) NOT NULL,
  `dataInclusao` DATE NOT NULL,
  `colecao` INT NULL,
  `uploader` VARCHAR(16) NULL,
  `isPublic` TINYINT NOT NULL,
  `caminho` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idVideo`),
  INDEX `fk_Colecao_idx` (`colecao` ASC) VISIBLE,
  INDEX `fk_Uploader_idx` (`uploader` ASC) VISIBLE,
  CONSTRAINT `fk_ColecaoV`
    FOREIGN KEY (`colecao`)
    REFERENCES `MediaCenter`.`Colecao` (`idColecao`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_UploaderV`
    FOREIGN KEY (`uploader`)
    REFERENCES `MediaCenter`.`Conta` (`username`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_idVideo`
    FOREIGN KEY (`idVideo`)
    REFERENCES `MediaCenter`.`MediaID` (`idMedia`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MediaCenter`.`Amizade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MediaCenter`.`Amizade` (
  `idAmizade` INT NOT NULL,
  `user1` VARCHAR(16) NOT NULL,
  `user2` VARCHAR(16) NOT NULL,
  PRIMARY KEY (`idAmizade`),
  INDEX `fk_Amizade_2_idx` (`user2` ASC) VISIBLE,
  INDEX `fk_Amizade_1_idx` (`user1` ASC) VISIBLE,
  CONSTRAINT `fk_Amizade_1`
    FOREIGN KEY (`user1`)
    REFERENCES `MediaCenter`.`Conta` (`username`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Amizade_2`
    FOREIGN KEY (`user2`)
    REFERENCES `MediaCenter`.`Conta` (`username`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

