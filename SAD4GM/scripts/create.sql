create SCHEMA sad4gm;

create table sad4gm.usuario(
nome VARCHAR(20) NOT NULL,
id VARCHAR(20)NOT NULL,
senha INTEGER NOT NULL,
auditor VARCHAR(20)NOT NULL);

create table sad4gm.maquina(
nome VARCHAR(20) NOT NULL,
codigo INTEGER NOT NULL,
descricao VARCHAR(20)NOT NULL);


