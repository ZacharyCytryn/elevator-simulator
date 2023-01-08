package elevatorSimulator;

/**
 * This class represents an elevator that will be have different states, requests, and change floor frequently.
 * 
 * @author Zachary Cytryn
 */
public class Elevator {
	private int currentFloor;
	public enum state{
		IDLE,
		TO_SOURCE,
		TO_DESTINATION
	};
	private state elevatorState;
	private Request request;
	
	/**
	 * Constructor for elevator
	 */
	public Elevator() {
		request = null;
		elevatorState = state.IDLE;
		currentFloor = 1;
	}
	
	/**
	 * Getter method for current floor
	 * 
	 * @return
	 * current floor the elevator is on
	 */
	public int getCurrentFloor() {
		return currentFloor;
	}
	
	/**
	 * Getter method for state of elevator
	 * 
	 * @return
	 * state of elevator (IDLE, TO_SOURCE, TO_DESTINATION)
	 */
	public state getState() {
		return elevatorState;
	}
	
	/**
	 * Getter method for current request of elevator
	 * 
	 * @return
	 * request for elevator
	 */
	public Request getRequest() {
		return request;
	}
	
	/**
	 * Setter method for current floor
	 * 
	 * @param currentFloor
	 * Current floor that the elevator is on
	 */
	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}
	
	/**
	 * Setter method for elevator state
	 * 
	 * @param elevatorState
	 * state of elevator
	 */
	public void setElevatorState(state elevatorState) {
		this.elevatorState = elevatorState;
	}
	
	/**
	 * Setter method for request of elevator
	 * 
	 * @param request
	 * request for elevator
	 */
	public void setRequest(Request request) {
		this.request = request;
	}
	
	
}
