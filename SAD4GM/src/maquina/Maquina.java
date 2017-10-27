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

	private Map<String, Subsistema> mapaDeSubsistemas;

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
		ValidaMaquina.validaNome(nome);
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		ValidaMaquina.validaCodigo(codigo);
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		ValidaMaquina.validaDescricao(descricao);
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
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
		Maquina other = (Maquina) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

	@Override
	public String toString() {

		String quebraLinha = System.lineSeparator();

		return "DADOS DA MÁQUINA: " + quebraLinha + "Nome: " + this.nome + quebraLinha + "Código: " + codigo
				+ quebraLinha + "Descrição: " + descricao + quebraLinha;
	}

}
