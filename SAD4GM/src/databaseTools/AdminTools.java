
package databaseTools;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * Classe de Ferramentas de Conexão com a Tabela de Admins no Banco de Dados.
 * 
 * @author caiosbl
 *
 */

public class AdminTools extends DatabaseTools {

	/**
	 * Insere um Admin no Banco de Dados.
	 * 
	 * @param nome
	 *            Nome do Admin
	 * @param senha
	 *            Senha do Admin
	 * @param id
	 *            ID do Admin
	 * @throws SQLException
	 *             Lança uma SQLException caso haja falha na conexão com o Banco de
	 *             Dados.
	 * @throws RuntimeErrorException
	 *             Lança uma RuntimeErrorException caso o ID já esteja cadastrado.
	 * 
	 */
	public void inserir(String nome, String senha, String id) throws SQLException {

		if (hasAdmin(id))
			throw new RuntimeErrorException(null, "ID já cadastrado!");

		try {

			String encodingPassword = encriptarSenha(senha);

			final String INSERIR = "INSERT INTO sad4gm.admin (nome, senha,id) VALUES (?,?,?)";
			abrirConexao();
			PreparedStatement stmt = con.prepareStatement(INSERIR);
			stmt.setString(1, nome);
			stmt.setString(2, encodingPassword);
			stmt.setString(3, id);
			stmt.execute();
			stmt.close();
			fecharConexao();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Remove um Admin do Banco de Dados.
	 * 
	 * @param id
	 *            ID do Admin a ser Removido.
	 * @throws SQLException
	 *             Lança uma SQLException caso haja falha na conexão com o Banco de
	 *             Dados.
	 * @throws RuntimeErrorException
	 *             Lança uma RuntimeErrorException caso o Admin não esteja
	 *             cadastrado.
	 * 
	 */
	public void deletar(String id) throws SQLException {

		if (!hasAdmin(id))
			throw new RuntimeErrorException(null, "Administrador não cadastrado!");

		try {

			final String DELETE = "DELETE FROM sad4gm.admin where CAST(id AS VARCHAR(128)) = ?";
			abrirConexao();
			PreparedStatement stmt = con.prepareStatement(DELETE);
			stmt.setString(1, id);
			stmt.execute();
			stmt.close();
			fecharConexao();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Altera o nome de um Admin no Banco de Dados.
	 * 
	 * @param nome
	 *            Novo nome do Admin
	 * @param id
	 *            ID do Admin a ter nome alterado.
	 * @throws SQLException
	 *             Lança uma SQLException caso haja falha na conexão com o Banco de
	 *             Dados.
	 * @throws RuntimeErrorException
	 *             Lança uma RuntimeErrorException caso o ID não esteja cadastrado.
	 * 
	 */
	public void setName(String nome, String id) throws SQLException {

		if (!hasAdmin(id))
			throw new RuntimeErrorException(null, "Usuário inexistente!");

		try {

			final String UPDATE = "UPDATE  sad4gm.admin SET nome = ? WHERE CAST(id AS VARCHAR(128))= ?";
			abrirConexao();
			PreparedStatement stmt = con.prepareStatement(UPDATE);
			stmt.setString(1, nome);
			stmt.setString(2, id);
			stmt.execute();
			stmt.close();
			fecharConexao();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Altera o ID de um Admin
	 * 
	 * @param id
	 *            ID do Admin a ser Alterado.
	 * @param novoId
	 *            Novo ID do Admin.
	 * @throws SQLException
	 *             Lança uma SQLException caso haja falha na conexão com o Banco de
	 *             Dados.
	 * @throws RuntimeErrorException
	 *             Lança uma RuntimeErrorException caso o ID não esteja cadastrado.
	 */
	public void setId(String id, String novoId) throws SQLException {

		if (!hasAdmin(id))
			throw new RuntimeErrorException(null, "Admin inexistente!");

		try {

			final String UPDATE = "UPDATE  sad4gm.admin SET id = ? WHERE CAST(id AS VARCHAR(128))  = ?";
			abrirConexao();
			PreparedStatement stmt = con.prepareStatement(UPDATE);
			stmt.setString(1, novoId);
			stmt.setString(2, id);
			stmt.execute();
			stmt.close();
			fecharConexao();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Altera a Senha de um Admin
	 * 
	 * @param id
	 *            ID do Admin a ser Alterado.
	 * @param senha
	 *            Nova Senha do Admin
	 * @throws SQLException
	 *             Lança uma SQLException caso haja falha na conexão com o Banco de
	 *             Dados.
	 * @throws RuntimeErrorException
	 *             Lança uma RuntimeErrorException caso o ID não esteja cadastrado.
	 */
	public void setSenha(String id, String senha) throws SQLException {

		if (!hasAdmin(id))
			throw new RuntimeErrorException(null, "Admin inexistente!");

		try {

			String encodingPassword = encriptarSenha(senha);

			final String UPDATE = "UPDATE  sad4gm.admin SET senha = ? WHERE CAST(id AS VARCHAR(128)) = ?";
			abrirConexao();
			PreparedStatement stmt = con.prepareStatement(UPDATE);
			stmt.setString(1, encodingPassword);
			stmt.setString(2, id);
			stmt.execute();
			stmt.close();
			fecharConexao();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Retorna as Informações de um Admin
	 * 
	 * @param id
	 *            ID do Admin a ter Informações Retornadas.
	 * @return Informações do Admin
	 * @throws SQLException
	 *             Lança uma SQLException caso haja falha na conexão com o Banco de
	 *             Dados.
	 * @throws RuntimeErrorException
	 *             Lança uma RuntimeErrorException caso o ID não esteja cadastrado.
	 */
	public String getInfo(String id) throws SQLException {
		if (!hasAdmin(id))
			throw new RuntimeErrorException(null, "Admin inexistente!");

		String infoAdmin = "";
		String breakLine = System.lineSeparator();

		try {
			abrirConexao();
			PreparedStatement state = con
					.prepareStatement("SELECT  nome,id FROM sad4gm.admin WHERE CAST(id AS VARCHAR(128)) = ?");
			state.setString(1, id);

			ResultSet resSet = state.executeQuery();

			while (resSet.next()) {
				infoAdmin += "Nome: " + resSet.getString(1) + breakLine;
				infoAdmin += "Id: " + resSet.getString(2) + breakLine;
			}
			state.close();
			fecharConexao();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return infoAdmin;

	}

	/**
	 * Retorna o nome de um Admin
	 * 
	 * @param id
	 *            ID do Admin a ter nome retornado.
	 * @return Nome do Admin
	 * @throws SQLException
	 *             Lança uma SQLException caso haja falha na conexão com o Banco de
	 *             Dados.
	 * @throws RuntimeErrorException
	 *             Lança uma RuntimeErrorException caso o ID não esteja cadastrado.
	 */
	public String getNome(String id) throws SQLException {

		if (!hasAdmin(id))
			throw new RuntimeErrorException(null, "Admin inexistente!");

		String nome = "";

		try {
			abrirConexao();
			PreparedStatement state = con
					.prepareStatement("SELECT  nome FROM sad4gm.admin WHERE CAST(id AS VARCHAR(128)) = ?");
			state.setString(1, id);

			ResultSet resSet = state.executeQuery();

			while (resSet.next()) {
				nome = resSet.getString(1);
			}
			state.close();
			fecharConexao();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return nome;

	}

	/**
	 * Autentica o ID e Senha de um Admin, retorna um valor Booleano informando se
	 * as informações são válidas.
	 * 
	 * @param id
	 *            ID do Admin
	 * @param senha
	 *            Senha do Admin
	 * @return Status da Autenticação
	 * @throws SQLException
	 *             Lança uma SQLException caso haja falha de Conexão com o Banco de
	 *             Dados.
	 * 
	 */
	public boolean autenticar(String id, String senha) throws SQLException {

		boolean valido = false;

		if (!hasAdmin(id))
			return false;

		try {

			String encodingPassword = encriptarSenha(senha);
			abrirConexao();
			PreparedStatement state = con.prepareStatement(
					"SELECT id FROM sad4gm.admin WHERE CAST(id AS VARCHAR(128)) = ? AND CAST(senha AS VARCHAR(128)) =  ?");
			state.setString(1, id);
			state.setString(2, encodingPassword);

			ResultSet resSet = state.executeQuery();

			if (resSet.next())
				valido = true;

			state.close();
			fecharConexao();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return valido;

	}

	/**
	 * Verifica se há um Admin no Banco de Dados com o ID informado.
	 * 
	 * @param id
	 *            ID a ser verificado.
	 * @return Valor Booleano informando existência ou não de tal ID no Banco de
	 *         Dados.
	 * @throws SQLException
	 *             Lança uma SQLException caso haja falha na conexão com o Banco de
	 *             Dados.
	 * 
	 */
	public boolean hasAdmin(String id) throws SQLException {
		boolean has;
		abrirConexao();
		PreparedStatement state = con
				.prepareStatement("SELECT nome FROM sad4gm.admin WHERE CAST(id AS VARCHAR(128)) = ?");
		state.setString(1, id);
		ResultSet resSet = state.executeQuery();

		if (resSet.next())
			has = true;
		else
			has = false;
		state.close();
		fecharConexao();

		return has;

	}

	/**
	 * Retorna a Listagem dos Admins presentes no Banco de Dados.
	 * 
	 * @return Listagem de Admins.
	 */
	public String listAdmins() {
		String list = "";
		String breakLine = System.lineSeparator();

		try {
			abrirConexao();
			PreparedStatement state = con.prepareStatement("SELECT  nome,id FROM sad4gm.admin");

			ResultSet resSet = state.executeQuery();

			while (resSet.next()) {
				list += "----------------------------------------------------------------------------";
				list += breakLine + String.format("Nome: %s", resSet.getString(1)) + breakLine
						+ String.format("ID: %s", resSet.getString(2)) + breakLine;
			}
			state.close();
			fecharConexao();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}
