package elevatorSimulator;
import java.lang.Math;

/**
 * The Request class contains the methods for "requesting" and elevator to move from one place to another
 * 
 * @author Zachary Cytryn
 *
 */
public class Request {
	private int sourceFloor;
	private int destinationFloor;
	private int timeEntered;
	
	/**
	 * Constructor for Request
	 * 
	 * @param numFloors
	 * The number of floors in the building that the elevators can go to
	 */
	public Request(int numFloors) {
		sourceFloor = (int) (Math.random() * numFloors + 1);
		destinationFloor = (int) (Math.random() * numFloors + 1);
	}
	
	/**
	 * Getter method for source floor
	 * 
	 * @return
	 * source floor
	 */
	public int getSourceFloor() {
		return sourceFloor;
	}
	
	/**
	 * Getter method for destination floor
	 * 
	 * @return
	 * destination floor
	 */
	public int getDestinationFloor() {
		return destinationFloor;
	}
	
	/**
	 * Getter method for time entered
	 * 
	 * @return
	 * time entered
	 */
	public int getTimeEntered() {
		return timeEntered;
	}
	
	/**
	 * Setter method for source floor
	 * 
	 * @param sourceFloor
	 * source floor
	 */
	public void setSourceFloor(int sourceFloor) {
		this.sourceFloor = sourceFloor;
	}
	
	/**
	 * Setter method for destination floor
	 * 
	 * @param destinationFloor
	 * destination floor
	 */
	public void setDestinationFloor(int destinationFloor) {
		this.destinationFloor = destinationFloor;
	}
	
	/**
	 * Setter method for time entered
	 * 
	 * @param timeEntered
	 * time entered
	 */
	public void setTimeEntered(int timeEntered) {
		this.timeEntered = timeEntered;
	}
	
}
