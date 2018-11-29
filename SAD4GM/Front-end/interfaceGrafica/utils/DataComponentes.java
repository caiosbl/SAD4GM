package interfaceGrafica.utils;

import java.util.ArrayList;
import entidades.Componente;
import entidades.Subsistema;

public class DataComponentes {

	private Subsistema subsistema;
	private ArrayList<Componente> componentes;

	public DataComponentes(Subsistema subsistema, ArrayList<Componente> componentes) {
		this.subsistema = subsistema;
		this.componentes = componentes;

	}

	public Subsistema getSubsistema() {
		return subsistema;
	}

	public void setSubsistema(Subsistema subsistema) {
		this.subsistema = subsistema;
	}

	public ArrayList<Componente> getComponentes() {
		return componentes;
	}

	public void setComponentes(ArrayList<Componente> componentes) {
		this.componentes = componentes;
	}

}
