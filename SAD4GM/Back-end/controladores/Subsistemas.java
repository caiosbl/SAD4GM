package controladores;



import databaseTools.SubsistemaTools;

public class Subsistemas {
	
	private SubsistemaTools sTools;
	
	
	public Subsistemas(SubsistemaTools sTools) {
		this.sTools = sTools;
	}
	
	
	
	
	public String inserir(String nome, int chaveMaquina) {
		String status = "Falha ao Inserir Subsistema!";
		
		try {
			sTools.inserir(nome, chaveMaquina);
			status = "Subsistema inserido com Sucesso!";
		} 
		catch (Exception e) {
			status = e.getMessage();
		}
		
		return status;
		
	}
	
	

}
