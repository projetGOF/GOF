package gof.controllers;

import java.util.HashMap;
import java.util.Map;

import gof.model.Mention;
import gof.model.Personne;
import gof.model.TypeMention;
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
	
	@RequestMapping("/accueil.htm")
	public ModelAndView home()
	{	
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
	
	@RequestMapping("/domaines{diplome}.htm")
	public ModelAndView domaines(@PathVariable String diplome)
	{
		System.out.println(diplome);
		
		Map<String, Object> domaineModel = new HashMap<String, Object>();
		TypeMention type = TypeMention.valueOf(diplome);
		domaineModel.put("type", diplome);
		domaineModel.put("domaines", this.domaineManager.findAllDomainesByTypeMention(type));
		return new ModelAndView("domaines", "model", domaineModel);
	}
	
	@RequestMapping("/domainesDetail{domaine}.htm")
	public ModelAndView domainesDetail(@PathVariable String domaine)
	{
		
		System.out.println(domaine);

        Map<String, Object> domaineDetailModel = new HashMap<String, Object>();
        domaineDetailModel.put("mentions", this.mentionManager.findAllMentionsByDomaine(domaine));
        return new ModelAndView("domainesDetail", "model", domaineDetailModel);
	}
	
	@RequestMapping("/mention{mention}.htm")
	public ModelAndView mention(@PathVariable String mention)
	{
		System.out.println(mention);

        Map<String, Object> mentionDetailModel = new HashMap<String, Object>();
        mentionDetailModel.put("mention", this.mentionManager.findMention(mention));
        return new ModelAndView("mention", "model", mentionDetailModel);
	}
}