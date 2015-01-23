package backend;
/**
 * @author Eric Le Fort
 * @version 01
 */

public class Profile{
	private Address home;
	private String name;
	private Gender gender;
	
	/**
	 * Creates/initializes the user's profile.
	 * @param home
	 * @param name
	 * @param gender
	 */
	public Profile(Address home, String name, Gender gender){
		this.home = home;
		this.name = name;
		this.gender = gender;
	}//Constructor
	
	/**
	 * Returns a String representation of this Profile.
	 * @return The user's name.
	 */
	@Override
	public String toString(){ return name; }//toString()
	
	// Getters & Setters //
	public Address getHome(){ return home; }//getHome()
	public Gender getGender(){ return gender; }//getGender()
	public void setHome(Address home){ this.home = home; }//setHome()
	public void setName(String name){ this.name = name; }//setName()
	public void setGender(Gender gender){ this.gender = gender; }//setGender()
	
}//Profile
