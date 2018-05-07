

CREATE TABLE maquinas.modo_falha(
descricao LONG VARCHAR,
chave INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
chave_falha INTEGER NOT NULL,
PRIMARY KEY(chave),
CONSTRAINT modo_falha_chave_falha_fkey FOREIGN KEY (chave_falha) REFERENCES maquinas.falha(chave)
);