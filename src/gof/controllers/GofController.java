package gof.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import gof.model.ComposantProgramme;
import gof.model.ElemStruct;
import gof.model.Enseignement;
import gof.model.Mention;
import gof.model.Programme;
import gof.model.Specialite;
import gof.model.TypeMention;
import gof.model.UECat;
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
	
	@RequestMapping("/accueil.htm")
	public ModelAndView home(Model model)
	{	
		boolean isUserConnected = (CustomUserDetails.getCurrentUserLogin().equals("anonymousUser") ? false : true);
		
		if(isUserConnected)
			model.addAttribute("loggedPersonne", personneManager.findPersonByIdExt(CustomUserDetails.getCurrentUserLogin()));
		
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
		return new ModelAndView("licence");
	}
	
	@RequestMapping("/licenceDetail{domaine}.htm")
	public ModelAndView domainesDetail(@PathVariable("domaine") String codeDomaine, Model model)
	{
        model.addAttribute("domaine", this.domaineManager.findDomaine(codeDomaine));
        model.addAttribute("mentions", this.mentionManager.findAllMentionsByDomaineAndTypeMention(codeDomaine, TypeMention.LICENCE));
        return new ModelAndView("licenceDetail");
	}
	
	@RequestMapping("/licencePro{diplome}.htm")
	public ModelAndView licencePromaster(@PathVariable("diplome") String codeDiplome, Model model)
	{
		model.addAttribute("type", codeDiplome);
		model.addAttribute("domaines", this.domaineManager.findAllDomaineByTypeMention(TypeMention.LICENCEPRO));
		return new ModelAndView("licencePro");
	}
	
	@RequestMapping("/licenceProDetail{domaine}.htm")
	public ModelAndView licenceProDetail(@PathVariable("domaine") String codeDomaine, Model model)
	{
        model.addAttribute("domaine", this.domaineManager.findDomaine(codeDomaine));
        model.addAttribute("mentions", this.mentionManager.findAllMentionsByDomaineAndTypeMention(codeDomaine, TypeMention.LICENCEPRO));
        return new ModelAndView("licenceProDetail");
	}
	
	@RequestMapping("/master{diplome}.htm")
	public ModelAndView master(@PathVariable("diplome") String codeDiplome, Model model)
	{
		model.addAttribute("type", codeDiplome);
		model.addAttribute("domaines", this.domaineManager.findAllDomaineByTypeMention(TypeMention.MASTER));
		return new ModelAndView("master");
	}
	
	@RequestMapping("/masterDetail{domaine}.htm")
	public ModelAndView masterDetail(@PathVariable("domaine") String codeDomaine, Model model)
	{
        model.addAttribute("domaine", this.domaineManager.findDomaine(codeDomaine));
        model.addAttribute("mentions", this.mentionManager.findAllMentionsByDomaineAndTypeMention(codeDomaine, TypeMention.MASTER));
        return new ModelAndView("masterDetail");
	}
	
	@RequestMapping("/mention{mention}.htm")
	public ModelAndView mention(@PathVariable("mention") String codeMention, Model model)
	{
		Mention mention = this.mentionManager.findMention(codeMention);

		boolean isUserConnected = (CustomUserDetails.getCurrentUserLogin().equals("anonymousUser") ? false : true);
		
		if(isUserConnected)
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
		
        return new ModelAndView("mention");
	}
	
	@RequestMapping(value="/editMentionPubliable.htm", method=RequestMethod.POST)
	public ModelAndView editMentionPubliable(@ModelAttribute Mention oldMention, Model model)
	{
		Mention newMention = this.mentionManager.findMention(oldMention.getCode());
		newMention.setPubliable(oldMention.isPubliable());
		this.mentionManager.saveMention(newMention);
		
        return new ModelAndView(new RedirectView("mention" + newMention.getCode() + ".htm"));
	}
	
	@RequestMapping("/specialite{specialite}.htm")
	public ModelAndView specialite(@PathVariable("specialite") String codeSpecialite, Model model)
	{
        Specialite specialite = this.specialiteManager.findSpecialite(codeSpecialite);
        
        boolean isUserConnected = (CustomUserDetails.getCurrentUserLogin().equals("anonymousUser") ? false : true);
        
        if(isUserConnected)
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
        
        return new ModelAndView("specialite");
	}
	
	@RequestMapping(value="/editSpecialitePubliable.htm", method=RequestMethod.POST)
	public ModelAndView editSpecialitePubliable(@ModelAttribute Specialite oldSpecialite, Model model)
	{
		Specialite newSpecialite = this.specialiteManager.findSpecialite(oldSpecialite.getCode());
		newSpecialite.setPubliable(oldSpecialite.isPubliable());
		this.specialiteManager.saveSpecialite(newSpecialite);
		
		return new ModelAndView(new RedirectView("specialite" + newSpecialite.getCode() + ".htm"));
	}
	
	@RequestMapping("/programme{programme}.htm")
	public ModelAndView programme(@PathVariable("programme") String codeProgramme, Model model)
	{
        Programme programme = this.programmeManager.findProgramme(codeProgramme);
        
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
        
        boolean isUserConnected = (CustomUserDetails.getCurrentUserLogin().equals("anonymousUser") ? false : true);
        
        if(isUserConnected)
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
        
        return new ModelAndView("programme");
	}
	
	@RequestMapping(value="/editProgrammePubliable.htm", method=RequestMethod.POST)
	public ModelAndView editProgrammePubliable(@ModelAttribute Programme oldProgramme, Model model)
	{
		Programme newProgramme = this.programmeManager.findProgramme(oldProgramme.getCode());
		newProgramme.setPubliable(oldProgramme.isPubliable());
		this.programmeManager.saveProgramme(newProgramme);
		
		return new ModelAndView(new RedirectView("programme" + newProgramme.getCode() + ".htm"));
	}

	@RequestMapping("/uecat{uecat}.htm")
	public ModelAndView uecat(@PathVariable("uecat") String codeUECat, Model model)
	{
        UECat uecat = this.uecatManager.findUECat(codeUECat);
        
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
        
        boolean isUserConnected = (CustomUserDetails.getCurrentUserLogin().equals("anonymousUser") ? false : true);
        
        if(isUserConnected)
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
        
        return new ModelAndView("uecat");
	}
	
	@RequestMapping(value="/editUECatPubliable.htm", method=RequestMethod.POST)
	public ModelAndView editUECatPubliable(@ModelAttribute UECat oldUECat, Model model)
	{
		UECat newUECat = this.uecatManager.findUECat(oldUECat.getCode());
		newUECat.setPubliable(oldUECat.isPubliable());
		this.uecatManager.saveUECat(newUECat);
		
		return new ModelAndView(new RedirectView("uecat" + newUECat.getCode() + ".htm"));
	}
	
	@RequestMapping("/composantProg{composantProg}.htm")
	public ModelAndView composantProg(@PathVariable("composantProg") String codeComposantProg, Model model)
	{
        ComposantProgramme composantProg = this.composantProgManager.findComposantProgramme(codeComposantProg);
        
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
        
        boolean isUserConnected = (CustomUserDetails.getCurrentUserLogin().equals("anonymousUser") ? false : true);
        
        if(isUserConnected)
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
        
        return new ModelAndView("composantProg");
	}
	
	@RequestMapping(value="/editComposantProgPubliable.htm", method=RequestMethod.POST)
	public ModelAndView editComposantProgPubliable(@ModelAttribute ComposantProgramme oldComposantProg, Model model)
	{
		ComposantProgramme newComposantProg = this.composantProgManager.findComposantProgramme(oldComposantProg.getCode());
		newComposantProg.setPubliable(oldComposantProg.isPubliable());
		this.composantProgManager.saveComposantProgramme(newComposantProg);
		
		return new ModelAndView(new RedirectView("composantProg" + newComposantProg.getCode() + ".htm"));
	}
	
	@RequestMapping("/enseignement{enseignement}.htm")
	public ModelAndView enseignement(@PathVariable("enseignement") String codeEnseignement, Model model)
	{
        Enseignement enseignement = this.enseignementManager.findEnseignement(codeEnseignement);
        
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
        
        boolean isUserConnected = (CustomUserDetails.getCurrentUserLogin().equals("anonymousUser") ? false : true);
        
        if(isUserConnected)
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
        
        return new ModelAndView("enseignement");
	}
	
	@RequestMapping(value="/editEnseignementPubliable.htm", method=RequestMethod.POST)
	public ModelAndView editEnseignementPubliable(@ModelAttribute Enseignement oldEnseignement, Model model)
	{
		Enseignement newEnseignement = this.enseignementManager.findEnseignement(oldEnseignement.getCode());
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
		
		return new ModelAndView("responsablesROF");
	}
	
	
}