package backend;
/**
 * @author Eric Le Fort
 * @version 01
 */

public class Address{
	private String streetName, postalCode;
	private int streetNumber;
	
	/**
	 * Creates an address.
	 * @param streetNumber
	 * @param streetName
	 * @param postalCode
	 */
	public Address(int streetNumber, String streetName, String postalCode){
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.postalCode = postalCode;
	}//Constructor
	
	/**
	 * Returns a String representation of this Address.
	 * @return streetNumber streetName (new line) postalCode
	 */
	@Override
	public String toString(){ return streetNumber + " " + streetName + System.getProperty("line.separator") + postalCode; }
	
	// Getters & Setters //
	public String getStreetName(){ return streetName; }//getStreetName()
	public String getPostalCode(){ return postalCode; }//getPostalCode()
	public int getStreetNumber(){ return streetNumber; }//getStreetNumber()
	public void setStreetName(String streetName){ this.streetName = streetName; }//setStreetName()
	public void setPostalCode(String postalCode){ this.postalCode = postalCode; }//setPostalCode()
	public void setStreetNumber(int streetNumber){ this.streetNumber = streetNumber; }//setStreetNumber()
	
}//Address
