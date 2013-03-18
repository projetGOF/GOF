package gof.dao;

import gof.model.Specialite;

import java.util.Collection;

import org.springframework.stereotype.Repository;

@Repository
public interface SpecialiteDao {
	
	Collection<Specialite> findAllSpecialites();

	Specialite findSpecialite(String code);

	void saveSpecialite(Specialite s);

	void deleteSpecialite(Specialite s);
}
