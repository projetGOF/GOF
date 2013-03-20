package gof.services;

import gof.model.Domaine;
import gof.model.TypeMention;

import java.util.Collection;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public interface DomaineManager {
	
	Collection<Domaine> findAllDomaines();

	Domaine findDomaine(String code);

	void saveDomaine(Domaine d);

	void deleteDomaine(Domaine d);
	
	Set<Domaine> findAllDomaineByTypeMention(TypeMention type);

}
