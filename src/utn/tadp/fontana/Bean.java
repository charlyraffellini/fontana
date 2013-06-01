package utn.tadp.fontana;

import utn.tadp.fontana.configuracion.Configuracion;

public class Bean<T extends Object> extends Dependencia<T>{
	
	String name;
	Configuracion config;
	
	public Bean(String n, Configuracion config){
		super();
		this.config = config;
		this.name = n;
	}

	@Override
	public T getValue() {
		return (T) config.getDependencia(this.name).getValue();
	}
	
	@Override
	public Class<T> getDepClass() {
		return config.getDependencia(this.name).getDepClass();
	}
}
