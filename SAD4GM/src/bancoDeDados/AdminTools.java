package bancoDeDados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

public class AdminTools extends DataBaseTools {

	public void inserirAdmin(String nome, int senha, String id) throws SQLException {

		if (hasAdmin(id))
			throw new RuntimeErrorException(null, "ID já cadastrado!");

		try {

			final String INSERIR = "INSERT INTO sad4gm.admin (nome, senha,id) VALUES (?,?,?)";
			criaConexao();
			PreparedStatement stmt = con.prepareStatement(INSERIR);
			stmt.setString(1, nome);
			stmt.setInt(2, senha);
			stmt.setString(3, id);
			stmt.execute();
			stmt.close();
			fechaConexao();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void setNomeAdmin(String nome, String id) throws SQLException {

		if (!hasAdmin(id))
			throw new RuntimeErrorException(null, "Usuário inexistente!");

		try {

			final String UPDATE = "UPDATE  sad4gm.admin SET nome = ? WHERE id = ?";
			criaConexao();
			PreparedStatement stmt = con.prepareStatement(UPDATE);
			stmt.setString(1, nome);
			stmt.setString(2, id);
			stmt.execute();
			stmt.close();
			fechaConexao();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void setIdAdmin(String id, String novoId) throws SQLException {

		if (!hasAdmin(id))
			throw new RuntimeErrorException(null, "Usuário inexistente!");

		try {

			final String UPDATE = "UPDATE  sad4gm.admin SET id = ? WHERE id = ?";
			criaConexao();
			PreparedStatement stmt = con.prepareStatement(UPDATE);
			stmt.setString(1, novoId);
			stmt.setString(2, id);
			stmt.execute();
			stmt.close();
			fechaConexao();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void setSenhaAdmin(String id, int senha) throws SQLException {

		if (!hasAdmin(id))
			throw new RuntimeErrorException(null, "Usuário inexistente!");

		try {

			final String UPDATE = "UPDATE  sad4gm.usuario SET senha = ? WHERE id = ?";
			criaConexao();
			PreparedStatement stmt = con.prepareStatement(UPDATE);
			stmt.setInt(1, senha);
			stmt.setString(2, id);
			stmt.execute();
			stmt.close();
			fechaConexao();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private boolean hasAdmin(String id) throws SQLException {
		boolean has;
		criaConexao();
		PreparedStatement state = con.prepareStatement("SELECT nome FROM sad4gm.admin WHERE id = ?");
		state.setString(1, id);
		ResultSet resSet = state.executeQuery();

		if (resSet.next())
			has = true;
		else
			has = false;
		state.close();
		fechaConexao();

		return has;

	}
}
