package controladores;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import databaseTools.AcaoRecomendadaTools;

import entidades.AcaoRecomendada;

public class AcoesRecomendadas {

	private AcaoRecomendadaTools aRTools;

	public AcoesRecomendadas(AcaoRecomendadaTools mFTools) {
		this.aRTools = mFTools;
	}

	public String inserir(String nome, String descricao, int chaveCausaPotencial) {

		String status;

		try {
			aRTools.inserir(nome, descricao, chaveCausaPotencial);
			status = "Ação Recomendada inserido com Sucesso!";
		} catch (SQLException e) {
			status = e.getMessage();
		}

		return status;

	}

	public Map<String, Integer> getMapaAcoesRecomendadas(int chaveCausaPotencial) {

		try {
			return aRTools.getMapaAcoesRecomendadas(chaveCausaPotencial);
		} catch (SQLException e) {
			return new HashMap<String, Integer>();
		}

	}

	public Map<Integer, AcaoRecomendada> getAcoesRecomendadasMap(int chaveCausaPotencial) {
		try {

			return aRTools.getAcoesRecomendadasMap(chaveCausaPotencial);
		} catch (SQLException e) {

			return new HashMap<Integer, AcaoRecomendada>();
		}
	}

	public String getDescricao(int chaveAcaoRecomendada) {
		String descricao;

		try {
			descricao = aRTools.getDescricao(chaveAcaoRecomendada);
		} catch (SQLException e) {
			descricao = "Falha na Conexão com Banco de Dados!";
		}
		return descricao;
	}

	public String getNome(int chaveAcaoRecomendada) {
		String nome;

		try {
			nome = aRTools.getNome(chaveAcaoRecomendada);
		} catch (SQLException e) {
			nome = "Falha na Conexão com Banco de Dados!";
		}
		return nome;
	}

	public String setDescricao(String descricao, int chaveAcaoRecomendada) {
		String status;

		try {
			aRTools.setDescricao(descricao, chaveAcaoRecomendada);
			status = "Descrição atualizada com Sucesso!";
		} catch (Exception e) {
			status = "Falha ao Atualizar Descrição!";
		}

		return status;
	}

	public String setNome(String nome, int chaveAcaoRecomendada) {
		String status;

		try {
			aRTools.setNome(nome, chaveAcaoRecomendada);
			status = "Título atualizado com Sucesso!";
		} catch (Exception e) {
			status = "Falha ao Atualizar Título!";
		}

		return status;
	}

	public String remover(int chave) {
		String status;

		try {
			aRTools.deletar(chave);
			status = "Ação Recomendada removida com sucesso!";
		} catch (Exception e) {
			status = e.getMessage();
		}

		return status;
	}

}
