package controladores;



import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import databaseTools.SubsistemaTools;

public class Subsistemas {
	
	private SubsistemaTools sTools;
	
	
	public Subsistemas(SubsistemaTools sTools) {
		this.sTools = sTools;
	}
	
	
	
	
	public String inserir(String nome, int chaveMaquina) {
		String status;
		
		try {
			sTools.inserir(nome, chaveMaquina);
			status = "Subsistema inserido com Sucesso!";
		} 
		catch (Exception e) {
			status = e.getMessage();
		}
		
		return status;
		
	}
	
	public Map<String,Integer> getMapaSubsistemas()  {

		try {
			return sTools.getMapaSubsistemas();
		} catch (SQLException e) {
			return new HashMap<String,Integer>();
		}

	}
	
	

}
