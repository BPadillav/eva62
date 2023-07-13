package ec.edu.ups.ppw.negocio;

import java.util.List;

import ec.edu.ups.ppw.datos.ComputadorDAO;
import ec.edu.ups.ppw.eva62Padilla.Computador;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class DatosComputador {
	
	@Inject
	private ComputadorDAO daoComputador;
	
	@PostConstruct
	public void init() {
		
		System.out.println("Hola UPS");
		
		Computador c = new Computador();
		Computador c1 = new Computador();
		
		c.setId_unico("50000");
		c.setMarca("HP");
		c.setAlmacenamiento("512 GB");
		c.setModelo("Portatil");
		c.setPrecio("500");
		
		c.setId_unico("90000");
		c1.setMarca("ASUS");
		c1.setAlmacenamiento("216 GB");
		c1.setModelo("Personal");
		c1.setPrecio("800");
		
		daoComputador.insert(c);
		daoComputador.insert(c1);
		
		List<Computador> computadores = daoComputador.getAll();
		

    }
}