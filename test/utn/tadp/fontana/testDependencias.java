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
		intDep = new IntDependencia(100);
		strDep = new StringDependencia("Holas");
		booDep = new BooleanDependencia(true);
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
