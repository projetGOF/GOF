package gof.controllers;

import java.util.HashMap;
import java.util.Map;

import gof.model.TypeMention;
import gof.services.DomaineManager;
import gof.services.MentionManager;

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
	
	@RequestMapping("/licence{diplome}.htm")
	public ModelAndView domaines(@PathVariable String diplome)
	{
		System.out.println(diplome);
		TypeMention type = TypeMention.LICENCE;
		
		Map<String, Object> domaineModel = new HashMap<String, Object>();
		
		domaineModel.put("type", diplome);
		domaineModel.put("domaines", this.domaineManager.findDomainesByTypeMention(type));
		return new ModelAndView("licence", "model", domaineModel);
	}
	
	@RequestMapping("/licenceDetail{domaine}.htm")
	public ModelAndView domainesDetail(@PathVariable String domaine)
	{
		System.out.println(domaine);
		TypeMention type = TypeMention.LICENCE;
        Map<String, Object> domaineDetailModel = new HashMap<String, Object>();
        domaineDetailModel.put("domaine", this.domaineManager.findDomaine(domaine));
        domaineDetailModel.put("mentions", this.mentionManager.findAllMentionsByDomaineAndTypeMention(domaine, type));
        return new ModelAndView("licenceDetail", "model", domaineDetailModel);
	}
	
	@RequestMapping("/licencePro{diplome}.htm")
	public ModelAndView licencePro(@PathVariable String diplome)
	{
		System.out.println(diplome);
		TypeMention type = TypeMention.LICENCEPRO;
		
		Map<String, Object> domaineModel = new HashMap<String, Object>();
		
		domaineModel.put("type", diplome);
		domaineModel.put("domaines", this.domaineManager.findDomainesByTypeMention(type));
		return new ModelAndView("licencePro", "model", domaineModel);
	}
	
	@RequestMapping("/licenceProDetail{domaine}.htm")
	public ModelAndView licenceProDetail(@PathVariable String domaine)
	{
		System.out.println(domaine);
		TypeMention type = TypeMention.LICENCEPRO;
        Map<String, Object> domaineDetailModel = new HashMap<String, Object>();
        domaineDetailModel.put("domaine", this.domaineManager.findDomaine(domaine));
        domaineDetailModel.put("mentions", this.mentionManager.findAllMentionsByDomaineAndTypeMention(domaine, type));
        return new ModelAndView("licenceProDetail", "model", domaineDetailModel);
	}
	
	@RequestMapping("/master{diplome}.htm")
	public ModelAndView master(@PathVariable String diplome)
	{
		System.out.println(diplome);
		TypeMention type = TypeMention.MASTER;
		
		Map<String, Object> domaineModel = new HashMap<String, Object>();
		
		domaineModel.put("type", diplome);
		domaineModel.put("domaines", this.domaineManager.findDomainesByTypeMention(type));
		return new ModelAndView("master", "model", domaineModel);
	}
	
	@RequestMapping("/masterDetail{domaine}.htm")
	public ModelAndView masterDetail(@PathVariable String domaine)
	{
		System.out.println(domaine);
		TypeMention type = TypeMention.MASTER;
        Map<String, Object> domaineDetailModel = new HashMap<String, Object>();
        domaineDetailModel.put("domaine", this.domaineManager.findDomaine(domaine));
        domaineDetailModel.put("mentions", this.mentionManager.findAllMentionsByDomaineAndTypeMention(domaine, type));
        return new ModelAndView("masterDetail", "model", domaineDetailModel);
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