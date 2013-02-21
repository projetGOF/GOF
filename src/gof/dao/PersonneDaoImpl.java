package gof.dao;

import gof.model.Personne;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class PersonneDaoImpl implements PersonneDao{
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Personne> findAllPersonnes() {
		Query query = em.createQuery("SELECT p FROM personne p");
	    return (Collection<Personne>) query.getResultList();
	}

	@Override
	public Personne findPersonneByCode(String code) {
		return em.find(Personne.class, code);
	}

	@Override
	public void savePersonne(Personne p) {
		em.merge(p);
		em.flush();
	}

	@Override
	public void deletePersonne(Personne p) {
		em.remove(p);
		em.flush();
	}
	
}
