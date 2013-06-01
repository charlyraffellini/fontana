package utn.tadp.fontana;

public abstract class Dependencia<T>{

	protected Class<T> cClass;
	
	public abstract T getValue();
	
	public Class<T> getDepClass() {
		return this.cClass;
	}
}
