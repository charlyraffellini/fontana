package utn.tadp.fontana.configuracion;

import utn.tadp.fontana.Compleja;

public class Solicitud<T extends Object> {

	private Compleja<T> bean;
	private String property;
	
	public Solicitud(Compleja<T> b, String property){
		this.bean = b;
		this.property = property;
	}

	public Compleja<T> getBean() {
		return bean;
	}

	public void setBean(Compleja<T> bean) {
		this.bean = bean;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}
}
