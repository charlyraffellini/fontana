package utn.tadp.fontana;

import java.util.ArrayList;

public class Lista<T extends Object> extends Dependencia {
	private Class<T> cClass;
	private ArrayList<Dependencia> listaDeDependencias ;
	
	public Lista(Class<T> cClass){
		this.listaDeDependencias = new ArrayList<Dependencia>();
		this.cClass = cClass;
	}
	
	public Lista<T> addDependenciaALaLista(Dependencia dep){
		this.listaDeDependencias.add(dep);
		return this;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<T> getValue() {
		ArrayList<T> value = new ArrayList<T>();
		for(Dependencia unaDependencia : listaDeDependencias){
			value.add((T) unaDependencia.getValue());
		}
		return value;
	}

	public Class<T> getcClass() {
		return cClass;
	}
	@Override
	public Class<?> getDepClass() {
		ArrayList<T> value = new ArrayList<T>();
		return value.getClass();
	}
}
