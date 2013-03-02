package gof.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import gof.dao.MentionDao;
import gof.dao.ProgrammeDao;

import gof.model.ElemStruct;
import gof.model.Personne;
import gof.model.Programme;

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
	
	@Test
	public void findAllProgrammesTest(){
		assertEquals(1, programmeDao.findAllProgrammes().size());
	}

	@Test
	public void findProgrammeTest(){
		assertEquals("PROGRAMME 01", programmeDao.findProgramme("PROG01").getNom());
	}

	@Test
	public void saveProgrammeTest(){		
		Programme programme = new Programme(	"PROG02", "PROGRAMME 02", 30, true, 
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
				new  ArrayList<Personne>(), new  ArrayList<ElemStruct>());
		
		programmeDao.saveProgramme(programme);
		
		mentionDao.findMention("MENT01").getProgrammes().add(programme);
		
		assertEquals(2, programmeDao.findAllProgrammes().size());
		assertEquals(2, mentionDao.findMention("MENT01").getProgrammes().size());
	}

	@Test
	public void deleteProgrammeTest(){
		programmeDao.deleteProgramme(programmeDao.findProgramme("PROG01"));
		assertEquals(0, programmeDao.findAllProgrammes().size());
	}
}