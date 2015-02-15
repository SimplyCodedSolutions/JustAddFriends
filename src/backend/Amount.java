package backend;
/**
 * @author Eric Le Fort
 * @version 01
 */

public class Amount{
	private String unit;
	private double quantity;
	
	/**
	 * Creates a new amount with only a quantity, e.g. for discrete quantites.
	 * @param quantity
	 */
	public Amount(double quantity){
		unit = "";
		this.quantity = quantity;
	}//Constructor
	
	/**
	 * Creates a new amount using the specified quantity and unit.
	 * @param quantity
	 * @param unit
	 */
	public Amount(double quantity, String unit){
		this.unit = unit;
		this.quantity = quantity;
	}//Constructor

	/**
	 * A String representation of this Amount.
	 * @return quantity unit
	 */
	public String toString(){ return this.quantity + " " +  this.unit; }//toString()

}//Amount
