package utn.tadp.fontana;

import java.lang.reflect.Method;

import utn.tadp.fontana.MetaUtil.ClassRender;

public class StringDependencia extends Primitiva {

	private String value;
	
	public StringDependencia(String s){
		this.value = s;
	}

	@Override
	public Class<?> getDepClass() {
		return String.class;
	}
	
	@Override
	public void setMe(Method setter, Object o) {
		ClassRender.invokeSetter(setter, o, this.value);
	}

}
