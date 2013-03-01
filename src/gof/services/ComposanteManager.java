package gof.services;

import gof.model.Composante;

import java.util.Collection;

import org.springframework.stereotype.Service;

@Service
public interface ComposanteManager {

	Collection<Composante> findAllComposantes();

	Composante findComposante(String code);

	void saveComposante(Composante c);

	void deleteComposante(Composante c);
}
