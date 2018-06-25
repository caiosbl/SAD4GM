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
	
	public Map<String,Integer> getMapaSubsistemas(int chaveMaquina)  {

		try {
			return sTools.getMapaSubsistemas(chaveMaquina);
		} catch (SQLException e) {
			return new HashMap<String,Integer>();
		}

	}
	
	
	
	public String getNomeSubsistema(int chaveSubsistema) {
		String nome;
		
		try {
			nome = sTools.getNomeSubsistema(chaveSubsistema);
		} catch (SQLException e) {
			e.printStackTrace();
			nome = "Falha na Conexão com Banco de Dados!";
		}
		return nome;
	}
	
	public String setNomeSubsistema(String nome, int chaveSubsistema) {
		String status;
		
		try {
			sTools.setNomeSubsistema(nome, chaveSubsistema);
			status = "Nome atualizado com Sucesso!";
		}
		catch (Exception e) {
			status = "Falha ao Atualizar Nome!";
		}
		
		return status;
	}




	public String remover(int chave) {
		String status;

		try {
			sTools.deletar(chave);
			status = "Subsistema removido com sucesso!";
		} catch (Exception e) {
			status = e.getMessage();
		}

		return status;
	}
	
	

}
