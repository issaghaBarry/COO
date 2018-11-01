package fil.coo.action;

import static org.junit.Assert.*;
import org.junit.*;
import fil.coo.action.exception.*;

public abstract class SchedulerTest extends TestAction {
	
	public Action createAction() {
		return this.createScheduler();
	}
	
	public Action createCompletedAction() {
		return this.createCScheduler();
	}
	
	protected abstract Scheduler createCScheduler();
	protected abstract Scheduler createScheduler();
	
	public class OneStepMockAction extends Action{
		public int time;
		
		public OneStepMockAction() {
			super();
			this.time = 1;
		}
		public boolean stopCondition() {
			if(this.time > 0) {
				return false;
			}else
				return true;
		}
		
		public void realyDoStep() {
			this.time--;
		}
	}
	
	public class TwoStepMockAction extends Action{
		public int time;
		
		public TwoStepMockAction() {
			super();
			this.time=2;
		}
		public boolean stopCondition() {
			if(this.time > 0)
				return false;
			else
				return true;
		}
		
		public void realyDoStep() {
			this.time--;
		}
	}
	
	protected Scheduler scheduler;
	protected Action a1;
	protected Action a2;
	
	@Before
	public void initScheduler() {
		this.a1 = new OneStepMockAction();
		this.a2 = new TwoStepMockAction();
		this.scheduler = this.createScheduler();
	}

	@Test(expected = SchedulerStartedException.class)
	public void schedulerAddActionThrowsExceptionWhenNotStarted() throws ActionFinishedException, SchedulerStartedException{
		this.scheduler.doStep();
		this.scheduler.addAction(this.a1);
	}
	
	@Test(expected = ActionFinishedException.class)
	public void schedulerAddActionThrowsExceptionWhenAddesActionIsFinished() throws ActionFinishedException, SchedulerStartedException {
		this.a1.doStep();
		assertTrue(this.a1.isFinished());
		this.scheduler.addAction(this.a1);
	}
	
	@Test
	public void schedulerHasOneActionAfterAddActionAndIsReady() throws ActionFinishedException, SchedulerStartedException{
		int len = this.scheduler.getActions().size();
		this.scheduler.addAction(this.a1);
		assertEquals(this.scheduler.getActions().size(), len+1);
	}
	
	@Test
	public void schedulerIsFinishedWhenAllSubActionIsFinished() throws ActionFinishedException{
		for(int i=0; i<3; i++) {
			assertFalse(this.scheduler.isFinished());
			this.scheduler.doStep();
		}
		assertEquals(this.scheduler.getActions().size(), 0);
		assertTrue(this.scheduler.isFinished());
	}

}
