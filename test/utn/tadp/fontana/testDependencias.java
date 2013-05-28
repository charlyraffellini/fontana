package utn.tadp.fontana;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testDependencias {

	@Before
	public void setUp() throws Exception {
		Dependencia intDep = new IntDependencia(100);
		Dependencia strDep = new StringDependencia("Holas");
		Dependencia booDep = new BooleanDependencia(true);
		Dependencia cpxDep = new Compleja(Persona.class);
		
	}

	@Test
	public void testIntDependenciadevuelveOK() {
		
	}

}
