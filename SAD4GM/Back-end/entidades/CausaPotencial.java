package entidades;

import java.util.ArrayList;

public class CausaPotencial {

	private String nome;
	private String descricao;
	private int chave;
	private ArrayList<Origem> origens;


	public CausaPotencial(String nome, String descricao, int chave) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.chave = chave;
	}
	
	public CausaPotencial(String nome,int chave, ArrayList<Origem> origens) {
		super();
		this.nome = nome;
		this.chave = chave;
		this.origens = origens;
	
		
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public ArrayList<Origem> getOrigens(){
		return this.origens;
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
