package bancoDeDados;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;



public class DataBaseTools {

	private Connection con;

	private void criaConexao() {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con = DriverManager.getConnection("jdbc:derby:Sad4gmDatabase; create = true");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void fechaConexao() {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * private static boolean criaTabelas(Connection conn) { FileInputStream
	 * fileStream = null; try { fileStream = new
	 * FileInputStream("./scripts/create.sql"); int result = ij.runScript(conn,
	 * fileStream, "UTF-8", System.out, "UTF-8"); if (result == 1) { return true; }
	 * else { return false; } } catch (FileNotFoundException e) { return false; }
	 * catch (UnsupportedEncodingException e) { return false; } finally { if
	 * (fileStream != null) { try { fileStream.close(); } catch (IOException e) { }
	 * } } }
	 */

	public void inserirUsuario(String nome, String id, int senha, String auditor) throws SQLException {

		if (hasUsuario(id))
			throw new RuntimeErrorException(null, "ID já cadastrado!");

		try {

			final String INSERIR = "INSERT INTO sad4gm.usuario (nome, id, senha,auditor) VALUES (?,?,?,?)";
			criaConexao();
			PreparedStatement stmt = con.prepareStatement(INSERIR);
			stmt.setString(1, nome);
			stmt.setString(2, id);
			stmt.setInt(3, senha);
			stmt.setString(4, auditor);
			stmt.execute();
			fechaConexao();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deletarUsuario(String id) throws SQLException {

		if (!hasUsuario(id))
			throw new RuntimeErrorException(null, "Usuário não cadastrado!");

		try {

			final String DELETE = "DELETE FROM sad4gm.usuario where id = ?";
			criaConexao();
			PreparedStatement stmt = con.prepareStatement(DELETE);
			stmt.setString(1, id);
			stmt.execute();
			fechaConexao();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getInfoUsuario(String id) throws SQLException {

		if (!hasUsuario(id))
			throw new RuntimeErrorException(null, "Usuário inexistente!");

		String infoUsuario = "";

		try {
			criaConexao();
			PreparedStatement State = con
					.prepareStatement("SELECT DISTINCT nome,id,auditor FROM sad4gm.usuario WHERE id = 'sdsd'");

			ResultSet ResSet = State.executeQuery();

			while (ResSet.next()) {
				infoUsuario += ResSet.getString(1);
				infoUsuario += ResSet.getString(2);
				infoUsuario += ResSet.getString(3);
			}

			fechaConexao();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return infoUsuario;

	}

	public void setNomeUsuario(String nome, String id) throws SQLException {

		if (!hasUsuario(id))
			throw new RuntimeErrorException(null, "Usuário inexistente!");

		try {

			final String UPDATE = "UPDATE  sad4gm.usuario SET nome = ? WHERE id = ?";
			criaConexao();
			PreparedStatement stmt = con.prepareStatement(UPDATE);
			stmt.setString(1, nome);
			stmt.setString(2, id);
			stmt.execute();
			fechaConexao();

		} catch (Exception e) {
			throw new NullPointerException();
		}

	}

	public void setIdUsuario(String id, String novoId) throws SQLException {

		if (!hasUsuario(id))
			throw new RuntimeErrorException(null, "Usuário inexistente!");

		try {

			final String UPDATE = "UPDATE  sad4gm.usuario SET id = ? WHERE id = ?";
			criaConexao();
			PreparedStatement stmt = con.prepareStatement(UPDATE);
			stmt.setString(1, novoId);
			stmt.setString(2, id);
			stmt.execute();
			fechaConexao();

		} catch (Exception e) {
			throw new NullPointerException();
		}

	}

	public void setAuditorUsuario(String id, String auditor) throws SQLException {

		if (!hasUsuario(id))
			throw new RuntimeErrorException(null, "Usuário inexistente!");

		try {

			final String UPDATE = "UPDATE  sad4gm.usuario SET auditor = ? WHERE id = ?";
			criaConexao();
			PreparedStatement stmt = con.prepareStatement(UPDATE);
			stmt.setString(1, auditor);
			stmt.setString(2, id);
			stmt.execute();
			fechaConexao();

		} catch (Exception e) {
			throw new NullPointerException();
		}

	}

	private boolean hasUsuario(String id) throws SQLException {
		boolean has;
		criaConexao();
		PreparedStatement State = con.prepareStatement("SELECT nome FROM sad4gm.usuario WHERE id = ?");
		State.setString(1, id);
		ResultSet ResSet = State.executeQuery();

		if (ResSet.next())
			has = true;
		else
			has = false;
		fechaConexao();

		return has;

	}

	public void inserirMaquina(String nome, int codigo, String descricao) throws SQLException {
		if (hasMaquina(codigo))
			throw new RuntimeErrorException(null, "Código já cadastrado!");

		try {

			final String INSERIR = "INSERT INTO sad4gm.maquina (nome, codigo,descricao) VALUES (?,?,?)";
			criaConexao();
			PreparedStatement stmt = con.prepareStatement(INSERIR);
			stmt.setString(1, nome);
			stmt.setInt(2, codigo);
			stmt.setString(3, descricao);
			stmt.execute();
			fechaConexao();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deletarMaquina(int codigo) throws SQLException {
		if (!hasMaquina(codigo))
			throw new RuntimeErrorException(null, "Máquina não cadastrada!");

		try {

			final String DELETE = "DELETE FROM sad4gm.maquina where codigo = ?";
			criaConexao();
			PreparedStatement stmt = con.prepareStatement(DELETE);
			stmt.setInt(1, codigo);
			stmt.execute();
			fechaConexao();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void setNomeMaquina(int codigo, String nome) throws SQLException {
		if (!hasMaquina(codigo))
			throw new RuntimeErrorException(null, "Máquina inexistente!");

		try {

			final String UPDATE = "UPDATE  sad4gm.maquina SET nome = ? WHERE codigo = ?";
			criaConexao();
			PreparedStatement stmt = con.prepareStatement(UPDATE);
			stmt.setString(1, nome);
			stmt.setInt(2, codigo);
			stmt.execute();
			fechaConexao();

		} catch (Exception e) {
			throw new NullPointerException();
		}

	}

	public void setCodigoMaquina(int codigo, int novoCodigo) throws SQLException {
		if (!hasMaquina(codigo))
			throw new RuntimeErrorException(null, "Máquina inexistente!");

		try {

			final String UPDATE = "UPDATE  sad4gm.maquina SET codigo = ? WHERE codigo = ?";
			criaConexao();
			PreparedStatement stmt = con.prepareStatement(UPDATE);
			stmt.setInt(1, novoCodigo);
			stmt.setInt(2, codigo);
			stmt.execute();
			fechaConexao();

		} catch (Exception e) {
			throw new NullPointerException();
		}
	}

	public void setDescricaoMaquina(int codigo, String descricao) throws SQLException {
		if (!hasMaquina(codigo))
			throw new RuntimeErrorException(null, "Máquina inexistente!");

		try {

			final String UPDATE = "UPDATE  sad4gm.maquina SET descricao = ? WHERE codigo = ?";
			criaConexao();
			PreparedStatement stmt = con.prepareStatement(UPDATE);
			stmt.setString(1, descricao);
			stmt.setInt(2, codigo);
			stmt.execute();
			fechaConexao();

		} catch (Exception e) {
			throw new NullPointerException();
		}

	}

	private boolean hasMaquina(int codigo) throws SQLException {
		boolean has;
		criaConexao();
		PreparedStatement State = con.prepareStatement("SELECT nome FROM sad4gm.maquina WHERE codigo = ?");
		State.setInt(1, codigo);
		ResultSet ResSet = State.executeQuery();

		if (ResSet.next())
			has = true;
		else
			has = false;
		fechaConexao();

		return has;
	}

}