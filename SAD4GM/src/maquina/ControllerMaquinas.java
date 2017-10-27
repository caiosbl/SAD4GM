package maquina;

import java.util.HashMap;
import java.util.Map;

/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - LABORATÓRIO DESIDES SISTEMA SAD4GM
 * 
 * @author caiosbl
 *
 */

public class ControllerMaquinas {

	private Map<String, Maquina> mapaDeMaquinas;

	public ControllerMaquinas() {
		this.mapaDeMaquinas = new HashMap<>();
	}
	
	public void adicionaMaquina() {
		Maquina maquina = new Maquina();
		mapaDeMaquinas.put("Nome", maquina);
	}

}
