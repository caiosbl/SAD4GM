package controladores;

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

}
