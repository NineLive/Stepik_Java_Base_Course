package Module4_3;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrimerIzVideo {
    public static final Logger LOGGER = Logger.getLogger(Start.class.getName());
    public static void start(String[] args) {
        LOGGER.log(Level.FINE, "Started with arguments {0}", Arrays.toString(args));

        try{
            randomlyFailingAlgorithm();
        }catch (IllegalStateException e){
            LOGGER.log(Level.SEVERE, "Exception", e);
            System.exit(2);
        }

    }

    public static void randomlyFailingAlgorithm() {
        double randomNumber = Math.random();
        LOGGER.log(Level.FINE, "generated rand number {0}", randomNumber);
        if (randomNumber < 0.5){
            throw new IllegalStateException("Invalid phase of the Moon");
        }
    }
}
