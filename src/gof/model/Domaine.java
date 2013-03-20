package gof.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@SuppressWarnings("serial")
@Entity(name="domaine")
public class Domaine implements Serializable{

	@Id
	@Column(name="code", length=50)
	private String code;
	private String nom;
	
	@ManyToMany(mappedBy="domaines")
	private Set<Mention> mentions;
	
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