package gof.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import gof.dao.MentionDao;
import gof.model.Composante;
import gof.model.Domaine;
import gof.model.Mention;
import gof.model.MotCle;
import gof.model.Personne;
import gof.model.Programme;
import gof.model.Specialite;
import gof.model.TypeDiplome;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/gof/tests/applicationContext-tests.xml"})
public class MentionDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private MentionDao mentionDao;
	
	@Test
	public void findAllMentionsTest(){
		assertEquals(1, mentionDao.findAllMentions().size());
	}

	@Test
	public void findMentionTest(){
		assertEquals("MASTER 1 INFO", mentionDao.findMention("MENT01").getNom());
	}

	@Test
	public void saveMentionTest(){
		Mention mention = new Mention(	"MENT02", "MASTER 2 INFO", TypeDiplome.MASTER, 
				new ArrayList<MotCle>(), "droits", 
				new ArrayList<Personne>(), 
				new ArrayList<Specialite>(), 
				new ArrayList<Programme>(), 
				new ArrayList<Composante>(), "adaptation", 
				"adaptationHab", "adosPro2", "adosRecherche", 
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
		mentionDao.saveMention(mention);
		assertEquals("MASTER 2 INFO", mentionDao.findMention("MENT02").getNom());
	}

	@Test
	public void deleteMentionTest(){
		mentionDao.deleteMention(mentionDao.findMention("MENT01"));
		assertEquals(0, mentionDao.findAllMentions().size());
	}
}