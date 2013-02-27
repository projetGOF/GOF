package gof.tests;

import static org.junit.Assert.*;

import gof.dao.ProgrammeDao;

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
	
	@Test
	public void findAllProgrammesTest(){
		assertEquals(2, programmeDao.findAllProgrammes().size());
	}

	@Test
	public void findProgrammeTest(){
		assertEquals(0, 0);
	}

	@Test
	public void saveProgrammeTest(){
		assertEquals(0, 0);
	}

	@Test
	public void deleteProgrammeTest(){
		programmeDao.deleteProgramme(null);
		assertEquals(1, programmeDao.findAllProgrammes().size());
	}
}