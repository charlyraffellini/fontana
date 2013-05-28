package utn.tadp.fontana;

import java.lang.reflect.Field;

import utn.tadp.fontana.MetaUtil.ClassRender;

public class BooleanDependencia extends Primitiva {

	private boolean value;
	
	public BooleanDependencia(boolean b){
		this.value = b;
	}
	@Override
	public void setValue(Object o, Field f) {
	    ClassRender.fieldSet(f, o, this.value);
	}

}
