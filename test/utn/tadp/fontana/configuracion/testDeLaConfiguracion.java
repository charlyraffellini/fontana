package utn.tadp.fontana.configuracion;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

import utn.tadp.fontana.Compleja;
import utn.tadp.fontana.Persona;
import utn.tadp.fontana.Primitiva;

public class testDeLaConfiguracion {

	Configuracion config = new Configuracion();
	Compleja<Persona> fiestero;
	
	@Before
	public void setUp() throws Exception {
		fiestero = new Compleja<Persona>(Persona.class)
				.addDependencia("nombre", new Primitiva(String.class, "pepe"))
				.addDependencia("edad", new Primitiva(int.class, 100))
				.addDependencia("vive", new Primitiva(boolean.class, true));
		config.setBeanLike("el tio", fiestero, "conocido");
		config.addBean("pepe", fiestero);
		Compleja<Persona> tio = new Compleja<Persona>(Persona.class)
				.addDependencia("nombre", new Primitiva(String.class, "Don Corleone"))
				.addDependencia("edad", new Primitiva(int.class, 120))
				.addDependencia("vive", new Primitiva(boolean.class, false));
		config.addBean("el tio", tio);
	}

	@Test
	public void testConfiguracionMeDevuelveUnaClaseCorrecta() {
		Persona fiestera = fiestero.getValue();
		Assert.assertEquals("pepe", fiestera.getNombre());
		Assert.assertEquals(100, fiestera.getEdad());
		Assert.assertEquals(true, fiestera.getVive());
		Assert.assertEquals("Don Corleone", fiestera.getConocido().getNombre());
		Assert.assertEquals(120, fiestera.getConocido().getEdad());
		Assert.assertEquals(false, fiestera.getConocido().getVive());
	}

}
