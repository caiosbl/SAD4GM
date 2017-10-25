package interfaceUsuario;

import java.util.Scanner;

import sistema.Sistema;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		Sistema sistema = new Sistema();
		String entrada = "";
		
		do {
			System.out.println(opcoes());
			System.out.print("OPÇÃO: ");
			entrada = sc.nextLine();
			selectOpcao(entrada, sistema);
		
		}
		while(!entrada.equals("5"));
	}

	public static void selectOpcao(String opcao, Sistema sistema) {
		switch (opcao) {
		case "1":
			cadastraUsuario(sistema);
			break;
		case "2":
			atualizaUsuario(sistema);

		default:
			break;
		}
	}

	public static String opcoes() {
		String opcoes = "SELECIONE UMA OPÇÃO: " + System.lineSeparator() + "1 - CADASTRAR UM USUÁRIO"
				+ System.lineSeparator() + "2 - ATUALIZAR UM USUÁRIO" + System.lineSeparator()
				+ "3 - REMOVER UM USUÁRIO" + System.lineSeparator() + "4 - BUSCAR UM USUÁRIO" + System.lineSeparator() +
				"5 - SAIR" + System.lineSeparator();

		return opcoes;
	}

	public static void cadastraUsuario(Sistema sistema) {
		System.out.println("CADASTRAR UM USUÁRIO"  + System.lineSeparator());
		Scanner sc = new Scanner(System.in);
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("ID: ");
		String id = sc.nextLine();
		System.out.print("Auditor: ");
		String auditor = sc.nextLine();
	
		System.out.println(System.lineSeparator() + sistema.cadastrarUsuario(nome, id, auditor) + System.lineSeparator());
	

	}
	
	public static void atualizaUsuario(Sistema sistema) {
		System.out.println("ATUALIZAR UM USUÁRIO " + System.lineSeparator());
		
		Scanner sc = new Scanner(System.in);
		System.out.print("ID DO USUÁRIO: ");
		String id = sc.nextLine();
		System.out.print("DADO A SER ATUALIZADO: ");
		String dado= sc.nextLine();
		System.out.print("NOVO VALOR DO DADO: ");
		String novoValor = sc.nextLine();
		
		
		System.out.println(System.lineSeparator() + sistema.atualizarUsuario(id, dado, novoValor) + System.lineSeparator());
		
	}

}
