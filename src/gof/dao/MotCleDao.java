package gof.dao;

import gof.model.MotCle;

import java.util.Collection;

import org.springframework.stereotype.Repository;

@Repository
public interface MotCleDao {
	
	Collection<MotCle> findAllMotsCles();

	MotCle findMotCle(String motcle);

	void saveMotCle(MotCle mc);

	void deleteMotCle(MotCle mc);

}
