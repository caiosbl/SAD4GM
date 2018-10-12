package databaseTools;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import entidades.ModoFalha;

public class ModosFalhaTools extends DatabaseTools {

	public void inserir(String nome, String descricao, int chaveFalha, double indiceOcorrencia, double indiceDeteccao ) throws SQLException {

		try {

			final String INSERIR = "INSERT INTO maquinas.modo_falha (nome,descricao,chave_falha,indice_ocorrencia,indice_deteccao) VALUES (?,?,?,?,?)";
			abrirConexao();

			PreparedStatement stmt = con.prepareStatement(INSERIR);

			stmt.setString(1, nome);
			stmt.setString(2, descricao);
			stmt.setInt(3, chaveFalha);
			stmt.setDouble(4, indiceOcorrencia);
			stmt.setDouble(5, indiceDeteccao);
			stmt.execute();
			stmt.close();

			fecharConexao();

		} catch (Exception e) {
			throw new SQLException("Falha na Conexão com o Banco de Dados!");
		}

	}

	public Map<String, Integer> getMapaModosFalha(int chaveFalha) throws SQLException {
		abrirConexao();
		Map<String, Integer> modosFalha = new HashMap<>();

		PreparedStatement state = con
				.prepareStatement("SELECT descricao,chave FROM maquinas.modo_falha WHERE chave_falha=" + chaveFalha);
		ResultSet resSet = state.executeQuery();

		while (resSet.next()) {
			modosFalha.put(resSet.getString(1), resSet.getInt(2));
		}
		state.close();

		fecharConexao();

		return modosFalha;

	}
	
	public double getIndiceOcorrencia(int chaveModoFalha) throws SQLException {
		abrirConexao();
		double indiceOcorrencia;
		PreparedStatement state = con
				.prepareStatement("SELECT indice_ocorrencia FROM maquinas.modo_falha WHERE chave=" + chaveModoFalha);
		ResultSet resSet = state.executeQuery();

		if (resSet.next())
			indiceOcorrencia = resSet.getDouble(1);
		else
			indiceOcorrencia = -1;

		state.close();
		fecharConexao();

		return indiceOcorrencia;

	}
	
	public double getIndiceDeteccao(int chaveModoFalha) throws SQLException {
		abrirConexao();
		double indiceDeteccao;
		PreparedStatement state = con
				.prepareStatement("SELECT indice_deteccao FROM maquinas.modo_falha WHERE chave=" + chaveModoFalha);
		ResultSet resSet = state.executeQuery();

		if (resSet.next())
			indiceDeteccao = resSet.getDouble(1);
		else
			indiceDeteccao = -1;

		state.close();
		fecharConexao();

		return indiceDeteccao;

	}
	

	public String getDescricaoModoFalha(int chaveModoFalha) throws SQLException {
		abrirConexao();
		String descricao;
		PreparedStatement state = con
				.prepareStatement("SELECT descricao FROM maquinas.modo_falha WHERE chave=" + chaveModoFalha);
		ResultSet resSet = state.executeQuery();

		if (resSet.next())
			descricao = resSet.getString(1);
		else
			descricao = "Falha na Conexão com Banco de Dados";

		state.close();
		fecharConexao();

		return descricao;

	}

	public String getNomeModoFalha(int chaveModoFalha) throws SQLException {
		abrirConexao();
		String nome;
		PreparedStatement state = con
				.prepareStatement("SELECT nome FROM maquinas.modo_falha WHERE chave=" + chaveModoFalha);
		ResultSet resSet = state.executeQuery();

		if (resSet.next())
			nome = resSet.getString(1);
		else
			nome = "Falha na Conexão com Banco de Dados";

		state.close();
		fecharConexao();

		return nome;

	}
	
	public Map<Integer, ModoFalha> getModosFalhaMap(int chaveFalha) throws SQLException {
		abrirConexao();

		Map<Integer, ModoFalha> modosFalha = new HashMap<>();

		PreparedStatement state = con.prepareStatement(
				"SELECT nome,descricao,chave FROM maquinas.modo_falha WHERE chave_falha =" + chaveFalha);
		ResultSet resSet = state.executeQuery();

		while (resSet.next()) {
			ModoFalha falha = new ModoFalha(resSet.getString(1), resSet.getString(2), resSet.getInt(3));
			modosFalha.put(falha.getChave(), falha);
		}

		state.close();

		fecharConexao();

		return modosFalha;
	}
	

	public void setDescricaoModoFalha(String descricao, int chaveModoFalha) throws SQLException {
		abrirConexao();
		PreparedStatement state = con
				.prepareStatement("UPDATE  maquinas.modo_falha SET descricao = ? WHERE chave=" + chaveModoFalha);
		state.setString(1, descricao);
		state.execute();
	}
	
	public void setNomeModoFalha(String nome, int chaveModoFalha) throws SQLException {
		abrirConexao();
		PreparedStatement state = con
				.prepareStatement("UPDATE  maquinas.modo_falha SET nome = ? WHERE chave=" + chaveModoFalha);
		state.setString(1, nome);
		state.execute();

	}
	
	public void setIndiceOcorrencia(double indiceOcorrencia, int chaveModoFalha) throws SQLException {
		abrirConexao();
		PreparedStatement state = con
				.prepareStatement("UPDATE  maquinas.modo_falha SET indice_ocorrencia = ? WHERE chave=" + chaveModoFalha);
		state.setDouble(1, indiceOcorrencia);
		state.execute();

	}
	
	public void setIndiceDeteccao(double indiceDeteccao, int chaveModoFalha) throws SQLException {
		abrirConexao();
		PreparedStatement state = con
				.prepareStatement("UPDATE  maquinas.modo_falha SET indice_deteccao = ? WHERE chave=" + chaveModoFalha);
		state.setDouble(1, indiceDeteccao);
		state.execute();

	}



	public void deletar(int chave) throws SQLException {

		try {

			final String DELETE = "DELETE FROM maquinas.modo_falha where chave =" + chave;
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
