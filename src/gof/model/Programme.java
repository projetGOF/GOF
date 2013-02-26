package gof.model;

import java.util.Date;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="programme")
public class Programme {

	@Id
	@Column(name="code", length=15)
	private String code;
	
	private String nom;
	private String parcours;
	private String identificateur;
	private String apogee;
	private String aspectsFormatRecherche;
	private String capacite;
	
	@ManyToOne
	@JoinColumn(name="code_mention", insertable=false, updatable=false)
	private Mention mention;
	
	private String competences;
	
	@Temporal(TemporalType.DATE)
	private Date dateModification;
	
	private String dureeStage;
	private String ensDelocalisees;
	private String ensDelocaliseesHab;
	private String etatRof;
	private String infosDiverses;
	private String langue;
	private String mcc;
	private String modalitesInscription;
	private String modalitesPedagogique;
	private String nbCredits;
	private String nfs1;
	private String nfs2;
	private String nfs3;
	private String objectifs;
	private String polotiqueStage;
	private String preRequis;
	private String preRequisHab;
	private String preRequisOblig;
	private String rome1;
	private String rome2;
	private String rome3;
	private String rome4;
	private String rome5;
	private String specialite1;
	private String specialite2;
	private String specialite3;
	private String troncCommun;
	private String version;
	private String volCM;
	private String volTD;
	private String volTP;
	private String web;
	
    @ManyToMany
    @JoinTable(name="programme_responsable",
    	joinColumns=@JoinColumn(name="code_programme"),
    	inverseJoinColumns=@JoinColumn(name="code_responsable"))
	private Collection<Personne> responsables;
    
    @ManyToMany
    @JoinTable(name="programme_specialite",
    	joinColumns=@JoinColumn(name="code_programme"),
    	inverseJoinColumns=@JoinColumn(name="code_specialite"))
	private Collection<Specialite> specialites;
    
    public Programme() {}

	public Programme(String code, String nom, String parcours,
			String identificateur, String apogee,
			String aspectsFormatRecherche, String capacite, Mention mention,
			String competences, Date dateModification, String dureeStage,
			String ensDelocalisees, String ensDelocaliseesHab, String etatRof,
			String infosDiverses, String langue, String mcc,
			String modalitesInscription, String modalitesPedagogique,
			String nbCredits, String nfs1, String nfs2, String nfs3,
			String objectifs, String polotiqueStage, String preRequis,
			String preRequisHab, String preRequisOblig, String rome1,
			String rome2, String rome3, String rome4, String rome5,
			String specialite1, String specialite2, String specialite3,
			String troncCommun, String version, String volCM, String volTD,
			String volTP, String web, Collection<Personne> responsables,
			Collection<Specialite> specialites) {
		super();
		this.code = code;
		this.nom = nom;
		this.parcours = parcours;
		this.identificateur = identificateur;
		this.apogee = apogee;
		this.aspectsFormatRecherche = aspectsFormatRecherche;
		this.capacite = capacite;
		this.mention = mention;
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
		this.nbCredits = nbCredits;
		this.nfs1 = nfs1;
		this.nfs2 = nfs2;
		this.nfs3 = nfs3;
		this.objectifs = objectifs;
		this.polotiqueStage = polotiqueStage;
		this.preRequis = preRequis;
		this.preRequisHab = preRequisHab;
		this.preRequisOblig = preRequisOblig;
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
		this.specialites = specialites;
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

	public String getParcours() {
		return parcours;
	}

	public void setParcours(String parcours) {
		this.parcours = parcours;
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

	public String getCapacite() {
		return capacite;
	}

	public void setCapacite(String capacite) {
		this.capacite = capacite;
	}

	public Mention getMention() {
		return mention;
	}

	public void setMention(Mention mention) {
		this.mention = mention;
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

	public String getDureeStage() {
		return dureeStage;
	}

	public void setDureeStage(String dureeStage) {
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

	public String getNbCredits() {
		return nbCredits;
	}

	public void setNbCredits(String nbCredits) {
		this.nbCredits = nbCredits;
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

	public String getPolotiqueStage() {
		return polotiqueStage;
	}

	public void setPolotiqueStage(String polotiqueStage) {
		this.polotiqueStage = polotiqueStage;
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

	public String getTroncCommun() {
		return troncCommun;
	}

	public void setTroncCommun(String troncCommun) {
		this.troncCommun = troncCommun;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getVolCM() {
		return volCM;
	}

	public void setVolCM(String volCM) {
		this.volCM = volCM;
	}

	public String getVolTD() {
		return volTD;
	}

	public void setVolTD(String volTD) {
		this.volTD = volTD;
	}

	public String getVolTP() {
		return volTP;
	}

	public void setVolTP(String volTP) {
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

	public Collection<Specialite> getSpecialites() {
		return specialites;
	}

	public void setSpecialites(Collection<Specialite> specialites) {
		this.specialites = specialites;
	}
    
    
}
