package Module4_2;

public interface RobotConnection extends AutoCloseable {
    void moveRobotTo(int x, int y, int tries);
    @Override
    void close();
}
