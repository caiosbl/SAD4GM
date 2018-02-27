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
import entidades.Usuario;
import validadorInformacoes.ValidaUsuario;
/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES 
 * SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class ControllerUsuarios {

	private UsuarioTools uTools;

	public ControllerUsuarios(UsuarioTools uTools) {
		this.uTools = uTools;
	}

	public String inserir(String nome, String id, String senha, String auditor) {

		Usuario usuario;
		String status;

		try {
			usuario = new Usuario(nome, id, senha, auditor);
		} catch (Exception e) {
			return e.getMessage();
		}

		try {
			uTools.inserir(usuario);
			status = "Usuário inserido com Sucesso!";
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

	public String setSenha(String id, String senha) {
		
String status;
		try {
			uTools.setSenha(id, senha);
			status = "Senha Atualizada com Sucesso!";
		} catch (Exception e) {
			status = "Falha ao Atualizar a Senha!";
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

	public String getNome(String id) {
		String nome;
		try {
			nome = uTools.getNome(id);
		} catch (Exception e) {
			nome = e.getMessage();
		}

		return nome;
	}

	public String getNomeAuditor(String id) {
		String auditor;
		try {
			auditor = uTools.getNomeAuditor(id);
		} catch (Exception e) {
			auditor = e.getMessage();
		}

		return auditor;

	}

	public String listar() {
		String listagem;

		listagem = uTools.listar();

		if (listagem.equals(""))
			listagem = "Nenhum usuário cadastrado!";

		return listagem;
	}

	public boolean autentica(String id, String senha) throws SQLException {
		boolean status;

	

		if (uTools.autenticador(id, senha))
			status = true;
		else
			status = false;

		return status;
	}

	public boolean hasUsuario(String id) throws SQLException {
		return uTools.hasUsuario(id);
	}
	
	public boolean isAtivo(String id) throws SQLException {
		return uTools.isAtivo(id);
	}

}
