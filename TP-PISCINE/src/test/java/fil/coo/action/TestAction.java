package fil.coo.action;

import static org.junit.Assert.*;
import org.junit.*;
import fil.coo.action.exception.*;

public abstract class TestAction {
	
	/**
	 * create an action
	 * @return the action 
	 */
	protected abstract Action createAction();
	
	protected abstract Action createCompletedAction();
		
	
	/** action*/
	protected Action action;
	/** completed action */
	protected Action completAction;
	
	
	@Before
	public void initAction() {
		this.action  = this.createAction();
		this.completAction = this.createCompletedAction();
	}

	@Test
	public void testInitAction() {
		assertNotNull(this.action);
	}
	
	@Test
	public void testIsReadyWhenCreated() {
		assertEquals(this.action.getState(), ActionState.READY);
	}
	
	@Test(expected = ActionFinishedException.class)
	public void dostepThrowsExceptionWhenFinished() throws ActionFinishedException{
		this.completAction.doStep();
	}
	
	@Test
	public void testStateIsInProgressWhenStartedandNotFinished() throws ActionFinishedException{
		assertEquals(this.action.getState(), ActionState.READY);
		this.action.doStep();
		assertEquals(this.action.getState(), ActionState.IN_PROGRESS);
	}

	
	
	
	
	
}
