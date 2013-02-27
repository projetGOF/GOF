package gof.tests;

import static org.junit.Assert.*;

import java.util.List;

import gof.dao.ComposantProgrammeDao;
import gof.model.ComposantProgramme;
import gof.model.ElemStruct;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/gof/tests/applicationContext-tests.xml"})
public class ComposantProgrammeDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private ComposantProgrammeDao composantProgrammeDao;
	
	@Before
	public void init() {
//		ElemStruct elemStruct0 = new ElemStruct("CES0", "NOM0", "30", "0", "1", "0", "42", "NULL");
//		ElemStruct elemStruct1 = new ElemStruct("CES1", "NOM1", "30", "1", "0", "1", "24", "NULL");
	}
	
	@Test
	public void findAllComposantsProgrammeTest() {
//		assertEquals(2,composantProgrammeDao.findAllComposantsProgramme().size());
	}

	@Test
	public void findComposantProgrammeTest() {
		
	}

	@Test
	public void saveComposantProgrammeTest() {
		
	}

	@Test
	public void deleteComposantProgrammeTest() {
		
	}
	
}
