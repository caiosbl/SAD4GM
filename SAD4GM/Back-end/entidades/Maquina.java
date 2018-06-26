package entidades;

import validadorInformacoes.ValidaMaquina;
import validadorInformacoes.CheckUser;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * Classe de uma Máquina.
 * 
 * @author caiosbl
 *
 */

public class Maquina {

	private String nome;
	private int codigo;
	private String descricao;
	private String idUsuario;
	private int chave;

	public Maquina(String nome, String codigo, String descricao, String idUsuario) {
		ValidaMaquina.validaNome(nome);
		this.nome = nome;
		this.codigo = parseCodigo(codigo);
		ValidaMaquina.validaDescricao(descricao);
		this.descricao = descricao;
		CheckUser.validateId(idUsuario);
		this.idUsuario = idUsuario;
	}

	public Maquina(String nome, int chave) {
		this.nome = nome;
		this.chave = chave;
	}

	/**
	 * Retorna o valor inteiro de um código em String
	 * 
	 * @param codigo
	 *            Código a ser convertido.
	 * @return Código em Int
	 * @throws IllegalArgumentException
	 *             Lança um IllegalArgumentException caso o código não possa ser
	 *             convertido em um inteiro válido.
	 */
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

	public int getChave() {
		return this.chave;
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

		return nome;
	}

}
