package databaseTools;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.management.RuntimeErrorException;

import entidades.Maquina;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * Classe de Ferramentas de Conexão com a Tabela de Máquinas no Banco de Dados.
 * 
 * @author caiosbl
 *
 */

public class MaquinaTools extends DatabaseTools {
	/**
	 * Instância da Classe de Ferramentas de conexão para usuários.
	 */
	private UsuarioTools uTools;
	/**
	 * Padrão de formatação da Data.
	 */
	private String data = "dd/MM/yyyy";
	SimpleDateFormat formata = new SimpleDateFormat(data);

	public MaquinaTools() {
		uTools = new UsuarioTools();
	}

	/**
	 * Insere uma Máquina no Banco de Dados
	 * 
	 * @param maquina
	 *            Máquina a ser Inserida
	 * @throws SQLException
	 *             Lança uma SQLException em caso de falha na conexão com a Database
	 * @throws RuntimeErrorException
	 *             Lança uma RuntimeErrorException no caso em que o código da
	 *             Máquina já esteja cadastrado.
	 */
	public void inserir(Maquina maquina) throws SQLException {

		if (hasMaquina(maquina.getCodigo()))
			throw new RuntimeErrorException(null, "Código já cadastrado!");

		try {

			final String INSERIR = "INSERT INTO sad4gm.maquina (nome, codigo,descricao,idusuario,dataInsercao) VALUES (?,?,?,?,?)";
			abrirConexao();

			PreparedStatement stmt = con.prepareStatement(INSERIR);
			stmt.setString(1, maquina.getNome());
			stmt.setInt(2, maquina.getCodigo());
			stmt.setString(3, maquina.getDescricao());
			stmt.setString(4, maquina.getIdUsuario());
			stmt.setDate(5, java.sql.Date.valueOf(java.time.LocalDate.now()));
			stmt.execute();
			stmt.close();

			fecharConexao();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Apaga uma Máquina do Banco de Dados.
	 * 
	 * @param codigo
	 *            Código da Máquina a ser Removida.
	 * @throws SQLException
	 *             Lança uma SQLException caso haja falha na conexão com Banco de
	 *             Dados.
	 * @throws RuntimeErrorException
	 *             Lança uma RuntimeErrorException caso a Máquina não esteja
	 *             cadastrada.
	 */
	public void deletar(int codigo) throws SQLException {
		if (!hasMaquina(codigo))
			throw new RuntimeErrorException(null, "Máquina não cadastrada!");

		try {

			final String DELETE = "DELETE FROM sad4gm.maquina where codigo = ?";
			abrirConexao();
			PreparedStatement stmt = con.prepareStatement(DELETE);
			stmt.setInt(1, codigo);
			stmt.execute();
			stmt.close();
			fecharConexao();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Retorna o nome de uma Máquina.
	 * 
	 * @param codigo
	 *            Código da Máquina a ter nome retornado.
	 * @return Nome da Máquina
	 * @throws SQLException
	 *             Lança uma SQLException caso haja falha na conexão com o Banco de
	 *             Dados.
	 * @throws RuntimeErrorException
	 *             Lança uma RuntimeErrorException caso a Máquina não esteja
	 *             cadastrada.
	 */
	public String getNome(int codigo) throws SQLException {
		if (!hasMaquina(codigo))
			throw new RuntimeErrorException(null, "Máquina inexistente!");

		String nome = "";

		try {
			abrirConexao();
			PreparedStatement state = con.prepareStatement("SELECT nome FROM sad4gm.maquina WHERE  codigo = ?");
			state.setInt(1, codigo);

			ResultSet resSet = state.executeQuery();

			if (resSet.next()) {
				nome += resSet.getString(1);
			}
			state.close();
			fecharConexao();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return nome;
	}

	/**
	 * Retorna a Descrição de uma Máquina.
	 * 
	 * @param codigo
	 *            Código da Máquina a ter Descrição Retornada.
	 * @return Descrição
	 * @throws SQLException
	 *             Lança uma SQLException caso haja falha na conexão com o Banco de
	 *             Dados.
	 * @throws RuntimeErrorException
	 *             Lança uma RuntimeErrorException caso a Máquina não esteja
	 *             cadastrada.
	 */
	public String getDescricao(int codigo) throws SQLException {
		if (!hasMaquina(codigo))
			throw new RuntimeErrorException(null, "Máquina inexistente!");

		String descricao = "";

		try {
			abrirConexao();
			PreparedStatement state = con.prepareStatement("SELECT descricao FROM sad4gm.maquina WHERE  codigo = ?");
			state.setInt(1, codigo);

			ResultSet resSet = state.executeQuery();

			if (resSet.next()) {
				descricao += resSet.getString(1);
			}
			state.close();
			fecharConexao();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return descricao;
	}

	/**
	 * Altera o nome de uma Máquina.
	 * 
	 * @param codigo
	 *            Código da Máquina a ter nome alterado.
	 * @param nome
	 *            Novo Nome da Máquina.
	 * @throws SQLException
	 *             Lança uma SQLException caso haja falha na conexão com o Banco de
	 *             Dados.
	 * @throws RuntimeErrorException
	 *             Lança uma RuntimeErrorException caso a Máquina não esteja
	 *             cadastrada.
	 */
	public void setNome(int codigo, String nome) throws SQLException {
		if (!hasMaquina(codigo))
			throw new RuntimeErrorException(null, "Máquina inexistente!");

		try {

			final String UPDATE = "UPDATE  sad4gm.maquina SET nome = ? WHERE codigo = ?";
			abrirConexao();
			PreparedStatement stmt = con.prepareStatement(UPDATE);
			stmt.setString(1, nome);
			stmt.setInt(2, codigo);
			stmt.execute();
			stmt.close();
			fecharConexao();

		} catch (Exception e) {
			throw new NullPointerException();
		}

	}

	/**
	 * Altera o Código de uma Máquina.
	 * 
	 * @param codigo
	 *            Código da Máquina a ser Alterada.
	 * @param novoCodigo
	 *            Novo Código da Máquina.
	 * @throws SQLException
	 *             Lança uma SQLException caso haja falha na Conexão com o Banco de
	 *             Dados.
	 * @throws RuntimeErrorException
	 *             Lança uma RuntimeErrorException caso a Máquina não esteja
	 *             cadastrada.
	 */
	public void setCodigo(int codigo, int novoCodigo) throws SQLException {
		if (!hasMaquina(codigo))
			throw new RuntimeErrorException(null, "Máquina inexistente!");

		try {

			final String UPDATE = "UPDATE  sad4gm.maquina SET codigo = ? WHERE codigo = ?";
			abrirConexao();
			PreparedStatement stmt = con.prepareStatement(UPDATE);
			stmt.setInt(1, novoCodigo);
			stmt.setInt(2, codigo);
			stmt.execute();
			stmt.close();
			fecharConexao();

		} catch (Exception e) {
			throw new NullPointerException();
		}
	}

	/**
	 * Altera a Descrição de uma Máquina.
	 * 
	 * @param codigo
	 *            Código da Máquina a ser Alterada.
	 * @param descricao
	 *            Nova Descrição da Máquina.
	 * @throws SQLException
	 *             Lança uma SQLException caso haja falha na conexão com o Banco de
	 *             Dados.
	 * @throws RuntimeErrorException
	 *             Lança uma RuntimeErrorException caso a Máquina não esteja
	 *             cadastrada.
	 */
	public void setDescricao(int codigo, String descricao) throws SQLException {
		if (!hasMaquina(codigo))
			throw new RuntimeErrorException(null, "Máquina inexistente!");

		try {

			final String UPDATE = "UPDATE  sad4gm.maquina SET descricao = ? WHERE codigo = ?";
			abrirConexao();
			PreparedStatement stmt = con.prepareStatement(UPDATE);
			stmt.setString(1, descricao);
			stmt.setInt(2, codigo);
			stmt.execute();
			stmt.close();
			fecharConexao();

		} catch (Exception e) {
			throw new NullPointerException();
		}

	}

	/**
	 * Retorna as Informações de uma Máquina
	 * 
	 * @param codigo
	 *            Código da Máquina a ter Informações Retornadas.
	 * @return Informações
	 * @throws SQLException
	 *             Lança uma SQLException caso haja falha na conexão com o Banco de
	 *             Dados.
	 * @throws RuntimeErrorException
	 *             Lança uma RuntimeErrorException caso a Máquina não esteja
	 *             cadastrada.
	 */
	public String getInfo(int codigo) throws SQLException {
		if (!hasMaquina(codigo))
			throw new RuntimeErrorException(null, "Máquina inexistente!");

		String infoMaquina = "";
		String quebraLinha = System.lineSeparator();
		String idUsuario = null;
		Date dataInsercao = null;

		try {
			abrirConexao();
			PreparedStatement state = con.prepareStatement(
					"SELECT  nome,codigo,descricao,idusuario,dataInsercao FROM sad4gm.maquina WHERE codigo = ?");
			state.setInt(1, codigo);

			ResultSet resSet = state.executeQuery();

			while (resSet.next()) {
				infoMaquina += "---------------------------------------------------------------------------"
						+ quebraLinha;
				infoMaquina += "Nome: " + resSet.getString(1) + quebraLinha;
				infoMaquina += "Código: " + resSet.getInt(2) + quebraLinha;
				infoMaquina += "Descrição: " + resSet.getString(3) + quebraLinha;
				idUsuario = resSet.getString(4);
				dataInsercao = resSet.getDate(5);

				String infoUsuarioCadastrou = uTools.getNome(idUsuario, con);
				infoMaquina += quebraLinha + "Cadastrada por: " + quebraLinha + infoUsuarioCadastrou;
				infoMaquina += "Cadastrada em: " + formata.format(dataInsercao);
				infoMaquina += quebraLinha;
			}
			state.close();

			fecharConexao();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return infoMaquina;

	}

	/**
	 * Retorna a Listagem de Máquinas Cadastradas.
	 * 
	 * @return Listagem de Máquinas
	 */
	public String listar() {
		String listagem = "";
		String quebraLinha = System.lineSeparator();
		String idUsuario = null;
		Date dataInsercao = null;

		try {
			abrirConexao();
			PreparedStatement state = con
					.prepareStatement("SELECT nome,codigo,descricao,idusuario,dataInsercao FROM sad4gm.maquina");

			ResultSet resSet = state.executeQuery();

			while (resSet.next()) {
				listagem += "---------------------------------------------------------------------------" + quebraLinha;
				listagem += "Nome: " + resSet.getString(1) + quebraLinha;
				listagem += "Código: " + resSet.getInt(2) + quebraLinha;
				listagem += "Descrição: " + resSet.getString(3) + quebraLinha;
				idUsuario = resSet.getString(4);
				dataInsercao = resSet.getDate(5);

				String infoUsuarioCadastrou = uTools.getNome(idUsuario, con);
				listagem += quebraLinha + "Cadastrada por: " + quebraLinha + infoUsuarioCadastrou;
				listagem += "Cadastrada em: " + formata.format(dataInsercao);
				listagem += quebraLinha;

			}
			state.close();
			fecharConexao();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listagem;

	}

	/**
	 * Retorna um Valor Booleano indicando se tal máquina está cadastrada no Banco
	 * de Dados.
	 * 
	 * @param codigo
	 *            Código da Máquina a ser verificada.
	 * @return Valor Booleano Indicando Presença da Máquina.
	 * @throws SQLException
	 *             Lança uma SQLException caso haja falha na conexão com o Banco de
	 *             Dados.
	 *
	 */
	public boolean hasMaquina(int codigo) throws SQLException {
		boolean has;
		abrirConexao();
		PreparedStatement state = con.prepareStatement("SELECT nome FROM sad4gm.maquina WHERE codigo = ?");
		state.setInt(1, codigo);
		ResultSet ResSet = state.executeQuery();

		if (ResSet.next())
			has = true;
		else
			has = false;
		state.close();
		fecharConexao();

		return has;
	}

}