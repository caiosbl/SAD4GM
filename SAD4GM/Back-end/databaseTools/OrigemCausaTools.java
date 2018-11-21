package databaseTools;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import entidades.Origem;

public class OrigemCausaTools extends DatabaseTools {

	public void inserir(String nome, int chaveCausaPotencial) throws SQLException {

		try {

			final String INSERIR = "INSERT INTO maquinas.origem_causa (nome,chave_causa) VALUES (?,?)";
			abrirConexao();

			PreparedStatement stmt = con.prepareStatement(INSERIR);

			stmt.setString(1, nome);
			stmt.setInt(2, chaveCausaPotencial);

			stmt.execute();
			stmt.close();

			fecharConexao();

		} catch (Exception e) {
			throw new SQLException("Falha na Conexão com o Banco de Dados!");
		}

	}

	public Map<String, Integer> getMapaOrigemCausas(int chaveCausaPotencial) throws SQLException {
		abrirConexao();
		Map<String, Integer> causasPotenciais = new HashMap<>();

		PreparedStatement state = con.prepareStatement(
				"SELECT nome,chave FROM maquinas.origem_causa WHERE chave_causa=" + chaveCausaPotencial);
		ResultSet resSet = state.executeQuery();

		while (resSet.next()) {
			causasPotenciais.put(resSet.getString(1), resSet.getInt(2));
		}
		state.close();

		fecharConexao();

		return causasPotenciais;

	}

	public String getNomeOrigemCausa(int chaveOrigem) throws SQLException {
		abrirConexao();
		String nome;
		PreparedStatement state = con
				.prepareStatement("SELECT nome FROM maquinas.origem_causa WHERE chave=" + chaveOrigem);
		ResultSet resSet = state.executeQuery();

		if (resSet.next())
			nome = resSet.getString(1);
		else
			nome = "Falha na Conexão com Banco de Dados";

		state.close();
		fecharConexao();

		return nome;

	}

	public void setNomeOrigem(String nome, int chaveOrigem) throws SQLException {
		abrirConexao();
		PreparedStatement state = con
				.prepareStatement("UPDATE  maquinas.origem_causa SET nome = ? WHERE chave=" + chaveOrigem);
		state.setString(1, nome);
		state.execute();
	}

	public Map<Integer, Origem> getCausasPotenciaisMap(int chaveCausaPotencial) throws SQLException {
		abrirConexao();

		Map<Integer, Origem> origens = new HashMap<>();

		PreparedStatement state = con.prepareStatement(
				"SELECT nome,chave FROM maquinas.origem_causa WHERE chave_causa =" + chaveCausaPotencial);
		ResultSet resSet = state.executeQuery();

		while (resSet.next()) {
			Origem origem = new Origem(resSet.getString(1), resSet.getInt(2), chaveCausaPotencial);

			origens.put(origem.getChave(), origem);
		}

		state.close();

		fecharConexao();

		return origens;
	}

	public void deletar(int chave) throws SQLException {

		try {

			final String DELETE = "DELETE FROM maquinas.origem_causa where chave =" + chave;
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
