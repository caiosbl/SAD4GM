package databaseTools;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import entidades.Falha;

public class FalhaTools extends DatabaseTools {

	public void inserir(String nome, String descricao, int chaveComponente) throws SQLException {

		if (hasFalha(nome))
			throw new IllegalArgumentException("Este nome de Falha já está cadastrado!");

		try {

			final String INSERIR = "INSERT INTO maquinas.falha (nome,descricao,chave_componente) VALUES (?,?,?)";
			abrirConexao();

			PreparedStatement stmt = con.prepareStatement(INSERIR);

			stmt.setString(1, nome);
			stmt.setString(2, descricao);
			stmt.setInt(3, chaveComponente);
			stmt.execute();
			stmt.close();

			fecharConexao();

		} catch (Exception e) {
			throw new SQLException("Falha na Conexão com o Banco de Dados!");
		}

	}

	public boolean hasFalha(String nome) throws SQLException {
		boolean has;

		abrirConexao();

		PreparedStatement state = con
				.prepareStatement("SELECT nome FROM maquinas.falha WHERE CAST (nome AS VARCHAR(128)) = ?");
		state.setString(1, nome);
		ResultSet ResSet = state.executeQuery();

		if (ResSet.next())
			has = true;
		else
			has = false;
		state.close();
		fecharConexao();

		return has;
	}

	public Map<String, Integer> getMapaFalhas(int chaveComponente) throws SQLException {
		abrirConexao();
		Map<String, Integer> falhas = new HashMap<>();

		PreparedStatement state = con
				.prepareStatement("SELECT nome,chave FROM maquinas.falha WHERE chave_componente=" + chaveComponente);
		ResultSet resSet = state.executeQuery();

		while (resSet.next()) {
			falhas.put(resSet.getString(1), resSet.getInt(2));
		}
		state.close();

		fecharConexao();

		return falhas;

	}

	public String getDescricaoFalha(int chaveFalha) throws SQLException {
		abrirConexao();
		String funcao;
		PreparedStatement state = con
				.prepareStatement("SELECT descricao FROM maquinas.falha WHERE chave=" + chaveFalha);
		ResultSet resSet = state.executeQuery();

		if (resSet.next())
			funcao = resSet.getString(1);
		else
			funcao = "Falha na Conexão com Banco de Dados";

		state.close();
		fecharConexao();

		return funcao;

	}

	public void setDescricaoFalha(String descricao, int chaveFalha) throws SQLException {
		abrirConexao();
		PreparedStatement state = con
				.prepareStatement("UPDATE  maquinas.falha SET descricao = ? WHERE chave=" + chaveFalha);
		state.setString(1, descricao);
		state.execute();
	}

	public String getNomeFalha(int chaveFalha) throws SQLException {
		abrirConexao();
		String funcao;
		PreparedStatement state = con.prepareStatement("SELECT nome FROM maquinas.falha WHERE chave=" + chaveFalha);
		ResultSet resSet = state.executeQuery();

		if (resSet.next())
			funcao = resSet.getString(1);
		else
			funcao = "Falha na Conexão com Banco de Dados";

		state.close();
		fecharConexao();

		return funcao;

	}

	public void setNomeFalha(String nome, int chaveFalha) throws SQLException {
		abrirConexao();
		PreparedStatement state = con.prepareStatement("UPDATE  maquinas.falha SET nome = ? WHERE chave=" + chaveFalha);
		state.setString(1, nome);
		state.execute();
	}

	public Map<Integer, Falha> getFalhasMap(int chaveComponente) throws SQLException {
		abrirConexao();

		Map<Integer, Falha> falhas = new HashMap<>();

		PreparedStatement state = con
				.prepareStatement("SELECT nome,chave FROM maquinas.falha WHERE chave_componente=" + chaveComponente);
		ResultSet resSet = state.executeQuery();

		while (resSet.next()) {
			Falha falha = new Falha(resSet.getString(1), resSet.getInt(2));
			falhas.put(falha.getChave(), falha);
		}

		state.close();

		fecharConexao();

		return falhas;
	}

}
