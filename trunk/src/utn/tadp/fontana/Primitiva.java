package utn.tadp.fontana;

public class Primitiva extends Dependencia {

	private Object value;
	
	Primitiva(Object value){
		this.value = value;
	}
	@Override
	public Object getValue() {
		return this.value;
	}

}
