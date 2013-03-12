package gof.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity(name="erreur_structure")
public class ErreurStruct implements Serializable {

	@Id
	@GeneratedValue
	private int id;
	private String description;
	
	public ErreurStruct() {}
	
	public ErreurStruct(String description)
	{
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
