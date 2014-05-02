package util;

public class RecipeIngredient {
	
	private Ingredient ing;
	private int proportion;
	
	
	public RecipeIngredient(Ingredient ingIn){
		ing = ingIn;
		setProportion(1);
		
		
		
	}
	
	public void incProportion(){
		setProportion(getProportion() + 1);
	}

	public int getProportion() {
		return proportion;
	}

	public void setProportion(int proportion) {
		this.proportion = proportion;
	}
	
	public String getName(){
		return this.ing.toString();
	}
	
	
}
