package gof.tests;

import static org.junit.Assert.*;

import gof.services.ElemStructManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/gof/tests/applicationContext-tests.xml"})
public class ElemStructManagerTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	private ElemStructManager elemStructManager;
	
	@Test
	public void getElemStructTreeTest() {
		assertEquals(4, elemStructManager.getElemStructTree("PROG01").size());
	}

}
