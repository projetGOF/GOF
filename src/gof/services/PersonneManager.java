package gof.services;

import java.util.Collection;

import gof.model.Personne;

import org.springframework.stereotype.Service;

@Service
public interface PersonneManager
{
	Collection<Personne> findAllPersonnes();

	Personne findPersonByIdExt(String idext);

	void savePersonne(Personne p);
	
	void deletePersonne(Personne p);
}
