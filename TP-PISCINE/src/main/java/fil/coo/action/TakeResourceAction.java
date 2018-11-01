package fil.coo.action;

import java.util.NoSuchElementException;

import fil.coo.action.exception.ActionFinishedException;
import fil.coo.display.Display;
import fil.coo.resource.*;


/**
 * TakeResourceAction typeof action
 * @author Barry Issagha/ Fremeaux Enzo
 * @version 1.0
 */
public class TakeResourceAction<R extends Resource> extends ResourceAction<R> {
	
	/**
	 * build a takeresource
	 * @param resourcePool the resource manager
	 * @param user the resource user
	 */
	public TakeResourceAction(ResourcePool<R> resourcePool, ResourceUser<R> user) {
		super(resourcePool, user);
		this.user.resetResource();
	}

	@Override
	public boolean stopCondition() {
		if(this.user.getResource()==null)
			return false;
		else
			return true;
	}

	@Override
	public void realyDoStep() {
		try {
			R resource = this.resourcePool.provideResource();
			this.user.setResource(resource);
		}catch(NoSuchElementException e) {}
	}
	
	public String toString() {
		return "trying to take resource from ";
	}
	
	@Override
	public void doStep() throws ActionFinishedException{
		super.doStep();
		String affichage = this.toString()+ this.resourcePool.toString();
		if(this.state==ActionState.FINISHED)
			affichage += "... success";
		else
			affichage +="... failled";
		Display.display(affichage);
	}

}
