package controladores;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import databaseTools.CausaPotencialTools;
import entidades.CausaPotencial;


public class CausasPotenciais {

	private CausaPotencialTools cPTools;

	public CausasPotenciais(CausaPotencialTools cPTools) {
		this.cPTools = cPTools;
	}

	public String inserir(String nome, String descricao, int chaveModoFalha) {

		String status;

		try {
			cPTools.inserir(nome, descricao, chaveModoFalha);
			status = "Modo de Falha inserido com Sucesso!";
		} catch (SQLException e) {
			status = e.getMessage();
		}

		return status;

	}

	public Map<String, Integer> getMapaCausasPotenciais(int chaveModoFalha) {

		try {
			return cPTools.getMapaCausasPotenciais(chaveModoFalha);
		} catch (SQLException e) {
			return new HashMap<String, Integer>();
		}

	}

	public Map<Integer, CausaPotencial> getCausasPotenciaisMap(int chaveModoFalha) {
		try {
			return cPTools.getCausasPotenciaisMap(chaveModoFalha);
		} catch (SQLException e) {
			return new HashMap<Integer, CausaPotencial>();
		}
	}

	public String getDescricao(int chaveCausaPotencial) {
		String descricao;

		try {
			descricao = cPTools.getDescricaoCausaPotencial(chaveCausaPotencial);
		} catch (SQLException e) {
			descricao = "Falha na Conexão com Banco de Dados!";
		}
		return descricao;
	}

	public String getNome(int chaveCausaPotencial) {
		String nome;

		try {
			nome = cPTools.getNomeCausaPotencial(chaveCausaPotencial);
		} catch (SQLException e) {
			nome = "Falha na Conexão com Banco de Dados!";
		}
		return nome;
	}
	
	public String setNome(String nome, int chaveCausaPotencial) {
		String status;

		try {
			cPTools.setNomeCausaPotencial(nome, chaveCausaPotencial);
			status = "Nome atualizado com Sucesso!";
		} catch (Exception e) {
			status = "Falha ao Atualizar Nome!";
		}

		return status;
	}

	public String setDescricao(String descricao, int chaveCausaPotencial) {
		String status;

		try {
			cPTools.setDescricaoCausaPotencial(descricao, chaveCausaPotencial);
			status = "Descrição atualizada com Sucesso!";
		} catch (Exception e) {
			status = "Falha ao Atualizar Descrição!";
		}

		return status;
	}

	public String remover(int chave) {
		String status;

		try {
			cPTools.deletar(chave);
			status = "Causa Potencial removida com sucesso!";
		} catch (Exception e) {
			status = e.getMessage();
		}

		return status;
	}

}
