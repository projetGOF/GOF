package gof.tests;

import static org.junit.Assert.*;

import gof.dao.MentionDao;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/gof/tests/applicationContext-tests.xml"})
public class MentionDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private MentionDao mentionDao;
	
	@Test
	public void findAllMentionsTest(){
		assertEquals(1, mentionDao.findAllMentions().size());
	}

//	@Test
//	public void findMentionTest(){
//		assertEquals(0, 0);
//	}
//
//	@Test
//	public void saveMentionTest(){
//		assertEquals(0, 0);
//	}
//
//	@Test
//	public void deleteMentionTest(){
//		mentionDao.deleteMention(null);
//		assertEquals(1, mentionDao.findAllMentions().size());
//	}
}