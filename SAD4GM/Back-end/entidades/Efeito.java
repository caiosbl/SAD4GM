package entidades;

public class Efeito {

	private String nome;
	private String descricao;
	private double indiceSeveridade;
	private int chave;

	public Efeito(String nome, String descricao ,int chave) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.chave = chave;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getIndiceSeveridade() {
		return indiceSeveridade;
	}

	public void setIndiceSeveridade(double indiceSeveridade) {
		this.indiceSeveridade = indiceSeveridade;
	}

	public int getChave() {
		return this.chave;
	}

	public void setChave(int chave) {
		this.chave = chave;
	}

	@Override
	public String toString() {
		return this.nome;
	}

}