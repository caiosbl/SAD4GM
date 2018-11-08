package controladores;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import databaseTools.EfeitosTools;

import entidades.Efeito;

public class Efeitos {

	private EfeitosTools eTools;

	public Efeitos(EfeitosTools eTools) {
		this.eTools = eTools;
	}

	public String inserir(String nome, String descricao, double indiceSeveridade, int chaveModoFalha) {

		String status;

		try {
			eTools.inserir(nome, descricao, chaveModoFalha, indiceSeveridade);
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

	public double getIndiceSeveridade(int chaveEfeito) {
		double indiceSeveridade;

		try {
			indiceSeveridade = eTools.getIndiceSeveridade(chaveEfeito);
		} catch (SQLException e) {
			indiceSeveridade = -1;
		}
		return indiceSeveridade;
	}

	public double getIndiceSeveridadePorFalha(int chaveModoFalha) throws SQLException {
		return eTools.getIndiceSeveridadePorFalha(chaveModoFalha);
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

	public String setIndiceSeveridade(double indiceSeveridade, int chaveEfeito) {
		String status;

		try {
			eTools.setIndiceSeveridade(indiceSeveridade, chaveEfeito);
			status = "Indíce de Severidade atualizado com Sucesso!";
		} catch (Exception e) {
			status = "Falha ao Atualizar Indíce de Severidade!";
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

	public boolean hasEfeito(int chaveModoFalha) throws SQLException {
		return eTools.hasEfeito(chaveModoFalha);
	}
}
