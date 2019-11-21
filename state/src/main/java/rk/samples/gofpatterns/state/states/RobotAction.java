package rk.samples.gofpatterns.state.states;

public interface RobotAction {
    void doWork();
    void charge();
    void shutdown();
}
