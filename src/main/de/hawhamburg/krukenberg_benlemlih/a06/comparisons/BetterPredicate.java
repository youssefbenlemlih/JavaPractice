package main.de.hawhamburg.krukenberg_benlemlih.a06.comparisons;

/**
 * A predicate to compare two objects
 * @author Jonas Krukenberg
 * @author Youssef Benlemlih
 */
@FunctionalInterface
interface BetterPredicate<T> {
    /**
     * Returns
     * false if second is better than first
     * true first is better than second
     */
    boolean isBetter(T first, T second);
}
