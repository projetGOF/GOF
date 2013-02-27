package gof.tests;

import static org.junit.Assert.*;

import gof.dao.SpecialiteDao;

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
	
	@Test
	public void findAllSpecialitesTest(){
		assertEquals(2, specialiteDao.findAllSpecialites().size());
	}

	@Test
	public void findSpecialiteTest(){
		assertEquals(0, 0);
	}

	@Test
	public void saveSpecialiteTest(){
		assertEquals(0, 0);
	}

	@Test
	public void deleteSpecialiteTest(){
		specialiteDao.deleteSpecialite(null);
		assertEquals(1, specialiteDao.findAllSpecialites().size());
	}
}