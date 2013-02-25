package gof.services;

import gof.model.Statut;

import java.util.Collection;

import org.springframework.stereotype.Service;

@Service
public interface StatutManager
{
	Collection<Statut> findAllStatut();

	Statut findStatut(String code);

	void saveStatut(Statut s);

	void deleteStatut(Statut s);
}
