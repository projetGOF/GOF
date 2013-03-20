package gof.controllers;

import java.util.HashMap;
import java.util.Map;

import gof.model.TypeMention;
import gof.services.CustomUserDetails;
import gof.services.DomaineManager;
import gof.services.MentionManager;
import gof.services.PersonneManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;




@Controller
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
	public ModelAndView domaines(@PathVariable String diplome)
	{
		TypeMention type = TypeMention.LICENCE;
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("type", diplome);
		model.put("domaines", this.mentionManager.findAllDomaineByTypeMention(type));
		return new ModelAndView("licence", "model", model);
	}
	
	@RequestMapping("/licenceDetail{domaine}.htm")
	public ModelAndView domainesDetail(@PathVariable String domaine)
	{
		TypeMention type = TypeMention.LICENCE;
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("domaine", this.domaineManager.findDomaine(domaine));
        model.put("mentions", this.mentionManager.findAllMentionsByDomaineAndTypeMention(domaine, type));
        return new ModelAndView("licenceDetail", "model", model);
	}
	
	@RequestMapping("/licencePro{diplome}.htm")
	public ModelAndView licencePro(@PathVariable String diplome)
	{
		TypeMention type = TypeMention.LICENCEPRO;
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("type", diplome);
		model.put("domaines", this.mentionManager.findAllDomaineByTypeMention(type));
		return new ModelAndView("licencePro", "model", model);
	}
	
	@RequestMapping("/licenceProDetail{domaine}.htm")
	public ModelAndView licenceProDetail(@PathVariable String domaine)
	{
		TypeMention type = TypeMention.LICENCEPRO;
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("domaine", this.domaineManager.findDomaine(domaine));
        model.put("mentions", this.mentionManager.findAllMentionsByDomaineAndTypeMention(domaine, type));
        return new ModelAndView("licenceProDetail", "model", model);
	}
	
	@RequestMapping("/master{diplome}.htm")
	public ModelAndView master(@PathVariable String diplome)
	{
		TypeMention type = TypeMention.MASTER;
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("type", diplome);
		model.put("domaines", this.mentionManager.findAllDomaineByTypeMention(type));
		return new ModelAndView("master", "model", model);
	}
	
	@RequestMapping("/masterDetail{domaine}.htm")
	public ModelAndView masterDetail(@PathVariable String domaine)
	{
		TypeMention type = TypeMention.MASTER;
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("domaine", this.domaineManager.findDomaine(domaine));
        model.put("mentions", this.mentionManager.findAllMentionsByDomaineAndTypeMention(domaine, type));
        return new ModelAndView("masterDetail", "model", model);
	}
	
	@RequestMapping("/mention{mention}.htm")
	public ModelAndView mention(@PathVariable String mention)
	{
		Map<String, Object> model = new HashMap<String, Object>();
		Mention ment = this.mentionManager.findMention(mention);
		
		Set<Specialite> spe = ment.getSpecialites();
		Hibernate.initialize(spe);
		
		model.put("mention", ment);
		model.put("specialites", spe);
        return new ModelAndView("mention", "model", model);
	}
	
	@RequestMapping("/specialite{specialite}.htm")
	public ModelAndView specialite(@PathVariable String specialite)
	{
		Map<String, Object> model = new HashMap<String, Object>();
        Specialite spe = this.specialiteManager.findSpecialite(specialite);
        
        Set<Programme> prog = spe.getProgrammes();
        Hibernate.initialize(prog);
        
        model.put("specialite", spe);
        model.put("programmes", prog);
        return new ModelAndView("specialite", "model", model);
	}
	
	@RequestMapping("/programme{programme}.htm")
	public ModelAndView programme(@PathVariable String programme)
	{
		Map<String, Object> model = new HashMap<String, Object>();
        Programme prog = this.programmeManager.findProgramme(programme);
        
        
        model.put("programme", prog);
        return new ModelAndView("programme", "model", model);
	}
	
	@RequestMapping("/etat.htm")
	public ModelAndView etat()
	{
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("domaines", this.domaineManager.findAllDomaines());
		model.put("mentionL", this.mentionManager.findAllMentionByTypeMention(TypeMention.LICENCE));
		model.put("mentionLP", this.mentionManager.findAllMentionByTypeMention(TypeMention.LICENCEPRO));
		model.put("mentionM", this.mentionManager.findAllMentionByTypeMention(TypeMention.MASTER));
		return new ModelAndView("etat", "model", model);
	}
	
	
}