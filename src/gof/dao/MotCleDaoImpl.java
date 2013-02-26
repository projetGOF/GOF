package gof.dao;

import gof.model.MotCle;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class MotCleDaoImpl implements MotCleDao {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<MotCle> findAllMotsCles() {
		Query query = em.createQuery("SELECT mc FROM motcle mc");
	    return (Collection<MotCle>) query.getResultList();
	}

	@Override
	public MotCle findMotCle(long id) {
		return em.find(MotCle.class, id);
	}

	@Override
	public void saveMotCle(MotCle mc) {
		em.merge(mc);
		em.flush();
	}

	@Override
	public void deleteMotCle(MotCle mc) {
		em.remove(mc);
		em.flush();
	}

}
