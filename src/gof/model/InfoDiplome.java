package gof.model;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Embeddable
@XmlAccessorType(XmlAccessType.FIELD)
public class InfoDiplome {

	@XmlElement(name="nom")
	private String nom;
	@XmlElement(name="web")
	private String web;
	@XmlElement(name="secteur")
	private String secteur;
	
	public InfoDiplome(){
		
	}
	
	public InfoDiplome(String nom, String web, String secteur) {
		super();
		this.nom = nom;
		this.web = web;
		this.secteur = secteur;
	}	
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getWeb() {
		return web;
	}
	
	public void setWeb(String web) {
		this.web = web;
	}
	
	public String getSecteur() {
		return secteur;
	}
	
	public void setSecteur(String secteur) {
		this.secteur = secteur;
	}
}