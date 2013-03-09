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
	public ArrayList<Domaine> findDomainesByTypeMention(TypeMention type) {
		ArrayList<Domaine> result = new ArrayList<Domaine>();
		ArrayList<Domaine> domaine=(ArrayList<Domaine>) domaineDao.findAllDomaines();
		for(int i=0; i<domaine.size(); ++i) {
			int count = domaineDao.countMentionByDomaineAndTypeMention(domaine.get(i).getCode() , type);
			if(count > 0) {
				result.add(domaine.get(i));
			}
		}
		return result;
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
