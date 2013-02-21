package gof.dao;

import gof.model.Statut;

import java.util.Collection;

import org.springframework.stereotype.Repository;

@Repository
public interface StatutDao {

	Collection<Statut> findAllStatut();

	Statut findStatut(String code);

	void saveStatut(Statut s);

	void deleteStatut(Statut s);
	
}
