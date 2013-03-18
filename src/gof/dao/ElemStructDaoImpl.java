package gof.dao;

import gof.model.ElemStruct;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class ElemStructDaoImpl implements ElemStructDao {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<ElemStruct> findAllElemStructs() {
		Query query = em.createQuery("SELECT e FROM element e");
	    return (Collection<ElemStruct>) query.getResultList();
	}

	@Override
	public ElemStruct findElemStruct(String code) {
		return em.find(ElemStruct.class, code);
	}

}
