package Module4_2;

public class RobotConnectionManagerCl implements RobotConnectionManager{

    @Override
    public RobotConnection getConnection(int i) {

        if (i == 1){
            throw new RobotConnectionException("connect error");
        }
        return new RobotConnectionCl();
    }
}
