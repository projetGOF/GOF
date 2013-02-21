package gof.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import gof.dao.StatutDao;
import gof.model.Personne;
import gof.model.Statut;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/gof/tests/applicationContext-tests.xml"})
public class StatutDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	private StatutDao statutDao;

	@Test
	public void findAllStatutsTest(){
		assertEquals(3,statutDao.findAllStatut().size());
	}
	
	@Test
	public void findStatutTest(){
		assertEquals("Administrateur",statutDao.findStatut("ROLE_ADMIN").getDescription());
	}
	
	@Test
	public void saveStatutTest(){
		
		Statut statutToSave = new Statut("ROLE_TEST","TEST",new ArrayList<Personne>());
		statutDao.saveStatut(statutToSave);
		assertEquals(statutToSave.getCode(),statutDao.findStatut("ROLE_TEST").getCode());
	}
	
	@Test
	public void deleteStatutTest(){
		/*Statut statutToSave = new Statut("ROLE_TEST","TEST",new ArrayList<Personne>());
		statutDao.saveStatut(statutToSave);
		assertEquals(4,statutDao.findAllStatut().size());*/
		
		statutDao.deleteStatut(statutDao.findStatut("ROLE_ADMIN"));
		assertEquals(3,statutDao.findAllStatut().size());
	}
}