package utn.tadp.fontana;

import java.lang.reflect.Field;

import utn.tadp.fontana.MetaUtil.ClassRender;

public class IntDependencia extends Primitiva {

	private int value;
	
	public IntDependencia(int i){
		this.value = i;
	}
	@Override
	public void setValue(Object o, Field f) {
	    ClassRender.fieldSet(f, o, this.value);
	}

}
