package utn.tadp.fontana;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testDependencias {

	Dependencia intDep;
	Dependencia strDep;
	Dependencia booDep;
	Compleja cpxDep;
	
	@Before
	public void setUp() throws Exception {
		intDep = new Primitiva(int.class, 100);
		strDep = new Primitiva(String.class, "Holas");
		booDep = new Primitiva(boolean.class, true);
		cpxDep = new Compleja(Persona.class);
		cpxDep.addDependencia("nombre",strDep)
			.addDependencia("edad", intDep)
			.addDependencia("vive", booDep);
		
		
	}

	@Test
	public void testIntDependenciadevuelveOK() {
		Persona persona = (Persona)cpxDep.getValue();
		Assert.assertEquals(100, (int)persona.getEdad());
		Assert.assertEquals(true, persona.getVive());
		Assert.assertEquals("Holas", persona.getNombre());
		
	}

}
