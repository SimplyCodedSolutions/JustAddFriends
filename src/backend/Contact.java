package backend;
/**
 * @author Eric Le Fort
 * @version 01
 */

public class Contact{
	private String name, number;
	private Gender gender;
	
	/**
	 * Creates/initializes a new Contact with their phone number.
	 * @param name
	 * @param number
	 * @param gender
	 */
	public Contact(String name, String number, Gender gender){
		this.name = name;
		this.number = number;
		this.gender = gender;
	}//Constructor
	
	/**
	 * Creates/initializes a new Contact with their phone number.
	 * @param name
	 * @param gender
	 */
	public Contact(String name, Gender gender){
		this.name = name;
		this.number = "";
		this.gender = gender;
	}//Constructor
	
	/**
	 * Returns a String representation of this contact.
	 * @return Contact's name.
	 */
	@Override
	public String toString(){ return name; }//toString()
	
	// Getters & Setters //
	public String getNumber(){ return number; }//getNumber()
	public Gender getGender(){ return gender; }//getGender()
	public void setName(String name){ this.name = name; }//setName()
	public void setNumber(String number){ this.number = number; }//setNumber()
	public void setGender(Gender gender){ this.gender = gender; }//setGender()
}//Contact
