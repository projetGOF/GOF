package gof.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity(name="composant_programme")
public class ComposantProgramme extends ElemStruct implements Mutualisable, Serializable {
	
	@Column(nullable=false)
	protected boolean mutualisable;
	protected String type;
	
	public ComposantProgramme()
	{
		super();
	}

	public ComposantProgramme(String code, String nom, int nbCredits,
			boolean publiable, boolean contenuValide, boolean structureValide,
			int nbErreurs, List<ElemStruct> elementsFils, boolean mutualisable,
			String type) {
		super(code, nom, nbCredits, publiable, contenuValide, structureValide,
				nbErreurs, elementsFils);
		this.mutualisable = mutualisable;
		this.type = type;
	}

	@Override
	public boolean getMutualisable() {
		return this.mutualisable;
	}

	@Override
	public void setMutualisable(boolean mutualisable) {
		this.mutualisable = mutualisable;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
