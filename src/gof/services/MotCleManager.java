package gof.services;

import gof.model.MotCle;

import java.util.Collection;

import org.springframework.stereotype.Service;

@Service
public interface MotCleManager {
	
	Collection<MotCle> findAllMotsCles();

	MotCle findMotCle(String motcle);

	void saveMotCle(MotCle mc);

	void deleteMotCle(MotCle mc);

}
