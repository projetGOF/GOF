package gof.dao;

import gof.model.UECat;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class UECatDaoImpl implements UECatDao {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<UECat> findAllUECats() {
		Query query = em.createQuery("SELECT ue FROM uecat ue");
	    return (Collection<UECat>) query.getResultList();
	}

	@Override
	public UECat findUECat(String code) {
		return em.find(UECat.class, code);
	}

	@Override
	public void saveUECat(UECat ue) {
		em.merge(ue);
		em.flush();
	}

	@Override
	public void deleteUECat(UECat ue) {
		em.remove(ue);
		em.flush();
	}

}
