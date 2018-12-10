package geoorg.additional.lectures.nov24.collections.examples;

import java.util.*;

/**
 * Created by gd on 12/8/2018.
 */
public class Ex04Enumeration {
    public static void main(String ... args) {
        final Collection<Integer> collection = new HashSet<>();
        collection.add(2);
        collection.add(3);

        final OptionalInt optionalInt = useEnumeration(Collections.enumeration(collection));
        System.out.println(optionalInt);
    }

    private static OptionalInt useEnumeration  (Enumeration<Integer> integerEnumeration) {
        if (!integerEnumeration.hasMoreElements()) {
            OptionalInt.empty();
        }
        int summ = 0;
        while (integerEnumeration.hasMoreElements()) {
            Integer integer = integerEnumeration.nextElement();
            summ += integer;
        }
        return OptionalInt.of(summ);
    }
}
