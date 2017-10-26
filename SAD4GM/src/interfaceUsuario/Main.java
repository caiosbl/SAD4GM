package interfaceUsuario;

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

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Sistema sistema = new Sistema();
		String entrada = "";

		do {
			System.out.println(FuncoesInterfaceUsuario.opcoes());
			System.out.print("OPÇÃO: ");
			entrada = sc.nextLine();
			selectOpcao(entrada, sistema);

		} while (!entrada.equals("5"));
	}

	public static void selectOpcao(String opcao, Sistema sistema) {
		switch (opcao) {
		case "1":
			FuncoesInterfaceUsuario.cadastraUsuario(sistema);
			break;
		case "2":
			FuncoesInterfaceUsuario.atualizaUsuario(sistema);
			break;
		case "3":
			FuncoesInterfaceUsuario.removeUsuario(sistema);
			break;
		case "4":
			FuncoesInterfaceUsuario.buscaUsuario(sistema);
			break;
		default:
			System.out.println(System.lineSeparator() + "OPÇÃO INVÁLIDA " + System.lineSeparator());
			break;
		}
	}

}
