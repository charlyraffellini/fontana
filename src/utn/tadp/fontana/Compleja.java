package utn.tadp.fontana;

import java.lang.reflect.Field;
import java.util.Map;

import utn.tadp.fontana.MetaUtil.ClassRender;
import utn.tadp.fontana.politica.CreacionDeDependencia;
import utn.tadp.fontana.politica.InstanciaComun;

public class Compleja extends Dependencia {

	Class<?> cCalss;
	CreacionDeDependencia policy;
	Map<String, Dependencia> dependencias;
	
	Compleja(Class<?> cClass){
		this.cCalss = cClass;
		this.policy = new InstanciaComun(cClass);
	}
	Compleja(Class<?> cClass, CreacionDeDependencia policy){
		this.cCalss = cClass;
		this.policy = policy.setClass(cClass);
	}
	
	
	@Override
	public Object getValue() {
		Object value = policy.getObject();
		
		for (Map.Entry<String, Dependencia> entry : dependencias.entrySet()) {
		    String property = entry.getKey();
		    Dependencia dependencia = entry.getValue();
		    Field field = ClassRender.getField(this.cCalss, property);
		    dependencia.setValue(value, field);
		}
		return value;
	}
	@Override
	public void setValue(Object o, Field f) {
		ClassRender.fieldSet(f, o, this.getValue());
	}
	
	public Compleja addDependencia(String property, Dependencia dep){
		this.dependencias.put(property, dep);
		return this;
	}
	
	

}
