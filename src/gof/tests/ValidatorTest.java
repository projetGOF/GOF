package gof.tests;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import gof.dao.MentionDao;
import gof.model.Mention;
import gof.validation.Validator;
import gof.validation.ValidatorLine;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/gof/tests/applicationContext-import.xml" })
public class ValidatorTest {

	@Autowired
	private MentionDao mentionDao;
	private Mention mention;
	private Validator validator;
	
	@Before
	public void setUp(){
		
		validator = new Validator();
		mention = mentionDao.findMention("ME3BAS");
	}
	
	@Test
	public void validateFicheTest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		Map<String,ValidatorLine> result = validator.validateFiche(mention, Mention.class);
		
		assertEquals(true,result.get("getAdaptation").getState());
		assertEquals(true,result.get("getAdaptationHab").getState());
		assertEquals(true,result.get("getAdosRecherche").getState());
		assertEquals(true,result.get("getAdosPro").getState());
		assertEquals(true,result.get("getAideInsPro").getState());
		assertEquals(true,result.get("getAideInsProHab").getState());
		assertEquals(true,result.get("getAideOrientation").getState());
		assertEquals(true,result.get("getAideOrientationHab").getState());
	}
}