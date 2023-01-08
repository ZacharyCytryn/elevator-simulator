/**
 * Zachary Cytryn
 * ID: 114283379
 * Email: zachary.cytryn@stonybrook.edu
 * Homework #3
 * CSE 214 Recitation 30
 */

package elevatorSimulator;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Contains main method to carry out the simulation along with stats from the simulation
 * 
 * @author zacharycytryn
 *
 */
public class Analyzer {

	/**
	 * Main method to carry out simulation, prints stats
	 * 
	 * @param args
	 * Command line arguments
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double probability = -1;
		int numFloors = -1;
		int numElevators = -1;
		int length = -1;
		System.out.println("Welcome to the Elevator simulator!\n");
		System.out.println("Please enter the probability of arrival for Requests: ");
		
		try {
			probability = sc.nextDouble();
		} catch (InputMismatchException e) {
			System.out.println("Please only enter a decimal between 0 and 1 for probability");
			System.exit(0);
		}
		System.out.println("Please enter the number of floors: ");
		try {
			numFloors = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Please only enter integers above 1 for floors");
			System.exit(0);
		}
		System.out.println("Please enter the number of elevators: ");
		try {
			numElevators = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Please only enter integers above 0 for elevators");
			System.exit(0);
		}
		System.out.println("Please enter the length of the simulation (in time units): ");
		try {
			length = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Please only enter integers above 0 for length of simulation");
			System.exit(0);
		}
		
		try {
			Simulator.simulate(probability, numFloors, numElevators, length);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		

	}

}
