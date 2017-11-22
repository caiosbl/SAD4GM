package bancoDeDados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

public class MaquinaTools extends DataBaseTools {

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

	public String getInfoMaquina(int codigo) throws SQLException {
		if (!hasMaquina(codigo))
			throw new RuntimeErrorException(null, "Máquina inexistente!");

		String infoMaquina = "";
		String quebraLinha = System.lineSeparator();

		try {
			criaConexao();
			PreparedStatement state = super.con
					.prepareStatement("SELECT DISTINCT nome,codigo,descricao FROM sad4gm.maquina WHERE codigo = ?");
			state.setInt(1, codigo);

			ResultSet resSet = state.executeQuery();

			while (resSet.next()) {
				infoMaquina += "Nome: " + resSet.getString(1) + quebraLinha;
				infoMaquina += "Código: " + resSet.getString(2) + quebraLinha;
				infoMaquina += "Descrição: " + resSet.getString(3) + quebraLinha;
				infoMaquina += quebraLinha;
			}

			fechaConexao();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return infoMaquina;

	}

	public String listarMaquinas() {
		String listagem = "";
		String quebraLinha = System.lineSeparator();

		try {
			criaConexao();
			PreparedStatement state = super.con.prepareStatement("SELECT nome,codigo,descricao FROM sad4gm.maquina");

			ResultSet resSet = state.executeQuery();

			while (resSet.next()) {
				listagem += "Nome: " + resSet.getString(1) + quebraLinha;
				listagem += "Código: " + resSet.getString(2) + quebraLinha;
				listagem += "Descrição: " + resSet.getString(3) + quebraLinha;
				listagem += quebraLinha;
			}

			fechaConexao();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listagem;

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