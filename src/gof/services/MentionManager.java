package gof.services;

import gof.model.Domaine;
import gof.model.Mention;
import gof.model.TypeMention;

import java.util.Collection;

import org.springframework.stereotype.Service;

@Service
public interface MentionManager {
	
	Collection<Mention> findAllMentions();
	
	Collection<Mention> findAllMentionByTypeMention(TypeMention type);
	
	Collection<Mention> findAllMentionsByDomaineAndTypeMention(String domaine, TypeMention type);
	
	Collection<Domaine> findAllDomaineByTypeMention(TypeMention type);

	Mention findMention(String code);

	void saveMention(Mention m);

	void deleteMention(Mention m);
	

}
