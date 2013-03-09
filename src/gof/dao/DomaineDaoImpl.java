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
	
	@SuppressWarnings("unchecked")
	@Override
	public int countMentionByDomaineAndTypeMention(String domaine, TypeMention type){
		Query query = em.createQuery("SELECT m FROM mention m INNER JOIN m.domaines md WHERE md.code= :domaine and m.typeMention= :type");
		query.setParameter("domaine", domaine);
		query.setParameter("type", type);
		Collection<Mention> mention = (Collection<Mention>) query.getResultList();
		return mention.size();
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
