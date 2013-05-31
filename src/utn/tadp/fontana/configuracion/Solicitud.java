package utn.tadp.fontana.configuracion;

public class Solicitud<T extends Object> {

	private Bean<T> bean;
	private String property;
	
	public Solicitud(Bean<T> b, String property){
		this.bean = b;
		this.property = property;
	}

	public Bean<T> getBean() {
		return bean;
	}

	public void setBean(Bean<T> bean) {
		this.bean = bean;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}
}
