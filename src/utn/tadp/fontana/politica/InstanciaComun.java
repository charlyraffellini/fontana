package utn.tadp.fontana.politica;

public class InstanciaComun<T extends Object> implements CreacionDeDependencia<T> {

	private T instance;
	
	public InstanciaComun(Class<T> cClass) {
		try {
			this.setInstance(cClass.newInstance());
		} catch (InstantiationException e) {
			throw new RuntimeException("InstanciaComun InstantiationException exeption", e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException("InstanciaComun IllegalAccessException exeption", e);
		}
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
