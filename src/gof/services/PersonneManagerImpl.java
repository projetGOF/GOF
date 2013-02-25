package gof.services;

import java.util.Collection;

import gof.dao.PersonneDao;
import gof.model.Personne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonneManagerImpl implements PersonneManager
{

	@Autowired
	private PersonneDao personneDao;
	
	public Collection<Personne> findAllPersonnes()
	{
		return personneDao.findAllPersonnes();
	}

	public Personne findPersonByIdExt(String idext)
	{
		return personneDao.findPersonneByIdExt(idext);
	}

	public void savePersonne(Personne p)
	{
		personneDao.savePersonne(p);
	}

	public void deletePersonne(Personne p)
	{
		personneDao.deletePersonne(p);
	}

	public Personne findPersonByCode(String code)
	{
		return personneDao.findPersonneByCode(code);
	}

}
