package utn.tadp.fontana;

import java.lang.reflect.Method;

public abstract class Dependencia{
	
	public Dependencia(){

	}
	public abstract Object getValue();
	
	public abstract Class<?> getDepClass();
	
	public abstract void setMe(Method setter, Object o);
}
