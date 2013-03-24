package gof.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import gof.model.ArianeItem;
import gof.model.ComposantProgramme;
import gof.model.Domaine;
import gof.model.ElemStruct;
import gof.model.Enseignement;
import gof.model.Mention;
import gof.model.Personne;
import gof.model.Programme;
import gof.model.Specialite;
import gof.model.TypeMention;
import gof.model.UECat;
import gof.services.Ariane;
import gof.services.ComposantProgrammeManager;
import gof.services.CustomUserDetails;
import gof.services.DomaineManager;
import gof.services.ElemStructManager;
import gof.services.EnseignementManager;
import gof.services.MentionManager;
import gof.services.PersonneManager;
import gof.services.ProgrammeManager;
import gof.services.SpecialiteManager;
import gof.services.UECatManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Transactional
public class GofController
{
	@Autowired
	MentionManager mentionManager;

	@Autowired
	DomaineManager domaineManager;

	@Autowired
	SpecialiteManager specialiteManager;

	@Autowired
	PersonneManager personneManager;

	@Autowired
	ElemStructManager elemStructManager;

	@Autowired
	ProgrammeManager programmeManager;

	@Autowired
	UECatManager uecatManager;

	@Autowired
	ComposantProgrammeManager composantProgManager;

	@Autowired
	EnseignementManager enseignementManager;
	
	Ariane ariane;
	
	public ArrayList<ArianeItem> filAriane(String url, String nom) 
	{
		if(this.ariane==null) this.ariane= new Ariane();
		this.ariane.add(url, nom);
		return this.ariane.getArianeFil();
	}

	@RequestMapping("/accueil.htm")
	public ModelAndView home(Model model)
	{		
		if(CustomUserDetails.isUserConnected())
			model.addAttribute("loggedPersonne", personneManager.findPersonByIdExt(CustomUserDetails.getCurrentUserLogin()));
		model.addAttribute("arianes", filAriane("accueil.htm", "Home"));
		return new ModelAndView("home");
	}

	@RequestMapping("/identification.htm")
	public ModelAndView login()
	{
		return new ModelAndView("login");
	}

	@RequestMapping("/identification-echec.htm")
	public ModelAndView loginFailure(Model model)
	{
		model.addAttribute("error", "true");
		return new ModelAndView("login");
	}

	@RequestMapping("/acces-refuse.htm")
	public ModelAndView accessDenied()
	{
		return new ModelAndView("accessDenied");
	}

	@RequestMapping("/licence{diplome}.htm")
	public ModelAndView domaines(@PathVariable("diplome") String codeDiplome, Model model)
	{
		model.addAttribute("type", codeDiplome);
		model.addAttribute("domaines", this.domaineManager.findAllDomaineByTypeMention(TypeMention.LICENCE));
		model.addAttribute("arianes", filAriane("licence.htm", "Licences"));
		return new ModelAndView("licence");
	}

	@RequestMapping("/licenceDetail{domaine}.htm")
	public ModelAndView domainesDetail(@PathVariable("domaine") String codeDomaine, Model model)
	{
		Domaine domaine = this.domaineManager.findDomaine(codeDomaine);
		
		if(domaine == null)
			return new ModelAndView("accessDenied");
		
		model.addAttribute("domaine", domaine);
		model.addAttribute("mentions", this.mentionManager.findAllMentionsByDomaineAndTypeMention(codeDomaine, TypeMention.LICENCE));
		model.addAttribute("arianes", filAriane("licenceDetail"+codeDomaine+".htm", "Licence: "+domaine.getNom()));
		return new ModelAndView("licenceDetail");
	}

	@RequestMapping("/licencePro{diplome}.htm")
	public ModelAndView licencePromaster(@PathVariable("diplome") String codeDiplome, Model model)
	{
		model.addAttribute("type", codeDiplome);
		model.addAttribute("domaines", this.domaineManager.findAllDomaineByTypeMention(TypeMention.LICENCEPRO));
		model.addAttribute("arianes", filAriane("licencePro.htm", "Licences Professionnelles"));
		return new ModelAndView("licencePro");
	}

	@RequestMapping("/licenceProDetail{domaine}.htm")
	public ModelAndView licenceProDetail(@PathVariable("domaine") String codeDomaine, Model model)
	{
		Domaine domaine = this.domaineManager.findDomaine(codeDomaine);
		
		if(domaine == null)
			return new ModelAndView("accessDenied");
		
		model.addAttribute("domaine", domaine);
		model.addAttribute("mentions", this.mentionManager.findAllMentionsByDomaineAndTypeMention(codeDomaine, TypeMention.LICENCEPRO));
		model.addAttribute("arianes", filAriane("licenceProDetail"+codeDomaine+".htm", "Licence Professionnelle: "+domaine.getNom()));
		return new ModelAndView("licenceProDetail");
	}

	@RequestMapping("/master{diplome}.htm")
	public ModelAndView master(@PathVariable("diplome") String codeDiplome, Model model)
	{
		model.addAttribute("type", codeDiplome);
		model.addAttribute("domaines", this.domaineManager.findAllDomaineByTypeMention(TypeMention.MASTER));
		model.addAttribute("arianes", filAriane("master.htm", "Masters"));
		return new ModelAndView("master");
	}

	@RequestMapping("/masterDetail{domaine}.htm")
	public ModelAndView masterDetail(@PathVariable("domaine") String codeDomaine, Model model)
	{
		Domaine domaine = this.domaineManager.findDomaine(codeDomaine);
				
		if(domaine == null)
			return new ModelAndView("accessDenied");
		
		model.addAttribute("domaine", domaine);
		model.addAttribute("mentions", this.mentionManager.findAllMentionsByDomaineAndTypeMention(codeDomaine, TypeMention.MASTER));
		model.addAttribute("arianes", filAriane("masterDetail"+codeDomaine+".htm", "Masters: "+domaine.getNom()));
		return new ModelAndView("masterDetail");
	}

	@RequestMapping("/mention{mention}.htm")
	public ModelAndView mention(@PathVariable("mention") String codeMention, Model model)
	{
		Mention mention = this.mentionManager.findMention(codeMention);

		if(mention == null)
			return new ModelAndView("accessDenied");
		
		if(CustomUserDetails.isUserConnected())
		{
			model.addAttribute("erreursStruct", mention.getErreursStruct());

			if(personneManager.isPersonneHasRightOnMention(personneManager.findPersonByIdExt(CustomUserDetails.getCurrentUserLogin()), mention))
			{	
				HashMap<Boolean, String> publiableMap = new HashMap<Boolean, String>();

				publiableMap.put(false, "Non");
				publiableMap.put(true, "Oui");

				model.addAttribute("edit","true");
				model.addAttribute("publiableMap", publiableMap);
			}
		}

		model.addAttribute("mention", mention);
		model.addAttribute("specialites", mention.getSpecialites());
		model.addAttribute("arianes", filAriane("mention"+codeMention+".htm", "Mention: "+mention.getNomCourt()));
		return new ModelAndView("mention");
	}

	@RequestMapping(value="/editMentionPubliable.htm", method=RequestMethod.POST)
	public ModelAndView editMentionPubliable(@ModelAttribute Mention oldMention, Model model)
	{
		Mention newMention = this.mentionManager.findMention(oldMention.getCode());
		
		if(!this.personneManager.isPersonneHasRightOnMention(this.personneManager.findPersonByIdExt(CustomUserDetails.getCurrentUserLogin()), newMention))
			return new ModelAndView("accessDenied");
		
		newMention.setPubliable(oldMention.isPubliable());
		this.mentionManager.saveMention(newMention);

		return new ModelAndView(new RedirectView("mention" + newMention.getCode() + ".htm"));
	}

	@RequestMapping("/specialite{specialite}.htm")
	public ModelAndView specialite(@PathVariable("specialite") String codeSpecialite, Model model)
	{
		Specialite specialite = this.specialiteManager.findSpecialite(codeSpecialite);

		if(specialite == null)
			return new ModelAndView("accessDenied");
		
		if(CustomUserDetails.isUserConnected())
		{
			model.addAttribute("erreursStruct", specialite.getErreursStruct());

			if(personneManager.isPersonneHasRightOnSpecialite(personneManager.findPersonByIdExt(CustomUserDetails.getCurrentUserLogin()), specialite))
			{
				HashMap<Boolean, String> publiableMap = new HashMap<Boolean, String>();

				publiableMap.put(false, "Non");
				publiableMap.put(true, "Oui");

				model.addAttribute("edit","true");
				model.addAttribute("publiableMap", publiableMap);
			}
		}

		model.addAttribute("specialite", specialite);
		model.addAttribute("programmes", specialite.getProgrammes());
		model.addAttribute("arianes", filAriane("specialite"+codeSpecialite+".htm", "Spécialité: "+specialite.getNomCourt()));
		return new ModelAndView("specialite");
	}

	@RequestMapping(value="/editSpecialitePubliable.htm", method=RequestMethod.POST)
	public ModelAndView editSpecialitePubliable(@ModelAttribute Specialite oldSpecialite, Model model)
	{
		Specialite newSpecialite = this.specialiteManager.findSpecialite(oldSpecialite.getCode());
		
		if(!this.personneManager.isPersonneHasRightOnSpecialite(this.personneManager.findPersonByIdExt(CustomUserDetails.getCurrentUserLogin()), newSpecialite))
			return new ModelAndView("accessDenied");
		
		newSpecialite.setPubliable(oldSpecialite.isPubliable());
		this.specialiteManager.saveSpecialite(newSpecialite);

		return new ModelAndView(new RedirectView("specialite" + newSpecialite.getCode() + ".htm"));
	}

	@RequestMapping("/programme{programme}.htm")
	public ModelAndView programme(@PathVariable("programme") String codeProgramme, Model model)
	{
		Programme programme = this.programmeManager.findProgramme(codeProgramme);

		if(programme == null)
			return new ModelAndView("accessDenied");
		
		ArrayList<Programme> programmeFils = new ArrayList<Programme>();
		ArrayList<UECat> uecatFils = new ArrayList<UECat>();
		ArrayList<ComposantProgramme> composantProgFils = new ArrayList<ComposantProgramme>();
		ArrayList<Enseignement> enseignementFils = new ArrayList<Enseignement>();

		for(Iterator<ElemStruct> it = programme.getElementsFils().iterator(); it.hasNext(); )
		{
			ElemStruct currentElement = it.next();

			if(currentElement instanceof Programme)
				programmeFils.add((Programme) currentElement);
			else if(currentElement instanceof UECat)
				uecatFils.add((UECat) currentElement);
			else if(currentElement instanceof ComposantProgramme)
				composantProgFils.add((ComposantProgramme) currentElement);
			else if(currentElement instanceof Enseignement)
				enseignementFils.add((Enseignement) currentElement);
		}

		if(CustomUserDetails.isUserConnected())
		{
			model.addAttribute("erreursStruct", programme.getErreursStruct());

			if(personneManager.isPersonneHasRightOnProgramme(personneManager.findPersonByIdExt(CustomUserDetails.getCurrentUserLogin()), programme))
			{
				HashMap<Boolean, String> publiableMap = new HashMap<Boolean, String>();

				publiableMap.put(false, "Non");
				publiableMap.put(true, "Oui");

				model.addAttribute("edit","true");
				model.addAttribute("publiableMap", publiableMap);
			}
		}

		model.addAttribute("programme", programme);
		model.addAttribute("programmeFils", programmeFils);
		model.addAttribute("uecatFils", uecatFils);
		model.addAttribute("composantProgFils", composantProgFils);
		model.addAttribute("enseignementFils", enseignementFils);
		model.addAttribute("arianes", filAriane("programme"+codeProgramme+".htm", "Programme: "+programme.getNom()));
		return new ModelAndView("programme");
	}

	@RequestMapping(value="/editProgrammePubliable.htm", method=RequestMethod.POST)
	public ModelAndView editProgrammePubliable(@ModelAttribute Programme oldProgramme, Model model)
	{
		Programme newProgramme = this.programmeManager.findProgramme(oldProgramme.getCode());
		
		if(!this.personneManager.isPersonneHasRightOnProgramme(this.personneManager.findPersonByIdExt(CustomUserDetails.getCurrentUserLogin()), newProgramme))
			return new ModelAndView("accessDenied");
		
		newProgramme.setPubliable(oldProgramme.isPubliable());
		this.programmeManager.saveProgramme(newProgramme);

		return new ModelAndView(new RedirectView("programme" + newProgramme.getCode() + ".htm"));
	}

	@RequestMapping("/uecat{uecat}.htm")
	public ModelAndView uecat(@PathVariable("uecat") String codeUECat, Model model)
	{
		UECat uecat = this.uecatManager.findUECat(codeUECat);

		if(uecat == null)
			return new ModelAndView("accessDenied");
		
		ArrayList<Programme> programmeFils = new ArrayList<Programme>();
		ArrayList<UECat> uecatFils = new ArrayList<UECat>();
		ArrayList<ComposantProgramme> composantProgFils = new ArrayList<ComposantProgramme>();
		ArrayList<Enseignement> enseignementFils = new ArrayList<Enseignement>();

		for(Iterator<ElemStruct> it = uecat.getElementsFils().iterator(); it.hasNext(); )
		{
			ElemStruct currentElement = it.next();

			if(currentElement instanceof Programme)
				programmeFils.add((Programme) currentElement);
			else if(currentElement instanceof UECat)
				uecatFils.add((UECat) currentElement);
			else if(currentElement instanceof ComposantProgramme)
				composantProgFils.add((ComposantProgramme) currentElement);
			else if(currentElement instanceof Enseignement)
				enseignementFils.add((Enseignement) currentElement);
		}

		if(CustomUserDetails.isUserConnected())
		{
			model.addAttribute("erreursStruct", uecat.getErreursStruct());

			if(personneManager.isPersonneHasRightOnUECat(personneManager.findPersonByIdExt(CustomUserDetails.getCurrentUserLogin()), uecat))
			{
				HashMap<Boolean, String> publiableMap = new HashMap<Boolean, String>();

				publiableMap.put(false, "Non");
				publiableMap.put(true, "Oui");

				model.addAttribute("edit","true");
				model.addAttribute("publiableMap", publiableMap);
			}
		}

		model.addAttribute("uecat", uecat);
		model.addAttribute("programmeFils", programmeFils);
		model.addAttribute("uecatFils", uecatFils);
		model.addAttribute("composantProgFils", composantProgFils);
		model.addAttribute("enseignementFils", enseignementFils);
		model.addAttribute("arianes", filAriane("composantProg"+codeUECat+".htm", "Unité d'enseignement: "+uecat.getNom()));
		return new ModelAndView("uecat");
	}

	@RequestMapping(value="/editUECatPubliable.htm", method=RequestMethod.POST)
	public ModelAndView editUECatPubliable(@ModelAttribute UECat oldUECat, Model model)
	{
		UECat newUECat = this.uecatManager.findUECat(oldUECat.getCode());
		
		if(!this.personneManager.isPersonneHasRightOnUECat(this.personneManager.findPersonByIdExt(CustomUserDetails.getCurrentUserLogin()), newUECat))
			return new ModelAndView("accessDenied");
		
		newUECat.setPubliable(oldUECat.isPubliable());
		this.uecatManager.saveUECat(newUECat);

		return new ModelAndView(new RedirectView("uecat" + newUECat.getCode() + ".htm"));
	}

	@RequestMapping("/composantProg{composantProg}.htm")
	public ModelAndView composantProg(@PathVariable("composantProg") String codeComposantProg, Model model)
	{
		ComposantProgramme composantProg = this.composantProgManager.findComposantProgramme(codeComposantProg);

		if(composantProg == null)
			return new ModelAndView("accessDenied");
		
		ArrayList<Programme> programmeFils = new ArrayList<Programme>();
		ArrayList<UECat> uecatFils = new ArrayList<UECat>();
		ArrayList<ComposantProgramme> composantProgFils = new ArrayList<ComposantProgramme>();
		ArrayList<Enseignement> enseignementFils = new ArrayList<Enseignement>();

		for(Iterator<ElemStruct> it = composantProg.getElementsFils().iterator(); it.hasNext(); )
		{
			ElemStruct currentElement = it.next();

			if(currentElement instanceof Programme)
				programmeFils.add((Programme) currentElement);
			else if(currentElement instanceof UECat)
				uecatFils.add((UECat) currentElement);
			else if(currentElement instanceof ComposantProgramme)
				composantProgFils.add((ComposantProgramme) currentElement);
			else if(currentElement instanceof Enseignement)
				enseignementFils.add((Enseignement) currentElement);
		}

		if(CustomUserDetails.isUserConnected())
		{
			model.addAttribute("erreursStruct", composantProg.getErreursStruct());

			if(personneManager.isPersonneHasRightOnComposantProg(personneManager.findPersonByIdExt(CustomUserDetails.getCurrentUserLogin()), composantProg))
			{
				HashMap<Boolean, String> publiableMap = new HashMap<Boolean, String>();

				publiableMap.put(false, "Non");
				publiableMap.put(true, "Oui");

				model.addAttribute("edit","true");
				model.addAttribute("publiableMap", publiableMap);
			}
		}

		model.addAttribute("composantProg", composantProg);
		model.addAttribute("programmeFils", programmeFils);
		model.addAttribute("uecatFils", uecatFils);
		model.addAttribute("composantProgFils", composantProgFils);
		model.addAttribute("enseignementFils", enseignementFils);
		model.addAttribute("arianes", filAriane("composantProg"+codeComposantProg+".htm", "Composant de programme: "+composantProg.getNom()));
		return new ModelAndView("composantProg");
	}

	@RequestMapping(value="/editComposantProgPubliable.htm", method=RequestMethod.POST)
	public ModelAndView editComposantProgPubliable(@ModelAttribute ComposantProgramme oldComposantProg, Model model)
	{
		ComposantProgramme newComposantProg = this.composantProgManager.findComposantProgramme(oldComposantProg.getCode());
		
		if(!this.personneManager.isPersonneHasRightOnComposantProg(this.personneManager.findPersonByIdExt(CustomUserDetails.getCurrentUserLogin()), newComposantProg))
			return new ModelAndView("accessDenied");
		
		newComposantProg.setPubliable(oldComposantProg.isPubliable());
		this.composantProgManager.saveComposantProgramme(newComposantProg);

		return new ModelAndView(new RedirectView("composantProg" + newComposantProg.getCode() + ".htm"));
	}

	@RequestMapping("/enseignement{enseignement}.htm")
	public ModelAndView enseignement(@PathVariable("enseignement") String codeEnseignement, Model model)
	{
		Enseignement enseignement = this.enseignementManager.findEnseignement(codeEnseignement);

		if(enseignement == null)
			return new ModelAndView("accessDenied");
		
		ArrayList<Programme> programmeFils = new ArrayList<Programme>();
		ArrayList<UECat> uecatFils = new ArrayList<UECat>();
		ArrayList<ComposantProgramme> composantProgFils = new ArrayList<ComposantProgramme>();
		ArrayList<Enseignement> enseignementFils = new ArrayList<Enseignement>();

		for(Iterator<ElemStruct> it = enseignement.getElementsFils().iterator(); it.hasNext(); )
		{
			ElemStruct currentElement = it.next();

			if(currentElement instanceof Programme)
				programmeFils.add((Programme) currentElement);
			else if(currentElement instanceof UECat)
				uecatFils.add((UECat) currentElement);
			else if(currentElement instanceof ComposantProgramme)
				composantProgFils.add((ComposantProgramme) currentElement);
			else if(currentElement instanceof Enseignement)
				enseignementFils.add((Enseignement) currentElement);
		}

		if(CustomUserDetails.isUserConnected())
		{
			model.addAttribute("erreursStruct", enseignement.getErreursStruct());

			if(personneManager.isPersonneHasRightOnEnseignement(personneManager.findPersonByIdExt(CustomUserDetails.getCurrentUserLogin()), enseignement))
			{
				HashMap<Boolean, String> publiableMap = new HashMap<Boolean, String>();

				publiableMap.put(false, "Non");
				publiableMap.put(true, "Oui");

				model.addAttribute("edit","true");
				model.addAttribute("publiableMap", publiableMap);
			}
		}

		model.addAttribute("enseignement", enseignement);
		model.addAttribute("programmeFils", programmeFils);
		model.addAttribute("uecatFils", uecatFils);
		model.addAttribute("composantProgFils", composantProgFils);
		model.addAttribute("enseignementFils", enseignementFils);
		model.addAttribute("arianes", filAriane("enseignement"+codeEnseignement+".htm", "Enseignement: "+enseignement.getNom()));
		return new ModelAndView("enseignement");
	}

	@RequestMapping(value="/editEnseignementPubliable.htm", method=RequestMethod.POST)
	public ModelAndView editEnseignementPubliable(@ModelAttribute Enseignement oldEnseignement, Model model)
	{	
		Enseignement newEnseignement = this.enseignementManager.findEnseignement(oldEnseignement.getCode());
		
		if(!this.personneManager.isPersonneHasRightOnEnseignement(this.personneManager.findPersonByIdExt(CustomUserDetails.getCurrentUserLogin()), newEnseignement))
			return new ModelAndView("accessDenied");
		
		newEnseignement.setPubliable(oldEnseignement.isPubliable());
		this.enseignementManager.saveEnseignement(newEnseignement);

		return new ModelAndView(new RedirectView("enseignement" + newEnseignement.getCode() + ".htm"));
	}

	@RequestMapping("/etat.htm")
	public ModelAndView etat(Model model)
	{
		model.addAttribute("domaines", this.domaineManager.findAllDomaines());
		model.addAttribute("mentionL", this.mentionManager.findAllMentionByTypeMention(TypeMention.LICENCE));
		model.addAttribute("mentionLP", this.mentionManager.findAllMentionByTypeMention(TypeMention.LICENCEPRO));
		model.addAttribute("mentionM", this.mentionManager.findAllMentionByTypeMention(TypeMention.MASTER));

		return new ModelAndView("etat");
	}

	@RequestMapping("/responsablesROF.htm")
	public ModelAndView responsablesROF(Model model)
	{
		model.addAttribute("responsablesROF", this.personneManager.findAllRespoROF());
		model.addAttribute("arianes", filAriane("responsablesROF.htm", "Responsables ROF"));
		return new ModelAndView("responsablesROF");
	}

	/** Gestion des droits sur les mentions **/

	@RequestMapping("/responsablesMention{mention}.htm")
	public ModelAndView responsablesMention(@PathVariable("mention") String codeMention, Model model)
	{
		Mention mention = this.mentionManager.findMention(codeMention);

		if(mention == null)
			return new ModelAndView("accessDenied");
		
		Personne currentUser = this.personneManager.findPersonByIdExt(CustomUserDetails.getCurrentUserLogin());

		if(!this.personneManager.isPersonneHasRightOnMention(currentUser, mention))
			return new ModelAndView("accessDenied");

		Set<Personne> responsables = mention.getResponsables();
		
		if(responsables.contains(currentUser))
			responsables.remove(currentUser);
		
		model.addAttribute("mention", mention);
		model.addAttribute("responsables", responsables);
		model.addAttribute("arianes", filAriane("responsablesMention"+codeMention+".htm", "Responsables de la Mention: "+mention.getNomCourt()));
		return new ModelAndView("responsablesMention");
	}

	@RequestMapping(value="/supprimerResponsableMention{mention}.htm", method=RequestMethod.POST)
	public ModelAndView deleteResponsableMentionOnSubmit(@PathVariable("mention") String codeMention, @ModelAttribute Personne responsable, Model model)
	{
		Mention mention = this.mentionManager.findMention(codeMention);

		if(mention == null)
			return new ModelAndView("accessDenied");

		Personne personne = this.personneManager.findPersonByCode(responsable.getCode());

		if(!this.personneManager.isPersonneHasRightOnMention(this.personneManager.findPersonByIdExt(CustomUserDetails.getCurrentUserLogin()), mention))
			return new ModelAndView("accessDenied");

		if(mention.getResponsables().contains(personne))
		{
			mention.getResponsables().remove(personne);
			this.mentionManager.saveMention(mention);
		}

		return new ModelAndView(new RedirectView("responsablesMention" + mention.getCode() + ".htm"));
	}

	@RequestMapping(value="/ajouterResponsableMention{mention}.htm", method=RequestMethod.GET)
	public ModelAndView addResponsableMention(@PathVariable("mention") String codeMention, Model model)
	{
		Mention mention = this.mentionManager.findMention(codeMention);

		if(mention == null)
			return new ModelAndView("accessDenied");

		if(!this.personneManager.isPersonneHasRightOnMention(this.personneManager.findPersonByIdExt(CustomUserDetails.getCurrentUserLogin()), mention))
			return new ModelAndView("accessDenied");

		Collection<Personne> personnes = this.personneManager.findAllPersonnes();
		personnes.removeAll(mention.getResponsables());

		model.addAttribute("mention", mention);
		model.addAttribute("personnes", personnes);

		return new ModelAndView("ajouterResponsableMention");
	}

	@RequestMapping(value="/ajouterResponsableMention{mention}.htm", method=RequestMethod.POST)
	public ModelAndView addResponsableMentionOnSubmit(@PathVariable("mention") String codeMention, @ModelAttribute Personne personne, Model model)
	{
		Mention mention = this.mentionManager.findMention(codeMention);

		if(mention == null)
			return new ModelAndView("accessDenied");

		Personne responsable = this.personneManager.findPersonByCode(personne.getCode());

		if(!this.personneManager.isPersonneHasRightOnMention(this.personneManager.findPersonByIdExt(CustomUserDetails.getCurrentUserLogin()), mention))
			return new ModelAndView("accessDenied");

		if(!mention.getResponsables().contains(responsable))
		{
			mention.getResponsables().add(responsable);
			this.mentionManager.saveMention(mention);
		}

		return new ModelAndView(new RedirectView("responsablesMention" + mention.getCode() + ".htm"));
	}

	/** Gestion des droits sur les specialites **/

	@RequestMapping("/responsablesSpecialite{specialite}.htm")
	public ModelAndView responsablesSpecialite(@PathVariable("specialite") String codeSpecialite, Model model)
	{
		Specialite specialite = this.specialiteManager.findSpecialite(codeSpecialite);

		if(specialite == null)
			return new ModelAndView("accessDenied");
		
		Personne currentUser = this.personneManager.findPersonByIdExt(CustomUserDetails.getCurrentUserLogin());

		if(!this.personneManager.isPersonneHasRightOnSpecialite(currentUser, specialite))
			return new ModelAndView("accessDenied");
		
		Set<Personne> responsables = specialite.getResponsables();
		
		if(responsables.contains(currentUser))
			responsables.remove(currentUser);

		model.addAttribute("specialite", specialite);
		model.addAttribute("responsables", specialite.getResponsables());
		model.addAttribute("arianes", filAriane("responsablesSpecialite"+codeSpecialite+".htm", "Responsables de la Spécialité: "+specialite.getNomCourt()));
		return new ModelAndView("responsablesSpecialite");
	}

	@RequestMapping(value="/supprimerResponsableSpecialite{specialite}.htm", method=RequestMethod.POST)
	public ModelAndView deleteResponsableSpecialiteOnSubmit(@PathVariable("specialite") String codeSpecialite, @ModelAttribute Personne responsable, Model model)
	{
		Specialite specialite = this.specialiteManager.findSpecialite(codeSpecialite);

		if(specialite == null)
			return new ModelAndView("accessDenied");

		Personne personne = this.personneManager.findPersonByCode(responsable.getCode());

		if(!this.personneManager.isPersonneHasRightOnSpecialite(this.personneManager.findPersonByIdExt(CustomUserDetails.getCurrentUserLogin()), specialite))
			return new ModelAndView("accessDenied");

		if(specialite.getResponsables().contains(personne))
		{
			specialite.getResponsables().remove(personne);
			this.specialiteManager.saveSpecialite(specialite);
		}

		return new ModelAndView(new RedirectView("responsablesSpecialite" + specialite.getCode() + ".htm"));
	}

	@RequestMapping(value="/ajouterResponsableSpecialite{specialite}.htm", method=RequestMethod.GET)
	public ModelAndView addResponsableSpecialite(@PathVariable("specialite") String codeSpecialite, Model model)
	{
		Specialite specialite = this.specialiteManager.findSpecialite(codeSpecialite);

		if(specialite == null)
			return new ModelAndView("accessDenied");

		if(!this.personneManager.isPersonneHasRightOnSpecialite(this.personneManager.findPersonByIdExt(CustomUserDetails.getCurrentUserLogin()), specialite))
			return new ModelAndView("accessDenied");

		Collection<Personne> personnes = this.personneManager.findAllPersonnes();
		personnes.removeAll(specialite.getResponsables());

		model.addAttribute("specialite", specialite);
		model.addAttribute("personnes", personnes);

		return new ModelAndView("ajouterResponsableSpecialite");
	}

	@RequestMapping(value="/ajouterResponsableSpecialite{specialite}.htm", method=RequestMethod.POST)
	public ModelAndView addResponsableSpecialiteOnSubmit(@PathVariable("specialite") String codeSpecialite, @ModelAttribute Personne personne, Model model)
	{
		Specialite specialite = this.specialiteManager.findSpecialite(codeSpecialite);

		if(specialite == null)
			return new ModelAndView("accessDenied");

		Personne responsable = this.personneManager.findPersonByCode(personne.getCode());

		if(!this.personneManager.isPersonneHasRightOnSpecialite(this.personneManager.findPersonByIdExt(CustomUserDetails.getCurrentUserLogin()), specialite))
			return new ModelAndView("accessDenied");

		if(!specialite.getResponsables().contains(responsable))
		{
			specialite.getResponsables().add(responsable);
			this.specialiteManager.saveSpecialite(specialite);
		}

		return new ModelAndView(new RedirectView("responsablesSpecialite" + specialite.getCode() + ".htm"));
	}

	/** Gestion des droits sur les programmes **/

	@RequestMapping("/responsablesProgramme{programme}.htm")
	public ModelAndView responsablesProgramme(@PathVariable("programme") String codeProgramme, Model model)
	{
		Programme programme = this.programmeManager.findProgramme(codeProgramme);

		if(programme == null)
			return new ModelAndView("accessDenied");
		
		Personne currentUser = this.personneManager.findPersonByIdExt(CustomUserDetails.getCurrentUserLogin());

		if(!this.personneManager.isPersonneHasRightOnProgramme(currentUser, programme))
			return new ModelAndView("accessDenied");
		
		Set<Personne> responsables = programme.getResponsables();
		
		if(responsables.contains(currentUser))
			responsables.remove(currentUser);

		model.addAttribute("programme", programme);
		model.addAttribute("responsables", responsables);
		model.addAttribute("arianes", filAriane("responsablesProgramme"+codeProgramme+".htm", "Responsable du Programme: "+programme.getNom()));
		return new ModelAndView("responsablesProgramme");
	}

	@RequestMapping(value="/supprimerResponsableProgramme{programme}.htm", method=RequestMethod.POST)
	public ModelAndView deleteResponsableProgrammeOnSubmit(@PathVariable("programme") String codeProgramme, @ModelAttribute Personne responsable, Model model)
	{
		Programme programme = this.programmeManager.findProgramme(codeProgramme);

		if(programme == null)
			return new ModelAndView("accessDenied");

		Personne personne = this.personneManager.findPersonByCode(responsable.getCode());

		if(!this.personneManager.isPersonneHasRightOnProgramme(this.personneManager.findPersonByIdExt(CustomUserDetails.getCurrentUserLogin()), programme))
			return new ModelAndView("accessDenied");

		if(programme.getResponsables().contains(personne))
		{
			programme.getResponsables().remove(personne);
			this.programmeManager.saveProgramme(programme);
		}

		return new ModelAndView(new RedirectView("responsablesProgramme" + programme.getCode() + ".htm"));
	}

	@RequestMapping(value="/ajouterResponsableProgramme{programme}.htm", method=RequestMethod.GET)
	public ModelAndView addResponsableProgramme(@PathVariable("programme") String codeProgramme, Model model)
	{
		Programme programme = this.programmeManager.findProgramme(codeProgramme);

		if(programme == null)
			return new ModelAndView("accessDenied");

		if(!this.personneManager.isPersonneHasRightOnProgramme(this.personneManager.findPersonByIdExt(CustomUserDetails.getCurrentUserLogin()), programme))
			return new ModelAndView("accessDenied");

		Collection<Personne> personnes = this.personneManager.findAllPersonnes();
		personnes.removeAll(programme.getResponsables());

		model.addAttribute("programme", programme);
		model.addAttribute("personnes", personnes);

		return new ModelAndView("ajouterResponsableProgramme");
	}

	@RequestMapping(value="/ajouterResponsableProgramme{programme}.htm", method=RequestMethod.POST)
	public ModelAndView addResponsableProgrammeOnSubmit(@PathVariable("programme") String codeProgramme, @ModelAttribute Personne personne, Model model)
	{
		Programme programme = this.programmeManager.findProgramme(codeProgramme);

		if(programme == null)
			return new ModelAndView("accessDenied");

		Personne responsable = this.personneManager.findPersonByCode(personne.getCode());

		if(!this.personneManager.isPersonneHasRightOnProgramme(this.personneManager.findPersonByIdExt(CustomUserDetails.getCurrentUserLogin()), programme))
			return new ModelAndView("accessDenied");

		if(!programme.getResponsables().contains(responsable))
		{
			programme.getResponsables().add(responsable);
			this.programmeManager.saveProgramme(programme);
		}

		return new ModelAndView(new RedirectView("responsablesProgramme" + programme.getCode() + ".htm"));
	}

	/** Gestion des droits sur les UECat **/
	
	@RequestMapping("/responsablesUECat{uecat}.htm")
	public ModelAndView responsablesUECat(@PathVariable("uecat") String codeUECat, Model model)
	{
		UECat uecat = this.uecatManager.findUECat(codeUECat);

		if(uecat == null)
			return new ModelAndView("accessDenied");
		
		Personne currentUser = this.personneManager.findPersonByIdExt(CustomUserDetails.getCurrentUserLogin());

		if(!this.personneManager.isPersonneHasRightOnUECat(currentUser, uecat))
			return new ModelAndView("accessDenied");
		
		Set<Personne> responsables = uecat.getResponsables();
		
		if(responsables.contains(currentUser))
			responsables.remove(currentUser);

		model.addAttribute("uecat", uecat);
		model.addAttribute("responsables", responsables);
		model.addAttribute("arianes", filAriane("responsablesUECat"+codeUECat+".htm", "Responsables de l'UECat: "+uecat.getNom()));
		return new ModelAndView("responsablesUECat");
	}

	@RequestMapping(value="/supprimerResponsableUECat{uecat}.htm", method=RequestMethod.POST)
	public ModelAndView deleteResponsableUECatOnSubmit(@PathVariable("uecat") String codeUECat, @ModelAttribute Personne responsable, Model model)
	{
		UECat uecat = this.uecatManager.findUECat(codeUECat);

		if(uecat == null)
			return new ModelAndView("accessDenied");

		Personne personne = this.personneManager.findPersonByCode(responsable.getCode());

		if(!this.personneManager.isPersonneHasRightOnUECat(this.personneManager.findPersonByIdExt(CustomUserDetails.getCurrentUserLogin()), uecat))
			return new ModelAndView("accessDenied");

		if(uecat.getResponsables().contains(personne))
		{
			uecat.getResponsables().remove(personne);
			this.uecatManager.saveUECat(uecat);
		}

		return new ModelAndView(new RedirectView("responsablesUECat" + uecat.getCode() + ".htm"));
	}

	@RequestMapping(value="/ajouterResponsableUECat{uecat}.htm", method=RequestMethod.GET)
	public ModelAndView addResponsableUECat(@PathVariable("uecat") String codeUECat, Model model)
	{
		UECat uecat = this.uecatManager.findUECat(codeUECat);

		if(uecat == null)
			return new ModelAndView("accessDenied");

		if(!this.personneManager.isPersonneHasRightOnUECat(this.personneManager.findPersonByIdExt(CustomUserDetails.getCurrentUserLogin()), uecat))
			return new ModelAndView("accessDenied");

		Collection<Personne> personnes = this.personneManager.findAllPersonnes();
		personnes.removeAll(uecat.getResponsables());

		model.addAttribute("uecat", uecat);
		model.addAttribute("personnes", personnes);

		return new ModelAndView("ajouterResponsableUECat");
	}

	@RequestMapping(value="/ajouterResponsableUECat{uecat}.htm", method=RequestMethod.POST)
	public ModelAndView addResponsableUECatOnSubmit(@PathVariable("uecat") String codeUECat, @ModelAttribute Personne personne, Model model)
	{
		UECat uecat = this.uecatManager.findUECat(codeUECat);

		if(uecat == null)
			return new ModelAndView("accessDenied");

		Personne responsable = this.personneManager.findPersonByCode(personne.getCode());

		if(!this.personneManager.isPersonneHasRightOnUECat(this.personneManager.findPersonByIdExt(CustomUserDetails.getCurrentUserLogin()), uecat))
			return new ModelAndView("accessDenied");

		if(!uecat.getResponsables().contains(responsable))
		{
			uecat.getResponsables().add(responsable);
			this.uecatManager.saveUECat(uecat);
		}

		return new ModelAndView(new RedirectView("responsablesUECat" + uecat.getCode() + ".htm"));
	}

	/** Gestion des droits sur les enseignements **/
	
	@RequestMapping("/responsablesEnseignement{enseignement}.htm")
	public ModelAndView responsablesEnseignement(@PathVariable("enseignement") String codeEnseignement, Model model)
	{
		Enseignement enseignement = this.enseignementManager.findEnseignement(codeEnseignement);

		if(enseignement == null)
			return new ModelAndView("accessDenied");
		
		Personne currentUser = this.personneManager.findPersonByIdExt(CustomUserDetails.getCurrentUserLogin());

		if(!this.personneManager.isPersonneHasRightOnEnseignement(currentUser, enseignement))
			return new ModelAndView("accessDenied");

		Set<Personne> responsables = enseignement.getResponsables();
		
		if(responsables.contains(currentUser))
			responsables.remove(currentUser);
		
		model.addAttribute("enseignement", enseignement);
		model.addAttribute("responsables", responsables);
		model.addAttribute("arianes", filAriane("responsablesEnseignement"+codeEnseignement+".htm", "Responsables de l'enseignement: "+enseignement.getNom()));
		return new ModelAndView("responsablesEnseignement");
	}

	@RequestMapping(value="/supprimerResponsableEnseignement{enseignement}.htm", method=RequestMethod.POST)
	public ModelAndView deleteResponsableEnseignementOnSubmit(@PathVariable("enseignement") String codeEnseignement, @ModelAttribute Personne responsable, Model model)
	{
		Enseignement enseignement = this.enseignementManager.findEnseignement(codeEnseignement);

		if(enseignement == null)
			return new ModelAndView("accessDenied");

		Personne personne = this.personneManager.findPersonByCode(responsable.getCode());

		if(!this.personneManager.isPersonneHasRightOnEnseignement(this.personneManager.findPersonByIdExt(CustomUserDetails.getCurrentUserLogin()), enseignement))
			return new ModelAndView("accessDenied");

		if(enseignement.getResponsables().contains(personne))
		{
			enseignement.getResponsables().remove(personne);
			this.enseignementManager.saveEnseignement(enseignement);
		}

		return new ModelAndView(new RedirectView("responsablesEnseignement" + enseignement.getCode() + ".htm"));
	}

	@RequestMapping(value="/ajouterResponsableEnseignement{enseignement}.htm", method=RequestMethod.GET)
	public ModelAndView addResponsableEnseignement(@PathVariable("enseignement") String codeEnseignement, Model model)
	{
		Enseignement enseignement = this.enseignementManager.findEnseignement(codeEnseignement);

		if(enseignement == null)
			return new ModelAndView("accessDenied");

		if(!this.personneManager.isPersonneHasRightOnEnseignement(this.personneManager.findPersonByIdExt(CustomUserDetails.getCurrentUserLogin()), enseignement))
			return new ModelAndView("accessDenied");

		Collection<Personne> personnes = this.personneManager.findAllPersonnes();
		personnes.removeAll(enseignement.getResponsables());

		model.addAttribute("enseignement", enseignement);
		model.addAttribute("personnes", personnes);

		return new ModelAndView("ajouterResponsableEnseignement");
	}

	@RequestMapping(value="/ajouterResponsableEnseignement{enseignement}.htm", method=RequestMethod.POST)
	public ModelAndView addResponsableEnseignementOnSubmit(@PathVariable("enseignement") String codeEnseignement, @ModelAttribute Personne personne, Model model)
	{
		Enseignement enseignement = this.enseignementManager.findEnseignement(codeEnseignement);

		if(enseignement == null)
			return new ModelAndView("accessDenied");

		Personne responsable = this.personneManager.findPersonByCode(personne.getCode());

		if(!this.personneManager.isPersonneHasRightOnEnseignement(this.personneManager.findPersonByIdExt(CustomUserDetails.getCurrentUserLogin()), enseignement))
			return new ModelAndView("accessDenied");

		if(!enseignement.getResponsables().contains(responsable))
		{
			enseignement.getResponsables().add(responsable);
			this.enseignementManager.saveEnseignement(enseignement);
		}

		return new ModelAndView(new RedirectView("responsablesEnseignement" + enseignement.getCode() + ".htm"));
	}

}