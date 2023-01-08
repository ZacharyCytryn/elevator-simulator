package elevatorSimulator;
import java.util.ArrayList;

/**
 * This class represents a queue of requests, extending arraylists for its structure
 * 
 * @author Zachary Cytryn
 *
 * @param <Request>
 * Object that will be stored in the array
 */
public class RequestQueue<Request> extends ArrayList<Request> {
	
	/**
	 * Used to enqueue requests onto queue
	 * 
	 * @param req
	 * request for elevator
	 */
	public void enqueue(Request req) {
		this.add(req);
	}
	
	/**
	 * Used to dequeue requests from queue
	 * 
	 * @return
	 * request that was dequeued
	 * 
	 * @throws EmptyListException
	 * If queue is empty
	 */
	public Request dequeue() throws EmptyListException {
		if (this.isEmpty()) {
			throw new EmptyListException("Error: cannot dequeue from an empty list.");
		}
		else {
			Request removed = this.get(0);
			this.remove(0);
			return removed;
		}
	}
}
