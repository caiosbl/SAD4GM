package interfaceSistema.enumsOpcoes;

public enum OpcoesUsuario {
	/*
	 * "1 - CADASTRAR UM USUÁRIO"
				+ System.lineSeparator() + "2 - ATUALIZAR UM USUÁRIO" + System.lineSeparator()
				+ "3 - REMOVER UM USUÁRIO" + System.lineSeparator() + "4 - BUSCAR UM USUÁRIO" + System.lineSeparator()
				+ "5 - SAIR"
	 */
	CADASTRAR_UM_USUÁRIO("1"), ATUALIZAR_UM_USUÁRIO("2"), REMOVER_UM_USUÁRIO("3"),BUSCAR_UM_USUÁRIO("4"),SAIR("5");

	final private String valorOpcao;
	
	private OpcoesUsuario(String valor) {
		this.valorOpcao = valor;
	}

	public String getValor() {
		return this.valorOpcao;
	}

}
