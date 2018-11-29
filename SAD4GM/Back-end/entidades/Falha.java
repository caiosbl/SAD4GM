package entidades;

import java.util.ArrayList;

public class Falha {

	private String nome;
	private int chave;
	private ArrayList<ModoFalha> modosDeFalha;

	public Falha(String nome, int chave) {
		super();
		this.nome = nome;
		this.chave = chave;
	}
	
	public Falha(String nome, int chave, ArrayList<ModoFalha> modosDeFalha) {
		super();
		this.nome = nome;
		this.chave = chave;
		this.modosDeFalha = modosDeFalha;
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
	
	public ArrayList<ModoFalha> getModoFalha(){
		return this.modosDeFalha;
	}

	public void setChave(int chave) {
		this.chave = chave;
	}

	@Override
	public String toString() {
		return nome;
	}

}
