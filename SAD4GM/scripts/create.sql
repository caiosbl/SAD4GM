create SCHEMA sad4gm;

create table sad4gm.usuario(
nome long VARCHAR,
id long VARCHAR,
senha INTEGER NOT NULL,
auditor long VARCHAR,
ativo INTEGER);

create table sad4gm.admin(
nome long VARCHAR,
id long VARCHAR,
senha long VARCHAR
);

create table sad4gm.maquina(
nome VARCHAR(20) NOT NULL,
codigo INTEGER NOT NULL,
descricao VARCHAR(20)NOT NULL);

INSERT INTO sad4gm.admin (nome, senha,id) VALUES ('Desides Admin','rootdesides','admin');