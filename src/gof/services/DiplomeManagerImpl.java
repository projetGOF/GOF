package gof.services;

import gof.dao.DiplomeDao;
import gof.model.Diplome;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DiplomeManagerImpl implements DiplomeManager {

	@Autowired
	private DiplomeDao diplomeDao;
	
	@Override
	@Transactional
	public Collection<Diplome> findAllDiplomes() {
		return diplomeDao.findAllDiplomes();
	}

	@Override
	@Transactional
	public Diplome findDiplome(String code) {
		return diplomeDao.findDiplome(code);
	}

	@Override
	@Transactional
	public void saveDiplome(Diplome d) {
		diplomeDao.saveDiplome(d);
	}

	@Override
	@Transactional
	public void deleteDiplome(Diplome d) {
		diplomeDao.deleteDiplome(d);
	}
}