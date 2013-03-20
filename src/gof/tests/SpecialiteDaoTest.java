package gof.tests;

import static org.junit.Assert.*;

import gof.dao.MentionDao;
import gof.dao.SpecialiteDao;

import gof.model.Mention;
import gof.model.Specialite;

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
	
	@Autowired
	private MentionDao mentionDao;
	
	@Test
	public void findAllSpecialitesTest(){
		assertEquals(1, specialiteDao.findAllSpecialites().size());
	}

	@Test
	public void findSpecialiteTest(){
		assertEquals("SPECIALITE 01", specialiteDao.findSpecialite("SPE01").getNom());
		assertEquals("MENT01", specialiteDao.findSpecialite("SPE01").getMention().getCode());
	}

	@Test
	public void saveSpecialiteTest(){
		Specialite specialite = new Specialite();
		
		specialite.setCode("SPE02");
		specialite.setNom("SPECIALITE 02");
		specialite.setContenuValide(true);
		specialite.setStructureValide(true);
		specialite.setNbErreurs(0);
		specialite.setPubliable(true);
		specialite.setMention(mentionDao.findMention("MENT01"));
		
		specialiteDao.saveSpecialite(specialite);
		
		Mention mention = mentionDao.findMention("MENT01");
		mention.getSpecialites().add(specialiteDao.findSpecialite("SPE02"));
		
		mentionDao.saveMention(mention);
		
		assertEquals("SPECIALITE 02", specialiteDao.findSpecialite("SPE02").getNom());
		assertEquals("MENT01", specialiteDao.findSpecialite("SPE02").getMention().getCode());
		assertEquals(2, mentionDao.findMention("MENT01").getSpecialites().size());
	}

	@Test
	public void deleteSpecialiteTest(){
		mentionDao.findMention("MENT01").getSpecialites().remove(specialiteDao.findSpecialite("SPE01"));
		specialiteDao.deleteSpecialite(specialiteDao.findSpecialite("SPE01"));
		assertEquals(0, specialiteDao.findAllSpecialites().size());
	}
}