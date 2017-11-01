package interfaceSistema;

import java.util.Scanner;

import sistema.Sistema;

public class FuncoesInterfaceMaquina {
	public static String opcoes() {
		String opcoes = "SELECIONE UMA OPÇÃO: " + System.lineSeparator() + "1 - CADASTRAR UMA MÁQUINA"
				+ System.lineSeparator() + "2 - ATUALIZAR UMA MÁQUINA" + System.lineSeparator()
				+ "3 - REMOVER UMA MÁQUINA" + System.lineSeparator() + "4 - BUSCAR UMA MÁQUINA" + System.lineSeparator()
				+ "5 - SAIR" + System.lineSeparator();

		return opcoes;
	}

	public static void selectOpcao(String opcao, Sistema sistema) {
		switch (opcao) {
		case "1":
			cadastraMaquina(sistema);
			break;
		case "2":
			atualizaMaquina(sistema);
			break;
		case "3":
			removeMaquina(sistema);
			break;
		case "4":
			buscaMaquina(sistema);
			break;
		default:
			System.out.println(System.lineSeparator() + "OPÇÃO INVÁLIDA " + System.lineSeparator());
			break;
		}
	}

	public static void cadastraMaquina(Sistema sistema) {
		System.out.println("CADASTRAR UMA MÁQUINA" + System.lineSeparator());
		Scanner sc = new Scanner(System.in);
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Código: ");
		String codigo = sc.nextLine();
		System.out.print("Descrição: ");
		String descricao = sc.nextLine();

		System.out.println(
				System.lineSeparator() + sistema.adicionaMaquina(nome, codigo, descricao) + System.lineSeparator());

	}

	public static void atualizaMaquina(Sistema sistema) {
		System.out.println("ATUALIZAR UMA MÁQUINA " + System.lineSeparator());

		Scanner sc = new Scanner(System.in);
		System.out.print("CÓDIGO DA MÁQUINA: ");
		String codigo = sc.nextLine();
		System.out.print("DADO A SER ATUALIZADO [NOME,CÓDIGO,DESCRIÇÃO]: ");
		String dado = sc.nextLine();
		System.out.print("NOVO VALOR DO DADO: ");
		String novoValor = sc.nextLine();

		System.out.println(
				System.lineSeparator() + sistema.atualizarMaquina(codigo, dado, novoValor) + System.lineSeparator());
	}

	public static void removeMaquina(Sistema sistema) {
		System.out.println("REMOVER UMA MÁQUINA " + System.lineSeparator());

		System.out.print("CÓDIGO DA MÁQUINA: ");
		Scanner sc = new Scanner(System.in);
		String codigo = sc.nextLine();

		System.out.println(System.lineSeparator() + sistema.removerMaquina(codigo) + System.lineSeparator());

	}

	public static void buscaMaquina(Sistema sistema) {
		Scanner sc = new Scanner(System.in);
		System.out.println("BUSCAR MÁQUINA" + System.lineSeparator());
		System.out.print("CÓDIGO DA MÁQUINA: ");

		String codigo = sc.nextLine();
		System.out.println(System.lineSeparator() + sistema.buscarDadosMaquina(codigo) + System.lineSeparator());
	}

}
