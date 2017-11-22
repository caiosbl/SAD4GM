package interfaceSistema;

import java.util.Scanner;
/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES 
 * SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */

import sistema.Sistema;

public class FuncoesInterfaceUsuario {

	public static String opcoes() {
		String opcoes = "SELECIONE UMA OPÇÃO: " + System.lineSeparator() + "1 - CADASTRAR UM USUÁRIO"
				+ System.lineSeparator() + "2 - ATUALIZAR UM USUÁRIO" + System.lineSeparator()
				+ "3 - REMOVER UM USUÁRIO" + System.lineSeparator() + "4 - BUSCAR UM USUÁRIO" + System.lineSeparator()
				+ "5 - LISTAR USUÁRIOS" + System.lineSeparator() + "6 - SAIR" + System.lineSeparator();

		return opcoes;
	}

	public static void selectOpcao(String opcao, Sistema sistema) {

		switch (opcao) {
		case "1":
			cadastraUsuario(sistema);
			break;
		case "2":
			//atualizaUsuario(sistema);
			break;
		case "3":
			removeUsuario(sistema);
			break;
		case "4":
			buscaUsuario(sistema);
			break;
		case "5":
			System.out.println(sistema.listarUsuarios());
			break;
		case "6":
			break;
		default:
			System.out.println(System.lineSeparator() + "OPÇÃO INVÁLIDA " + System.lineSeparator());
			break;
		}
	}

	public static void cadastraUsuario(Sistema sistema) {
		System.out.println("CADASTRAR UM USUÁRIO" + System.lineSeparator());
		Scanner sc = new Scanner(System.in);
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("ID: ");
		String id = sc.nextLine();
		System.out.print("Senha: ");
		String senha = sc.nextLine();
		System.out.print("Auditor: ");
		String auditor = sc.nextLine();

		System.out
				.println(System.lineSeparator() + sistema.cadastrarUsuario(nome, id,senha, auditor) + System.lineSeparator());

	}

	

	public static void removeUsuario(Sistema sistema) {
		System.out.println("REMOVER UM USUÁRIO " + System.lineSeparator());

		System.out.print("ID DO USUÁRIO: ");
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();

		System.out.println(System.lineSeparator() + sistema.removerUsuario(id) + System.lineSeparator());

	}

	public static void buscaUsuario(Sistema sistema) {
		Scanner sc = new Scanner(System.in);
		System.out.println("BUSCAR USUÁRIO" + System.lineSeparator());
		System.out.print("ID DO USUÁRIO: ");

		String id = sc.nextLine();
		System.out.println(System.lineSeparator() + sistema.getInfoUsuario(id) + System.lineSeparator());
	}
}
