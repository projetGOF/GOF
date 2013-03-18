package gof.services;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import gof.dao.PersonneDao;
import gof.model.ElemStruct;
import gof.model.Enseignement;
import gof.model.Mention;
import gof.model.Personne;
import gof.model.Programme;
import gof.model.Specialite;
import gof.model.UECat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonneManagerImpl implements PersonneManager
{
	@Autowired
	private PersonneDao personneDao;
	
	@Autowired
	private ElemStructManager elemStructManager;
	
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

	@Override
	@Transactional
	public Set<String> findAllCodesFiches(Personne p) {
		
		HashSet<String> codesHashSet = new HashSet<String>();
		
		/* Mentions */
		
		for(Iterator<Mention> itMention = p.getMentions().iterator(); itMention.hasNext(); )
		{
			Mention currentMention = itMention.next();
			
			codesHashSet.add(currentMention.getCode());
			
			/* Specialites de la mention */
			
			for(Iterator<Specialite> itSpe = currentMention.getSpecialites().iterator(); itSpe.hasNext(); )
			{
				Specialite currentSpe = itSpe.next();
				
				codesHashSet.add(currentSpe.getCode());
				
				/* Programmes de la specialite */
				
				for(Iterator<Programme> itProg = currentSpe.getProgrammes().iterator(); itProg.hasNext(); )
				{
					Programme currentProg = itProg.next();
					
					codesHashSet.add(currentProg.getCode());
					
					/* ElemStructs du programme */
					
					HashSet<ElemStruct> elemStructHashSet = (HashSet<ElemStruct>) elemStructManager.getElemStructTree(currentProg.getCode());
					
					for(Iterator<ElemStruct> itElem = elemStructHashSet.iterator(); itElem.hasNext(); )
					{
						ElemStruct currentElemStruct = itElem.next();
						
						codesHashSet.add(currentElemStruct.getCode());				
					}
				}
			}
			
			/* Programmes de la mention */
			
			for(Iterator<Programme> itProg = currentMention.getProgrammes().iterator(); itProg.hasNext(); )
			{
				Programme currentProg = itProg.next();
				
				codesHashSet.add(currentProg.getCode());
				
				/* ElemStructs du programme */
				
				HashSet<ElemStruct> elemStructHashSet = (HashSet<ElemStruct>) elemStructManager.getElemStructTree(currentProg.getCode());
				
				for(Iterator<ElemStruct> itElem = elemStructHashSet.iterator(); itElem.hasNext(); )
				{
					ElemStruct currentElemStruct = itElem.next();
					
					codesHashSet.add(currentElemStruct.getCode());				
				}
			}
		}
		
		/* Specialites */
		
		for(Iterator<Specialite> itSpe = p.getSpecialites().iterator(); itSpe.hasNext(); )
		{
			Specialite currentSpe = itSpe.next();
			
			codesHashSet.add(currentSpe.getCode());
			
			/* Programmes de la specialite */
			
			for(Iterator<Programme> itProg = currentSpe.getProgrammes().iterator(); itProg.hasNext(); )
			{
				Programme currentProg = itProg.next();
				
				codesHashSet.add(currentProg.getCode());
				
				/* ElemStructs du programme */
				
				HashSet<ElemStruct> elemStructHashSet = (HashSet<ElemStruct>) elemStructManager.getElemStructTree(currentProg.getCode());
				
				for(Iterator<ElemStruct> itElem = elemStructHashSet.iterator(); itElem.hasNext(); )
				{
					ElemStruct currentElemStruct = itElem.next();
					
					codesHashSet.add(currentElemStruct.getCode());				
				}
			}
		}
		
		/* Programmes */
		
		for(Iterator<Programme> itProg = p.getProgrammes().iterator(); itProg.hasNext(); )
		{
			Programme currentProg = itProg.next();
			
			codesHashSet.add(currentProg.getCode());
			
			/* ElemStructs du programme */
			
			HashSet<ElemStruct> elemStructHashSet = (HashSet<ElemStruct>) elemStructManager.getElemStructTree(currentProg.getCode());
			
			for(Iterator<ElemStruct> itElem = elemStructHashSet.iterator(); itElem.hasNext(); )
			{
				ElemStruct currentElemStruct = itElem.next();
				
				codesHashSet.add(currentElemStruct.getCode());				
			}
		}
		
		/* UECats */
		
		for(Iterator<UECat> itUECat = p.getUecats().iterator(); itUECat.hasNext(); )
		{
			UECat currentUECat = itUECat.next();
			
			codesHashSet.add(currentUECat.getCode());
			
			/* ElemStructs de l'UECat */
			
			HashSet<ElemStruct> elemStructHashSet = (HashSet<ElemStruct>) elemStructManager.getElemStructTree(currentUECat.getCode());
			
			for(Iterator<ElemStruct> itElem = elemStructHashSet.iterator(); itElem.hasNext(); )
			{
				ElemStruct currentElemStruct = itElem.next();
				
				codesHashSet.add(currentElemStruct.getCode());				
			}
		}
		
		/* Enseignements */
		
		for(Iterator<Enseignement> itEns = p.getEnseignements().iterator(); itEns.hasNext(); )
		{
			Enseignement currentEns = itEns.next();
			
			codesHashSet.add(currentEns.getCode());
			
			/* ElemStructs de l'Enseignement */
			
			HashSet<ElemStruct> elemStructHashSet = (HashSet<ElemStruct>) elemStructManager.getElemStructTree(currentEns.getCode());
			
			for(Iterator<ElemStruct> itElem = elemStructHashSet.iterator(); itElem.hasNext(); )
			{
				ElemStruct currentElemStruct = itElem.next();
				
				codesHashSet.add(currentElemStruct.getCode());				
			}
		}
		
		return codesHashSet;
	}

}
