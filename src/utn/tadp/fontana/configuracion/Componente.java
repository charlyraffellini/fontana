package utn.tadp.fontana.configuracion;

import utn.tadp.fontana.Dependencia;

public abstract class Componente {
	
	protected Dependencia dependenciaEfectiva;
	protected Configuracion conf;
	
	public Dependencia getDependencia(){
		if(this.dependenciaEfectiva == null){
			this.dependenciaEfectiva = this.createDependencia();
		}
		return this.dependenciaEfectiva;
	}
	
	protected abstract Dependencia createDependencia();
	
}
