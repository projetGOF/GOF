package gof.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity(name = "mention")
public class Mention implements Serializable {

	@Id
	@Column(name="code", length=15)
	private String code;
	
	@Column(nullable=false)
	private String nom;
	private String nomCourt;
	
	@Enumerated(EnumType.STRING)
	private TypeMention typeMention;
	
    @OneToMany
    @JoinColumn(name="code_mention")
	private Collection<MotCle> motsCles;
    
	private int droits;
	
    @ManyToMany
    @JoinTable(name="mention_responsable",
    	joinColumns=@JoinColumn(name="code_mention"),
    	inverseJoinColumns=@JoinColumn(name="code_responsable"))
	private Collection<Personne> responsables;
    
    @OneToMany
    @JoinColumn(name="code_mention")
	private Collection<Specialite> specialites;
	
    @OneToMany
    @JoinColumn(name="code_mention")
	private Collection<Programme> programmes;
	
    @ManyToMany
    @JoinTable(name="mention_composante",
    	joinColumns=@JoinColumn(name="code_mention"),
    	inverseJoinColumns=@JoinColumn(name="code_composante"))
	private Collection<Composante> composantes;
    
	private String adaptation;
	private String adaptationHab;
	private String adosPro;
	private String adosRecherche;
	private String aideInsPro;
	private String aideInsProHab;
	private String aideOrientation;
	private String aideOrientationHab;
	private String aideReussite;
	private String aideReussiteHab;
	private String articuAutresFormat;
	private String autoEvaluation;
	private String codeDossier;
	private String cohabilitation;
	private String competences;
	private String competencesHab;
	private String conditionsAdmission;
	private String conditionsAdmissionHab;
	private String connaissances;
	private String connaissancesHab;
	private String contenusEnseignement;
	private String contexte;
	private String contexteHab;
	private String dateModification;
	private String debouches;
	private String debouchesHab;
	private String denominationNationale;
	private String equipePedago;
	private String etatRof;
	private String finalite;
	private String identificateur;
	private String indicateurs;
	private String international;
	private String internationalHab;
	private String mcc;
	private String mccHab;
	private String mesuresPrises;
	private String modalitesPedagoHab;
	private String modifications;
	private int nbCredits;
	private String orgPedago;
	private String orgPedagoHab;
	private String partenaires;
	private String partenairesHab;
	private String pilotage;
	private String politiqueStages;
	private String posOffreEtablis;
	private String posOffreRegion;
	private String poursuiteEtudes;
	private String poursuiteEtudesHab;
	private String previsions;
	private String publique;
	private String publicHab;
	
    @ManyToMany
    @JoinTable(name="mention_domaine",
    	joinColumns=@JoinColumn(name="code_mention"),
    	inverseJoinColumns=@JoinColumn(name="code_domaine"))
	private Collection<Domaine> domaines;
    
	private String secteurPro;
	private String typeDiplome;
	private String validiteCompetences;
	private int version;
	private String web;
	@Column(nullable=false)
	private boolean publiable;
	@Column(nullable=false)
	private boolean contenuValide;
	@Column(nullable=false)
	private boolean structureValide;
	@Column(nullable=false)
	private int nbErreurs;
	
	public Mention() {}

	public Mention(String code, String nom, String nomCourt,
			TypeMention typeMention, Collection<MotCle> motsCles, int droits,
			Collection<Personne> responsables,
			Collection<Specialite> specialites,
			Collection<Programme> programmes,
			Collection<Composante> composantes, String adaptation,
			String adaptationHab, String adosPro, String adosRecherche,
			String aideInsPro, String aideInsProHab, String aideOrientation,
			String aideOrientationHab, String aideReussite,
			String aideReussiteHab, String articuAutresFormat,
			String autoEvaluation, String codeDossier, String cohabilitation,
			String competences, String competencesHab,
			String conditionsAdmission, String conditionsAdmissionHab,
			String connaissances, String connaissancesHab,
			String contenusEnseignement, String contexte, String contexteHab,
			String dateModification, String debouches, String debouchesHab,
			String denominationNationale, String equipePedago, String etatRof,
			String finalite, String identificateur, String indicateurs,
			String international, String internationalHab, String mcc,
			String mccHab, String mesuresPrises, String modalitesPedagoHab,
			String modifications, int nbCredits, String orgPedago,
			String orgPedagoHab, String partenaires, String partenairesHab,
			String pilotage, String politiqueStages, String posOffreEtablis,
			String posOffreRegion, String poursuiteEtudes,
			String poursuiteEtudesHab, String previsions, String publique,
			String publicHab, Collection<Domaine> domaines, String secteurPro,
			String typeDiplome, String validiteCompetences, int version,
			String web, boolean publiable, boolean contenuValide,
			boolean structureValide, int nbErreurs) {
		super();
		this.code = code;
		this.nom = nom;
		this.nomCourt = nomCourt;
		this.typeMention = typeMention;
		this.motsCles = motsCles;
		this.droits = droits;
		this.responsables = responsables;
		this.specialites = specialites;
		this.programmes = programmes;
		this.composantes = composantes;
		this.adaptation = adaptation;
		this.adaptationHab = adaptationHab;
		this.adosPro = adosPro;
		this.adosRecherche = adosRecherche;
		this.aideInsPro = aideInsPro;
		this.aideInsProHab = aideInsProHab;
		this.aideOrientation = aideOrientation;
		this.aideOrientationHab = aideOrientationHab;
		this.aideReussite = aideReussite;
		this.aideReussiteHab = aideReussiteHab;
		this.articuAutresFormat = articuAutresFormat;
		this.autoEvaluation = autoEvaluation;
		this.codeDossier = codeDossier;
		this.cohabilitation = cohabilitation;
		this.competences = competences;
		this.competencesHab = competencesHab;
		this.conditionsAdmission = conditionsAdmission;
		this.conditionsAdmissionHab = conditionsAdmissionHab;
		this.connaissances = connaissances;
		this.connaissancesHab = connaissancesHab;
		this.contenusEnseignement = contenusEnseignement;
		this.contexte = contexte;
		this.contexteHab = contexteHab;
		this.dateModification = dateModification;
		this.debouches = debouches;
		this.debouchesHab = debouchesHab;
		this.denominationNationale = denominationNationale;
		this.equipePedago = equipePedago;
		this.etatRof = etatRof;
		this.finalite = finalite;
		this.identificateur = identificateur;
		this.indicateurs = indicateurs;
		this.international = international;
		this.internationalHab = internationalHab;
		this.mcc = mcc;
		this.mccHab = mccHab;
		this.mesuresPrises = mesuresPrises;
		this.modalitesPedagoHab = modalitesPedagoHab;
		this.modifications = modifications;
		this.nbCredits = nbCredits;
		this.orgPedago = orgPedago;
		this.orgPedagoHab = orgPedagoHab;
		this.partenaires = partenaires;
		this.partenairesHab = partenairesHab;
		this.pilotage = pilotage;
		this.politiqueStages = politiqueStages;
		this.posOffreEtablis = posOffreEtablis;
		this.posOffreRegion = posOffreRegion;
		this.poursuiteEtudes = poursuiteEtudes;
		this.poursuiteEtudesHab = poursuiteEtudesHab;
		this.previsions = previsions;
		this.publique = publique;
		this.publicHab = publicHab;
		this.domaines = domaines;
		this.secteurPro = secteurPro;
		this.typeDiplome = typeDiplome;
		this.validiteCompetences = validiteCompetences;
		this.version = version;
		this.web = web;
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

	public TypeMention getTypeMention() {
		return typeMention;
	}

	public void setTypeMention(TypeMention typeMention) {
		this.typeMention = typeMention;
	}

	public Collection<MotCle> getMotsCles() {
		return motsCles;
	}

	public void setMotsCles(Collection<MotCle> motsCles) {
		this.motsCles = motsCles;
	}

	public int getDroits() {
		return droits;
	}

	public void setDroits(int droits) {
		this.droits = droits;
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

	public Collection<Programme> getProgrammes() {
		return programmes;
	}

	public void setProgrammes(Collection<Programme> programmes) {
		this.programmes = programmes;
	}

	public Collection<Composante> getComposantes() {
		return composantes;
	}

	public void setComposantes(Collection<Composante> composantes) {
		this.composantes = composantes;
	}

	public String getAdaptation() {
		return adaptation;
	}

	public void setAdaptation(String adaptation) {
		this.adaptation = adaptation;
	}

	public String getAdaptationHab() {
		return adaptationHab;
	}

	public void setAdaptationHab(String adaptationHab) {
		this.adaptationHab = adaptationHab;
	}

	public String getAdosPro() {
		return adosPro;
	}

	public void setAdosPro(String adosPro) {
		this.adosPro = adosPro;
	}

	public String getAdosRecherche() {
		return adosRecherche;
	}

	public void setAdosRecherche(String adosRecherche) {
		this.adosRecherche = adosRecherche;
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

	public String getArticuAutresFormat() {
		return articuAutresFormat;
	}

	public void setArticuAutresFormat(String articuAutresFormat) {
		this.articuAutresFormat = articuAutresFormat;
	}

	public String getAutoEvaluation() {
		return autoEvaluation;
	}

	public void setAutoEvaluation(String autoEvaluation) {
		this.autoEvaluation = autoEvaluation;
	}

	public String getCodeDossier() {
		return codeDossier;
	}

	public void setCodeDossier(String codeDossier) {
		this.codeDossier = codeDossier;
	}

	public String getCohabilitation() {
		return cohabilitation;
	}

	public void setCohabilitation(String cohabilitation) {
		this.cohabilitation = cohabilitation;
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

	public String getContexte() {
		return contexte;
	}

	public void setContexte(String contexte) {
		this.contexte = contexte;
	}

	public String getContexteHab() {
		return contexteHab;
	}

	public void setContexteHab(String contexteHab) {
		this.contexteHab = contexteHab;
	}

	public String getDateModification() {
		return dateModification;
	}

	public void setDateModification(String dateModification) {
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

	public String getDenominationNationale() {
		return denominationNationale;
	}

	public void setDenominationNationale(String denominationNationale) {
		this.denominationNationale = denominationNationale;
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

	public String getIdentificateur() {
		return identificateur;
	}

	public void setIdentificateur(String identificateur) {
		this.identificateur = identificateur;
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

	public String getModifications() {
		return modifications;
	}

	public void setModifications(String modifications) {
		this.modifications = modifications;
	}

	public int getNbCredits() {
		return nbCredits;
	}

	public void setNbCredits(int nbCredits) {
		this.nbCredits = nbCredits;
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

	public String getPartenaires() {
		return partenaires;
	}

	public void setPartenaires(String partenaires) {
		this.partenaires = partenaires;
	}

	public String getPartenairesHab() {
		return partenairesHab;
	}

	public void setPartenairesHab(String partenairesHab) {
		this.partenairesHab = partenairesHab;
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

	public String getPosOffreEtablis() {
		return posOffreEtablis;
	}

	public void setPosOffreEtablis(String posOffreEtablis) {
		this.posOffreEtablis = posOffreEtablis;
	}

	public String getPosOffreRegion() {
		return posOffreRegion;
	}

	public void setPosOffreRegion(String posOffreRegion) {
		this.posOffreRegion = posOffreRegion;
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

	public String getPublicHab() {
		return publicHab;
	}

	public void setPublicHab(String publicHab) {
		this.publicHab = publicHab;
	}

	public Collection<Domaine> getDomaines() {
		return domaines;
	}

	public void setDomaines(Collection<Domaine> domaines) {
		this.domaines = domaines;
	}

	public String getSecteurPro() {
		return secteurPro;
	}

	public void setSecteurPro(String secteurPro) {
		this.secteurPro = secteurPro;
	}

	public String getTypeDiplome() {
		return typeDiplome;
	}

	public void setTypeDiplome(String typeDiplome) {
		this.typeDiplome = typeDiplome;
	}

	public String getValiditeCompetences() {
		return validiteCompetences;
	}

	public void setValiditeCompetences(String validiteCompetences) {
		this.validiteCompetences = validiteCompetences;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
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