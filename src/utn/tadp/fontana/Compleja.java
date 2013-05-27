package utn.tadp.fontana;

import java.lang.reflect.Field;
import java.util.Map;

import utn.tadp.fontana.MetaUtil.ClassRender;

public class Compleja extends Dependencia {

	Class cCalss;
	CreacionDeDependencia policy;
	Map<String, Dependencia> dependencias;
	
	Compleja(Class cClass){
		this.cCalss = cClass;
		this.policy = new InstanciaComun(cClass);
	}
	Compleja(Class cClass, CreacionDeDependencia policy){
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
		    field.set(value, dependencia.getValue());
		    
		}
		return null;
	}
	

}
