package gof.dao;

import gof.model.ComposantProgramme;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class ComposantProgrammeDaoImpl implements ComposantProgrammeDao{

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<ComposantProgramme> findAllComposantsProgramme() {
		Query query = em.createQuery("SELECT cp FROM composant_programme cp");
	    return (Collection<ComposantProgramme>) query.getResultList();
	}

	@Override
	public ComposantProgramme findComposantProgramme(String code) {
		return em.find(ComposantProgramme.class, code);
	}

	@Override
	public void saveComposantProgramme(ComposantProgramme cp) {
		em.merge(cp);
		em.flush();
	}

	@Override
	public void deleteComposantProgramme(ComposantProgramme cp) {
		em.remove(cp);
		em.flush();
	}

}
