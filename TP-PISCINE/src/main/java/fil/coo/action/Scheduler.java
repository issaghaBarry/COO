package fil.coo.action;
import java.util.*;

import fil.coo.action.exception.*;


/**
 * Scheduler action who contain other action's
 * @author Barry Issagha/ Fremeaux Enzo
 * @version 1.0
 */
public abstract class Scheduler extends Action {
	/** list of action */
	protected List<Action> listofaction ;
	
	/** completed action list*/
	protected List<Action> finalAction;
	
	/** index of the next action to take*/
	protected int index;
	
	/** number of action in sxheduler*/
	protected int len;
	
	/**
	 * build the sheduler contain action's
	 * @param laction the actions in sheduler
	 */
	public Scheduler(List<Action> laction) {
		this();
		this.listofaction.addAll(laction);	
	}
	
	/**
	 *  build the sheduler contain action's
	 */
	public Scheduler() {
		super();
		this.listofaction = new ArrayList<Action>();
		this.finalAction = new ArrayList<Action>();
		this.index=0;
		this.len = this.listofaction.size();
	}
	
	/**
	 * give the action's in scheduler
	 * @return the action's in scheduler
	 */
	public List<Action> getActions(){
		return this.listofaction;
	}
	
	@Override
	public boolean stopCondition() {
		return this.listofaction.size()==0;
	}
	
	/**
	 * give the next action who execute
	 * @return the next action
	 */
	protected abstract Action nextAction();
	
	@Override
	public void realyDoStep() {
		Action a = this.nextAction();
		if(a!=null) {
			try {
				a.doStep();
				if(a.isFinished()) {
					this.finalAction.add(a);
					this.listofaction.remove(a);
				}else
					this.index++;
			}catch(ActionFinishedException e) {}
		}
	}
	
	/**
	 * add action in scheduler when scheduler state in initial and action who add are not finished
	 * @param action the action to add in scheduler
	 * @throws ActionFinishedException exception when action who want to add are finished
	 * @throws SchedulerStartedException exception when scheduler in not in initial
	 */
	public void addAction(Action action) throws ActionFinishedException, SchedulerStartedException{
		if(!action.isFinished() && this.state==ActionState.READY) {
			this.listofaction.add(action);
			this.len++;
		}else if(action.isFinished())
			throw new ActionFinishedException("can not add an already finished action ");
		else if(!(this.state==ActionState.READY))
			throw new SchedulerStartedException("can not add when scheduler in progress or finished");
	}
	
	/**
	 * remove an action in the scheduler
	 * @param action the action to delete in scheduler
	 */
	public void removeAction(Action action) {
		boolean a = this.listofaction.remove(action);
		boolean b = this.finalAction.remove(action);
		if(a==true || b==true)
			this.len--;
	}
	
	
}
