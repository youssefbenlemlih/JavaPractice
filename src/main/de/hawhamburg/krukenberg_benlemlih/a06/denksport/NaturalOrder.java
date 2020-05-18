package main.de.hawhamburg.krukenberg_benlemlih.a06.denksport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NaturalOrder {
    public static Comparator<Integer>naturalOrder(){return (i, j) -> (i < j) ? -1 : (i == j ? 0 : 1);}

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(1);
        list.add(100);

        Integer[] arr = {5, 3, 1};
        Arrays.sort(arr, Integer::compareTo);

        int[] arr2 = {5, 3, 1};
//        Arrays.sort(arr2, Integer::compareTo);

        list.sort(naturalOrder());
        System.out.println(list);
    }
}
