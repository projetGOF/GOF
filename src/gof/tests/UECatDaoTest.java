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
		assertEquals(2,uECatDao.findAllUECats().size());
	}

//	@Test
//	public void findUECatTest(){
//		assertEquals("NOM2",uECatDao.findUECat().getNom());
//	}
//
//	@Test
//	public void saveUECatTest(){
//		UECat uECatToSave = new UECat();
//		uECatDao.saveUECat(uECatToSave);
//		assertEquals(uECatToSave.getCode(), uECatDao.findUECat().getCode());
//	}
//
//	@Test
//	public void deleteUECatTest(){
//		uECatDao.deleteUECat(uECatDao.findUECat());
//		assertEquals(1,uECatDao.findAllUECats().size());
//	}
}
