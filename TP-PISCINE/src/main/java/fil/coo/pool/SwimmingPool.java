package fil.coo.pool;
import fil.coo.action.*;
import fil.coo.action.exception.*;
import fil.coo.resource.*;

/**
 * the main of the simulation of swimming pool
 * @author Barry Issagha/ Fremeaux Enzo
 * @version 1.0
 */
public class SwimmingPool {
	/** protected swimmer the key it's the name of swimmer et value it's a list of*/ 
	public static void main(String[] args) throws ActionFinishedException, SchedulerStartedException{
		final BasketPool baskets = new BasketPool(6);
		final CubiclePool cubicles = new CubiclePool(3);
		final FairScheduler s = new FairScheduler();
		s.addAction(new Swimmer("Camille", baskets, cubicles, 6, 4, 8));
		s.addAction(new Swimmer("lois", baskets, cubicles, 2, 10, 4));
		s.addAction(new Swimmer("Mae", baskets, cubicles, 10, 18, 10));
		s.addAction(new Swimmer("Ange", baskets, cubicles, 3, 7, 5));
		s.addAction(new Swimmer("Louison", baskets, cubicles, 18, 3, 3));
        s.addAction(new Swimmer("charlie", baskets, cubicles, 3, 6, 10));
        s.addAction(new Swimmer("Alexie", baskets, cubicles, 6, 5, 7));
        
        int nbSteps = 0;
        while (!s.isFinished()) {
	        nbSteps++;
	        s.doStep();
        }
        System.out.println("Finished in " + nbSteps + " steps");
	}

}
