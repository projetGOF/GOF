package gof.tests;

import static org.junit.Assert.*;

import gof.dao.MotCleDao;
import gof.model.MotCle;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/gof/tests/applicationContext-tests.xml"})
public class MotCleDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private MotCleDao motCleDao;
	
	@Test
	public void findAllMotsClesTest(){
		assertEquals(2,motCleDao.findAllMotsCles().size());
	}

	@Test
	public void findMotCleTest(){
		assertEquals("MOTCLE2",motCleDao.findMotCle("MOTCLE2").getMotcle());
	}

	@Test
	public void saveMotCleTest(){
		MotCle motCleToSave = new MotCle("MOTCLE3");
		motCleDao.saveMotCle(motCleToSave);
		assertEquals(motCleToSave.getMotcle(), motCleDao.findMotCle("MOTCLE3").getMotcle());
	}

	@Test
	public void deleteMotCleTest(){
		motCleDao.deleteMotCle(motCleDao.findMotCle("MOTCLE1"));
		assertEquals(1,motCleDao.findAllMotsCles().size());
	}
}
