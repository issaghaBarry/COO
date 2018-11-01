package fil.coo.resource;

/**
 * ResourceUser
 * @author Barry Issagha/ Fremeaux Enzo
 * @version 1.0
 */
public class ResourceUser<R extends Resource> {
	protected R resource;
	
	/**
	 * give the resource what the user use
	 * @return the resource
	 */
	public R getResource() {
		return this.resource;
	}
	
	/**
	 * put the resource to user
	 * @param resource the resource to put
	 */
	public void setResource(R resource) {
		this.resource = resource;
	}
	
	/**
	 * delete the resource take by user
	 */
	public void resetResource() {
		this.resource = null;
	}
}
