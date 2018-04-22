package databaseTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

import entidades.Usuario;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * Classe de Ferramentas de Conexão com a Tabela de Usuários no Banco de Dados.
 * 
 * @author caiosbl
 *
 */

public class UsuarioTools extends DatabaseTools {

	/**
	 * Insere um Usuário no Banco de Dados
	 * 
	 * @param Usuário
	 *            a ser Inserido
	 * @throws SQLException
	 *             Lança uma SQLException em caso de falha na conexão com a Database
	 * @throws RuntimeErrorException
	 *             Lança uma RuntimeErrorException no caso em que o ID do usuário já
	 *             esteja cadastrado.
	 */
	public void inserir(Usuario usuario) throws SQLException {

		if (hasUsuario(usuario.getId()))
			throw new RuntimeErrorException(null, "ID já cadastrado!");

		try {

			String encodingPassword = encriptarSenha(usuario.getSenha());

			final String INSERIR = "INSERT INTO sad4gm.usuario (nome, id, senha,auditor,ativo) VALUES (?,?,?,?,?)";
			abrirConexao();
			PreparedStatement stmt = con.prepareStatement(INSERIR);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getId());
			stmt.setString(3, encodingPassword);
			stmt.setString(4, usuario.getAuditor());
			stmt.setInt(5, 1);
			stmt.execute();
			stmt.close();
			fecharConexao();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Define um Usuário no Banco de Dados como Inativo
	 * 
	 * @param id
	 *            ID do Usuário a se tornar inativo.
	 * @throws SQLException
	 *             Lança uma SQLException em caso de falha na conexão com a Database
	 * @throws RuntimeErrorException
	 *             Lança uma RuntimeErrorException caso o Usuário não esteja
	 *             cadastrado ou já esteja Inativo.
	 */
	public void deletar(String id) throws SQLException {

		if (!hasUsuario(id))
			throw new RuntimeErrorException(null, "Usuário não cadastrado!");
		else if (!isAtivo(id))
			throw new RuntimeErrorException(null, "Usuário inativo!");

		try {

			final String DELETE = "UPDATE sad4gm.usuario SET ativo = 0 where CAST(id AS VARCHAR(128)) = ?";
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
	 * Altera o nome de um usuário no Banco de Dados.
	 * 
	 * @param nome
	 *            Novo nome do Usuário.
	 * @param id
	 *            ID do Usuário a ser alterado.
	 * @throws SQLException
	 *             Lança uma SQLException em caso de falha na conexão com a Database
	 * @throws RuntimeErrorException
	 *             Lança uma RuntimeErrorException caso o Usuário não esteja
	 *             cadastrado ou já esteja Inativo.
	 * 
	 * 
	 */
	public void setNome(String nome, String id) throws SQLException {

		if (!hasUsuario(id))
			throw new RuntimeErrorException(null, "Usuário inexistente!");
		else if (!isAtivo(id))
			throw new RuntimeErrorException(null, "Usuário inativo!");

		try {

			final String UPDATE = "UPDATE  sad4gm.usuario SET nome = ? WHERE  CAST(id AS VARCHAR(128)) = ?";
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
	 * Altera o ID de um Usuário.
	 * 
	 * @param id
	 *            ID do Usuário a ser Alterado.
	 * @param novoId
	 *            Novo ID do Usuário.
	 * @throws SQLException
	 *             Lança uma SQLException em caso de falha na conexão com a Database
	 * @throws RuntimeErrorException
	 *             Lança uma RuntimeErrorException caso o Usuário não esteja
	 *             cadastrado ou já esteja Inativo.
	 */
	public void setId(String id, String novoId) throws SQLException {

		if (!hasUsuario(id))
			throw new RuntimeErrorException(null, "Usuário inexistente!");
		else if (!isAtivo(id))
			throw new RuntimeErrorException(null, "Usuário inativo!");

		try {

			final String UPDATE = "UPDATE  sad4gm.usuario SET id = ? WHERE  CAST(id AS VARCHAR(128)) = ?";
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
	 * Altera a Senha de um Usuário.
	 * 
	 * @param id
	 *            ID do Usuário a ser alterado.
	 * @param senha
	 *            Nova Senha do Usuário.
	 * @throws SQLException
	 *             Lança uma SQLException em caso de falha na conexão com a Database
	 * @throws RuntimeErrorException
	 *             Lança uma RuntimeErrorException caso o Usuário não esteja
	 *             cadastrado ou já esteja Inativo.
	 */
	public void setSenha(String id, String senha) throws SQLException {

		if (!hasUsuario(id))
			throw new RuntimeErrorException(null, "Usuário inexistente!");
		else if (!isAtivo(id))
			throw new RuntimeErrorException(null, "Usuário inativo!");

		try {

			String encodingPassword = encriptarSenha(senha);

			final String UPDATE = "UPDATE  sad4gm.usuario SET senha = ? WHERE  CAST(id AS VARCHAR(128)) = ?";
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
	 * Altera o Auditor de um Usuário.
	 * 
	 * @param id
	 *            ID do Usuário a ser alterado.
	 * @param auditor
	 *            Novo Auditor do Usuário.
	 * @throws SQLException
	 *             Lança uma SQLException em caso de falha na conexão com a Database
	 * @throws RuntimeErrorException
	 *             Lança uma RuntimeErrorException caso o Usuário não esteja
	 *             cadastrado ou já esteja Inativo.
	 */
	public void setAuditor(String id, String auditor) throws SQLException {

		if (!hasUsuario(id))
			throw new RuntimeErrorException(null, "Usuário inexistente!");
		else if (!isAtivo(id))
			throw new RuntimeErrorException(null, "Usuário inativo!");

		try {

			final String UPDATE = "UPDATE  sad4gm.usuario SET auditor = ? WHERE  CAST(id AS VARCHAR(128)) = ?";
			abrirConexao();
			PreparedStatement stmt = con.prepareStatement(UPDATE);
			stmt.setString(1, auditor);
			stmt.setString(2, id);
			stmt.execute();
			stmt.close();
			fecharConexao();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Retorna as Informações de um Usuário.
	 * 
	 * @param id
	 *            ID do Usuário a ter Informações retornadas.
	 * @return Informações
	 * @throws SQLException
	 *             Lança uma SQLException em caso de falha na conexão com a Database
	 * @throws RuntimeErrorException
	 *             Lança uma RuntimeErrorException caso o Usuário não esteja
	 *             cadastrado.
	 */
	public String getInfo(String id) throws SQLException {

		if (!hasUsuario(id))
			throw new RuntimeErrorException(null, "Usuário inexistente!");

		String infoUsuario = "";
		String quebraLinha = System.lineSeparator();

		try {
			abrirConexao();
			PreparedStatement state = con.prepareStatement(
					"SELECT  nome,id,auditor,ativo FROM sad4gm.usuario WHERE  CAST(id AS VARCHAR(128)) = ?");
			state.setString(1, id);

			ResultSet resSet = state.executeQuery();

			while (resSet.next()) {

				infoUsuario += "Nome: " + resSet.getString(1) + quebraLinha;
				infoUsuario += "ID: " + resSet.getString(2) + quebraLinha;
				infoUsuario += "Auditor: " + resSet.getString(3) + quebraLinha;
				if (resSet.getInt(4) == 1)
					infoUsuario += "Situação: Ativo" + quebraLinha;
				else
					infoUsuario += "Situação: Inativo" + quebraLinha;

			}
			state.close();
			fecharConexao();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return infoUsuario;

	}

	/**
	 * Retorna o nome de um Usuário.
	 * 
	 * @param id
	 *            ID do Usuário a ter nome retornado.
	 * @return Nome do Usuário.
	 * @throws SQLException
	 *             Lança uma SQLException em caso de falha na conexão com a Database
	 * @throws RuntimeErrorException
	 *             Lança uma RuntimeErrorException caso o Usuário não esteja
	 *             cadastrado .
	 */
	public String getNome(String id) throws SQLException {

		if (!hasUsuario(id))
			throw new RuntimeErrorException(null, "Usuário inexistente!");

		String nome = "";

		try {
			abrirConexao();
			PreparedStatement state = con
					.prepareStatement("SELECT  nome FROM sad4gm.usuario WHERE  CAST(id AS VARCHAR(128)) = ?");
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
	 * Retorna o Nome de um Usuário.
	 * 
	 * @param id
	 *            ID do Usuário a ter nome retornado.
	 * @param con
	 *            Conexão com o Banco de Dados.
	 * @return Nome do Usuário.
	 * @throws SQLException
	 *             Lança uma SQLException em caso de falha na conexão com a Database
	 * @throws RuntimeErrorException
	 *             Lança uma RuntimeErrorException caso o Usuário não esteja
	 *             cadastrado .
	 */
	public String getNome(int chave, Connection con) throws SQLException {
		if (!hasUsuario(chave))
			return "Usuário Não Cadastrado";

		String descricao = "";

		try {
			PreparedStatement state = con.prepareStatement("SELECT nome,id FROM sad4gm.usuario WHERE chave = ?");
			state.setInt(1, chave);

			ResultSet resSet = state.executeQuery();

			if (resSet.next())
				descricao += resSet.getString(1) + " - ID: " + resSet.getString(2);

			state.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return descricao;
	}

	/**
	 * Retorna o nome do Auditor de um Usuário.
	 * 
	 * @param id
	 *            ID do Usuário a ter nome retornado.
	 * @return Nome do Auditor.
	 * @throws SQLException
	 *             Lança uma SQLException em caso de falha na conexão com a Database
	 * @throws RuntimeErrorException
	 *             Lança uma RuntimeErrorException caso o Usuário não esteja
	 *             cadastrado .
	 */
	public String getNomeAuditor(String id) throws SQLException {

		if (!hasUsuario(id))
			throw new RuntimeErrorException(null, "Usuário inexistente!");

		String auditor = "";

		try {
			abrirConexao();
			PreparedStatement state = con
					.prepareStatement("SELECT  auditor FROM sad4gm.usuario WHERE  CAST(id AS VARCHAR(128)) = ?");
			state.setString(1, id);

			ResultSet resSet = state.executeQuery();

			while (resSet.next()) {
				auditor = resSet.getString(1);
			}
			state.close();
			fecharConexao();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return auditor;

	}

	/**
	 * Autentica o ID e Senha de um Usuário.
	 * 
	 * @param id
	 *            ID do Usuário a ser autenticado.
	 * @param senha
	 *            Senha do Usuário a ser autenticado.
	 * @return Valor booleano indicando se os dados são válidos.
	 * @throws SQLException
	 *             Lança uma SQLException em caso de falha na conexão com a Database
	 * 
	 */
	public boolean autenticador(String id, String senha) throws SQLException {
		boolean valido = false;

		if (!hasUsuario(id))
			return false;
		else if (!isAtivo(id))
			return false;
		try {

			String encodingPassword = encriptarSenha(senha);
			abrirConexao();
			PreparedStatement state = con.prepareStatement(
					"SELECT  nome FROM sad4gm.usuario WHERE  CAST(id AS VARCHAR(128)) = ? AND  CAST(senha AS VARCHAR(128)) =  ?");
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
	 * Retorna a listagem de Usuário cadastrados no Banco de Dados.
	 * 
	 * @return Listagem de Usuários.
	 */
	public String listar() {
		String listagem = "";
		String quebraLinha = System.lineSeparator();

		try {
			abrirConexao();
			PreparedStatement state = con
					.prepareStatement("SELECT nome,id,auditor FROM sad4gm.usuario WHERE ativo = 1");

			ResultSet resSet = state.executeQuery();

			while (resSet.next()) {
				listagem += "----------------------------------------------------------------------------";
				listagem += quebraLinha + String.format("Nome: %s", resSet.getString(1)) + quebraLinha
						+ String.format("ID: %s", resSet.getString(2)) + quebraLinha
						+ String.format("Auditor: %s", resSet.getString(3)) + quebraLinha;
			}
			state.close();
			fecharConexao();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listagem;
	}

	/**
	 * Verifica se há um usuário cadastrado no Banco de Dados.
	 * 
	 * @param id
	 *            ID do usuário a ser verificado.
	 * @return Valor Booleano indicando se há tal usuário.
	 * @throws SQLException
	 *             Lança uma SQLException em caso de falha na conexão com a Database
	 * 
	 */
	public boolean hasUsuario(String id) throws SQLException {
		boolean has;
		abrirConexao();
		PreparedStatement state = con
				.prepareStatement("SELECT nome FROM sad4gm.usuario WHERE  CAST(id AS VARCHAR(128)) = ?");
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

	public boolean hasUsuario(int chave) throws SQLException {
		boolean has;
		abrirConexao();
		PreparedStatement state = con.prepareStatement("SELECT nome FROM sad4gm.usuario WHERE CHAVE = ?");
		state.setInt(1, chave);
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
	 * Retorna um valor booleano indicando se um usuário está ativo.
	 * 
	 * @param id
	 *            ID do usuário a ser verificado.
	 * @return Valor Booleano indicando se o usuário está ativo.
	 * @throws SQLException
	 *             Lança uma SQLException em caso de falha na conexão com a Database
	 * 
	 */
	public boolean isAtivo(String id) throws SQLException {
		boolean has;
		abrirConexao();
		PreparedStatement state = con
				.prepareStatement("SELECT nome FROM sad4gm.usuario WHERE  CAST(id AS VARCHAR(128)) = ? AND ativo = 1");
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

	public int getChave(String id, Connection con) throws SQLException {

		PreparedStatement state = con
				.prepareStatement("SELECT chave FROM sad4gm.usuario WHERE  CAST(id AS VARCHAR(128)) = ?");
		state.setString(1, id);
		ResultSet resSet = state.executeQuery();

		int chave = -1;
		if (resSet.next())
			chave = resSet.getInt(1);

		state.close();
		fecharConexao();

		return chave;
	}
}
