package util;

public class RawIngredient extends Ingredient {
	
	private boolean isSweetener;
	private boolean isEmulsifier;
	private boolean isDairy;
	private boolean isCrunchy;
	private boolean isDye;
	private boolean isFlavor;
	
	public RawIngredient(String nameIn, boolean sweetener, boolean emulsifier, boolean dairy, boolean crunchy, boolean dye, boolean flavor){
		super(nameIn);
		
		isSweetener = sweetener;
		isEmulsifier = emulsifier;
		isDairy = dairy;
		isCrunchy = crunchy;
		isDye = dye;
		isFlavor = flavor;
		
	}

}
