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
 * 
 * @author caiosbl
 *
 */

public class MachineTools extends DataBaseTools {
	private UserTools uTools;
	private String data = "dd/MM/yyyy";
	SimpleDateFormat formata = new SimpleDateFormat(data);

	public MachineTools() {
		uTools = new UserTools();
	}

	public void insert(Maquina maquina) throws SQLException {
		if (hasMaquina(maquina.getCodigo()))
			throw new RuntimeErrorException(null, "Código já cadastrado!");

		try {

			final String INSERIR = "INSERT INTO sad4gm.maquina (nome, codigo,descricao,idusuario,dataInsercao) VALUES (?,?,?,?,?)";
			openConnection();
			PreparedStatement stmt = con.prepareStatement(INSERIR);
			stmt.setString(1, maquina.getNome());
			stmt.setInt(2, maquina.getCodigo());
			stmt.setString(3, maquina.getDescricao());
			stmt.setString(4, maquina.getIdUsuario());
			stmt.setDate(5, java.sql.Date.valueOf(java.time.LocalDate.now()));
			stmt.execute();
			stmt.close();
			closeConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deletar(int codigo) throws SQLException {
		if (!hasMaquina(codigo))
			throw new RuntimeErrorException(null, "Máquina não cadastrada!");

		try {

			final String DELETE = "DELETE FROM sad4gm.maquina where codigo = ?";
			openConnection();
			PreparedStatement stmt = con.prepareStatement(DELETE);
			stmt.setInt(1, codigo);
			stmt.execute();
			stmt.close();
			closeConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getNome(int codigo) throws SQLException {
		if (!hasMaquina(codigo))
			throw new RuntimeErrorException(null, "Máquina inexistente!");

		String nome = "";

		try {
			openConnection();
			PreparedStatement state = con.prepareStatement("SELECT nome FROM sad4gm.maquina WHERE  codigo = ?");
			state.setInt(1, codigo);

			ResultSet resSet = state.executeQuery();

			if (resSet.next()) {
				nome += resSet.getString(1);
			}
			state.close();
			closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return nome;
	}

	public String getDescricao(int codigo) throws SQLException {
		if (!hasMaquina(codigo))
			throw new RuntimeErrorException(null, "Máquina inexistente!");

		String descricao = "";

		try {
			openConnection();
			PreparedStatement state = con.prepareStatement("SELECT descricao FROM sad4gm.maquina WHERE  codigo = ?");
			state.setInt(1, codigo);

			ResultSet resSet = state.executeQuery();

			if (resSet.next()) {
				descricao += resSet.getString(1);
			}
			state.close();
			closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return descricao;
	}

	public void setNome(int codigo, String nome) throws SQLException {
		if (!hasMaquina(codigo))
			throw new RuntimeErrorException(null, "Máquina inexistente!");

		try {

			final String UPDATE = "UPDATE  sad4gm.maquina SET nome = ? WHERE codigo = ?";
			openConnection();
			PreparedStatement stmt = con.prepareStatement(UPDATE);
			stmt.setString(1, nome);
			stmt.setInt(2, codigo);
			stmt.execute();
			stmt.close();
			closeConnection();

		} catch (Exception e) {
			throw new NullPointerException();
		}

	}

	public void setCodigo(int codigo, int novoCodigo) throws SQLException {
		if (!hasMaquina(codigo))
			throw new RuntimeErrorException(null, "Máquina inexistente!");

		try {

			final String UPDATE = "UPDATE  sad4gm.maquina SET codigo = ? WHERE codigo = ?";
			openConnection();
			PreparedStatement stmt = con.prepareStatement(UPDATE);
			stmt.setInt(1, novoCodigo);
			stmt.setInt(2, codigo);
			stmt.execute();
			stmt.close();
			closeConnection();

		} catch (Exception e) {
			throw new NullPointerException();
		}
	}

	public void setDescricao(int codigo, String descricao) throws SQLException {
		if (!hasMaquina(codigo))
			throw new RuntimeErrorException(null, "Máquina inexistente!");

		try {

			final String UPDATE = "UPDATE  sad4gm.maquina SET descricao = ? WHERE codigo = ?";
			openConnection();
			PreparedStatement stmt = con.prepareStatement(UPDATE);
			stmt.setString(1, descricao);
			stmt.setInt(2, codigo);
			stmt.execute();
			stmt.close();
			closeConnection();

		} catch (Exception e) {
			throw new NullPointerException();
		}

	}

	public String getInfo(int codigo) throws SQLException {
		if (!hasMaquina(codigo))
			throw new RuntimeErrorException(null, "Máquina inexistente!");

		String infoMaquina = "";
		String quebraLinha = System.lineSeparator();
		String idUsuario = null;
		Date dataInsercao = null;

		try {
			openConnection();
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

			closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return infoMaquina;

	}

	public String listar() {
		String listagem = "";
		String quebraLinha = System.lineSeparator();
		String idUsuario = null;
		Date dataInsercao = null;

		try {
			openConnection();
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
			closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listagem;

	}

	public boolean hasMaquina(int codigo) throws SQLException {
		boolean has;
		openConnection();
		PreparedStatement state = con.prepareStatement("SELECT nome FROM sad4gm.maquina WHERE codigo = ?");
		state.setInt(1, codigo);
		ResultSet ResSet = state.executeQuery();

		if (ResSet.next())
			has = true;
		else
			has = false;
		state.close();
		closeConnection();

		return has;
	}

}
