package interfaceSistema;

import java.sql.SQLException;
import java.util.Scanner;

import sistema.Sistema;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */

// Provisório
public class Main {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);

		Sistema sistema = new Sistema();
		String entrada = "";

		do {
			System.out.println(opcoesGerais());
			System.out.print("OPÇÃO: ");
			entrada = sc.nextLine();
			System.out.println();
			selectOpcao(sistema, entrada);

		} while (!entrada.equals("4"));

		sc.close();
	}

	public static String opcoesGerais() {
		String quebraLinha = System.lineSeparator();
		String opcoes = quebraLinha + "SELECIONE UMA OPÇÃO: " + quebraLinha + "1 - OPÇÕES DE USUÁRIO" + quebraLinha
				+ "2 - OPÇÕES DE MÁQUINAS" + quebraLinha + "3 - OPÇÕES DE ADMIN" + quebraLinha + "4 - SAIR"
				+ quebraLinha;

		return opcoes;
	}

	public static void selectOpcao(Sistema sistema, String opcaoPrimaria) throws SQLException {
		switch (opcaoPrimaria) {
		case "1":
			Scanner sc = new Scanner(System.in);
			System.out.println(FuncoesInterfaceUsuario.opcoes());
			System.out.print("OPÇÃO: ");
			String opcaoSecundaria = sc.nextLine();
			FuncoesInterfaceUsuario.selectOpcao(opcaoSecundaria, sistema);

			break;

		case "2":
			sc = new Scanner(System.in);
			System.out.println(FuncoesInterfaceMaquina.opcoes());
			System.out.print("OPÇÃO: ");
			opcaoSecundaria = sc.nextLine();
			FuncoesInterfaceMaquina.selectOpcao(opcaoSecundaria, sistema);
			break;

		case "3":
			sc = new Scanner(System.in);
			System.out.println(FuncoesInterfaceAdmin.opcoes());
			System.out.print("OPÇÃO: ");
			opcaoSecundaria = sc.nextLine();
			FuncoesInterfaceAdmin.selectOpcao(opcaoSecundaria, sistema);
			break;
		case "4":
			break;

		default:
			System.out.println("OPÇÃO INVÁLIDA!" + System.lineSeparator());
			break;
		}
	}

}
