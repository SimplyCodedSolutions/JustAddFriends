package backend;
/**
 * @author Eric Le Fort
 * @version 01
 */

public class Recipe{
	private Ingredient[] ingredients;
	private String[] prep;
	private String name;
	private Glass glass;
	private boolean advanced;
	
	/**
	 * Instantiates the recipe.
	 * @param type
	 * @param adv
	 * @param name
	 * @param glass
	 * @param ingredients
	 * @param garnishes
	 * @param prep
	 */
	public Recipe(String name, Glass glass, boolean adv,Ingredient[] ingredients, String[] prep){
		this.advanced = adv;
		this.name = name;
		this.glass = glass;
		this.ingredients = ingredients;
		this.prep = prep;
	}//Constructor

	/**
	 * Returns a String representation of this drink.
	 * @return The name of this drink.
	 */
	@Override
	public String toString(){ return name; }//toString()
	
	// Getters //
	public Ingredient[] getIngredients(){ return ingredients; }//getIngredients()
	public String[] getPrep(){ return prep; }//getPrep()
	public Glass getGlass(){ return glass; }//getGlass()
	public boolean getAdvanced(){ return advanced; }//getAdvanced()
	
}//Recipe