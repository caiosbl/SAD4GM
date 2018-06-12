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



	public Map<String, Integer> getMapaModosFalha(int chaveFalha) throws SQLException {
		abrirConexao();
		Map<String, Integer> subsistemas = new HashMap<>();

		PreparedStatement state = con.prepareStatement("SELECT descricao,chave FROM maquinas.modo_falha WHERE chave_falha=" + chaveFalha);
		ResultSet resSet = state.executeQuery();

		while (resSet.next()) {
			subsistemas.put(resSet.getString(1), resSet.getInt(2));
		}
		state.close();

		fecharConexao();

		return subsistemas;

	}
	
	public String getDescricaoModoFalha(int chaveModoFalha) throws SQLException {
		abrirConexao();
		String funcao;
		PreparedStatement state = con
				.prepareStatement("SELECT descricao FROM maquinas.modo_falha WHERE chave=" + chaveModoFalha);
		ResultSet resSet = state.executeQuery();
		

		if(resSet.next())
		funcao = resSet.getString(1);
		else
			funcao = "Falha na Conexão com Banco de Dados";
		

		state.close();
		fecharConexao();

		return funcao;

	}
	
	public void setDescricaoModoFalha(String descricao, int chaveModoFalha) throws SQLException {
		abrirConexao();
		PreparedStatement state = con.prepareStatement("UPDATE  maquinas.modo_falha SET descricao = ? WHERE chave=" + chaveModoFalha);
		state.setString(1, descricao);
		state.execute();
	}
}
