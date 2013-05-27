package utn.tadp.fontana.MetaUtil;

import java.lang.reflect.Field;

import javax.management.RuntimeErrorException;

public class ClassRender {
	static public Field getField(Class c, String f){
		try {
			Field fiel = c.getField(f);
			return fiel;
		} catch (NoSuchFieldException e) {
			throw new RuntimeException(e);
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		}
	}
}
