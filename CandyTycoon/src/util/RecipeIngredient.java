package util;

public class RecipeIngredient {
	
	private Ingredient ing;
	private int proportion;
	
	
	public RecipeIngredient(Ingredient ingIn, int proportionIn){
		ing = ingIn;
		proportion = 1;
		
		
		
	}
	
	public void incProportion(){
		proportion ++;
	}
	
	
	
}
