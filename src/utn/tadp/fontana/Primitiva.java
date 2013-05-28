package utn.tadp.fontana;

public class Primitiva extends Dependencia {

	public Primitiva(Class<?> c, Object o){
		super(c,o);
	}
	
	@Override
	public Object getValue() {
		return this.value;
	}

}
