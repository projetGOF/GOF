package gof.data;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlPath;

import gof.model.Composante;
import gof.model.Domaine;
import gof.model.Personne;
import gof.model.UECat;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="diplomes")
public class DiplomesWrapper {

	@XmlElement(name="personne", type=Personne.class)
	private List<Personne> personnes;
	
	@XmlElement(name="uecat", type=UECat.class)
	private List<UECat> catalogues;
	
	@XmlPath("extra/composantes/composante")
	private List<Composante> composantes;
	
	@XmlPath("extra/domaines/domaine")
	private List<Domaine> domaines;
			
	public DiplomesWrapper(){
		this.personnes = new ArrayList<Personne>();
		this.catalogues = new ArrayList<UECat>();
		this.composantes = new ArrayList<Composante>();
		this.domaines = new ArrayList<Domaine>();
	}
	public List<Personne> getPersonnes(){
		return this.personnes;
	}
	public void setPersonnes(List<Personne> personnes){
		this.personnes = personnes;
	}	
	public List<UECat> getCatalogues(){
		return this.catalogues;
	}
	public void setCatalogues(List<UECat> catalogues){
		this.catalogues = catalogues;
	}
	public List<Composante> getComposantes() {
		return composantes;
	}
	public void setComposantes(List<Composante> composantes) {
		this.composantes = composantes;
	}
	public List<Domaine> getDomaines() {
		return domaines;
	}
	public void setDomaines(List<Domaine> domaines) {
		this.domaines = domaines;
	}
}