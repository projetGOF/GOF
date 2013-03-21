package gof.services;

import java.util.Collection;

import gof.model.ComposantProgramme;
import gof.model.ElemStruct;
import gof.model.Enseignement;
import gof.model.Mention;
import gof.model.Personne;
import gof.model.Programme;
import gof.model.Specialite;
import gof.model.UECat;

import org.springframework.stereotype.Service;

@Service
public interface PersonneManager
{
	Collection<Personne> findAllPersonnes();

	Personne findPersonByCode(String code);
	
	Personne findPersonByIdExt(String idext);

	void savePersonne(Personne p);
	
	void deletePersonne(Personne p);
	
	boolean isPersonneHasRightOnMention(Personne personne, Mention mention);
	
	boolean isPersonneHasRightOnSpecialite(Personne personne, Specialite specialite);
	
	boolean isPersonneHasRightOnProgramme(Personne personne, Programme programme);
	
	boolean isPersonneHasRightOnUECat(Personne personne, UECat uecat);
	
	boolean isPersonneHasRightOnComposantProg(Personne personne, ComposantProgramme compProg);
	
	boolean isPersonneHasRightOnEnseignement(Personne personne, Enseignement ens);
	
	boolean isPersonneHasRightOnElemStruct(Personne personne, ElemStruct element);
}
