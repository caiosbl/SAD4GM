

CREATE TABLE maquinas.falha(
nome LONG VARCHAR,
descricao LONG VARCHAR,
chave INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
chave_componente INTEGER NOT NULL,
CONSTRAINT falha_chave_componente_fkey FOREIGN KEY (chave_componente) REFERENCES maquinas.componente(chave)
);