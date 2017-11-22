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
			stmt.close();
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
			stmt.close();
			fechaConexao();

		} catch (Exception e) {
			e.printStackTrace();
		}

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
			stmt.close();
			fechaConexao();

		} catch (Exception e) {
			e.printStackTrace();
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
			stmt.close();
			fechaConexao();

		} catch (Exception e) {
			e.printStackTrace();
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
			stmt.close();
			fechaConexao();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getInfoUsuario(String id) throws SQLException {

		if (!hasUsuario(id))
			throw new RuntimeErrorException(null, "Usuário inexistente!");

		String infoUsuario = "";
		String quebraLinha = System.lineSeparator();

		try {
			criaConexao();
			PreparedStatement state = super.con
					.prepareStatement("SELECT DISTINCT nome,id,auditor FROM sad4gm.usuario WHERE id = ?");
			state.setString(1, id);

			ResultSet resSet = state.executeQuery();

			while (resSet.next()) {
				infoUsuario += "Nome: " + resSet.getString(1) + quebraLinha;
				infoUsuario += "Id: " + resSet.getString(2) + quebraLinha;
				infoUsuario += "Auditor: " + resSet.getString(3) + quebraLinha;
			}
			state.close();
			fechaConexao();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return infoUsuario;

	}

	public String listarUsuarios() {
		String listagem = "";
		String quebraLinha = System.lineSeparator();

		try {
			criaConexao();
			PreparedStatement state = super.con.prepareStatement("SELECT nome,id,auditor FROM sad4gm.usuario");

			ResultSet resSet = state.executeQuery();

			while (resSet.next()) {
				listagem += "Nome: " + resSet.getString(1) + quebraLinha;
				listagem += "Id: " + resSet.getString(2) + quebraLinha;
				listagem += "Auditor: " + resSet.getString(3) + quebraLinha;
				listagem += quebraLinha;
			}
			state.close();
			fechaConexao();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listagem;

	}

	private boolean hasUsuario(String id) throws SQLException {
		boolean has;
		criaConexao();
		PreparedStatement state = super.con.prepareStatement("SELECT nome FROM sad4gm.usuario WHERE id = ?");
		state.setString(1, id);
		ResultSet ResSet = state.executeQuery();

		if (ResSet.next())
			has = true;
		else
			has = false;
		state.close();
		fechaConexao();

		return has;

	}
}
