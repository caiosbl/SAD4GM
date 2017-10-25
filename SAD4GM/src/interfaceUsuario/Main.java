package interfaceUsuario;

import usuario.enums.AtributosUsuario;

public class Main {

	public static void main(String[] args) {
		AtributosUsuario atr = AtributosUsuario.valueOf("NOME");
		System.out.println(atr.getValor());
	}

}
