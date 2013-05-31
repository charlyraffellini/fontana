package utn.tadp.fontana.estrategia;

import java.lang.reflect.Method;
import java.util.Map;

import utn.tadp.fontana.Dependencia;
import utn.tadp.fontana.MetaUtil.ClassRender;
import utn.tadp.fontana.politica.CreacionDeDependencia;

public class InicializacionPorSetters<T extends Object> extends Inicializacion<T> {

	
	
	CreacionDeDependencia<T> policy;
	
	@Override
	public T getObject() {
		T value = this.getObjectFromPolicy();
		for (Map.Entry<String, Dependencia> entry : this.dependencias.entrySet()) {
		    String property = entry.getKey();
		    Dependencia dependencia = entry.getValue();
		    Method setter = ClassRender.getSetterForProperty(this.getMiDependenciaCompleja().getcClass(), property, dependencia.getDepClass());
		    ClassRender.invokeSetter(setter, value, dependencia.getValue());
		}
		return value;
	}
	
	protected T getObjectFromPolicy() {
		return this.getPolicy().getObject();
	}

	public CreacionDeDependencia<T> getPolicy() {
		return policy;
	}

	public void setPolicy(CreacionDeDependencia<T> policy) {
		this.policy = policy;
	}
}
