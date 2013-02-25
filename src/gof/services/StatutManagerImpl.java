package gof.services;

import gof.dao.StatutDao;
import gof.model.Statut;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatutManagerImpl implements StatutManager
{
	@Autowired
	private StatutDao statutDao;
	
	public Collection<Statut> findAllStatut() {
		return statutDao.findAllStatut();
	}

	public Statut findStatut(String code) {
		return statutDao.findStatut(code);
	}

	public void saveStatut(Statut s) {
		statutDao.saveStatut(s);
	}

	public void deleteStatut(Statut s) {
		statutDao.deleteStatut(s);
	}

}
