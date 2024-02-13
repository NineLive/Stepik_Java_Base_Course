package Module4_3;


import java.util.logging.*;

public class Start {

    public static void start() {
        configureLogging();

    }

    private static void configureLogging() {
        Logger LOGGER = Logger.getLogger("org.stepic.java.logging.ClassA");
        Logger LOGGER2 = Logger.getLogger("org.stepic.java.logging.ClassB");
        LOGGER.setLevel(Level.ALL);
        LOGGER2.setLevel(Level.WARNING);
        Logger LOGGER3 = Logger.getLogger("org.stepic.java");
        LOGGER3.setLevel(Level.ALL);
        LOGGER3.setUseParentHandlers(false);
        Handler HANDLER = new ConsoleHandler();
        HANDLER.setLevel(Level.ALL);
        LOGGER3.addHandler(HANDLER);
        Formatter FORMATTER = new XMLFormatter();
        HANDLER.setFormatter(FORMATTER);
    }
}
