package utn.tadp.fontana.estrategia;

import java.util.ArrayList;

import utn.tadp.fontana.Dependencia;
import utn.tadp.fontana.MetaUtil.ClassRender;

public class InicializacionPorConstructor<T extends Object> extends Inicializacion<T> {

	@SuppressWarnings("unchecked")
	@Override
	public T getObject() {
		ArrayList<Dependencia> objects = new ArrayList<Dependencia>();
		for (int i = 1 ; i <= dependencias.size(); i++){
			objects.add(dependencias.get(String.valueOf(i)));
		}
		return (T) ClassRender.invokeConstructor(this.getMiDependenciaCompleja().getcClass(), objects);

	}

}
