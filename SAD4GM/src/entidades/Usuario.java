package entidades;

import validadorInformacoes.CheckUser;
/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES 
 * SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */
public class Usuario {

	private String nome;
	private String id;
	private String senha;
	private String auditor;

	public Usuario(String nome, String id, String senha, String auditor) {
		CheckUser.validateName(nome);
		this.nome = nome;
		CheckUser.validateId(id);
		this.id = id;
		this.senha = senha;
		CheckUser.validaAuditor(auditor);
		this.auditor = auditor;
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
