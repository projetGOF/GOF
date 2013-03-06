package gof.tests;

import static org.junit.Assert.*;

import gof.dao.UECatDao;
import gof.model.UECat;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/gof/tests/applicationContext-tests.xml"})
public class UECatDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private UECatDao uECatDao;		
	
	@Test
	public void findAllUECatsTest(){
		assertEquals(1,uECatDao.findAllUECats().size());
	}

	@Test
	public void findUECatTest(){
		assertEquals("UECAT 01",uECatDao.findUECat("UE01").getNom());
	}

	@Test
	public void saveUECatTest(){
		UECat uECat = new UECat();
		
		uECat.setCode("UE02");
		uECat.setNom("UECAT 02");
		
		uECat.setContenuValide(true);
		uECat.setStructureValide(true);
		uECat.setNbCredits(0);
		uECat.setNbErreurs(0);
		uECat.setPubliable(true);
		
		uECat.setCapacite(0);
		uECat.setDureeStage(0);
		uECat.setVolAutres(0);
		uECat.setVolCM(0);
		uECat.setVolGlobal(0);
		uECat.setVolTD(0);
		uECat.setVolTP(0);
		uECat.setVolTravail(0);
		uECat.setVersion(0);
		uECat.setMiseEnService(true);
		uECat.setLangue(0);
		
		uECatDao.saveUECat(uECat);
		assertEquals("UECAT 02", uECatDao.findUECat("UE02").getNom());
	}

	@Test
	public void deleteUECatTest(){
		uECatDao.deleteUECat(uECatDao.findUECat("UE01"));
		assertEquals(0,uECatDao.findAllUECats().size());
	}
}