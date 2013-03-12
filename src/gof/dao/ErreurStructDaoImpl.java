package gof.dao;

import gof.model.ErreurStruct;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class ErreurStructDaoImpl implements ErreurStructDao {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<ErreurStruct> findAllErreursStruct() {
		Query query = em.createQuery("SELECT es FROM erreur_structure es");
	    return (Collection<ErreurStruct>) query.getResultList();
	}

	@Override
	public ErreurStruct findErreurStruct(int id) {
		return em.find(ErreurStruct.class, id);
	}

	@Override
	public void saveErreurStruct(ErreurStruct es) {
		em.merge(es);
		em.flush();
	}

	@Override
	public void deleteErreurStruct(ErreurStruct es) {
		em.remove(es);
		em.flush();
	}


}
