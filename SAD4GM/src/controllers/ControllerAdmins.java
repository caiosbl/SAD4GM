package controllers;

import java.sql.SQLException;

import bancoDeDados.AdminTools;
import validadorInformacoes.ValidaUsuario;

public class ControllerAdmins {
	private AdminTools admTools;

	public ControllerAdmins(AdminTools admTools) {
		this.admTools = admTools;
	}

	public String inserir(String nome, String senha, String id) {
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
			admTools.inserir(nome, senhaInt, id);
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
			admTools.setNome(nome, id);
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
		int senhaInt;

		try {
			senhaInt = Integer.parseInt(senha);
		} catch (Exception e) {
			return "Senha Inválida!";
		}

		try {

			admTools.setSenha(id, senhaInt);
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

	public boolean autentica(String id, String senha) throws SQLException {
		int senhaInt;
		boolean status;

		try {
			senhaInt = Integer.parseInt(senha);
		} catch (Exception e) {
			return false;
		}

		if (admTools.autentica(id, senhaInt))
			status = true;
		else
			status = false;

		return status;
	}
}
