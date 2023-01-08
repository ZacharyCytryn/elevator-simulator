/**
 * Zachary Cytryn
 * ID: 114283379
 * Email: zachary.cytryn@stonybrook.edu
 * Homework #3
 * CSE 214 Recitation 30
 */

//BOOLEAN SOURCE CODE TAKEN FROM LECTURE NOTES

package elevatorSimulator;
import java.lang.Math;

/**
 * This class represents BooleanSource, which determines whether an event occurs or not based on probability
 * TAKEN FROM LECTURE
 * 
 * @author zacharycytryn
 */
public class BooleanSource {
	private double probability;
	
	/**
	 * Constructor for boolean source
	 * 
	 * @param probability
	 * probability of request occurring
	 * 
	 * @throws IllegalArgumentException
	 * if probability is less than 0 or greater than 1
	 */
	public BooleanSource(double probability) throws IllegalArgumentException {
		if (probability < 0.0 || probability > 1.0) {
			throw new IllegalArgumentException("Invalid probability: must be in between 0 and 1.");
		}
		else {
			this.probability = probability;
		}
	}
	
	/**
	 * Returns true if random number falls within the probability range, signifying that the event should occur
	 * 
	 * @return
	 * boolean value based on whether the random number falls under the probability
	 */
	public boolean requestArrived() {
		return (Math.random() < probability);
	}

}
