package gof.dao;

import gof.model.Programme;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class ProgrammeDaoImpl implements ProgrammeDao {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Programme> findAllProgrammes() {
		Query query = em.createQuery("SELECT p FROM programme p");
	    return (Collection<Programme>) query.getResultList();
	}

	@Override
	public Programme findProgramme(String code) {
		return em.find(Programme.class, code);
	}

	@Override
	public void saveProgramme(Programme p) {
		em.merge(p);
		em.flush();
	}

	@Override
	public void deleteProgramme(Programme p) {
		em.remove(p);
		em.flush();
	}

}
