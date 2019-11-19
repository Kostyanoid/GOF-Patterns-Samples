package com.rk.samples.gofpatterns.state.model;

import com.rk.samples.gofpatterns.state.states.AbstractRobotState;
import com.rk.samples.gofpatterns.state.states.PowerOffState;
import com.rk.samples.gofpatterns.state.states.WaitingState;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SimpleRobot extends Robot {
    private static final Logger logger = LogManager.getLogger(SimpleRobot.class);
    private static final byte maxCharge = 3;

    public SimpleRobot() {
        this.charge = maxCharge;
    }

    public SimpleRobot(AbstractRobotState initialState) {
        this();
        this.currentState = initialState;
        initialState.setContext(this);
    }

    @Override
    public void setCharge(byte charge) {
        if (charge < 0)
            throw new IllegalArgumentException("Charge cannot be less than zero");
        if (charge > maxCharge)
            charge = maxCharge;
        this.charge = charge;
    }

    @Override
    public void goCharge() {
        logger.trace("Go charge.");
        currentState.charge();
    }

    @Override
    public void goWork() {
        logger.trace("Go work.");
        currentState.doWork();
    }

    @Override
    public String toString() {
        return "SimpleRobot: " +
                "currentState=" + currentState +
                ", charge=" + charge +
                ';';
    }

    @Override
    public void switchOff() {
        logger.trace("switch off");
        currentState.setNewStateToContext(new PowerOffState());
    }

    @Override
    public void switchOn() {
        logger.trace("switch on");
        currentState.setNewStateToContext(new WaitingState());
    }
}
