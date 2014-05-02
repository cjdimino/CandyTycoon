package util;

import java.util.LinkedList;


public class Recipe{
	private LinkedList<RecipeIngredient> ings;
	
	public Recipe(){
		ings = new LinkedList();
	}
	
	public void addIngredient(Ingredient ing){
		RecipeIngredient recIng = new RecipeIngredient(ing);
		int index = this.checkMatches(recIng);
		if( index == -1){
			ings.add(recIng);
		}
		else
			ings.get(index).incProportion();
			
		
	}
	
	private int checkMatches(RecipeIngredient recIng){
		int index = -1;
		
		for(int i = 0;i<ings.size();i++){
			
			if(this.ings.get(1).getName().equals(recIng.getName())){
				
				index = i;
				
			}
		}
		return index;
	}
	

}