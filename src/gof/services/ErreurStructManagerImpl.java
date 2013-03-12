package gof.services;

import gof.dao.ErreurStructDao;
import gof.model.ErreurStruct;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ErreurStructManagerImpl implements ErreurStructManager {

	@Autowired
	private ErreurStructDao erreurStructDao;
	
	@Override
	@Transactional
	public Collection<ErreurStruct> findAllErreursStruct() {
		return erreurStructDao.findAllErreursStruct();
	}

	@Override
	@Transactional
	public ErreurStruct findErreurStruct(int id) {
		return erreurStructDao.findErreurStruct(id);
	}

	@Override
	@Transactional
	public void saveErreurStruct(ErreurStruct es) {
		erreurStructDao.saveErreurStruct(es);
	}

	@Override
	@Transactional
	public void deleteErreurStruct(ErreurStruct es) {
		erreurStructDao.deleteErreurStruct(es);
	}

}
