package rk.samples.gofpatterns.state.model;

import rk.samples.gofpatterns.state.states.AbstractRobotState;

public abstract class Robot {
    protected AbstractRobotState currentState;
    protected byte charge;

    public AbstractRobotState getState() {
        return currentState;
    }

    public  void setState(AbstractRobotState newState) {
        this.currentState = newState;
    }

    public byte getCharge() {
        return charge;
    }

    public void increaseChargeByOnePoint() {
        setCharge((byte) (charge + 1));
    }
    public void decreaseChargeByOnePoint() {
        setCharge((byte) (charge - 1));
    }

    protected abstract void setCharge(byte charge);
    public abstract void goCharge();
    public abstract void goWork();
    public abstract void switchOff();
    public abstract void switchOn();
}
