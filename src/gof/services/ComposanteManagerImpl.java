package gof.services;

import gof.dao.ComposanteDao;
import gof.model.Composante;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ComposanteManagerImpl implements ComposanteManager {

	@Autowired
	private ComposanteDao composanteDao;
	
	@Override
	@Transactional
	public Collection<Composante> findAllComposantes() {
		return composanteDao.findAllComposantes();
	}

	@Override
	@Transactional
	public Composante findComposante(String code) {
		return composanteDao.findComposante(code);
	}

	@Override
	@Transactional
	public void saveComposante(Composante c) {
		composanteDao.saveComposante(c);
	}

	@Override
	@Transactional
	public void deleteComposante(Composante c) {
		composanteDao.deleteComposante(c);
	}

}
