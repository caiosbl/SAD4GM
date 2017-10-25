package usuario.enums;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES 
 * SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */

public enum AtributosUsuario {
	NOME("Nome"), ID("ID"), AUDITOR("Auditor");

	final private String valorAtributo;

	private AtributosUsuario(String valor) {
		this.valorAtributo = valor;
	}

	public String getValor() {
		return this.valorAtributo;
	}

}
