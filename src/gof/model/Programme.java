package gof.model;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity(name="programme")
public class Programme extends ElemStruct {
	
	protected String identificateur;
	protected String apogee;
	protected String aspectsFormatRecherche;
	protected int capacite;
	protected String competences;
	
	@Temporal(TemporalType.DATE)
	protected Date dateModification;
	
	protected int dureeStage;
	protected String ensDelocalisees;
	protected String ensDelocaliseesHab;
	protected String etatRof;
	protected String infosDiverses;
	protected String langue;
	protected String mcc;
	protected String modalitesInscription;
	protected String modalitesPedagogique;
	protected String nfs1;
	protected String nfs2;
	protected String nfs3;
	protected String objectifs;
	protected String politiqueStages;
	protected String preRequis;
	protected String preRequisHab;
	protected String preRequisOblig;
	protected String preRequisObligHab;
	protected String rome1;
	protected String rome2;
	protected String rome3;
	protected String rome4;
	protected String rome5;
	protected String specialite1;
	protected String specialite2;
	protected String specialite3;
	@Column(nullable=false)
	protected boolean troncCommun;
	protected int version;
	protected int volCM;
	protected int volTD;
	protected int volTP;
	protected String web;
	
    @ManyToMany
    @JoinTable(name="programme_responsable",
    	joinColumns=@JoinColumn(name="code_programme"),
    	inverseJoinColumns=@JoinColumn(name="code_responsable"))
    protected Collection<Personne> responsables;
    
    @OneToMany
    @JoinColumn(name="code_programme_rattache")
    protected Collection<ComposantProgramme> composantsProgrammeRattaches;
    
    @OneToMany
    @JoinColumn(name="code_programme_rattache")
    protected Collection<Enseignement> enseignementsRattaches;
    
    public Programme() {}

	public Programme(String code, String nom, int nbCredits, boolean publiable,
			boolean contenuValide, boolean structureValide, int nbErreurs,
			List<ElemStruct> elementsFils, String identificateur,
			String apogee, String aspectsFormatRecherche, int capacite,
			String competences, Date dateModification, int dureeStage,
			String ensDelocalisees, String ensDelocaliseesHab, String etatRof,
			String infosDiverses, String langue, String mcc,
			String modalitesInscription, String modalitesPedagogique,
			String nfs1, String nfs2, String nfs3, String objectifs,
			String politiqueStages, String preRequis, String preRequisHab,
			String preRequisOblig, String preRequisObligHab, String rome1,
			String rome2, String rome3, String rome4, String rome5,
			String specialite1, String specialite2, String specialite3,
			boolean troncCommun, int version, int volCM, int volTD, int volTP,
			String web, Collection<Personne> responsables,
			Collection<ComposantProgramme> composantsProgrammeRattaches,
			Collection<Enseignement> enseignementsRattaches) {
		super(code, nom, nbCredits, publiable, contenuValide, structureValide,
				nbErreurs, elementsFils);
		this.identificateur = identificateur;
		this.apogee = apogee;
		this.aspectsFormatRecherche = aspectsFormatRecherche;
		this.capacite = capacite;
		this.competences = competences;
		this.dateModification = dateModification;
		this.dureeStage = dureeStage;
		this.ensDelocalisees = ensDelocalisees;
		this.ensDelocaliseesHab = ensDelocaliseesHab;
		this.etatRof = etatRof;
		this.infosDiverses = infosDiverses;
		this.langue = langue;
		this.mcc = mcc;
		this.modalitesInscription = modalitesInscription;
		this.modalitesPedagogique = modalitesPedagogique;
		this.nfs1 = nfs1;
		this.nfs2 = nfs2;
		this.nfs3 = nfs3;
		this.objectifs = objectifs;
		this.politiqueStages = politiqueStages;
		this.preRequis = preRequis;
		this.preRequisHab = preRequisHab;
		this.preRequisOblig = preRequisOblig;
		this.preRequisObligHab = preRequisObligHab;
		this.rome1 = rome1;
		this.rome2 = rome2;
		this.rome3 = rome3;
		this.rome4 = rome4;
		this.rome5 = rome5;
		this.specialite1 = specialite1;
		this.specialite2 = specialite2;
		this.specialite3 = specialite3;
		this.troncCommun = troncCommun;
		this.version = version;
		this.volCM = volCM;
		this.volTD = volTD;
		this.volTP = volTP;
		this.web = web;
		this.responsables = responsables;
		this.composantsProgrammeRattaches = composantsProgrammeRattaches;
		this.enseignementsRattaches = enseignementsRattaches;
	}

	public String getIdentificateur() {
		return identificateur;
	}

	public void setIdentificateur(String identificateur) {
		this.identificateur = identificateur;
	}

	public String getApogee() {
		return apogee;
	}

	public void setApogee(String apogee) {
		this.apogee = apogee;
	}

	public String getAspectsFormatRecherche() {
		return aspectsFormatRecherche;
	}

	public void setAspectsFormatRecherche(String aspectsFormatRecherche) {
		this.aspectsFormatRecherche = aspectsFormatRecherche;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public String getCompetences() {
		return competences;
	}

	public void setCompetences(String competences) {
		this.competences = competences;
	}

	public Date getDateModification() {
		return dateModification;
	}

	public void setDateModification(Date dateModification) {
		this.dateModification = dateModification;
	}

	public int getDureeStage() {
		return dureeStage;
	}

	public void setDureeStage(int dureeStage) {
		this.dureeStage = dureeStage;
	}

	public String getEnsDelocalisees() {
		return ensDelocalisees;
	}

	public void setEnsDelocalisees(String ensDelocalisees) {
		this.ensDelocalisees = ensDelocalisees;
	}

	public String getEnsDelocaliseesHab() {
		return ensDelocaliseesHab;
	}

	public void setEnsDelocaliseesHab(String ensDelocaliseesHab) {
		this.ensDelocaliseesHab = ensDelocaliseesHab;
	}

	public String getEtatRof() {
		return etatRof;
	}

	public void setEtatRof(String etatRof) {
		this.etatRof = etatRof;
	}

	public String getInfosDiverses() {
		return infosDiverses;
	}

	public void setInfosDiverses(String infosDiverses) {
		this.infosDiverses = infosDiverses;
	}

	public String getLangue() {
		return langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}

	public String getMcc() {
		return mcc;
	}

	public void setMcc(String mcc) {
		this.mcc = mcc;
	}

	public String getModalitesInscription() {
		return modalitesInscription;
	}

	public void setModalitesInscription(String modalitesInscription) {
		this.modalitesInscription = modalitesInscription;
	}

	public String getModalitesPedagogique() {
		return modalitesPedagogique;
	}

	public void setModalitesPedagogique(String modalitesPedagogique) {
		this.modalitesPedagogique = modalitesPedagogique;
	}

	public String getNfs1() {
		return nfs1;
	}

	public void setNfs1(String nfs1) {
		this.nfs1 = nfs1;
	}

	public String getNfs2() {
		return nfs2;
	}

	public void setNfs2(String nfs2) {
		this.nfs2 = nfs2;
	}

	public String getNfs3() {
		return nfs3;
	}

	public void setNfs3(String nfs3) {
		this.nfs3 = nfs3;
	}

	public String getObjectifs() {
		return objectifs;
	}

	public void setObjectifs(String objectifs) {
		this.objectifs = objectifs;
	}

	public String getPolitiqueStages() {
		return politiqueStages;
	}

	public void setPolitiqueStages(String politiqueStages) {
		this.politiqueStages = politiqueStages;
	}

	public String getPreRequis() {
		return preRequis;
	}

	public void setPreRequis(String preRequis) {
		this.preRequis = preRequis;
	}

	public String getPreRequisHab() {
		return preRequisHab;
	}

	public void setPreRequisHab(String preRequisHab) {
		this.preRequisHab = preRequisHab;
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

	public String getRome1() {
		return rome1;
	}

	public void setRome1(String rome1) {
		this.rome1 = rome1;
	}

	public String getRome2() {
		return rome2;
	}

	public void setRome2(String rome2) {
		this.rome2 = rome2;
	}

	public String getRome3() {
		return rome3;
	}

	public void setRome3(String rome3) {
		this.rome3 = rome3;
	}

	public String getRome4() {
		return rome4;
	}

	public void setRome4(String rome4) {
		this.rome4 = rome4;
	}

	public String getRome5() {
		return rome5;
	}

	public void setRome5(String rome5) {
		this.rome5 = rome5;
	}

	public String getSpecialite1() {
		return specialite1;
	}

	public void setSpecialite1(String specialite1) {
		this.specialite1 = specialite1;
	}

	public String getSpecialite2() {
		return specialite2;
	}

	public void setSpecialite2(String specialite2) {
		this.specialite2 = specialite2;
	}

	public String getSpecialite3() {
		return specialite3;
	}

	public void setSpecialite3(String specialite3) {
		this.specialite3 = specialite3;
	}

	public boolean isTroncCommun() {
		return troncCommun;
	}

	public void setTroncCommun(boolean troncCommun) {
		this.troncCommun = troncCommun;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getVolCM() {
		return volCM;
	}

	public void setVolCM(int volCM) {
		this.volCM = volCM;
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

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public Collection<Personne> getResponsables() {
		return responsables;
	}

	public void setResponsables(Collection<Personne> responsables) {
		this.responsables = responsables;
	}

	public Collection<ComposantProgramme> getComposantsProgrammeRattaches() {
		return composantsProgrammeRattaches;
	}

	public void setComposantsProgrammeRattaches(
			Collection<ComposantProgramme> composantsProgrammeRattaches) {
		this.composantsProgrammeRattaches = composantsProgrammeRattaches;
	}

	public Collection<Enseignement> getEnseignementsRattaches() {
		return enseignementsRattaches;
	}

	public void setEnseignementsRattaches(
			Collection<Enseignement> enseignementsRattaches) {
		this.enseignementsRattaches = enseignementsRattaches;
	}

	
}