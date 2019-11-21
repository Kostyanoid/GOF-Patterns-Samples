package rk.samples.gofpatterns.state.states;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WaitingState extends AbstractRobotState {
    private static final Logger logger = LogManager.getLogger(WaitingState.class);

    public void doWork() {
        logger.info("Start working...");

        setNewStateToContext(new WorkingState());

        this.context.goWork();
    }

    public void charge() {
        this.context.increaseChargeByOnePoint();
        logger.info("Charged to {}.", this.context.getCharge());
    }

    public void shutdown() {
        logger.info("Go to shut down.");
        setNewStateToContext(new PowerOffState());
    }

    @Override
    public String toString() {
        return "waiting or charging..";
    }
}
