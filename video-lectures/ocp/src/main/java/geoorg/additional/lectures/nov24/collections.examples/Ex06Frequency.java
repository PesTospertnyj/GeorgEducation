package geoorg.additional.lectures.nov24.collections.examples;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by gd on 12/8/2018.
 */
public class Ex06Frequency {
    public static void main(String ... args) {
        final Collection<Object> numbers = Arrays.asList(1.0, 2.5, 3.3, 1.0);
        int frequency = Collections.frequency(numbers, new Double(1.0));
        System.out.println(frequency);
    }
}
