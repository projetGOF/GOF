package gof.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity(name="formation")
public abstract class Formation extends ElemStruct {

	protected String apogee;
	protected int capacite;
	protected String competences;
	protected String competencesHab;
	
	@Temporal(TemporalType.DATE)
	protected Date dateModification;
	
	protected int dureeStage;
	protected String etatRof;
	protected String langue;
	protected String mcc;
	protected String preRequis;
	protected String preRequisHab;
	protected String preRequisOblig;
	protected String preRequisObligHab;
	protected int volCM;
	protected int volTD;
	protected int volTP;
	protected int version;
	
	public Formation()
	{
		super();
	}
	
	public Formation(String code, String nom, int nbCredits, boolean publiable,
			boolean contenuValide, boolean structureValide, int nbErreurs,
			List<ElemStruct> elementsFils, String apogee, int capacite,
			String competences, String competencesHab, Date dateModification,
			int dureeStage, String etatRof, String langue, String mcc,
			String preRequis, String preRequisHab, String preRequisOblig,
			String preRequisObligHab, int volCM, int volTD, int volTP,
			int version) {
		super(code, nom, nbCredits, publiable, contenuValide, structureValide,
				nbErreurs, elementsFils);
		this.apogee = apogee;
		this.capacite = capacite;
		this.competences = competences;
		this.competencesHab = competencesHab;
		this.dateModification = dateModification;
		this.dureeStage = dureeStage;
		this.etatRof = etatRof;
		this.langue = langue;
		this.mcc = mcc;
		this.preRequis = preRequis;
		this.preRequisHab = preRequisHab;
		this.preRequisOblig = preRequisOblig;
		this.preRequisObligHab = preRequisObligHab;
		this.volCM = volCM;
		this.volTD = volTD;
		this.volTP = volTP;
		this.version = version;
	}

	public String getApogee() {
		return apogee;
	}

	public void setApogee(String apogee) {
		this.apogee = apogee;
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

	public String getCompetencesHab() {
		return competencesHab;
	}

	public void setCompetencesHab(String competencesHab) {
		this.competencesHab = competencesHab;
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

	public String getEtatRof() {
		return etatRof;
	}

	public void setEtatRof(String etatRof) {
		this.etatRof = etatRof;
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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	
}
