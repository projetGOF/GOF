package gof.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import gof.dao.DomaineDao;
import gof.dao.MentionDao;
import gof.model.Domaine;
import gof.model.Mention;
import gof.model.TypeMention;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MentionManagerImpl implements MentionManager {

	@Autowired
	private MentionDao mentionDao;
	
	@Autowired
	private DomaineDao domaineDao;
	
	@Override
	@Transactional
	public Collection<Mention> findAllMentions() {
		return mentionDao.findAllMentions();
	}
	

	@Override
	@Transactional
	public Set<Mention> findAllMentionByTypeMention(TypeMention type) {
		ArrayList<Mention> mention = (ArrayList<Mention>) mentionDao.findAllMentions();
		HashSet<Mention> result = new HashSet<Mention>();
		
		for(int i=0; i< mention.size(); ++i) {
			if(mention.get(i).getTypeMention()==type) {
				result.add(mention.get(i));
			}
		}
		
		return result;
	}
	
	@Override
	@Transactional
	public Set<Mention> findAllMentionsByDomaineAndTypeMention(String codeDomaine, TypeMention type) {
		ArrayList<Mention> mention = (ArrayList<Mention>) mentionDao.findAllMentions();
		HashSet<Mention> result = new HashSet<Mention>();
		
		Domaine domaine = domaineDao.findDomaine(codeDomaine);
		
		for(int i=0; i<mention.size(); ++i) {
			if(mention.get(i).getTypeMention().equals(type) && mention.get(i).getDomaines().contains(domaine))
				result.add(mention.get(i));
		}
		return result;
	}

	@Override
	@Transactional
	public Mention findMention(String code) {
		return mentionDao.findMention(code);
	}

	@Override
	@Transactional
	public void saveMention(Mention m) {
		mentionDao.saveMention(m);
	}

	@Override
	@Transactional
	public void deleteMention(Mention m) {
		mentionDao.deleteMention(m);
	}
}
