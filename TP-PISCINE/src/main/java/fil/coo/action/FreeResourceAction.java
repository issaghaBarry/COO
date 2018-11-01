package fil.coo.action;

import fil.coo.action.exception.ActionFinishedException;
import fil.coo.display.Display;
import fil.coo.resource.*;

/**
 * FreeResourceAction typeof action
 * @author Barry Issagha/ Fremeaux Enzo
 * @version 1.0
 */
public class FreeResourceAction<R extends Resource> extends ResourceAction<R> {
	
	/**
	 * build a FreeResourceAction
	 * @param resourcePool the resource manager
	 * @param user the resource user
	 */
	public FreeResourceAction(ResourcePool<R> resourcePool, ResourceUser<R> user) {
		super(resourcePool, user);
	}
	
	@Override
	public boolean stopCondition() {
		return this.user.getResource()==null;
	}

	@Override
	public void realyDoStep() {
		try {
			this.resourcePool.recoverResource(this.user.getResource());
			this.user.resetResource();
		}catch(IllegalArgumentException e) {}

	}
	
	public String toString() {
		return "freeing resource from pool ";
	}
	
	@Override
	public void doStep() throws ActionFinishedException{
		super.doStep();
		String affichage = this.toString()+ this.resourcePool.toString();
		if(this.state==ActionState.FINISHED)
			Display.display(affichage);
	}

}
