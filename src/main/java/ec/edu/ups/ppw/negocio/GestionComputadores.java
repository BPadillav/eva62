package ec.edu.ups.ppw.negocio;

import ec.edu.ups.ppw.datos.ComputadorDAO;
import ec.edu.ups.ppw.eva62Padilla.Computador;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionComputadores {
	
	@Inject
	private ComputadorDAO daoComputador;
	
	 public void guardarComputadores(Computador computador) throws Exception {
		 
		 if (!this.isIdValido(computador.getId_unico())) 
		        throw new Exception("ID incorrecto");
			
		        if (daoComputador.read(computador.getId_unico()) == null){
			        try {
			            daoComputador.insert(computador); 
			        } catch (Exception e) {
			            throw new Exception("Error al insertar: " + e.getMessage());
			        }
			    } else {
			        try {
			            daoComputador.update(computador); 
			        } catch (Exception e) {
			            throw new Exception("Error al actualizar: " + e.getMessage());
			        }
			    }
		}
    
	    private boolean isIdValido (String id_unico) {
		
	    	return id_unico.length()==5;

	    }
	
    public void guardarComputadores( String marca, String modelo, String precio, String almacenamiento) {}
}