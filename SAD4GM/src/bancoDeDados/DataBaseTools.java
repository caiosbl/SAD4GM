package bancoDeDados;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */

public abstract class DataBaseTools {

	protected Connection con;

	protected void criaConexao() throws SQLException {

		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con = DriverManager.getConnection("jdbc:derby:Sad4gmDatabase;");
		} catch (Exception e) {
			inicializaBancoDados();
		}
	}

	private void inicializaBancoDados() throws SQLException {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con = DriverManager.getConnection("jdbc:derby:Sad4gmDatabase; create = true");

			// Criando Schema
			PreparedStatement inicializa = con.prepareStatement("create SCHEMA sad4gm");

			// Criando Tabela Admin
			inicializa.execute();
			inicializa = con.prepareStatement("create table sad4gm.admin(\r\n" + "nome long VARCHAR,\r\n"
					+ "id long VARCHAR,\r\n" + "senha long VARCHAR\r\n" + ")");
			inicializa.execute();

			// Inserindo Admin Default
			inicializa = con.prepareStatement(
					"INSERT INTO sad4gm.admin (nome,senha,id) VALUES ('Desides Admin','rootdesides','admin')");
			inicializa.execute();

			// Criando Tabela Usuário
			inicializa = con.prepareStatement(
					"create table sad4gm.usuario(\r\n" + "nome long VARCHAR,\r\n" + "id long VARCHAR,\r\n"
							+ "senha VARCHAR(200),\r\n" + "auditor long VARCHAR,\r\n" + "ativo INTEGER)");

			inicializa.execute();

			// Criando Tabela Máquinas

			inicializa = con.prepareStatement("create table sad4gm.maquina(\r\n" + "nome VARCHAR(20) NOT NULL,\r\n"
					+ "codigo INTEGER NOT NULL,\r\n" + "descricao VARCHAR(20)NOT NULL)");

			inicializa.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String encodingPassword(String password) throws UnsupportedEncodingException, Exception {
		MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
		byte messageDigest[] = algorithm.digest(password.getBytes("UTF-8"));

		StringBuilder hexString = new StringBuilder();
		for (byte b : messageDigest) {
			hexString.append(String.format("%02X", 0xFF & b));
		}
		String hashPassword = hexString.toString();

		return hashPassword;
	}

	protected void fechaConexao() {
		try {
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}