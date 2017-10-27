package maquina;

import java.util.HashMap;
import java.util.Map;

import javax.management.RuntimeErrorException;

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
		if(mapaDeMaquinas.containsKey(codigo)) {
			throw new RuntimeErrorException(null, "MÁQUINA NÃO CADASTRADA!");
		}
	}
	
	public void adicionaMaquina(String nome, int codigo, String descricao) {
		verificaCodigo(codigo);
		Maquina maquina = new Maquina(nome, codigo, descricao);
		mapaDeMaquinas.put(maquina.getCodigo(), maquina);
	}

}
