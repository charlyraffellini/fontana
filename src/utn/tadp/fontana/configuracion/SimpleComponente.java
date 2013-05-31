package utn.tadp.fontana.configuracion;

import utn.tadp.fontana.Dependencia;
import utn.tadp.fontana.Primitiva;

public class SimpleComponente extends Componente {

	private Object value;
	private Class<?> cClass;
	
	public SimpleComponente(Class<?> cClass, Object o){
		this.cClass = cClass;
		this.value = o;
	}
	@Override
	protected Dependencia createDependencia() {
		return new Primitiva(this.cClass, value);
	}

	public void setClass(Class<?> cClass){
		this.cClass = cClass;
	}
	

}
