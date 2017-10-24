package interfaceUsuario;

import java.util.Scanner;

import usuario.Usuario;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);

		System.out.println("Nome:");
		String nome = sc.nextLine();
		System.out.println("Id:");
		String id = sc.nextLine();
		System.out.println("Auditor:");
		String auditor = sc.nextLine();
		
		Usuario usuario = new Usuario(nome, id, auditor);
		
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
