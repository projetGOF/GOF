package gof.services;

import gof.dao.ElemStructDao;
import gof.model.ElemStruct;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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
	public Set<ElemStruct> getElemStructTree(String code) {
		
		ElemStruct elemStruct = elemStructDao.findElemStruct(code);
		
		HashSet<ElemStruct> elemStructHashSet = new HashSet<ElemStruct>();
		elemStructHashSet.add(elemStruct);
		
		ElemStruct currentElemStruct = new ElemStruct();
		
		for(Iterator<ElemStruct> it = elemStruct.getElementsFils().iterator(); it.hasNext(); )
		{
			currentElemStruct = it.next();
			
			elemStructHashSet.addAll(getElemStructTree(currentElemStruct.getCode()));
		}
		
		return elemStructHashSet;
	}

}
