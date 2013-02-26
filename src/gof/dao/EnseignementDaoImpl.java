package gof.dao;

import gof.model.Enseignement;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class EnseignementDaoImpl implements EnseignementDao {
	
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Enseignement> findAllEnseignements() {
		Query query = em.createQuery("SELECT e FROM enseignement e");
	    return (Collection<Enseignement>) query.getResultList();
	}

	@Override
	public Enseignement findEnseignement(String code) {
		return em.find(Enseignement.class, code);
	}

	@Override
	public void saveEnseignement(Enseignement e) {
		em.merge(e);
		em.flush();
	}

	@Override
	public void deleteEnseignement(Enseignement e) {
		em.remove(e);
		em.flush();
	}

}
