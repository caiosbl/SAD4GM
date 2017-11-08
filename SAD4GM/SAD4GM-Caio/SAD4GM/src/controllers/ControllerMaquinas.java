package controllers;

import java.util.HashMap;
import java.util.Map;
import javax.management.RuntimeErrorException;

import maquina.Maquina;
import maquina.enums.AtributosMaquina;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */

public class ControllerMaquinas {

	private Map<Integer, Maquina> mapaDeMaquinas;

	public ControllerMaquinas() {
		this.mapaDeMaquinas = new HashMap<>();
	}

	private void verificaCodigo(int codigo) {
		if (mapaDeMaquinas.containsKey(codigo)) {
			throw new RuntimeErrorException(null, "CÓDIGO DE MÁQUINA JÁ CADASTRADA!");
		}
	}

	private void validaCodigo(int codigo) {
		if (!mapaDeMaquinas.containsKey(codigo)) {
			throw new RuntimeErrorException(null, "MÁQUINA NÃO CADASTRADA!");
		}
	}

	public void adicionaMaquina(String nome, int codigo, String descricao) {
		verificaCodigo(codigo);
		Maquina maquina = new Maquina(nome, codigo, descricao);
		mapaDeMaquinas.put(maquina.getCodigo(), maquina);
	}

	public void removerMaquina(int codigo) {
		validaCodigo(codigo);
		mapaDeMaquinas.remove(codigo);
	}

	public void atualizarMaquina(int codigo, String dado, String novoValor) {
		Maquina maquina = buscaMaquina(codigo);
		final AtributosMaquina atributo;

		try {
			atributo = AtributosMaquina.valueOf(dado.toUpperCase());
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("DADO A SER ATUALIZADO INVÁLIDO!");
		}

		switch (atributo) {
		case NOME:
			maquina.setNome(novoValor);

			break;
		case CÓDIGO:
			Maquina maquinaTemporaria = maquina;
			int novoCodigo;
			try {
				novoCodigo = Integer.parseInt(novoValor);
			} catch (Exception e) {
				throw new IllegalArgumentException("NOVO CÓDIGO INVÁLIDO");
			}

			maquinaTemporaria.setCodigo(novoCodigo);
			mapaDeMaquinas.remove(codigo);
			mapaDeMaquinas.put(maquinaTemporaria.getCodigo(), maquinaTemporaria);
			break;

		case DESCRIÇÃO:
			maquina.setDescricao(novoValor);
			break;

		}
	}

	public Maquina buscaMaquina(int codigo) {
		validaCodigo(codigo);
		return mapaDeMaquinas.get(codigo);
	}

	public String listaMaquinas() {
		String quebraLinha = System.lineSeparator();
		String listagem = "MÁQUINAS CADASTRADAS: " + quebraLinha;

		for (Integer chave : mapaDeMaquinas.keySet()) {
			listagem += quebraLinha;
			listagem += mapaDeMaquinas.get(chave).toString();
			listagem += quebraLinha;
		}

		return listagem;

	}

}
