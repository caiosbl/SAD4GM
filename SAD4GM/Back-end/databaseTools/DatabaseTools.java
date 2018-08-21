package databaseTools;

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

		} catch (Exception e) {
			e.printStackTrace();
		}

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
				"INSERT INTO sad4gm.usuario (admin,ativo,auditor,senha,id,nome) VALUES (1,1,'Fernando',?,'admin','Caio')");

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
				+ "CONSTRAINT modo_falha_chave_falha_fkey FOREIGN KEY (CHAVE_FALHA) REFERENCES MAQUINAS.FALHA(CHAVE) ON DELETE CASCADE\r\n"
				+ ")");

		statement.execute();
		statement.close();
	}

	private void criarTabelaCausasPotenciais(Connection con) throws SQLException {
		PreparedStatement statement = con
				.prepareStatement("CREATE TABLE MAQUINAS.CAUSAS_POTENCIAIS (\r\n" + 
						"						NOME VARCHAR(80),\r\n" + 
						"						CHAVE INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),\r\n" + 
						"						DESCRICAO LONG VARCHAR, \r\n" + 
						"						CHAVE_MODO_FALHA INTEGER NOT NULL,\r\n" + 
						"						PRIMARY KEY (chave),\r\n" + 
						"						CONSTRAINT causas_potenciais_chave_modo_falha_fkey FOREIGN KEY (CHAVE_MODO_FALHA)\r\n" + 
						"						REFERENCES MAQUINAS.MODO_FALHA(CHAVE) ON DELETE CASCADE\r\n" + 
						"						);");

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