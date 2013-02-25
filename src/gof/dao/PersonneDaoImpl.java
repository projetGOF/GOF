package gof.dao;

import gof.model.Personne;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class PersonneDaoImpl implements PersonneDao{
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public Collection<Personne> findAllPersonnes() {
		Query query = em.createQuery("SELECT p FROM personne p");
	    return (Collection<Personne>) query.getResultList();
	}
	
	public Personne findPersonneByCode(String code) {
		return em.find(Personne.class, code);
	}

	public Personne findPersonneByIdExt(String idext) {
		Personne personne;
		
		Query query = em.createQuery("SELECT e FROM personne e WHERE idext=?1").setParameter(1, idext);
		
		try
		{
			personne = (Personne)query.getSingleResult();
		}
		catch (NoResultException e)
		{
			return null;
		}

		return personne;
	}

	public void savePersonne(Personne p) {
		em.merge(p);
		em.flush();
	}

	public void deletePersonne(Personne p) {
		em.remove(p);
		em.flush();
	}
	
}
