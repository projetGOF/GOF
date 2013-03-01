package gof.tests;

import java.util.List;

import javax.xml.bind.JAXBException;

import gof.model.Personne;
import gof.services.PersonneManager;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import gof.data.ImportXML;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/gof/tests/applicationContext-import.xml"})
public class ImportDataTest extends AbstractTransactionalJUnit4SpringContextTests{
	
	@Autowired
	private PersonneManager personneManager;
	private static ImportXML importXml;
	
	@BeforeClass
	public static void debutTest() throws JAXBException{
		importXml = new ImportXML("C:\\Users\\denis\\Documents\\Luminy_2012\\Semestre_I\\Projet\\GOF\\offre.xml");
	}
		
	@Test
	public void importPersonnes() throws JAXBException{
		List<Personne> personnes = (List<Personne>) importXml.getPersonnes();
		for(int i=0;i<personnes.size();i++)
			personneManager.savePersonne(personnes.get(i));
	}
}