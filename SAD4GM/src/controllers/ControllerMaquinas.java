package controllers;

import bancoDeDados.MaquinaTools;
import entidades.Maquina;
import validadorInformacoes.ValidaMaquina;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */

public class ControllerMaquinas {

	private MaquinaTools mTools;

	public ControllerMaquinas(MaquinaTools mTools) {
		this.mTools = mTools;

	}

	public String inserir(String nome, String codigo, String descricao, String idUsuario) {
		String status;
		Maquina maquina;

		try {
			maquina = new Maquina(nome, codigo, descricao, idUsuario);
		} catch (Exception e) {
			return e.getMessage();
		}

		try {
			mTools.inserir(maquina);
			status = "Máquina Inserida com Sucesso!";
		} catch (Exception e) {
			status = e.getMessage();
		}

		return status;
	}

	public String remover(String codigo) {
		String status;
		int codigoInt;

		try {
			codigoInt = Maquina.parseCodigo(codigo);
		} catch (Exception e) {
			return e.getMessage();
		}

		try {
			mTools.deletar(codigoInt);
			status = "Máquina removida com sucesso!";
		} catch (Exception e) {
			status = e.getMessage();
		}

		return status;
	}

	public String setNome(String codigo, String nome) {
		String status;
		int codigoInt;

		try {
			codigoInt = Integer.parseInt(codigo);
		} catch (Exception e) {
			return "CÓDIGO INVÁLIDO!";
		}

		try {
			ValidaMaquina.validaNome(nome);
			mTools.setNome(codigoInt, nome);
			status = "Nome atualizado com sucesso!";
		} catch (Exception e) {
			status = e.getMessage();
		}

		return status;
	}

	public String setCodigo(String codigo, String novoCodigo) {
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
			mTools.setCodigo(codigoInt, novoCodigoInt);
			status = "Código atualizado com sucesso!";
		} catch (Exception e) {
			status = e.getMessage();
		}

		return status;
	}

	public String setDescricao(String codigo, String descricao) {
		String status;
		int codigoInt;

		try {
			codigoInt = Integer.parseInt(codigo);
		} catch (Exception e) {
			return "CÓDIGO INVÁLIDO!";
		}

		try {
			ValidaMaquina.validaDescricao(descricao);
			mTools.setDescricao(codigoInt, descricao);
			status = "Descrição atualizada com sucesso!";
		} catch (Exception e) {
			status = e.getMessage();
		}

		return status;
	}

	public String getInfo(String codigo) {
		String info;
		int codigoInt;

		try {
			codigoInt = Integer.parseInt(codigo);
		} catch (Exception e) {
			return "CÓDIGO INVÁLIDO!";
		}

		try {
			info = mTools.getInfo(codigoInt);
		} catch (Exception e) {
			info = e.getMessage();
		}

		return info;
	}

	public String listar() {
		String listagem;

		listagem = mTools.listar();

		if (listagem.equals(""))
			listagem = "Nenhuma máquina cadastrada!";

		return listagem;
	}

	public boolean hasMaquina(String codigo) {

		return hasMaquina(codigo);
	}

}
