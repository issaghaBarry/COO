package fil.coo.resource;



import fil.coo.resource.Cubicle;
import fil.coo.resource.CubiclePool;
import fil.coo.resource.ResourcePool;

public class CubiclePoolTest extends ResourcePoolTest<Cubicle> {

	public ResourcePool<Cubicle> createResourcePool(){
		return new CubiclePool(NUMBER);
	}
	
	public Cubicle createResource() {
		return new Cubicle();
	}

}
