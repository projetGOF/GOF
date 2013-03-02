package gof.tests;

import static org.junit.Assert.*;

import gof.dao.ComposanteDao;
import gof.dao.MentionDao;
import gof.model.Composante;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/gof/tests/applicationContext-tests.xml"})
public class ComposanteDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	private ComposanteDao composanteDao;
	
	@Autowired
	private MentionDao mentionDao;
	
	@Test
	public void findAllComposantesTest(){
		assertEquals(2,composanteDao.findAllComposantes().size());
	}

	@Test
	public void findComposanteTest(){
		assertEquals("NOM1",composanteDao.findComposante("COMPO01").getNom());
	}

	@Test
	public void saveComposanteTest(){
		Composante composanteToSave = new Composante("COMPO03", "ACRO3", "NOM3", "WEB3");
		composanteDao.saveComposante(composanteToSave);
		assertEquals(composanteToSave.getCode(), composanteDao.findComposante("COMPO03").getCode());
	}

	@Test
	public void deleteComposanteTest(){
		mentionDao.findMention("MENT01").getComposantes().remove(composanteDao.findComposante("COMPO01"));
		composanteDao.deleteComposante(composanteDao.findComposante("COMPO01"));
		assertEquals(1,composanteDao.findAllComposantes().size());
	}

}
