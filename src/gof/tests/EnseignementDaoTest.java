package gof.tests;

import static org.junit.Assert.*;

import gof.dao.EnseignementDao;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/gof/tests/applicationContext-tests.xml"})
public class EnseignementDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private EnseignementDao enseignementDao;
	
	@Test
	public void findAllEnseignementsTest(){
		assertEquals(2, enseignementDao.findAllEnseignements().size());
	}

	@Test
	public void findEnseignementTest(){
		assertEquals(0, 0);
	}

	@Test
	public void saveEnseignementTest(){
		assertEquals(0, 0);
	}

	@Test
	public void deleteEnseignementTest(){
		enseignementDao.deleteEnseignement(null);
		assertEquals(1, enseignementDao.findAllEnseignements().size());
	}
}
