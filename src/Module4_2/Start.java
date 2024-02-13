package Module4_2;

public class Start {
    public static void start() {
        RobotConnectionManager robotConnectionManager = new RobotConnectionManagerCl();
        moveRobot(robotConnectionManager, 3, 4);

    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        for (int i = 0; i < 3; i++) {
            try (RobotConnection robotConnection = robotConnectionManager.getConnection(i)) {
                robotConnection.moveRobotTo(toX, toY, i);
                i = 3;
                break;
            } catch (RobotConnectionException connectionException) {
                if (i == 2) {
                    throw connectionException;
                }
            }
        }
    }


}