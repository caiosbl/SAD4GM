package bancoDeDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

import entidades.Usuario;

public class UsuarioTools extends DataBaseTools {

	public void inserir(Usuario usuario) throws SQLException {

		if (hasUsuario(usuario.getId()))
			throw new RuntimeErrorException(null, "ID já cadastrado!");

		try {

			final String INSERIR = "INSERT INTO sad4gm.usuario (nome, id, senha,auditor) VALUES (?,?,?,?)";
			criaConexao();
			PreparedStatement stmt = con.prepareStatement(INSERIR);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getId());
			stmt.setInt(3, usuario.getSenha());
			stmt.setString(4, usuario.getAuditor());
			stmt.execute();
			stmt.close();
			fechaConexao();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deletar(String id) throws SQLException {

		if (!hasUsuario(id))
			throw new RuntimeErrorException(null, "Usuário não cadastrado!");

		try {

			final String DELETE = "DELETE FROM sad4gm.usuario where id = ?";
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

		if (!hasUsuario(id))
			throw new RuntimeErrorException(null, "Usuário inexistente!");

		try {

			final String UPDATE = "UPDATE  sad4gm.usuario SET nome = ? WHERE id = ?";
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

		if (!hasUsuario(id))
			throw new RuntimeErrorException(null, "Usuário inexistente!");

		try {

			final String UPDATE = "UPDATE  sad4gm.usuario SET id = ? WHERE id = ?";
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

		if (!hasUsuario(id))
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

	public void setAuditor(String id, String auditor) throws SQLException {

		if (!hasUsuario(id))
			throw new RuntimeErrorException(null, "Usuário inexistente!");

		try {

			final String UPDATE = "UPDATE  sad4gm.usuario SET auditor = ? WHERE id = ?";
			criaConexao();
			PreparedStatement stmt = con.prepareStatement(UPDATE);
			stmt.setString(1, auditor);
			stmt.setString(2, id);
			stmt.execute();
			stmt.close();
			fechaConexao();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getInfo(String id) throws SQLException {

		if (!hasUsuario(id))
			throw new RuntimeErrorException(null, "Usuário inexistente!");

		String infoUsuario = "";
		String quebraLinha = System.lineSeparator();

		try {
			criaConexao();
			PreparedStatement state = con
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
	
	public String getNome(String id) throws SQLException {

		if (!hasUsuario(id))
			throw new RuntimeErrorException(null, "Usuário inexistente!");

		String nome = "";
	

		try {
			criaConexao();
			PreparedStatement state = con
					.prepareStatement("SELECT DISTINCT nome FROM sad4gm.usuario WHERE id = ?");
			state.setString(1, id);

			ResultSet resSet = state.executeQuery();

			while (resSet.next()) {
				nome =  resSet.getString(1) ;
			}
			state.close();
			fechaConexao();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return nome;

	}
	
	public String getNome(String id, Connection con) throws SQLException {
		if (!hasUsuario(id))
			return "Usuário Não Cadastrado";

		String descricao = "";
		String quebraLinha = System.lineSeparator();

		try {
			PreparedStatement state = con.prepareStatement("SELECT DISTINCT nome FROM sad4gm.usuario WHERE id = ?");
			state.setString(1, id);

			ResultSet resSet = state.executeQuery();

			if (resSet.next()) {
				descricao += String.format("Nome: %s - ID: %s", resSet.getString(1), id) + quebraLinha;

			}
			state.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return descricao;
	}
	
	public String getNomeAuditor(String id) throws SQLException {

		if (!hasUsuario(id))
			throw new RuntimeErrorException(null, "Usuário inexistente!");

		String auditor = "";
	

		try {
			criaConexao();
			PreparedStatement state = con
					.prepareStatement("SELECT DISTINCT auditor FROM sad4gm.usuario WHERE id = ?");
			state.setString(1, id);

			ResultSet resSet = state.executeQuery();

			while (resSet.next()) {
				auditor =  resSet.getString(1) ;
			}
			state.close();
			fechaConexao();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return auditor;

	}

	public boolean autenticador(String id, int senha) throws SQLException {
		boolean valido = false;

		if (!hasUsuario(id))
			return false;
		try {
			criaConexao();
			PreparedStatement state = con
					.prepareStatement("SELECT DISTINCT nome FROM sad4gm.usuario WHERE id = ? AND senha =  ?");
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

	public String listar() {
		String listagem = "";
		String quebraLinha = System.lineSeparator();

		try {
			criaConexao();
			PreparedStatement state = con.prepareStatement("SELECT nome,id,auditor FROM sad4gm.usuario");

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

	

	public boolean hasUsuario(String id) throws SQLException {
		boolean has;
		criaConexao();
		PreparedStatement state = con.prepareStatement("SELECT nome FROM sad4gm.usuario WHERE id = ?");
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
