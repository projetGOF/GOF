package gof.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;;

@Entity(name="statut")
public class Statut {
	
	@Id
	private String code;
	private String description;
	
	@ManyToMany(mappedBy="statuts")	
	private Collection<Personne> personnes;
	
	public Statut(){}
	
	public Statut(String code, String description, Collection<Personne> personnes) {
		super();
		this.code = code;
		this.description = description;
		this.personnes = personnes;
	}

	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Collection<Personne> getPersonnes() {
		return personnes;
	}
	
	public void setPersonnes(Collection<Personne> personnes) {
		this.personnes = personnes;
	}
}