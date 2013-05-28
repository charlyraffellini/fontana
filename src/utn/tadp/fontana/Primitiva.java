package utn.tadp.fontana;

public abstract class Primitiva extends Dependencia {

	@Override
	public Object getValue() {
		throw new GetPrimitiveValueExeption();
	}


}
