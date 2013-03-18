package gof.tests;

import static org.junit.Assert.*;

import gof.services.PersonneManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/gof/tests/applicationContext-tests.xml"})
public class PersonneManagerTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	private PersonneManager personneManager;
	
	@Test
	public void findAllCodesFichesTest()
	{	
		assertEquals(6, personneManager.findAllCodesFiches(personneManager.findPersonByCode("PER02")).size());		
	}

}
