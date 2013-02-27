package gof.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import java.util.Date;
import gof.dao.UECatDao;
import gof.model.ElemStruct;
import gof.model.Personne;
import gof.model.UECat;

import org.junit.Before;
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
	
	
	
	@Before
	public void init() {
		UECat ueCat = new UECat(	"codeUE", "nomUE", 30, true, 
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
		uECatDao.saveUECat(ueCat);
	}
		
	
	@Test
	public void findAllUECatsTest(){
		assertEquals(1,uECatDao.findAllUECats().size());
	}

	@Test
	public void findUECatTest(){
		assertEquals("nomUE",uECatDao.findUECat("codeUE").getNom());
	}

	@Test
	public void saveUECatTest(){
		UECat uECatToSave = new UECat(
				"codeUE", "nomUE", 30, true, 
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
		assertEquals(uECatToSave.getNom(), uECatDao.findUECat("codeUE").getNom());
	}

	@Test
	public void deleteUECatTest(){
		uECatDao.deleteUECat(uECatDao.findUECat("codeUE"));
		assertEquals(0,uECatDao.findAllUECats().size());
	}
}
