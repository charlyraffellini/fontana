package utn.tadp.fontana;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testDependencias {

	Dependencia intDep;
	Dependencia strDep;
	Dependencia booDep;
	Compleja<Persona> cpxDep;
	Compleja<Persona> cpxTio;
	
	@Before
	public void setUp() throws Exception {
		
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
