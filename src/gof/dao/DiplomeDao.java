package gof.dao;

import gof.model.Diplome;

import java.util.Collection;

import org.springframework.stereotype.Repository;

@Repository
public interface DiplomeDao {

	Collection<Diplome> findAllDiplomes();

	Diplome findDiplome(String code);

	void saveDiplome(Diplome d);

	void deleteDiplome(Diplome d);
}