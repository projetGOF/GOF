package gof.services;

import gof.dao.DomaineComposanteDao;
import gof.model.DomaineComposante;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DomaineComposanteManagerImpl implements DomaineComposanteManager {

	@Autowired
	private DomaineComposanteDao domaineComposanteDao;
	
	@Override
	@Transactional
	public Collection<DomaineComposante> findAllDomainesComposantes() {
		return domaineComposanteDao.findAllDomainesComposantes();
	}

	@Override
	@Transactional
	public DomaineComposante findDomaineComposante(String code) {
		return domaineComposanteDao.findDomaineComposante(code);
	}

	@Override
	@Transactional
	public void saveDomaineComposante(DomaineComposante d) {
		domaineComposanteDao.saveDomaineComposante(d);
	}

	@Override
	@Transactional
	public void deleteDomaineComposante(DomaineComposante d) {
		domaineComposanteDao.deleteDomaineComposante(d);
	}
}