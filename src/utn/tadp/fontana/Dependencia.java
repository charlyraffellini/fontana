package utn.tadp.fontana;

public abstract class Dependencia{
	
	protected Object value;
	protected Class<?> dClass;
	
	public Dependencia(Class<?> c, Object o){
		this.dClass = c;
		this.value = o;
	}
	public Dependencia(){
		
	}
	public abstract Object getValue();
	
	public Class<?> getDepClass() {
		return this.dClass;
	}
}
