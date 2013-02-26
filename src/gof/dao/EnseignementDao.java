package gof.dao;

import gof.model.Enseignement;

import java.util.Collection;

import org.springframework.stereotype.Repository;

@Repository
public interface EnseignementDao {

	Collection<Enseignement> findAllEnseignements();

	Enseignement findEnseignement(String code);

	void saveEnseignement(Enseignement e);

	void deleteEnseignement(Enseignement e);
}
