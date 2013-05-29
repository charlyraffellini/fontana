package utn.tadp.fontana.configuracion;

import java.util.HashMap;
import java.util.Map;

import utn.tadp.fontana.Dependencia;

public class Configuracion {

	private Reader reader;
	private Map<String,Bean> beans = new HashMap<String,Bean>();
	
	public Dependencia getDependencia(Bean comp){
		//Buscar en el map y pedirle la dependencia al bean que va a tener el
		//mismo nombre que el que paso por parametro
		//*****comp y el bean que encuentre en el map no son el mismo objeto
		//*****solo tienen el mismo name
		return null;
	}
}
