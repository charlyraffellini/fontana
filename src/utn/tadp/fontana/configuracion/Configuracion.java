package utn.tadp.fontana.configuracion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utn.tadp.fontana.Compleja;
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
@SuppressWarnings("rawtypes")
public class Configuracion {

	private Map<String,Compleja> beans = new HashMap<String,Compleja>();
	
	public void addBean(String beanName, Compleja bean){
		this.beans.put(beanName, bean);
	}

	public Dependencia getDependencia(String name){
		return this.beans.get(name);
	}
}
