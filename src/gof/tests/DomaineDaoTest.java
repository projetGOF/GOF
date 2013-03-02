package gof.tests;

import static org.junit.Assert.*;

import gof.dao.DomaineDao;
import gof.dao.MentionDao;
import gof.model.Domaine;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/gof/tests/applicationContext-tests.xml"})
public class DomaineDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private DomaineDao domaineDao;
	
	@Autowired
	private MentionDao mentionDao;
	
	@Test
	public void findAllDomainesTest(){
		assertEquals(2,domaineDao.findAllDomaines().size());
	}

	@Test
	public void findDomaineTest(){
		assertEquals("NOM2",domaineDao.findDomaine("DOM2").getNom());
	}

	@Test
	public void saveDomaineTest(){
		Domaine domaineToSave = new Domaine("DOM3","NOM3");
		domaineDao.saveDomaine(domaineToSave);
		assertEquals(domaineToSave.getCode(), domaineDao.findDomaine("DOM3").getCode());
	}

	@Test
	public void deleteDomaineTest(){
		mentionDao.findMention("MENT01").getDomaines().remove(domaineDao.findDomaine("DOM1"));
		domaineDao.deleteDomaine(domaineDao.findDomaine("DOM1"));
		assertEquals(1,domaineDao.findAllDomaines().size());
	}
}
