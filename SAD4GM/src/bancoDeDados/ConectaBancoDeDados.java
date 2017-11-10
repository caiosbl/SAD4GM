package bancoDeDados;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.derby.tools.ij;

import java.sql.*;

public class ConectaBancoDeDados {

	public static void main(String[] args) {
		Connection conn = null;

		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

			conn = DriverManager
					.getConnection("jdbc:derby:Sad4gmDatabase;create=true;user=caiosanches;password=mengohexa");
			System.out.println("Conectado com sucesso...");

		} catch (ClassNotFoundException | SQLException Err) {
			System.out.println("Erro ao tentar conectar em Bando de dados localdb... " + Err);
		}

		// PROXIMO PASSO COM ERRO OU NÃO..

		try {
			if (conn == null) {
				System.out.println("Criando bando de dados local...");
				conn = DriverManager.getConnection("jdbc:derby:.\\Sad4gmDatabase;create=true;");
			}

			Statement sql = conn.createStatement();

			System.out.println("Banco de dados LocalDB criado com sucesso...");

			/*
			 * DAKI PRA BAIXO ANTES DE close() PODE MANIPULAR TODO O DERBY EM SQL
			 * sql.executeUpdate("CREATE/INSERT/DELETE/ETC..."); PARA EXECUTAR COMANDOS QUE
			 * ATUALIZEM A TABELA sql.executeQuery("SELECT..."); PARA OBTER DADOS DA TABELA
			 * E IMPRIMIR A MATRIZ EM UM LOOPING
			 */
			
			createDB(conn);
			populateDB(conn);

			conn.close();

		} catch (Exception Err) {
			System.out.println("Ocorreu um erro. " + Err);
		}
	}

	private static boolean createDB(Connection conn) {
		FileInputStream fileStream = null;
		try {
			fileStream = new FileInputStream("./scripts/create.sql");
			int result = ij.runScript(conn, fileStream, "UTF-8", System.out, "UTF-8");
			System.out.println("Result code is: " + result);
			if (result == 1) {
				return true;
			} else {
				return false;
			}
		} catch (FileNotFoundException e) {
			return false;
		} catch (UnsupportedEncodingException e) {
			return false;
		} finally {
			if (fileStream != null) {
				try {
					fileStream.close();
				} catch (IOException e) {
				}
			}
		}
	}

	private static boolean populateDB(Connection conn) {
		FileInputStream fileStream = null;
		try {
			fileStream = new FileInputStream("./scripts/populate.sql");
			int result = ij.runScript(conn, fileStream, "UTF-8", System.out, "UTF-8");
			System.out.println("Result code is: " + result);
			if (result == 1) {
				return true;
			} else {
				return false;
			}
		} catch (FileNotFoundException e) {
			return false;
		} catch (UnsupportedEncodingException e) {
			return false;
		} finally {
			if (fileStream != null) {
				try {
					fileStream.close();
				} catch (IOException e) {
				}
			}
		}
	}
}