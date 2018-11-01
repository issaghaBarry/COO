package fil.coo.pool;

import fil.coo.action.*;
import fil.coo.action.exception.ActionFinishedException;
import fil.coo.display.Display;
import fil.coo.resource.*;

/**
 * Swimmer it's a sequentialScheduler
 * @author Barry Issagha/ Fremeaux Enzo
 * @version 1.0
 */
public class Swimmer extends SequentialScheduler{
	/** the name of swimmer*/
	protected String name;
	
	
	/*the user of cubicle*/
	protected ResourceUser<Cubicle> userc;
	/** the user of basket*/
	protected ResourceUser<Basket> userb;
	
	
	public Swimmer(String name, BasketPool basket, CubiclePool cubicle, int undress, int swim, int dress) {
		super();
		this.name = name;
		this.userb = new ResourceUser<Basket>();
		this.userc = new ResourceUser<Cubicle>();
		this.listofaction.add(new TakeResourceAction<Basket>(basket, this.userb));
		this.listofaction.add(new TakeResourceAction<Cubicle>(cubicle, this.userc));
		this.listofaction.add(new ForeseableAction(undress));
		this.listofaction.add(new FreeResourceAction<Cubicle>(cubicle, this.userc));
		this.listofaction.add(new ForeseableAction(swim));
		this.listofaction.add(new TakeResourceAction<Cubicle>(cubicle, this.userc));
		this.listofaction.add(new ForeseableAction(dress));
		this.listofaction.add(new FreeResourceAction<Cubicle>(cubicle, this.userc));
		this.listofaction.add(new FreeResourceAction<Basket>(basket, this.userb));
	}
	
	public void doStep() throws ActionFinishedException{
		String affichage = this.name+"'s turn"+System.getProperty("line.separator")+ " "+this.name+ " ";
		Display.displayendofline(affichage);
		super.doStep();
	}
	
	
	
}
