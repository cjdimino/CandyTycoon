package util;

public class Ingredient {
	

	double currentTemperature;

	
	private String name;
	
	public Ingredient(String nameIn){
		this.name = nameIn;
	}
	public String toString(){
		
		return this.getName();
		
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
