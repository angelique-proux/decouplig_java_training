package fr.lernejo.logger;

public class LoggerFactory {

    public static Logger getLogger(String name) {
        //return new ContextualLogger(new ConsoleLogger(), name);
        return new ContextualLogger(new FileLogger("fileLog"), name);
    }
}
