package entidades;

import validadorInformacoes.ValidaUsuario;
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
	private int senha;
	private String auditor;

	public Usuario(String nome, String id, String senha, String auditor) {
		ValidaUsuario.validaNome(nome);
		this.nome = nome;
		ValidaUsuario.validaId(id);
		this.id = id;
		this.senha = parseSenha(senha);
		ValidaUsuario.validaAuditor(auditor);
		this.auditor = auditor;
	}

	private int parseSenha(String senha) {
		int senhaInt;

		try {
			senhaInt = Integer.parseInt(senha);
		} catch (Exception e) {
			throw new IllegalArgumentException("Senha Inválida!");
		}

		return senhaInt;
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

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public String getAuditor() {
		return auditor;
	}

	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}

}
