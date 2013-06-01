package utn.tadp.fontana.politica;

import utn.tadp.fontana.MetaUtil.ClassRender;

public class InstanciaComun<T extends Object> implements CreacionDeDependencia<T> {

	private T instance;
	
	public InstanciaComun(Class<T> cClass) {
		this.instance = (T) ClassRender.newInstance(cClass);
	}

	public T getObject() {
		return this.instance;
	}

	public Object getInstance() {
		return instance;
	}

	public void setInstance(T instance) {
		this.instance = instance;
	}

	public CreacionDeDependencia<T> setClass(Class<T> cClass) {
		// TODO Auto-generated method stub
		return null;
	}

}
