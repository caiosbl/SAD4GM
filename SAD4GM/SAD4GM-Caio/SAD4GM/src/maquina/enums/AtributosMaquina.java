package maquina.enums;

public enum AtributosMaquina {
	NOME("Nome"), CÓDIGO("Código"), DESCRIÇÃO("Descrição");

	final private String valorAtributo;

	private AtributosMaquina(String valor) {
		this.valorAtributo = valor;
	}

	public String getValor() {
		return this.valorAtributo;
	}

}
