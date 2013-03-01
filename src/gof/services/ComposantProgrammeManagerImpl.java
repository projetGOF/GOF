package gof.services;

import gof.dao.ComposantProgrammeDao;
import gof.model.ComposantProgramme;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ComposantProgrammeManagerImpl implements ComposantProgrammeManager {

	@Autowired
	private ComposantProgrammeDao composantProgrammeDao;
	
	@Override
	@Transactional
	public Collection<ComposantProgramme> findAllComposantsProgramme() {
		return composantProgrammeDao.findAllComposantsProgramme();
	}

	@Override
	@Transactional
	public ComposantProgramme findComposantProgramme(String code) {
		return composantProgrammeDao.findComposantProgramme(code);
	}

	@Override
	@Transactional
	public void saveComposantProgramme(ComposantProgramme cp) {
		composantProgrammeDao.saveComposantProgramme(cp);
	}

	@Override
	@Transactional
	public void deleteComposantProgramme(ComposantProgramme cp) {
		composantProgrammeDao.deleteComposantProgramme(cp);
	}

}
