package backend;
/**
 * @author Eric Le Fort
 * @version 01
 */

public class Event{
	private String name, description;
	private boolean complete;

	public Event(String name, String description){
		this.name = name;
		this.description = description;
		this.complete = false;
	}//Constructor
	
	@Override
	public String toString(){ return name; }//toString()
	
	// Getters //
	public String getDesciption(){ return description; }//getDescription()
	public boolean isComplete(){ return complete; }//isComplete
}//Event
