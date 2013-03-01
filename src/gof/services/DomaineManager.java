package gof.services;

import gof.model.Domaine;

import java.util.Collection;

import org.springframework.stereotype.Service;

@Service
public interface DomaineManager {
	
	Collection<Domaine> findAllDomaines();

	Domaine findDomaine(String code);

	void saveDomaine(Domaine d);

	void deleteDomaine(Domaine d);

}
