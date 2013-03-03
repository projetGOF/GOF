package gof.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="domaine_composante")
public class DomaineComposante {
	
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	@JoinColumn(name="code_domaine", nullable = false)
	private Domaine domaine;
	@ManyToOne
	@JoinColumn(name="code_composante", nullable = false)
	private Composante composante;
	private String xdn;
	private String xsp;
	
	public DomaineComposante(){
		
	}
	
	public DomaineComposante(Domaine domaine, Composante composante,String xdn, String xsp) {
		super();
		this.domaine = domaine;
		this.composante = composante;
		this.xdn = xdn;
		this.xsp = xsp;
	}	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Composante getComposante() {
		return (Composante)composante;
	}
	public void setComposante(Composante composante) {
		this.composante = composante;
	}
	public Domaine getDomaine() {
		return (Domaine)domaine;
	}
	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}
	public String getXdn() {
		return xdn;
	}
	public void setXdn(String xdn) {
		this.xdn = xdn;
	}
	public String getXsp() {
		return xsp;
	}
	public void setXsp(String xsp) {
		this.xsp = xsp;
	}
}