package funcoesInteface;

import java.sql.SQLException;

import sistema.Sistema;

public class FuncoesGeraisUsuario {

	private String usuarioLogadoId;
	private Sistema sistema;
	private boolean logado;

	public FuncoesGeraisUsuario() {
		this.sistema = new Sistema();
		this.logado = false;
		this.usuarioLogadoId = null;
	}

	private void logar() {
		if (!this.logado)
			this.logado = true;
	}

	private void logout() {
		if (this.logado) {
			this.logado = false;
			this.usuarioLogadoId = null;
		}
	}

	public boolean isLogado() {
		return this.logado;
	}

	public String login(String id, String senha) throws SQLException {
		String status;

		if (sistema.autenticaUsuario(id, senha)) {
			this.usuarioLogadoId = id;
			logar();
			status = "Login efetuado com Sucesso!";
		} else
			status = "ID ou Senha Inválidos!";

		return status;

	}

}
