package fil.coo.action;

import static org.junit.Assert.*;
import org.junit.*;

public class FreeResourceActionTest extends ResourceActionTest {
	protected FreeResourceAction<MockResource> free;
	
	@Before
	public void initFreeResourceAction() {
		this.free = new FreeResourceAction<MockResource>(this.resourcePool, this.user);
	}
	
	
	@Test
	public void canFreeWhileUserHaveNotResource() {
		assertNull(this.user.getResource());
		assertEquals(this.resourcePool.getAvailableResource().size(), 2);
		this.free.realyDoStep();
		assertEquals(this.resourcePool.getAvailableResource().size(), 2);
	}
	
	@Test
	public void canFreeWhileUserHaveAResource() {
		MockResource r = this.resourcePool.provideResource();
		this.user.setResource(r);
		assertEquals(this.resourcePool.getAvailableResource().size(), 1);
		this.free.realyDoStep();
		assertEquals(this.resourcePool.getAvailableResource().size(), 2);
		assertNull(this.user.getResource());
	}
	

}
