package fil.coo.action.exception;

/**
 * the actionfinished exception when action is finished
 * @author Barry Issagha/ Fremeaux Enzo
 * @version 1.0
 */
public class ActionFinishedException extends Exception {
	
	/**
	 * build an exception
	 */
	public ActionFinishedException() {
		super();
	}
	
	/**
	 * build an exception
	 * @param message the message you want to show
	 */
	public ActionFinishedException(final String message) {
		super(message);
	}
}
