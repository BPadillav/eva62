package ec.edu.ups.ppw.servicios;

import java.util.List;

import ec.edu.ups.ppw.datos.ComputadorDAO;
import ec.edu.ups.ppw.eva62Padilla.Computador;
import ec.edu.ups.ppw.negocio.GestionComputadores;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("computadores")
public class GComputadoresService {
	
	@Inject
	private GestionComputadores gComputadores;
	
	@Inject
    private ComputadorDAO daoComputador;

	@GET
	@Path("personas1")
	@Produces("application/json")
	@Consumes("application/json")
	public Response guardarComputador(Computador computador) {
	    try {
	    	gComputadores.guardarComputadores(computador);
	        List<Computador> computadores = getComputadores(); 
	        return Response.status(Response.Status.OK).entity(computadores).build();
	    } catch (Exception e) {
	        e.printStackTrace();
	        Error error = new Error();
	        error.setCodigo(99);
	        error.setMensaje("Error al guardar: " + e.getMessage());
	        return Response.status(Response.Status.OK).entity(error).build();
	    }
	}

	public List<Computador> getComputadores() {
	    return daoComputador.getAll();
	}
	
}