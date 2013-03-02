package gof.dao;

import gof.model.Diplome;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class DiplomeDaoImpl implements DiplomeDao {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Diplome> findAllDiplomes() {
		Query query = em.createQuery("SELECT d FROM diplome d");
	    return (Collection<Diplome>) query.getResultList();
	}

	@Override
	public Diplome findDiplome(String code) {
		return em.find(Diplome.class, code);
	}

	@Override
	public void saveDiplome(Diplome d) {
		em.merge(d);
		em.flush();
	}
	
	@Override
	public void deleteDiplome(Diplome d) {
		em.remove(d);
		em.flush();
	}
}