package fr.lernejo.logger;

import java.util.function.Predicate;

public class FilteredLogger implements Logger {

    public final Logger delegate;
    public final Predicate<String> condition;

    public FilteredLogger(Logger delegate, Predicate<String> condition) {
        this.delegate = delegate;
        this.condition = condition;
    }

    @Override
    public void log(String message) {
        //Predicate.test(arg) : teste si arg convient à la prédiction
        if(this.condition.test(message)) {
            this.delegate.log(message);
        }
    }
}
