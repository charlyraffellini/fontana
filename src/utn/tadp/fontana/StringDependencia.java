package utn.tadp.fontana;

import java.lang.reflect.Field;

import utn.tadp.fontana.MetaUtil.ClassRender;

public class StringDependencia extends Primitiva {

	private String value;
	
	public StringDependencia(String s){
		this.value = s;
	}
	@Override
	public void setValue(Object o, Field f) {
	    ClassRender.fieldSet(f, o, this.value);
	}

}
