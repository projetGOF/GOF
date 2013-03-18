package gof.services;

import java.util.Collection;
import java.util.Set;

import gof.model.Personne;

import org.springframework.stereotype.Service;

@Service
public interface PersonneManager
{
	Collection<Personne> findAllPersonnes();

	Personne findPersonByCode(String code);
	
	Personne findPersonByIdExt(String idext);

	void savePersonne(Personne p);
	
	void deletePersonne(Personne p);
	
	Set<String> findAllCodesFiches(Personne p);
}
