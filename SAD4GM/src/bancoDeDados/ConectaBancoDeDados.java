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

	private boolean isConnected = false;
	private Connection conn = null;

	public boolean conectaDataBase() {
		boolean status = false;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

			conn = DriverManager
					.getConnection("jdbc:derby:Sad4gmDatabase;create=true;user=caiosanches;password=mengohexa");
			status = true;
			isConnected = true;

		} catch (ClassNotFoundException | SQLException Err) {
			status = false;
		}

		try {
			if (conn == null) {
				conn = DriverManager.getConnection("jdbc:derby:.\\Sad4gmDatabase;create=true;");
				status = true;
				isConnected = true;
			}

			createDB(conn);
			populateDB(conn);

			conn.close();

		} catch (Exception Err) {
			status = false;
		}
		return status;
	}

	public boolean desconectaDataBase() throws SQLException {
		if (!isConnected) {
			return false;
		}
		try {
			conn.close();
			isConnected = false;
			return true;
		} catch (Exception e) {
			return false;
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