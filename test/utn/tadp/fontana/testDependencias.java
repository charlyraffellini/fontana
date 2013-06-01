package utn.tadp.fontana;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import utn.tadp.fontana.estrategia.InicializacionPorConstructor;

public class testDependencias {

	Dependencia intDep;
	Dependencia strDep;
	Dependencia booDep;
	Compleja<Persona> cpxDep;
	Compleja<Persona> cpxTio;
	Compleja<Persona> personaConstructiva;
	Lista<String, ArrayList<String>> apodosDelTipo;
	private Compleja<Persona> robertoCarlos;
	
	@Before
	public void setUp() {
		
		cpxTio = new Compleja<Persona>(Persona.class)
			.addDependencia("nombre", new Primitiva(String.class, "Tio de Holas"))
			.addDependencia("edad", new Primitiva(int.class, 120))
			.addDependencia("vive", new Primitiva(boolean.class, false));
		intDep = new Primitiva(int.class, 100);
		strDep = new Primitiva(String.class, "Holas");
		booDep = new Primitiva(boolean.class, true);
		cpxDep = new Compleja<Persona>(Persona.class);
		cpxDep.addDependencia("nombre",strDep)
			.addDependencia("edad", intDep)
			.addDependencia("vive", booDep)
			.addDependencia("conocido", cpxTio);
		
		InicializacionPorConstructor<Persona> inicializacionDefault = new InicializacionPorConstructor<Persona>();
		inicializacionDefault.setMiDependenciaCompleja(personaConstructiva);		
		personaConstructiva = new Compleja<Persona>(Persona.class, inicializacionDefault);
		
		personaConstructiva.addDependencia("1", new Primitiva(String.class, "Pepe")).addDependencia("2", new Primitiva(int.class, 31));
		
		apodosDelTipo = new Lista(ArrayList.class);
		apodosDelTipo.addDependenciaALaLista(new Primitiva(String.class, "Pepe")).addDependenciaALaLista(new Primitiva(String.class, "otro"));
		robertoCarlos = new Compleja<Persona>(Persona.class)
				.addDependencia("nombre", new Primitiva(String.class, "Roberto Carlos"))
				.addDependencia("edad", new Primitiva(int.class, 100))
				.addDependencia("vive", new Primitiva(boolean.class, true))
				.addDependencia("apodos", apodosDelTipo);		
	}
	@Test
	public void testDependenciaConLista(){
		Persona persona = (Persona)robertoCarlos.getValue();
		Assert.assertEquals("Roberto Carlos", persona.getNombre());
		ArrayList<String> losApodos = new ArrayList<String>();
		losApodos = persona.getApodos();
		Assert.assertEquals(losApodos.get(0),("Pepe"));
	}
	@Test
	public void testDependenciaPorConstructor(){
		Persona persona = (Persona)personaConstructiva.getValue();
		Assert.assertEquals("Pepe", persona.getNombre());
	}
	@Test
	public void testIntDependenciadevuelveOK() {
		Persona persona = (Persona)cpxDep.getValue();
		Assert.assertEquals(100, (int)persona.getEdad());
		Assert.assertEquals(true, persona.getVive());
		Assert.assertEquals("Holas", persona.getNombre());
		Assert.assertEquals("Tio de Holas", persona.getConocido().getNombre());
		Assert.assertEquals(120, persona.getConocido().getEdad());
		Assert.assertEquals(false, persona.getConocido().getVive());
	}

}
