package maquina;

import java.util.HashMap;
import java.util.Map;

import maquina.subsistema.Subsistema;
import validadorInformacoes.ValidaMaquina;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */

public class Maquina {

	private String nome;
	private int codigo;
	private String descricao;

	private Map<String,Subsistema> mapaDeSubsistemas;
	
	public Maquina(String nome, int codigo, String descricao) {
		ValidaMaquina.validaNome(nome);
		this.nome = nome;
		ValidaMaquina.validaCodigo(codigo);
		this.codigo = codigo;
		ValidaMaquina.validaDescricao(descricao);
		this.descricao = descricao;
		this.mapaDeSubsistemas = new HashMap<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
}
