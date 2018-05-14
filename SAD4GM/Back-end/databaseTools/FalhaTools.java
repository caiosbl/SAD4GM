package databaseTools;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class FalhaTools extends DatabaseTools {
	
	public void inserir(String nome, String descricao,  int chaveComponente) throws SQLException {
		
		if (hasFalha(nome)) throw new IllegalArgumentException("Este nome de Falha já está cadastrado!");

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

		PreparedStatement state = con.prepareStatement("SELECT nome FROM maquinas.falha WHERE CAST (nome AS VARCHAR(128)) = ?");
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
	
	public Map<String, Integer> getMapaFalhas() throws SQLException {
		abrirConexao();
		Map<String, Integer> subsistemas = new HashMap<>();

		PreparedStatement state = con.prepareStatement("SELECT nome,chave FROM maquinas.falha");
		ResultSet resSet = state.executeQuery();

		while (resSet.next()) {
			subsistemas.put(resSet.getString(1), resSet.getInt(2));
		}
		state.close();

		fecharConexao();

		return subsistemas;

	}


}
