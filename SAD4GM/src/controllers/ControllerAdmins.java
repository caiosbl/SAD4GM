package controllers;

import java.sql.SQLException;

import bancoDeDados.AdminTools;
import validadorInformacoes.ValidaUsuario;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */

public class ControllerAdmins {
	private AdminTools admTools;

	public ControllerAdmins(AdminTools admTools) {
		this.admTools = admTools;
	}

	public String inserir(String nome, String senha, String id) {

		String status;

		try {
			ValidaUsuario.validaNome(nome);
			ValidaUsuario.validaId(id);
			admTools.insert(nome, senha, id);
			status = "Admin CADASTRADO COM SUCESSO!";

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

	public String deletar(String id) {
		String status;

		try {
			admTools.delete(id);
			status = "Admin Removido com Sucesso!";
		} catch (Exception e) {
			status = e.getMessage();
		}

		return status;
	}

	public String setNome(String nome, String id) {
		String status;

		try {
			ValidaUsuario.validaNome(nome);
			admTools.setName(nome, id);
			status = "Nome alterado com Sucesso!";
		} catch (Exception e) {
			status = e.getMessage();
		}

		return status;
	}

	public String setId(String id, String novoId) {
		String status;

		try {
			ValidaUsuario.validaId(novoId);
			admTools.setId(id, novoId);
			status = "Nome alterado com Sucesso!";
		} catch (Exception e) {
			status = e.getMessage();
		}

		return status;
	}

	public String setSenha(String id, String senha) {
		String status;

		try {

			admTools.setPassword(id, senha);
			status = "Senha alterada com Sucesso!";
		} catch (Exception e) {
			status = e.getMessage();
		}

		return status;
	}

	public String getInfo(String id) {
		String info;

		try {
			info = admTools.getInfo(id);
		} catch (Exception e) {
			info = e.getMessage();
		}

		return info;
	}

	public String getNome(String id) {
		String nome;
		try {
			nome = admTools.getName(id);
		} catch (Exception e) {
			nome = e.getMessage();
		}

		return nome;
	}

	public boolean autentica(String id, String senha) throws SQLException {
		return admTools.authenticate(id, senha);

	}

	public boolean hasAdmin(String id) throws SQLException {
		return admTools.hasAdmin(id);
	}

	public String getListagemAdmins() {
		return admTools.listAdmins();
	}
}
