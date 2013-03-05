package gof.data;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;

import gof.data.XLP;
import gof.data.DiplomesWrapper;

import gof.model.Composante;
import gof.model.Domaine;
import gof.model.Personne;
import gof.model.UECat;
import gof.services.ComposanteManager;
import gof.services.DomaineManager;
import gof.services.PersonneManager;
import gof.services.UECatManager;

public class ImportXML implements Import {
	
	private File file;
	private JAXBContext jaxbContext;
	private Unmarshaller unmarshaller;
	private DiplomesWrapper diplomes;
	
	@Autowired
	private PersonneManager personneManager;
	@Autowired
	private DomaineManager domaineManager;
	@Autowired
	private ComposanteManager composanteManager;
	@Autowired
	private UECatManager uecatManager;
	//@Autowired
	//private DiplomeManager diplomeManager;
	
	public ImportXML(	String path) throws JAXBException{
		file = new File(path);
		jaxbContext = JAXBContext.newInstance(DiplomesWrapper.class);
		unmarshaller = jaxbContext.createUnmarshaller();
        diplomes = (DiplomesWrapper) unmarshaller.unmarshal(file);   
	}
	
	public void importerPersonnes(){
		List<Personne> personnes = diplomes.getPersonnes();
		for(int i=0; i<personnes.size(); i++){
			personneManager.savePersonne(personnes.get(i));
		}
	}
	
	public void importerCatalogues(){
		List<UECat> catalogues = diplomes.getCatalogues();
		for(int i=0; i<catalogues.size(); i++){
			uecatManager.saveUECat(catalogues.get(i));
		}
	}
	
	public void importerComposantes(){
		List<Composante> composantes = diplomes.getComposantes();
		for(int i=0; i<composantes.size(); i++){
			composanteManager.saveComposante(composantes.get(i));
		}
	}
	
	public void importerDomaines(){
		List<Domaine> domaines = diplomes.getDomaines();
		for(int i=0; i<domaines.size(); i++){
			domaineManager.saveDomaine(domaines.get(i));
		}
	}
	
	/**public void importerDiplomes(){
		List<Diplome> allDiplomes = new ArrayList<Diplome>();
		allDiplomes.addAll(diplomes.getDiplomes());
		allDiplomes.addAll(diplomes.getDiplomesAutres());
		for(int i=0; i<allDiplomes.size(); i++){
			diplomeManager.saveDiplome(allDiplomes.get(i));
		}
	}*/
	
	
	public void importerXLPS(){
		List<XLP> xlps = diplomes.getXLPS();
		for(int i=0; i<xlps.size(); i++){
			//xlpManager.saveXLP(xlps.get(i));
		}
	}
	/*
	public void importerEnseignements(){
		List<Enseignement> enseignements = diplomes.getEnseignements();
		for(int i=0; i<enseignements.size(); i++){
			//enseignementManager.saveEnseignement(enseignements.get(i));
		}
	}*/
	
    public List<Personne> getPersonnes() {
        return diplomes.getPersonnes();
    }
    
    public List<UECat> getCatalogues() {
        return diplomes.getCatalogues();        
    }

	public List<Composante> getComposantes() {
		return diplomes.getComposantes();
	}

	public List<Domaine> getDomaines() {
		return diplomes.getDomaines();
	}
	
	/**public List<Diplome> getDiplomes() {
		List<Diplome> allDiplomes = new ArrayList<Diplome>();
		allDiplomes.addAll(diplomes.getDiplomes());
		allDiplomes.addAll(diplomes.getDiplomesAutres());
		return allDiplomes;
	}*/
	
	public List<XLP> getXLPS() {		
		return diplomes.getXLPS();
	}
	
	public void importerAll(){
		importerPersonnes();
		importerCatalogues();
		importerComposantes();
		importerDomaines();
		//importerDiplomes();
		importerXLPS();
	}
}