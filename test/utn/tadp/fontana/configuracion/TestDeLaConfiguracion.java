package utn.tadp.fontana.configuracion;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

import utn.tadp.fontana.Bean;
import utn.tadp.fontana.Compleja;
import utn.tadp.fontana.Persona;
import utn.tadp.fontana.Primitiva;

public class TestDeLaConfiguracion {

	Configuracion config = new Configuracion();
	Compleja<Persona> fiestero;
	
	@Before
	public void setUp() throws Exception {
		fiestero = new Compleja<Persona>(Persona.class)
				.addDependencia("nombre", new Primitiva(String.class, "pepe"))
				.addDependencia("edad", new Primitiva(int.class, 100))
				.addDependencia("vive", new Primitiva(boolean.class, true))
				.addDependencia("conocido", new Bean("el tio", config));
		config.addBean("pepe", fiestero);
		Compleja<Persona> tio = new Compleja<Persona>(Persona.class)
				.addDependencia("nombre", new Primitiva(String.class, "Don Corleone"))
				.addDependencia("edad", new Primitiva(int.class, 120))
				.addDependencia("vive", new Primitiva(boolean.class, false))
				.addDependencia("conocido", new Compleja<Persona>(Persona.class)
						.addDependencia("nombre", new Primitiva(String.class, "Spilbergo"))
						.addDependencia("edad", new Primitiva(int.class, 68))
						.addDependencia("vive", new Primitiva(boolean.class, true)));
		config.addBean("el tio", tio);
	}

	@Test
	public void testConfiguracionMeDevuelveUnaClaseCorrecta() {
		Persona fiestera = fiestero.getValue();
		Persona padrino = fiestera.getConocido();
		Persona director = padrino.getConocido();
		Assert.assertEquals("pepe", fiestera.getNombre());
		Assert.assertEquals(100, fiestera.getEdad());
		Assert.assertEquals(true, fiestera.getVive());
		Assert.assertEquals("Don Corleone", padrino.getNombre());
		Assert.assertEquals(120, padrino.getEdad());
		Assert.assertEquals(false, padrino.getVive());
		Assert.assertEquals("Spilbergo", director.getNombre());
		Assert.assertEquals(68, director.getEdad());
		Assert.assertEquals(true, director.getVive());
	}
	
	@Test
	public void testDe_getBean_DeLaConfiguracion() {
		Persona fiestera = (Persona)config.getBean("pepe");
		Persona padrino = (Persona)config.getBean("el tio");
		Persona director = padrino.getConocido();
		Assert.assertEquals("pepe", fiestera.getNombre());
		Assert.assertEquals(100, fiestera.getEdad());
		Assert.assertEquals(true, fiestera.getVive());
		Assert.assertEquals("Don Corleone", padrino.getNombre());
		Assert.assertEquals(120, padrino.getEdad());
		Assert.assertEquals(false, padrino.getVive());
		Assert.assertEquals("Spilbergo", director.getNombre());
		Assert.assertEquals(68, director.getEdad());
		Assert.assertEquals(true, director.getVive());
	}

}
