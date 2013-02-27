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
		ArrayList<Programme> programmes = new ArrayList<Programme>();
		programmes.add(programme);
		
		mentionDao.saveMention(mention);
		
		programmeDao.saveProgramme(programme);
	}
	
	

	
//	Programme(String code, String nom, int nbCredits, boolean publiable,
//			boolean contenuValide, boolean structureValide, int nbErreurs,
//			List<ElemStruct> elementsFils, String apogee, int capacite,
//			String competences, String competencesHab, Date dateModification,
//			int dureeStage, String etatRof, String langue, String mcc,
//			String preRequis, String preRequisHab, String preRequisOblig,
//			String preRequisObligHab, int volCM, int volTD, int volTP,
//			int version, String identificateur, String aspectsFormatRecherche,
//			String ensDelocalisees, String ensDelocaliseesHab,
//			String infosDiverses, String modalitesInscription,
//			String modalitesPedagogique, String nfs1, String nfs2, String nfs3,
//			String objectifs, String politiqueStages, String rome1,
//			String rome2, String rome3, String rome4, String rome5,
//			String specialite1, String specialite2, String specialite3,
//			boolean troncCommun, String web, Mention mention,
//			Collection<Personne> responsables,
//			Collection<ElemStruct> elementsRattaches)
	
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
		Programme programme2 = new Programme(	"CODEPRO2", "nompro2", 30, true, 
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
				mentionDao.findMention("code"), 
				new  ArrayList<Personne>(), new  ArrayList<ElemStruct>());
		programmeDao.saveProgramme(programme2);
		assertEquals(programme2.getNom(), programmeDao.findProgramme("CODEPRO2").getNom());
	}

	@Test
	public void deleteProgrammeTest(){
		programmeDao.deleteProgramme(programmeDao.findProgramme("CODEPRO1"));
		assertEquals(0, programmeDao.findAllProgrammes().size());
	}
}