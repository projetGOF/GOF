package gof.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Version;

@SuppressWarnings("serial")
@Entity(name="element")
@Inheritance(strategy=InheritanceType.JOINED)
public class ElemStruct implements Serializable {

	@Id
	@Column(name="code", length=50)
	protected String code;
	
	@Column(nullable=false)
	protected String nom;
	@Column(nullable=false)
	protected int nbCredits;
	@Column(nullable=false)
	protected boolean publiable;
	@Column(nullable=false)
	protected boolean contenuValide;
	@Column(nullable=false)
	protected boolean structureValide;
	@Column(nullable=false)
	protected int nbErreurs;
	
	@ManyToMany
	@OrderColumn(name = "rang")
    @JoinTable(name="element_fils",
    	joinColumns=@JoinColumn(name="code_pere"),
    	inverseJoinColumns=@JoinColumn(name="code_fils"))
	protected List<ElemStruct> elementsFils;
	
	@ManyToMany(mappedBy="elementsFils")
	protected List<ElemStruct> elementsPere;
	
	@OneToMany
	@JoinColumn(name="code")
	protected Set<ErreurStruct> erreursStruct;
	
	@Version
	protected long version;
	
	public ElemStruct() {}

	public ElemStruct(String code, String nom, int nbCredits,
			boolean publiable, boolean contenuValide, boolean structureValide,
			int nbErreurs, List<ElemStruct> elementsFils,
			Set<ErreurStruct> erreursStruct) {
		super();
		this.code = code;
		this.nom = nom;
		this.nbCredits = nbCredits;
		this.publiable = publiable;
		this.contenuValide = contenuValide;
		this.structureValide = structureValide;
		this.nbErreurs = nbErreurs;
		this.elementsFils = elementsFils;
		this.erreursStruct = erreursStruct;
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

	public List<ElemStruct> getElementsPere() {
		return elementsPere;
	}

	public void setElementsPere(List<ElemStruct> elementsPere) {
		this.elementsPere = elementsPere;
	}

	public Set<ErreurStruct> getErreursStruct() {
		return erreursStruct;
	}

	public void setErreursStruct(Set<ErreurStruct> erreursStruct) {
		this.erreursStruct = erreursStruct;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	
}

	