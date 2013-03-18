package gof.validation;

public class ValidatorLine {
	
	private String description;
	private String example;
	private boolean state;
	
	public ValidatorLine(){}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getExample() {
		return example;
	}
	public void setExample(String example) {
		this.example = example;
	}
	public boolean getState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}	
}