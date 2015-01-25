package backend;
/**
 * @author Eric Le Fort
 * @version 01
 */

public class Taxi{
	private String name, number, tollFree, region;

	/**
	 * Creates a new Taxi without a toll free number.
	 * @param name
	 * @param number
	 * @param region
	 */
	public Taxi(String name, String number, String region){
		this.tollFree = "No toll free number.";
		this.name = name;
		this.number = number;
		this.region = region;
	}//Constructor
	
	/**
	 * Creates a new Taxi with a toll free number.
	 * @param name
	 * @param number
	 * @param tollFree
	 * @param region
	 */
	public Taxi(String name, String number, String tollFree, String region){
		this.tollFree = tollFree;
		this.name = name;
		this.number = number;
		this.region = region;
	}//Constructor
	
	/**
	 * Returns a String representation of this taxi service.
	 * @return Name of the company
	 */
	@Override
	public String toString(){ return name; }//toString()
	
	// Getters //
	public String getNumber(){ return number; }//getNumber()
	public String getTollFree(){ return tollFree; }//getTollFree()
	public String getRegion(){ return region; }//getRegion()
}//Taxi
