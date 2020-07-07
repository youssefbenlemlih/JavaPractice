package de.hawh.wendholt.ws1819.a1;

import java.util.List;
import java.util.Map;

public class A1 {

    // 5
    public static double geoReiheIt(double a0, double q, int n) {
        if (Math.abs(q) <= 1) {
            throw new IllegalArgumentException("Wrong q!");
        }
        double result = 0.0;
        for (int k = 0; k < n; k++) {
            result += a0 * Math.pow(q, k);
        }
        return result;
    }

    // 5
    public static double geoReiheRek(double a0, double q, int n) {
        if (Math.abs(q) <= 1) {
            throw new IllegalArgumentException("Wrong q!");
        }
        if (n == 0) {
            return a0; // a0 * Math.pow(q, 0) == a0 * 1 == a0
        }
        return geoReiheRek(a0, q, n - 1) + a0 * Math.pow(q, n);
    }


    // 5 n für eps
    public static int n_fuer_eps(double eps, double a0, double q) {
        int n = 0;
        while (true) {
            if (Math.abs(geoReiheIt(a0, q, n) - a0 / (1 - q)) < eps) {
                return n;
            }
            n++;
        }
    }

    // 10 Pkt
    public static double[][] miniTabCalc(double[][] table) {
        double[][] newTable = new double[table.length][];
        int rowNum = 0;
        for (double[] row : table) {
            int rowSum = 0;
            int colNum = 0;
            for (double col : row) {
                newTable[rowNum][colNum++] = col;
                rowSum += col;
            }
            newTable[rowNum][++colNum] = rowSum;
            newTable[rowNum][colNum + 1] = rowSum / (colNum - 1.0);
            rowNum++;
        }
        return newTable;
    }

    // 10 Pkt Umgang mit Maps
    public static Map<Integer, List<Integer>> merge(Map<Integer, List<Integer>> m1, Map<Integer, List<Integer>> m2) {
        m2.forEach((k2, v2) -> m2.merge(k2, v2, (key2, key1) -> key1.equals(key2) ? key1 : null));
        return m2;
    }

}
