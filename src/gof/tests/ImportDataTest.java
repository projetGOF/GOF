package gof.tests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.xml.bind.JAXBException;

import gof.model.Composante;
import gof.model.Domaine;
import gof.model.Personne;
import gof.services.ComposanteManager;
import gof.services.DomaineManager;
import gof.services.PersonneManager;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import gof.data.ImportXML;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/gof/tests/applicationContext-import.xml"})
public class ImportDataTest {
	
	@Autowired
	private PersonneManager personneManager;
	@Autowired
	private DomaineManager domaineManager;
	@Autowired
	private ComposanteManager composanteManager;
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
		assertEquals(personnes.size(),personneManager.findAllPersonnes().size());
	}
	
	@Test
	public void importDomaines() throws JAXBException{
		List<Domaine> domaines = (List<Domaine>) importXml.getDomaines();
		for(int i=0;i<domaines.size();i++)
			domaineManager.saveDomaine(domaines.get(i));
		assertEquals(domaines.size(),domaineManager.findAllDomaines().size());
	}

	@Test
	public void importComposantes() throws JAXBException{
		List<Composante> composantes = (List<Composante>) importXml.getComposantes();
		for(int i=0;i<composantes.size();i++)
			composanteManager.saveComposante(composantes.get(i));
		assertEquals(composantes.size(),composanteManager.findAllComposantes().size());
	}
}