package gof.controllers;

import gof.model.Mention;
import gof.model.Programme;
import gof.model.Specialite;
import gof.model.TypeMention;
import gof.services.CustomUserDetails;
import gof.services.DomaineManager;
import gof.services.MentionManager;
import gof.services.PersonneManager;
import gof.services.ProgrammeManager;
import gof.services.SpecialiteManager;

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
	ProgrammeManager programmeManager;
	
	@Autowired
	PersonneManager personneManager;
	
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

        model.addAttribute("specialite", specialite);
        model.addAttribute("programmes", specialite.getProgrammes());
        return new ModelAndView("specialite", "model", model);
	}
	
	@RequestMapping("/programme{programme}.htm")
	public ModelAndView programme(@PathVariable("programme") String codeProgramme, Model model)
	{
        Programme programme = this.programmeManager.findProgramme(codeProgramme);
          
        model.addAttribute("programme", programme);
        return new ModelAndView("programme", "model", model);
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