package utn.tadp.fontana;

import java.lang.reflect.Method;

import utn.tadp.fontana.MetaUtil.ClassRender;

public class BooleanDependencia extends Primitiva {

	private boolean value;
	
	public BooleanDependencia(boolean b){
		this.value = b;
	}
	
	@Override
	public Class<?> getDepClass() {
		return boolean.class;
	}

	@Override
	public void setMe(Method setter, Object o) {
		ClassRender.invokeSetter(setter, o, this.value);
	}

}
