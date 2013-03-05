package gof.tests;

import static org.junit.Assert.*;

import gof.dao.MentionDao;
import gof.model.Mention;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/gof/tests/applicationContext-tests.xml"})
public class MentionDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private MentionDao mentionDao;
	
	@Test
	public void findAllMentionsTest(){
		assertEquals(1, mentionDao.findAllMentions().size());
	}

	@Test
	public void findMentionTest(){
		assertEquals("MASTER 1 INFO", mentionDao.findMention("MENT01").getNom());
	}

	@Test
	public void saveMentionTest(){
		Mention mention = new Mention();

		mention.setCode("MENT02");
		mention.setNom("MASTER 2 INFO");
		mention.setDroits(123);
		mention.setContenuValide(true);
		mention.setStructureValide(true);
		mention.setNbCredits(0);
		mention.setNbErreurs(0);
		mention.setPubliable(true);
		mention.setVersion(0);
		
		mentionDao.saveMention(mention);
		assertEquals("MASTER 2 INFO", mentionDao.findMention("MENT02").getNom());
	}

	@Test
	public void deleteMentionTest(){
		mentionDao.deleteMention(mentionDao.findMention("MENT01"));
		assertEquals(0, mentionDao.findAllMentions().size());
	}
}