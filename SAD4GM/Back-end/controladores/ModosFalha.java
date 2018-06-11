package controladores;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import databaseTools.ModosFalhaTools;

public class ModosFalha {
	
	private ModosFalhaTools mFTools;
	
	public ModosFalha(ModosFalhaTools mFTools) {
		this.mFTools = new ModosFalhaTools();
	}
	
	public String inserir(String descricao, int chaveFalha) {

		String status;

		try {
			mFTools.inserir( descricao, chaveFalha);
			status = "Modo de Falha inserido com Sucesso!";
		} catch (SQLException e) {
			status = e.getMessage();
		}

		return status;

	}

	public Map<String, Integer> getMapaModosFalha(int chaveFalha) {

		try {
			return mFTools.getMapaModosFalha(chaveFalha);
		} catch (SQLException e) {
			return new HashMap<String, Integer>();
		}

	}

}
