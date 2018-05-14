package databaseTools;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ModosFalhaTools extends DatabaseTools {

	public void inserir(String descricao, int chaveFalha) throws SQLException {
	

		try {

			final String INSERIR = "INSERT INTO maquinas.modo_falha (descricao,chave_falha) VALUES (?,?)";
			abrirConexao();

			PreparedStatement stmt = con.prepareStatement(INSERIR);

			stmt.setString(1, descricao);
			stmt.setInt(2, chaveFalha);
			stmt.execute();
			stmt.close();

			fecharConexao();

		} catch (Exception e) {
			throw new SQLException("Falha na Conexão com o Banco de Dados!");
		}

	}



	public Map<String, Integer> getMapaModosFalha() throws SQLException {
		abrirConexao();
		Map<String, Integer> subsistemas = new HashMap<>();

		PreparedStatement state = con.prepareStatement("SELECT descricao,chave FROM maquinas.modo_falha");
		ResultSet resSet = state.executeQuery();

		while (resSet.next()) {
			subsistemas.put(resSet.getString(1), resSet.getInt(2));
		}
		state.close();

		fecharConexao();

		return subsistemas;

	}
}
