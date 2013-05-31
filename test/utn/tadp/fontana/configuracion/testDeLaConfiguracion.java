package utn.tadp.fontana.configuracion;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

import utn.tadp.fontana.Dependencia;
import utn.tadp.fontana.Persona;

public class testDeLaConfiguracion {

	Configuracion config = new Configuracion();
	Bean<Persona> fiestero;
	
	@Before
	public void setUp() throws Exception {
		fiestero = new Bean<Persona>("pepe", Persona.class)
				.addComponente("nombre", new SimpleComponente(String.class, "pepe"))
				.addComponente("edad", new SimpleComponente(int.class, 100))
				.addComponente("vive", new SimpleComponente(boolean.class, true));
		config.setBeanLike("el tio", fiestero, "conocido");
		config.addBean("pepe", fiestero);
		Bean<Persona> tio = new Bean<Persona>("tio de pepe", Persona.class)
				.addComponente("nombre", new SimpleComponente(String.class, "Don Corleone"))
				.addComponente("edad", new SimpleComponente(int.class, 120))
				.addComponente("vive", new SimpleComponente(boolean.class, false));
		config.addBean("el tio", tio);
	}

	@Test
	public void testConfiguracionMeDevuelveUnaClaseCorrecta() {
		Dependencia fiesteroDependencia = fiestero.getDependencia();
		Persona fiestera = (Persona) fiesteroDependencia.getValue();
		Assert.assertEquals("pepe", fiestera.getNombre());
		Assert.assertEquals(100, fiestera.getEdad());
		Assert.assertEquals(true, fiestera.getVive());
		Assert.assertEquals("Don Corleone", fiestera.getConocido().getNombre());
		Assert.assertEquals(120, fiestera.getConocido().getEdad());
		Assert.assertEquals(false, fiestera.getConocido().getVive());
	}

}
