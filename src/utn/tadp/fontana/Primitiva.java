package utn.tadp.fontana;

public class Primitiva extends Dependencia {

	Object value;
	
	public Primitiva(Class<?> c, Object value){
		this.cClass = c;
		this.value = value;
	}
	
	@Override
	public Object getValue() {
		return this.value;
	}

}
