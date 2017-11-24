package interfaceSistema;

import java.sql.SQLException;
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
				+ "2 - ATUALIZAR NOME" + quebraLinha + "3 - Atualizar ID" + quebraLinha + "4 - Remover um Usuário"
				+ quebraLinha + "5 - LISTAR USUÁRIOS" + quebraLinha + "6 - SAIR" + quebraLinha + "7 - Valida Usuário e Senha"
				+ quebraLinha;

		return opcoes;
	}

	public static void selectOpcao(String opcao, Sistema sistema) throws SQLException {

		switch (opcao) {
		case "1":
			cadastraUsuario(sistema);
			break;
		case "2":
			atualizarNome(sistema);
			break;
		case "3":
			atualizarId(sistema);
			break;
		case "4":
			removeUsuario(sistema);
			break;
		case "5":
			System.out.println(sistema.listarUsuarios());
			break;
		case "6":
			break;
			
		case "7":
			valida(sistema);
			break;
		default:
			System.out.println(System.lineSeparator() + "OPÇÃO INVÁLIDA " + System.lineSeparator());
			break;
		}
	}

	public static void cadastraUsuario(Sistema sistema) throws SQLException {
		System.out.println("CADASTRAR UM USUÁRIO" + System.lineSeparator());
		
		System.out.println(System.lineSeparator());
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Id do Admin: ");
		String idAdmin = sc.nextLine();
		System.out.println("Senha do Admin: ");
		String senhaAdmin = sc.nextLine();
		
		if(sistema.autenticaAdmin(idAdmin, senhaAdmin)) {
		
		
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
		else {
			System.out.println("Usuário ou Senha Inválidos!");
		}

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
	
	public static void atualizarId(Sistema sistema) {

		Scanner sc = new Scanner(System.in);
		System.out.println("AtualizarID" + System.lineSeparator());
		System.out.print("ID DO USUÁRIO: ");
		String id = sc.nextLine();
		System.out.print("NOVO ID DO USUÁRIO: ");
		String novoId = sc.nextLine();
		System.out.println(System.lineSeparator() + sistema.setIdUsuario(id, novoId) + System.lineSeparator());

	}
	
	public static void valida(Sistema sistema) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Valida Usuário e Senha" + System.lineSeparator());
		System.out.print("ID DO USUÁRIO: ");
		String id = sc.nextLine();
		System.out.print("Senha: ");
		String senha = sc.nextLine();
		System.out.println(System.lineSeparator() + sistema.validaIdAndSenhaUsuario(id, senha) + System.lineSeparator());
	}
}
