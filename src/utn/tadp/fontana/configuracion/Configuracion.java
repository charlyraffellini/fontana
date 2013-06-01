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
	private Map<String,List<Solicitud>> listasDeSolicitud = new HashMap<String,List<Solicitud>>();
	
	@SuppressWarnings("unchecked")
	public void setBeanLike(String beanName, Compleja interesado, String property){
		Compleja pedido = this.beans.get(beanName);
		if(pedido == null) this.agregarSolicitud(beanName, new Solicitud(interesado, property));
		else interesado.addDependencia(beanName, pedido);
	}
	
	public void addBean(String beanName, Compleja bean){
		this.beans.put(beanName, bean);
		List<Solicitud> solicitudes = this.listasDeSolicitud.get(beanName);
		if(solicitudes != null){
			for(Solicitud solicitud : solicitudes){
				solicitud.getBean().addDependencia(solicitud.getProperty(), bean);
			}
		}
	}
	
	private void agregarSolicitud(String beanName, Solicitud solicitud) {
		List<Solicitud> solicitudes = this.listasDeSolicitud.get(beanName);
		if (solicitudes == null) solicitudes = this.nuevaListaInteresados(beanName); 
		solicitudes.add(solicitud);
	}

	private List<Solicitud> nuevaListaInteresados(String beanName) {
		List<Solicitud> solicitudes = new ArrayList<Solicitud>();
		this.listasDeSolicitud.put(beanName, solicitudes);
		return solicitudes;
	}

	public Dependencia getDependencia(Compleja comp){
		//Buscar en el map y pedirle la dependencia al bean que va a tener el
		//mismo nombre que el que paso por parametro
		//*****comp y el bean que encuentre en el map no son el mismo objeto
		//*****solo tienen el mismo name
		return null;
	}
}
