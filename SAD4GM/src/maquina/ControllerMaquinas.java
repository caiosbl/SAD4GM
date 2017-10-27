package maquina;

import java.util.HashMap;
import java.util.Map;

import javax.management.RuntimeErrorException;

import maquina.enums.AtributosMaquina;
import usuario.Usuario;
import usuario.enums.AtributosUsuario;

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
		validaCodigo(codigo);

		Maquina maquina = mapaDeMaquinas.get(codigo);

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
			break;

		case DESCRIÇÃO:
			break;

		default:
			break;
		}
	}

}
