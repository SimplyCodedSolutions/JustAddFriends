package backend;
/**
 * @author Eric Le Fort
 * @version 01
 */

public class Bar{
	private Address address;
	private String name, type, number;
	private int open, close;

	/**
	 * Creates/initializes a new Bar with the type of bar specified.
	 * @param name
	 * @param type
	 * @param number
	 * @param open
	 * @param close
	 * @param address
	 */
	public Bar(String name, String type, String number, int open, int close, Address address){
		this.name = name;
		this.type = type;
		this.number = number;
		this.open = open;
		this.close = close;
		this.address = address;
	}//Constructor
	
	/**
	 * Creates/initializes a new Bar without the type of bar specified.
	 * @param name
	 * @param number
	 * @param open
	 * @param close
	 * @param address
	 */
	public Bar(String name, String number, int open, int close, Address address){
		this.name = name;
		this.type = "Unknown";
		this.open = open;
		this.close = close;
		this.number = number;
		this.address = address;
	}//Constructor
	
	/**
	 * Returns a String representation of this Bar.
	 * @return The name of the bar.
	 */
	@Override
	public String toString(){ return name; }
	
	//Getters & Setters //
	public String getType(){ return type; }//getType()
	public String getHours(){ return open + " - " + close; }//getHours()
	public String getNumber(){ return number; }//getNumber
	public Address getAddress(){ return address; }//getAddress()
	public void setType(String type){ this.type = type; }//setType()
	public void setOpen(int open){ this.open = open; }//setOpen()
	public void setClose(int close){ this.close = close; }//setClose()
}//Bar
