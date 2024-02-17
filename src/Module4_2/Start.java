package Module4_2;

public class Start {
    public static void start() {
        RobotConnectionManager robotConnectionManager = new RobotConnectionManagerCl();
        moveRobot(robotConnectionManager, 3, 4);

    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        final int MAX_QUANTITY_TRY = 3;
        for (int i = 0; i < MAX_QUANTITY_TRY; i++) {
            try (RobotConnection robotConnection = robotConnectionManager.getConnection(i)) { //In the task, the method .getConnection() does not have a parameter "i", it is needed for tests
                robotConnection.moveRobotTo(toX, toY, i); //In the task, the method .moveRobotTo(toX, toY) does not have a parameter "i", it is needed for tests
                i = MAX_QUANTITY_TRY;
            } catch (RobotConnectionException connectionException) {
                if (i == MAX_QUANTITY_TRY - 1) {
                    throw connectionException;
                }
            }
        }
    }


}