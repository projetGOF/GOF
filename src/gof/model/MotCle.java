package gof.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="motcle")
public class MotCle {

	@Id
	@GeneratedValue
	private Long id;
	private String motcle;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getMotcle() {
		return motcle;
	}
	
	public void setMotcle(String motcle) {
		this.motcle = motcle;
	}
}
