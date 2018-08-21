package databaseTools;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import entidades.ModoFalha;

public class ModosFalhaTools extends DatabaseTools {

	public void inserir(String nome, String descricao, int chaveFalha) throws SQLException {

		try {

			final String INSERIR = "INSERT INTO maquinas.modo_falha (nome,descricao,chave_falha) VALUES (?,?,?)";
			abrirConexao();

			PreparedStatement stmt = con.prepareStatement(INSERIR);

			stmt.setString(1, nome);
			stmt.setString(2, descricao);
			stmt.setInt(3, chaveFalha);
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

	public void setDescricaoModoFalha(String descricao, int chaveModoFalha) throws SQLException {
		abrirConexao();
		PreparedStatement state = con
				.prepareStatement("UPDATE  maquinas.modo_falha SET descricao = ? WHERE chave=" + chaveModoFalha);
		state.setString(1, descricao);
		state.execute();
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
