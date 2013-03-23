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
	
	@Before
	public void setUp(){
		
		mention = mentionDao.findMention("ME3BAS");
	}
	
	@Test
	public void validateFicheTest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		Map<String,ValidatorLine> result = Validator.validateFiche(mention, Mention.class);
		
		System.out.println(result.size());
		
		assertEquals(true,result.get("getAdaptation").getState());
		assertEquals(true,result.get("getAdaptationHab").getState());
		assertEquals(true,result.get("getAdosRecherche").getState());
		assertEquals(true,result.get("getAdosPro").getState());
		assertEquals(true,result.get("getAideInsPro").getState());
		assertEquals(true,result.get("getAideInsProHab").getState());
		assertEquals(true,result.get("getAideOrientation").getState());
		assertEquals(true,result.get("getAideOrientationHab").getState());
		assertEquals(true,result.get("getAideReussite").getState());
		assertEquals(true,result.get("getAideReussiteHab").getState());
		assertEquals(true,result.get("getAideOrientation").getState());
		assertEquals(true,result.get("getAideOrientationHab").getState());		
		assertEquals(true,result.get("getArticuAutresFormat").getState());
		assertEquals(true,result.get("getAutoEvaluation").getState());
		
		assertEquals(false,result.get("getCohabilitation").getState());
		if(result.get("getCohabilitation").getState()==false){
			List<String> errors = result.get("getCohabilitation").getErrorList();
			System.out.println("Le champ contient les erreurs suivantes :");
			for(int i=0;i<errors.size();i++)
				System.out.println(errors.get(i));
		}
		
		assertEquals(true,result.get("getCompetences").getState());
		assertEquals(true,result.get("getCompetencesHab").getState());
		
		assertEquals(false,result.get("getConditionsAdmission").getState());
		if(result.get("getConditionsAdmission").getState()==false){
			List<String> errors = result.get("getConditionsAdmission").getErrorList();
			System.out.println("Le champ contient les erreurs suivantes :");
			for(int i=0;i<errors.size();i++)
				System.out.println(errors.get(i));
		}
		
		assertEquals(true,result.get("getConditionsAdmissionHab").getState());
		assertEquals(true,result.get("getConnaissances").getState());
		assertEquals(true,result.get("getConnaissancesHab").getState());
		//assertEquals(false,result.get("getContenusEnseignement").getState());
		assertEquals(true,result.get("getContexte").getState());
		assertEquals(true,result.get("getContexteHab").getState());
		assertEquals(true,result.get("getDebouches").getState());
		assertEquals(true,result.get("getDebouchesHab").getState());
		assertEquals(true,result.get("getInternational").getState());
		assertEquals(true,result.get("getInternationalHab").getState());
		assertEquals(true,result.get("getMcc").getState());
		assertEquals(true,result.get("getMccHab").getState());
		//assertEquals(false,result.get("getMesuresPrises").getState());
		assertEquals(true,result.get("getModalitesPedagoHab").getState());
		//assertEquals(false,result.get("getModifications").getState());
		assertEquals(true,result.get("getOrgPedago").getState());
		assertEquals(true,result.get("getOrgPedagoHab").getState());
		//assertEquals(false,result.get("getPartenaires").getState());
		assertEquals(true,result.get("getPartenairesHab").getState());
		//assertEquals(false,result.get("getPilotage").getState());
		assertEquals(true,result.get("getPolitiqueStages").getState());
		assertEquals(true,result.get("getPosOffreEtablis").getState());
		assertEquals(true,result.get("getPosOffreRegion").getState());
		assertEquals(true,result.get("getPoursuiteEtudes").getState());
		assertEquals(true,result.get("getPoursuiteEtudesHab").getState());
		//assertEquals(false,result.get("getPrevisions").getState());
		assertEquals(true,result.get("getPublique").getState());
		assertEquals(true,result.get("getPublicHab").getState());
		assertEquals(true,result.get("getValiditeCompetences").getState());
	}
}