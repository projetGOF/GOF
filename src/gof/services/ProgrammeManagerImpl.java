package gof.services;

import gof.dao.ProgrammeDao;
import gof.model.Programme;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProgrammeManagerImpl implements ProgrammeManager {

	@Autowired
	private ProgrammeDao programmeDao;
	
	@Override
	@Transactional
	public Collection<Programme> findAllProgrammes() {
		return programmeDao.findAllProgrammes();
	}

	@Override
	@Transactional
	public Programme findProgramme(String code) {
		return programmeDao.findProgramme(code);
	}

	@Override
	@Transactional
	public void saveProgramme(Programme p) {
		programmeDao.saveProgramme(p);
	}

	@Override
	@Transactional
	public void deleteProgramme(Programme p) {
		programmeDao.deleteProgramme(p);
	}

}
