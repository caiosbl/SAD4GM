package bancoDeDados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES 
 * SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */

public class AdminTools extends DataBaseTools {

	public void inserir(String nome, int senha, String id) throws SQLException {

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

	public void delete(String id) throws SQLException {

		if (!hasAdmin(id))
			throw new RuntimeErrorException(null, "Administrador não cadastrado!");

		try {

			final String DELETE = "DELETE FROM sad4gm.admin where CAST(id AS VARCHAR(128)) = ?";
			criaConexao();
			PreparedStatement stmt = con.prepareStatement(DELETE);
			stmt.setString(1, id);
			stmt.execute();
			stmt.close();
			fechaConexao();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void setNome(String nome, String id) throws SQLException {

		if (!hasAdmin(id))
			throw new RuntimeErrorException(null, "Usuário inexistente!");

		try {

			final String UPDATE = "UPDATE  sad4gm.admin SET nome = ? WHERE CAST(id AS VARCHAR(128))= ?";
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

	public void setId(String id, String novoId) throws SQLException {

		if (!hasAdmin(id))
			throw new RuntimeErrorException(null, "Usuário inexistente!");

		try {

			final String UPDATE = "UPDATE  sad4gm.admin SET id = ? WHERE CAST(id AS VARCHAR(128))  = ?";
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

	public void setSenha(String id, int senha) throws SQLException {

		if (!hasAdmin(id))
			throw new RuntimeErrorException(null, "Usuário inexistente!");

		try {

			final String UPDATE = "UPDATE  sad4gm.admin SET senha = ? WHERE CAST(id AS VARCHAR(128)) = ?";
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

	public String getInfo(String id) throws SQLException {
		if (!hasAdmin(id))
			throw new RuntimeErrorException(null, "Admin inexistente!");

		String infoAdmin = "";
		String quebraLinha = System.lineSeparator();

		try {
			criaConexao();
			PreparedStatement state = con.prepareStatement("SELECT  nome,id FROM sad4gm.admin WHERE CAST(id AS VARCHAR(128)) = ?");
			state.setString(1, id);

			ResultSet resSet = state.executeQuery();

			while (resSet.next()) {
				infoAdmin += "Nome: " + resSet.getString(1) + quebraLinha;
				infoAdmin += "Id: " + resSet.getString(2) + quebraLinha;
			}
			state.close();
			fechaConexao();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return infoAdmin;

	}

	public String getNome(String id) throws SQLException {

		if (!hasAdmin(id))
			throw new RuntimeErrorException(null, "Usuário inexistente!");

		String nome = "";

		try {
			criaConexao();
			PreparedStatement state = con.prepareStatement("SELECT  nome FROM sad4gm.admin WHERE CAST(id AS VARCHAR(128)) = ?");
			state.setString(1, id);

			ResultSet resSet = state.executeQuery();

			while (resSet.next()) {
				nome = resSet.getString(1);
			}
			state.close();
			fechaConexao();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return nome;

	}

	public boolean autentica(String id, int senha) throws SQLException {
		boolean valido = false;

		if (!hasAdmin(id))
			return false;
		try {
			criaConexao();
			PreparedStatement state = con
					.prepareStatement("SELECT  nome FROM sad4gm.admin WHERE CAST(id AS VARCHAR(128)) = ? AND senha =  ?");
			state.setString(1, id);
			state.setInt(2, senha);

			ResultSet resSet = state.executeQuery();

			if (resSet.next())
				valido = true;

			state.close();
			fechaConexao();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return valido;

	}

	public boolean hasAdmin(String id) throws SQLException {
		boolean has;
		criaConexao();
		PreparedStatement state = con.prepareStatement("SELECT nome FROM sad4gm.admin WHERE CAST(id AS VARCHAR(128)) = ?");
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

	public String listarAdmins() {
		String listagem = "";
		String quebraLinha = System.lineSeparator();

		try {
			criaConexao();
			PreparedStatement state = con.prepareStatement("SELECT  nome,id FROM sad4gm.admin");

			ResultSet resSet = state.executeQuery();

			while (resSet.next()) {
				listagem += "----------------------------------------------------------------------------";
				listagem += quebraLinha + String.format("Nome: %s", resSet.getString(1)) + quebraLinha
						+ String.format("ID: %s", resSet.getString(2)) + quebraLinha;
			}
			state.close();
			fechaConexao();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listagem;
	}
}
