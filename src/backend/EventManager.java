package backend;
/**
 * @author Eric Le Fort
 * @version 01
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class EventManager{
	private ArrayList<Event> events;
	private Event[] completedEvents;
	private int numComplete;
	
	/**
	 * Initializes the list of events to be those passed in.
	 * @param events
	 */
	public EventManager(Event[] events){
		this.events = new ArrayList<Event>(Arrays.asList(events));
		completedEvents = new Event[this.events.size()];
		numComplete = 0;
	}//Constructor

	/**
	 * Returns a random event from the list of events and removes it from the current list to avoid
	 * repeating events.
	 * @return Random event from the list.
	 */
	public Event startEvent(){
		if(events.size() > 0){
			return events.remove(new Random().nextInt(events.size()));	//range of 0 --> size-1
		}
		return new Event("N/A", "No more events found!");
	}//startEvent()
	
	/**
	 * Adds the specified event to the list of completed events.
	 * @param event
	 */
	public void completedEvent(Event event){
		completedEvents[numComplete++] = event;		//Increments numComplete after adding at proper location.
	}//completedEvent()
	
	// Getters //
	public Event[] getEvents(){ return events.toArray(new Event[0]); }//getEvents()
	public int getNumEvents(){ return events.size(); }//getNumEvents()
	
}//EventManager
