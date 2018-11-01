package fil.coo.resource;

/**
 * CubiclePool it's a ResourcePool
 * @author Barry Issagha/ Fremeaux Enzo
 * @version 1.0
 */
public class CubiclePool extends ResourcePool<Cubicle> {
	
	/**
	 * build a CubuclePool 
	 * @param n the number of resource
	 */
	public CubiclePool(int n) {
		super(n);
	}
	
	/**
	 * return the cubicle resource
	 * @return the a cubicle resource
	 */
	public Cubicle createResource() {
		return new Cubicle();
	}
	
	/**
	 * give a representation of basketpool
	 * @return the representation
	 */
	public String toString() {
		return "pool cubicle";
	}
}
