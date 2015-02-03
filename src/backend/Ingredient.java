package backend;
/**
 * @author Eric Le Fort
 * @version 01
 */
import java.awt.Color;

public class Ingredient{
	private Color colour;
	private String name;
	
	/**
	 * Initializes a new ingredient with the given colour code.
	 * @param name
	 * @param red
	 * @param green
	 * @param blue
	 */
	public Ingredient(String name, int red, int green, int blue){
		this.name = name;
		colour = new Color(red, green, blue);
	}//Constructor
	
	/**
	 * Initializes ingredient without a specified colour.
	 * @param name
	 */
	public Ingredient(String name){
		this.name = name;
	}//Constructor
	
	/**
	 * Returns the name of this ingredient.
	 * @return A String representation of the ingredient.
	 */
	@Override
	public String toString(){ return name; }//toString()
	
	// Getters //
	public Color getColour(){ return colour; }//getColour()
}//Ingredient
