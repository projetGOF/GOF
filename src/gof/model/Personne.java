package gof.model;

import java.io.Serializable;
import java.util.Collection;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@SuppressWarnings("serial")
@Entity(name="personne")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Personne implements Serializable {
	
	@Id
	@XmlAttribute(name="code")
	private String code;
	
	@Column(unique=true)
	@XmlElement(name="idext")
	private String idext;
	
	@XmlElement(name="nom")
	private String nom;
	
	@XmlElement(name="prenom")
	private String prenom;
	
	@XmlElement(name="telephone")
	private String telephone;
	
	@XmlElement(name="mail")
	private String mail;
	
	@XmlTransient
	private String password;
	
	@ElementCollection
	@CollectionTable(name="personne_statut",
			joinColumns=@JoinColumn(name="code_personne"))
	@Enumerated(EnumType.STRING)
	@XmlTransient
	private Collection<Statut> statuts;
	
	public Personne(){}

	public Personne(String code, String idext, String nom, String prenom,
			String telephone, String mail, String password, Collection<Statut> statuts) {
		super();
		this.code = code;
		this.idext = idext;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.mail = mail;
		this.password = password;
		this.statuts = statuts;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getIdext() {
		return idext;
	}

	public void setIdext(String idext) {
		this.idext = idext;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Collection<Statut> getStatuts() {
		return statuts;
	}

	public void setStatuts(Collection<Statut> statuts) {
		this.statuts = statuts;
	}

	
}