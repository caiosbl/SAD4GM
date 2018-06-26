package databaseTools;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


import entidades.Subsistema;

public class SubsistemaTools extends DatabaseTools {

	public void inserir(String nome, int chaveMaquina) throws SQLException {

		if (hasSubsistema(nome))
			throw new IllegalArgumentException("Este nome de Subsistema já está cadastrado!");

		try {

			final String INSERIR = "INSERT INTO maquinas.subsistema (nome, chave_maquina) VALUES (?,?)";
			abrirConexao();

			PreparedStatement stmt = con.prepareStatement(INSERIR);

			stmt.setString(1, nome);
			stmt.setInt(2, chaveMaquina);
			stmt.execute();
			stmt.close();

			fecharConexao();

		} catch (Exception e) {
			throw new SQLException("Falha na Conexão com o Banco de Dados!");
		}

	}

	public boolean hasSubsistema(String nome) throws SQLException {
		boolean has;

		abrirConexao();

		PreparedStatement state = con
				.prepareStatement("SELECT nome FROM maquinas.subsistema WHERE CAST (nome AS VARCHAR(128)) = ?");
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

	public Map<String, Integer> getMapaSubsistemas(int chaveMaquina) throws SQLException {
		abrirConexao();
		Map<String, Integer> subsistemas = new HashMap<>();

		PreparedStatement state = con
				.prepareStatement("SELECT nome,chave FROM maquinas.subsistema WHERE chave_maquina=" + chaveMaquina);
		ResultSet resSet = state.executeQuery();

		while (resSet.next()) {
			subsistemas.put(resSet.getString(1), resSet.getInt(2));
		}
		state.close();

		fecharConexao();

		return subsistemas;

	}

	public Map<Integer, Subsistema> getSubsistemasMap(int chaveMaquina) throws SQLException {
		abrirConexao();

		Map<Integer, Subsistema> subsistemas = new HashMap<>();

		PreparedStatement state = con
				.prepareStatement("SELECT nome,chave FROM maquinas.subsistema  WHERE chave_maquina=" + chaveMaquina);
		ResultSet resSet = state.executeQuery();

		while (resSet.next()) {
			Subsistema subsistema = new Subsistema(resSet.getString(1), resSet.getInt(2));
			subsistemas.put(subsistema.getChave(), subsistema);
		}
		state.close();

		fecharConexao();

		return subsistemas;
	}

	public String getNomeSubsistema(int chaveSubsistema) throws SQLException {
		abrirConexao();
		String nome;
		PreparedStatement state = con
				.prepareStatement("SELECT nome FROM maquinas.subsistema WHERE chave=" + chaveSubsistema);
		ResultSet resSet = state.executeQuery();

		if (resSet.next())
			nome = resSet.getString(1);
		else
			nome = "Falha na Conexão com Banco de Dados";

		state.close();
		fecharConexao();

		return nome;

	}

	public void setNomeSubsistema(String nome, int chaveSubsistema) throws SQLException {
		abrirConexao();
		PreparedStatement state = con
				.prepareStatement("UPDATE  maquinas.subsistema SET nome = ? WHERE chave=" + chaveSubsistema);
		state.setString(1, nome);
		state.execute();
	}

	public void deletar(int chave) {
		try {

			final String DELETE = "DELETE FROM maquinas.subsistema where chave =" + chave;
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
