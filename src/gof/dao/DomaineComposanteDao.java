package gof.dao;

import gof.model.DomaineComposante;

import java.util.Collection;

import org.springframework.stereotype.Repository;

@Repository
public interface DomaineComposanteDao {
	Collection<DomaineComposante> findAllDomainesComposantes();

	DomaineComposante findDomaineComposante(String code);

	void saveDomaineComposante(DomaineComposante c);

	void deleteDomaineComposante(DomaineComposante c);
}