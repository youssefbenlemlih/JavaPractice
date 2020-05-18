package main.de.hawhamburg.krukenberg_benlemlih.a06.comparisons;

import java.util.Comparator;

/**
 * A comparator, that compares wich of the two objects is better
 * according to the given comparison method
 * @author Jonas Krukenberg
 * @author Youssef Benlemlih
 */
public class BetterComparator<T> {
    public T getBest(T first, T second, Comparator<T> comparator) {
        return comparator.compare(first,second) < 0 ?
                first : second;
    }

    public T getBest(T first, T second, BetterPredicate<T> betterPredicate) {
        return betterPredicate.isBetter(first, second) ? first : second;
    }
}
