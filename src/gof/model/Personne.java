package gof.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name="personne")
public class Personne
{
	@Id
	@Column(name="code", length=15)
	private String code;
	private String idext;
	private String nom;
	private String prenom;
	private String telephone;
	private String mail;
	
	@ManyToMany
	@JoinTable(name="personne_statut",
	joinColumns=@JoinColumn(name="code_personne"),
	inverseJoinColumns=@JoinColumn(name="code_statut"))
	private Collection<Statut> statuts;
	
	public Personne(){}

	public Personne(String code, String idext, String nom, String prenom,
			String telephone, String mail, Collection<Statut> statuts) {
		super();
		this.code = code;
		this.idext = idext;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.mail = mail;
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

	public Collection<Statut> getStatuts() {
		return statuts;
	}

	public void setStatuts(Collection<Statut> statuts) {
		this.statuts = statuts;
	}

	
}