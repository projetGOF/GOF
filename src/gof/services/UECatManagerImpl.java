package gof.services;

import java.util.Collection;

import gof.dao.UECatDao;
import gof.model.UECat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UECatManagerImpl implements UECatManager {
	
	@Autowired
	UECatDao uECatDao;

	@Override
	@Transactional
	public Collection<UECat> findAllUECats() {
		return uECatDao.findAllUECats();
	}

	@Override
	@Transactional
	public UECat findUECat(String code) {
		return uECatDao.findUECat(code);
	}

	@Override
	@Transactional
	public void saveUECat(UECat ue) {
		uECatDao.saveUECat(ue);
	}

	@Override
	@Transactional
	public void deleteUECat(UECat ue) {
		uECatDao.deleteUECat(ue);
	}
	
	

}
