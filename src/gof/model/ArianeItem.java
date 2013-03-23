package gof.model;

public class ArianeItem {

	private String url;
	
	private String nom;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public ArianeItem() {
		this.url="";
		this.nom="";
	}
	
	public ArianeItem(String url, String nom) {
		this.url=url;
		this.nom=nom;
	}
	
	
	
}
