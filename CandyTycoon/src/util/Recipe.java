package util;

import java.util.LinkedList;


public class Recipe{
	private LinkedList<Ingredient> ings = new LinkedList();
	
	public Recipe(){
	}
	
	public void addIngredient(Ingredient ing){
				
		ings.add(ing);
			

	}
	

}