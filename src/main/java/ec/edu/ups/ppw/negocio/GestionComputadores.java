package ec.edu.ups.ppw.negocio;

import ec.edu.ups.ppw.datos.ComputadorDAO;
import ec.edu.ups.ppw.eva62Padilla.Computador;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionComputadores {
	
	@Inject
	private ComputadorDAO daoComputador;
	
	public void guardarComputador(Computador computador) throws Exception {
	    if (computador == null) {
	        throw new IllegalArgumentException("incorrecto");
	    }

	    if (!isCodigoValido(computador.getId_computador())) {
	        throw new Exception("Id incorrecto");
	    }

	    try {
	        if (daoComputador.read(computador.getId_computador()) == null) {
	        	daoComputador.insert(computador);
	        } else {
	        	daoComputador.update(computador);
	        }
	    } catch (Exception e) {
	        throw new Exception("Error al guardar: " + e.getMessage());
	    }
	}

	private boolean isCodigoValido(int id_computador) {
	    return id_computador > 0;
	}
	
}