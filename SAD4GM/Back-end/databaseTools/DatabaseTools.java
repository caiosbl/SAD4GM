package databaseTools;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * Classe de Ferramentas de Conexão com o Banco de Dados.
 * 
 * @author caiosbl
 *
 */

public abstract class DatabaseTools {

	/**
	 * Instância da Conexão com o Banco de Dados
	 */
	protected Connection con;

	/**
	 * Abre uma Conexão com o Banco de Dados, caso este não exista é chamada a
	 * função de iniciar o Banco de Dados.
	 * 
	 * @throws SQLException Lança uma SQLException caso haja alguma falha na Conexão
	 *                      com o Banco de Dados.
	 */
	protected void abrirConexao() throws SQLException {

		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con = DriverManager.getConnection("jdbc:derby:Sad4gmDatabase;");
		} catch (Exception e) {
			iniciarDatabase();
		}
	}

	/**
	 * Inicia o Banco de Dados.
	 * 
	 * @throws SQLException
	 * 
	 */
	private void iniciarDatabase() throws SQLException {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con = DriverManager.getConnection("jdbc:derby:Sad4gmDatabase; create = true");

			criarSchema(con);
			criarTabelaUsuarios(con);
			inserirAdminDefault(con);
			criarTabelaMaquinas(con);
			criarTabelaSubsistema(con);
			criarTabelaComponente(con);
			criarTabelaFalha(con);
			criarTabelaModoFalha(con);
			criarTabelaCausasPotenciais(con);
			criarTabelaOrigemCausas(con);
			criarTabelaAcoesRecomendadas(con);
			criarTabelaEfeitos(con);
			carregarDados();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void carregarDados() throws SQLException, IOException {


		// Cria um lista para receber os inserts do arquivo
		String[] list = lerArquivoSQL();

		try {
			PreparedStatement stmt = null;
		
			for (String s : list) {
	
				stmt = con.prepareStatement(s);
				stmt.execute();
			}
			
			stmt.close();
			// faz o insert em lote no banco pelo método executeBatch()
		
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private String[] lerArquivoSQL() {
		String[] lista = {
				"INSERT INTO MAQUINAS.MAQUINA( NOME, DATA_INSERCAO, CODIGO, DESCRICAO, CHAVE_USUARIO) VALUES ( 'Transformador', '2018-12-01', 1, 'Sistema Transformador', 1 )",
				"INSERT INTO MAQUINAS.SUBSISTEMA( NOME,  CHAVE_MAQUINA ) VALUES ( 'Parte Ativa', 1 )",
				"INSERT INTO MAQUINAS.SUBSISTEMA( NOME,  CHAVE_MAQUINA ) VALUES ( 'Relés', 1 )",
				"INSERT INTO MAQUINAS.SUBSISTEMA( NOME,  CHAVE_MAQUINA ) VALUES ( 'Buchas e Comutadores', 1)",
				"INSERT INTO MAQUINAS.SUBSISTEMA( NOME, CHAVE_MAQUINA ) VALUES ( 'Sistema de Resfriamento', 1 )",
				"INSERT INTO MAQUINAS.COMPONENTE( NOME,  CHAVE_SUBSISTEMA, FUNCAO ) VALUES ( 'Núcleo', 1, '' )",
				"INSERT INTO MAQUINAS.COMPONENTE( NOME,  CHAVE_SUBSISTEMA, FUNCAO ) VALUES ( 'Sistema de Isolamento', 1, '' )",
				"INSERT INTO MAQUINAS.FALHA( NOME, DESCRICAO, CHAVE_COMPONENTE ) VALUES ( 'Degradação da isolação (óleo e papel isolante)', 'Ruptura total ou redução significativa da suportabilidade da isolação', 2 )",
				"INSERT INTO MAQUINAS.MODO_FALHA( NOME, DESCRICAO, CHAVE_FALHA, INDICE_OCORRENCIA, INDICE_DETECCAO) VALUES ( 'Envelhecimento natural da isolação', '', 1, 1.0, 1.0)",
				"INSERT INTO MAQUINAS.MODO_FALHA( NOME, DESCRICAO, CHAVE_FALHA, INDICE_OCORRENCIA, INDICE_DETECCAO) VALUES ( 'Sobreaquecimento do sistema de isolação', '', 1, 1.0, 1.0)",
				"INSERT INTO MAQUINAS.MODO_FALHA( NOME, DESCRICAO,  CHAVE_FALHA, INDICE_OCORRENCIA, INDICE_DETECCAO) VALUES ( 'Rompimento  do dielétrico (modelo de falha cataléctica) ou degradação do dielétrico (modelo de falha de degradação)', '', 1, 1.0, 1.0)",
				"INSERT INTO MAQUINAS.MODO_FALHA( NOME, DESCRICAO,  CHAVE_FALHA, INDICE_OCORRENCIA, INDICE_DETECCAO) VALUES ( 'Contaminação do sitema de isolação (óleo e papel) por umidade, oxigênio e outros poluentes', '', 1, 1.0, 1.0)",
				"INSERT INTO MAQUINAS.MODO_FALHA( NOME, DESCRICAO,  CHAVE_FALHA, INDICE_OCORRENCIA, INDICE_DETECCAO) VALUES ( 'Eletrização estática do óleo', '', 1, 1.0, 1.0)",
				"INSERT INTO MAQUINAS.MODO_FALHA( NOME, DESCRICAO,  CHAVE_FALHA, INDICE_OCORRENCIA, INDICE_DETECCAO) VALUES ( 'Formação de bolhas no óleo', '', 1, 1.0, 1.0) ",
				"INSERT INTO MAQUINAS.MODO_FALHA( NOME, DESCRICAO,  CHAVE_FALHA, INDICE_OCORRENCIA, INDICE_DETECCAO) VALUES ( 'Degradação da isolação das bobinas', '', 1, 1.0, 1.0 )",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS( NOME,  DESCRICAO, CHAVE_MODO_FALHA ) VALUES ( 'Causas não controláveis', '', 1 )",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS( NOME,  DESCRICAO, CHAVE_MODO_FALHA ) VALUES ( 'Sobretensão no núcleo',  '', 2 )",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS( NOME,  DESCRICAO, CHAVE_MODO_FALHA ) VALUES ( 'Correntes harmônicas no enrolamento', '', 2 )",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS( NOME,  DESCRICAO, CHAVE_MODO_FALHA ) VALUES ( 'Elevação da corrente de carga', '', 2 )",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS( NOME,  DESCRICAO, CHAVE_MODO_FALHA ) VALUES ( 'Deslocamento ou deformação da geometria das bobinas do enrolamento',  '', 2 )",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS( NOME,  DESCRICAO, CHAVE_MODO_FALHA ) VALUES ( 'Temperatura ambiente elevada','', 2 )",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS( NOME,  DESCRICAO, CHAVE_MODO_FALHA ) VALUES ( 'Deficiências na isolação dos parafusos passantes que atravessam pelas lâminas do núcleo, ferragens e jugo', '', 2 )",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS( NOME,  DESCRICAO, CHAVE_MODO_FALHA ) VALUES ( 'Tensão Transitória Rápida (com frente de onda muito rápida)', '', 2 )",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS( NOME,  DESCRICAO, CHAVE_MODO_FALHA ) VALUES ( 'Sobretensões Ressonantes: tensões transitórias oriundas do sistema elétrico', '', 3 )",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS( NOME,  DESCRICAO, CHAVE_MODO_FALHA ) VALUES ( 'Tensão Transitória Rápida (com frente de onda muito rápida)','', 3 )",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS( NOME,  DESCRICAO, CHAVE_MODO_FALHA ) VALUES ( 'Falha no sistema de resfriamento','', 4 )",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS( NOME,  DESCRICAO, CHAVE_MODO_FALHA ) VALUES ( 'Defeito das gaxetas de vedação','', 4 )",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS( NOME,  DESCRICAO, CHAVE_MODO_FALHA ) VALUES ( 'Corrosão do tanque principal','', 4 )",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS( NOME,  DESCRICAO, CHAVE_MODO_FALHA ) VALUES ( 'Corrosão do tanque auxiliar','', 4 )",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS( NOME,  DESCRICAO, CHAVE_MODO_FALHA ) VALUES ( 'Defeito da vedação','', 4 )",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS( NOME,  DESCRICAO, CHAVE_MODO_FALHA ) VALUES ( 'Defeitos em bombas do sistema de resfriamento','', 4 )",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS( NOME,  DESCRICAO, CHAVE_MODO_FALHA ) VALUES ( 'Ruptura das membranas dos tubos de expansão', '', 4 )",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS( NOME,  DESCRICAO, CHAVE_MODO_FALHA ) VALUES ( 'Porosidade da borracha que compõe a membrana (ou bolsa) do sistema de preservação','', 4 )",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS( NOME,  DESCRICAO, CHAVE_MODO_FALHA ) VALUES ( 'Vazamento de água para o tanque principal','', 4 )",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS( NOME,  DESCRICAO, CHAVE_MODO_FALHA ) VALUES ( 'Desgaste das engrenagens das bombas do sistema de resfriamento','', 4 )",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS( NOME,  DESCRICAO, CHAVE_MODO_FALHA ) VALUES ( 'Desgastes dos contatos da chave seletora do comutador de derivações em carga','', 4 )",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS( NOME,  DESCRICAO, CHAVE_MODO_FALHA ) VALUES ( 'Vazamento de óleo do cilindro da chave desviadora do comutador de tape','', 4 )",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS( NOME,  DESCRICAO, CHAVE_MODO_FALHA ) VALUES ( 'Sobreaquecimento no sistema de isolação','', 5 )",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS( NOME,  DESCRICAO, CHAVE_MODO_FALHA ) VALUES ( 'Envelhecimento do óleo','', 5 )",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS( NOME,  DESCRICAO, CHAVE_MODO_FALHA ) VALUES ( 'Elevação do nível de gases no óleo','', 6 )",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS( NOME,  DESCRICAO, CHAVE_MODO_FALHA ) VALUES ( 'Sobreaquecimento do sistema de isolação','', 6 )",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS( NOME,  DESCRICAO, CHAVE_MODO_FALHA ) VALUES ( 'Contaminação do sistema de isolação (óleo e papel) por umidade, oxigênio e poluentes','', 6 )",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS( NOME,  DESCRICAO, CHAVE_MODO_FALHA ) VALUES ( 'Variações bruscas da pressão atmosférica','', 6 )",
				"INSERT INTO MAQUINAS.CAUSAS_POTENCIAIS( NOME,  DESCRICAO, CHAVE_MODO_FALHA ) VALUES ( 'Vibração do núcleo','', 7 )",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA( NOME,  CHAVE_CAUSA ) VALUES ( 'Operação em sobrecarga', 4)",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA( NOME,  CHAVE_CAUSA ) VALUES ( 'Elevadas Correntes de Curto-Circuito', 5 )",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA( NOME,  CHAVE_CAUSA ) VALUES ( 'Origem externa: descargas atomosféricas',  8 )",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA( NOME,  CHAVE_CAUSA ) VALUES ( 'Origem interna: faltas no sistema ou operações de manobra', 8 )",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA( NOME,  CHAVE_CAUSA ) VALUES ( 'Origem externa: descargas atomosféricas', 9)",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA( NOME,  CHAVE_CAUSA ) VALUES ( 'Origem interna: faltas no sistema ou operações de manobra',  9 )",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA( NOME,  CHAVE_CAUSA ) VALUES ( 'Causas Desconhecidas',  9 )",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA( NOME,  CHAVE_CAUSA ) VALUES ( 'Origem externa: descargas atomosféricas',  10 )",
				"INSERT INTO MAQUINAS.ORIGEM_CAUSA( NOME,  CHAVE_CAUSA ) VALUES ( 'Origem interna: faltas no sistema ou operações de manobra',  10 )"
		};

		return lista;
	}

	/**
	 * Cria o SCHEMA SAD4GM
	 * 
	 * @param con Conexão com o Banco de Dados.
	 * @throws SQLException Lança uma SQLException caso haja alguma falha na conexão
	 *                      com o Banco de Dados.
	 */
	private void criarSchema(Connection con) throws SQLException {
		PreparedStatement statement = con.prepareStatement("create SCHEMA sad4gm");
		PreparedStatement statement1 = con.prepareStatement("create SCHEMA maquinas");
		statement.execute();
		statement.close();
		statement1.execute();
		statement1.close();
	}

	/**
	 * Insere o Admin Default na Tabela de Usuário
	 * 
	 * @param con Conexão com o Banco de Dados.
	 * @throws UnsupportedEncodingException Lança uma UnsupportedEncodingException
	 *                                      caso haja falha na encriptação da Senha.
	 * 
	 * @throws Exception                    Lança uma Exception caso haja alguma
	 *                                      falha na inserção no Banco de Dados.
	 */
	private void inserirAdminDefault(Connection con) throws UnsupportedEncodingException, Exception {
		String senhaDefault = encriptarSenha("rootdesides");

		PreparedStatement statement = con.prepareStatement(
				"INSERT INTO sad4gm.usuario (admin,ativo,auditor,senha,id,nome) VALUES (1,1,'Default',?,'admin','Admin')");

		statement.setString(1, senhaDefault);
		statement.execute();
		statement.close();
	}

	/**
	 * Cria a Tabela de Usuários no Banco de Dados.
	 * 
	 * @param con Conexão com o Banco de Dados
	 * @throws SQLException Lança uma SQLException caso haja alguma falha na
	 *                      inserção no Banco de Dados.
	 */
	private void criarTabelaUsuarios(Connection con) throws SQLException {

		PreparedStatement statement = con
				.prepareStatement("CREATE TABLE sad4gm.usuario (\r\n" + "		nome LONG VARCHAR,\r\n"
						+ "		chave INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),\r\n"
						+ "		id VARCHAR(200) NOT NULL,\r\n" + "		senha VARCHAR(200),\r\n"
						+ "		auditor LONG VARCHAR,\r\n" + "		ativo INTEGER,\r\n"
						+ "		admin INTEGER DEFAULT 0,\r\n" + "		PRIMARY KEY (CHAVE))");

		statement.execute();
		statement.close();
	}

	/**
	 * Cria a Tabela de Máquinas no Banco de Dados.
	 * 
	 * @param con Conexão com o Banco de Dados
	 * @throws SQLException Lança uma SQLException caso haja alguma falha na
	 *                      inserção no Banco de Dados.
	 */
	private void criarTabelaMaquinas(Connection con) throws SQLException {

		PreparedStatement statement = con.prepareStatement("CREATE TABLE maquinas.maquina (\r\n"
				+ "					nome LONG VARCHAR,\r\n" + "					data_insercao DATE,\r\n"
				+ "					codigo INTEGER NOT NULL, \r\n" + "					descricao LONG VARCHAR, \r\n"
				+ "					chave_usuario INTEGER NOT NULL, \r\n"
				+ "					chave INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), \r\n"
				+ "				    PRIMARY KEY (chave), \r\n"
				+ "					CONSTRAINT maquina_chave_usuario_fkey \r\n"
				+ "					FOREIGN KEY (chave_usuario)  \r\n"
				+ "					REFERENCES sad4gm.usuario (chave) ON DELETE CASCADE )\r\n" + "					");

		statement.execute();
		statement.close();
	}

	private void criarTabelaSubsistema(Connection con) throws SQLException {

		PreparedStatement statement = con.prepareStatement("\r\n"
				+ "				CREATE TABLE maquinas.subsistema(\r\n" + "				nome LONG VARCHAR,\r\n"
				+ "				chave INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),\r\n"
				+ "				chave_maquina INTEGER NOT NULL,\r\n" + "				PRIMARY KEY (chave) ,\r\n"
				+ "				CONSTRAINT subsistema_chave_maquina_fkey FOREIGN KEY (chave_maquina) REFERENCES maquinas.maquina(chave) ON DELETE CASCADE \r\n"
				+ "				)");

		statement.execute();
		statement.close();
	}

	private void criarTabelaComponente(Connection con) throws SQLException {

		PreparedStatement statement = con.prepareStatement("CREATE TABLE maquinas.componente(\r\n"
				+ "nome LONG VARCHAR,\r\n"
				+ "chave INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),\r\n"
				+ "chave_subsistema INTEGER NOT NULL,\r\n" + "funcao LONG VARCHAR,\r\n" + "PRIMARY KEY (chave),"
				+ "CONSTRAINT componente_chave_subsistema_fkey FOREIGN KEY (chave_subsistema) REFERENCES maquinas.subsistema(chave) ON DELETE CASCADE\r\n"
				+ ")");

		statement.execute();
		statement.close();
	}

	private void criarTabelaFalha(Connection con) throws SQLException {

		PreparedStatement statement = con.prepareStatement("CREATE TABLE MAQUINAS.FALHA(\r\n"
				+ "				NOME LONG VARCHAR,\r\n" + "				DESCRICAO LONG VARCHAR,\r\n"
				+ "				CHAVE INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),\r\n"
				+ "				CHAVE_COMPONENTE INTEGER NOT NULL, \r\n" + "				PRIMARY KEY (CHAVE),\r\n"
				+ "				CONSTRAINT falha_chave_componente_fkey FOREIGN KEY (CHAVE_COMPONENTE) REFERENCES maquinas.componente(CHAVE) ON DELETE CASCADE)");

		statement.execute();
		statement.close();
	}

	private void criarTabelaModoFalha(Connection con) throws SQLException {

		PreparedStatement statement = con.prepareStatement("\r\n" + "CREATE TABLE MAQUINAS.MODO_FALHA(\r\n"
				+ "NOME LONG VARCHAR, \r\n" + "DESCRICAO LONG VARCHAR,\r\n"
				+ "CHAVE INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),\r\n"
				+ "CHAVE_FALHA INTEGER NOT NULL,\r\n" + "PRIMARY KEY(CHAVE),\r\n"
				+ "INDICE_OCORRENCIA DOUBLE PRECISION, \r\n" + "INDICE_DETECCAO DOUBLE PRECISION, \r\n"
				+ "NUMERO_OCORRENCIAS INTEGER, \r\n" 
				+ "CONSTRAINT modo_falha_chave_falha_fkey FOREIGN KEY (CHAVE_FALHA) REFERENCES MAQUINAS.FALHA(CHAVE) ON DELETE CASCADE\r\n"
				+ ")");

		statement.execute();
		statement.close();
	}

	private void criarTabelaCausasPotenciais(Connection con) throws SQLException {
		PreparedStatement statement = con.prepareStatement("CREATE TABLE MAQUINAS.CAUSAS_POTENCIAIS (\r\n"
				+ "						NOME LONG VARCHAR,\r\n"
				+ "						CHAVE INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),\r\n"
				+ "						DESCRICAO LONG VARCHAR, \r\n"
				+ "						CHAVE_MODO_FALHA INTEGER NOT NULL,\r\n"
				+ "						PRIMARY KEY (chave),\r\n"
				+ "						CONSTRAINT causas_potenciais_chave_modo_falha_fkey FOREIGN KEY (CHAVE_MODO_FALHA)\r\n"
				+ "						REFERENCES MAQUINAS.MODO_FALHA(CHAVE) ON DELETE CASCADE\r\n"
				+ "						)");

		statement.execute();
		statement.close();
	}

	private void criarTabelaOrigemCausas(Connection con) throws SQLException {
		PreparedStatement statement = con.prepareStatement("CREATE TABLE MAQUINAS.ORIGEM_CAUSA (\r\n"
				+ "						NOME LONG VARCHAR,\r\n"
				+ "						CHAVE INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),\r\n"
				+ "						CHAVE_CAUSA INTEGER NOT NULL,\r\n"
				+ "						PRIMARY KEY (chave),\r\n"
				+ "						CONSTRAINT causas_potenciais_chave_causa_fkey FOREIGN KEY (CHAVE_CAUSA)\r\n"
				+ "						REFERENCES MAQUINAS.CAUSAS_POTENCIAIS(CHAVE) ON DELETE CASCADE\r\n"
				+ "						)");

		statement.execute();
		statement.close();
	}

	private void criarTabelaAcoesRecomendadas(Connection con) throws SQLException {
		PreparedStatement statement = con.prepareStatement(
				"CREATE TABLE MAQUINAS.ACAO_RECOMENDADA(\r\n" + "NOME LONG VARCHAR,\r\n" + "DESCRICAO LONG VARCHAR,\r\n"
						+ "CHAVE INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),\r\n"
						+ "CHAVE_CAUSA_POTENCIAL INTEGER NOT NULL,\r\n" + "PRIMARY KEY (CHAVE),\r\n"
						+ "CONSTRAINT ACAO_RECOMENDADA_CAUSA_POTENCIAL_FKEY FOREIGN KEY (CHAVE_CAUSA_POTENCIAL) \r\n"
						+ "REFERENCES MAQUINAS.CAUSAS_POTENCIAIS(CHAVE) ON DELETE CASCADE\r\n" + ")");

		statement.execute();
		statement.close();
	}

	private void criarTabelaEfeitos(Connection con) throws SQLException {
		PreparedStatement statement = con.prepareStatement(
				"CREATE TABLE MAQUINAS.EFEITO(\r\n" + "NOME LONG VARCHAR,\r\n" + "DESCRICAO LONG VARCHAR,\r\n"
						+ "CHAVE INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),\r\n"
						+ "CHAVE_MODO_FALHA INTEGER NOT NULL,\r\n" + "INDICE_SEVERIDADE DOUBLE PRECISION, \r\n"
						+ "PRIMARY KEY (chave),\r\n"
						+ "CONSTRAINT efeitos_chave_modo_falha_fkey FOREIGN KEY (CHAVE_MODO_FALHA)\r\n"
						+ "REFERENCES MAQUINAS.MODO_FALHA(CHAVE) ON DELETE CASCADE\r\n" + ")");

		statement.execute();
		statement.close();
	}

	/**
	 * Criptografa uma Senha em SHA-2
	 * 
	 * @param senha Senha a ser encriptada
	 * @return Senha encriptada
	 * @throws UnsupportedEncodingException Lança a UnsupportedEncodingException
	 *                                      caso haja falha na encriptação
	 * @throws Exception                    Lança uma Exception caso haja problema
	 *                                      na instância da criptografia escolhida.
	 */
	public String encriptarSenha(String senha) throws UnsupportedEncodingException, Exception {
		MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
		byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));

		StringBuilder hexString = new StringBuilder();
		for (byte b : messageDigest) {
			hexString.append(String.format("%02X", 0xFF & b));
		}
		String hashPassword = hexString.toString();

		return hashPassword;
	}

	/**
	 * Fecha a Conexão com o Banco de Dados.
	 */
	protected void fecharConexao() {
		try {
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}