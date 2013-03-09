package gof.dao;


import gof.model.Domaine;
import gof.model.TypeMention;

import java.util.Collection;

import org.springframework.stereotype.Repository;

@Repository
public interface DomaineDao {
	
	Collection<Domaine> findAllDomaines();
	
	Collection<Domaine> findAllDomainesByTypeMention(TypeMention type);

	Domaine findDomaine(String code);

	void saveDomaine(Domaine d);

	void deleteDomaine(Domaine d);

}
