package usuario.enums;

public enum AtributosUsuario {
	NOME("Nome"),ID("ID"),AUDITOR("Auditor");
	
	final private String valorAtributo;
	
	private AtributosUsuario(String valor) {
		this.valorAtributo = valor;
	}
	
	public String getValor() {
		return this.valorAtributo;
	}

}
