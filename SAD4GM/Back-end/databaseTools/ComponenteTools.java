package databaseTools;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import entidades.Componente;


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
	
	public Map<String, Integer> getMapaComponentes(int chaveSubsistema) throws SQLException {
		abrirConexao();
		Map<String, Integer> componentes = new HashMap<>();

		PreparedStatement state = con.prepareStatement("SELECT nome,chave FROM maquinas.componente WHERE chave_subsistema=" + chaveSubsistema);
		ResultSet resSet = state.executeQuery();

		while (resSet.next()) {
			componentes.put(resSet.getString(1), resSet.getInt(2));
		}
		state.close();

		fecharConexao();

		return componentes;

	}
	
	public String getNomeComponente(int chaveComponente) throws SQLException {
		abrirConexao();
		String nome;
		PreparedStatement state = con
				.prepareStatement("SELECT nome FROM maquinas.componente WHERE chave=" + chaveComponente);
		ResultSet resSet = state.executeQuery();
		

		if(resSet.next())
		nome = resSet.getString(1);
		else
			nome = "Falha na Conexão com Banco de Dados";
		

		state.close();
		fecharConexao();

		return nome;

	}
	
	public void setNomeComponente(String nome, int chaveComponente) throws SQLException {
		abrirConexao();
		PreparedStatement state = con.prepareStatement("UPDATE  maquinas.componente SET nome = ? WHERE chave=" + chaveComponente);
		state.setString(1, nome);
		state.execute();
	}
	
	public String getFuncaoComponente(int chaveComponente) throws SQLException {
		abrirConexao();
		String funcao;
		PreparedStatement state = con
				.prepareStatement("SELECT funcao FROM maquinas.componente WHERE chave=" + chaveComponente);
		ResultSet resSet = state.executeQuery();
		

		if(resSet.next())
		funcao = resSet.getString(1);
		else
			funcao = "Falha na Conexão com Banco de Dados";
		

		state.close();
		fecharConexao();

		return funcao;

	}
	
	public void setFuncaoComponente(String funcao, int chaveComponente) throws SQLException {
		abrirConexao();
		PreparedStatement state = con.prepareStatement("UPDATE  maquinas.componente SET funcao = ? WHERE chave=" + chaveComponente);
		state.setString(1, funcao);
		state.execute();
	}
	
	public Map<Integer, Componente> getComponentesMap(int chaveSubsistema) throws SQLException {
		abrirConexao();

		Map<Integer, Componente> componentes = new HashMap<>();

		PreparedStatement state = con
				.prepareStatement("SELECT nome,chave FROM maquinas.componente WHERE chave_subsistema=" + chaveSubsistema);
		ResultSet resSet = state.executeQuery();

		while (resSet.next()) {
			Componente componente = new Componente(resSet.getString(1), resSet.getInt(2));
			componentes.put(componente.getChave(), componente);
		}
		
		state.close();

		fecharConexao();

		return componentes;
	}

	public void deletar(int chave) throws SQLException {

		try {

			final String DELETE = "DELETE FROM maquinas.componente where chave =" + chave;
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
