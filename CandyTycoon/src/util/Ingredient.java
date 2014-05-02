package util;

public class Ingredient {
	
	private boolean isSweetener;
	private boolean isEmulsifier;
	private boolean isDairy;
	private boolean isCrunchy;
	private boolean isDye;
	private boolean isFlavor;
	private String name;
	
	public Ingredient(String nameIn, boolean sweetener, boolean emulsifier, boolean dairy, boolean crunchy, boolean dye, boolean flavor){
		isSweetener = sweetener;
		isEmulsifier = emulsifier;
		isDairy = dairy;
		isCrunchy = crunchy;
		isDye = dye;
		isFlavor = flavor;
		setName(nameIn);
			
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
