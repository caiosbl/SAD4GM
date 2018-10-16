package databaseTools;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import entidades.AcaoRecomendada;



public class AcaoRecomendadaTools extends DatabaseTools {

	public void inserir(String nome, String descricao, int chaveCausaPotencial) throws SQLException {

		try {

			final String INSERIR = "INSERT INTO maquinas.acao_recomendada (nome,descricao,chave_causa_potencial) VALUES (?,?,?)";
			abrirConexao();

			PreparedStatement stmt = con.prepareStatement(INSERIR);

			stmt.setString(1, nome);
			stmt.setString(2, descricao);
			stmt.setInt(3, chaveCausaPotencial);
			stmt.execute();
			stmt.close();

			fecharConexao();

		} catch (Exception e) {
			throw new SQLException("Falha na Conexão com o Banco de Dados!");
		}

	}


	public Map<String, Integer> getMapaAcoesRecomendadas(int chaveCausaPotencial) throws SQLException {
		abrirConexao();
		Map<String, Integer> acoesRecomendadas = new HashMap<>();

		PreparedStatement state = con.prepareStatement(
				"SELECT descricao,chave FROM maquinas.acao_recomendada WHERE chave_causa_potencial=" + chaveCausaPotencial);
		ResultSet resSet = state.executeQuery();

		while (resSet.next()) {
			acoesRecomendadas.put(resSet.getString(1), resSet.getInt(2));
		}
		state.close();

		fecharConexao();

		return acoesRecomendadas;

	}
	

	public Map<Integer, AcaoRecomendada> getAcoesRecomendadasMap(int chaveCausaPotencial) throws SQLException {
		abrirConexao();

		Map<Integer, AcaoRecomendada> acoesRecomendadas = new HashMap<>();

		PreparedStatement state = con
				.prepareStatement("SELECT nome,descricao,chave FROM maquinas.acao_recomendada WHERE chave_causa_potencial ="
						+ chaveCausaPotencial);
		ResultSet resSet = state.executeQuery();

		while (resSet.next()) {
			AcaoRecomendada acaoRecomendada = new AcaoRecomendada(resSet.getString(1), resSet.getString(2),
					resSet.getInt(3));
			acoesRecomendadas.put(acaoRecomendada.getChave(), acaoRecomendada);
		}

		state.close();

		fecharConexao();

		return acoesRecomendadas;
	}

	public String getDescricao(int chaveAcaoRecomendada) throws SQLException {
		abrirConexao();
		String descricao;
		PreparedStatement state = con.prepareStatement(
				"SELECT descricao FROM maquinas.acao_recomendada WHERE chave=" + chaveAcaoRecomendada);
		ResultSet resSet = state.executeQuery();

		if (resSet.next())
			descricao = resSet.getString(1);
		else
			descricao = "Falha na Conexão com Banco de Dados";

		state.close();
		fecharConexao();

		return descricao;

	}

	public String getNome(int chaveAcaoRecomendada) throws SQLException {
		abrirConexao();
		String nome;
		PreparedStatement state = con
				.prepareStatement("SELECT nome FROM maquinas.acao_recomendada WHERE chave=" + chaveAcaoRecomendada);
		ResultSet resSet = state.executeQuery();

		if (resSet.next())
			nome = resSet.getString(1);
		else
			nome = "Falha na Conexão com Banco de Dados";

		state.close();
		fecharConexao();

		return nome;

	}
	
	public void setNome(String nome, int chaveAcaoRecomendada) throws SQLException {
		abrirConexao();
		PreparedStatement state = con.prepareStatement(
				"UPDATE maquinas.acao_recomendada SET nome = ? WHERE chave=" + chaveAcaoRecomendada);
		state.setString(1, nome);
		state.execute();
	}

	public void setDescricao(String descricao, int chaveAcaoRecomendada) throws SQLException {
		abrirConexao();
		PreparedStatement state = con.prepareStatement(
				"UPDATE  maquinas.acao_recomendada SET descricao = ? WHERE chave=" + chaveAcaoRecomendada);
		state.setString(1, descricao);
		state.execute();
	}


	public void deletar(int chave) throws SQLException {

		try {

			final String DELETE = "DELETE FROM maquinas.acao_recomendada where chave =" + chave;
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
