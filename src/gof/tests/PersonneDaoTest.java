package gof.tests;

import static org.junit.Assert.*;

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
		assertTrue(personneDao.findPersonneByCode("PER01").getStatuts().contains(Statut.ROLE_ADMIN));
	}
	
	@Test
	public void findPersonneByIdExtTest(){
		assertEquals("testNom1",personneDao.findPersonneByIdExt("1").getNom());
	}
	
	@Test
	public void savePersonneTest(){
		
		Personne personne = new Personne();
		
		personne.setCode("PER03");
		personne.setIdext("3");
		
		personneDao.savePersonne(personne);
		assertEquals(personne.getIdext(),personneDao.findPersonneByIdExt("3").getIdext());
	}
	
	@Test
	public void deletePersonneTest(){
		personneDao.deletePersonne(personneDao.findPersonneByIdExt("1"));
		assertEquals(1,personneDao.findAllPersonnes().size());
	}

}
