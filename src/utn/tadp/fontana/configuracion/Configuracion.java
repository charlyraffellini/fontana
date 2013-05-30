package utn.tadp.fontana.configuracion;

import java.util.HashMap;
import java.util.Map;

import utn.tadp.fontana.Dependencia;

/**
 * Donfiguración va a tener una lista de Componentes a los cuales les corresponde un BeanName
 * Y además una lista de interesados para cada Componente que todavía no se agregó a la lista oficial
 * Entonces cuando se agrega un nuevo Componente a la lista oficial se revisa si no hay interesados
 * que lo necesiten, si es así se les manda el componente
 * Si al final de la construccion quedan interesados por algun componente significa que hay algun error
 * y se puede avisar de esta anomalia al usuario
 * 
 * Lista de componentes encontrados por el reader: <String BeanName, Componente>
 * Listas de componentes interesados en un componente no creado: <String FutureBeanName, ListaDeInteresadosASettearle<Componentes>>
 * 
 * 
 * @author charly
 *
 */
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
