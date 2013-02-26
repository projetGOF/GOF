package gof.dao;

import gof.model.Composante;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class ComposanteDaoImpl implements ComposanteDao{
	
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Composante> findAllComposantes() {
		Query query = em.createQuery("SELECT c FROM composante c");
	    return (Collection<Composante>) query.getResultList();
	}

	@Override
	public Composante findComposante(String code) {
		return em.find(Composante.class, code);
	}

	@Override
	public void saveComposante(Composante c) {
		em.merge(c);
		em.flush();
	}

	@Override
	public void deleteComposante(Composante c) {
		em.remove(c);
		em.flush();
	}

}
