package geoorg.additional.lectures.nov24.collections.examples;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by gd on 12/8/2018.
 */
public class Ex05Fill {
    public static void main(String ... args) {
        final List<Number> numbers = Arrays.asList(1.0, 2.5, 3.3);
        Collections.fill(numbers, new Integer(4));
        System.out.println(numbers);
    }
}
