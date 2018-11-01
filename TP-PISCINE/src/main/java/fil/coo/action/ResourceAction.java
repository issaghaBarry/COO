package fil.coo.action;

import fil.coo.action.exception.ActionFinishedException;
import fil.coo.resource.*;


public abstract class ResourceAction<R extends Resource> extends Action {
	/**the resource manager*/
	protected ResourcePool<R> resourcePool;
	/** the resource user*/
	protected ResourceUser<R> user;
	
	/**
	 * build a ResourceAction
	 * @param resourcePool the resource manager
	 * @param user the resource user
	 */
	public ResourceAction(ResourcePool<R> resourcePool, ResourceUser<R> user) {
		super();
		this.resourcePool = resourcePool;
		this.user = user;
	}
	
	
	

}
