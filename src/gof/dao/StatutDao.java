package gof.dao;

import java.util.Collection;

import gof.model.Statut;

import org.springframework.stereotype.Repository;

@Repository
public interface StatutDao {

	Collection<Statut> findAllStatut();

	Statut findStatut(String code);

	void saveStatut(Statut s);

	void deleteStatut(Statut s);
	
}
