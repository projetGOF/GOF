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

@Entity(name="specialite")
public class Specialite {

	@Id
	@Column(name="code", length=15)
	private String code;
	
	private String nom;
	private String nomCourt;
	private String identificateur;
	
    @ManyToMany
    @JoinTable(name="specialite_responsable",
    	joinColumns=@JoinColumn(name="code_specialite"),
    	inverseJoinColumns=@JoinColumn(name="code_responsable"))
	private Collection<Personne> responsables;
    
    @ManyToMany
    @JoinTable(name="specialite_programme",
    	joinColumns=@JoinColumn(name="code_specialite"),
    	inverseJoinColumns=@JoinColumn(name="code_programme"))
	private Collection<Programme> programmes;	
    
	private String aideInsPro;
	private String aideInsProHab;
	private String aideOrientation;
	private String aideOrientationHab;
	private String aideReussite;
	private String aideReussiteHab;
	private String aspectsFormatContinue;
	private String aspectsFormatPro;
	private String aspectsFormatRecherche;
	
	@ManyToOne
	@JoinColumn(name="code_mention", insertable = false, updatable = false)
	private Mention mention;
	
	private String competencesHab;
	private String conditionsAdmission;
	private String conditionsAdmissionHab;
	private String connaissances;
	private String connaissancesHab;
	private String contenusEnseignement;
	
	@Temporal(TemporalType.DATE)
	private Date dateModification;
	
	private String debouches;
	private String debouchesHab;
	private String equipePedago;
	private String etatRof;
	private String finalite;
	private String indicateurs;
	private String international;
	private String internationalHab;
	private String liensAutresCertif;
	private String mcc;
	private String mccHab;
	private String mesuresPrises;
	private String modalitesPedagoHab;
	private String mutualisation;
	private String orgPedago;
	private String orgPedagoHab;
	private String pilotage;
	private String politiqueStages;
	private String poursuiteEtudes;
	private String poursuiteEtudesHab;
	private String previsions;
	private String publique;
	private String publiqueHab; 
	private String validiteCompetences;
	private String version;
	
	private boolean publiable;
	private boolean contenuValide;
	private boolean structureValide;
	private int nbErreurs;
	
	public Specialite() {}
	
	public Specialite(String code, String nom, String nomCourt,
			String identificateur, Collection<Personne> responsables,
			Collection<Programme> programmes, String aideInsPro,
			String aideInsProHab, String aideOrientation,
			String aideOrientationHab, String aideReussite,
			String aideReussiteHab, String aspectsFormatContinue,
			String aspectsFormatPro, String aspectsFormatRecherche,
			Mention mention, String competencesHab, String conditionsAdmission,
			String conditionsAdmissionHab, String connaissances,
			String connaissancesHab, String contenusEnseignement,
			Date dateModification, String debouches, String debouchesHab,
			String equipePedago, String etatRof, String finalite,
			String indicateurs, String international, String internationalHab,
			String liensAutresCertif, String mcc, String mccHab,
			String mesuresPrises, String modalitesPedagoHab,
			String mutualisation, String orgPedago, String orgPedagoHab,
			String pilotage, String politiqueStages, String poursuiteEtudes,
			String poursuiteEtudesHab, String previsions, String publique,
			String publiqueHab, String validiteCompetences, String version,
			boolean publiable, boolean contenuValide, boolean structureValide,
			int nbErreurs) {
		super();
		this.code = code;
		this.nom = nom;
		this.nomCourt = nomCourt;
		this.identificateur = identificateur;
		this.responsables = responsables;
		this.programmes = programmes;
		this.aideInsPro = aideInsPro;
		this.aideInsProHab = aideInsProHab;
		this.aideOrientation = aideOrientation;
		this.aideOrientationHab = aideOrientationHab;
		this.aideReussite = aideReussite;
		this.aideReussiteHab = aideReussiteHab;
		this.aspectsFormatContinue = aspectsFormatContinue;
		this.aspectsFormatPro = aspectsFormatPro;
		this.aspectsFormatRecherche = aspectsFormatRecherche;
		this.mention = mention;
		this.competencesHab = competencesHab;
		this.conditionsAdmission = conditionsAdmission;
		this.conditionsAdmissionHab = conditionsAdmissionHab;
		this.connaissances = connaissances;
		this.connaissancesHab = connaissancesHab;
		this.contenusEnseignement = contenusEnseignement;
		this.dateModification = dateModification;
		this.debouches = debouches;
		this.debouchesHab = debouchesHab;
		this.equipePedago = equipePedago;
		this.etatRof = etatRof;
		this.finalite = finalite;
		this.indicateurs = indicateurs;
		this.international = international;
		this.internationalHab = internationalHab;
		this.liensAutresCertif = liensAutresCertif;
		this.mcc = mcc;
		this.mccHab = mccHab;
		this.mesuresPrises = mesuresPrises;
		this.modalitesPedagoHab = modalitesPedagoHab;
		this.mutualisation = mutualisation;
		this.orgPedago = orgPedago;
		this.orgPedagoHab = orgPedagoHab;
		this.pilotage = pilotage;
		this.politiqueStages = politiqueStages;
		this.poursuiteEtudes = poursuiteEtudes;
		this.poursuiteEtudesHab = poursuiteEtudesHab;
		this.previsions = previsions;
		this.publique = publique;
		this.publiqueHab = publiqueHab;
		this.validiteCompetences = validiteCompetences;
		this.version = version;
		this.publiable = publiable;
		this.contenuValide = contenuValide;
		this.structureValide = structureValide;
		this.nbErreurs = nbErreurs;
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
	public String getNomCourt() {
		return nomCourt;
	}
	public void setNomCourt(String nomCourt) {
		this.nomCourt = nomCourt;
	}
	public String getIdentificateur() {
		return identificateur;
	}
	public void setIdentificateur(String identificateur) {
		this.identificateur = identificateur;
	}
	public Collection<Personne> getResponsables() {
		return responsables;
	}
	public void setResponsables(Collection<Personne> responsables) {
		this.responsables = responsables;
	}
	public Collection<Programme> getProgrammes() {
		return programmes;
	}
	public void setProgrammes(Collection<Programme> programmes) {
		this.programmes = programmes;
	}
	public String getAideInsPro() {
		return aideInsPro;
	}
	public void setAideInsPro(String aideInsPro) {
		this.aideInsPro = aideInsPro;
	}
	public String getAideInsProHab() {
		return aideInsProHab;
	}
	public void setAideInsProHab(String aideInsProHab) {
		this.aideInsProHab = aideInsProHab;
	}
	public String getAideOrientation() {
		return aideOrientation;
	}
	public void setAideOrientation(String aideOrientation) {
		this.aideOrientation = aideOrientation;
	}
	public String getAideOrientationHab() {
		return aideOrientationHab;
	}
	public void setAideOrientationHab(String aideOrientationHab) {
		this.aideOrientationHab = aideOrientationHab;
	}
	public String getAideReussite() {
		return aideReussite;
	}
	public void setAideReussite(String aideReussite) {
		this.aideReussite = aideReussite;
	}
	public String getAideReussiteHab() {
		return aideReussiteHab;
	}
	public void setAideReussiteHab(String aideReussiteHab) {
		this.aideReussiteHab = aideReussiteHab;
	}
	public String getAspectsFormatContinue() {
		return aspectsFormatContinue;
	}
	public void setAspectsFormatContinue(String aspectsFormatContinue) {
		this.aspectsFormatContinue = aspectsFormatContinue;
	}
	public String getAspectsFormatPro() {
		return aspectsFormatPro;
	}
	public void setAspectsFormatPro(String aspectsFormatPro) {
		this.aspectsFormatPro = aspectsFormatPro;
	}
	public String getAspectsFormatRecherche() {
		return aspectsFormatRecherche;
	}
	public void setAspectsFormatRecherche(String aspectsFormatRecherche) {
		this.aspectsFormatRecherche = aspectsFormatRecherche;
	}
	public Mention getMention() {
		return mention;
	}
	public void setMention(Mention mention) {
		this.mention = mention;
	}
	public String getCompetencesHab() {
		return competencesHab;
	}
	public void setCompetencesHab(String competencesHab) {
		this.competencesHab = competencesHab;
	}
	public String getConditionsAdmission() {
		return conditionsAdmission;
	}
	public void setConditionsAdmission(String conditionsAdmission) {
		this.conditionsAdmission = conditionsAdmission;
	}
	public String getConditionsAdmissionHab() {
		return conditionsAdmissionHab;
	}
	public void setConditionsAdmissionHab(String conditionsAdmissionHab) {
		this.conditionsAdmissionHab = conditionsAdmissionHab;
	}
	public String getConnaissances() {
		return connaissances;
	}
	public void setConnaissances(String connaissances) {
		this.connaissances = connaissances;
	}
	public String getConnaissancesHab() {
		return connaissancesHab;
	}
	public void setConnaissancesHab(String connaissancesHab) {
		this.connaissancesHab = connaissancesHab;
	}
	public String getContenusEnseignement() {
		return contenusEnseignement;
	}
	public void setContenusEnseignement(String contenusEnseignement) {
		this.contenusEnseignement = contenusEnseignement;
	}
	public Date getDateModification() {
		return dateModification;
	}
	public void setDateModification(Date dateModification) {
		this.dateModification = dateModification;
	}
	public String getDebouches() {
		return debouches;
	}
	public void setDebouches(String debouches) {
		this.debouches = debouches;
	}
	public String getDebouchesHab() {
		return debouchesHab;
	}
	public void setDebouchesHab(String debouchesHab) {
		this.debouchesHab = debouchesHab;
	}
	public String getEquipePedago() {
		return equipePedago;
	}
	public void setEquipePedago(String equipePedago) {
		this.equipePedago = equipePedago;
	}
	public String getEtatRof() {
		return etatRof;
	}
	public void setEtatRof(String etatRof) {
		this.etatRof = etatRof;
	}
	public String getFinalite() {
		return finalite;
	}
	public void setFinalite(String finalite) {
		this.finalite = finalite;
	}
	public String getIndicateurs() {
		return indicateurs;
	}
	public void setIndicateurs(String indicateurs) {
		this.indicateurs = indicateurs;
	}
	public String getInternational() {
		return international;
	}
	public void setInternational(String international) {
		this.international = international;
	}
	public String getInternationalHab() {
		return internationalHab;
	}
	public void setInternationalHab(String internationalHab) {
		this.internationalHab = internationalHab;
	}
	public String getLiensAutresCertif() {
		return liensAutresCertif;
	}
	public void setLiensAutresCertif(String liensAutresCertif) {
		this.liensAutresCertif = liensAutresCertif;
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
	public String getMesuresPrises() {
		return mesuresPrises;
	}
	public void setMesuresPrises(String mesuresPrises) {
		this.mesuresPrises = mesuresPrises;
	}
	public String getModalitesPedagoHab() {
		return modalitesPedagoHab;
	}
	public void setModalitesPedagoHab(String modalitesPedagoHab) {
		this.modalitesPedagoHab = modalitesPedagoHab;
	}
	public String getMutualisation() {
		return mutualisation;
	}
	public void setMutualisation(String mutualisation) {
		this.mutualisation = mutualisation;
	}
	public String getOrgPedago() {
		return orgPedago;
	}
	public void setOrgPedago(String orgPedago) {
		this.orgPedago = orgPedago;
	}
	public String getOrgPedagoHab() {
		return orgPedagoHab;
	}
	public void setOrgPedagoHab(String orgPedagoHab) {
		this.orgPedagoHab = orgPedagoHab;
	}
	public String getPilotage() {
		return pilotage;
	}
	public void setPilotage(String pilotage) {
		this.pilotage = pilotage;
	}
	public String getPolitiqueStages() {
		return politiqueStages;
	}
	public void setPolitiqueStages(String politiqueStages) {
		this.politiqueStages = politiqueStages;
	}
	public String getPoursuiteEtudes() {
		return poursuiteEtudes;
	}
	public void setPoursuiteEtudes(String poursuiteEtudes) {
		this.poursuiteEtudes = poursuiteEtudes;
	}
	public String getPoursuiteEtudesHab() {
		return poursuiteEtudesHab;
	}
	public void setPoursuiteEtudesHab(String poursuiteEtudesHab) {
		this.poursuiteEtudesHab = poursuiteEtudesHab;
	}
	public String getPrevisions() {
		return previsions;
	}
	public void setPrevisions(String previsions) {
		this.previsions = previsions;
	}
	public String getPublique() {
		return publique;
	}
	public void setPublique(String publique) {
		this.publique = publique;
	}
	public String getPubliqueHab() {
		return publiqueHab;
	}
	public void setPubliqueHab(String publiqueHab) {
		this.publiqueHab = publiqueHab;
	}
	public String getValiditeCompetences() {
		return validiteCompetences;
	}
	public void setValiditeCompetences(String validiteCompetences) {
		this.validiteCompetences = validiteCompetences;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
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

}
