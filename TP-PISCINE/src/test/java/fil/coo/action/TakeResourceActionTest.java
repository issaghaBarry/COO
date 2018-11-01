package fil.coo.action;

import static org.junit.Assert.*;
import org.junit.*;


public class TakeResourceActionTest extends ResourceActionTest {
	protected TakeResourceAction<MockResource> take;
	
	@Before
	public void initTakeResourceAction() {
		this.take = new TakeResourceAction<MockResource>(this.resourcePool, this.user);
	}
	
	@Test
	public void canTakeWhilePoolHaveNotResource() {
		assertNull(this.user.getResource());
		this.resourcePool.provideResource();
		this.resourcePool.provideResource();
		assertEquals(this.resourcePool.getAvailableResource().size(), 0);
		assertFalse(this.take.stopCondition());
		assertNull(this.user.getResource());
	}
	
	@Test
	public void cantakeOneResourceWhenResourcePoolHaveAResource() {
		assertNull(this.user.getResource());
		this.take.realyDoStep();
		assertNotNull(this.user.getResource());
	}

}
