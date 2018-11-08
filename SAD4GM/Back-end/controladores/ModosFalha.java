package controladores;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import databaseTools.ModosFalhaTools;
import entidades.ModoFalha;

public class ModosFalha {

	private ModosFalhaTools mFTools;

	public ModosFalha(ModosFalhaTools mFTools) {
		this.mFTools = mFTools;
	}

	public String inserir(String nome, String descricao, int chaveFalha, double indiceOcorrencia,
			double indiceDeteccao) {

		String status;

		try {
			mFTools.inserir(nome, descricao, chaveFalha, indiceOcorrencia, indiceDeteccao);
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
	
	public Map<String, Integer> getMapaModosFalhaPorMaquina(int chaveMaquina) throws SQLException {

		try {
			return mFTools.getMapaModosFalhaPorMaquina(chaveMaquina);
		} catch (Exception e) {
	
			throw new SQLException("Falha na Conexão com o Banco de Dados!");
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
			descricao = "Falha na Conexão com Banco de Dados!";
		}
		return descricao;
	}

	public String getNome(int chaveModoFalha) {
		String nome;

		try {
			nome = mFTools.getNomeModoFalha(chaveModoFalha);
		} catch (SQLException e) {
			nome = "Falha na Conexão com Banco de Dados!";
		}
		return nome;
	}

	public double getIndiceOcorrencia(int chaveModoFalha) {
		double indiceOcorrencia;

		try {
			indiceOcorrencia = mFTools.getIndiceOcorrencia(chaveModoFalha);
		} catch (SQLException e) {
			indiceOcorrencia = -1;
		}
		return indiceOcorrencia;
	}

	public double getIndiceDeteccao(int chaveModoFalha) {
		double indiceDeteccao;

		try {
			indiceDeteccao = mFTools.getIndiceDeteccao(chaveModoFalha);
		} catch (SQLException e) {
			indiceDeteccao = -1;
		}
		return indiceDeteccao;
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

	public String setNome(String nome, int chaveModoFalha) {
		String status;

		try {
			mFTools.setNomeModoFalha(nome, chaveModoFalha);
			status = "Título atualizado com Sucesso!";
		} catch (Exception e) {
			status = "Falha ao Atualizar Título!";
		}

		return status;
	}

	public String setIndiceOcorrencia(double indiceOcorrencia, int chaveModoFalha) {
		String status;

		try {
			mFTools.setIndiceOcorrencia(indiceOcorrencia, chaveModoFalha);
			status = "Indíce de Ocorrência atualizado com Sucesso!";
		} catch (Exception e) {
			status = "Falha ao Atualizar Indíce de Ocorrência!";
		}

		return status;
	}

	public String setIndiceDeteccao(double indiceDeteccao, int chaveModoFalha) {
		String status;

		try {
			mFTools.setIndiceOcorrencia(indiceDeteccao, chaveModoFalha);
			status = "Indíce de Detecção atualizado com Sucesso!";
		} catch (Exception e) {
			status = "Falha ao Atualizar Indíce de Detecção!";
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
	
	public String registrarOcorrencia(int chave) {
		String status;
		
		try {
			mFTools.registrarOcorrencia(chave);
			status = "Ocorrência Registrada com Sucesso!";
		} catch (SQLException e) {
			status = e.getMessage();
		
		}
		
		return status;
	}

}
