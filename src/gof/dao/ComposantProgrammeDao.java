package gof.dao;


import gof.model.ComposantProgramme;

import java.util.Collection;

import org.springframework.stereotype.Repository;

@Repository
public interface ComposantProgrammeDao {
	
	Collection<ComposantProgramme> findAllComposantsProgramme();

	ComposantProgramme findComposantProgramme(String code);

	void saveComposantProgramme(ComposantProgramme cp);

	void deleteComposantProgramme(ComposantProgramme cp);

}
