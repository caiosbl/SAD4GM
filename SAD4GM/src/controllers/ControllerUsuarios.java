package controllers;

import java.sql.SQLException;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES
 * SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */

import bancoDeDados.UsuarioTools;
import validadorInformacoes.ValidaUsuario;

public class ControllerUsuarios {

	private UsuarioTools uTools;

	public ControllerUsuarios(UsuarioTools uTools) {
		this.uTools = uTools;
	}

	public String inserir(String nome, String id, String senha, String auditor) {

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
			uTools.inserir(nome, id, senhaInt, auditor);
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

	public String remover(String id) {
		String status;
		try {
			uTools.deletar(id);
			status = "Usuário removido com sucesso!";
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
			uTools.setNome(nome, id);
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
			uTools.setId(id, novoId);
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
			uTools.setAuditor(id, auditor);
			;
			status = "Auditor Atualizado com Sucesso!";
		} catch (Exception e) {
			status = "Falha ao Atualizar o Auditor!";
		}

		return status;
	}

	public String getInfo(String id) {
		String info;

		try {
			info = uTools.getInfo(id);
		} catch (Exception e) {
			info = e.getMessage();
		}

		return info;
	}

	public String listar() {
		String listagem;

		listagem = uTools.listar();

		if (listagem.equals(""))
			listagem = "Nenhuma usuário cadastrado!";

		return listagem;
	}
	
	
	public String autentica(String id, String  senha) throws SQLException {
		int senhaInt;
		String status;

		try {
			senhaInt = Integer.parseInt(senha);
		} catch (Exception e) {
			return "SENHA INVÁLIDA!";
		}
		
		if(uTools.autenticador(id, senhaInt))
			status = "Usuário e senha válida";
		else
			status = "Usuário ou senha inválida";
		
		return status;
	}

}
