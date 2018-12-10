package geoorg.additional.lectures.nov24.collections.examples;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by gd on 12/8/2018.
 */
public class Ex07SublistIndex {
    public static void main(String ... args) {
        final List<Object> source = Arrays.asList(new StringBuilder("Hello"), 3.0, 1 , 2 , 3, 4.0, "hi", 5L);
        final List<Object> target = Arrays.asList( 2 , 3, 4.0, "hi");

        int indexOfSubList = Collections.indexOfSubList(source, target);
        System.out.println(indexOfSubList);

        final List<Object> source2 = Arrays.asList(new StringBuilder("Hello"), 3.0, 1 , 2 , 3, 4.0, "hi", 5L, 1 , 2, 'h');
        final List<Object> target2 = Arrays.asList( 1 , 2);

        int indexOfSubList2 = Collections.lastIndexOfSubList(source2, target2);
        System.out.println(indexOfSubList2);

    }
}
