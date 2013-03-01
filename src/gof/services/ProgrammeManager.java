package gof.services;

import gof.model.Programme;

import java.util.Collection;

import org.springframework.stereotype.Service;

@Service
public interface ProgrammeManager {

	Collection<Programme> findAllProgrammes();

	Programme findProgramme(String code);

	void saveProgramme(Programme p);

	void deleteProgramme(Programme p);

}
