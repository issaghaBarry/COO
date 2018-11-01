package fil.coo.resource;

import static org.junit.Assert.*;
import org.junit.*;

public class ResourceUserTest {
	protected MockResource resource;
	protected ResourceUser<MockResource> user;
	
	protected class MockResource implements Resource{
		@Override
		public String description() {
			return "MockResource";
		}
	}
	
	@Before
	public void initUser() {
		this.resource = new MockResource();
		this.user = new ResourceUser<MockResource>();
	}

	@Test
	public void testSetResource() {
		assertNull(this.user.getResource());
		this.user.setResource(this.resource);
		assertNotNull(this.user.getResource());
		assertSame(this.resource, this.user.getResource());
	}

	@Test
	public void testResetResource() {
		this.user.setResource(this.resource);
		assertNotNull(this.user.getResource());
		this.user.resetResource();
		assertNull(this.user.getResource());
	}

}
