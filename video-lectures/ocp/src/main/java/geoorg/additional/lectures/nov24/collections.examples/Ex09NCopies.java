package geoorg.additional.lectures.nov24.collections.examples;

import java.util.Collections;
import java.util.List;

/**
 * Created by gd on 12/8/2018.
 */
public class Ex09NCopies {
    public static void main(String ... args) {
        List<String> strings = Collections.nCopies(3, new String("hi"));
        System.out.println(strings);

//        strings.add("Hello");
//        strings.set(1, "hello");
        System.out.println(strings);
    }
}
