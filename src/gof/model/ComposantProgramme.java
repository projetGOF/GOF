package gof.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@SuppressWarnings("serial")
@Entity(name="composant_programme")
public class ComposantProgramme extends ElemStruct {
	
	@Column(nullable=false)
	protected boolean mutualisable;
	
	@Enumerated(EnumType.STRING)
	protected TypeComposantProgramme type;
	
	protected int numero;
	
	public ComposantProgramme() {}

	public ComposantProgramme(String code, String nom, int nbCredits,
			boolean publiable, boolean contenuValide, boolean structureValide,
			int nbErreurs, List<ElemStruct> elementsFils, boolean mutualisable,
			TypeComposantProgramme type, int numero) {
		super(code, nom, nbCredits, publiable, contenuValide, structureValide,
				nbErreurs, elementsFils);
		this.mutualisable = mutualisable;
		this.type = type;
		this.numero = numero;
	}

	public boolean isMutualisable() {
		return mutualisable;
	}

	public void setMutualisable(boolean mutualisable) {
		this.mutualisable = mutualisable;
	}

	public TypeComposantProgramme getType() {
		return type;
	}

	public void setType(TypeComposantProgramme type) {
		this.type = type;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	

}