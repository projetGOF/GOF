package gof.dao;

import gof.model.DomaineComposante;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class DomaineComposanteDaoImpl implements DomaineComposanteDao{

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public Collection<DomaineComposante> findAllDomainesComposantes() {
		Query query = em.createQuery("SELECT d FROM domaine_composante d");
	    return (Collection<DomaineComposante>) query.getResultList();
	}

	@Override
	public DomaineComposante findDomaineComposante(String code) {
		return em.find(DomaineComposante.class, code);
	}

	@Override
	public void saveDomaineComposante(DomaineComposante d) {
		em.merge(d);
		em.flush();
	}

	@Override
	public void deleteDomaineComposante(DomaineComposante d) {
		em.remove(d);
		em.flush();
	}
}