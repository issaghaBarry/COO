package fil.coo.resource;




public class BasketPoolTest extends ResourcePoolTest<Basket> {

	public ResourcePool<Basket> createResourcePool(){
		return  new BasketPool(NUMBER);
	}
	
	public Basket createResource() {
		return new Basket();
	} 

}
