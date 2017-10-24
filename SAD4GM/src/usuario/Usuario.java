package usuario;

public class Usuario {

	private String nome;
	private String id;
	private String supervisor;

	public Usuario(String nome, String id, String supervisor) {
		this.nome = nome;
		this.id = id;
		this.supervisor = supervisor;
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

	public String getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	@Override
	public String toString() {
		return "DADOS DO USUÁRIO:" + System.lineSeparator() + "Usuário: " + nome + System.lineSeparator() + "Id: " + id
				+ System.lineSeparator() + "Supervisor: " + supervisor;

	}

}
