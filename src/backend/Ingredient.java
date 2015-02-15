package backend;
/**
 * @author Eric Le Fort
 * @version 01
 */
import java.awt.Color;

public class Ingredient{
	private Color colour;
	private Amount amount;
	private String name;
	
	/**
	 * Initializes a new ingredient with the given colour code.
	 * @param name
	 * @param red
	 * @param green
	 * @param blue
	 */
	public Ingredient(String name, double quantity, String unit, int red, int green, int blue){
		colour = new Color(red, green, blue);
		amount = new Amount(quantity, unit);
		this.name = name;
	}//Constructor
	
	/**
	 * Initializes ingredient, sets the colour to white.
	 * @param name
	 */
	public Ingredient(String name, double quantity, String unit){
		colour = new Color(255, 255, 255);
		amount = new Amount(quantity, unit);
		this.name = name;
	}//Constructor
	
	/**
	 * Returns the name of this ingredient and its quantity.
	 * @return A String representation of the ingredient.
	 */
	@Override
	public String toString(){ return name + " " + amount; }//toString()
	
	// Getters //
	public Color getColour(){ return colour; }//getColour()
	public Amount getAmount(){ return this.amount; }//getAmount()
}//Ingredient
