package src.main.de.hawhamburg.krukenberg_benlemlih.a05.denksport;

import java.util.*;

public class SuspiciousSort {
    public static void main(String[] args) {
        Random rnd = new Random();
        Integer[] arr = new Integer[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt();
        }
        Comparator<Integer> cmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                Integer result  =i2 - i1;
                System.out.println("i1="+i1+" i2="+i2+" res="+result+
                        " correct="+(Integer.compare(i2,i1)==Math.signum(result)));
                return result;
            }
        };
        Arrays.sort(arr, cmp); // 9999, 9997, 9991, ...
        System.out.println(order(arr));
    }

    enum Order {ASCENDING, DESCENDING, CONSTANT, UNORDERED}

    static Order order(Integer[] a) {
        boolean ascending = false;
        boolean descending = false;
        for (int i = 1; i < a.length; i++) {
            ascending |= a[i] > a[i - 1];
            descending |= a[i] < a[i - 1];
        }
        if (ascending && !descending)
            return Order.ASCENDING;
        if (descending && !ascending)
            return Order.DESCENDING;
        if (!ascending)
            return Order.CONSTANT; // All elements equal
        return Order.UNORDERED; // Array is not sorted
        }
    }