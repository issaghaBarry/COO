package fil.coo.action;
import java.util.*;

/**
 * FairScheduler it's a other type Scheduler
 * @author Barry Issagha/ Fremeaux Enzo
 * @version 1.0
 */
public class FairScheduler extends Scheduler {
	
	public FairScheduler(List<Action> laction) {
		super(laction);
	}
	
	public FairScheduler() {
		super();
	}
	
	@Override
	protected Action nextAction() {
		try {
			if(this.listofaction.size()!=0) {
				Action action = this.listofaction.get(index%this.listofaction.size());
				return action;
			}
			return null;
		}catch(IndexOutOfBoundsException e) {
			return null;
		}
	
	}

}
