package gof.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
		return new ModelAndView("licence", "model", model);
	}
	
	@RequestMapping("/licenceDetail{domaine}.htm")
	public ModelAndView domainesDetail(@PathVariable("domaine") String codeDomaine, Model model)
	{
        model.addAttribute("domaine", this.domaineManager.findDomaine(codeDomaine));
        model.addAttribute("mentions", this.mentionManager.findAllMentionsByDomaineAndTypeMention(codeDomaine, TypeMention.LICENCE));
        return new ModelAndView("licenceDetail", "model", model);
	}
	
	@RequestMapping("/licencePro{diplome}.htm")
	public ModelAndView licencePromaster(@PathVariable("diplome") String codeDiplome, Model model)
	{
		model.addAttribute("type", codeDiplome);
		model.addAttribute("domaines", this.domaineManager.findAllDomaineByTypeMention(TypeMention.LICENCEPRO));
		return new ModelAndView("licencePro", "model", model);
	}
	
	@RequestMapping("/licenceProDetail{domaine}.htm")
	public ModelAndView licenceProDetail(@PathVariable("domaine") String codeDomaine, Model model)
	{
        model.addAttribute("domaine", this.domaineManager.findDomaine(codeDomaine));
        model.addAttribute("mentions", this.mentionManager.findAllMentionsByDomaineAndTypeMention(codeDomaine, TypeMention.LICENCEPRO));
        return new ModelAndView("licenceProDetail", "model", model);
	}
	
	@RequestMapping("/master{diplome}.htm")
	public ModelAndView master(@PathVariable("diplome") String codeDiplome, Model model)
	{
		model.addAttribute("type", codeDiplome);
		model.addAttribute("domaines", this.domaineManager.findAllDomaineByTypeMention(TypeMention.MASTER));
		return new ModelAndView("master", "model", model);
	}
	
	@RequestMapping("/masterDetail{domaine}.htm")
	public ModelAndView masterDetail(@PathVariable("domaine") String codeDomaine, Model model)
	{
        model.addAttribute("domaine", this.domaineManager.findDomaine(codeDomaine));
        model.addAttribute("mentions", this.mentionManager.findAllMentionsByDomaineAndTypeMention(codeDomaine, TypeMention.MASTER));
        return new ModelAndView("masterDetail", "model", model);
	}
	
	@RequestMapping("/mention{mention}.htm")
	public ModelAndView mention(@PathVariable("mention") String codeMention, Model model)
	{
		Mention mention = this.mentionManager.findMention(codeMention);

		model.addAttribute("mention", mention);
		model.addAttribute("specialites", mention.getSpecialites());
		
        return new ModelAndView("mention", "model", model);
	}
	
	@RequestMapping("/specialite{specialite}.htm")
	public ModelAndView specialite(@PathVariable("specialite") String codeSpecialite, Model model)
	{
        Specialite specialite = this.specialiteManager.findSpecialite(codeSpecialite);

        Set<Programme> programmes = specialite.getProgrammes();
        
        model.addAttribute("specialite", specialite);
        model.addAttribute("programmes", programmes);
        
        return new ModelAndView("specialite", "model", model);
	}
	
	@RequestMapping("/programme{programme}.htm")
	public ModelAndView programme(@PathVariable("programme") String codeProgramme, Model model)
	{
        Programme programme = this.programmeManager.findProgramme(codeProgramme);
        
        ArrayList<Programme> programmeFils = new ArrayList<Programme>();
        ArrayList<UECat> uecatFils = new ArrayList<UECat>();
        ArrayList<ComposantProgramme> composantProgFils = new ArrayList<ComposantProgramme>();
        ArrayList<Enseignement> enseignementFils = new ArrayList<Enseignement>();
        
        
        System.out.println(programme.getElementsFils().size());
        
        
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
        
        model.addAttribute("programme", programme);
        
        model.addAttribute("programmeFils", programmeFils);
        model.addAttribute("uecatFils", uecatFils);
        model.addAttribute("composantProgFils", composantProgFils);
        model.addAttribute("enseignementFils", enseignementFils);
        
        return new ModelAndView("programme");
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
        
        model.addAttribute("uecat", uecat);
        
        model.addAttribute("programmeFils", programmeFils);
        model.addAttribute("uecatFils", uecatFils);
        model.addAttribute("composantProgFils", composantProgFils);
        model.addAttribute("enseignementFils", enseignementFils);
        
        return new ModelAndView("uecat", "model", model);
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
        
        model.addAttribute("composantProg", composantProg);
        
        model.addAttribute("programmeFils", programmeFils);
        model.addAttribute("uecatFils", uecatFils);
        model.addAttribute("composantProgFils", composantProgFils);
        model.addAttribute("enseignementFils", enseignementFils);
        
        return new ModelAndView("composantProg", "model", model);
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
        
        model.addAttribute("enseignement", enseignement);
        
        model.addAttribute("programmeFils", programmeFils);
        model.addAttribute("uecatFils", uecatFils);
        model.addAttribute("composantProgFils", composantProgFils);
        model.addAttribute("enseignementFils", enseignementFils);
        
        return new ModelAndView("enseignement", "model", model);
	}
	
	@RequestMapping("/etat.htm")
	public ModelAndView etat(Model model)
	{
		model.addAttribute("domaines", this.domaineManager.findAllDomaines());
		model.addAttribute("mentionL", this.mentionManager.findAllMentionByTypeMention(TypeMention.LICENCE));
		model.addAttribute("mentionLP", this.mentionManager.findAllMentionByTypeMention(TypeMention.LICENCEPRO));
		model.addAttribute("mentionM", this.mentionManager.findAllMentionByTypeMention(TypeMention.MASTER));
		return new ModelAndView("etat", "model", model);
	}
	
	
}