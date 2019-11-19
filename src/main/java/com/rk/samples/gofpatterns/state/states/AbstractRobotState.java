package com.rk.samples.gofpatterns.state.states;

import com.rk.samples.gofpatterns.state.model.Robot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AbstractRobotState implements RobotAction {
    private static final Logger logger = LogManager.getLogger(AbstractRobotState.class);

    protected Robot context;

    public void setContext(Robot context) {
        this.context = context;
    }

    public void setNewStateToContext(AbstractRobotState newState) {
        logger.debug("Change state to {}", newState);
        this.context.setState(newState);
        newState.context = this.context;
    }

}
