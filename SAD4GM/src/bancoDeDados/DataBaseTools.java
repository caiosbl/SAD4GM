package bancoDeDados;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.derby.tools.ij;

public class DataBaseTools {

	private Connection con;

	public void criaConexao() {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con = DriverManager.getConnection("jdbc:derby:Sad4gmDatabase");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void fechaConexao() {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static boolean criaTabelas(Connection conn) {
		FileInputStream fileStream = null;
		try {
			fileStream = new FileInputStream("./scripts/create.sql");
			int result = ij.runScript(conn, fileStream, "UTF-8", System.out, "UTF-8");
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

	public void inserirUsuario(String nome, String id, String auditor) {
		criaConexao();
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO sad4gm.usuario (nome,id,senha,auditor) VALUES (" + nome +"," + id +","+auditor+")");

			int result = ps.executeUpdate();

			if (result > 0) {
				System.out.println("Data Inserted");
			} else {
				System.out.println("Something happened");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fechaConexao();
		}
	}

}