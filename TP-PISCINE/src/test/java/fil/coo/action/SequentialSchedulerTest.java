package fil.coo.action;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;
import fil.coo.action.exception.*;

public class SequentialSchedulerTest extends SchedulerTest {

	public Scheduler createScheduler() {
		List<Action> l =new ArrayList<Action>();
		Action a3 = new OneStepMockAction();
		Action a4 = new TwoStepMockAction();
		l.add(a4);
		l.add(a3);
		Scheduler s = new SequentialScheduler(l);
		return s;
	}
	
	public Scheduler createCScheduler() {
		List<Action> l = new ArrayList<Action>();
		Action a3 = new OneStepMockAction();
		l.add(a3);
		Scheduler s1 = new SequentialScheduler(l);
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
		assertEquals(this.scheduler.getActions().get(0).getState(), ActionState.IN_PROGRESS);
		assertEquals(this.scheduler.getActions().get(1).getState(), ActionState.READY);
		this.scheduler.doStep();
		assertEquals(this.scheduler.finalAction.get(0).getState(), ActionState.FINISHED);
		assertEquals(this.scheduler.getActions().get(0).getState(), ActionState.READY);
	}

}
