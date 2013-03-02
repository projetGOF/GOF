package gof.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity(name="diplome")
@XmlAccessorType(XmlAccessType.FIELD)
public class Diplome {

	@Id
	@Column(name="code", length=15)
	@XmlAttribute(name="code")
	private String code;
	
	@XmlElement(name="type_diplome")
	private String type;
	
	@XmlElement(name="identificateur")
	private String identificateur;
	
	@XmlElement(name="nom")
	private String nom;
	
	@XmlElement(name="nom-court")
	private String nomCourt;
	
	@XmlElement(name="publiable")
	private String publiable;				//changer en boolean?
	
	@XmlElement(name="acronyme")
	private String acronyme;
	
	@XmlElement(name="rang")
	private String rang;
	
	@Enumerated(EnumType.STRING)
	@XmlTransient
	private TypeDiplome typeDiplome;
	
	@ElementCollection
	@CollectionTable(name="diplome_info",joinColumns=@JoinColumn(name="code_diplome"))
	@XmlElement(name="x-diplome")
	private List<InfoDiplome> info;
		
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getIdentificateur() {
		return identificateur;
	}
	
	public void setIdentificateur(String identificateur) {
		this.identificateur = identificateur;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getNomCourt() {
		return nomCourt;
	}
	
	public void setNomCourt(String nomCourt) {
		this.nomCourt = nomCourt;
	}
	
	public String getPubliable() {
		return publiable;
	}

	public void setPubliable(String publiable) {
		this.publiable = publiable;
	}

	public String getAcronyme() {
		return acronyme;
	}
	
	public void setAcronyme(String acronyme) {
		this.acronyme = acronyme;
	}
	
	public String getRang() {
		return rang;
	}
	
	public void setRang(String rang) {
		this.rang = rang;
	}

	public TypeDiplome getTypeDiplome() {
		return typeDiplome;
	}

	public void setTypeDiplome(TypeDiplome typeDiplome) {
		this.typeDiplome = typeDiplome;
	}
	
	public List<InfoDiplome> getInfo() {
		return info;
	}
	
	public void setInfo(List<InfoDiplome> info) {
		this.info = info;
	}
}