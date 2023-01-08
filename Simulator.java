package elevatorSimulator;
import java.lang.Math;

/**
 * This class represents the simulator that takes all the parameters and creates a simulation
 * 
 * @author Zachary Cytryn
 */
public class Simulator {
	
	/**
	 * Helper method to check the availability of an elevator (to check if it's IDLE)
	 * 
	 * @param elevators
	 * array of current elevators to cycle through and check
	 * @return
	 * place in array where there is an idle elevator (if there are any. If not, it returns -1)
	 */
	public static int checkElevator(Elevator[] elevators) {
		for (int i = 0; i < elevators.length; i++) {
			if (elevators[i].getState().equals(Elevator.state.IDLE)) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Simulates elevator system and prints Total wait time, total requests, and average wait time
	 * 
	 * @param probability
	 * probability of a request being called in
	 * @param numFloors
	 * Number of floors in the building
	 * @param numElevators
	 * Number of elevators working to handle requests
	 * @param length
	 * Length (time) of simulation
	 * @throws IllegalArgumentException
	 * If one of the parameters are invalid
	 */
	public static void simulate(double probability, int numFloors, int numElevators, int length) throws IllegalArgumentException {
		if (probability < 0.0 || probability > 1.0) {
			throw new IllegalArgumentException("Invalid probability");
		}
		else if (numFloors < 2) {
			throw new IllegalArgumentException("Invalid number of floors");
		}
		else if (numElevators < 1) {
			throw new IllegalArgumentException("Invalid number of elevators");
		}
		else if (length < 1) {
			throw new IllegalArgumentException("Invalid time length");
		}
		
		double totalWaitTime = 0;
		double avgWaitTime;
		
		//Calculate total travel time by doing Math.abs((request).getSource() - (request).getDestination)
		
		double requests = 0;
		BooleanSource determiner = null;
		int availElevator;
		int floorCounter;
		RequestQueue<Request> reqQueue = new RequestQueue<Request>();
		Elevator[] elevators = new Elevator[numElevators];
		for (int i = 0; i < numElevators; i++) {
			elevators[i] = new Elevator();
		}
		
		
		try {
			determiner = new BooleanSource(probability);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		
		for (int i = 1; i <= length; i++) {
			//Handling requests
			if (determiner.requestArrived()) {
				reqQueue.enqueue(new Request(numFloors));
				reqQueue.get(reqQueue.size() - 1).setTimeEntered(i);
				requests++;
				//System.out.println("Request received! Current requests: " + requests + ".");
			}
			
			//Checking elevator and queue
			availElevator = checkElevator(elevators);
			if (!reqQueue.isEmpty() && availElevator >= 0) {
				//If elevator is at source floor
				if (elevators[availElevator].getCurrentFloor() == reqQueue.get(0).getSourceFloor()) {
					try {
						elevators[availElevator].setRequest(reqQueue.dequeue());
						totalWaitTime += i - elevators[availElevator].getRequest().getTimeEntered();
						elevators[availElevator].setElevatorState(Elevator.state.TO_DESTINATION);
						//System.out.println("Started at source, so wait time 0! On the way to destination.");
					} catch (EmptyListException e) {
						System.out.println(e.getMessage());
					}
				}
				//If elevator needs to get to source floor
				else {
					try {
						elevators[availElevator].setRequest(reqQueue.dequeue());
						elevators[availElevator].setElevatorState(Elevator.state.TO_SOURCE);
						//System.out.println("On the way to source!");
					} catch (EmptyListException e){
						System.out.println(e.getMessage());
					}
				}
			}
			
			//Moving elevators if loaded with passenger or moving to request source
			for(int j = 0; j < elevators.length; j++) {
				//if the elevator did not reach the request destination yet
				if (elevators[j].getState().equals(Elevator.state.TO_SOURCE)) {
					if (elevators[j].getCurrentFloor() != elevators[j].getRequest().getSourceFloor()) {
						if (elevators[j].getCurrentFloor() < elevators[j].getRequest().getSourceFloor()) {
							elevators[j].setCurrentFloor(elevators[j].getCurrentFloor() + 1);
							
						}
						else if (elevators[j].getCurrentFloor() > elevators[j].getRequest().getSourceFloor()) {
							elevators[j].setCurrentFloor(elevators[j].getCurrentFloor() - 1);
						}
					}
					else {
						totalWaitTime += i - elevators[j].getRequest().getTimeEntered();
						elevators[j].setElevatorState(Elevator.state.TO_DESTINATION);
						//System.out.println("Picked up! Wait time was: " + (i - elevators[j].getRequest().getTimeEntered()));
					}
				}
				if (elevators[j].getState().equals(Elevator.state.TO_DESTINATION)) {
					if (elevators[j].getCurrentFloor() == elevators[j].getRequest().getDestinationFloor()) {
						elevators[j].setElevatorState(Elevator.state.IDLE);
					}
					else if (elevators[j].getRequest().getSourceFloor() < elevators[j].getRequest().getDestinationFloor()) {
						elevators[j].setCurrentFloor(elevators[j].getCurrentFloor() + 1);
					}
					else {
						elevators[j].setCurrentFloor(elevators[j].getCurrentFloor() - 1);
					}
				}
			}
		}
		avgWaitTime = (double) Math.round((totalWaitTime/requests) * 100.0) / 100.0;
		System.out.println("Total Wait Time: " + (int) totalWaitTime +
				"\nTotal Requests: " + (int) requests +
				"\nAverage Wait Time: " + avgWaitTime);
	}
}
