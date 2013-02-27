package gof.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="motcle")
public class MotCle {

	@Id
	private String motcle;
	
	public MotCle() {	}
	
	public MotCle(String motcle) {
		this.motcle=motcle;
	}
	
	public String getMotcle() {
		return motcle;
	}
	
	public void setMotcle(String motcle) {
		this.motcle = motcle;
	}
}
