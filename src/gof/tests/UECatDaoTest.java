package gof.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import java.util.Date;
import gof.dao.UECatDao;
import gof.model.ElemStruct;
import gof.model.Personne;
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
		UECat uECatToSave = new UECat(
				"UE02", "UECAT 02", 30, true, 
				true, true, 0, 
				new ArrayList<ElemStruct>(), "apogee", 10, 
				"competences", "competencesHab", new Date(), 
				10, "etatRof", "langue", "mcc", 
				"preRequis", "preRequisHab", "preRequisOblig", 
				"preRequisObligHab", 10, 10, 10, 
				0, "bibliographie", "capitalisation", 
				"coefficient", "contenu", "contenuHab", 
				"discipline", "modalitesOrganisation", 
				"typeEns", 10, 20, 
				42, new ArrayList<Personne>(), 
				true);
		uECatDao.saveUECat(uECatToSave);
		assertEquals("UECAT 02", uECatDao.findUECat("UE02").getNom());
	}

	@Test
	public void deleteUECatTest(){
		uECatDao.deleteUECat(uECatDao.findUECat("UE01"));
		assertEquals(0,uECatDao.findAllUECats().size());
	}
}
