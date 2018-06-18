package entidades;

import validadorInformacoes.CheckUser;
/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * Classe de um Usuário.
 * 
 * @author caiosbl
 *
 */

public class Usuario {

	private String nome;
	private String id;
	private String senha;
	private String auditor;
	private boolean isAdmin;

	public Usuario(String nome, String id, String senha, String auditor, boolean admin) {
		CheckUser.validateName(nome);
		this.nome = nome;
		CheckUser.validateId(id);
		this.id = id;
		this.senha = senha;
		CheckUser.validaAuditor(auditor);
		this.auditor = auditor;
		this.isAdmin = admin;
	}

	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getId() {
		return id;
	}
	
	public boolean isAdmin() {
		return isAdmin;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getAuditor() {
		return auditor;
	}

	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}

}
