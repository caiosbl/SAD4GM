package controladores;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import databaseTools.ComponenteTools;

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
	
	public Map<String,Integer> getMapaComponentes()  {

		try {
			return cTools.getMapaComponentes();
		} catch (SQLException e) {
			return new HashMap<String,Integer>();
		}

	}

}
