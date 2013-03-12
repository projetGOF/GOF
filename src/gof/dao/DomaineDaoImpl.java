package gof.dao;

import gof.model.Domaine;
import gof.model.Mention;
import gof.model.TypeMention;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class DomaineDaoImpl implements DomaineDao {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Domaine> findAllDomaines() {
		Query query = em.createQuery("SELECT d FROM domaine d");
	    return (Collection<Domaine>) query.getResultList();
	}

	@Override
	public Domaine findDomaine(String code) {
		return em.find(Domaine.class, code);
	}

	@Override
	public void saveDomaine(Domaine d) {
		em.merge(d);
		em.flush();
	}

	@Override
	public void deleteDomaine(Domaine d) {
		em.remove(d);
		em.flush();
	}

}
