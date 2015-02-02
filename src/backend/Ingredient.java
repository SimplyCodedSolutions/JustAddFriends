package backend;
/**
 * @author Eric Le Fort
 * @version 01
 */
import java.awt.Color;

public class Ingredient{
	private Color colour;
	private String name;
	
	public Ingredient(String name, int red, int green, int blue){
		this.name = name;
		colour = new Color(red, green, blue);
	}//Constructor
	
	@Override
	public String toString(){ return name; }//toString()
	
	// Getters //
	public Color getColour(){ return colour; }//getColour()
}//Ingredient
