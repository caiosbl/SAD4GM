package databaseTools;

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

	protected void openConnection() throws SQLException {

		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con = DriverManager.getConnection("jdbc:derby:Sad4gmDatabase;");
		} catch (Exception e) {
			initDatabase();
		}
	}

	private void initDatabase() throws SQLException {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con = DriverManager.getConnection("jdbc:derby:Sad4gmDatabase; create = true");

			createSchema(con);
			createAdminTable(con);
			insertAdminDefault(con);
			createUserTable(con);
			createMachineTable(con);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void createSchema(Connection con) throws SQLException {
		PreparedStatement statament = con.prepareStatement("create SCHEMA sad4gm");
		statament.execute();
	}

	private void createAdminTable(Connection con) throws SQLException {
		PreparedStatement statement = con.prepareStatement("create table sad4gm.admin(\r\n" + "nome long VARCHAR,\r\n"
				+ "id long VARCHAR,\r\n" + "senha long VARCHAR\r\n" + ")");
		statement.execute();
	}

	private void insertAdminDefault(Connection con) throws UnsupportedEncodingException, Exception {
		String senhaDefault = encodePassword("rootdesides");

		PreparedStatement statement = con
				.prepareStatement("INSERT INTO sad4gm.admin (nome,senha,id) VALUES ('Desides Admin',?,'admin')");

		statement.setString(1, senhaDefault);
		statement.execute();
	}

	private void createUserTable(Connection con) throws SQLException {

		PreparedStatement statement = con.prepareStatement("create table sad4gm.usuario(\r\n" + "nome long VARCHAR,\r\n"
				+ "id long VARCHAR,\r\n" + "senha VARCHAR(200),\r\n" + "auditor long VARCHAR,\r\n" + "ativo INTEGER)");

		statement.execute();
	}

	private void createMachineTable(Connection con) throws SQLException {

		PreparedStatement statement = con.prepareStatement(
				"create table sad4gm.maquina(\r\n" + "nome long VARCHAR,\r\n" + "idusuario long VARCHAR,\r\n"
						+ "datainsercao date,\r\n" + "codigo INTEGER NOT NULL,\r\n" + "descricao long VARCHAR)");

		statement.execute();
	}

	// Criptografa as Senhas em SHA-2
	public String encodePassword(String password) throws UnsupportedEncodingException, Exception {
		MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
		byte messageDigest[] = algorithm.digest(password.getBytes("UTF-8"));

		StringBuilder hexString = new StringBuilder();
		for (byte b : messageDigest) {
			hexString.append(String.format("%02X", 0xFF & b));
		}
		String hashPassword = hexString.toString();

		return hashPassword;
	}

	protected void closeConnection() {
		try {
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}