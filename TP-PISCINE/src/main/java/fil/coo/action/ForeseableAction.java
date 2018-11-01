package fil.coo.action;

import fil.coo.action.exception.ActionFinishedException;
import fil.coo.display.Display;

/**
 * ForseableAction action who have a know time for go to final state
 * @author Barry Issagha/ Fremeaux Enzo
 * @version 1.0
 */
public class ForeseableAction extends Action {
	/** remainig time*/
	protected int remainingTime;
	/** total time*/
	protected int totalTime;
	
	/**
	 * this fonction create an action who execute in advance time
	 * @param time the total time
	 */
	public ForeseableAction(int time) {
		super();
		this.totalTime = time;
		this.remainingTime = 0;
	}
	
	
	@Override
	public boolean stopCondition() {
		return this.remainingTime>=this.totalTime;
	}
	
	/**
	 * return the total action time
	 * @return the total action time
	 */
	public int getTotalTime() {
		return this.totalTime;
	}
	
	/**
	 * return the remaining time
	 * @return the remaining time
	 */
	public int remainingTime() {
		return this.remainingTime;
	}

	@Override
	public void realyDoStep() {
		this.remainingTime++;
	}
	
	@Override
	public void doStep() throws ActionFinishedException{
		super.doStep();
		Display.display(this.remainingTime+"/"+this.totalTime);
	}

}
