package interfaceUsuario;

import java.util.Scanner;

import sistema.Sistema;

public class FuncoesInterfaceUsuario {
	public static String opcoes() {
		String opcoes = "SELECIONE UMA OPÇÃO: " + System.lineSeparator() + "1 - CADASTRAR UM USUÁRIO"
				+ System.lineSeparator() + "2 - ATUALIZAR UM USUÁRIO" + System.lineSeparator()
				+ "3 - REMOVER UM USUÁRIO" + System.lineSeparator() + "4 - BUSCAR UM USUÁRIO" + System.lineSeparator()
				+ "5 - SAIR" + System.lineSeparator();

		return opcoes;
	}

	public static void cadastraUsuario(Sistema sistema) {
		System.out.println("CADASTRAR UM USUÁRIO" + System.lineSeparator());
		Scanner sc = new Scanner(System.in);
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("ID: ");
		String id = sc.nextLine();
		System.out.print("Auditor: ");
		String auditor = sc.nextLine();

		System.out
				.println(System.lineSeparator() + sistema.cadastrarUsuario(nome, id, auditor) + System.lineSeparator());

	}

	public static void atualizaUsuario(Sistema sistema) {
		System.out.println("ATUALIZAR UM USUÁRIO " + System.lineSeparator());

		Scanner sc = new Scanner(System.in);
		System.out.print("ID DO USUÁRIO: ");
		String id = sc.nextLine();
		System.out.print("DADO A SER ATUALIZADO [NOME,ID,AUDITOR]: ");
		String dado = sc.nextLine();
		System.out.print("NOVO VALOR DO DADO: ");
		String novoValor = sc.nextLine();

		System.out.println(
				System.lineSeparator() + sistema.atualizarUsuario(id, dado, novoValor) + System.lineSeparator());

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
		System.out.println(System.lineSeparator() + sistema.buscaDadosUsuario(id) + System.lineSeparator());
	}
}