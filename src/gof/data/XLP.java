package gof.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlAccessorType(XmlAccessType.FIELD)
public class XLP {

	@XmlElement(name="ref-domaine")
	@XmlPath("ref-domaine/@ref")
	private String refDomaine;
	
	@XmlElement(name="ref-composante")
	@XmlPath("ref-composante/@ref")
	private String refComposante;
	
	@XmlElement(name="XDN")
	private String xdn;
	
	@XmlElement(name="XSP")
	private String xsp;
	
	public String getRefDomaine() {
		return refDomaine;
	}
	public void setRefDomaine(String refDomaine) {
		this.refDomaine = refDomaine;
	}
	public String getRefComposante() {
		return refComposante;
	}
	public void setRefComposante(String refComposante) {
		this.refComposante = refComposante;
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