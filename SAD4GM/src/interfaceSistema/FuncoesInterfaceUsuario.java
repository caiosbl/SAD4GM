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

		String quebraLinha = System.lineSeparator();
		String opcoes = "SELECIONE UMA OPÇÃO: " + quebraLinha + "1 - CADASTRAR UM USUÁRIO" + quebraLinha
				+ "2 - ATUALIZAR NOME" + quebraLinha + "3 - REMOVER UM USUÁRIO" + quebraLinha + "4 - BUSCAR UM USUÁRIO"
				+ quebraLinha + "5 - LISTAR USUÁRIOS" + quebraLinha + "6 - SAIR" + quebraLinha;

		return opcoes;
	}

	public static void selectOpcao(String opcao, Sistema sistema) {

		switch (opcao) {
		case "1":
			cadastraUsuario(sistema);
			break;
		case "2":
			atualizarNome(sistema);
			break;
		case "3":
			removeUsuario(sistema);
			break;
		case "4":
			getInfoUsuario(sistema);
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

		System.out.println(
				System.lineSeparator() + sistema.cadastrarUsuario(nome, id, senha, auditor) + System.lineSeparator());

	}

	public static void removeUsuario(Sistema sistema) {
		System.out.println("REMOVER UM USUÁRIO " + System.lineSeparator());

		System.out.print("ID DO USUÁRIO: ");
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();

		System.out.println(System.lineSeparator() + sistema.removerUsuario(id) + System.lineSeparator());

	}

	public static void getInfoUsuario(Sistema sistema) {
		Scanner sc = new Scanner(System.in);
		System.out.println("BUSCAR USUÁRIO" + System.lineSeparator());
		System.out.print("ID DO USUÁRIO: ");

		String id = sc.nextLine();
		System.out.println(System.lineSeparator() + sistema.getInfoUsuario(id) + System.lineSeparator());
	}

	public static void atualizarNome(Sistema sistema) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Atualizar Nome" + System.lineSeparator());
		System.out.print("ID DO USUÁRIO: ");
		String id = sc.nextLine();
		System.out.print("NOVO NOME DO USUÁRIO: ");
		String nome = sc.nextLine();
		System.out.println(System.lineSeparator() + sistema.setNomeUsuario(id, nome) + System.lineSeparator());

	}
}
