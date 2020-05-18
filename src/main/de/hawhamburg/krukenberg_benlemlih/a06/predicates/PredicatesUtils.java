package main.de.hawhamburg.krukenberg_benlemlih.a06.predicates;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * A helper class to implement disjunction/conjunction of predicates
 * @author Jonas Krukenberg
 * @author Youssef Benlemlih
 */
public class PredicatesUtils<T> {

    @SafeVarargs
    public final Predicate<T> anyPredicate(Predicate<T>... predicates) {
        return Arrays.stream(predicates).reduce(Predicate::or).orElse((_a) -> false);
    }

    @SafeVarargs
    public final Predicate<T> allPredicates(Predicate<T>... predicates) {
        return Arrays.stream(predicates).reduce(Predicate::and).orElse((_a) -> false);
    }
}
