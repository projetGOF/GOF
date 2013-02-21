package gof.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import gof.dao.PersonneDao;
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
public class PersonneDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	private PersonneDao personneDao;
	
	@Test
	public void findAllPersonnesTest(){
		assertEquals(2,personneDao.findAllPersonnes().size());
	}
	
	@Test
	public void findPersonneByCodeTest(){
		assertEquals("testNom1",personneDao.findPersonneByCode("PER01").getNom());
	}
	
	@Test
	public void savePersonneTest(){
		
		Personne personneToSave = new Personne("PER03","3","testNom3","testPrenom3","testTel3","testMail3",new ArrayList<Statut>());
		personneDao.savePersonne(personneToSave);
		assertEquals(personneToSave.getCode(),personneDao.findPersonneByCode("PER03").getCode());
	}
	
	@Test
	public void deletePersonneTest(){
		personneDao.deletePersonne(personneDao.findPersonneByCode("PER01"));
		assertEquals(1,personneDao.findAllPersonnes().size());
	}

}
