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
	public static void cadastraMaquina(Sistema sistema) {
		System.out.println("CADASTRAR UMA MÁQUINA" + System.lineSeparator());
		Scanner sc = new Scanner(System.in);
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Código: ");
		String codigo = sc.nextLine();
		System.out.print("Descrição: ");
		String descricao = sc.nextLine();

		System.out
				.println(System.lineSeparator() + sistema.adicionaMaquina(nome, codigo, descricao) + System.lineSeparator());

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

}
