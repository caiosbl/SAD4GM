package interfaceSistema;

import java.sql.SQLException;
import java.util.Scanner;

import sistema.Sistema;

public class FuncoesInterfaceAdmin {
	public static String opcoes() {

		String quebraLinha = System.lineSeparator();
		String opcoes = "SELECIONE UMA OPÇÃO: " + quebraLinha + "1 - CADASTRAR UM ADMIN" + quebraLinha
				+ "2 - ATUALIZAR NOME" + quebraLinha + "3 - Atualizar ID" + quebraLinha + "4 - Remover um Admin"
				+ quebraLinha + "5 - LISTAR Admin" + quebraLinha + "6 - SAIR" + quebraLinha
				+ "7 - Valida Usuário e Senha" + quebraLinha;

		return opcoes;
	}

	public static void selectOpcao(String opcao, Sistema sistema) throws SQLException {

		switch (opcao) {
		case "1":
			cadastrarAdmin(sistema);
			;
			break;
		case "2":
			break;

		default:
			System.out.println(System.lineSeparator() + "OPÇÃO INVÁLIDA " + System.lineSeparator());
			break;
		}
	}

	public static void cadastrarAdmin(Sistema sistema) throws SQLException {

		Scanner sc = new Scanner(System.in);
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("ID: ");
		String id = sc.nextLine();
		System.out.print("Senha: ");
		String senha = sc.nextLine();

		System.out.println(System.lineSeparator() + sistema.inserirAdmin(nome, senha, id) + System.lineSeparator());

	}
}
