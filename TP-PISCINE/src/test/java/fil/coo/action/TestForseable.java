package fil.coo.action;

import static org.junit.Assert.*;
import org.junit.*;

import fil.coo.action.exception.ActionFinishedException;

public class TestForseable extends TestAction {
	public static final int DURATION=3;
	public static final int DURATION_C = 1;
	
	public Action createAction() {
		return new ForeseableAction(DURATION);
	}
	
	public Action createCompletedAction() {
		Action a = new ForeseableAction(DURATION_C);
		try {
			a.doStep();
		}catch(ActionFinishedException e) {}
		return a;
	}
	
	@Test
	public void testForseableActionIsFinishedAfterSpecifyTime() throws ActionFinishedException{
		for(int i=0; i<DURATION; i++) {
			assertFalse(this.action.isFinished());
			this.action.doStep();
		}
		assertTrue(this.action.isFinished());
	}
	
	@Test
	public void testRealyDoStep() throws ActionFinishedException{
		ForeseableAction a = new ForeseableAction(DURATION);
		assertEquals(a.remainingTime(), 0);
		a.doStep();
		assertEquals(a.remainingTime(), 1);
	}


}
