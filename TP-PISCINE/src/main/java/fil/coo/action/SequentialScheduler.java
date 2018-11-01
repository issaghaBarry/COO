package fil.coo.action;

import java.util.*;

/**
 * FairScheduler it's a scheduler 
 * @author Barry Issagha/ Fremeaux Enzo
 * @version 1.0
 */
public class SequentialScheduler extends Scheduler {
	
	public SequentialScheduler(List<Action> laction) {
		super(laction);
	}
	
	public SequentialScheduler() {
		super();
	}
	
	@Override
	public Action nextAction() {
		try {
			Action action = this.listofaction.get(0);
			/*while(action.getState()==ActionState.FINISHED){
				this.finalAction.add(action);
				this.listofaction.remove(0);
				action = this.listofaction.get(0);
			}*/
			return action;
		}catch(IndexOutOfBoundsException e) {
			return null;
		}
	}

}
