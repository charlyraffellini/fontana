package utn.tadp.fontana;

import java.lang.reflect.Field;

public abstract class Dependencia{
	
	public Dependencia(){

	}
	public abstract Object getValue();
	
	public abstract void setValue(Object o, Field f);
}
