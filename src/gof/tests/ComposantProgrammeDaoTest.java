package gof.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import gof.dao.ComposantProgrammeDao;
import gof.model.ComposantProgramme;
import gof.model.ElemStruct;

import org.junit.Before;
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
	
	@Before
	public void init() {
		ComposantProgramme composantProgramme = new ComposantProgramme(
				"codeCompProg", "nomCompProg", 30, 
				true, true, true, 
				0, new ArrayList<ElemStruct>(), false, 
				"type");
		
		composantProgrammeDao.saveComposantProgramme(composantProgramme);
	}
	
	@Test
	public void findAllComposantsProgrammeTest() {
		assertEquals(1, composantProgrammeDao.findAllComposantsProgramme().size());
	}

	@Test
	public void findComposantProgrammeTest() {
		assertEquals("nomCompProg", composantProgrammeDao.findComposantProgramme("codeCompProg").getNom());
	}

	@Test
	public void saveComposantProgrammeTest() {
		ComposantProgramme composantProgramme2 = new ComposantProgramme(
				"codeCompProg2", "nomCompProg2", 30, 
				true, true, true, 
				0, new ArrayList<ElemStruct>(), false, 
				"type");
		composantProgrammeDao.saveComposantProgramme(composantProgramme2);
		assertEquals("nomCompProg2", composantProgrammeDao.findComposantProgramme("codeCompProg2").getNom());
	}

	@Test
	public void deleteComposantProgrammeTest() {
		composantProgrammeDao.deleteComposantProgramme(composantProgrammeDao.findComposantProgramme("codeCompProg"));
		assertEquals(0, composantProgrammeDao.findAllComposantsProgramme().size());
	}
	
}
