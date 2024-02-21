package EcologyTask;

public class User {
    private int id;
    private String name;
    private int waterCount, gasCount1, gasCount2, electroCount1, electroCount2;


    public User(String[] attributes) {
        this.id = Integer.parseInt(attributes[0]);
        this.name = attributes[1];
        this.waterCount = Integer.parseInt(attributes[2]);
        this.gasCount1 = Integer.parseInt(attributes[3]);
        this.gasCount2 = Integer.parseInt(attributes[4]);
        this.electroCount1 = Integer.parseInt(attributes[5]);
        this.electroCount2 = Integer.parseInt(attributes[6]);
    }

    public int getId() {
        return id;
    }

    public int getWaterCount() {
        return waterCount;
    }

    public int getGasCount1() {
        return gasCount1;
    }

    public int getGasCount2() {
        return gasCount2;
    }

    public int getElectroCount1() {
        return electroCount1;
    }

    public int getElectroCount2() {
        return electroCount2;
    }

    public String getName() {
        return name;
    }

    public int getAllGas() {
        return getGasCount1() + getGasCount2();
    }

    public int getAllElectro() {
        return getElectroCount1() + getElectroCount2();
    }
}
