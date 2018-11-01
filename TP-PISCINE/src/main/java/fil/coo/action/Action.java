package fil.coo.action;

import fil.coo.action.exception.*;

/**
 * Action class who allow to progress an object from initial state to final state
 * @author Barry Issagha/ Fremeaux Enzo
 * @version 1.0
 */
public abstract class Action {

	/** state of action*/
	protected ActionState state;
	
	/**
	 * create the action
	 */
	public Action() {
		this.state = ActionState.READY;
	}
	
	/**
	 * cheick if the action is finished
	 * @return true if the action is finished false otherwise
	 */
	public boolean isFinished() {
		return this.state == ActionState.FINISHED;
	}
	
	/**
	 * return the state of action
	 * @return state of action 
	 */
	public ActionState getState() {
		return this.state;
	}
	
	/**
	 * allow to know when action action can stop
	 * @return true if the condition is respect , false otherwise
	 */
	public abstract boolean stopCondition();
	
	/**
	 * same the dostep 
	 */
	public abstract void realyDoStep();
	
	/**
	 * this function allow the action to move one step
	 * @throws ActionFinishedException
	 */
	public void doStep() throws ActionFinishedException{
		this.realyDoStep();
		if(!this.isFinished()) {
			if(this.stopCondition()) {
				this.state = ActionState.FINISHED;
			}else if(!this.stopCondition() && this.state==ActionState.READY )
				this.state = ActionState.IN_PROGRESS;		
		}else {
			throw new ActionFinishedException();
		}
	}
	
	
	
	
}
