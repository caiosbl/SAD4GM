package controladores;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import databaseTools.ModosFalhaTools;
import entidades.ModoFalha;

public class ModosFalha {

	private ModosFalhaTools mFTools;

	public ModosFalha(ModosFalhaTools mFTools) {
		this.mFTools = new ModosFalhaTools();
	}

	public String inserir(String nome, String descricao, int chaveFalha) {

		String status;

		try {
			mFTools.inserir(nome, descricao, chaveFalha);
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

	public Map<Integer, ModoFalha> getModosFalhaMap(int chaveFalha) {
		try {
			return mFTools.getModosFalhaMap(chaveFalha);
		} catch (SQLException e) {
			return new HashMap<Integer, ModoFalha>();
		}
	}

	public String getDescricao(int chaveModoFalha) {
		String descricao;

		try {
			descricao = mFTools.getDescricaoModoFalha(chaveModoFalha);
		} catch (SQLException e) {
			e.printStackTrace();
			descricao = "Falha na Conexão com Banco de Dados!";
		}
		return descricao;
	}

	public String setDescricao(String descricao, int chaveModoFalha) {
		String status;

		try {
			mFTools.setDescricaoModoFalha(descricao, chaveModoFalha);
			status = "Descrição atualizada com Sucesso!";
		} catch (Exception e) {
			status = "Falha ao Atualizar Descrição!";
		}

		return status;
	}

	public String remover(int chave) {
		String status;

		try {
			mFTools.deletar(chave);
			status = "Modo de Falha removido com sucesso!";
		} catch (Exception e) {
			status = e.getMessage();
		}

		return status;
	}

}
