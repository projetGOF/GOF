package gof.data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import gof.data.DiplomesWrapper;

import gof.model.Composante;
import gof.model.Diplome;
import gof.model.Domaine;
import gof.model.Personne;
import gof.model.UECat;

public class ImportXML implements Import {
	
	private File file;
	private JAXBContext jaxbContext;
	private Unmarshaller unmarshaller;
	private DiplomesWrapper diplomes;
	
	public ImportXML(String path) throws JAXBException{
		file = new File(path);
		jaxbContext = JAXBContext.newInstance(DiplomesWrapper.class);
		unmarshaller = jaxbContext.createUnmarshaller();
        diplomes = (DiplomesWrapper) unmarshaller.unmarshal(file);   
	}
	
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
	
	public List<Diplome> getDiplomes() {
		List<Diplome> allDiplomes = new ArrayList<Diplome>();
		allDiplomes.addAll(diplomes.getDiplomes());
		allDiplomes.addAll(diplomes.getDiplomesAutres());
		return allDiplomes;
	}
}