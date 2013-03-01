package gof.services;

import gof.model.Mention;

import java.util.Collection;

import org.springframework.stereotype.Service;

@Service
public interface MentionManager {
	
	Collection<Mention> findAllMentions();

	Mention findMention(String code);

	void saveMention(Mention m);

	void deleteMention(Mention m);

}
