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
@Entity(name="domaine")
@XmlAccessorType(XmlAccessType.FIELD)
public class Domaine implements Serializable{

	@Id
	@Column(name="code", length=15)
	@XmlAttribute(name="code")
	private String code;
	@XmlElement(name="nom")
	private String nom;
	
	public Domaine() {}
	
	public Domaine(String code, String nom) {
		super();
		this.code = code;
		this.nom = nom;
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
}