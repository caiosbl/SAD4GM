package databaseTools;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import entidades.Efeito;

public class EfeitosTools extends DatabaseTools {

	public void inserir(String nome, String descricao, int chaveModoFalha, double indiceSeveridade)
			throws SQLException {

		try {

			final String INSERIR = "INSERT INTO maquinas.efeito (nome,descricao,chave_modo_falha,indice_severidade) VALUES (?,?,?,?)";
			abrirConexao();

			PreparedStatement stmt = con.prepareStatement(INSERIR);

			stmt.setString(1, nome);
			stmt.setString(2, descricao);
			stmt.setInt(3, chaveModoFalha);
			stmt.setDouble(4, indiceSeveridade);
			stmt.execute();
			stmt.close();

			fecharConexao();

		} catch (Exception e) {
			throw new SQLException("Falha na Conexão com o Banco de Dados!");
		}

	}

	public Map<String, Integer> getMapaEfeitos(int chaveModoFalha) throws SQLException {
		abrirConexao();
		Map<String, Integer> subsistemas = new HashMap<>();

		PreparedStatement state = con.prepareStatement(
				"SELECT descricao,chave FROM maquinas.efeito WHERE chave_modo_falha=" + chaveModoFalha);
		ResultSet resSet = state.executeQuery();

		while (resSet.next()) {
			subsistemas.put(resSet.getString(1), resSet.getInt(2));
		}
		state.close();

		fecharConexao();

		return subsistemas;

	}

	public Map<Integer, Efeito> getEfeitosMap(int chaveModoFalha) throws SQLException {
		abrirConexao();

		Map<Integer, Efeito> efeitos = new HashMap<>();

		PreparedStatement state = con.prepareStatement(
				"SELECT nome,descricao,chave FROM maquinas.efeito WHERE chave_modo_falha =" + chaveModoFalha);
		ResultSet resSet = state.executeQuery();

		while (resSet.next()) {
			Efeito efeito = new Efeito(resSet.getString(1), resSet.getString(2), resSet.getInt(3));
			efeitos.put(efeito.getChave(), efeito);
		}

		state.close();

		fecharConexao();

		return efeitos;
	}

	public String getDescricaoEfeito(int chaveEfeito) throws SQLException {
		abrirConexao();
		String descricao;
		PreparedStatement state = con
				.prepareStatement("SELECT descricao FROM maquinas.efeito WHERE chave=" + chaveEfeito);
		ResultSet resSet = state.executeQuery();

		if (resSet.next())
			descricao = resSet.getString(1);
		else
			descricao = "Falha na Conexão com Banco de Dados";

		state.close();
		fecharConexao();

		return descricao;

	}

	public String getNomeEfeito(int chaveEfeito) throws SQLException {
		abrirConexao();
		String nome;
		PreparedStatement state = con.prepareStatement("SELECT nome FROM maquinas.efeito WHERE chave=" + chaveEfeito);
		ResultSet resSet = state.executeQuery();

		if (resSet.next())
			nome = resSet.getString(1);
		else
			nome = "Falha na Conexão com Banco de Dados";

		state.close();
		fecharConexao();

		return nome;

	}

	public double getIndiceSeveridade(int chaveEfeito) throws SQLException {
		abrirConexao();
		double indiceSeveridade;
		PreparedStatement state = con
				.prepareStatement("SELECT indice_severidade FROM maquinas.efeito WHERE chave=" + chaveEfeito);
		ResultSet resSet = state.executeQuery();

		if (resSet.next())
			indiceSeveridade = resSet.getDouble(1);
		else
			indiceSeveridade = -1;

		state.close();
		fecharConexao();

		return indiceSeveridade;

	}

	public double getIndiceSeveridadePorFalha(int chaveModoFalha) throws SQLException {
		abrirConexao();
		double indiceSeveridade;
		PreparedStatement state = con.prepareStatement(
				"SELECT indice_severidade FROM maquinas.efeito WHERE chave_modo_falha=" + chaveModoFalha);
		ResultSet resSet = state.executeQuery();

		if (resSet.next())
			indiceSeveridade = resSet.getDouble(1);
		else {

			indiceSeveridade = 0;
		}
		state.close();
		fecharConexao();
		return indiceSeveridade;
	}

	public void setNomeEfeito(String nome, int chaveEfeito) throws SQLException {
		abrirConexao();
		PreparedStatement state = con
				.prepareStatement("UPDATE  maquinas.efeito SET nome = ? WHERE chave=" + chaveEfeito);
		state.setString(1, nome);
		state.execute();
	}

	public void setDescricaoEfeito(String descricao, int chaveEfeito) throws SQLException {
		abrirConexao();
		PreparedStatement state = con
				.prepareStatement("UPDATE  maquinas.efeito SET descricao = ? WHERE chave=" + chaveEfeito);
		state.setString(1, descricao);
		state.execute();
	}

	public void setIndiceSeveridade(double indiceSeveridade, int chaveEfeito) throws SQLException {
		abrirConexao();
		PreparedStatement state = con
				.prepareStatement("UPDATE  maquinas.efeito SET indice_severidade = ? WHERE chave=" + chaveEfeito);
		state.setDouble(1, indiceSeveridade);
		state.execute();
	}

	public boolean hasEfeito(int chaveModoFalha) throws SQLException {
		abrirConexao();

		try {
			PreparedStatement state = con.prepareStatement("SELECT indice_severidade FROM maquinas.efeito WHERE chave_modo_falha=" + chaveModoFalha);
			ResultSet resSet = state.executeQuery();

			if (resSet.next()) {
				state.close();
				fecharConexao();
				return true;
			} else {
				state.close();
				fecharConexao();
				return false;
			}

		} catch (SQLException e) {
			throw new SQLException("Falha na Conexão com Banco de Dados!");
		}

	}

	public void deletar(int chave) throws SQLException {

		try {

			final String DELETE = "DELETE FROM maquinas.efeito where chave =" + chave;
			abrirConexao();
			PreparedStatement stmt = con.prepareStatement(DELETE);
			stmt.execute();
			stmt.close();
			fecharConexao();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
