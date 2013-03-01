package gof.services;

import gof.dao.SpecialiteDao;
import gof.model.Specialite;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SpecialiteManagerImpl implements SpecialiteManager {

	@Autowired
	private SpecialiteDao specialiteDao;
	
	@Override
	@Transactional
	public Collection<Specialite> findAllSpecialites() {
		return specialiteDao.findAllSpecialites();
	}

	@Override
	@Transactional
	public Specialite findSpecialite(String code) {
		return specialiteDao.findSpecialite(code);
	}

	@Override
	@Transactional
	public void saveSpecialite(Specialite s) {
		specialiteDao.saveSpecialite(s);
	}

	@Override
	@Transactional
	public void deleteSpecialite(Specialite s) {
		specialiteDao.deleteSpecialite(s);
	}

}
