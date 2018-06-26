package entidades;

public class Componente {

	private String nome;
	private int chave;

	public Componente(String nome, int chave) {
		super();
		this.nome = nome;
		this.chave = chave;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getChave() {
		return chave;
	}

	public void setChave(int chave) {
		this.chave = chave;
	}

	@Override
	public String toString() {
		return nome;
	}

}
