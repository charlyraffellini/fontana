package utn.tadp.fontana.MetaUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.commons.lang.WordUtils;

public class ClassRender {
	static public Field getField(Class<?> c, String f){
		try {
			Field fiel = c.getField(f);
			return fiel;
		} catch (NoSuchFieldException e) {
			throw new RuntimeException("ClassRender trows NoSuchFieldException",e);
		} catch (SecurityException e) {
			throw new RuntimeException("ClassRender trows SecurityException",e);
		}
	}
	
	static public void fieldSet(Field field, Object obj, Object value){
		try {
			field.set(obj, value);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException("ClassRender trows IllegalArgumentException",e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException("ClassRender trows IllegalAccessException",e);
		}
	}
	
	static public void fieldSet(Field field, Object obj, int value){
		try {
			field.set(obj, value);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException("ClassRender trows IllegalArgumentException",e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException("ClassRender trows IllegalAccessException",e);
		}
	}
	
	static public void fieldSet(Field field, Object obj, boolean value){
		try {
			field.set(obj, value);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException("ClassRender trows IllegalArgumentException",e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException("ClassRender trows IllegalAccessException",e);
		}
	}
	
	static public void fieldSet(Field field, Object obj, String value){
		try {
			field.set(obj, value);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException("ClassRender trows IllegalArgumentException",e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException("ClassRender trows IllegalAccessException",e);
		}
	}
	
	static public Method getGetterForProperty(Class<?> cClass, String property){
		try {
			return cClass.getMethod("get" + WordUtils.capitalize(property));
		} catch (NoSuchMethodException e) {
			throw new RuntimeException("ClassRender trows NoSuchMethodException",e);
		} catch (SecurityException e) {
			throw new RuntimeException("ClassRender trows SecurityException",e);
		}
	}
	
	static public Method getSetterForProperty(Class<?> cClass, String property, Class<?> param){
		try {
			return cClass.getMethod("set" + WordUtils.capitalize(property), param);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException("ClassRender trows NoSuchMethodException",e);
		} catch (SecurityException e) {
			throw new RuntimeException("ClassRender trows SecurityException",e);
		}
	}
	
	static public void invokeSetter(Method setter, Object obj, Object value){
		try {
			setter.invoke(obj, value);
		} catch (IllegalAccessException e) {
			throw new RuntimeException("ClassRender trows IllegalAccessException",e);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException("ClassRender trows IllegalArgumentException",e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException("ClassRender trows InvocationTargetException",e);
		}
	}
}
