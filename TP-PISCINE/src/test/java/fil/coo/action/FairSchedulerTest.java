package fil.coo.action;

import static org.junit.Assert.*;
import org.junit.*;

import fil.coo.action.exception.ActionFinishedException;

import java.util.*;

public class FairSchedulerTest extends SchedulerTest {
	
	public Scheduler createScheduler() {
		List<Action> l =new ArrayList<Action>();
		Action a3 = new OneStepMockAction();
		Action a4 = new TwoStepMockAction();
		l.add(a4);
		l.add(a3);
		Scheduler s = new FairScheduler(l);
		return s;
	}
	
	public Scheduler createCScheduler() {
		List<Action> l = new ArrayList<Action>();
		Action a3 = new OneStepMockAction();
		l.add(a3);
		Scheduler s1 = new FairScheduler(l);
		try {
			s1.doStep();
		}catch(ActionFinishedException e) {}
		return s1;
	}
	
	@Test
	public void testNextAction() throws ActionFinishedException{
		assertEquals(this.scheduler.getActions().get(0).getState(), ActionState.READY);
		assertEquals(this.scheduler.getActions().get(1).getState(), ActionState.READY);
		this.scheduler.doStep();
		assertEquals(this.scheduler.listofaction.get(0).getState(), ActionState.IN_PROGRESS);
		assertEquals(this.scheduler.listofaction.get(1).getState(), ActionState.READY);
		this.scheduler.doStep();
		assertEquals(this.scheduler.getActions().size(), 1);
		assertEquals(this.scheduler.finalAction.get(0).getState(), ActionState.FINISHED);
	}

}
