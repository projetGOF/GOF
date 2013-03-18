package gof.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity(name="composant_programme")
public class ComposantProgramme extends ElemStruct {
	
	@Column(nullable=false)
	protected boolean mutualisable;
	
	@Enumerated(EnumType.STRING)
	protected TypeComposantProgramme type;
	
	protected int numero;
	
	@ManyToOne
    @JoinColumn(name="code_programme_rattache", insertable=false, updatable=false)
    private Programme programme;
	
	public ComposantProgramme() { super(); }

	public ComposantProgramme(String code, String nom, int nbCredits,
			boolean publiable, boolean contenuValide, boolean structureValide,
			int nbErreurs, List<ElemStruct> elementsFils,
			Set<ErreurStruct> erreursStruct, boolean mutualisable,
			TypeComposantProgramme type, int numero) {
		super(code, nom, nbCredits, publiable, contenuValide, structureValide,
				nbErreurs, elementsFils, erreursStruct);
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

	public Programme getProgramme() {
		return programme;
	}

	public void setProgramme(Programme programme) {
		this.programme = programme;
	}

	
}