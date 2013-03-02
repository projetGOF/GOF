package gof.model;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@SuppressWarnings("serial")
@Entity(name="uecat")
@XmlRootElement(name="uecat")
@XmlAccessorType(XmlAccessType.FIELD)
public class UECat extends Enseignement {

	@XmlTransient
	protected boolean miseEnService;			//il faut un adapter string to boolean
	
	public UECat() {}
	
	public UECat(String code, String nom, int nbCredits, boolean publiable,
			boolean contenuValide, boolean structureValide, int nbErreurs,
			List<ElemStruct> elementsFils, String apogee, int capacite,
			String competences, String competencesHab, Date dateModification,
			int dureeStage, String etatRof, String langue, String mcc,
			String preRequis, String preRequisHab, String preRequisOblig,
			String preRequisObligHab, int volCM, int volTD, int volTP,
			int version, String bibliographie, String capitalisation,
			String coefficient, String contenu, String contenuHab,
			String discipline, String modalitesOrganisation,
			String typeEns, int volAutres, int volGlobal,
			int volTravail, Collection<Personne> responsables,
			boolean miseEnService) {
		super(code, nom, nbCredits, publiable, contenuValide, structureValide,
				nbErreurs, elementsFils, apogee, capacite, competences,
				competencesHab, dateModification, dureeStage, etatRof, langue,
				mcc, preRequis, preRequisHab, preRequisOblig,
				preRequisObligHab, volCM, volTD, volTP, version, bibliographie,
				capitalisation, coefficient, contenu, contenuHab, discipline,
				modalitesOrganisation, true, typeEns, volAutres,
				volGlobal, volTravail, responsables);
		this.miseEnService = miseEnService;
	}

	@Override
	public boolean getMutualisable() {
		return true;
	}

	@Override
	public void setMutualisable(boolean mutualisable) {} // Une UECat ne peut être mutualisable
}
