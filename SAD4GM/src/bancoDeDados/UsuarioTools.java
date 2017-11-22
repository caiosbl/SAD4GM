package bancoDeDados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

public class UsuarioTools extends DataBaseTools {
	public void inserirUsuario(String nome, String id, int senha, String auditor) throws SQLException {

		if (hasUsuario(id))
			throw new RuntimeErrorException(null, "ID já cadastrado!");

		try {

			final String INSERIR = "INSERT INTO sad4gm.usuario (nome, id, senha,auditor) VALUES (?,?,?,?)";
			criaConexao();
			PreparedStatement stmt = super.con.prepareStatement(INSERIR);
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
			PreparedStatement stmt = super.con.prepareStatement(DELETE);
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
			PreparedStatement State = super.con
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
			PreparedStatement stmt = super.con.prepareStatement(UPDATE);
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
			PreparedStatement stmt = super.con.prepareStatement(UPDATE);
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
			PreparedStatement stmt = super.con.prepareStatement(UPDATE);
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
		PreparedStatement State = super.con.prepareStatement("SELECT nome FROM sad4gm.usuario WHERE id = ?");
		State.setString(1, id);
		ResultSet ResSet = State.executeQuery();

		if (ResSet.next())
			has = true;
		else
			has = false;
		fechaConexao();

		return has;

	}
}
