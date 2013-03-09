package gof.services;

import gof.model.Domaine;
import gof.model.TypeMention;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Service;

@Service
public interface DomaineManager {
	
	Collection<Domaine> findAllDomaines();
	
	ArrayList<Domaine> findDomainesByTypeMention(TypeMention type);

	Domaine findDomaine(String code);

	void saveDomaine(Domaine d);

	void deleteDomaine(Domaine d);

}
