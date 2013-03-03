package gof.services;

import java.util.Collection;

import org.springframework.stereotype.Service;
import gof.model.DomaineComposante;

@Service
public interface DomaineComposanteManager {
	Collection<DomaineComposante> findAllDomainesComposantes();

	DomaineComposante findDomaineComposante(String code);

	void saveDomaineComposante(DomaineComposante d);

	void deleteDomaineComposante(DomaineComposante d);
}