package gof.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@SuppressWarnings("serial")
@Entity(name="composante")
@XmlAccessorType(XmlAccessType.FIELD)
public class Composante implements Serializable {

	@Id
	@Column(name="code", length=15)
	@XmlAttribute(name="code")
	private String code;
	@XmlElement(name="nom")
	private String nom;
	@XmlElement(name="web")
	private String web;
	@XmlElement(name="acronyme")
	private String acronyme;
		
	public Composante() {}
	
	public Composante(String code, String nom, String web, String acronyme) {
		super();
		this.code = code;
		this.nom = nom;
		this.web = web;
		this.acronyme = acronyme;
	}



	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
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
	
	public String getAcronyme() {
		return acronyme;
	}

	public void setAcronyme(String acronyme) {
		this.acronyme = acronyme;
	}
}