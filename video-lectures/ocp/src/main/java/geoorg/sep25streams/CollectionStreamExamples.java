package geoorg.sep25streams;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */

public class CollectionStreamExamples
{
    public static void main(String[] args) {
        long count = Arrays.asList(1, 3 ,6 ,-4).parallelStream().count();
        System.out.println(count);





    }
}
