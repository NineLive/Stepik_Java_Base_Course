package Module4_2;

public class RobotConnectionCl implements RobotConnection{

    @Override
    public void moveRobotTo(int x, int y, int tries) {
        if (1 ==1){
            throw new RobotConnectionException("connect error");
        }
        System.out.println("move to x,y");
    }

    @Override
    public void close() {
//        throw new RuntimeException();
        System.out.println("close connect");
    }
}
