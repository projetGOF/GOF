package gof.services;

import java.util.Collection;

import gof.dao.PersonneDao;
import gof.model.ComposantProgramme;
import gof.model.ElemStruct;
import gof.model.Enseignement;
import gof.model.Mention;
import gof.model.Personne;
import gof.model.Programme;
import gof.model.Specialite;
import gof.model.UECat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonneManagerImpl implements PersonneManager
{
	@Autowired
	private PersonneDao personneDao;
	
	@Autowired
	private ElemStructManager elemStructManager;
	
	/**
	 * Encodeur de mot de passe (SHA1)
	 */
	@Autowired
	private ShaPasswordEncoder passwordEncoder;
	
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
		p.setPassword(passwordEncoder.encodePassword(p.getPassword(), null));
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

	@Transactional
	public boolean isPersonneHasRightOnMention(Personne personne, Mention mention)
	{
		if(mention.getResponsables().contains(personne))
			return true;
		
		return false;
	}
	
	@Transactional
	public boolean isPersonneHasRightOnSpecialite(Personne personne, Specialite specialite)
	{
		if(specialite.getResponsables().contains(personne) || isPersonneHasRightOnMention(personne, specialite.getMention()))
			return true;
		
		return false;
	}
	
	@Transactional
	public boolean isPersonneHasRightOnProgramme(Personne personne, Programme programme)
	{
		if(programme.getResponsables().contains(personne)) // La personne est directement responsable du programme
			return true;
		else if(isPersonneHasRightOnMention(personne, programme.getMention())) // La personne est responsable de la mention à laquelle est rattaché le programme
			return true;
		
		return false;
	}
	
	@Transactional
	public boolean isPersonneHasRightOnUECat(Personne personne, UECat uecat)
	{
		if(uecat.getResponsables().contains(personne))
			return true;
		
		return false;
	}
	
	@Transactional
	public boolean isPersonneHasRightOnComposantProg(Personne personne, ComposantProgramme compProg)
	{
		return isPersonneHasRightOnProgramme(personne, compProg.getProgramme());
	}
	
	@Transactional
	public boolean isPersonneHasRightOnEnseignement(Personne personne, Enseignement ens)
	{
		if(ens.getResponsables().contains(personne)) // La personne est directement responsable de l'enseignement
			return true;
		else if(isPersonneHasRightOnProgramme(personne, ens.getProgramme())) // La personne est responsable du programme auquel est rattaché l'enseignement
			return true;
		
		return false;
	}
	
	@Transactional
	public boolean isPersonneHasRightOnElemStruct(Personne personne, ElemStruct element)
	{
		if(element instanceof Programme)
		{
			return isPersonneHasRightOnProgramme(personne, (Programme) element);
		}
		else if(element instanceof UECat)
		{
			return isPersonneHasRightOnUECat(personne, (UECat) element);
		}
		else if(element instanceof ComposantProgramme)
		{
			return isPersonneHasRightOnComposantProg(personne, (ComposantProgramme) element);
		}
		else if(element instanceof Enseignement)
		{
			return isPersonneHasRightOnEnseignement(personne, (Enseignement) element);
		}
		
		return false;
	}

}
