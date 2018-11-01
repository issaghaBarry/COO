package fil.coo.action;


import org.junit.Before;

import fil.coo.action.exception.*;
import fil.coo.resource.*;


public abstract class ResourceActionTest extends TestAction {
	
	protected class MockResource implements Resource{
		public String description() {
			return "MOCK";
		}
	}
	
	protected class MockUser extends ResourceUser<MockResource>{
		
	}
	
	protected class MockResourcePool extends ResourcePool<MockResource>{
		public MockResourcePool(int n) {
			super(n);
		}
		
		public MockResource createResource() {
			return new MockResource();
		}
	}
	
	
	protected MockUser user;
	protected MockResourcePool resourcePool;
	
	
	@Before
	public void initResourceAction() {
		this.user = new MockUser();
		this.resourcePool = new MockResourcePool(2);
	}
	
	@Override
	public Action createAction() {
		MockUser user1 = new MockUser();
		MockResourcePool resourcePool1 = new MockResourcePool(0);
		TakeResourceAction<MockResource> take1 = new TakeResourceAction<MockResource>(resourcePool1, user1);
		return take1;
	}
	
	@Override
	public Action createCompletedAction() {
		MockUser user2 = new MockUser();
		MockResourcePool resourcePool2 = new MockResourcePool(2);
		TakeResourceAction<MockResource> take2 = new TakeResourceAction<MockResource>(resourcePool2, user2);
		try {
			take2.doStep();
		}catch(ActionFinishedException e) {}
		return take2;
	}

}
