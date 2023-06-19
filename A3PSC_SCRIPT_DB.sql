CREATE DATABASE a3psc;
USE a3psc;

CREATE TABLE estampa (
  idEstampa INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  setorEstampa VARCHAR(45) NULL,
  nomeEstampa VARCHAR(50) NULL
  );

CREATE TABLE login (
  usuario VARCHAR(36) PRIMARY KEY NOT NULL,
  senha VARCHAR(45) NULL
  );

CREATE TABLE pedido (
  idPedido INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  precoTotal DOUBLE NULL,
  estado VARCHAR(45) NOT NULL,
  formaPgto VARCHAR(45)
  );

CREATE TABLE produto (
  idProd INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  nomeProd VARCHAR(45) NULL,
  setor VARCHAR(45) NULL,
  cor VARCHAR(45) NULL,
  tamanho VARCHAR(1) NULL,
  estampa VARCHAR(45) NULL,
  idEstampa INT NULL,
  qtde INT NULL,
  preco DOUBLE NULL
  );

CREATE TABLE setor (
  nomeSetor VARCHAR(50) PRIMARY KEY NOT NULL
);

CREATE TABLE pedidoproduto (
  idPedido INT NOT NULL,
  idProd INT NULL,
  qtdeProd INT NULL
  );
