package entidades;

import validadorInformacoes.ValidaMaquina;
import validadorInformacoes.ValidaUsuario;

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
	private String idUsuario;

	public Maquina(String nome, String codigo, String descricao, String idUsuario) {
		ValidaMaquina.validaNome(nome);
		this.nome = nome;
		this.codigo = parseCodigo(codigo);
		ValidaMaquina.validaDescricao(descricao);
		this.descricao = descricao;
		ValidaUsuario.validaId(idUsuario);
		this.idUsuario = idUsuario;
	}

	public static int parseCodigo(String codigo) {
		int codigoInt;

		try {
			codigoInt = Integer.parseInt(codigo);
		} catch (Exception e) {
			throw new IllegalArgumentException("Código Inválido!");
		}

		return codigoInt;
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

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
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
