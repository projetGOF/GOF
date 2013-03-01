package gof.services;

import gof.dao.EnseignementDao;
import gof.model.Enseignement;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EnseignementManagerImpl implements EnseignementManager {

	@Autowired
	private EnseignementDao enseignementDao;
	
	@Override
	@Transactional
	public Collection<Enseignement> findAllEnseignements() {
		return enseignementDao.findAllEnseignements();
	}

	@Override
	@Transactional
	public Enseignement findEnseignement(String code) {
		return enseignementDao.findEnseignement(code);
	}

	@Override
	@Transactional
	public void saveEnseignement(Enseignement e) {
		enseignementDao.saveEnseignement(e)
;	}

	@Override
	@Transactional
	public void deleteEnseignement(Enseignement e) {
		enseignementDao.deleteEnseignement(e);
	}

}
