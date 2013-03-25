package gof.tests;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import gof.dao.MentionDao;
import gof.model.Mention;
import gof.validation.Validator;
import gof.validation.ValidatorLine;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/gof/tests/applicationContext-validation.xml" })
public class ValidatorTest {

	@Autowired
	private MentionDao mentionDao;
	private Mention mention;
	private Validator validator;
	
	@Before
	public void setUp(){
		
		validator = new Validator();
		mention = mentionDao.findMention("ME3BAS");
	}
	
	@Test
	public void validateFicheTest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		Map<String,ValidatorLine> result = validator.validateFiche(mention, Mention.class);
		
		System.out.println(validator.getErrors()+" champs contiennent des erreur dans la fiche");
		
		assertEquals(true,result.get("adaptation").getState());
		assertEquals(true,result.get("adaptationHab").getState());
		assertEquals(true,result.get("adosRecherche").getState());
		assertEquals(true,result.get("adosPro").getState());
		assertEquals(true,result.get("aideInsPro").getState());
		assertEquals(true,result.get("aideInsProHab").getState());
		assertEquals(true,result.get("aideOrientation").getState());
		assertEquals(true,result.get("aideOrientationHab").getState());
		assertEquals(true,result.get("aideReussite").getState());
		assertEquals(true,result.get("aideReussiteHab").getState());
		assertEquals(true,result.get("aideOrientation").getState());
		assertEquals(true,result.get("aideOrientationHab").getState());		
		assertEquals(true,result.get("articuAutresFormat").getState());
		assertEquals(true,result.get("autoEvaluation").getState());
		
		assertEquals(false,result.get("cohabilitation").getState());
		if(result.get("cohabilitation").getState()==false){
			List<String> errors = result.get("cohabilitation").getErrorList();
			System.out.println("Le champ contient les erreurs suivantes :");
			for(int i=0;i<errors.size();i++)
				System.out.println(errors.get(i));
		}
		
		assertEquals(true,result.get("nbCredits").getState());
		if(result.get("nbCredits").getState()==false){
			List<String> errors = result.get("nbCredits").getErrorList();
			System.out.println("Le champ contient les erreurs suivantes :");
			for(int i=0;i<errors.size();i++)
				System.out.println(errors.get(i));
			System.out.println("Description : "+result.get("nbCredits").getDescription());
			System.out.println("Example : "+result.get("nbCredits").getExample());
		}
		
		assertEquals(true,result.get("competences").getState());
		assertEquals(true,result.get("competencesHab").getState());
		
		assertEquals(false,result.get("conditionsAdmission").getState());
		if(result.get("conditionsAdmission").getState()==false){
			List<String> errors = result.get("conditionsAdmission").getErrorList();
			System.out.println("Le champ contient les erreurs suivantes :");
			for(int i=0;i<errors.size();i++)
				System.out.println(errors.get(i));
		}
		
		assertEquals(true,result.get("conditionsAdmissionHab").getState());
		assertEquals(true,result.get("connaissances").getState());
		assertEquals(true,result.get("connaissancesHab").getState());
		//assertEquals(false,result.get("contenusEnseignement").getState());
		assertEquals(true,result.get("contexte").getState());
		assertEquals(true,result.get("contexteHab").getState());
		assertEquals(true,result.get("debouches").getState());
		assertEquals(true,result.get("debouchesHab").getState());
		assertEquals(true,result.get("international").getState());
		assertEquals(true,result.get("internationalHab").getState());
		assertEquals(true,result.get("mcc").getState());
		assertEquals(true,result.get("mccHab").getState());
		//assertEquals(false,result.get("mesuresPrises").getState());
		assertEquals(true,result.get("modalitesPedagoHab").getState());
		//assertEquals(false,result.get("modifications").getState());
		assertEquals(true,result.get("nbCredits").getState());
		assertEquals(true,result.get("orgPedago").getState());
		assertEquals(true,result.get("orgPedagoHab").getState());
		//assertEquals(false,result.get("partenaires").getState());
		assertEquals(true,result.get("partenairesHab").getState());
		//assertEquals(false,result.get("pilotage").getState());
		assertEquals(true,result.get("politiqueStages").getState());
		assertEquals(true,result.get("posOffreEtablis").getState());
		assertEquals(true,result.get("posOffreRegion").getState());
		assertEquals(true,result.get("poursuiteEtudes").getState());
		assertEquals(true,result.get("poursuiteEtudesHab").getState());
		//assertEquals(false,result.get("previsions").getState());
		assertEquals(true,result.get("publique").getState());
		assertEquals(true,result.get("publicHab").getState());
		assertEquals(true,result.get("validiteCompetences").getState());
	}
}