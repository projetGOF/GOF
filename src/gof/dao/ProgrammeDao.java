package gof.dao;

import gof.model.Programme;

import java.util.Collection;

import org.springframework.stereotype.Repository;

@Repository
public interface ProgrammeDao {
	
	Collection<Programme> findAllProgrammes();

	Programme findProgramme(String code);

	void saveProgramme(Programme p);

	void deleteProgramme(Programme p);

}
