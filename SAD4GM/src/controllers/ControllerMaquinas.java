package controllers;

import bancoDeDados.DataBaseTools;

import validadorInformacoes.ValidaMaquina;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */

public class ControllerMaquinas {

	private DataBaseTools dTools;

	public ControllerMaquinas(DataBaseTools dTools) {
		this.dTools = dTools;

	}

	public String adicionaMaquina(String nome, String codigo, String descricao) {
		int codigoInt;
		String status;

		try {
			codigoInt = Integer.parseInt(codigo);
		} catch (Exception e) {
			return "CÓDIGO INVÁLIDO!";
		}
		try {
			ValidaMaquina.validaNome(nome);
			ValidaMaquina.validaCodigo(codigoInt);
			ValidaMaquina.validaDescricao(descricao);
			dTools.inserirMaquina(nome, codigoInt, descricao);
			status = "MÁQUINA CADASTRADA COM SUCESSO!";
		} catch (NullPointerException e) {
			status = e.getMessage();
		} catch (IllegalArgumentException e) {
			status = e.getMessage();
		} catch (RuntimeException e) {
			status = e.getMessage();
		} catch (Exception e) {
			status = e.getMessage();
		}

		return status;
	}

	public String removerMaquina(String codigo) {
		String status;
		int codigoInt;

		try {
			codigoInt = Integer.parseInt(codigo);
		} catch (Exception e) {
			return "CÓDIGO INVÁLIDO!";
		}

		try {
			dTools.deletarMaquina(codigoInt);
			status = "Máquina removida com sucesso!";
		} catch (Exception e) {
			status = e.getMessage();
		}

		return status;
	}

	public String setNomeMaquina(String codigo, String nome) {
		String status;
		int codigoInt;

		try {
			codigoInt = Integer.parseInt(codigo);
		} catch (Exception e) {
			return "CÓDIGO INVÁLIDO!";
		}

		try {
			ValidaMaquina.validaNome(nome);
			dTools.setNomeMaquina(codigoInt, nome);
			status = "Nome atualizado com sucesso!";
		} catch (Exception e) {
			status = e.getMessage();
		}

		return status;
	}

	public String setCodigoMaquina(String codigo, String novoCodigo) {
		String status;
		int codigoInt;
		int novoCodigoInt;

		try {
			codigoInt = Integer.parseInt(codigo);
		} catch (Exception e) {
			return "CÓDIGO INVÁLIDO!";
		}

		try {
			novoCodigoInt = Integer.parseInt(novoCodigo);
		} catch (Exception e) {
			return "NOVO CÓDIGO INVÁLIDO!";
		}

		try {
			ValidaMaquina.validaCodigo(novoCodigoInt);
			dTools.setCodigoMaquina(codigoInt, novoCodigoInt);
			status = "Código atualizado com sucesso!";
		} catch (Exception e) {
			status = e.getMessage();
		}

		return status;
	}

	public String setDescricaoMaquina(String codigo, String descricao) {
		String status;
		int codigoInt;

		try {
			codigoInt = Integer.parseInt(codigo);
		} catch (Exception e) {
			return "CÓDIGO INVÁLIDO!";
		}

		try {
			ValidaMaquina.validaDescricao(descricao);
			dTools.setDescricaoMaquina(codigoInt, descricao);
			status = "Descrição atualizada com sucesso!";
		} catch (Exception e) {
			status = e.getMessage();
		}

		return status;
	}

	/*
	 * 
	 * public String listaMaquinas() { String quebraLinha = System.lineSeparator();
	 * String listagem = "MÁQUINAS CADASTRADAS: " + quebraLinha;
	 * 
	 * for (Integer chave : mapaDeMaquinas.keySet()) { listagem += quebraLinha;
	 * listagem += mapaDeMaquinas.get(chave).toString(); listagem += quebraLinha; }
	 * 
	 * return listagem;
	 * 
	 * }
	 */
}
