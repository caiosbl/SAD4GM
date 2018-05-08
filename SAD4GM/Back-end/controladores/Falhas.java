package controladores;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import databaseTools.FalhaTools;

public class Falhas {

	private FalhaTools fTools;

	public Falhas(FalhaTools fTools) {
		this.fTools = new FalhaTools();
	}

	public String inserir(String nome, String descricao, int chaveComponente) {

		String status;

		try {
			fTools.inserir(nome, descricao, chaveComponente);
			status = "Falha inserida com Sucesso!";
		} catch (SQLException e) {
			status = e.getMessage();
		}

		return status;

	}

	public Map<String, Integer> getMapaFalhas() {

		try {
			return fTools.getMapaFalhas();
		} catch (SQLException e) {
			return new HashMap<String, Integer>();
		}

	}

}
