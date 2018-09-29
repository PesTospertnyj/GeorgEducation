package geoorg.sep25streams;

import geoorg.Person;

import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */

public class StreamExamples
{
    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("", "", "").
            limit(5).filter((String s) -> {
            System.out.println("predicate was invoked");
            return !s.isEmpty();
        }).filter(s -> s.length() > 2);

        Stream<String> stream2 =
         stringStream.filter(s -> s.length() > 2);

//        try {
            stringStream.count();
//        } catch (Exception e) {
//
//        }
        System.out.println("want to use second stream");
//        stream2.count();

//        stringStream.forEach((String s) -> {
//                    System.out.println("print string");
//            System.out.println(s);
//        });


    }
}
