package controladores;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import databaseTools.FalhaTools;
import entidades.Falha;

public class Falhas {

	private FalhaTools fTools;

	public Falhas(FalhaTools fTools) {
		this.fTools = new FalhaTools();
	}

	public String inserir(String nome, String descricao, int chaveComponente) {

		String status;

		try {
			fTools.inserir(nome, descricao, chaveComponente);
			status = "Falha inserida com Sucesso!";
		} catch (SQLException e) {
			status = e.getMessage();
		}

		return status;

	}

	public Map<String, Integer> getMapaFalhas(int chaveComponente) {

		try {
			return fTools.getMapaFalhas(chaveComponente);
		} catch (SQLException e) {
			return new HashMap<String, Integer>();
		}

	}
	
	public Map<Integer,Falha> getFalhasMap(int chaveComponente){
		try {
			return fTools.getFalhasMap(chaveComponente);
		} catch (SQLException e) {
			return new HashMap<Integer,Falha>();
		}
	}
	public String getDescricao(int chaveFalha) {
		String descricao;
		
		try {
			descricao = fTools.getDescricaoFalha(chaveFalha);
		} catch (SQLException e) {
			e.printStackTrace();
			descricao = "Falha na Conexão com Banco de Dados!";
		}
		return descricao;
	}
	
	public String setDescricao(String descricao, int chaveFalha) {
		String status;
		
		try {
			fTools.setDescricaoFalha(descricao, chaveFalha);
			status = "Descrição atualizada com Sucesso!";
		}
		catch (Exception e) {
			status = "Falha ao Atualizar Descrição!";
		}
		
		return status;
	}
	
	
	
	public String getNome(int chaveFalha) {
		String nome;
		
		try {
			nome = fTools.getNomeFalha(chaveFalha);
		} catch (SQLException e) {
			e.printStackTrace();
			nome = "Falha na Conexão com Banco de Dados!";
		}
		return nome;
	}
	
	public String setNome(String nome, int chaveFalha) {
		String status;
		
		try {
			fTools.setNomeFalha(nome, chaveFalha);
			status = "Nome atualizado com Sucesso!";
		}
		catch (Exception e) {
			status = "Falha ao Atualizar Nome!";
		}
		
		return status;
	}

}
