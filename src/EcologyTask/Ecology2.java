package EcologyTask;


import java.util.Arrays;

public class Ecology2 {
    public static void main(String[] args) {
        makeEcoCSV( "D:\\data.csv",  701);
    }

    public static void makeEcoCSV(String path, int maxConsumption){
        DataFromCSV dataFromCSV = new DataFromCSV(path, maxConsumption);
        ReaderCSV.read(dataFromCSV);
        WriterCSV.writeEcologicalUser(dataFromCSV,"dota2");
    }
}
