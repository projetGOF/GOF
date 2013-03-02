package gof.model;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@SuppressWarnings("serial")
@Entity(name="enseignement")
public class Enseignement extends Formation implements Mutualisable {

	protected String bibliographie;
	protected String capitalisation;
	protected String coefficient;
	protected String contenu;
	protected String contenuHab;
	protected String discipline;
	protected String modalitesOrganisation;
	@Column(nullable=false)
	protected boolean mutualisable;
	protected String typeEns;
	protected int volAutres;
	protected int volGlobal;
	protected int volTravail;
	
	@ManyToMany
    @JoinTable(name="enseignement_responsable",
    	joinColumns=@JoinColumn(name="code_enseignement"),
    	inverseJoinColumns=@JoinColumn(name="code_responsable"))
    protected Collection<Personne> responsables;
	
	public Enseignement() {}

	public Enseignement(String code, String nom, int nbCredits,
			boolean publiable, boolean contenuValide, boolean structureValide,
			int nbErreurs, List<ElemStruct> elementsFils, String apogee,
			int capacite, String competences, String competencesHab,
			Date dateModification, int dureeStage, String etatRof,
			String langue, String mcc, String preRequis, String preRequisHab,
			String preRequisOblig, String preRequisObligHab, int volCM,
			int volTD, int volTP, int version, String bibliographie,
			String capitalisation, String coefficient, String contenu,
			String contenuHab, String discipline, String modalitesOrganisation,
			boolean mutualisable, String typeEns, int volAutres, int volGlobal,
			int volTravail, Collection<Personne> responsables) {
		super(code, nom, nbCredits, publiable, contenuValide, structureValide,
				nbErreurs, elementsFils, apogee, capacite, competences,
				competencesHab, dateModification, dureeStage, etatRof, langue,
				mcc, preRequis, preRequisHab, preRequisOblig,
				preRequisObligHab, volCM, volTD, volTP, version);
		this.bibliographie = bibliographie;
		this.capitalisation = capitalisation;
		this.coefficient = coefficient;
		this.contenu = contenu;
		this.contenuHab = contenuHab;
		this.discipline = discipline;
		this.modalitesOrganisation = modalitesOrganisation;
		this.mutualisable = mutualisable;
		this.typeEns = typeEns;
		this.volAutres = volAutres;
		this.volGlobal = volGlobal;
		this.volTravail = volTravail;
		this.responsables = responsables;
	}



	public String getBibliographie() {
		return bibliographie;
	}

	public void setBibliographie(String bibliographie) {
		this.bibliographie = bibliographie;
	}

	public String getCapitalisation() {
		return capitalisation;
	}

	public void setCapitalisation(String capitalisation) {
		this.capitalisation = capitalisation;
	}

	public String getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(String coefficient) {
		this.coefficient = coefficient;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public String getContenuHab() {
		return contenuHab;
	}

	public void setContenuHab(String contenuHab) {
		this.contenuHab = contenuHab;
	}

	public String getDiscipline() {
		return discipline;
	}

	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}

	public String getModalitesOrganisation() {
		return modalitesOrganisation;
	}

	public void setModalitesOrganisation(String modalitesOrganisation) {
		this.modalitesOrganisation = modalitesOrganisation;
	}

	public boolean isMutualisable() {
		return mutualisable;
	}

	public String getTypeEns() {
		return typeEns;
	}

	public void setTypeEns(String typeEns) {
		this.typeEns = typeEns;
	}

	public int getVolAutres() {
		return volAutres;
	}

	public void setVolAutres(int volAutres) {
		this.volAutres = volAutres;
	}

	public int getVolGlobal() {
		return volGlobal;
	}

	public void setVolGlobal(int volGlobal) {
		this.volGlobal = volGlobal;
	}

	public int getVolTravail() {
		return volTravail;
	}

	public void setVolTravail(int volTravail) {
		this.volTravail = volTravail;
	}

	public Collection<Personne> getResponsables() {
		return responsables;
	}

	public void setResponsables(Collection<Personne> responsables) {
		this.responsables = responsables;
	}
	
	@Override
	public boolean getMutualisable() {
		return this.mutualisable;
	}

	@Override
	public void setMutualisable(boolean mutualisable)
	{
		this.mutualisable = mutualisable;
	}
}
