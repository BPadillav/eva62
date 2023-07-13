package ec.edu.ups.ppw.datos;

import java.io.Serializable;
import java.util.List;

import ec.edu.ups.ppw.eva62Padilla.Computador;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class ComputadorDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert (Computador computador) {
		
		em.persist(computador);
	}
	
	public void update (Computador computador) {
		
		em.merge(computador);
	}
	
	public Computador read(int id_computador) {
		Computador p = em.find(Computador.class, id_computador);
		return p;
		
	}
	
	public void delete (String almacenamiento) {
		
		Computador p = em.find(Computador.class, almacenamiento);
		em.remove(p);
				
	}

	public List<Computador> getAll(){
		String jpql = "SELECT c FROM Computador c";
		Query q = em.createQuery(jpql);
		return q.getResultList();		
	}
}