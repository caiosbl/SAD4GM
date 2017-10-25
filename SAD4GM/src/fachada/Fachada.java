package fachada;

import usuario.ControllerUsuarios;

public class Fachada {

	private ControllerUsuarios cUsuarios;

	public Fachada() {
		this.cUsuarios = new ControllerUsuarios();
	}

	// Funções de Usuário

	// 1 - Cadastrar um Usuário

	public String cadastrarUsuario(String nome, String id, String auditor) {

		String status;
		try {
			cUsuarios.adicionaUsuario(nome, id, auditor);
			status = "USUÁRIO CADASTRADO COM SUCESSO!";
		} catch (NullPointerException e) {
			status = e.getMessage();
		} catch (IllegalArgumentException e) {
			status = e.getMessage();
		}
		return status;
	}

}
