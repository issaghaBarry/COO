package fil.coo.resource;

/**
 * BasketPool it's a ResourcePool
 * @author Barry Issagha/ Fremeaux Enzo
 * @version 1.0
 */
public class BasketPool extends ResourcePool<Basket> {
	
	/**
	 * build a basket pool
	 * @param n the number of resource in pool
	 */
	public BasketPool(int n) {
		super(n);
	}
	
	/**
	 * return a resource typeof basket
	 * @return the cubicle resource
	 */
	public Basket createResource() {
		return new Basket();
	}
	
	/**
	 * give a representation of basketpool
	 * @return the representation
	 */
	public String toString() {
		return "pool basket";
	}
}
