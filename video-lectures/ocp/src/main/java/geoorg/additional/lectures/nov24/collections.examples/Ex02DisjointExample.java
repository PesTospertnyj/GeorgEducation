package geoorg.additional.lectures.nov24.collections.examples;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by gd on 12/1/2018.
 */
public class Ex02DisjointExample {
    public static void main(String ... args) {
        //************* disjoint example

        Collection<Integer> integers = new ArrayList<>();
        Collections.addAll(integers, 1, 1, 4);

        Collection<Integer> integers2 = new ArrayList<>();
        Collections.addAll(integers2, 4, 4, 5);
        boolean duplicatesAbsent = Collections.disjoint(integers, integers2);
        System.out.println("duplicatesAbsent = " + duplicatesAbsent);
    }
}
