package gof.model;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity(name="programme")
public class Programme extends Formation {
	
	protected String identificateur;
	protected String aspectsFormatRecherche;
	protected String ensDelocalisees;
	protected String ensDelocaliseesHab;
	protected String infosDiverses;
	protected String modalitesInscription;
	protected String modalitesPedagogique;
	protected String nfs1;
	protected String nfs2;
	protected String nfs3;
	protected String objectifs;
	protected String politiqueStages;
	protected String rome1;
	protected String rome2;
	protected String rome3;
	protected String rome4;
	protected String rome5;
	protected String specialite1;
	protected String specialite2;
	protected String specialite3;
	protected boolean troncCommun;
	protected String web;
	
	@ManyToOne
	@JoinColumn(name="code_mention", insertable=false, updatable=false)
	protected Mention mention;
	
	@ManyToMany(mappedBy="programmes")
	protected Collection<Specialite> specialites;
	
    @ManyToMany
    @JoinTable(name="programme_responsable",
    	joinColumns=@JoinColumn(name="code_programme"),
    	inverseJoinColumns=@JoinColumn(name="code_responsable"))
    protected Collection<Personne> responsables;
    
    @OneToMany(mappedBy="programme",cascade=CascadeType.ALL)
    protected Collection<ElemStruct> elementsRattaches;
    
    public Programme()
    {
    	super();
    }

	public Programme(String code, String nom, int nbCredits, boolean publiable,
			boolean contenuValide, boolean structureValide, int nbErreurs,
			List<ElemStruct> elementsFils, String apogee, int capacite,
			String competences, String competencesHab, Date dateModification,
			int dureeStage, String etatRof, String langue, String mcc,
			String preRequis, String preRequisHab, String preRequisOblig,
			String preRequisObligHab, int volCM, int volTD, int volTP,
			int version, String identificateur, String aspectsFormatRecherche,
			String ensDelocalisees, String ensDelocaliseesHab,
			String infosDiverses, String modalitesInscription,
			String modalitesPedagogique, String nfs1, String nfs2, String nfs3,
			String objectifs, String politiqueStages, String rome1,
			String rome2, String rome3, String rome4, String rome5,
			String specialite1, String specialite2, String specialite3,
			boolean troncCommun, String web,
			Mention mention,
			Collection<Personne> responsables,
			Collection<ElemStruct> elementsRattaches) {
		super(code, nom, nbCredits, publiable, contenuValide, structureValide,
				nbErreurs, elementsFils, apogee, capacite, competences,
				competencesHab, dateModification, dureeStage, etatRof, langue,
				mcc, preRequis, preRequisHab, preRequisOblig,
				preRequisObligHab, volCM, volTD, volTP, version);
		this.identificateur = identificateur;
		this.aspectsFormatRecherche = aspectsFormatRecherche;
		this.ensDelocalisees = ensDelocalisees;
		this.ensDelocaliseesHab = ensDelocaliseesHab;
		this.infosDiverses = infosDiverses;
		this.modalitesInscription = modalitesInscription;
		this.modalitesPedagogique = modalitesPedagogique;
		this.nfs1 = nfs1;
		this.nfs2 = nfs2;
		this.nfs3 = nfs3;
		this.objectifs = objectifs;
		this.politiqueStages = politiqueStages;
		this.rome1 = rome1;
		this.rome2 = rome2;
		this.rome3 = rome3;
		this.rome4 = rome4;
		this.rome5 = rome5;
		this.specialite1 = specialite1;
		this.specialite2 = specialite2;
		this.specialite3 = specialite3;
		this.troncCommun = troncCommun;
		this.web = web;
		this.responsables = responsables;
		this.elementsRattaches = elementsRattaches;
		this.mention = mention;
	}


	public String getIdentificateur() {
		return identificateur;
	}

	public void setIdentificateur(String identificateur) {
		this.identificateur = identificateur;
	}

	public String getAspectsFormatRecherche() {
		return aspectsFormatRecherche;
	}

	public void setAspectsFormatRecherche(String aspectsFormatRecherche) {
		this.aspectsFormatRecherche = aspectsFormatRecherche;
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

	public String getInfosDiverses() {
		return infosDiverses;
	}

	public void setInfosDiverses(String infosDiverses) {
		this.infosDiverses = infosDiverses;
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

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public Mention getMention() {
		return mention;
	}

	public void setMention(Mention mention) {
		this.mention = mention;
	}

	public Collection<Personne> getResponsables() {
		return responsables;
	}

	public void setResponsables(Collection<Personne> responsables) {
		this.responsables = responsables;
	}

	public Collection<ElemStruct> getElementsRattaches() {
		return elementsRattaches;
	}

	public void setElementsRattaches(Collection<ElemStruct> elementsRattaches) {
		this.elementsRattaches = elementsRattaches;
	}

	public Collection<Specialite> getSpecialites() {
		return specialites;
	}

	public void setSpecialites(Collection<Specialite> specialites) {
		this.specialites = specialites;
	}

	

}