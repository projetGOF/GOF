package gof.tests;

import static org.junit.Assert.*;

import gof.dao.EnseignementDao;

import gof.model.Enseignement;

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
		assertEquals(1, enseignementDao.findAllEnseignements().size());
	}

	@Test
	public void findEnseignementTest(){
		assertEquals("ENSEIGNEMENT 01", enseignementDao.findEnseignement("ENS01").getNom());
	}

	@Test
	public void saveEnseignementTest(){
		Enseignement enseignement = new Enseignement();
		
		enseignement.setCode("ENS02");
		enseignement.setNom("ENSEIGNEMENT 02");
		
		enseignement.setContenuValide(true);
		enseignement.setStructureValide(true);
		enseignement.setNbCredits(0);
		enseignement.setNbErreurs(0);
		enseignement.setPubliable(true);
		
		enseignement.setCapacite(0);
		enseignement.setDureeStage(0);
		enseignement.setVolAutres(0);
		enseignement.setVolCM(0);
		enseignement.setVolGlobal(0);
		enseignement.setVolTD(0);
		enseignement.setVolTP(0);
		enseignement.setVolTravail(0);
		enseignement.setVersion(0);
		enseignement.setMutualisable(true);
		
		enseignementDao.saveEnseignement(enseignement);
		assertEquals("ENSEIGNEMENT 02", enseignementDao.findEnseignement("ENS02").getNom());
	}

	@Test
	public void deleteEnseignementTest(){
		enseignementDao.deleteEnseignement(enseignementDao.findEnseignement("ENS01"));
		assertEquals(0, enseignementDao.findAllEnseignements().size());
	}
}