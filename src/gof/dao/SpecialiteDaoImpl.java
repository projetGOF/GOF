package gof.dao;

import gof.model.Specialite;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class SpecialiteDaoImpl implements SpecialiteDao {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Specialite> findAllSpecialites() {
		Query query = em.createQuery("SELECT s FROM specialite s");
	    return (Collection<Specialite>) query.getResultList();
	}

	@Override
	public Specialite findSpecialite(String code) {
		return em.find(Specialite.class, code);
	}

	@Override
	public void saveSpecialite(Specialite s) {
		em.merge(s);
		em.flush();
	}

	@Override
	public void deleteSpecialite(Specialite s) {
		em.remove(s);
		em.flush();
	}
}
