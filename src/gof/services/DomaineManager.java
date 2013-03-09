package gof.services;

import gof.model.Domaine;
import gof.model.TypeMention;

import java.util.Collection;

import org.springframework.stereotype.Service;

@Service
public interface DomaineManager {
	
	Collection<Domaine> findAllDomaines();
	
	Collection<Domaine> findAllDomainesByTypeMention(TypeMention type);

	Domaine findDomaine(String code);

	void saveDomaine(Domaine d);

	void deleteDomaine(Domaine d);

}
