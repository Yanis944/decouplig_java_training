package fr.lernejo.logger;

import java.util.function.Predicate;

public class LoggerFactory {

    public static Logger getLogger(String name) {
        return new CompositeLogger(new ContextualLogger(new FileLogger("fileLog"), name), new ContextualLogger(new ConsoleLogger(), name));
    }

}
