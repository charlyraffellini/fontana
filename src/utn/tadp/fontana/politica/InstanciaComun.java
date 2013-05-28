package utn.tadp.fontana.politica;

public class InstanciaComun implements CreacionDeDependencia {

	private Object instance;
	
	public InstanciaComun(Class<?> cClass) {
		try {
			this.setInstance(cClass.newInstance());
		} catch (InstantiationException e) {
			throw new RuntimeException("InstanciaComun InstantiationException exeption", e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException("InstanciaComun IllegalAccessException exeption", e);
		}
	}

	@Override
	public Object getObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreacionDeDependencia setClass(Class cClass) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getInstance() {
		return instance;
	}

	public void setInstance(Object instance) {
		this.instance = instance;
	}

}
