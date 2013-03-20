package gof.tests;

import static org.junit.Assert.*;

import gof.dao.ComposantProgrammeDao;
import gof.dao.MentionDao;
import gof.dao.ProgrammeDao;
import gof.dao.SpecialiteDao;

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
	
	@Autowired
	private SpecialiteDao specialiteDao;
	
	@Autowired
	private ComposantProgrammeDao composantProgrammeDao;
	
	@Test
	public void findAllProgrammesTest(){
		assertEquals(1, programmeDao.findAllProgrammes().size());
	}

	@Test
	public void findProgrammeTest(){
		assertEquals("PROGRAMME 01", programmeDao.findProgramme("PROG01").getNom());
		assertEquals(mentionDao.findMention("MENT01"), programmeDao.findProgramme("PROG01").getMention());
		assertTrue(programmeDao.findProgramme("PROG01").getElementsFils().contains(composantProgrammeDao.findComposantProgramme("SEM01")));
	}

	@Test
	public void saveProgrammeTest(){		
		Programme programme = new Programme();

		programme.setCode("PROG02");
		programme.setNom("PROGRAMME 02");		
		programme.setContenuValide(true);
		programme.setStructureValide(true);
		programme.setNbCredits(0);
		programme.setNbErreurs(0);
		programme.setPubliable(true);
		
		programme.setCapacite(0);
		programme.setDureeStage(0);
		programme.setTroncCommun(true);
		programme.setVolCM(0);
		programme.setVolTD(0);
		programme.setVolTP(0);
		programme.setLangue(0);
		
		programmeDao.saveProgramme(programme);
		
		//mentionDao.findMention("MENT01").getProgrammes().add(programme);
		
		assertEquals(2, programmeDao.findAllProgrammes().size());
		//assertEquals(2, mentionDao.findMention("MENT01").getProgrammes().size());
	}

	@Test
	public void deleteProgrammeTest(){
		mentionDao.findMention("MENT01").getProgrammes().remove(programmeDao.findProgramme("PROG01"));
		specialiteDao.findSpecialite("SPE01").getProgrammes().remove(programmeDao.findProgramme("PROG01"));
		programmeDao.deleteProgramme(programmeDao.findProgramme("PROG01"));
		assertEquals(0, programmeDao.findAllProgrammes().size());
	}
}