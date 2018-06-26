package controladores;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import databaseTools.ComponenteTools;
import entidades.Componente;

public class Componentes {
	
	private ComponenteTools cTools;
	
	public Componentes(ComponenteTools cTools) {
		this.cTools = cTools;
	}
	
	
	public String inserir(String nome, int chaveSubsistema, String funcao) {
		String status;
		
		try {
			cTools.inserir(nome, chaveSubsistema, funcao);
			status = "Componente inserido com Sucesso!";
		} 
		catch (Exception e) {
			status = e.getMessage();
		}
		
		return status;
		
	}
	
	public Map<String,Integer> getMapaComponentes(int chaveSubsistema)  {

		try {
			return cTools.getMapaComponentes(chaveSubsistema);
		} catch (SQLException e) {
			return new HashMap<String,Integer>();
		}

	}
	
	public Map<Integer,Componente> getComponentesMap(int chaveSubsistema){
		try {
			return cTools.getComponentesMap(chaveSubsistema);
		} catch (SQLException e) {
			return new HashMap<Integer,Componente>();
		}
	}
	
	public String getNomeComponente(int chaveComponente) {
		String nome;
		
		try {
			nome = cTools.getNomeComponente(chaveComponente);
		} catch (SQLException e) {
			e.printStackTrace();
			nome = "Falha na Conexão com Banco de Dados!";
		}
		return nome;
	}
	
	public String setNomeComponente(String nome, int chaveComponente) {
		String status;
		
		try {
			cTools.setNomeComponente(nome, chaveComponente);
			status = "Nome atualizado com Sucesso!";
		}
		catch (Exception e) {
			status = "Falha ao Atualizar Nome!";
		}
		
		return status;
	}
	
	public String getFuncaoComponente(int chaveComponente) {
		String funcao;
		
		try {
			funcao = cTools.getFuncaoComponente(chaveComponente);
		} catch (SQLException e) {
			e.printStackTrace();
			funcao = "Falha na Conexão com Banco de Dados!";
		}
		return funcao;
	}
	
	public String setFuncaoComponente(String funcao, int chaveComponente) {
		String status;
		
		try {
			cTools.setFuncaoComponente(funcao, chaveComponente);
			status = "Função atualizada com Sucesso!";
		}
		catch (Exception e) {
			status = "Falha ao Atualizar Função!";
		}
		
		return status;
	}

}
