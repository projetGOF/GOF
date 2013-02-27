package gof.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import gof.dao.EnseignementDao;
import gof.model.ElemStruct;
import gof.model.Enseignement;
import gof.model.Personne;

import org.junit.Before;
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
	
	@Before
	public void init() {
		
		Enseignement enseignement = new Enseignement(
				"codeEns", "nomENS", 30, 
				true, true, true, 
				0, new ArrayList<ElemStruct>(), "apogee", 
				10, "competences", "competencesHab", 
				new Date(), 6, "etatRof", 
				"langue", "mcc", "preRequis", "preRequisHab", 
				"preRequisOblig", "preRequisObligHab", 10, 
				10, 11, 0, "bibliographie", 
				"capitalisation", "coefficient", "contenu", 
				"contenuHab", "discipline", "modalitesOrganisation", 
				false, "typeEns", 10, 20, 
				42, new ArrayList<Personne>());
		
		enseignementDao.saveEnseignement(enseignement);
		
		
		
	}
	
	
	@Test
	public void findAllEnseignementsTest(){
		assertEquals(1, enseignementDao.findAllEnseignements().size());
	}

	@Test
	public void findEnseignementTest(){
		assertEquals("nomENS", enseignementDao.findEnseignement("codeEns").getNom());
	}

	@Test
	public void saveEnseignementTest(){
		Enseignement enseignement2 = new Enseignement(
				"codeEns2", "nomENS2", 30, 
				true, true, true, 
				0, new ArrayList<ElemStruct>(), "apogee", 
				10, "competences", "competencesHab", 
				new Date(), 6, "etatRof", 
				"langue", "mcc", "preRequis", "preRequisHab", 
				"preRequisOblig", "preRequisObligHab", 10, 
				10, 11, 0, "bibliographie", 
				"capitalisation", "coefficient", "contenu", 
				"contenuHab", "discipline", "modalitesOrganisation", 
				false, "typeEns", 10, 20, 
				42, new ArrayList<Personne>());
		enseignementDao.saveEnseignement(enseignement2);
		assertEquals("nomENS2", enseignementDao.findEnseignement("codeEns2").getNom());
	}

	@Test
	public void deleteEnseignementTest(){
		enseignementDao.deleteEnseignement(enseignementDao.findEnseignement("codeEns"));
		assertEquals(0, enseignementDao.findAllEnseignements().size());
	}
}
