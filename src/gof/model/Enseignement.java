package gof.model;

import java.util.Set;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity(name="enseignement")
public class Enseignement extends ElemStruct {

	@Column(length = 2000)
	protected String apogee;
	@Column(length = 2000)
	protected String bibliographie;
	protected int capacite;
	@Column(length = 2000)
	protected String capitalisation;
	@Column(length = 2000)
	protected String coefficient;
	@Column(length = 2000)
	protected String competences;
	@Column(length = 2000)
	protected String competencesHab;
	@Column(length = 2000)
	protected String contenu;
	@Column(length = 2000)
	protected String contenuHab;
	
	@Temporal(TemporalType.DATE)
	protected Date dateModification;
	
	@Column(length = 2000)
	protected String discipline;
	protected float dureeStage;
	protected String etatRof;
	protected int langue;
	@Column(length = 2000)
	protected String mcc;
	@Column(length = 2000)
	protected String mccHab;
	@Column(length = 2000)
	protected String modalitesOrganisation;
	
	@Column(nullable=false)
	protected boolean mutualisable;
	
	@Column(length = 2000)
	protected String preRequis;
	@Column(length = 2000)
	protected String preRequisOblig;
	@Column(length = 2000)
	protected String preRequisObligHab;
	protected String typeEns;
	
	protected int volAutres;
	protected int volCM;
	protected int volGlobal;
	protected int volTD;
	protected int volTP;
	protected int volTravail;
	
	@ManyToMany
    @JoinTable(name="enseignement_responsable",
    	joinColumns=@JoinColumn(name="code_enseignement"),
    	inverseJoinColumns=@JoinColumn(name="code_responsable"))
    protected Set<Personne> responsables;
	
	public Enseignement() {}

	public Enseignement(String code, String nom, int nbCredits,
			boolean publiable, boolean contenuValide, boolean structureValide,
			int nbErreurs, List<ElemStruct> elementsFils, String apogee,
			String bibliographie, int capacite, String capitalisation,
			String coefficient, String competences, String competencesHab,
			String contenu, String contenuHab, Date dateModification,
			String discipline, float dureeStage, String etatRof, int langue,
			String mcc, String mccHab, String modalitesOrganisation,
			boolean mutualisable, String preRequis, String preRequisOblig,
			String preRequisObligHab, String typeEns, 
			int volAutres, int volCM, int volGlobal, int volTD, int volTP,
			int volTravail, Set<Personne> responsables) {
		super(code, nom, nbCredits, publiable, contenuValide, structureValide,
				nbErreurs, elementsFils);
		this.apogee = apogee;
		this.bibliographie = bibliographie;
		this.capacite = capacite;
		this.capitalisation = capitalisation;
		this.coefficient = coefficient;
		this.competences = competences;
		this.competencesHab = competencesHab;
		this.contenu = contenu;
		this.contenuHab = contenuHab;
		this.dateModification = dateModification;
		this.discipline = discipline;
		this.dureeStage = dureeStage;
		this.etatRof = etatRof;
		this.langue = langue;
		this.mcc = mcc;
		this.mccHab = mccHab;
		this.modalitesOrganisation = modalitesOrganisation;
		this.mutualisable = mutualisable;
		this.preRequis = preRequis;
		this.preRequisOblig = preRequisOblig;
		this.preRequisObligHab = preRequisObligHab;
		this.typeEns = typeEns;
		this.volAutres = volAutres;
		this.volCM = volCM;
		this.volGlobal = volGlobal;
		this.volTD = volTD;
		this.volTP = volTP;
		this.volTravail = volTravail;
		this.responsables = responsables;
	}

	public String getApogee() {
		return apogee;
	}

	public void setApogee(String apogee) {
		this.apogee = apogee;
	}

	public String getBibliographie() {
		return bibliographie;
	}

	public void setBibliographie(String bibliographie) {
		this.bibliographie = bibliographie;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
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

	public String getCompetences() {
		return competences;
	}

	public void setCompetences(String competences) {
		this.competences = competences;
	}

	public String getCompetencesHab() {
		return competencesHab;
	}

	public void setCompetencesHab(String competencesHab) {
		this.competencesHab = competencesHab;
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

	public Date getDateModification() {
		return dateModification;
	}

	public void setDateModification(Date dateModification) {
		this.dateModification = dateModification;
	}

	public String getDiscipline() {
		return discipline;
	}

	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}

	public float getDureeStage() {
		return dureeStage;
	}

	public void setDureeStage(float dureeStage) {
		this.dureeStage = dureeStage;
	}

	public String getEtatRof() {
		return etatRof;
	}

	public void setEtatRof(String etatRof) {
		this.etatRof = etatRof;
	}

	public int getLangue() {
		return langue;
	}

	public void setLangue(int langue) {
		this.langue = langue;
	}

	public String getMcc() {
		return mcc;
	}

	public void setMcc(String mcc) {
		this.mcc = mcc;
	}

	public String getMccHab() {
		return mccHab;
	}

	public void setMccHab(String mccHab) {
		this.mccHab = mccHab;
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

	public void setMutualisable(boolean mutualisable) {
		this.mutualisable = mutualisable;
	}

	public String getPreRequis() {
		return preRequis;
	}

	public void setPreRequis(String preRequis) {
		this.preRequis = preRequis;
	}

	public String getPreRequisOblig() {
		return preRequisOblig;
	}

	public void setPreRequisOblig(String preRequisOblig) {
		this.preRequisOblig = preRequisOblig;
	}

	public String getPreRequisObligHab() {
		return preRequisObligHab;
	}

	public void setPreRequisObligHab(String preRequisObligHab) {
		this.preRequisObligHab = preRequisObligHab;
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

	public int getVolCM() {
		return volCM;
	}

	public void setVolCM(int volCM) {
		this.volCM = volCM;
	}

	public int getVolGlobal() {
		return volGlobal;
	}

	public void setVolGlobal(int volGlobal) {
		this.volGlobal = volGlobal;
	}

	public int getVolTD() {
		return volTD;
	}

	public void setVolTD(int volTD) {
		this.volTD = volTD;
	}

	public int getVolTP() {
		return volTP;
	}

	public void setVolTP(int volTP) {
		this.volTP = volTP;
	}

	public int getVolTravail() {
		return volTravail;
	}

	public void setVolTravail(int volTravail) {
		this.volTravail = volTravail;
	}

	public Set<Personne> getResponsables() {
		return responsables;
	}

	public void setResponsables(Set<Personne> responsables) {
		this.responsables = responsables;
	}
	
	
}