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
		System.out.println(opcoes());
		Sistema sistema = new Sistema ();
		cadastraUsuario(sistema);
	}
	
	
	public static void selectOpcao(String opcao,Sistema sistema) {
		switch (opcao) {
		case "1":
			cadastraUsuario(sistema);
			break;
		case "2":
			

		default:
			break;
		}
	}

	public static String opcoes() {
		String opcoes = "SELECIONE UMA OPÇÃO: " + System.lineSeparator() + "1 - CADASTRAR UM USUÁRIO"
				+ System.lineSeparator() + "2 - ATUALIZAR UM USUÁRIO" + System.lineSeparator()
				+ "3 - REMOVER UM USUÁRIO" + System.lineSeparator() + "4 - BUSCAR UM USUÁRIO" +
				System.lineSeparator();

		return opcoes;
	}

	public static  void cadastraUsuario(Sistema sistema) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("ID: ");
		String id = sc.nextLine();
		System.out.print("Auditor: ");
		String auditor = sc.nextLine();
		sc.close();

		System.out.println( sistema.cadastrarUsuario(nome, id, auditor));

	}

}
