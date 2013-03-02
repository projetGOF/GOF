package gof.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import gof.dao.MentionDao;
import gof.dao.SpecialiteDao;

import gof.model.Personne;
import gof.model.Programme;
import gof.model.Specialite;

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
	
	@Test
	public void findAllSpecialitesTest(){
		assertEquals(1, specialiteDao.findAllSpecialites().size());
	}

	@Test
	public void findSpecialiteTest(){
		assertEquals("SPECIALITE 01", specialiteDao.findSpecialite("SPE01").getNom());
	}

	@Test
	public void saveSpecialiteTest(){
		Specialite specialite = new Specialite(
				"SPE02", "SPECIALITE 02", "nomCourt", 
				"identificateur", new ArrayList<Personne>(), 
				new ArrayList<Programme>(), "aideInsPro", 
				"aideInsProHab", "aideOrientation", 
				"aideOrientationHab", "aideReussite", 
				"aideReussiteHab", "aspectsFormatContinue", 
				"aspectsFormatPro", "aspectsFormatRecherche", 
				"competencesHab", "conditionsAdmission", 
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
		
		specialiteDao.saveSpecialite(specialite);
		
		mentionDao.findMention("MENT01").getSpecialites().add(specialite);
		
		assertEquals("SPECIALITE 02", specialiteDao.findSpecialite("SPE02").getNom());
		assertEquals(2, mentionDao.findMention("MENT01").getSpecialites().size());
	}

	@Test
	public void deleteSpecialiteTest(){
		specialiteDao.deleteSpecialite(specialiteDao.findSpecialite("SPE01"));
		assertEquals(0, specialiteDao.findAllSpecialites().size());
	}
}