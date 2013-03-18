package gof.tests;

import static org.junit.Assert.*;

import gof.dao.ComposantProgrammeDao;
import gof.dao.ProgrammeDao;
import gof.model.ComposantProgramme;
import gof.model.TypeComposantProgramme;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/gof/tests/applicationContext-tests.xml"})
public class ComposantProgrammeDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private ComposantProgrammeDao composantProgrammeDao;
	
	@Autowired
	private ProgrammeDao programmeDao;
	
	@Test
	public void findAllComposantsProgrammeTest() {
		assertEquals(1, composantProgrammeDao.findAllComposantsProgramme().size());
	}

	@Test
	public void findComposantProgrammeTest() {
		assertEquals("SEMESTRE 01", composantProgrammeDao.findComposantProgramme("SEM01").getNom());
		assertTrue(composantProgrammeDao.findComposantProgramme("SEM01").getElementsPere().contains(programmeDao.findProgramme("PROG01")));
	}

	@Test
	public void saveComposantProgrammeTest() {
		ComposantProgramme composantProgramme = new ComposantProgramme();
		
		composantProgramme.setCode("ANNEE01");
		composantProgramme.setNom("ANNEE 01");
		composantProgramme.setType(TypeComposantProgramme.ANNEE);
		composantProgramme.setPubliable(true);
		composantProgramme.setContenuValide(true);
		composantProgramme.setStructureValide(true);
		composantProgramme.setNbCredits(0);
		composantProgramme.setNbErreurs(0);
		composantProgramme.setPubliable(true);
		
		composantProgrammeDao.saveComposantProgramme(composantProgramme);
		assertEquals("ANNEE 01", composantProgrammeDao.findComposantProgramme("ANNEE01").getNom());
	}

	@Test
	public void deleteComposantProgrammeTest() {
		programmeDao.findProgramme("PROG01").getElementsFils().remove(0);
		composantProgrammeDao.deleteComposantProgramme(composantProgrammeDao.findComposantProgramme("SEM01"));
		assertEquals(0, composantProgrammeDao.findAllComposantsProgramme().size());
	}
	
}
