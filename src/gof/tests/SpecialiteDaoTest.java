package gof.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import gof.dao.MentionDao;
import gof.dao.SpecialiteDao;
import gof.model.Composante;
import gof.model.Domaine;
import gof.model.Mention;
import gof.model.MotCle;
import gof.model.Personne;
import gof.model.Programme;
import gof.model.Specialite;
import gof.model.TypeDiplome;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/gof/tests/applicationContext-tests.xml"})
public class SpecialiteDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private SpecialiteDao specialiteDao;
	
	@Autowired
	private MentionDao mentionDao;
	
	@Before
	public void init() {
		Mention mention = new Mention(	"code", "nomMent", TypeDiplome.LICENCE, 
				new ArrayList<MotCle>(), "droits", 
				new ArrayList<Personne>(), 
				new ArrayList<Specialite>(), 
				new ArrayList<Programme>(), 
				new ArrayList<Composante>(), "adaptation", 
				"adaptationHab", "adosPro", "adosRecherche", 
				"aideInsPro", "aideInsProHab", "aideOrientation", 
				"aideOrientationHab", "aideReussite", 
				"aideReussiteHab", "articuAutresFormat", 
				"autoEvaluation", "codeDossier", "cohabilitation", 
				"competences", "competencesHab", 
				"conditionsAdmission", "conditionsAdmissionHab", 
				"connaissances", "connaissancesHab", 
				"contenusEnseignement", "contexte", "contexteHab", 
				"dateModification", "debouches", "debouchesHab", 
				"denominationNationale", "equipePedago", "etatRof", 
				"finalite", "indicateurs", "international", 
				"internationalHab", "mcc", "mccHab", 
				"mesuresPrises", "modalitesPedagoHab", 
				"modifications", 0, "orgPedago", 
				"orgPedagoHab", "partenaires", "partenairesHab", 
				"pilotage", "politiqueStages", 
				"posOffreEtablis", "posOffreRegion", "poursuiteEtudes", 
				"poursuiteEtudesHab", "previsions", "publique", 
				"publicHab", new ArrayList<Domaine>(), "secteurPro", 
				"validiteCompetences", 0, "web", 
				true, true, true, 
				0);
		
		Specialite specialite = new Specialite(
				"codespe", "nomspe", "nomCourt", 
				"identificateur", new ArrayList<Personne>(), 
				new ArrayList<Programme>(), "aideInsPro", 
				"aideInsProHab", "aideOrientation", 
				"aideOrientationHab", "aideReussite", 
				"aideReussiteHab", "aspectsFormatContinue", 
				"aspectsFormatPro", "aspectsFormatRecherche", 
				mention, "competencesHab", "conditionsAdmission", 
				"conditionsAdmissionHab", "connaissances", 
				"connaissancesHab", "contenusEnseignement", 
				new Date(), "debouches", "debouchesHab", 
				"equipePedago", "etatRof", "finalite", 
				"indicateurs", "international", "internationalHab", 
				"liensAutresCertif", "mcc", "mccHab", 
				"mesuresPrises", "modalitesPedagoHab", 
				"mutualisation", "orgPedago", "orgPedagoHab", 
				"pilotage", "politiqueStages", "poursuiteEtudes", 
				"poursuiteEtudesHab", "previsions", "publique", 
				"publiqueHab", "validiteCompetences", 0, 
				true, true, true, 
				0);
		mentionDao.saveMention(mention);
		specialiteDao.saveSpecialite(specialite);
	}	
	
	@Test
	public void findAllSpecialitesTest(){
		assertEquals(1, specialiteDao.findAllSpecialites().size());
	}

	@Test
	public void findSpecialiteTest(){
		assertEquals("nomspe", specialiteDao.findSpecialite("codespe").getNom());
	}

	@Test
	public void saveSpecialiteTest(){
		Specialite specialite2 = new Specialite(
				"codespe2", "nomspe2", "nomCourt", 
				"identificateur", new ArrayList<Personne>(), 
				new ArrayList<Programme>(), "aideInsPro", 
				"aideInsProHab", "aideOrientation", 
				"aideOrientationHab", "aideReussite", 
				"aideReussiteHab", "aspectsFormatContinue", 
				"aspectsFormatPro", "aspectsFormatRecherche", 
				mentionDao.findMention("code"), "competencesHab", "conditionsAdmission", 
				"conditionsAdmissionHab", "connaissances", 
				"connaissancesHab", "contenusEnseignement", 
				new Date(), "debouches", "debouchesHab", 
				"equipePedago", "etatRof", "finalite", 
				"indicateurs", "international", "internationalHab", 
				"liensAutresCertif", "mcc", "mccHab", 
				"mesuresPrises", "modalitesPedagoHab", 
				"mutualisation", "orgPedago", "orgPedagoHab", 
				"pilotage", "politiqueStages", "poursuiteEtudes", 
				"poursuiteEtudesHab", "previsions", "publique", 
				"publiqueHab", "validiteCompetences", 0, 
				true, true, true, 
				0);
		specialiteDao.saveSpecialite(specialite2);
		
		assertEquals(specialite2.getNom(), specialiteDao.findSpecialite("codespe2").getNom());
	}

	@Test
	public void deleteSpecialiteTest(){
		specialiteDao.deleteSpecialite(specialiteDao.findSpecialite("codespe"));
		assertEquals(0, specialiteDao.findAllSpecialites().size());
	}
}