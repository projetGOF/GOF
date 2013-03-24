package gof.services;

import gof.model.ArianeItem;

import java.util.ArrayList;

public class Ariane {
	
	private ArrayList<ArianeItem> fil;
	
	public Ariane() {
		if(this.fil==null) {
			this.fil = new ArrayList<ArianeItem>();
			this.fil.add(new ArianeItem("accueil.htm","Home"));
		}
	}
	
	public void add(String url, String nom) {
		if(this.fil==null) {
			this.fil = new ArrayList<ArianeItem>();
			this.fil.add(new ArianeItem("accueil.htm","Home"));
		}
		int positionTrue=-1;
		for(int i=0; i<fil.size();++i) {
			if(fil.get(i).getUrl().equals(url)) {
				positionTrue=i;
			}
		}
		if(positionTrue==-1) {
			fil.add(new ArianeItem(url, nom));
		}
		else {
			for(int i=fil.size()-1; i>positionTrue; --i) {
				fil.remove(i);
			}
		}
	}
	
	public ArrayList<ArianeItem> getArianeFil() {
		return this.fil;
	}
}
