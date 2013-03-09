package gof.dao;

import gof.model.Mention;

import java.util.Collection;

import org.springframework.stereotype.Repository;

@Repository
public interface MentionDao {
	
	Collection<Mention> findAllMentions();
	
	Collection<Mention> findAllMentionsByDomaine(String domaine);

	Mention findMention(String code);

	void saveMention(Mention m);

	void deleteMention(Mention m);

}
