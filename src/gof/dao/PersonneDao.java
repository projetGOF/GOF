package gof.dao;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import gof.model.Personne;

@Repository
public interface PersonneDao {
	
	Collection<Personne> findAllPersonnes();

	Personne findPersonneByCode(String code);

	void savePersonne(Personne p);

	void deletePersonne(Personne p);
	
}
