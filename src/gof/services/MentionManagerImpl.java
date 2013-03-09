package gof.services;

import java.util.ArrayList;
import java.util.Collection;

import gof.dao.MentionDao;
import gof.model.Mention;
import gof.model.TypeMention;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MentionManagerImpl implements MentionManager {

	@Autowired
	private MentionDao mentionDao;
	
	@Override
	@Transactional
	public Collection<Mention> findAllMentions() {
		return mentionDao.findAllMentions();
	}
	
	@Override
	@Transactional
	public Collection<Mention> findAllMentionsByDomaine(String domaine) {
		return mentionDao.findAllMentionsByDomaine(domaine);
	}
	
	@Override
	@Transactional
	public Collection<Mention> findAllMentionsByDomaineAndTypeMention(String domaine, TypeMention type) {
		ArrayList<Mention> mention = (ArrayList<Mention>) mentionDao.findAllMentionsByDomaine(domaine);
		ArrayList<Mention> result = new ArrayList<Mention>();
		for(int i=0; i<mention.size(); ++i) {
			if(mention.get(i).getTypeMention()==type) {
				result.add(mention.get(i));
			}
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
