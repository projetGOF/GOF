package gof.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity(name="motcle")
public class MotCle implements Serializable {

	@Id
	@Column
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
