package com.rk.samples.gofpatterns.state.states;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PowerOffState extends AbstractRobotState {

    private static final Logger logger = LogManager.getLogger(PowerOffState.class);

    public void doWork() {
        logger.info("...(power off)");
    }

    public void charge() {
        logger.info("Power on and start charging...");

        setNewStateToContext(new WaitingState());

        this.context.goCharge();
    }

    public void shutdown() {
        logger.info("...(power off)");
    }

    @Override
    public String toString() {
        return "shut down";
    }
}
