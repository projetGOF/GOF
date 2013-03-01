package gof.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import gof.dao.MentionDao;
import gof.dao.ProgrammeDao;
import gof.model.Composante;
import gof.model.Domaine;
import gof.model.ElemStruct;
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
public class ProgrammeDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private ProgrammeDao programmeDao;
	
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
		
		Programme programme = new Programme(	"CODEPRO1", "nompro", 30, true, 
												true, true, 0,
												new ArrayList<ElemStruct>(), "apogee", 10, 
												"competences", "competencesHab", new Date(), 
												10, "etatRof", "langue", "mcc", 
												"preRequis", "preRequisHab", "preRequisOblig", 
												"preRequisObligHab", 10, 10, 10, 
												10, "identificateur", "aspectsFormatRecherche", 
												"ensDelocalisees", "ensDelocaliseesHab", 
												"infosDiverses", "modalitesInscription", 
												"modalitesPedagogique", "nfs1", "nfs2", "nfs3", 
												"objectifs", "politiqueStages", "rome1", 
												"rome2", "rome3", "rome4", "rome5", 
												"specialite1", "specialite2", "specialite3", 
												true, "web", 
												mention, 
												new  ArrayList<Personne>(), new  ArrayList<ElemStruct>());
		
		mentionDao.saveMention(mention);	
		programmeDao.saveProgramme(programme);
		
		programme = programmeDao.findProgramme("CODEPRO1");
		mention = mentionDao.findMention("code");
		
		programme.setMention(mentionDao.findMention("code"));
		mention.getProgrammes().add(programmeDao.findProgramme("CODEPRO1"));
		
		mentionDao.saveMention(mention);	
		programmeDao.saveProgramme(programme);
	}
	
	@Test
	public void findAllProgrammesTest(){
		assertEquals(1, programmeDao.findAllProgrammes().size());
	}

	@Test
	public void findProgrammeTest(){
		assertEquals("nompro", programmeDao.findProgramme("CODEPRO1").getNom());
	}

	@Test
	public void saveProgrammeTest(){
		assertEquals("code", programmeDao.findProgramme("CODEPRO1").getMention().getCode());
		assertEquals(1, mentionDao.findMention("code").getProgrammes().size());
	}

	@Test
	public void deleteProgrammeTest(){
		mentionDao.findMention("code").getProgrammes().remove(programmeDao.findProgramme("CODEPRO1"));
		programmeDao.deleteProgramme(programmeDao.findProgramme("CODEPRO1"));
		assertEquals(0, programmeDao.findAllProgrammes().size());
	}
}