package controllers;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES
 * SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
import java.util.Map;

import javax.management.RuntimeErrorException;

import bancoDeDados.DataBaseTools;
import bancoDeDados.UsuarioTools;
import usuario.Usuario;
import validadorInformacoes.ValidaUsuario;

public class ControllerUsuarios {

	private UsuarioTools uTools;

	public ControllerUsuarios(UsuarioTools uTools) {
		this.uTools = uTools;
	}

	public String adicionaUsuario(String nome, String id, String senha, String auditor) {

		int senhaInt;
		String status;

		try {
			senhaInt = Integer.parseInt(senha);
		} catch (Exception e) {
			return "SENHA INVÁLIDA!";
		}
		try {
			ValidaUsuario.validaNome(nome);
			ValidaUsuario.validaId(id);
			ValidaUsuario.validaAuditor(auditor);
			uTools.inserirUsuario(nome, id, senhaInt, auditor);
			status = "USUÁRIO CADASTRADO COM SUCESSO!";
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
	
	public String removerUsuario(String id) {
		String status;
		try {
			uTools.deletarUsuario(id);
			status = "Máquina removida com sucesso!";
		} catch (Exception e) {
			status = e.getMessage();
		}

		return status;
	}
	
	


	public String setNome(String id, String nome) {
		String status;
		try {
			ValidaUsuario.validaNome(nome);
		} catch (IllegalArgumentException e) {
			status = "Nome Inválido!";
			return status;
		} catch (NullPointerException e) {
			status = "Nome nulo Inválido!";
			return status;
		}

		try {
			uTools.setNomeUsuario(nome, id);
			status = "Nome Atualizado com Sucesso!";
		} catch (Exception e) {
			status = "Falha ao Atualizar Nome!";
		}

		return status;
	}
	
	public String setId(String id, String novoId) {
		String status;
		try {
			ValidaUsuario.validaId(novoId);
		} catch (IllegalArgumentException e) {
			status = "ID Inválido!";
			return status;
		} catch (NullPointerException e) {
			status = "ID nulo Inválido!";
			return status;
		}

		try {
			uTools.setIdUsuario(id, novoId);
			status = "ID Atualizado com Sucesso!";
		} catch (Exception e) {
			status = "Falha ao Atualizar o ID!";
		}

		return status;
	}
	
	public String setAuditor(String id, String auditor) {
		String status;
		try {
			ValidaUsuario.validaAuditor(auditor);
		} catch (IllegalArgumentException e) {
			status = "Auditor Inválido!";
			return status;
		} catch (NullPointerException e) {
			status = "Auditor nulo Inválido!";
			return status;
		}

		try {
			uTools.setAuditorUsuario(id, auditor);;
			status = "Auditor Atualizado com Sucesso!";
		} catch (Exception e) {
			status = "Falha ao Atualizar o Auditor!";
		}

		return status;
	}

	


	public String listarUsuarios() {
		String quebraLinha = System.lineSeparator();
		String listagem = "USUÁRIOS CADASTRADOS: " + quebraLinha;

		for (String chave : mapaUsuarios.keySet()) {
			listagem += quebraLinha;
			listagem += mapaUsuarios.get(chave).toString();
			listagem += quebraLinha;
		}

		return listagem;
	}

}
