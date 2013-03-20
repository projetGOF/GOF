package gof.services;

import gof.model.Mention;
import gof.model.TypeMention;

import java.util.Collection;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public interface MentionManager {
	
	Collection<Mention> findAllMentions();
	
	Set<Mention> findAllMentionByTypeMention(TypeMention type);
	
	Set<Mention> findAllMentionsByDomaineAndTypeMention(String codeDomaine, TypeMention type);

	Mention findMention(String code);

	void saveMention(Mention m);

	void deleteMention(Mention m);
}
