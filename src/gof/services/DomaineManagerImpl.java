package gof.services;

import gof.dao.DomaineDao;
import gof.model.Domaine;
import gof.model.TypeMention;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DomaineManagerImpl implements DomaineManager {

	@Autowired
	private DomaineDao domaineDao;
	
	@Override
	@Transactional
	public Collection<Domaine> findAllDomaines() {
		return domaineDao.findAllDomaines();
	}

	@Override
	@Transactional
	public Domaine findDomaine(String code) {
		return domaineDao.findDomaine(code);
	}

	@Override
	@Transactional
	public void saveDomaine(Domaine d) {
		domaineDao.saveDomaine(d);
	}

	@Override
	@Transactional
	public void deleteDomaine(Domaine d) {
		domaineDao.deleteDomaine(d);
	}

}
