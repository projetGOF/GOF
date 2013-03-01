package gof.services;

import gof.model.Enseignement;

import java.util.Collection;

import org.springframework.stereotype.Service;

@Service
public interface EnseignementManager {

	Collection<Enseignement> findAllEnseignements();

	Enseignement findEnseignement(String code);

	void saveEnseignement(Enseignement e);

	void deleteEnseignement(Enseignement e);
}
