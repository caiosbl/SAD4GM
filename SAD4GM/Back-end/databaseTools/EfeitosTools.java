package databaseTools;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import entidades.CausaPotencial;

public class EfeitosTools extends DatabaseTools {

	public void inserir(String nome, String descricao, int chaveModoFalha) throws SQLException {

		try {

			final String INSERIR = "INSERT INTO maquinas.efeito (nome,descricao,chave_modo_falha) VALUES (?,?,?)";
			abrirConexao();

			PreparedStatement stmt = con.prepareStatement(INSERIR);

			stmt.setString(1, nome);
			stmt.setString(2, descricao);
			stmt.setInt(3, chaveModoFalha);
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

	public String getNomeCausaEfeito(int chaveEfeito) throws SQLException {
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

	public Map<Integer, CausaPotencial> getEfeitosMap(int chaveModoFalha) throws SQLException {
		abrirConexao();

		Map<Integer, CausaPotencial> efeitos = new HashMap<>();

		PreparedStatement state = con.prepareStatement(
				"SELECT nome,descricao,chave FROM maquinas.efeito WHERE chave_modo_falha =" + chaveModoFalha);
		ResultSet resSet = state.executeQuery();

		while (resSet.next()) {
			CausaPotencial causaPotencial = new CausaPotencial(resSet.getString(1), resSet.getString(2),
					resSet.getInt(3));
			efeitos.put(causaPotencial.getChave(), causaPotencial);
		}

		state.close();

		fecharConexao();

		return efeitos;
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
