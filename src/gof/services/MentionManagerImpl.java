package gof.services;

import gof.dao.MentionDao;
import gof.model.Mention;

import java.util.Collection;

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
