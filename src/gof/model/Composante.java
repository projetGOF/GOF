package gof.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

@SuppressWarnings("serial")
@Entity(name="composante")
public class Composante implements Serializable {

	@Id
	@Column(name="code", length=15)
	private String code;
	private String nom;
	private String web;
	private String acronyme;
	
	@Version
	private long version;

	public Composante() {}
	
	public Composante(String code, String nom, String web, String acronyme) {
		super();
		this.code = code;
		this.nom = nom;
		this.web = web;
		this.acronyme = acronyme;
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
	
	public String getWeb() {
		return web;
	}
	
	public void setWeb(String web) {
		this.web = web;
	}
	
	public String getAcronyme() {
		return acronyme;
	}

	public void setAcronyme(String acronyme) {
		this.acronyme = acronyme;
	}
	
	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
}