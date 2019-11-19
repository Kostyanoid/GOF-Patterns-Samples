package com.rk.samples.gofpatterns.state.states;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WorkingState extends AbstractRobotState {
    private static final Logger logger = LogManager.getLogger(WorkingState.class);

    public void doWork() {
        if (this.context.getCharge() > 0) {
            this.context.decreaseChargeByOnePoint();
            logger.info("Worked one hour. {} charge left.", this.context.getCharge());
        } else {
            logger.info("Power is off..");
            shutdown();
        }
    }

    public void charge() {
        logger.info("Stop working and start charging...");
        setNewStateToContext(new WaitingState());
        this.context.goCharge();
    }

    public void shutdown() {
        logger.info("Go to shut down.");

        setNewStateToContext(new PowerOffState());
    }

    @Override
    public String toString() {
        return "working...";
    }
}
