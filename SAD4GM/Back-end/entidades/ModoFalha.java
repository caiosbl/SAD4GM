package entidades;

import java.util.ArrayList;

public class ModoFalha {

	private String nome;
	private String descricao;
	private int chave;
	private ArrayList<CausaPotencial> causasPotencias;
	private ArrayList<Efeito> efeitos;

	public ModoFalha(String nome, String descricao, int chave) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.chave = chave;
	}

	public ModoFalha(String nome, String descricao, int chave, ArrayList<CausaPotencial> causasPotenciais,
			ArrayList<Efeito> efeitos) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.chave = chave;
		this.causasPotencias = causasPotenciais;
		this.efeitos = efeitos;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public ArrayList<Efeito> getEfeitos(){
		return this.efeitos;
	}

	public ArrayList<CausaPotencial> getCausasPotencias() {
		return this.causasPotencias;
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
