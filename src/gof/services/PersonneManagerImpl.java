package gof.services;

import java.util.Collection;

import gof.dao.PersonneDao;
import gof.model.Personne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonneManagerImpl implements PersonneManager
{

	@Autowired
	private PersonneDao personneDao;
	
	@Override
	@Transactional
	public Collection<Personne> findAllPersonnes()
	{
		return personneDao.findAllPersonnes();
	}

	@Override
	@Transactional
	public Personne findPersonByIdExt(String idext)
	{
		return personneDao.findPersonneByIdExt(idext);
	}

	@Override
	@Transactional
	public void savePersonne(Personne p)
	{
		personneDao.savePersonne(p);
	}

	@Override
	@Transactional
	public void deletePersonne(Personne p)
	{
		personneDao.deletePersonne(p);
	}
	
	@Override
	@Transactional
	public Personne findPersonByCode(String code)
	{
		return personneDao.findPersonneByCode(code);
	}

}
