package gof.services;

import gof.dao.ElemStructDao;
import gof.model.ElemStruct;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ElemStructManagerImpl implements ElemStructManager {

	@Autowired
	private ElemStructDao elemStructDao;
	
	@Override
	@Transactional
	public Collection<ElemStruct> findAllElemStructs() {
		return elemStructDao.findAllElemStructs();
	}

	@Override
	@Transactional
	public ElemStruct findElemStruct(String code) {
		return elemStructDao.findElemStruct(code);
	}

	@Override
	@Transactional
	public void saveElemStruct(ElemStruct element) {
		elemStructDao.saveElemStruct(element);
	}

	@Override
	@Transactional
	public void deleteElemStruct(ElemStruct element) {
		elemStructDao.deleteElemStruct(element);
	}
}
