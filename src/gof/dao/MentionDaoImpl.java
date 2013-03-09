package gof.dao;

import gof.model.Mention;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class MentionDaoImpl implements MentionDao {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Mention> findAllMentions() {
		Query query = em.createQuery("SELECT m FROM mention m");
	    return (Collection<Mention>) query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Mention> findAllMentionsByDomaine(String domaine) {
		Query query = em.createQuery("SELECT m FROM mention m");
		//requete sql qui marche sur mysql mais pas jpa :
		//select m from mention m inner join mention_domaine on mention.code=mention_domaine.code_mention where mention_domaine.code_domaine='DEG'
	    return (Collection<Mention>) query.getResultList();
	}

	@Override
	public Mention findMention(String code) {
		return em.find(Mention.class, code);
	}

	@Override
	public void saveMention(Mention m) {
		em.merge(m);
		em.flush();
	}

	@Override
	public void deleteMention(Mention m) {
		em.remove(m);
		em.flush();
	}

}
