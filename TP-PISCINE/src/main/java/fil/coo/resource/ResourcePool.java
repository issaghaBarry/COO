package fil.coo.resource;

import java.util.*;

/**
 * ResourcePool
 * @author Barry Issagha/ Fremeaux Enzo
 * @version 1.0
 */
public abstract class ResourcePool<R extends Resource> {
	/** the resource already use's*/
	protected List<R> busyResource;
	/** the resource not use's*/
	protected List<R> available;
	
	/**
	 * build the resource pool
	 * @param n the number of resource in the pool
	 */
	public ResourcePool(int n) {
		this.available = new ArrayList<R>();
		this.busyResource = new ArrayList<R>();
		for(int i=0; i<n; i++) {
			this.available.add(this.createResource());
		}
	}
	
	/**
	 * give the available resource 
	 * @return the available resource
	 */
	public List<R> getAvailableResource(){
		return this.available;
	}
	
	/**
	 * return the resource it's already uses
	 * @return the resource already uses
	 */
	public List<R> getBusyResource(){
		return this.busyResource;
	}
	
	/**
	 * create a resource
	 * @return the resource
	 */
	protected abstract R createResource();
	
	/**
	 * return the resource of the pool if it's have it
	 * @return the resource
	 * @throws NoSuchElementException when the pool have not a free resource
	 */
	public R provideResource() throws NoSuchElementException{
		if(this.available.size()==0)
			throw new NoSuchElementException("the pool have not a free pool resource");
		R resource = this.available.get(0);
		this.available.remove(resource);
		this.busyResource.add(resource);
		return resource;
	}
	
	public void recoverResource(R resource) throws IllegalArgumentException{
		if(!this.busyResource.contains(resource))
			throw new IllegalArgumentException("this resource have not get by provideResource");
		this.busyResource.remove(resource);
		this.available.add(resource);
	}
	
	
	
}
