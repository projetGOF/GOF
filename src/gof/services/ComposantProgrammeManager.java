package gof.services;

import gof.model.ComposantProgramme;

import java.util.Collection;

import org.springframework.stereotype.Service;

@Service
public interface ComposantProgrammeManager {
	
	Collection<ComposantProgramme> findAllComposantsProgramme();

	ComposantProgramme findComposantProgramme(String code);

	void saveComposantProgramme(ComposantProgramme cp);

	void deleteComposantProgramme(ComposantProgramme cp);

}
