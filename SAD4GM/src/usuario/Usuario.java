package usuario;

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
	private String auditor;

	public Usuario(String nome, String id, String auditor) {
		ValidaUsuario.validaNome(nome);
		this.nome = nome;
		ValidaUsuario.validaId(id);
		this.id = id;
		ValidaUsuario.validaAuditor(auditor);
		this.auditor = auditor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		ValidaUsuario.validaNome(nome);
		this.nome = nome;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		ValidaUsuario.validaId(id);
		this.id = id;
	}

	public String getAuditor() {
		return auditor;
	}

	public void setAuditor(String auditor) {
		ValidaUsuario.validaAuditor(auditor);
		this.auditor = auditor;
	}

	@Override
	public String toString() {
		return "DADOS DO USUÁRIO:" + System.lineSeparator() + "Usuário: " + nome + System.lineSeparator() + "Id: " + id
				+ System.lineSeparator() + "Auditor: " + auditor;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
