package gof.dao;

import gof.model.Statut;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class StatutDaoImpl implements StatutDao{
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Statut> findAllStatut() {
		Query query = em.createQuery("SELECT s FROM statut s");
	    return (Collection<Statut>) query.getResultList();
	}

	@Override
	public Statut findStatut(String code) {
		return em.find(Statut.class, code);
	}

	@Override
	public void saveStatut(Statut s) {
		em.merge(s);
		em.flush();
	}

	@Override
	public void deleteStatut(Statut s) {
		em.remove(s);
		em.flush();
	}

}
