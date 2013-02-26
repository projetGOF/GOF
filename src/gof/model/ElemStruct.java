package gof.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name="element")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class ElemStruct {

	@Id
	@Column(name="code", length=15)
	protected String code;
	
	protected String nom;

	protected int nbCredits;
	
	protected boolean publiable;
	protected boolean contenuValide;
	protected boolean structureValide;
	protected int nbErreurs;
	
	@ManyToMany
    @JoinTable(name="element_fils",
    	joinColumns=@JoinColumn(name="code_pere"),
    	inverseJoinColumns=@JoinColumn(name="code_fils"))
	private List<ElemStruct> elementsFils;
	
	public ElemStruct() {}

	public ElemStruct(String code, String nom, int nbCredits,
			boolean publiable, boolean contenuValide, boolean structureValide,
			int nbErreurs, List<ElemStruct> elementsFils) {
		super();
		this.code = code;
		this.nom = nom;
		this.nbCredits = nbCredits;
		this.publiable = publiable;
		this.contenuValide = contenuValide;
		this.structureValide = structureValide;
		this.nbErreurs = nbErreurs;
		this.elementsFils = elementsFils;
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

	public int getNbCredits() {
		return nbCredits;
	}

	public void setNbCredits(int nbCredits) {
		this.nbCredits = nbCredits;
	}

	public boolean isPubliable() {
		return publiable;
	}

	public void setPubliable(boolean publiable) {
		this.publiable = publiable;
	}

	public boolean isContenuValide() {
		return contenuValide;
	}

	public void setContenuValide(boolean contenuValide) {
		this.contenuValide = contenuValide;
	}

	public boolean isStructureValide() {
		return structureValide;
	}

	public void setStructureValide(boolean structureValide) {
		this.structureValide = structureValide;
	}

	public int getNbErreurs() {
		return nbErreurs;
	}

	public void setNbErreurs(int nbErreurs) {
		this.nbErreurs = nbErreurs;
	}

	public List<ElemStruct> getElementsFils() {
		return elementsFils;
	}

	public void setElementsFils(List<ElemStruct> elementsFils) {
		this.elementsFils = elementsFils;
	}
}
