package gof.dao;

import gof.model.Composante;

import java.util.Collection;

import org.springframework.stereotype.Repository;

@Repository
public interface ComposanteDao {

	Collection<Composante> findAllComposantes();

	Composante findComposante(String code);

	void saveComposante(Composante c);

	void deleteComposante(Composante c);
}
