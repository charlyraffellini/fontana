package utn.tadp.fontana;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import utn.tadp.fontana.MetaUtil.ClassRender;
import utn.tadp.fontana.politica.CreacionDeDependencia;
import utn.tadp.fontana.politica.InstanciaComun;

public class Compleja<T extends Object> extends Dependencia {

	Class<T> cClass;
	CreacionDeDependencia<T> policy;
	Map<String, Dependencia> dependencias = new HashMap<String, Dependencia>();
	
	Compleja(Class<T> cClass){
		this.cClass = cClass;
		this.policy = new InstanciaComun<T>(cClass);
	}
	Compleja(Class<T> cClass, CreacionDeDependencia<T> policy){
		this.cClass = cClass;
		this.policy = policy.setClass(cClass);
	}
	
	
	@Override
	public T getValue() {
		T value = policy.getObject();
		
		for (Map.Entry<String, Dependencia> entry : dependencias.entrySet()) {
		    String property = entry.getKey();
		    Dependencia dependencia = entry.getValue();
		    Method setter = ClassRender.getSetterForProperty(this.cClass, property, dependencia.getDepClass());
		    ClassRender.invokeSetter(setter, value, dependencia.getValue());
		}
		return value;
	}
	
	public Compleja<T> addDependencia(String property, Dependencia dep){
		this.dependencias.put(property, dep);
		return this;
	}
	@Override
	public Class<T> getDepClass() {
		return this.cClass;
	}

}
