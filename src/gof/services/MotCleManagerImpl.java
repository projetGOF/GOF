package gof.services;

import gof.dao.MotCleDao;
import gof.model.MotCle;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MotCleManagerImpl implements MotCleManager {

	@Autowired
	private MotCleDao motCleDao;
	
	@Override
	@Transactional
	public Collection<MotCle> findAllMotsCles() {
		return motCleDao.findAllMotsCles();
	}

	@Override
	@Transactional
	public MotCle findMotCle(String motcle) {
		return motCleDao.findMotCle(motcle);
	}

	@Override
	@Transactional
	public void saveMotCle(MotCle mc) {
		motCleDao.saveMotCle(mc);
	}

	@Override
	@Transactional
	public void deleteMotCle(MotCle mc) {
		motCleDao.deleteMotCle(mc);
	}

}
