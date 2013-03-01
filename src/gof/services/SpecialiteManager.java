package gof.services;

import gof.model.Specialite;

import java.util.Collection;

import org.springframework.stereotype.Service;

@Service
public interface SpecialiteManager {
	
	Collection<Specialite> findAllSpecialites();

	Specialite findSpecialite(String code);

	void saveSpecialite(Specialite s);

	void deleteSpecialite(Specialite s);

}
