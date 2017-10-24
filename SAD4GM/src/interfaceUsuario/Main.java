package interfaceUsuario;

public class Main {

	public static void main(String[] args) {
		System.out.println(opcoesGerais());
		

	}
	
	public static String opcoesGerais() {
		return "(U)suário" + System.lineSeparator() + 
				"(M)áquina";
	}
	
	public static String opcoesUsuario() {
		return "(C)adastrar Usuário" + System.lineSeparator() +
		"(A)tualizar Usuário" + System.lineSeparator() +
		"(R)emover Usuário" + System.lineSeparator() ;
		
	}

}
