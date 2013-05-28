package utn.tadp.fontana;

import java.lang.reflect.Method;

import utn.tadp.fontana.MetaUtil.ClassRender;

public class IntDependencia extends Primitiva {

	private int value;
	
	public IntDependencia(int i){
		this.value = i;
	}
	
	@Override
	public Class<?> getDepClass() {
		return int.class;
	}
	
	@Override
	public void setMe(Method setter, Object o) {
		ClassRender.invokeSetter(setter, o, this.value);
	}

}
