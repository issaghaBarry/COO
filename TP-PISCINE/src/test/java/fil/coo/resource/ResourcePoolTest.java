package fil.coo.resource;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.*;

import fil.coo.resource.Resource;
import fil.coo.resource.ResourcePool;

public abstract class ResourcePoolTest<R extends Resource> {
	
	protected static final int NUMBER=3;
	
	protected abstract ResourcePool<R> createResourcePool();
	protected abstract R createResource();
	
	protected ResourcePool<R> pool;
	protected R res;
	
	@Before
	public void initResourcePooll() {
		this.pool = this.createResourcePool();
		this.res = this.createResource();
	}
	
	@Test
	public void numberOfResourceIsCorrectAtCreation() {
		assertEquals(this.pool.getAvailableResource().size(), NUMBER);
	}
	
	@Test
	public void canTakeResource() throws NoSuchElementException{
		this.pool.provideResource();
		assertEquals(this.pool.getAvailableResource().size(), NUMBER-1);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void canTakeResourceFromEmptyPool()throws NoSuchElementException{
		this.pool.provideResource();
		this.pool.provideResource();
		this.pool.provideResource();
		this.pool.provideResource();
	}
	
	@Test
	public void canGiveResource() throws IllegalArgumentException{
		assertEquals(this.pool.getBusyResource().size(), 0);
		R resource  = this.pool.provideResource();
		assertTrue(this.pool.getBusyResource().contains(resource));
		this.pool.recoverResource(resource);
		assertEquals(this.pool.getBusyResource().size(), 0);
		assertTrue(this.pool.getAvailableResource().contains(resource));
		assertFalse(this.pool.getBusyResource().contains(resource));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void canGiveResourceThatNotWasTake() throws IllegalArgumentException{
		assertTrue(this.pool.getAvailableResource().contains(this.pool.getAvailableResource().get(0)));
		this.pool.recoverResource(this.pool.getAvailableResource().get(0));
	}
	
	@Test(expected  = IllegalArgumentException.class)
	public void canGiveResourceThatNotWasInInitial() throws IllegalArgumentException{
		assertFalse(this.pool.getAvailableResource().contains(this.res));
		this.pool.recoverResource(this.res);
	}

}
