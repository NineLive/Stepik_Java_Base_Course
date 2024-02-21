package EcologyTask;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.function.Predicate;

public class Ecology2 {
    public static void main(String[] args) {
//        makeEcoCSV(args[0], Integer.parseInt(args[1])); // PRODUCTION
        makeEcoCSV("D:\\data.csv", 300); // DEBUG
    }

    public static void makeEcoCSV(String fromFile, int maxConsumption) {
        ReaderCSV readerCSV = new ReaderCSV(Paths.get(fromFile));
        WriterCSV writerCSV = new WriterCSV(Paths.get("D:\\data2.csv"));
        ArrayList<User> users = readerCSV.read();

        ArrayList<User> ecoUsers = findEcologyUser(users, u -> (u.getWaterCount() <= maxConsumption) &&
                (u.getAllGas() <= maxConsumption) && (u.getAllElectro() <= maxConsumption));

        writerCSV.writeNewCSV(ecoUsers);
    }

    public static ArrayList<User> findEcologyUser(ArrayList<User> users, Predicate<User> filter) {
        ArrayList<User> ecologyUsers = new ArrayList<>();
        for (User user : users) {
            if (filter.test(user)) {
                ecologyUsers.add(user);
            }
        }
        return ecologyUsers;
    }
}
