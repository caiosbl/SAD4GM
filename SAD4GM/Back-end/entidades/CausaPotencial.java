package entidades;

public class CausaPotencial {

	private String nome;
	private String descricao;
	private int chave;

	public CausaPotencial(String nome, String descricao, int chave) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.chave = chave;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
