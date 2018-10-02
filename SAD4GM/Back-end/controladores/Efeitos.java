package controladores;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import databaseTools.CausaPotencialTools;
import databaseTools.EfeitosTools;
import entidades.CausaPotencial;
import entidades.Efeito;

public class Efeitos {

	private EfeitosTools eTools;

	public Efeitos(EfeitosTools eTools) {
		this.eTools = eTools;
	}

	public String inserir(String nome, String descricao, double indice_severidade, int chaveModoFalha) {

		String status;

		try {
			eTools.inserir(nome, descricao, chaveModoFalha, indice_severidade);
			status = "Causa Potencial inserida com Sucesso!";
		} catch (SQLException e) {
			status = e.getMessage();
		}

		return status;

	}

	public Map<String, Integer> getMapaEfeitos(int chaveModoFalha) {

		try {
			return eTools.getMapaEfeitos(chaveModoFalha);
		} catch (SQLException e) {
			return new HashMap<String, Integer>();
		}

	}

	public Map<Integer, Efeito> getEfeitosMap(int chaveModoFalha) {
		try {
			return eTools.getEfeitosMap(chaveModoFalha);
		} catch (SQLException e) {
			return new HashMap<Integer, Efeito>();
		}
	}

	public String getDescricao(int chaveEfeito) {
		String descricao;

		try {
			descricao = eTools.getDescricaoEfeito(chaveEfeito);
		} catch (SQLException e) {
			descricao = "Falha na Conexão com Banco de Dados!";
		}
		return descricao;
	}

	public String getNome(int chaveEfeito) {
		String nome;

		try {
			nome = eTools.getNomeEfeito(chaveEfeito);
		} catch (SQLException e) {
			nome = "Falha na Conexão com Banco de Dados!";
		}
		return nome;
	}

	public String setNome(String nome, int chaveEfeito) {
		String status;

		try {
			eTools.setNomeEfeito(nome, chaveEfeito);
			status = "Nome atualizado com Sucesso!";
		} catch (Exception e) {
			status = "Falha ao Atualizar Nome!";
		}

		return status;
	}

	public String setDescricao(String descricao, int chaveEfeito) {
		String status;

		try {
			eTools.setDescricaoEfeito(descricao, chaveEfeito);
			status = "Descrição atualizada com Sucesso!";
		} catch (Exception e) {
			status = "Falha ao Atualizar Descrição!";
		}

		return status;
	}

	public String remover(int chave) {
		String status;

		try {
			eTools.deletar(chave);
			status = "Efeito removido com sucesso!";
		} catch (Exception e) {
			status = e.getMessage();
		}

		return status;
	}

}
