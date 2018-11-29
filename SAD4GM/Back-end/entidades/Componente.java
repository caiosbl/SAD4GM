package entidades;

import java.util.ArrayList;

public class Componente {

	private String nome;
	private int chave;
	private ArrayList<Falha> falhas;

	public Componente(String nome, int chave) {
		super();
		this.nome = nome;
		this.chave = chave;
	}
	
	public Componente(String nome,  int chave, ArrayList<Falha>falhas) {
		super();
		this.nome = nome;
		this.chave = chave;
		this.falhas = falhas;
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
	
	public ArrayList<Falha> getFalhas(){
		return this.falhas;
	}

	public void setChave(int chave) {
		this.chave = chave;
	}

	@Override
	public String toString() {
		return nome;
	}

}
