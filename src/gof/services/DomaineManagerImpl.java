package gof.services;

import gof.dao.DomaineDao;
import gof.dao.MentionDao;
import gof.model.Domaine;
import gof.model.Mention;
import gof.model.TypeMention;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DomaineManagerImpl implements DomaineManager {

	@Autowired
	private DomaineDao domaineDao;
	
	@Autowired
	private MentionDao mentionDao;
	
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

	@Override
	@Transactional
	public Set<Domaine> findAllDomaineByTypeMention(TypeMention type) {
		
		ArrayList<Mention> mentions = (ArrayList<Mention>) mentionDao.findAllMentions();
		HashSet<Domaine> result = new HashSet<Domaine>();
		
		for(int i = 0; i < mentions.size(); ++i)
		{
			if(mentions.get(i).getTypeMention().equals(type))
				result.addAll(mentions.get(i).getDomaines());
		}
		
		return result;
	}

}
