CREATE DATABASE a3psc;

CREATE TABLE `a3psc`.`estampa` (
  `idEstampa` INT NOT NULL AUTO_INCREMENT,
  `setorEstampa` VARCHAR(45) NULL,
  `nomeEstampa` VARCHAR(50) NULL,
  PRIMARY KEY (`idEstampa`));

CREATE TABLE `a3psc`.`login` (
  `usuario` VARCHAR(36) NOT NULL,
  `senha` VARCHAR(45) NULL,
  PRIMARY KEY (`usuario`),
  UNIQUE INDEX `usuario_UNIQUE` (`usuario` ASC) VISIBLE);

CREATE TABLE `a3psc`.`pedido` (
  `idpedido` INT NOT NULL AUTO_INCREMENT,
  `precoTotal` DOUBLE NULL,
  `status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idpedido`));

CREATE TABLE `a3psc`.`produto` (
  `idProd` INT NOT NULL AUTO_INCREMENT,
  `nomeProd` VARCHAR(45) NULL,
  `setor` VARCHAR(45) NULL,
  `cor` VARCHAR(45) NULL,
  `tamanho` VARCHAR(1) NULL,
  `estampa` VARCHAR(45) NULL,
  `idEstampa` INT NULL,
  `qtde` INT NULL,
  `preco` DOUBLE NULL,
  PRIMARY KEY (`idProd`));

CREATE TABLE `a3psc`.`setor` (
  `nomeSetor` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`nomeSetor`));

CREATE TABLE `a3psc`.`pedidoproduto` (
  `idPedido` INT NOT NULL,
  `idProd` INT NULL,
  `qtdeProd` INT NULL);
