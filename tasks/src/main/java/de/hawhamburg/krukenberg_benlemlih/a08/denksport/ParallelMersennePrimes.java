package de.hawhamburg.krukenberg_benlemlih.a08.denksport;

import static java.math.BigInteger.*;

import java.math.BigInteger;
import java.util.stream.Stream;

/**
 * Parallel stream-based program to generate the first 20 Mersenne
 * primes - HANGS!!! (Page 222)
 * 1
 *
 * @author Joshua Bloch
 */
public class ParallelMersennePrimes {
    public static void main(String[] args) {
        primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
                .parallel()
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(14)
                .forEach(System.out::println);
    }

    static Stream<BigInteger> primes() {
        return Stream.iterate(TWO, BigInteger::nextProbablePrime);
    }
}