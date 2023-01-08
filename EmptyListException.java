/**
 * Zachary Cytryn
 * ID: 114283379
 * Email: zachary.cytryn@stonybrook.edu
 * Homework #3
 * CSE 214 Recitation 30
 */

package elevatorSimulator;

/**
 * This class represents an EmptyListException which is an exception thrown if the queue is empty
 * and an action like removing is trying to be carried out
 * 
 * @author zacharycytryn
 *
 */
public class EmptyListException extends Exception {
	/**
	 * Constructor for EmptyListException
	 * 
	 * @param message
	 * Desired message to return if thrown
	 */
	public EmptyListException(String message) {
		super(message);
	}
}
