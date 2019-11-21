package rk.samples.gofpatterns.state;

import rk.samples.gofpatterns.state.model.Robot;
import rk.samples.gofpatterns.state.model.SimpleRobot;
import rk.samples.gofpatterns.state.states.AbstractRobotState;
import rk.samples.gofpatterns.state.states.PowerOffState;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StateSample {
    private static final Logger logger = LogManager.getLogger(StateSample.class);

    public static void main(String[] args) {

        AbstractRobotState initialState = new PowerOffState();
        Robot robot = new SimpleRobot(initialState);
        logger.debug(robot);

        robot.switchOn();
        robot.goWork();
        robot.goWork();
        robot.goWork();
        robot.goWork();
        robot.goCharge();
        robot.goCharge();
        robot.goWork();
        robot.goCharge();
        robot.switchOff();
        robot.goWork();
        robot.switchOn();
        robot.goWork();
    }
}
