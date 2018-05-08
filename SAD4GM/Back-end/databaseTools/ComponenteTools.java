package databaseTools;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ComponenteTools extends DatabaseTools {

	public void inserir(String nome, int chaveSubsistema, String funcao) throws SQLException {

		if (hasComponente(nome))
			throw new IllegalArgumentException("Este nome de Componente já está cadastrado!");

		try {

			final String INSERIR = "INSERT INTO maquinas.componente (nome, chave_subsistema,funcao) VALUES (?,?,?)";

			abrirConexao();

			PreparedStatement stmt = con.prepareStatement(INSERIR);

			stmt.setString(1, nome);
			stmt.setInt(2, chaveSubsistema);
			stmt.setString(3, funcao);
			stmt.execute();
			stmt.close();

			fecharConexao();

		} catch (Exception e) {
			throw new SQLException("Falha na Conexão com o Banco de Dados!");
		}

	}

	public boolean hasComponente(String nome) throws SQLException {
		boolean has;

		abrirConexao();

		PreparedStatement state = con
				.prepareStatement("SELECT nome FROM maquinas.componente WHERE CAST (nome AS VARCHAR(128)) = ?");
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

}
