CREATE TABLE cliente (
  id BIGINT AUTO_INCREMENT NOT NULL,
   nome VARCHAR(150) NOT NULL,
   documento VARCHAR(14) NOT NULL,
   email VARCHAR(255) NOT NULL,
   telefone VARCHAR(11) NOT NULL,
   data_cadastro datetime NOT NULL,
   data_atualizacao datetime NULL,
   CONSTRAINT pk_cliente PRIMARY KEY (id)
);