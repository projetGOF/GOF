package gof.services;

import java.util.ArrayList;
import java.util.Collection;

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
	
	@Override
	@Transactional
	public Collection<Mention> findAllMentions() {
		return mentionDao.findAllMentions();
	}
	

	@Override
	@Transactional
	public Collection<Mention> findAllMentionByTypeMention(TypeMention type) {
		ArrayList<Mention> mention = (ArrayList<Mention>) mentionDao.findAllMentions();
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
	public Collection<Mention> findAllMentionsByDomaineAndTypeMention(String domaine, TypeMention type) {
		ArrayList<Mention> mention = (ArrayList<Mention>) this.findAllMentionByTypeMention(type);
		ArrayList<Mention> result = new ArrayList<Mention>();
		for(int i=0; i<mention.size(); ++i) {
			ArrayList<Domaine> temp = new ArrayList<Domaine>();
			boolean isExist = false;
			
			temp.addAll(mention.get(i).getDomaines());
			
			for(int j=0; j<temp.size(); ++j) {
				if(domaine.equals(temp.get(j).getCode())) {
					isExist=true;
				}
			}
				
			if(isExist==true)
				result.add(mention.get(i));
		}
		return result;
	}
	
	@Override
	@Transactional
	public Collection<Domaine> findAllDomaineByTypeMention(TypeMention type) {
		ArrayList<Mention> mention = (ArrayList<Mention>) this.findAllMentionByTypeMention(type);
		ArrayList<Domaine> result = new ArrayList<Domaine>();
		ArrayList<Domaine> temp = new ArrayList<Domaine>();
		for(int i=0; i<mention.size(); ++i) {
			temp.addAll(mention.get(i).getDomaines());
		}
		result.add(temp.get(0));
		for(int i=1; i<temp.size(); ++i) {
			boolean isExist = false;
			for(int j=0; j<result.size(); j++)
				if(temp.get(i).getCode()==result.get(j).getCode())
					isExist=true;
			if(!isExist)
				result.add(temp.get(i));
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
